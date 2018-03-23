package vues;

import controleur.Controleur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import modele.classesMetiers.Questionnaire;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;


public class Menu {
    private Controleur monControleur;

    @FXML
    Button btnSelectQCM;

    @FXML
    Button btnSelectCorrection;

    public static Menu creerEtAfficher(Controleur c, Stage laStageUnique) {
        URL location = Menu.class.getResource("/vues/menu.fxml");
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


    public void quitterApplication(ActionEvent actionEvent) {
        monControleur.quitter();
    }

    public void gotoChoixQCM(ActionEvent event) {
        monControleur.goToChoixQCM();
    }

    public void gotoChoixCorrection(ActionEvent event) {

    }
}
