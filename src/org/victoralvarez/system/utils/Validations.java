/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.victoralvarez.system.utils;

/**
 *
 * @author informatica
 */
public class Validations {

    public Validations() {

    }

    public Boolean equalsText(String textOriginal, String textCompare) {
        return textOriginal.equals(textCompare);
    }

    public Boolean emtyText(String text) {
        boolean isEmpty = false;
        if (text.isEmpty() || text.isBlank()) {
            isEmpty = true;
        }
        return isEmpty;
    }
    
    public Boolean validarLenghtText(String text, int lenghtMax){
return text.length() <= lenghtMax;
    }
    public Boolean validarEmail(String Email){
        return true;
    }
}
