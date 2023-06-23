package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class ServerController implements Initializable {

    @FXML
    private JFXTextField txtField;

    @FXML
    private JFXTextArea txtArea;

    @FXML
    private JFXButton sendBtn;

    @FXML
    void sendBtnOnAction(ActionEvent event) {

    }

    @FXML
    void txtFieldOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
