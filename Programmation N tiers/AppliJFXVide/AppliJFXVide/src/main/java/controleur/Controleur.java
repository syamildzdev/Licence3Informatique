package controleur;

import javafx.stage.Stage;
import modele.GestionDemineur;
import views.ConnexionInterface;
import views.FabriqueVues;
import views.jfx.Connexion;

/**
 * Created by YohanBoichut on 10/11/15.
 */
public class Controleur {


    private ConnexionInterface maVue;
    private FabriqueVues fabriqueVues;

    private GestionDemineur gestionDemineur;

    public Controleur(FabriqueVues fabriqueVues) {

        this.fabriqueVues = fabriqueVues;
        this.maVue = this.fabriqueVues.buildConnexionView(this);
        this.gestionDemineur = new GestionDemineur();
        this.maVue.show();

    }



    public GestionDemineur getGestionDemineur() {
        return gestionDemineur;
    }


}
