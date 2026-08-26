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
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
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
        boolean isValidEmail = validate.validarEmail(txtEmail.getText().trim());
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
               if (validate.validateLengthText(user, 25)
                || validate.validateLengthText(name, 50)
                || validate.validateLengthText(lastName, 50)
                || validate.validateLengthText(email, 50)
                || validate.validateLengthText(password, 50)) {
        
            
}
    }
    
 
        }

