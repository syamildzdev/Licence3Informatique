package modele;

import exceptions.SiegeDejaReserveException;

import java.util.Arrays;

public class Seance {
    String horaireDebutSeance;

    Salle salle;
    int idFilm;
    int nbPlacesDisponibles;

    Place[][] configuration; /* Configuration de la salle concernée par la séance*/


    /**
     *  @param horaireDebutSeance : heure du début de la séance
     * @param salle : salle concernée par la séance
     * @param idFilm : id du film diffusé
     */


    public Seance(String horaireDebutSeance, Salle salle, int idFilm) {
        this.horaireDebutSeance = horaireDebutSeance;
        this.salle = salle;
        this.idFilm = idFilm;
        this.configuration = salle.getConfiguration();
        this.nbPlacesDisponibles = salle.getNbRang()*salle.getNbSiegeParRang();
    }


    public String getHoraireDebutSeance() {
        return horaireDebutSeance;
    }

    public void setHoraireDebutSeance(String horaireDebutSeance) {
        this.horaireDebutSeance = horaireDebutSeance;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    public Place[][] getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Place[][] configuration) {
        this.configuration = configuration;
    }

    public int getNbPlacesDisponibles() {
        return nbPlacesDisponibles;
    }

    public boolean getAGuichetsFermes() {
        return nbPlacesDisponibles <= 0;
    }

    public void reserverSiege(int idSiege) throws SiegeDejaReserveException {

        System.out.println(this);
        if (!getAGuichetsFermes()) {
            int x = idSiege / salle.getNbSiegeParRang();
            int y = idSiege % salle.getNbSiegeParRang();
            if (configuration[x][y].isReserve()) {
                throw new SiegeDejaReserveException();
            }
            configuration[x][y].setReserve(true);
            nbPlacesDisponibles--;
        }
    }


    @Override
    public String toString() {
        String resultat = "";

        for (int i=0;i<configuration.length;i++) {
            for(int j=0;j<configuration[0].length;j++) {
                resultat += " "+ configuration[i][j].getIdSiege();
            }
            resultat +="\n";
        }
        return resultat;
    }
}
