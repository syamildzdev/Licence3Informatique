package actions.connexions;

import actions.Environnement;

public class Deconnexion extends Environnement {

    @Override
    public String execute() throws Exception {
        getFacade().deconnexion((String) getVariablesSession().get("login"));
        getVariablesSession().clear();
        return SUCCESS;
    }
}
