package controleur;

import modele.GestionDemineur;
import views.Connexion;
import views.Resultat;

/**
 * Created by YohanBoichut on 10/11/15.
 */
public class Controleur {


    private Connexion connexion;
    private GestionDemineur gestionDemineur;

    public Controleur() {

        this.connexion = Connexion.creerInstance(this);
        this.gestionDemineur = new GestionDemineur();

    }

    public GestionDemineur getGestionDemineur() {
        return gestionDemineur;
    }
}
