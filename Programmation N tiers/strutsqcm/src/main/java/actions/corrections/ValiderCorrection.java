package actions.corrections;

import actions.Environnement;
import modele.CorrectionQuestion;

import java.util.Collection;

public class ValiderCorrection extends Environnement {

    private int idQuestionnaire;

    public Collection<CorrectionQuestion> getCorrection() {
        return getFacade().getReponsesDonneesPourQuestionnaire((String) getVariablesSession().get(LOGIN),
                getIdQuestionnaire());
    }

    @Override
    public String execute() throws Exception {
       return super.execute();
    }

    public int getIdQuestionnaire() {
        return idQuestionnaire;
    }

    public void setIdQuestionnaire(int idQuestionnaire) {
        this.idQuestionnaire = idQuestionnaire;
    }
}
