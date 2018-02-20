package actions.qcms;

import actions.Environnement;
import modele.Questionnaire;

import java.util.Collection;

public class GoToChoixQCM extends Environnement {

    public Collection<Questionnaire> getQcms() {
        return getFacade().getListQuestionnairesNonFaits(
                (String) getVariablesSession().get(LOGIN)
        );
    }

}
