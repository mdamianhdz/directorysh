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
public class Contact implements Serializable {

    private int id;
    private String name;
    private String address;
    private String email;
    private String photo;
    private boolean active;
    private String typePerson;//Persona moral o fisica
    private Company company;
    private AccesoDatos oAD;

    public Contact() {
    }

    public Contact(int id, String name, String address, String email, String photo, boolean active, String typePerson, Company company) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.photo = photo;
        this.active = active;
        this.typePerson = typePerson;
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getTypePerson() {
        return typePerson;
    }

    public void setTypePerson(String typePerson) {
        this.typePerson = typePerson;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
    
    public AccesoDatos getAD() {
        return oAD;
    }

    public void setAD(AccesoDatos oAD) {
        this.oAD = oAD;
    }


    @Override
    public String toString() {
        return "Contact{" + "id=" + id + ", name=" + name + ", address=" + address + ", email=" + email + ", photo=" + photo + ", active=" + active + ", typePerson=" + typePerson + ", company=" + company + '}';
    }
}
