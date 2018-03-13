package actions.connexion;

import actions.Environnement;
import modele.Case;
import modele.Plateau;
import modele.exceptions.ExceptionLoginDejaPris;

public class Connexion extends Environnement {

    private String pseudo;

    @Override
    public String execute() {

        try {
            getFacade().connexion(pseudo);
            getVariablesSession().put("pseudo", pseudo);

            return SUCCESS;
        } catch (ExceptionLoginDejaPris e) {
           addFieldError("pseudo", getText("Connexion.erreur1"));
           return INPUT;
        }

    }

    public Case[][] getPlateau(){
        return getFacade().getPlateau(pseudo).getMonPlateau();
    }

    @Override
    public void validate() {
        if(pseudo == null || pseudo.length() == 0)
            addFieldError("pseudo", getText("Connexion.erreur2"));
    }

    public String getString() {
        return getFacade().getPlateau((String) getVariablesSession().get(LOGIN)).getMonPlateau().toString();
    }

    // Getters & Setters

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
}
