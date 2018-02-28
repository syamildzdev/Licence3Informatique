package actions.connexion;

import actions.Environnement;

public class Deconnexion extends Environnement {

    @Override
    public String execute() throws Exception {
        getDemineur().deconnexion((String) getVariablesSession().get("pseudo"));
        return SUCCESS;
    }
}
