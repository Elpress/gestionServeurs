package sn.serveur.entities;

public class Local {

    private int idL;
    private String nomL;

    public Local() {
    }

    public Local(int idL, String nomL) {
        this.idL = idL;
        this.nomL = nomL;
    }

    public int getIdL() {
        return idL;
    }

    public void setIdL(int idL) {
        this.idL = idL;
    }

    public String getNomL() {
        return nomL;
    }

    public void setNomL(String nomL) {
        this.nomL = nomL;
    }
}
