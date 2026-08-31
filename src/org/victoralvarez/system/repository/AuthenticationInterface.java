/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.victoralvarez.system.repository;

import org.victoralvarez.system.model.Users;

/**
 *
 * @author victo
 */
public interface AuthenticationInterface {
    Users login(String usernameOrEmail, String password);
}
