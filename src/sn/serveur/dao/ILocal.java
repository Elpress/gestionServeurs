package sn.serveur.dao;

import sn.serveur.entities.Local;

import java.util.List;

public interface ILocal {

    public int add(Local local);
    public int update(Local local);
    public int delete(int idL);
    public List<Local> getAll();
    public Local get(int idL);

}
