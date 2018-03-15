package actions.jouer;

import actions.Environnement;
import modele.Case;
import modele.GestionDemineur;
import modele.Plateau;
import modele.exceptions.BombeException;

public class Jouer extends Environnement {

    @Override
    public GestionDemineur getFacade() {
        return super.getFacade();
    }

    public String getString() {
        return getFacade().getPlateau((String) getVariablesSession().get(LOGIN)).getMonPlateau().toString();
    }

    @Override
    public String execute() throws Exception {

        try {
            Plateau monPlateau = getFacade().getPlateau((String) getVariablesSession().get(LOGIN));
            for (int i = 0; i < monPlateau.getMonPlateau().length; i++) {
                for (int j = 0; j < monPlateau.getMonPlateau().length; j++) {
                    monPlateau.decouvrirCase(i, j);
                }
            }

            return "encore";
        } catch (BombeException e) {

            return "perdu";
        } catch (Exception e) {

            return "gagne";
        }

    }
}
