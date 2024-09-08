package mft.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class MainPageController implements Initializable {

    @FXML
    private Menu resourcesMenu;

    
    @FXML
    private MenuItem addResourceMenu , resourceListMenu;

    @FXML
    private void handleAddResourceAction(ActionEvent event) {
        System.out.println("addResourceAction");
    }

    @FXML
    private void handleMiClose(ActionEvent event) {
        System.out.println("handleMiClose");
    }

    @FXML
    private void handleMiDelete(ActionEvent event) {
        System.out.println("handleMiDelete");
    }

    @FXML
    private void handleMIAbout(ActionEvent event) {
        System.out.println("handleMIAbout");
    }




    @Override
    public void initialize(URL location, ResourceBundle resources) {

        MenuItem viewJobs = new MenuItem("Jobs");

        Menu help = new Menu("Help");
        MenuItem helpItem = new MenuItem("Help");
        helpItem.setActionCommand("hello");



    }
}
