package views.jfx;

import controleur.Controleur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modele.exceptions.ExceptionLoginDejaPris;
import views.ConnexionInterface;

import java.io.IOException;
import java.net.URL;

/**
 * Created by YohanBoichut on 10/11/15.
 */
public class Connexion implements ConnexionInterface {


    private Controleur monControleur;

    public void setMonControleur(Controleur monControleur) {
        this.monControleur = monControleur;
    }

    @FXML
    private Button monBouton;

    @FXML
    private TextField monChamp;

    @FXML
    VBox topNiveau;

    private Stage primaryStage;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public static Connexion creerInstance(Controleur c, Stage primaryStage) {
        URL location = Connexion.class.getResource("/views/jfx/login.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(location);
        Parent root = null;
        try {
            root = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Connexion vue = fxmlLoader.getController();
        vue.setPrimaryStage(primaryStage);
        vue.setMonControleur(c);
        return vue;
    }


    public void cliquer(ActionEvent actionEvent) {

        URL location = Connexion.class.getResource("/views/jfx/jeu.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(location);
        Parent root = null;

        try {
            monControleur.getGestionDemineur().connexion(getmonChamp());
            root = (Parent) fxmlLoader.load();
            primaryStage.setScene(new Scene(root, 300, 300));
        }
        catch (ExceptionLoginDejaPris e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        //setmonChamp("Yeah!");
    }

    public void setmonChamp(String affichage) {
        this.monChamp.setText(affichage);
    }

    public String getmonChamp() { return monChamp.getText(); }

    @Override
    public void show() {
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(topNiveau, 300, 275));
        primaryStage.show();
    }

    @Override
    public void showMessageErreur(String messageErreur) {

    }
}
