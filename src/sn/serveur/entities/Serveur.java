package sn.serveur.entities;

public class Serveur {

    private int idS;
    private String nomS;
    private String adripS;
    private Local local;

    public Serveur() {
    }

    public Serveur(int idS, String nomS, String adripS, Local local) {
        this.idS = idS;
        this.nomS = nomS;
        this.adripS = adripS;
        this.local = local;
    }

    public int getIdS() {
        return idS;
    }

    public void setIdS(int idS) {
        this.idS = idS;
    }

    public String getNomS() {
        return nomS;
    }

    public void setNomS(String nomS) {
        this.nomS = nomS;
    }

    public String getAdripS() {
        return adripS;
    }

    public void setAdripS(String adripS) {
        this.adripS = adripS;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }
}
