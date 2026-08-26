/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.victoralvarez.system.model;

/**
 *
 * @author informatica
 */
public class Users {

    /**
     * name lastname email user password idUser pk_users
     */
    private String name;
    private String lastname;
    private String email;
    private String user;
    private String password;
    private String idUser;

    public Users() {
    }

    public Users(String idUser, String email, String name, String lastname, String password, String user) {
        this.idUser = idUser;
        this.email = email;
        this.name = name;
        this.lastname = lastname;
        this.password = password;
        this.user = user;

    }

    public Users(String password, String email, String name, String lastname, String user) {
        this.password = password;
        this.email = email;
        this.name = name;
        this.lastname = lastname;
        this.user = user;
    }

    //constructores
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

}
