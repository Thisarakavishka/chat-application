package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class ClientController implements Initializable {

    @FXML
    private JFXTextField txtField;

    @FXML
    private JFXTextArea txtArea;

    @FXML
    private JFXButton sendBtn;

    Socket socket;
    DataInputStream dataInputStream;
    DataOutputStream dataOutputStream;
    String msg = "";

    @FXML
    void sendBtnOnAction(ActionEvent event) {
        try {
        txtArea.appendText("[CLIENT] - "+txtField.getText()+"\n");
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
                socket = new Socket("Localhost",3002);
                txtArea.appendText("[CLIENT] - Client connected to server\n");

                dataOutputStream = new DataOutputStream(socket.getOutputStream());
                dataInputStream = new DataInputStream(socket.getInputStream());

                while (!msg.equalsIgnoreCase("finish")){
                    msg = dataInputStream.readUTF();
                    txtArea.appendText("[SERVER] - "+msg+"\n");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
