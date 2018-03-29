package modele;

public class Film {
    private static int ID_FILMS = 0;
    int idFilm;
    String titreFilm;


    public Film(String titreFilm) {
        this.idFilm = ID_FILMS++;
        this.titreFilm = titreFilm;
    }


    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    public String getTitreFilm() {
        return titreFilm;
    }

    public void setTitreFilm(String titreFilm) {
        this.titreFilm = titreFilm;
    }
}
