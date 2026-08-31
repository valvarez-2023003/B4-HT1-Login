/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.victoralvarez.system.service;

import org.victoralvarez.system.model.Users;
import org.victoralvarez.system.repository.AuthenticationRepository;

/**
 *
 * @author victo
 */
public class AuthenticationService {

    private AuthenticationRepository authRepository = new AuthenticationRepository();
    private UserService userService = new UserService();

    public AuthenticationService() {
    }

    public AuthStatus login(String userOrEmail, String password) {
        if (userOrEmail == null || userOrEmail.isBlank() || password == null || password.isBlank()) {
            return AuthStatus.FIELDS_EMPTY;
        }

        // 1. Validar primero si el usuario/email existe en la BD usando UserService
        boolean userExists = userService.existsUserOrEmail(userOrEmail);
        if (!userExists) {
            return AuthStatus.USER_NOT_FOUND;
        }

        // 2. Si existe, intenta hacer la autenticación con la contraseña
        Users user = authRepository.login(userOrEmail, password);
        if (user == null) {
            return AuthStatus.INVALID_PASSWORD;
        }

        return AuthStatus.SUCCESS;
    }
}