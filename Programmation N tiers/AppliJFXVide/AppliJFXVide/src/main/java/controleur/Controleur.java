package controleur;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modele.GestionDemineur;
import modele.exceptions.BombeException;
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

    private ConnexionInterface connexionVue;
    private JeuInterface jeuVue;
    private ResultatInterface resultatVue;
    private FabriqueVues fabriqueVues;

    private GestionDemineur gestionDemineur;

    private String login;

    public Controleur(FabriqueVues fabriqueVues) {

        this.fabriqueVues = fabriqueVues;
        this.connexionVue = this.fabriqueVues.buildConnexionView(this);
        this.gestionDemineur = new GestionDemineur();
        connexionVue.show();

    }

    public void connexion(String login) {
        URL location = Connexion.class.getResource("/views/jfx/jeu.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(location);
        Parent root = null;

        try {
            gestionDemineur.connexion(login);
            root = (Parent) fxmlLoader.load();
            jeuVue = this.fabriqueVues.buildJeuView(this);
            jeuVue.show();
        }
        catch (ExceptionLoginDejaPris e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }




    // Getters & Setters

    public GestionDemineur getGestionDemineur() {
        return gestionDemineur;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
