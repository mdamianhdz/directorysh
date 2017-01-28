/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sanatoriohuerta.modelbeans;

import com.sanatoriohuerta.AD.AccesoDatos;
import java.io.Serializable;
import java.util.Date;
import java.util.Vector;

/**
 *
 * @author Angel
 */
public class Configuration implements Serializable {

    private int id;
    private String version;
    private Date date;
    private String logo;
    private boolean active;
    private AccesoDatos oAD;

    public Configuration() {
    }

    public Configuration(int id, String version, Date date, String logo, boolean active) {
        this.id = id;
        this.version = version;
        this.date = date;
        this.logo = logo;
        this.active = active;
    }

    public Configuration getConfiguration() throws Exception {
        Configuration configuration = new Configuration();
        Vector rst = null;
        String sQuery = "SELECT * FROM Configuration WHERE Active=TRUE ORDER BY Date DESC lIMIT 1;";
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
            System.out.println("Ha ocurrido un error al obtener los datos de configuracion. Intente mas tarde");
        } else {
            Vector vRowTemp = (Vector) rst.elementAt(0);
            configuration.setId(((Double) vRowTemp.elementAt(0)).intValue());
            configuration.setVersion((String) vRowTemp.elementAt(1));
            configuration.setDate((Date) vRowTemp.elementAt(2));
            configuration.setLogo((String) vRowTemp.elementAt(3));
            configuration.setActive(new Utilities().CharacterToBoolean((String) vRowTemp.elementAt(4)));
        }
        return configuration;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
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
        return "Configuration{" + "id=" + id + ", version=" + version + ", date=" + date + ", logo=" + logo + ", active=" + active + '}';
    }
}
