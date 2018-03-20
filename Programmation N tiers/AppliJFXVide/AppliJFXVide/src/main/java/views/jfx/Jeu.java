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
import modele.exceptions.BombeException;
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
    private Case[][] monPlateau;
    private Stage primaryStage;

    @FXML
    private GridPane gridpane;

    @FXML
    private ArrayList<Button> mesButtons;

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

    @Override
    public void show() {
        creerPlateau(monControleur.getLogin());
        primaryStage.setTitle("C'est parti !");
        primaryStage.setScene(new Scene(topNiveau, 300, 275));
        primaryStage.show();
    }

    @Override
    public void showMessageErreur(String messageErreur) {

    }

    int i = 0;
    public void creerPlateau(String login) {
        monPlateau = getPlateau(login);
        mesButtons = new ArrayList<Button>();
        for(int y = 0; y < monPlateau.length; y++) {
           for(int x = 0; x < monPlateau[y].length; x++){
               mesButtons.add(new Button(" " + monPlateau[x][y].getValeur()));
               gridpane.add(mesButtons.get(i), x, y);
               mesButtons.get(i).setOnAction(action -> play());
               i++;
           }
        }

    }

    public Case[][] getPlateau(String login) {
        return monControleur.getGestionDemineur().getPlateau(login).getMonPlateau();
    }

    public void play() {

        try{
            for(int y = 0; y < monPlateau.length; y++) {
                for(int x = 0; x < monPlateau[y].length; x++) {
                    monControleur.getGestionDemineur().decouvrir(monControleur.getLogin(), x, y);

                }
            }

        } catch (BombeException bombe) {

        }
    }

    public void setMonControleur(Controleur monControleur) {
        this.monControleur = monControleur;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }


}
