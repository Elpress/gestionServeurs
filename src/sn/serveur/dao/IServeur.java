package sn.serveur.dao;

import sn.serveur.entities.Serveur;

import java.util.List;

public interface IServeur {

    public int add(Serveur serveur);
    public int update(Serveur serveur);
    public int delete(int idS);
    public List<Serveur> getAll();
    public Serveur get(int idS);
}
