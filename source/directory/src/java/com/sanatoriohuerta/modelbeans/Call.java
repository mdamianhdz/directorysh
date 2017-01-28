/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sanatoriohuerta.modelbeans;

import com.sanatoriohuerta.AD.AccesoDatos;
import java.io.Serializable;
import java.util.Date;
import java.util.Vector;

/**
 *
 * @author Angel
 */
public class Call implements Serializable {

    private int id;
    private Phone phone;
    private User user;
    private Localphone localphone;
    private boolean done;
    private Date date;
    private String comments;
    private String requested;
    private Status status;
    private AccesoDatos oAD;

    public Call() {
    }

    public Call(int id, Phone phone, User user, Localphone localphone, boolean done, Date date, String comments, String requested, Status status, AccesoDatos oAD) {
        this.id = id;
        this.phone = phone;
        this.user = user;
        this.localphone = localphone;
        this.done = done;
        this.date = date;
        this.comments = comments;
        this.requested = requested;
        this.status = status;
        this.oAD = oAD;
    }

    public boolean addCall() throws Exception {
        Vector rst = null;
        String sQuery = "";
        boolean rstQ = true;
        if (this.getPhone() == null || this.getUser() == null || this.getLocalphone() == null || this.getStatus() == null) {
            throw new Exception("Phone.addPhoneFromDirectCall: Error de programación. Faltan datos.");
        } else {
            sQuery = "SELECT * FROM addCall(" + this.getPhone().getId() + "," + this.getUser().getId() + "," + this.getLocalphone().getId() + "," + this.isDone() + ",'" + this.getComments() + "', '" + this.getRequested() + "', " + this.getStatus().getId() + ");";
            System.out.println(sQuery);
            if (getAD() == null) {
                setAD(new AccesoDatos());
                getAD().conectar();
                rst = getAD().ejecutarConsulta(sQuery);
                getAD().desconectar();
                setAD(null);
            }
        }
        if (rst == null || rst.indexOf("ERROR") > 0) {
            rstQ = false;
        }
        System.out.println("rstQ: " + rst);
        return rstQ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Localphone getLocalphone() {
        return localphone;
    }

    public void setLocalphone(Localphone localphone) {
        this.localphone = localphone;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getRequested() {
        return requested;
    }

    public void setRequested(String requested) {
        this.requested = requested;
    }

    public AccesoDatos getAD() {
        return oAD;
    }

    public void setAD(AccesoDatos oAD) {
        this.oAD = oAD;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Call{" + "id=" + id + ", phone=" + phone + ", user=" + user + ", localphone=" + localphone + ", done=" + done + ", date=" + date + ", comments=" + comments + ", requested=" + requested + ", status=" + status + ", oAD=" + oAD + '}';
    }
}
