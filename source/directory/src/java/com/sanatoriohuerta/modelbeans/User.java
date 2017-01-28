/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sanatoriohuerta.modelbeans;

import com.sanatoriohuerta.AD.AccesoDatos;
import java.io.Serializable;
import java.util.Vector;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Angel
 */
public class User implements Serializable {

    private int id;
    private String name;
    private String lastname;
    private String user;
    private String password;
    private boolean active;
    private Usertype usertype;
    private AccesoDatos oAD;
    private String sMsjQuery;

    public User() {
        this.user = "";
        this.password = "";
    }

    public User(int id, String name, String lastname, String user, String password, boolean active, Usertype userstype) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.user = user;
        this.password = password;
        this.active = active;
        this.usertype = userstype;
    }

    public boolean searchUserForLogin() throws Exception {
        boolean encontrado = false;
        Utilities utilities = new Utilities();
        User user = null;
        Vector rst = null;
        String sQuery = "";
        if (this.user.equals("") || this.password.equals("")) {
            throw new Exception("User.searchUserForLogin: error de programación, faltan datos");
        } else {
            sQuery = "SELECT * FROM SearchUserLogin('" + this.user + "','" + this.password + "');";
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
                this.sMsjQuery = "No tiene permisos de ingreso";
            } else {
                this.sMsjQuery = "" + rst.get(0);
                if (this.sMsjQuery.indexOf("ERROR") > 0) {
                    encontrado = false;
                } else {
                    encontrado = true;
                    user = new User();
                    Vector vRowTemp = (Vector) rst.elementAt(0);
                    this.setId(((Double) vRowTemp.elementAt(0)).intValue());
                    this.setName((String) vRowTemp.elementAt(1));
                    this.setLastname((String) vRowTemp.elementAt(2));
                    this.setUser((String) vRowTemp.elementAt(3));
                    this.setActive(utilities.CharacterToBoolean((String) vRowTemp.elementAt(4)));
                    this.setUsertype(new Usertype());
                    this.getUsertype().setId(((Double) vRowTemp.elementAt(5)).intValue());
                    this.getUsertype().setName((String) vRowTemp.elementAt(6));
                    this.getUsertype().setUpdateContacts(utilities.CharacterToBoolean((String) vRowTemp.elementAt(7)));
                    this.getUsertype().setCreateContacts(utilities.CharacterToBoolean((String) vRowTemp.elementAt(8)));
                    this.getUsertype().setDeleteContacts(utilities.CharacterToBoolean((String) vRowTemp.elementAt(9)));
                    this.getUsertype().setQueryContacts(utilities.CharacterToBoolean((String) vRowTemp.elementAt(10)));
                    this.getUsertype().setUpdatePhones(utilities.CharacterToBoolean((String) vRowTemp.elementAt(11)));
                    this.getUsertype().setCreatePhones(utilities.CharacterToBoolean((String) vRowTemp.elementAt(12)));
                    this.getUsertype().setDeletePhones(utilities.CharacterToBoolean((String) vRowTemp.elementAt(13)));
                    this.getUsertype().setQueryPhones(utilities.CharacterToBoolean((String) vRowTemp.elementAt(14)));
                    this.getUsertype().setUpdateUsers(utilities.CharacterToBoolean((String) vRowTemp.elementAt(15)));
                    this.getUsertype().setCreateUsers(utilities.CharacterToBoolean((String) vRowTemp.elementAt(16)));
                    this.getUsertype().setDeleteUsers(utilities.CharacterToBoolean((String) vRowTemp.elementAt(17)));
                    this.getUsertype().setQueryUsers(utilities.CharacterToBoolean((String) vRowTemp.elementAt(18)));
                    this.getUsertype().setUpdateDepartments(utilities.CharacterToBoolean((String) vRowTemp.elementAt(19)));
                    this.getUsertype().setCreateDepartments(utilities.CharacterToBoolean((String) vRowTemp.elementAt(20)));
                    this.getUsertype().setDeleteDepartments(utilities.CharacterToBoolean((String) vRowTemp.elementAt(21)));
                    this.getUsertype().setQueryDepartments(utilities.CharacterToBoolean((String) vRowTemp.elementAt(22)));
                    this.getUsertype().setUpdateConfiguration(utilities.CharacterToBoolean((String) vRowTemp.elementAt(23)));
                    this.getUsertype().setQueryReports(utilities.CharacterToBoolean((String) vRowTemp.elementAt(24)));
                }
            }
        }
        return encontrado;
    }

    public User getUserSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return (User) session.getAttribute("usuarioSesion");
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Usertype getUsertype() {
        return usertype;
    }

    public void setUsertype(Usertype usertype) {
        this.usertype = usertype;
    }

    public AccesoDatos getAD() {
        return oAD;
    }

    public void setAD(AccesoDatos oAD) {
        this.oAD = oAD;
    }

    public String getMsjQuery() {
        return sMsjQuery;
    }

    public void setMsjQuery(String sMsjQuery) {
        this.sMsjQuery = sMsjQuery;
    }

    @Override
    public String toString() {
        return "Users{" + "id=" + id + ", name=" + name + ", lastname=" + lastname + ", user=" + user + ", password=" + password + ", active=" + active + ", userstype=" + usertype + '}';
    }
}
