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
public class Phone implements Serializable {

    private int id;
    private Contact contact;
    private Description description;
    private String number;
    private boolean verified;
    private boolean correct;
    private boolean searchable;
    private String comments;
    private AccesoDatos oAD;

    public Phone() {
    }

    public Phone(int id, Contact contacts, Description descriptions, String number, boolean verified, boolean correct, boolean searchable, String comments) {
        this.id = id;
        this.contact = contacts;
        this.description = descriptions;
        this.number = number;
        this.verified = verified;
        this.correct = correct;
        this.searchable = searchable;
        this.comments = comments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public boolean isSearchable() {
        return searchable;
    }

    public void setSearchable(boolean searchable) {
        this.searchable = searchable;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public AccesoDatos getAD() {
        return oAD;
    }

    public void setAD(AccesoDatos oAD) {
        this.oAD = oAD;
    }

    @Override
    public String toString() {
        return "Phones{" + "id=" + id + ", contacts=" + contact + ", descriptions=" + description + ", number=" + number + ", verified=" + verified + ", correct=" + correct + ", searchable=" + searchable + ", comments=" + comments + '}';
    }
}
