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
public class Configuration implements Serializable {

    private int id;
    private String version;
    private Date date;
    private String logo;
    private boolean active;
    private AccesoDatos oAD;

    public Configuration() {
    }

    public Configuration(int id, String version, Date date, String logo, boolean active) {
        this.id = id;
        this.version = version;
        this.date = date;
        this.logo = logo;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public AccesoDatos getAD() {
        return oAD;
    }

    public void setAD(AccesoDatos oAD) {
        this.oAD = oAD;
    }

    @Override
    public String toString() {
        return "Configuration{" + "id=" + id + ", version=" + version + ", date=" + date + ", logo=" + logo + ", active=" + active + '}';
    }
}
