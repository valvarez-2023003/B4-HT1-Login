/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.victoralvarez.system.controller;

/**
 *
 * @author informatica
 */
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.victoralvarez.system.service.UserService;
import org.victoralvarez.system.service.UserStatus;
import org.victoralvarez.system.utils.AlertInformation;
import org.victoralvarez.system.utils.Validations;
import org.victoralvarez.system.utils.ViewFactory;

public class RegisterUserController implements Initializable {

    @FXML
    private TextField txtUser;
    @FXML
    private TextField txtName;

    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField pwdPassword;
    @FXML
    private PasswordField pwdConfirmPassword;

    private Validations validate = new Validations();
    private AlertInformation alertInfo = new AlertInformation();
    private UserService userService = new UserService();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    public void onCancel(MouseEvent event) {
        ViewFactory viewFacto = new ViewFactory();
        viewFacto.viewLogin();
    }

    @FXML
    public void onCreateUser(MouseEvent event) {
        boolean isValidEmail = validate.validateEmail(txtEmail.getText().trim());
        if (isValidEmail == false) {
            alertInfo.viewAlert("ERROR", "ERROR EMAIL", "ERROR DE CAMPO", "HAS INGRESADO UN EMAIL INCORRECTO");
            return;

        }
        String user, name, lastName, email, password, confirmPassword;
        user = txtUser.getText().trim();
        name = txtName.getText().trim();
        lastName = txtLastName.getText().trim();
        email = txtEmail.getText().trim();
        password = pwdPassword.getText().trim();
        confirmPassword = pwdConfirmPassword.getText().trim();

        if (validate.emtyText(user) == true
                || validate.emtyText(name) == true
                || validate.emtyText(lastName) == true
                || validate.emtyText(email) == true
                || validate.emtyText(password) == true
                || validate.emtyText(confirmPassword) == true) {
            alertInfo.viewAlert("ERROR", "ERROR DE CAMPOS VACIOS", "ERROR DE CAMPO", "DEJO CAMPOS VACIOS DEL FORMULARIO");
            return;
        }
        String msgField = "";
        if (validate.validateLengthText(user, 25) == false) {
            msgField = "EL CAMPO USUARIO ES MAYOR A 25 CARACTERES";

        }
        if (validate.validateLengthText(name, 50) == false) {
            msgField = "EL CAMPO NAME ES MAYOR A 50 CARACTERES";

        }
        if (validate.validateLengthText(lastName, 50) == false) {
            msgField = "EL CAMPO LASTNAME ES MAYOR A 50 CARACTERES";
        }
        if (validate.validateLengthText(email, 50) == false) {
            msgField = "EL CAMPO EMAIL ES MAYOR A 50 CARACTERES";
        }
        if (validate.validateLengthText(password, 35) == false) {
            msgField = "EL CAMPO PASSWORD ES MAYOR A 35 CARACTERES";
        }
        if (msgField.isEmpty() == false) {
            alertInfo.viewAlert("ERROR", "ERROR DE CAMPO", "ERROR", msgField);
            return;
        }
        if (validate.equalsText(password, confirmPassword) == false) {
            alertInfo.viewAlert("ERROR", "ERROR DE CONTRASEÑAS", "ERROR", "SUS CONTRASEÑAS NO COINCIDEN");
            return;
        }
        UserStatus status = userService.createUser(user, name, lastName, email, password);
        switch (status) {
            case UserStatus.ERROR_USER_CREATE ->
                alertInfo.viewAlert("ERROR", "ERROR EN BD", "ERROR", "NO SE PUDO CREAR EL USUARIO EN LA BASE DE DATOS");
            case UserStatus.USER_CREATED -> {
                alertInfo.viewAlert("INFORMACION", "USUARIO CREADO", "EXITO", "EL USUARIO SE HA REGISTRADO CORRECTAMENTE");
                ViewFactory viewFactory = new ViewFactory();
                viewFactory.viewLogin();
            }
            case UserStatus.FIELDS_EMPTY ->
                System.out.println("LOS CAMPOS NO ESTAN VACIOS");
            case UserStatus.VALUE_LENGHT_INVALID ->
                System.out.println("VALIDAR LONGITUDES DE TEXTO");

            default ->
                System.out.println("ERROR DESCONOCIDO");
        }
    }

}
