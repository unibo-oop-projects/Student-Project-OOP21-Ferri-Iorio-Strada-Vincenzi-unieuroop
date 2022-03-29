package unieuroop.view.login;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import unieuroop.controller.login.ControllerLoginImpl;
import unieuroop.controller.serialization.Pages;

public class ViewLogin implements Initializable {
    private final ControllerLoginImpl controller;
    private final Stage primaryStage;
    @FXML 
    private TextField email;
    @FXML
    private PasswordField password;
    public ViewLogin(final ControllerLoginImpl controller, final Stage primaryStage) {
        this.controller = controller;
        this.primaryStage = primaryStage;
    }
    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
    }
    @FXML
    private void btnLoginHandler(final ActionEvent event) throws IOException {
        if (this.controller.checkPassword(this.email.getText(), this.password.getText())) {
          final Parent root = FXMLLoader.load(getClass().getResource("/pages/MainMenu.fxml"));
          final Scene scene = new Scene(root, 1000, 600);
          primaryStage.setTitle("unieurOOP");
          primaryStage.setScene(scene);
          primaryStage.setMinHeight(500);
          primaryStage.setMinWidth(1000);
          primaryStage.show();
        } else {
            final Alert alert = new Alert(AlertType.INFORMATION);
            alert.setContentText("Wrong Password");
            alert.showAndWait();
        }
    }

}