package views.jfx;

import controleur.Controleur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modele.Case;
import views.ConnexionInterface;
import views.JeuInterface;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by YohanBoichut on 10/11/15.
 */
public class Jeu implements JeuInterface {


    private Controleur monControleur;

    public void setMonControleur(Controleur monControleur) {
        this.monControleur = monControleur;
    }



    @FXML
    private GridPane gridpane;

    @FXML
    private ArrayList<Button> mesButtons;

    private Stage primaryStage;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }


    @FXML
    VBox topNiveau;

    public static Jeu creerInstance(Controleur c, Stage primaryStage) {
        URL location = Jeu.class.getResource("/views/jfx/jeu.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(location);
        Parent root = null;
        try {
            root = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Jeu vue = fxmlLoader.getController();
        vue.setPrimaryStage(primaryStage);
        vue.setMonControleur(c);
        return vue;
    }

    public void creerPlateau(String login) {
        Case[][] monPlateau = getPlateau(login);
        mesButtons = new ArrayList<Button>();
       for(int y = 0; y < monPlateau.length; y++) {
           for(int x = 0; x < monPlateau[y].length; x++){
                gridpane.add(new Button(" "), y, x);
           }
       }

    }

    public Case[][] getPlateau(String login) {
        return monControleur.getGestionDemineur().getPlateau(login).getMonPlateau();
    }



    @Override
    public void show() {
        primaryStage.setTitle("C'est parti !");
        primaryStage.setScene(new Scene(topNiveau, 300, 275));
        primaryStage.show();
    }

    @Override
    public void showMessageErreur(String messageErreur) {

    }
}
