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

    public Boolean validateLengthText(String text, int lenghtMax) {
        return text.length() <= lenghtMax;
    }


    public Boolean validateEmail(String email) {
        int arrobeCount = 0;

        // 1. VALIDA QUE NO EXISTAN PUNTOS CONSECUTIVOS (..)
        for (int index = 0; index < email.length() - 1; index++) {
            if (email.charAt(index) == '.' && email.charAt(index + 1) == '.') {
                return false;
            }
        }

        // 2. VALIDA LA EXISTENCIA DE UN ÚNICO ARROBA
        for (int index = 0; index < email.length(); index++) {
            if (email.charAt(index) == '@') {
                arrobeCount++;
            }
        }

        // Si tiene más de un arroba o ninguno, es inválido
        if (arrobeCount != 1) {
            return false;
        }

        return true;
    }
}
