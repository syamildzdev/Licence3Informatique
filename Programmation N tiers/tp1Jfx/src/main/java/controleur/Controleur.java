package controleur;


import javafx.stage.Stage;
import modele.classesMetiers.QuestionReponse;
import modele.classesMetiers.Questionnaire;
import modele.exceptions.InformationsSaisiesIncoherentesException;
import modele.exceptions.PseudoDejaUtiliseException;
import modele.exceptions.QuestionnaireEnCoursNonTermineException;
import modele.exceptions.QuestionnaireEnCoursTermineException;
import modele.facade.GestionQCMImpl;
import modele.facade.InterfaceUtilisateur;
import vues.ChoixQCM;
import vues.Login;
import vues.Menu;
import vues.QuestionCourante;

import java.util.Collection;
import java.util.List;

/**
 * Created by YohanBoichut on 10/11/15.
 */
public class Controleur {

    private Stage laStageUnique;

    private Login login;
    private Menu menu;
    private ChoixQCM choixQCM;
    private QuestionCourante questionCourante;

    private QuestionReponse questionReponse;

    private InterfaceUtilisateur facade;

    String pseudo;
    private int idQuestionnaire;

    public Controleur(Stage primaryStage) {
        this.facade = new GestionQCMImpl() ;
        this.laStageUnique = primaryStage;
        this.login = Login.creerEtAfficher(this,laStageUnique);
    }

   public void tenteUnLogin(String pseudo,String motDePasse) {
        try {
            facade.connexion(pseudo,motDePasse);
            // OK on est log
            this.pseudo = pseudo;
            this.goToMenu();
            // afficher le menu
            // changer la Scene de la stage pour le menu
        } catch (PseudoDejaUtiliseException exceptionLoginDejaPris) {
            // pas OK : on reste sur le login
            login.afficheMessageErreur("Login déjà connecté !!!");
        } catch (InformationsSaisiesIncoherentesException e) {
            login.afficheMessageErreur("Couple Login/mot de passe incohérent");
        }
    }

    public Collection<Questionnaire> getQuestionnairesNonFaits() {
        return facade.getListQuestionnairesNonFaits(pseudo);
    }

    public Collection<QuestionReponse> getQuestionReponse() {
        //return facade.getReponsesDonneesPourQuestionnaire()
        return null;
    }

    public void goToMenu() {
        menu = Menu.creerEtAfficher(this,laStageUnique);
    }

    public void goToChoixQCM() {
        choixQCM = ChoixQCM.creerEtAfficher(this, laStageUnique);
        choixQCM.initialiserListe();
        //facade
    }

    public void goToQuestionCourante() {
        questionCourante = QuestionCourante.creerEtAfficher(this, laStageUnique);
        try {
            facade.choixQuestionnaire(pseudo, idQuestionnaire);
            questionCourante.showQuestionReponse();
        } catch (QuestionnaireEnCoursNonTermineException e) {
            e.printStackTrace();
        }
    }

    public void quitter() {
        this.facade.deconnexion(pseudo);
        this.login = Login.creerEtAfficher(this,laStageUnique);
    }

    public Collection<QuestionReponse> getQuestionCourante() {
        Questionnaire q = facade.getQuestionnaireById(pseudo, idQuestionnaire);
        Collection<QuestionReponse> listeQuestion = facade.getQuestionnaireById(pseudo, idQuestionnaire).getQuestionsReponses();
        return listeQuestion;
    }

    public QuestionReponse getNext() {
        return facade.next(pseudo, idQuestionnaire);
    }

    public Collection<String> getReponsesPossibles() {
        return facade.getQuestionnaireById(pseudo, idQuestionnaire).getQuestionById(idQuestionnaire).getReponsesPossibles();
    }

    public int getIdQuestionnaire() {
        return idQuestionnaire;
    }

    public void setIdQuestionnaire(int idQuestionnaire) {
        this.idQuestionnaire = idQuestionnaire;
    }

}
