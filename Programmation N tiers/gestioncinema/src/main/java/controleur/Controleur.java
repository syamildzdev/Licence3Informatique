package controleur;

import facade.GestionCineImpl;
import javafx.stage.Stage;
import modele.Film;
import modele.Place;
import modele.Seance;
import views.Menu;
import views.Placement;
import views.SelectionFilm;
import views.SelectionSeance;

import java.util.Collection;

public class Controleur {

    private Stage laStageUnique;

    private Menu menu;
    private SelectionFilm selectionFilm;
    private SelectionSeance selectionSeance;
    private Placement placement;

    private GestionCineImpl facade;


    public Controleur(Stage primaryStage) {
        this.facade = new GestionCineImpl() ;
        this.laStageUnique = primaryStage;
        this.menu = menu.creerEtAfficher(this,laStageUnique);
        goToMenu();
    }

    public void reserverPlace(int idSiege) {
        //facade.reserverSiege(selectionFilm.getIdFilm(), selectionSeance.getSeance(), idSiege);
    }

    public Collection<Film> getFilms() {
        return facade.getFilmsEnSalle();
    }

    public Collection<Seance> getSeance() {
        return facade.getSeancesDisponiblesPourUnFilm(selectionFilm.getIdFilm());
    }

    public int getRang() {
        return facade.getSalleParId(facade.getNumeroSalle(selectionFilm.getIdFilm())).getNbRang();
    }

    public int getNbSiegeParRang() {
        return facade.getSalleParId(facade.getNumeroSalle(selectionFilm.getIdFilm())).getNbSiegeParRang();
    }

    public Place[][] getPlace() {
        return facade.getSalleParId(facade.getNumeroSalle(selectionFilm.getIdFilm())).getConfiguration();
    }

    public void goToMenu() {
        menu = Menu.creerEtAfficher(this,laStageUnique);
    }

    public void goToSelectionFilm() {
        selectionFilm = SelectionFilm.creerEtAfficher(this, laStageUnique);
        selectionFilm.initialiserListe();
    }

    public void goToSelectionSeance() {
        selectionSeance = SelectionSeance.creerEtAfficher(this, laStageUnique);
        selectionSeance.initialiserListe();
    }

    public void goToPlacement() {
        placement = Placement.creerEtAfficher(this, laStageUnique);
        placement.affichePlace();
    }

    public GestionCineImpl getFacade() {
        return facade;
    }

    public void quitter() {
        Stage stage = (Stage) menu.getBtnQuitter().getScene().getWindow();
        stage.close();
    }
}
