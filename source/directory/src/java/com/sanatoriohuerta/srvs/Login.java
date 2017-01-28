package com.sanatoriohuerta.srvs;

import com.sanatoriohuerta.modelbeans.Configuration;
import com.sanatoriohuerta.modelbeans.Department;
import com.sanatoriohuerta.modelbeans.Description;
import com.sanatoriohuerta.modelbeans.Localphone;
import com.sanatoriohuerta.modelbeans.User;
import com.sanatoriohuerta.modelbeans.Utilities;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Angel
 */
public class Login extends HttpServlet {

    private User oUsuario = new User();
    private Department oDep = new Department();
    private Department[] departments;
    private Localphone oLocp = new Localphone();
    private Localphone[] localphones;
    private Description oDescrip = new Description();
    private Description[] descriptions;

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        if ("login".equals(request.getParameter("accion"))) {
            // Logueo del usuario
            if (request.getSession().getAttribute("user") != null) {
                RequestDispatcher a = request.getRequestDispatcher("index.jsp");
                a.forward(request, response);
            }
            login(request, response);
        }
    }

    void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {

        if (request.getParameter("user") != null && request.getParameter("password") != null) {
            oUsuario.setUser(request.getParameter("user"));
            oUsuario.setPassword(request.getParameter("password"));
            if (oUsuario.searchUserForLogin()) {
                //Obtenemos los datos de departamentos para mostrar
                departments = oDep.searchByUserPermission(oUsuario.getId());
                localphones = oLocp.searchAllLocalPhone();
                descriptions = oDescrip.searchAllDescriptions();
                String msj = "Bienvenido " + oUsuario.getName();
                HttpSession session = request.getSession();
                session.setAttribute("usuarioSesion", oUsuario);
                System.out.println(oUsuario);
                session.setAttribute("departments", departments);
                session.setAttribute("localphones", localphones);
                session.setAttribute("descriptions", descriptions);
                session.setAttribute("config", new Configuration().getConfiguration());
                request.setAttribute("msj", msj);
                request.setAttribute("msjtype", Utilities.INFO);
                RequestDispatcher a = request.getRequestDispatcher("home.jsp");
                a.forward(request, response);
            } else {
                request.setAttribute("msj", new Utilities().convertMsjDBForFrontend(oUsuario.getMsjQuery()));
                request.setAttribute("msjtype", Utilities.ERROR);
                RequestDispatcher a = request.getRequestDispatcher("index.jsp");
                a.forward(request, response);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
