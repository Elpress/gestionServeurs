package sn.serveur.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DB {

    // pour la connexion
    private Connection con;
    // pour les resultats des requetes de type SELECT
    private ResultSet rs;
    // pour les requetes preparees
    private PreparedStatement pstm;
    // pour les resultats des requetes de type mise a jour (INSERT, UPDADE, DELETE)
    private int ok;

    private void getConnection() {
        String mysqlurl = "jdbc:mysql://localhost:3306/gestionserveur";
        String mysqluser = "root";
        String mysqlpassword = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(mysqlurl, mysqluser, mysqlpassword);
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void initPrepar(String sql) {
        try {
            getConnection();
            pstm = con.prepareStatement(sql);
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public ResultSet executeSelect() {
        rs = null;
        try {
            rs = pstm.executeQuery();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return rs;
    }
    public int executeMaj() {
        try {
            ok = pstm.executeUpdate();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return ok;
    }
    public void closeConnection() {
        try {
            if (con != null) {
                con.close();
            }
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public PreparedStatement getPstm(){
        return pstm;
    }

}
