package facade;

import exceptions.SiegeDejaReserveException;
import modele.Salle;
import modele.Seance;
import modele.Film;
import modele.Place;

import java.util.Collection;

public interface GestionCine {


    /**
     * Permet de retourner la configuration de la salle pour un idFilm donné et un horaire de début de séance
     * @return la configuration de la salle
     */
    Place[][] getConfigurationSallePourUnFilmEtUneSeance(int idFilm, String heureDebutSeance);


    /**
     *
     * @param idFilm id du film
     * @return numéro de la salle dans laquelle est projeté le film
     */

    int getNumeroSalle(int idFilm);


    /**
     * Permet de réserver un siège pour une séance donnée
     * @param idFilm
     * @param heureDebutSeance
     * @param numeroSiege
     */
    void reserverSiege(int idFilm, String heureDebutSeance, int numeroSiege) throws SiegeDejaReserveException;


    /**
     * Permet d'avoir la liste des films actuellement en salle dans le ciné
     * @return
     */
    Collection<Film> getFilmsEnSalle();


    /**
     * Permet d'avoir la liste des séances ayant encore au moins une place à réserver pour un film donné
     * @param idFilm
     * @return
     */
    Collection<Seance> getSeancesDisponiblesPourUnFilm(int idFilm);


    /**
     * Permet d'avoir la liste des séances dans le cinéma n'ayant plus une place à réserver
     * @return
     */
    Collection<Seance> getSeancesGuichetsFermesPourLeCine();





    /**
     *
     * @param idFilm
     * @return le film correspondant à l'id
     */

    Film getFilmParId(int idFilm);

    /**
     *
     * @param numeroSalle
     * @return la salle correspondant au numéro de salle
     */
    Salle getSalleParId(int numeroSalle);


}
