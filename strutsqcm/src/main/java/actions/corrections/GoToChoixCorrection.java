package actions.corrections;

import actions.Environnement;
import modele.Questionnaire;

import java.util.Collection;

public class GoToChoixCorrection extends Environnement {

    public Collection<Questionnaire> getQcms() {
        return getFacade().getListQuestionnairesFaits(
                (String) getVariablesSession().get(LOGIN)
        );
    }

}
