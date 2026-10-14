package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginPageController{

    @FXML
    private Button btnClear;

    @FXML
    private Button btnLogin;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUsername;

    @FXML
    void btnClearOnAction(ActionEvent event) {
        txtUsername.clear();
        txtPassword.clear();
        txtUsername.requestFocus();
    }

    @FXML
    void btnLoginOnAction(ActionEvent event) {

        String username = txtUsername.getText().trim();
        String password = txtPassword.getText();

        if (username.isEmpty() || password.isEmpty()) {
            showAlert(
                    Alert.AlertType.WARNING,
                    "Missing Information",
                    "Please enter both username and password."
            );
            return;
        }

        if (username.equalsIgnoreCase("admin")
                && password.equals("admin123")) {

            showAlert(
                    Alert.AlertType.INFORMATION,
                    "Login Successful",
                    "Welcome!"
            );

        } else {
            showAlert(
                    Alert.AlertType.ERROR,
                    "Login Failed",
                    "Invalid username or password."
            );
        }
    }

private void showAlert(
        Alert.AlertType type,
        String title,
        String message
) {
    Alert alert = new Alert(type);
    alert.setTitle(title);
    alert.setHeaderText(null);

    alert.setContentText(message);
    alert.showAndWait();

    }

}
