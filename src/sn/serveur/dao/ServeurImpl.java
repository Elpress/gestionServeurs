package sn.serveur.dao;

import sn.serveur.entities.Local;
import sn.serveur.entities.Serveur;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ServeurImpl implements IServeur {

    private DB db = new DB();

    @Override
    public int add(Serveur serveur) {
        String sql = "INSERT INTO serveur VALUES(NULL, ?, ?, ?)";
        int ok = 0;
        try {
            db.initPrepar(sql);
            db.getPstm().setString(1, serveur.getNomS());
            db.getPstm().setString(2, serveur.getAdripS());
            db.getPstm().setInt(3, serveur.getLocal().getIdL());

            ok = db.executeMaj();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return ok;
    }

    @Override
    public int update(Serveur serveur) {
        String sql = "UPDATE serveur SET nomS = ?, adripS = ?, local = ? WHERE idS = ?";
        int ok = 0;
        try {
            db.initPrepar(sql);
            db.getPstm().setString(1, serveur.getNomS());
            db.getPstm().setString(2, serveur.getAdripS());
            db.getPstm().setInt(3, serveur.getLocal().getIdL());

            ok = db.executeMaj();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return ok;
    }

    @Override
    public int delete(int idS) {
        String sql = "DELETE FROM serveur WHERE idS = ?";
        int ok = 0;
        try {
            db.initPrepar(sql);
            db.getPstm().setInt(1, idS);

            ok = db.executeMaj();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return ok;
    }

    @Override
    public List<Serveur> getAll() {
        String sql = "SELECT * FROM serveur";
        List<Serveur> serveurList = new ArrayList<Serveur>();

        try {
            db.initPrepar(sql);
            ResultSet rs = db.executeSelect();
            while (rs.next()) {
                Serveur serveur = new Serveur();
                serveur.setIdS(rs.getInt(1));
                serveur.setNomS(rs.getString(2));
                serveur.setAdripS(rs.getString(3));

                // Gestion du Local
                Local local = new Local();
                local.setIdL(rs.getInt(4));
                // Ajout dans la liste local
                serveurList.add(serveur);
            }
            rs.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return serveurList;
    }

    @Override
    public Serveur get(int idS) {
        String sql = "SELECT * FROM serveur WHERE idS = ?";

        Serveur serveur = null;
        try {
            db.initPrepar(sql);
            db.getPstm().setInt(1, idS);
            ResultSet rs = db.executeSelect();
            if (rs.next()) {
                serveur = new Serveur();
                serveur.setIdS(rs.getInt(1));
                serveur.setNomS(rs.getString(2));
                serveur.setAdripS(rs.getString(3));

                 // Gestion local
                Local local = new Local();
                local.setIdL(rs.getInt(4));
                serveur.setLocal(local);

            }
            rs.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return serveur;
    }
}
