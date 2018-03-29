package facade;

import exceptions.SiegeDejaReserveException;
import modele.Film;
import modele.Place;
import modele.Salle;
import modele.Seance;

import java.util.*;

public class GestionCineImpl implements GestionCine {

    private Map<Integer,Film> bibliothequeFilms;
    private Map<Integer, Salle> sallesDisponibles;
    private Map<Integer, Collection<Seance>> seancesParFilm;

    private Map<Integer,Integer> associationFilmSalle;
    private Map<Integer,Integer> associationSalleFilm;






    public GestionCineImpl() {
        bibliothequeFilms = new HashMap<Integer, Film>();
        sallesDisponibles = new HashMap<Integer, Salle>();
        seancesParFilm = new HashMap<Integer, Collection<Seance>>();
        associationFilmSalle = new HashMap<Integer, Integer>();
        associationSalleFilm = new HashMap<Integer, Integer>();
        this.initialisationData();
    }



    private void initialisationData() {
        Film hp1 = new Film("Harry Potter à l'école des sorciers");
        Film hp2 = new Film("Harry Potter et la chambre des secrets");
        Film hp3 = new Film("Harry Potter et le prisonnier d'Azkaban");
        Film hp4 = new Film("Harry Potter et la coupe de feu");
        Film hp5 = new Film("Harry Potter et l'order du Phoenix");
        Film hp6 = new Film("Harry Potter et le prince de sang-mêlé");
        Film hp7 = new Film ("Harry Potter et les reliques de la mort - part 1");
        Film hp8 = new Film ("Harry Potter et les reliques de la mort - part 2");

        bibliothequeFilms.put(hp1.getIdFilm(),hp1);
        bibliothequeFilms.put(hp2.getIdFilm(),hp2);
        bibliothequeFilms.put(hp3.getIdFilm(),hp3);
        bibliothequeFilms.put(hp4.getIdFilm(),hp4);
        bibliothequeFilms.put(hp5.getIdFilm(),hp5);
        bibliothequeFilms.put(hp6.getIdFilm(),hp6);
        bibliothequeFilms.put(hp7.getIdFilm(),hp7);
        bibliothequeFilms.put(hp8.getIdFilm(),hp8);


        Salle grandeSalle = new Salle(1,5,4);
        Salle petiteSalle1 = new Salle(2,3,4);
        Salle petiteSalle2 = new Salle(3,3,3);


        sallesDisponibles.put(grandeSalle.getNumeroSalle(),grandeSalle);
        sallesDisponibles.put(petiteSalle1.getNumeroSalle(),petiteSalle1);
        sallesDisponibles.put(petiteSalle2.getNumeroSalle(),petiteSalle2);

        List<String> creneauxHoraires = Arrays.asList("13h00","16h00","21h00");
        List<Film> filmsEnSalle = Arrays.asList(hp1,hp2,hp3);
        List<Salle> salles = Arrays.asList(grandeSalle,petiteSalle1,petiteSalle2);



        for (String creneau : creneauxHoraires) {
            for(int i=0; i<filmsEnSalle.size();i++) {
                Film film = filmsEnSalle.get(i);
                for(int j=0; j<salles.size();j++) {
                    Salle salle = salles.get(j);
                    if (i == j) {
                        Seance seance = new Seance(creneau, salle, film.getIdFilm());
                        Collection<Seance> res = seancesParFilm.get(film.getIdFilm());
                        if (res == null) {
                            res = new ArrayList<Seance>();
                            seancesParFilm.put(film.getIdFilm(), res);
                            associationFilmSalle.put(film.getIdFilm(), salle.getNumeroSalle());
                            associationSalleFilm.put(salle.getNumeroSalle(), film.getIdFilm());
                        }
                        res.add(seance);
                    }


                }
            }
        }


    }

    public Place[][] getConfigurationSallePourUnFilmEtUneSeance(int idFilm, String heureDebutSeance) {
        for(Seance seance:seancesParFilm.get(idFilm)) {
            if (seance.getHoraireDebutSeance().equals(heureDebutSeance)) {
                return seance.getConfiguration();
            }
        }
        return null;
    }

    public int getNumeroSalle(int idFilm) {
        return associationFilmSalle.get(idFilm);
    }

    public void reserverSiege(int idFilm, String heureDebutSeance, int numeroSiege) throws SiegeDejaReserveException {
        for(Seance seance:seancesParFilm.get(idFilm)) {
            if (seance.getHoraireDebutSeance().equals(heureDebutSeance)) {
                seance.reserverSiege(numeroSiege);
            }
        }
    }

    public Collection<Film> getFilmsEnSalle() {
        ArrayList<Film> films = new ArrayList<Film>();
        for(Integer idFilm : associationFilmSalle.keySet()) {
            films.add(bibliothequeFilms.get(idFilm));
        }
        return films;
    }

    public Collection<Seance> getSeancesDisponiblesPourUnFilm(int idFilm) {
        ArrayList<Seance> seances = new ArrayList<Seance>();
        for(Seance seance : seancesParFilm.get(idFilm)) {
            if (!seance.getAGuichetsFermes()) {
                seances.add(seance);
            }
        }

        return seances;
    }

    public Collection<Seance> getSeancesGuichetsFermesPourLeCine() {
        ArrayList<Seance> seances = new ArrayList<Seance>();
        for(Integer idFilm : associationFilmSalle.keySet()) {
            for (Seance seance : seancesParFilm.get(idFilm)) {
                if (!seance.getAGuichetsFermes()) {
                    seances.add(seance);
                }
            }
        }
        return seances;
    }

    public Film getFilmParId(int idFilm) {
        return bibliothequeFilms.get(idFilm);
    }

    public Salle getSalleParId(int numeroSalle) {
        return sallesDisponibles.get(numeroSalle);
    }



}
