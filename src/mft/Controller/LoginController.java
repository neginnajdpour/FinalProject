package mft.Controller;

import javafx.scene.control.*;
import mft.Model.bl.ProfileBl;
import mft.Model.entity.Profile;
import mft.View.dto.FormState;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private TextField usernameTxt;

    @FXML
    private PasswordField passwordTxt;

    @FXML
    private Button loginBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        loginBtn.setOnAction(event -> {

            try{
                Profile profile =  ProfileBl.getProfile(usernameTxt.getText(), passwordTxt.getText());
                FormState.profile = profile;
                if (profile != null) {

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information");
                    alert.setHeaderText(null);
                    alert.setContentText("You have successfully logged in!");
                    alert.showAndWait();

                    Stage stage = new Stage();
                    Scene scene = new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/mft/View/Book.fxml"))));
                    stage.setTitle("Panel");
                    stage.setScene(scene);
                    stage.show();

                    loginBtn.getScene().getWindow().hide();

                }



            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR,e.getMessage());
                alert.showAndWait();
            }
        });
    }


}
