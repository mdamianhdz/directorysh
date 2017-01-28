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
public class Department implements Serializable {

    private int id;
    private String name;
    private AccesoDatos oAD;

    public Department() {
    }

    public Department[] searchByUserPermission(int userid) throws Exception {
        Department arrRet[] = null, oDep = null;
        Vector rst = null;
        Vector<Department> vObj = null;
        String sQuery = "";
        int i = 0, nTam = 0;

        sQuery = "SELECT d.id, d.name FROM \"users-departments\" ud  JOIN Departments d ON ud.departmentid=d.id WHERE userid=" + userid + " ORDER BY d.id ;";
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
            vObj = new Vector<Department>();
            for (i = 0; i < rst.size(); i++) {
                oDep = new Department();
                Vector vRowTemp = (Vector) rst.elementAt(i);
                oDep.setId(((Double) vRowTemp.elementAt(0)).intValue());
                oDep.setName((String) vRowTemp.elementAt(1));
                vObj.add(oDep);
            }
            nTam = vObj.size();
            arrRet = new Department[nTam];

            for (i = 0; i < nTam; i++) {
                arrRet[i] = vObj.elementAt(i);
            }
        }
        return arrRet;
    }

    public Department(int id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "Departments{" + "id=" + id + ", name=" + name + '}';
    }
}
