package vues;

import controleur.Controleur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import modele.classesMetiers.QuestionReponse;
import modele.classesMetiers.Questionnaire;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;


public class QuestionCourante {
    private Controleur monControleur;
    private QuestionReponse questionReponse;

    @FXML
    Label question;

    @FXML
    ComboBox<String> listeReponsePossibles;

    @FXML
    Button btnSubmit;

    public static QuestionCourante creerEtAfficher(Controleur c, Stage laStageUnique) {
        URL location = QuestionCourante.class.getResource("/vues/questionCourante.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(location);
        Parent root = null;
        try {
            root = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        QuestionCourante vue = fxmlLoader.getController();
        laStageUnique.setTitle("Questionaire");
        laStageUnique.setScene(new Scene(root, 800, 600));
        laStageUnique.show();
        vue.setMonControleur(c);
        return vue;
    }

    public void showQuestionReponse() {
        question.setText(monControleur.getQuestionCourante().toString());

        Collection<String> listeReponse = monControleur.getReponsesPossibles();
        listeReponsePossibles.getItems().addAll(listeReponse);
    }

    public void setMonControleur(Controleur monControleur) {
        this.monControleur = monControleur;
    }


    public void quitterApplication(ActionEvent actionEvent) {
        monControleur.quitter();
    }

    public void valider(ActionEvent event) {
        int id = monControleur.getIdQuestionnaire();
        id++;
        monControleur.setIdQuestionnaire(id);
        //monControleur.getNext();
        showQuestionReponse();
    }
}
