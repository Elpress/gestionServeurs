package sn.serveur.controller;

import sn.serveur.dao.ILocal;
import sn.serveur.dao.LocalImpl;
import sn.serveur.entities.Local;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/Local", name = "local")
public class LocalServlet extends HttpServlet {
    ILocal localdao = null;

    @Override
    public void init(ServletConfig config) throws ServletException {
        localdao = new LocalImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Local> l_local = localdao.getAll();
        req.setAttribute("locals", l_local);

        req.getRequestDispatcher("views/local/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nomL = req.getParameter("nomL");

        Local local = new Local();
        local.setNomL(nomL);

        int ok = localdao.add(local);

        resp.sendRedirect("Local");
    }
}
