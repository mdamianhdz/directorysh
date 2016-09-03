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
public class User implements Serializable {

    private int id;
    private String name;
    private String lastname;
    private String user;
    private String password;
    private boolean active;
    private Usertype usertype;
    private AccesoDatos oAD;

    public User() {
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

    @Override
    public String toString() {
        return "Users{" + "id=" + id + ", name=" + name + ", lastname=" + lastname + ", user=" + user + ", password=" + password + ", active=" + active + ", userstype=" + usertype + '}';
    }
}
