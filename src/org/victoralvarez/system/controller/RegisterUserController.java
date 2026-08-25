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
import javafx.scene.input.MouseEvent;
import org.victoralvarez.system.utils.ViewFactory;

public class RegisterUserController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
    
    @FXML
    public void onCancel(MouseEvent event){
        ViewFactory viewFacto = new ViewFactory();
        viewFacto.viewLogin();
    }
}
