package mft.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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

    @FXML
    private void handleAddResourceAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Scene scene = new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/mft/View/Book.fxml"))));
        stage.setTitle("Panel");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void handleAllResourcesAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Scene scene = new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/mft/View/BookSearch.fxml"))));
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
