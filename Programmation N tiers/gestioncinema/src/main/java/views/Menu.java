package views;

import controleur.Controleur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Menu {

    private Controleur monControleur;

    @FXML
    Button btnReserver;

    @FXML
    Button btnQuitter;

    public static Menu creerEtAfficher(Controleur c, Stage laStageUnique) {
        URL location = Menu.class.getResource("/views/menu.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(location);
        Parent root = null;
        try {
            root = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Menu vue = fxmlLoader.getController();
        laStageUnique.setTitle("Menu");
        laStageUnique.setScene(new Scene(root, 800, 600));
        laStageUnique.show();
        vue.setMonControleur(c);
        return vue;
    }


    public void setMonControleur(Controleur monControleur) {
        this.monControleur = monControleur;
    }

    public Button getBtnQuitter() {
        return btnQuitter;
    }

    public void clickReserver(ActionEvent actionEvent) {
        try{
            monControleur.goToSelectionFilm();
        } catch (Exception e) {
            afficheMessageErreur(e.getMessage());
        }

    }

    public void quitterApplication(ActionEvent actionEvent) {
        monControleur.quitter();
    }

    public void afficheMessageErreur(String message) {
        Alert a = new Alert(Alert.AlertType.ERROR,message, ButtonType.OK);
        a.show();
    }

}
