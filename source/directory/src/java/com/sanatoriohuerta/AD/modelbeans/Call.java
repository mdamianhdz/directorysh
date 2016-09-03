/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sanatoriohuerta.AD.modelbeans;

import com.sanatoriohuerta.AD.AccesoDatos;
import java.io.Serializable;
import java.util.Date;

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
    private AccesoDatos oAD;

    public Call() {
    }

    public Call(int id, Phone phone, User user, Localphone localphone, boolean done, Date date, String comments, String requested) {
        this.id = id;
        this.phone = phone;
        this.user = user;
        this.localphone = localphone;
        this.done = done;
        this.date = date;
        this.comments = comments;
        this.requested = requested;
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

    @Override
    public String toString() {
        return "Call{" + "id=" + id + ", phone=" + phone + ", user=" + user + ", localphone=" + localphone + ", done=" + done + ", date=" + date + ", comments=" + comments + ", requested=" + requested + '}';
    }
}
