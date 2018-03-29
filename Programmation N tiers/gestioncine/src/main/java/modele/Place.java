package modele;

public class Place {
    int idSiege;
    boolean reserve;

    public Place(int idSiege) {
        this.idSiege = idSiege;
        reserve = false;
    }

    public int getIdSiege() {
        return idSiege;
    }

    public void setIdSiege(int idSiege) {
        this.idSiege = idSiege;
    }

    public boolean isReserve() {
        return reserve;
    }

    public void setReserve(boolean reserve) {
        this.reserve = reserve;
    }
}
