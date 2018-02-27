package actions.qcms;

import actions.Environnement;
import facade.GestionQCM;
import modele.QuestionReponse;
import modele.Questionnaire;

import java.util.Collection;

public class ValiderChoixQCM extends Environnement {

    private int idQuestionnaire;
    QuestionReponse questionReponse;

    @Override
    public String execute() throws Exception {
        String login = (String) getVariablesSession().get(LOGIN);
        getFacade().choixQuestionnaire(login,idQuestionnaire);
        questionReponse = getFacade().next(login, idQuestionnaire);
        getVariablesSession().put(ID_QUESTIONNAIRE, idQuestionnaire);
        return SUCCESS;
    }

    public QuestionReponse getQuestionReponse() {
        return questionReponse;
    }

    public void setIdQuestionnaire(int idQuestionnaire) {
        this.idQuestionnaire = idQuestionnaire;
    }
}
