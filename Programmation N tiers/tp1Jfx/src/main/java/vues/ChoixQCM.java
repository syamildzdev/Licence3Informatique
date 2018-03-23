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


public class ChoixQCM {

    private Controleur monControleur;
    private QuestionReponse questionReponse;

    @FXML
    ComboBox<Questionnaire> listeQuestionReponse;

    @FXML
    Button btnSelect;

    public static ChoixQCM creerEtAfficher(Controleur c, Stage laStageUnique) {
        URL location = ChoixQCM.class.getResource("/vues/choixQCM.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(location);
        Parent root = null;
        try {
            root = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ChoixQCM vue = fxmlLoader.getController();
        laStageUnique.setTitle("Choix QCM");
        laStageUnique.setScene(new Scene(root, 800, 600));
        laStageUnique.show();
        vue.setMonControleur(c);
        return vue;
    }

    public void initialiserListe() {
        Collection<Questionnaire> liste = monControleur.getQuestionnairesNonFaits();
        listeQuestionReponse.getItems().setAll(liste);
        listeQuestionReponse.setConverter(new StringConverter<Questionnaire>() {
            @Override
            public String toString(Questionnaire object) {
                return object.getThematiqueQuestionnaire();
            }

            @Override
            public Questionnaire fromString(String string) {
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

    public void validerQCM(ActionEvent event) {
        int id = listeQuestionReponse.getSelectionModel().getSelectedItem().getIdQuestionnaire();
        monControleur.setIdQuestionnaire(id);
        monControleur.goToQuestionCourante();
    }
}
