package mft.Controller;

import javafx.scene.control.*;
import mft.Model.bl.ProfileBl;
import mft.Model.entity.Category;
import mft.Model.entity.Profile;
import mft.View.dto.FormState;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
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

                Profile profile = new Profile();
                profile = ProfileBl.getProfile(usernameTxt.getText(), passwordTxt.getText());
                FormState.profile = profile;
                System.out.println(profile.toString());


                Alert alert = new Alert(Alert.AlertType.INFORMATION,"user found" + profile.toString() );
                alert.showAndWait();

                Stage stage = new Stage();
                Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/mft/View/Profile.fxml")));
                stage.setTitle("Panel");
                stage.setScene(scene);
                stage.show();

                loginBtn.getScene().getWindow().hide();

            } catch (Exception e) {
                e.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.ERROR,e.getMessage());
                alert.showAndWait();
            }
        });
    }


}
