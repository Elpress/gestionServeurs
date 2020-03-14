package sn.serveur.controller;

import sn.serveur.dao.ILocal;
import sn.serveur.dao.IServeur;
import sn.serveur.dao.LocalImpl;
import sn.serveur.dao.ServeurImpl;
import sn.serveur.entities.Local;
import sn.serveur.entities.Serveur;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/Serveur", name = "serveur")
public class ServeurServlet extends HttpServlet {
    IServeur serveurdao = null;
    ILocal localdao = null;

    @Override
    public void init(ServletConfig config) throws ServletException {
        serveurdao = new ServeurImpl();
        localdao = new LocalImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // resp.getWriter().println("Ok page trouve");
        List<Local> l_local = localdao.getAll();
        req.setAttribute("locals", l_local);

        List<Serveur> l_serveur = serveurdao.getAll();
        req.setAttribute("serveurs", l_serveur);

        req.getRequestDispatcher("views/serveur/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nomS = req.getParameter("nomS");
        String adripS = req.getParameter("adripS");
        Integer idL = Integer.parseInt(req.getParameter("idL"));

        Serveur serveur = new Serveur();
        serveur.setNomS(nomS);
        serveur.setAdripS(adripS);

        Local local = new Local();
        local.setIdL(idL);
        serveur.setLocal(local);

        int ok = serveurdao.add(serveur);
        resp.sendRedirect("Serveur");
    }
}
