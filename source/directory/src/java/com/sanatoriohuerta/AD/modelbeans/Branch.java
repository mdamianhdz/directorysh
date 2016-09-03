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
public class Branch implements Serializable {

    private int id;
    private Company company;
    private String name;
    private String schedule;
    private boolean active;
    private AccesoDatos oAD;

    public Branch() {
    }

    public Branch(int id, Company company, String name, String schedule, boolean active) {
        this.id = id;
        this.company = company;
        this.name = name;
        this.schedule = schedule;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
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
        return "Branchs{" + "id=" + id + ", company=" + company + ", name=" + name + ", schedule=" + schedule + ", active=" + active + '}';
    }
}
