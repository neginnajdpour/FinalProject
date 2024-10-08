package mft.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class MainPageController implements Initializable {


    @FXML
    private MenuItem newMemberMenu, searchMemberMenu , newResourceMenu, searchResourceMenu,issueBookMenu;

    @FXML
    private void handleMemberRegistrationAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Scene scene = new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/mft/view/Member.fxml"))));
        stage.setTitle("Panel");
        stage.setScene(scene);
        stage.show();
    }




    @Override
    public void initialize(URL location, ResourceBundle resources) {

        newMemberMenu.setOnAction(event -> {

            try {
                Stage stage = new Stage();
                Scene scene = null;
                scene = new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/mft/view/Member.fxml"))));
                stage.setTitle("Panel");
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        searchMemberMenu.setOnAction(event -> {

            try {
                Stage stage = new Stage();
                Scene scene = null;
                scene = new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/mft/view/MemberDirectory.fxml"))));
                stage.setTitle("Panel");
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        newResourceMenu.setOnAction(event -> {

            try {
                Stage stage = new Stage();
                Scene scene = null;
                scene = new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/mft/view/Resource.fxml"))));
                stage.setTitle("Panel");
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        searchResourceMenu.setOnAction(event -> {

            try {
                Stage stage = new Stage();
                Scene scene = null;
                scene = new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/mft/view/SearchBook.fxml"))));
                stage.setTitle("Panel");
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        issueBookMenu.setOnAction(event -> {

            try {
                Stage stage = new Stage();
                Scene scene = null;
                scene = new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/mft/view/Borrow.fxml"))));
                stage.setTitle("Panel");
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });


    }
}
