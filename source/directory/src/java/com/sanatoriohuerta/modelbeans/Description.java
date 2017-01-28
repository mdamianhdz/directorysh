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
public class Description implements Serializable {

    private int id;
    private String name;
    private String format;
    private AccesoDatos oAD;

    public Description() {
    }

    public Description(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Description[] searchAllDescriptions() throws Exception {
        Description arrRet[] = null;
        Description description = null;
        Vector rst = null;
        Vector<Description> vObj = null;
        String sQuery = "";
        int i = 0, nTam = 0;

        sQuery = "SELECT d.id, d.name, d.format FROM Descriptions d ORDER BY d.id;";
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
            vObj = new Vector<Description>();
            for (i = 0; i < rst.size(); i++) {
                Vector vRowTemp = (Vector) rst.elementAt(i);
                description = new Description();
                description.setId(((Double) vRowTemp.elementAt(0)).intValue());
                description.setName((String) vRowTemp.elementAt(1));
                description.setFormat((String) vRowTemp.elementAt(2));
                vObj.add(description);
            }
            nTam = vObj.size();
            arrRet = new Description[nTam];

            for (i = 0; i < nTam; i++) {
                arrRet[i] = vObj.elementAt(i);
            }
        }
        return arrRet;
    }

    public Description searchDescriptionByID() throws Exception {
        Description description = null;
        Vector rst = null;
        Vector<Description> vObj = null;
        String sQuery = "";

        sQuery = "SELECT d.id, d.name, d.format FROM Descriptions d WHERE d.id=" + this.id + ";";
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
            vObj = new Vector<Description>();
            Vector vRowTemp = (Vector) rst.elementAt(0);
            description = new Description();
            description.setId(((Double) vRowTemp.elementAt(0)).intValue());
            description.setName((String) vRowTemp.elementAt(1));
            description.setFormat((String) vRowTemp.elementAt(2));

        }
        return description;
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

    public AccesoDatos getAD() {
        return oAD;
    }

    public void setAD(AccesoDatos oAD) {
        this.oAD = oAD;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return "Description{" + "id=" + id + ", name=" + name + ", format=" + format + ", oAD=" + oAD + '}';
    }
}
