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
public class Correction implements Serializable {

    private int id;
    private Phone phone;
    private User user;
    private boolean active;
    private String comments;
    private Date date;
    private AccesoDatos oAD;

    public Correction() {
    }

    public Correction(int id, Phone phones, User users, boolean active, String comments, Date date) {
        this.id = id;
        this.phone = phones;
        this.user = users;
        this.active = active;
        this.comments = comments;
        this.date = date;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public AccesoDatos getAD() {
        return oAD;
    }

    public void setAD(AccesoDatos oAD) {
        this.oAD = oAD;
    }

    @Override
    public String toString() {
        return "Corrections{" + "id=" + id + ", phones=" + phone + ", users=" + user + ", active=" + active + ", comments=" + comments + ", date=" + date + '}';
    }
}
