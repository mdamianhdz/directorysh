/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sanatoriohuerta.modelbeans;

import com.sanatoriohuerta.AD.AccesoDatos;
import java.io.Serializable;
import java.util.Vector;

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
    private String sMsjQuery;
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

    public boolean searchPhone() throws Exception {
        boolean encontrado = false;
        Vector rst = null;
        String sQuery = "";
        if (this.number.equals("")) {
            throw new Exception("Phone.searchPhone: error de programación, faltan datos");
        } else {
            sQuery = "SELECT p.id, p.\"number\", p.verified, p.correct, p.searchable FROM Phones p WHERE p.\"number\"='" + this.number + "'";
            if (getAD() == null) {
                setAD(new AccesoDatos());
                getAD().conectar();
                rst = getAD().ejecutarConsulta(sQuery);
                getAD().desconectar();
                setAD(null);
            } else {
                rst = getAD().ejecutarConsulta(sQuery);
            }
            if (rst == null || rst.isEmpty()) {
                this.sMsjQuery = "No se encontraron numeros registrados";
            } else {
                this.sMsjQuery = "" + rst.get(0);
                if (this.sMsjQuery.indexOf("ERROR") > 0) {
                    encontrado = false;
                } else {
                    encontrado = true;
                    Vector vRowTemp = (Vector) rst.elementAt(0);
                    this.setId(((Double) vRowTemp.elementAt(0)).intValue());
                    this.setNumber((String) vRowTemp.elementAt(1));
                    this.setVerified(new Utilities().CharacterToBoolean((String) vRowTemp.elementAt(2)));
                    this.setCorrect(new Utilities().CharacterToBoolean((String) vRowTemp.elementAt(3)));
                    this.setSearchable(new Utilities().CharacterToBoolean((String) vRowTemp.elementAt(4)));
                }
            }
        }
        return encontrado;
    }

    public boolean addPhoneFromDirectCall(int contactID, int descriptionID) throws Exception {
        Vector rst = null;
        String sQuery = "";
        boolean rstQ = true;
        if (descriptionID == 0 || this.number.equals("")) {
            throw new Exception("Phone.addPhoneFromDirectCall: Error de programación. Faltan datos.");
        } else {
            sQuery = "SELECT * FROM addPhoneFromDirectCall(" + contactID + "," + descriptionID + ",'" + this.number + "',false, '" + this.comments + "' );";
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
        return rstQ;
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

    public String getsMsjQuery() {
        return sMsjQuery;
    }

    public void setsMsjQuery(String sMsjQuery) {
        this.sMsjQuery = sMsjQuery;
    }

    @Override
    public String toString() {
        return "Phone{" + "id=" + id + ", contact=" + contact + ", description=" + description + ", number=" + number + ", verified=" + verified + ", correct=" + correct + ", searchable=" + searchable + ", comments=" + comments + ", sMsjQuery=" + sMsjQuery + ", oAD=" + oAD + '}';
    }
}
