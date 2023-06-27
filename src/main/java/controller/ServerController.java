package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class ServerController implements Initializable {

    @FXML
    private JFXTextField txtField;

    @FXML
    private JFXTextArea txtArea;

    @FXML
    private JFXButton sendBtn;

    ServerSocket serverSocket;
    Socket socket;
    DataInputStream dataInputStream;
    DataOutputStream dataOutputStream;
    String msg = "";

    @FXML
    void sendBtnOnAction(ActionEvent event) {
        try {
            txtArea.appendText("[SERVER] - " + txtField.getText() + "\n");
            dataOutputStream.writeUTF(txtField.getText());
            txtField.setText("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void txtFieldOnAction(ActionEvent event) {
        sendBtnOnAction(event);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        new Thread(() -> {
            try {
                serverSocket = new ServerSocket(3002);
                txtArea.appendText("[SERVER] - server is started\n");

                socket = serverSocket.accept();
                txtArea.appendText("[SERVER] - new client is accepted\n");

                dataInputStream = new DataInputStream(socket.getInputStream());
                dataOutputStream = new DataOutputStream(socket.getOutputStream());

                while (!msg.equalsIgnoreCase("finish")) {
                    msg = dataInputStream.readUTF();
                    txtArea.appendText("[CLIENT] - " + msg + "\n");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
