package views.jfx;

import controleur.Controleur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import views.ResultatInterface;

import java.io.IOException;
import java.net.URL;

/**
 * Created by YohanBoichut on 10/11/15.
 */
public class Resultat implements ResultatInterface {


    private Controleur monControleur;

    public void setMonControleur(Controleur monControleur) {
        this.monControleur = monControleur;
    }

    @FXML
    private Button monBouton;

    private Stage primaryStage;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @FXML
    private TextField monChamp;

    public static Resultat creerInstance(Controleur c, Stage primaryStage) {
        URL location = Resultat.class.getResource("/views/jfx/resultat.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(location);
        Parent root = null;
        try {
            root = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Resultat vue = fxmlLoader.getController();
        vue.setPrimaryStage(primaryStage);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
        vue.setMonControleur(c);
        return vue;
    }


    public void cliquer(ActionEvent actionEvent) {
        this.setMonChamp("Yeah!!");
    }

    public void setMonChamp(String affichage) {
        this.monChamp.setText(affichage);
    }

    @Override
    public void show() {

    }

    @Override
    public void showMessageErreur(String messageErreur) {

    }
}
