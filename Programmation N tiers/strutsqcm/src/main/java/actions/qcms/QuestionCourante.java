package actions.qcms;

import actions.Environnement;
import modele.QuestionReponse;


public class QuestionCourante extends Environnement {

    private int idQuestionnaire;
    QuestionReponse questionReponse;

    private int idQuestion;
    private String reponse;

    public String validerQcm() throws Exception {
        String login = (String) getVariablesSession().get(LOGIN);
        getFacade().choixQuestionnaire(login,idQuestionnaire);
        questionReponse = getFacade().next(login, idQuestionnaire);
        getVariablesSession().put(ID_QUESTIONNAIRE, idQuestionnaire);
        return SUCCESS;
    }

    private Double resultat;

    public Double getResultat() {
        return resultat;
    }

    public String validerQuestionCourante() throws  Exception {
        String login = (String) getVariablesSession().get(LOGIN);

        idQuestionnaire = (int) getVariablesSession().get(ID_QUESTIONNAIRE);
        this.getFacade().validerQuestion(login, idQuestion, reponse);

        if(getFacade().hasNext(login, idQuestionnaire)) {
            questionReponse = getFacade().next(login, idQuestionnaire);
            return "question";
        } else {
            resultat = getFacade().validerQuestionnaire(login);
            return "resultat";
        }

    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public QuestionReponse getQuestionReponse() {
        return questionReponse;
    }

    public void setIdQuestionnaire(int idQuestionnaire) {
        this.idQuestionnaire = idQuestionnaire;
    }
}
