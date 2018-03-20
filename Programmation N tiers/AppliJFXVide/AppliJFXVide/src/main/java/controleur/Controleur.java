package controleur;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modele.GestionDemineur;
import modele.exceptions.ExceptionLoginDejaPris;
import views.ConnexionInterface;
import views.FabriqueVues;
import views.JeuInterface;
import views.ResultatInterface;
import views.jfx.Connexion;
import views.jfx.FabriqueVuesJFX;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;

/**
 * Created by YohanBoichut on 10/11/15.
 */
public class Controleur {

    private ConnexionInterface maConnexionVue;
    private JeuInterface maJeuVue;
    private ResultatInterface maResultatVue;
    private FabriqueVues fabriqueVues;

    private GestionDemineur gestionDemineur;

    private Button connexionButton;

    public Controleur(FabriqueVues fabriqueVues) {

        this.fabriqueVues = fabriqueVues;
        this.maConnexionVue = this.fabriqueVues.buildConnexionView(this);
        this.gestionDemineur = new GestionDemineur();
        maConnexionVue.show();

    }

    public void connexion(String login) {
        URL location = Connexion.class.getResource("/views/jfx/jeu.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(location);
        Parent root = null;

        try {
            gestionDemineur.connexion(login);
            root = (Parent) fxmlLoader.load();
            maJeuVue = this.fabriqueVues.buildJeuView(this);
            maJeuVue.show();
        }
        catch (ExceptionLoginDejaPris e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }


    public GestionDemineur getGestionDemineur() {
        return gestionDemineur;
    }


}
