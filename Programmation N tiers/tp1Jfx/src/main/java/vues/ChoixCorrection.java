package vues;

import controleur.Controleur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import modele.classesMetiers.QuestionReponse;
import modele.classesMetiers.Questionnaire;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;


public class ChoixCorrection {

    private Controleur monControleur;
    private QuestionReponse questionReponse;

    private int idQuestionnaire;

    @FXML
    ComboBox<QuestionReponse> listeQuestionReponse;

    @FXML
    Button btnSelect;

    public static ChoixCorrection creerEtAfficher(Controleur c, Stage laStageUnique) {
        URL location = ChoixCorrection.class.getResource("/vues/choixCorrection.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(location);
        Parent root = null;
        try {
            root = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ChoixCorrection vue = fxmlLoader.getController();
        laStageUnique.setTitle("Choix Correction");
        laStageUnique.setScene(new Scene(root, 800, 600));
        laStageUnique.show();
        vue.setMonControleur(c);
        return vue;
    }

    public void initialiserListe() {
        Collection<QuestionReponse> liste = monControleur.getQuestionReponse();
        listeQuestionReponse.getItems().setAll(liste);
        listeQuestionReponse.setConverter(new StringConverter<QuestionReponse>() {
            @Override
            public String toString(QuestionReponse object) {
                return object.getReponseCorrecte();
            }

            @Override
            public QuestionReponse fromString(String string) {
                return null;
            }
        });
    }

    public void setMonControleur(Controleur monControleur) {
        this.monControleur = monControleur;
    }


    public void quitterApplication(ActionEvent actionEvent) {
        monControleur.quitter();
    }

    public void valider(ActionEvent event) {

    }
}
