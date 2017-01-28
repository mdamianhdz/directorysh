/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sanatoriohuerta.modelbeans;

import com.sanatoriohuerta.AD.AccesoDatos;
import java.io.Serializable;

/**
 *
 * @author Angel
 */
public class Usertype implements Serializable {

    private int id;
    private String name;
    private boolean updateContacts;
    private boolean updatePhones;
    private boolean updateUsers;
    private boolean updateDepartments;
    private boolean updateConfiguration;
    private boolean createContacts;
    private boolean createPhones;
    private boolean createUsers;
    private boolean createDepartments;
    private boolean deleteContacts;
    private boolean deletePhones;
    private boolean deleteUsers;
    private boolean deleteDepartments;
    private boolean queryContacts;
    private boolean queryPhones;
    private boolean queryUsers;
    private boolean queryDepartments;
    private boolean queryReports;
    private AccesoDatos oAD;

    public Usertype() {
    }

    public Usertype(int id, String name, boolean updateContacts, boolean updatePhones, boolean updateUsers, boolean updateDepartments, boolean updateConfiguration, boolean createContacts, boolean createPhones, boolean createUsers, boolean createDepartments, boolean deleteContacts, boolean deletePhones, boolean deleteUsers, boolean deleteDepartments, boolean queryContacts, boolean queryPhones, boolean queryUsers, boolean queryDepartments, boolean queryReports) {
        this.id = id;
        this.name = name;
        this.updateContacts = updateContacts;
        this.updatePhones = updatePhones;
        this.updateUsers = updateUsers;
        this.updateDepartments = updateDepartments;
        this.updateConfiguration = updateConfiguration;
        this.createContacts = createContacts;
        this.createPhones = createPhones;
        this.createUsers = createUsers;
        this.createDepartments = createDepartments;
        this.deleteContacts = deleteContacts;
        this.deletePhones = deletePhones;
        this.deleteUsers = deleteUsers;
        this.deleteDepartments = deleteDepartments;
        this.queryContacts = queryContacts;
        this.queryPhones = queryPhones;
        this.queryUsers = queryUsers;
        this.queryDepartments = queryDepartments;
        this.queryReports = queryReports;
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

    public boolean isUpdateContacts() {
        return updateContacts;
    }

    public void setUpdateContacts(boolean updateContacts) {
        this.updateContacts = updateContacts;
    }

    public boolean isUpdatePhones() {
        return updatePhones;
    }

    public void setUpdatePhones(boolean updatePhones) {
        this.updatePhones = updatePhones;
    }

    public boolean isUpdateUsers() {
        return updateUsers;
    }

    public void setUpdateUsers(boolean updateUsers) {
        this.updateUsers = updateUsers;
    }

    public boolean isUpdateDepartments() {
        return updateDepartments;
    }

    public void setUpdateDepartments(boolean updateDepartments) {
        this.updateDepartments = updateDepartments;
    }

    public boolean isUpdateConfiguration() {
        return updateConfiguration;
    }

    public void setUpdateConfiguration(boolean updateConfiguration) {
        this.updateConfiguration = updateConfiguration;
    }

    public boolean isCreateContacts() {
        return createContacts;
    }

    public void setCreateContacts(boolean createContacts) {
        this.createContacts = createContacts;
    }

    public boolean isCreatePhones() {
        return createPhones;
    }

    public void setCreatePhones(boolean createPhones) {
        this.createPhones = createPhones;
    }

    public boolean isCreateUsers() {
        return createUsers;
    }

    public void setCreateUsers(boolean createUsers) {
        this.createUsers = createUsers;
    }

    public boolean isCreateDepartments() {
        return createDepartments;
    }

    public void setCreateDepartments(boolean createDepartments) {
        this.createDepartments = createDepartments;
    }

    public boolean isDeleteContacts() {
        return deleteContacts;
    }

    public void setDeleteContacts(boolean deleteContacts) {
        this.deleteContacts = deleteContacts;
    }

    public boolean isDeletePhones() {
        return deletePhones;
    }

    public void setDeletePhones(boolean deletePhones) {
        this.deletePhones = deletePhones;
    }

    public boolean isDeleteUsers() {
        return deleteUsers;
    }

    public void setDeleteUsers(boolean deleteUsers) {
        this.deleteUsers = deleteUsers;
    }

    public boolean isDeleteDepartments() {
        return deleteDepartments;
    }

    public void setDeleteDepartments(boolean deleteDepartments) {
        this.deleteDepartments = deleteDepartments;
    }

    public boolean isQueryContacts() {
        return queryContacts;
    }

    public void setQueryContacts(boolean queryContacts) {
        this.queryContacts = queryContacts;
    }

    public boolean isQueryPhones() {
        return queryPhones;
    }

    public void setQueryPhones(boolean queryPhones) {
        this.queryPhones = queryPhones;
    }

    public boolean isQueryUsers() {
        return queryUsers;
    }

    public void setQueryUsers(boolean queryUsers) {
        this.queryUsers = queryUsers;
    }

    public boolean isQueryDepartments() {
        return queryDepartments;
    }

    public void setQueryDepartments(boolean queryDepartments) {
        this.queryDepartments = queryDepartments;
    }

    public AccesoDatos getAD() {
        return oAD;
    }

    public void setAD(AccesoDatos oAD) {
        this.oAD = oAD;
    }

    public boolean getQueryReports() {
        return queryReports;
    }

    public void setQueryReports(boolean queryReports) {
        this.queryReports = queryReports;
    }

    @Override
    public String toString() {
        return "Usertype{" + "id=" + id + ", name=" + name + ", updateContacts=" + updateContacts + ", updatePhones=" + updatePhones + ", updateUsers=" + updateUsers + ", updateDepartments=" + updateDepartments + ", updateConfiguration=" + updateConfiguration + ", createContacts=" + createContacts + ", createPhones=" + createPhones + ", createUsers=" + createUsers + ", createDepartments=" + createDepartments + ", deleteContacts=" + deleteContacts + ", deletePhones=" + deletePhones + ", deleteUsers=" + deleteUsers + ", deleteDepartments=" + deleteDepartments + ", queryContacts=" + queryContacts + ", queryPhones=" + queryPhones + ", queryUsers=" + queryUsers + ", queryDepartments=" + queryDepartments + ", queryReports=" + queryReports + ", oAD=" + oAD + '}';
    }
}
