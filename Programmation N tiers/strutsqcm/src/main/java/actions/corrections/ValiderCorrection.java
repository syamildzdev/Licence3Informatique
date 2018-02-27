package actions.corrections;

import actions.Environnement;
import modele.CorrectionQuestion;

import java.util.Collection;

public class ValiderCorrection extends Environnement {

    private int idQuestionnaire;

    CorrectionQuestion correctionQuestion;
    private String reponse;
    private String idQuestion;
    private String idQst;
    private String reponses;

    public Collection<CorrectionQuestion> getCorrection() {
        String login = (String) getVariablesSession().get(LOGIN);
        return getFacade().getReponsesDonneesPourQuestionnaire(login, idQuestionnaire);
    }

    public int getIdQuestionnaire() {
        return idQuestionnaire;
    }

    public void setIdQuestionnaire(int idQuestionnaire) {
        this.idQuestionnaire = idQuestionnaire;
    }

    public CorrectionQuestion getCorrectionQuestion() {
        return correctionQuestion;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public String getReponse() {
        return reponse;
    }

    public void setIdQuestion(String idQuestion) {
        this.idQuestion = idQuestion;
    }

    public String getIdQuestion() {
        return idQuestion;
    }

    public void setIdQst(String idQst) {
        this.idQst = idQst;
    }

    public String getIdQst() {
        return idQst;
    }

    public void setReponses(String reponses) {
        this.reponses = reponses;
    }

    public String getReponses() {
        return reponses;
    }

    public void setI(String i) {
    }

    public void setR(String r) {
    }
}
