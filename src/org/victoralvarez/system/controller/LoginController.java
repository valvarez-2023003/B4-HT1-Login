/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.victoralvarez.system.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.victoralvarez.system.service.AuthStatus;
import org.victoralvarez.system.service.AuthenticationService;
import org.victoralvarez.system.utils.AlertInformation;
import org.victoralvarez.system.utils.Validations;
import org.victoralvarez.system.utils.ViewFactory;

/**
 *
 * @author informatica
 */
public class LoginController implements Initializable {

    @FXML
    private TextField txtUser;

    @FXML
    private PasswordField pwdPassword;

    private Validations validate = new Validations();
    private AlertInformation alertInfo = new AlertInformation();
    private AuthenticationService authService = new AuthenticationService();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    public void onLogin(MouseEvent event) {
        String user = txtUser.getText().trim();
        String password = pwdPassword.getText().trim();

        if (validate.emtyText(user) || validate.emtyText(password)) {
            alertInfo.viewAlert("ERROR", "CAMPOS VACIOS", "ERROR DE CAMPO", "POR FAVOR INGRESE USUARIO Y CONTRASEÑA");
            return;
        }

        AuthStatus status = authService.login(user, password);

        switch (status) {
            case USER_NOT_FOUND -> 
                alertInfo.viewAlert("ERROR", "USUARIO NO ENCONTRADO", "CUENTA INEXISTENTE", "EL USUARIO O EMAIL NO EXISTE, POR FAVOR REGÍSTRESE.");
            case INVALID_PASSWORD -> 
                alertInfo.viewAlert("ERROR", "CONTRASEÑA INCORRECTA", "ERROR DE AUTENTICACION", "LA CONTRASEÑA INGRESADA ES INCORRECTA.");
            case SUCCESS -> {
                alertInfo.viewAlert("INFORMACION", "BIENVENIDO", "LOGIN EXITOSO", "INICIO DE SESIÓN CORRECTO");
                ViewFactory viewFactory = new ViewFactory();
                viewFactory.viewDashboard();
            }
            default -> 
                System.out.println("ERROR DESCONOCIDO EN LOGIN");
        }
    }

    @FXML
    public void onRegister(MouseEvent event) {
        ViewFactory viewFactory = new ViewFactory();
        viewFactory.viewRegister();
    }
}
