package sn.serveur.dao;

import sn.serveur.entities.Local;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LocalImpl implements ILocal{

    private DB db = new DB();

    @Override
    public int add(Local local) {
        String sql = "INSERT INTO local VALUES(NULL, ?)";
        int ok = 0;

        try {
            db.initPrepar(sql);
            db.getPstm().setString(1, local.getNomL());

            ok = db.executeMaj();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        return ok;
    }

    @Override
    public int update(Local local) {
        String sql = "UPDATE local SET nomL = ? WHERE id = ?";
        int ok = 0;
        try {
            db.initPrepar(sql);
            db.getPstm().setString(1, local.getNomL());

            ok = db.executeMaj();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return ok;
    }

    @Override
    public int delete(int idL) {
        String sql = "DELETE FROM local WHERE idL = ?";
        int ok = 0;
        try {
            db.initPrepar(sql);
            db.getPstm().setInt(1, idL);

            ok = db.executeMaj();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return ok;
    }

    @Override
    public List<Local> getAll() {
        String sql = "SELECT * FROM local";
        List<Local> localList = new ArrayList<Local>();

        try {
            db.initPrepar(sql);
            ResultSet rs = db.executeSelect();
            while (rs.next()) {
                Local local = new Local();
                local.setIdL(rs.getInt(1));
                local.setNomL(rs.getString(2));

                localList.add(local);
            }
            rs.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return localList;
    }

    @Override
    public Local get(int idL) {
        String sql = "SELECT * FROM local WHERE idL = ?";

        Local local = null;
        try {
            db.initPrepar(sql);
            db.getPstm().setInt(1, idL);
            ResultSet rs = db.executeSelect();
            if (rs.next()) {
                local = new Local();
                local.setIdL(rs.getInt(1));
                local.setNomL(rs.getString(2));
            }
            rs.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return local;
    }
}
