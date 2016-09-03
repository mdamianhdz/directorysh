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
public class Company implements Serializable {

    private int id;
    private Turning turning;
    private String name;
    private String businessName;
    private String contact;
    private AccesoDatos oAD;

    public Company(int id, Turning turning, String name, String businessName, String contact) {
        this.id = id;
        this.turning = turning;
        this.name = name;
        this.businessName = businessName;
        this.contact = contact;
    }

    public Company() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Turning getTurning() {
        return turning;
    }

    public void setTurning(Turning turning) {
        this.turning = turning;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public AccesoDatos getAD() {
        return oAD;
    }

    public void setAD(AccesoDatos oAD) {
        this.oAD = oAD;
    }

    @Override
    public String toString() {
        return "Company{" + "id=" + id + ", turning=" + turning + ", name=" + name + ", businessName=" + businessName + ", contact=" + contact + '}';
    }
}
