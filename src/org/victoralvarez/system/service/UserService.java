/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.victoralvarez.system.service;

import org.victoralvarez.system.model.Users;
import org.victoralvarez.system.repository.UserRepository;
import org.victoralvarez.system.utils.AlertInformation;
import org.victoralvarez.system.utils.Validations;

/**
 *
 * @author informatica
 */
public class UserService {
        private Validations validate = new Validations();
    private AlertInformation alertInfo = new AlertInformation();
    private UserRepository userRepo = new UserRepository();

    public UserStatus createUser(String user, String name, String lastName, String email, String password){
        if (validate.emtyText(user) == true
                || validate.emtyText(name) == true
                || validate.emtyText(lastName) == true
                || validate.emtyText(email) == true
                || validate.emtyText(password) == true) {
            alertInfo.viewAlert("ERROR", "ERROR DE CAMPOS VACIOS", "ERROR DE CAMPO", "DEJO CAMPOS VACIOS DEL FORMULARIO");
            return UserStatus.FIELDS_EMPTY;
        }
        try{
            Users newUser = new Users(password, email, name, lastName, user);
            userRepo.create(newUser);
            return UserStatus.USER_CREATED;
        }catch(Exception e){
            return UserStatus.ERROR_USER_CREATE;
        }
    }
}
