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

    public Localphone[] searchAllLocalPhone() throws Exception {
        Localphone arrRet[] = null, oLocPh = null;
        Description description = null;
        Vector rst = null;
        Vector<Localphone> vObj = null;
        String sQuery = "";
        int i = 0, nTam = 0;

        sQuery = "SELECT lp.id, lp.number, d.id, d.name, d.format FROM localphones lp JOIN Descriptions d ON lp.descriptionid=d.id ORDER BY lp.id;";
        if (getAD() == null) {
            setAD(new AccesoDatos());
            getAD().conectar();
            rst = getAD().ejecutarConsulta(sQuery);
            getAD().desconectar();
            setAD(null);
        } else {
            rst = getAD().ejecutarConsulta(sQuery);
        }

        if (rst != null) {
            vObj = new Vector<Localphone>();
            for (i = 0; i < rst.size(); i++) {
                oLocPh = new Localphone();
                Vector vRowTemp = (Vector) rst.elementAt(i);
                oLocPh.setId(((Double) vRowTemp.elementAt(0)).intValue());
                oLocPh.setNumber((String) vRowTemp.elementAt(1));
                description = new Description();
                description.setId(((Double) vRowTemp.elementAt(2)).intValue());
                description.setName((String) vRowTemp.elementAt(3));
                description.setFormat((String) vRowTemp.elementAt(4));
                oLocPh.setDescription(description);
                vObj.add(oLocPh);
            }
            nTam = vObj.size();
            arrRet = new Localphone[nTam];

            for (i = 0; i < nTam; i++) {
                arrRet[i] = vObj.elementAt(i);
            }
        }
        return arrRet;
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
