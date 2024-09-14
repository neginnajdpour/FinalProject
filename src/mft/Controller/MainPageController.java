package mft.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lombok.SneakyThrows;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class MainPageController implements Initializable {

    @FXML
    private Menu resourcesMenu;

    
    @FXML
    private MenuItem addResourceMenu , resourceListMenu;


    @SneakyThrows
    @FXML
    private void handleManageResourcesAction(ActionEvent event) {
        Stage stage = new Stage();
        Scene scene = new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/mft/View/Resource.fxml"))));
        stage.setTitle("Panel");
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    private void handleAddMemberAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Scene scene = new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/mft/View/Member.fxml"))));
        stage.setTitle("Panel");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void handleAllMembersAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Scene scene = new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/mft/View/MemberList.fxml"))));
        stage.setTitle("Panel");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        MenuItem viewJobs = new MenuItem("Jobs");
        Menu help = new Menu("Help");
        MenuItem helpItem = new MenuItem("Help");
        helpItem.setActionCommand("hello");

    }
}
