package actions.connexions;

import actions.Environnement;
import modele.exceptions.InformationsSaisiesIncoherentesException;
import modele.exceptions.UtilisateurDejaConnecteException;

public class Connexion extends Environnement {

    private String login;
    private String password;

    @Override
    public String execute() {

        try {
            getFacade().connexion(login, password);
            getVariablesSession().put("login", login);

            return SUCCESS;

        } catch (UtilisateurDejaConnecteException e) {
           addFieldError("login", getText("Connexion.erreur1"));
           return INPUT;
        } catch (InformationsSaisiesIncoherentesException e) {
            addFieldError("login", getText("Connexion.erreur2"));
           return INPUT;
        }

    }

    @Override
    public void validate() {
        if(login == null || login.length() == 0)
            addFieldError("login", getText("Connexion.erreur3"));

        if(password == null || password.length() == 0)
            addFieldError("password", getText("Connexion.erreur4"));

    }

    // Getters & Setters

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
