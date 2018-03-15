package views;

import controleur.Controleur;

public interface FabriqueVues {

    ConnexionInterface buildConnexionView(Controleur c);
    JeuInterface buildJeuView(Controleur c);
    ResultatInterface buildResultatView(Controleur c);

}
