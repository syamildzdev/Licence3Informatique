package views;

import controleur.Controleur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import modele.Film;
import modele.Seance;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;

public class SelectionSeance {

    private Controleur monControleur;

    @FXML
    Label selectionLabel;

    @FXML
    ComboBox<Seance> lesSeances;

    @FXML
    Button btnSelect;

    @FXML
    Button btnMenu;

    private Seance seance;

    public static SelectionSeance creerEtAfficher(Controleur c, Stage laStageUnique) {
        URL location = SelectionSeance.class.getResource("/views/selectionSeance.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(location);
        Parent root = null;
        try {
            root = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        SelectionSeance vue = fxmlLoader.getController();
        laStageUnique.setTitle("Choix d'un film");
        laStageUnique.setScene(new Scene(root, 800, 600));
        laStageUnique.show();
        vue.setMonControleur(c);
        return vue;
    }

    public void setMonControleur(Controleur monControleur) {
        this.monControleur = monControleur;
    }

    public void initialiserListe() {
        Collection<Seance> listeSeances = monControleur.getSeance();
        lesSeances.getItems().setAll(listeSeances);

        lesSeances.setConverter(new StringConverter<Seance>() {
            @Override
            public String toString(Seance object) {
                return object.getHoraireDebutSeance() + " - " + object.getNbPlacesDisponibles() + " places restantes";
            }

            @Override
            public Seance fromString(String string) {
                return null;
            }
        });
    }

    public void clickOk(ActionEvent actionEvent) {

        if(lesSeances.getValue()==null) {
            afficheMessageErreur("Veuillez sélectionner une séance!");
        } else {
            seance = lesSeances.getValue();
            monControleur.goToPlacement();
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
        Alert a = new Alert(Alert.AlertType.WARNING,message, ButtonType.OK);
        a.show();
    }

    public Seance getSeance() {
        return seance;
    }
}
