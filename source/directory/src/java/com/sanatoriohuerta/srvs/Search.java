package com.sanatoriohuerta.srvs;

import com.sanatoriohuerta.modelbeans.Utilities;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Angel
 */
public class Search extends HttpServlet {

    private String value = "";
    private String department = "";
    /*
     * Option 1: contact
     * Option 2: turning
     * Option 3: contactCompany
     */
    private String filterSearch = "";

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
            throws ServletException, IOException {
        this.value = (new Utilities().stringIsNullOrEmpty(request.getParameter("value")) ? "" : request.getParameter("value"));
        this.department = (new Utilities().stringIsNullOrEmpty(request.getParameter("department")) ? "" : request.getParameter("department"));
        this.filterSearch = (new Utilities().stringIsNullOrEmpty(request.getParameter("filterSearch")) ? "Invalid" : request.getParameter("filterSearch"));

        if (this.filterSearch.equals("contact")) {
            //Buscamos por nombre de contacto
        } else if (this.filterSearch.equals("turning")) {
            //Buscamos por giro de empresa
        } else if (this.filterSearch.equals("contactCompany")) {
            //Buscamos por nombre de contacto de compañia
        } else {
            System.out.println("No se ha recibido ningun filtro de busqueda");
        }
        System.out.println(this);
        request.setAttribute("value", this.value);

        RequestDispatcher a = request.getRequestDispatcher("search.jsp");
        a.forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getFilterSearch() {
        return filterSearch;
    }

    public void setFilterSearch(String filterSearch) {
        this.filterSearch = filterSearch;
    }

    @Override
    public String toString() {
        return "Search{" + "value=" + value + ", department=" + department + ", filterSearch=" + filterSearch + '}';
    }
}
