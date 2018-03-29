package modele;

public class Salle {
    int numeroSalle;
    int nbRang;
    int nbSiegeParRang;

    public Salle(int numeroSalle, int nbRang, int nbSiegeParRang) {
        this.numeroSalle = numeroSalle;
        this.nbRang = nbRang;
        this.nbSiegeParRang = nbSiegeParRang;
    }

    public int getNumeroSalle() {
        return numeroSalle;
    }

    public void setNumeroSalle(int numeroSalle) {
        this.numeroSalle = numeroSalle;
    }

    public int getNbRang() {
        return nbRang;
    }

    public void setNbRang(int nbRang) {
        this.nbRang = nbRang;
    }

    public int getNbSiegeParRang() {
        return nbSiegeParRang;
    }

    public void setNbSiegeParRang(int nbSiegeParRang) {
        this.nbSiegeParRang = nbSiegeParRang;
    }

    public Place[][] getConfiguration() {
        Place[][] nouvelleConfiguration = new Place[nbRang][nbSiegeParRang];
        for (int i=0;i<nbRang;i++) {
            for(int j=0;j<nbSiegeParRang;j++) {
                nouvelleConfiguration[i][j] = new Place(i*nbSiegeParRang+j);
            }
        }
        return nouvelleConfiguration;
    }
}
