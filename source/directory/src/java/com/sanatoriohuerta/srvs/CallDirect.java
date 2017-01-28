package com.sanatoriohuerta.srvs;

import com.sanatoriohuerta.modelbeans.Call;
import com.sanatoriohuerta.modelbeans.Description;
import com.sanatoriohuerta.modelbeans.Localphone;
import com.sanatoriohuerta.modelbeans.Phone;
import com.sanatoriohuerta.modelbeans.Status;
import com.sanatoriohuerta.modelbeans.User;
import com.sanatoriohuerta.modelbeans.Utilities;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Angel
 */
public class CallDirect extends HttpServlet {

    private String number = "";
    private String localPhone = "";
    private String requested = "";
    private String comments = "";
    private String description = "";
    private boolean callDone = false;
    private int status = 0;
    private String messageResponse = "";
    private static final String DATA_INCOMPLETE = false + "&Faltan datos requeridos&" + Utilities.ERROR;
    private static final String DATA_INVALIDATE = false + "&ERROR: Favor de verificar los datos ingresados&" + Utilities.ERROR;
    private static final String SUCCESS = true + "&Llamada registrada&" + Utilities.OK;
    private static final String FAILED_DATABASE = false + "&Ha ocurrido un error al registrar la informacion. Intenta mas tarde.&" + Utilities.WARNING;

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
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String tmp = "";

        if (new Utilities().stringIsNullOrEmpty(request.getParameter("numberP"))
                || new Utilities().stringIsNullOrEmpty(request.getParameter("localnumber"))
                || new Utilities().stringIsNullOrEmpty(request.getParameter("descriptions"))
                || new Utilities().stringIsNullOrEmpty(request.getParameter("requested"))
                || new Utilities().stringIsNullOrEmpty(request.getParameter("calldone"))) {
            this.messageResponse = DATA_INCOMPLETE;
        } else {
            this.number = request.getParameter("numberP");
            this.localPhone = request.getParameter("localnumber");
            this.description = request.getParameter("descriptions");
            this.requested = request.getParameter("requested");
            tmp = request.getParameter("calldone");
            if (tmp.equals("t")) {
                this.status = 1;
            } else if (tmp.equals("f")) {
                this.status = 2;
            } else if (tmp.equals("p")) {
                this.status = 3;
            } else {
                this.status = 3;
            }
            this.callDone = new Utilities().CharacterToBoolean(request.getParameter("calldone"));
            this.comments = (new Utilities().stringIsNullOrEmpty(request.getParameter("comments")) ? "N/A" : request.getParameter("comments"));
            /**
             * **
             * Registro en base de datos de la llamada
             *
             */
            System.out.println("convertNumber");
            Description d = new Description(Integer.parseInt(this.description), "");
            String tmpNmb = new Utilities().convertNumberWithFormatForBD(this.number, d.searchDescriptionByID().getFormat());
            if (new Utilities().stringIsNullOrEmpty(tmpNmb)) {
                this.messageResponse = DATA_INVALIDATE;
            } else {
                System.out.println("Number with format: " + tmpNmb);
                Phone p = new Phone();
                p.setNumber(tmpNmb);
                boolean searched = p.searchPhone();
                boolean added = true;
                if (!searched) {
                    p.setComments("Direct call");
                    added = p.addPhoneFromDirectCall(1, Integer.parseInt(this.description));
                }
                // this.getPhone().getId() + "," + this.getUser().getId() + "," + this.getLocalphone().getId() + "," + this.isDone() + ",'" + this.getComments() +
                //"', '" + this.getRequested() + "', " + this.getStatus().getId()
                //Objetos para solicitar la alta de llamada
                Localphone localphone = new Localphone();
                Call call = new Call();
                localphone.setId(Integer.parseInt(this.localPhone));
                Status s = new Status();
                s.setId(this.status);
                p.searchPhone();
                System.out.println("Searched: " + searched + " Object Phone: " + p);
                call.setPhone(p);
                call.setUser(new User().getUserSession(request));
                call.setLocalphone(localphone);
                call.setDone((this.status == 1) ? true : false);
                call.setComments(this.comments);
                call.setRequested(this.requested);
                call.setStatus(s);
                boolean callRegistered = call.addCall();

                System.out.println(new User().getUserSession(request));
                this.messageResponse = (added && callRegistered) ? SUCCESS : FAILED_DATABASE;
            }
        }
        System.out.println(this);
        out.println(this.messageResponse);
        out.close();
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
            Logger.getLogger(CallDirect.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CallDirect.class.getName()).log(Level.SEVERE, null, ex);
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getLocalPhone() {
        return localPhone;
    }

    public void setLocalPhone(String localPhone) {
        this.localPhone = localPhone;
    }

    public String getRequested() {
        return requested;
    }

    public void setRequested(String requested) {
        this.requested = requested;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getMessageResponse() {
        return messageResponse;
    }

    public void setMessageResponse(String messageResponse) {
        this.messageResponse = messageResponse;
    }

    public boolean isCallDone() {
        return callDone;
    }

    public void setCallDone(boolean callDone) {
        this.callDone = callDone;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CallDirect{" + "number=" + number + ", localPhone=" + localPhone + ", requested=" + requested + ", comments=" + comments + ", callDone=" + callDone + ", status=" + status + ", messageResponse=" + messageResponse + '}';
    }
}
