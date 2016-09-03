/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sanatoriohuerta.AD.modelbeans;

import com.sanatoriohuerta.AD.AccesoDatos;
import java.io.Serializable;

/**
 *
 * @author Angel
 */
public class Localphone implements Serializable {

    private int id;
    private String number;
    private Description description;
    private AccesoDatos oAD;

    public Localphone() {
    }

    public Localphone(int id, String number, Description descriptions) {
        this.id = id;
        this.number = number;
        this.description = descriptions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
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
        return "Localphones{" + "id=" + id + ", number=" + number + ", descriptions=" + description + '}';
    }
}
