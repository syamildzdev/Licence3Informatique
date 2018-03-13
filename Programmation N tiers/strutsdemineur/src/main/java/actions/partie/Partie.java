package actions.partie;

import actions.Environnement;
import modele.GestionDemineur;

public class Partie extends Environnement {

    @Override
    public GestionDemineur getFacade() {
        return super.getFacade();
    }

    public String getString() {
        return getFacade().getPlateau((String) getVariablesSession().get(LOGIN)).getMonPlateau().toString();
    }

}
