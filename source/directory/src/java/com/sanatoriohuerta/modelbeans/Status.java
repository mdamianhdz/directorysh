/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sanatoriohuerta.modelbeans;

import com.sanatoriohuerta.AD.AccesoDatos;
import java.io.Serializable;

/**
 *
 * @author Angel
 */
public class Status implements Serializable {

    private int id;
    private String description;
    private AccesoDatos oAD;

    public Status() {
    }

    public Status(int id, String description, AccesoDatos oAD) {
        this.id = id;
        this.description = description;
        this.oAD = oAD;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AccesoDatos getAD() {
        return oAD;
    }

    public void setAD(AccesoDatos oAD) {
        this.oAD = oAD;
    }

    @Override
    public String toString() {
        return "Status{" + "id=" + id + ", description=" + description + ", oAD=" + oAD + '}';
    }
}
