package views;

import controleur.Controleur;
import exceptions.SiegeDejaReserveException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import modele.Place;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;

public class Placement {

    private Controleur monControleur;
    private Place place;

    @FXML
    Label lblPlacement;

    @FXML
    private GridPane gridpane;

    private ArrayList<Button> mesButtons = new ArrayList<Button>();

    @FXML
    Button btnMenu;

    private int idSiege;

    public static Placement creerEtAfficher(Controleur c, Stage laStageUnique) {
        URL location = Placement.class.getResource("/views/placement.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(location);
        Parent root = null;
        try {
            root = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Placement vue = fxmlLoader.getController();
        laStageUnique.setTitle("Réservation");
        laStageUnique.setScene(new Scene(root, 800, 600));
        laStageUnique.show();
        vue.setMonControleur(c);
        return vue;
    }

    public void setMonControleur(Controleur monControleur) {
        this.monControleur = monControleur;
    }

    int i = 0;
    public void affichePlace() {
        int n = 0;
        Place[][] lesPlaces = monControleur.getPlace();

        for(int y = 0; y < lesPlaces.length; y++) {
            for(int x = 0; x < lesPlaces[y].length; x++){

                mesButtons.add(new Button(String.valueOf(i)));
                //i = lesPlaces[x][y].getIdSiege();
                gridpane.add(mesButtons.get(i), x, y);

                mesButtons.get(i).setOnAction(new EventHandler<ActionEvent>() {
                    @Override public void handle(ActionEvent e) {
                           Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                           alert.setTitle("Message");
                           alert.setHeaderText("Message");
                           alert.setContentText("Le siège " + getI() + " a bien été sélectionné !");

                           alert.showAndWait();
                    }
                });
                i++;
            }
        }
    }

    public void retourMenu(ActionEvent actionEvent) {
        try {
            monControleur.goToMenu();
        } catch (Exception e) {
            afficheMessageErreur(e.getMessage());
        }
    }

    public void afficheMessageErreur(String message) {
        Alert a = new Alert(Alert.AlertType.ERROR,message, ButtonType.OK);
        a.show();
    }

    public int getI() {
        return i;
    }
}
