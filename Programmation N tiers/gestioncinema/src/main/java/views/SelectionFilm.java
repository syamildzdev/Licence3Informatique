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

import java.io.IOException;
import java.net.URL;
import java.util.Collection;

public class SelectionFilm {

    private Controleur monControleur;

    @FXML
    Label selectionLabel;

    @FXML
    ComboBox<Film> lesFilms;

    @FXML
    Button btnSelect;

    @FXML
    Button btnMenu;

    private Film filmSelected;
    private int idFilm;

    public static SelectionFilm creerEtAfficher(Controleur c, Stage laStageUnique) {
        URL location = SelectionFilm.class.getResource("/views/selectionFilm.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(location);
        Parent root = null;
        try {
            root = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        SelectionFilm vue = fxmlLoader.getController();
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
        Collection<Film> listeFilms = monControleur.getFilms();
        lesFilms.getItems().setAll(listeFilms);

        lesFilms.setConverter(new StringConverter<Film>() {
            @Override
            public String toString(Film object) {
                return object.getTitreFilm();
            }

            @Override
            public Film fromString(String string) {
                return null;
            }
        });
    }


    public void clickOk(ActionEvent actionEvent) {

        if(lesFilms.getValue()==null) {
            afficheMessageErreur("Veuillez sélectionner un film!");
        } else {
            filmSelected = lesFilms.getValue();
            idFilm = filmSelected.getIdFilm();
            monControleur.goToSelectionSeance();
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

    public Film getFilmSelected() {
        return filmSelected;
    }

    public void setFilmSelected(Film filmSelected) {
        this.filmSelected = filmSelected;
    }

    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }
}
