package mft.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lombok.SneakyThrows;
import javafx.scene.control.*;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class MainPageController implements Initializable {

    @FXML
    private Button resourceBtn, memberBtn;




    @Override
    public void initialize(URL location, ResourceBundle resources) {

        resourceBtn.setOnAction(event -> {

            try {
                Stage stage = new Stage();
                Scene scene = new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/mft/View/Resource.fxml"))));
                stage.setTitle("Panel");
                stage.setScene(scene);
                stage.show();
            }
            catch (IOException e) {
                e.printStackTrace();
            }

        });

        memberBtn.setOnAction(event -> {

            try {
                Stage stage = new Stage();
                Scene scene = new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/mft/View/Member.fxml"))));
                stage.setTitle("Panel");
                stage.setScene(scene);
                stage.show();
            }
            catch (IOException e) {
                e.printStackTrace();
            }

        });





    }
}
