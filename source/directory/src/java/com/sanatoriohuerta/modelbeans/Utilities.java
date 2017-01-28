/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sanatoriohuerta.modelbeans;

import java.io.Serializable;

/**
 *
 * @author Angel
 */
public class Utilities implements Serializable {

    public static final String WARNING = "alert-warning";
    public static final String OK = "alert-success";
    public static final String INFO = "alert-info";
    public static final String ERROR = "alert-danger";

    public Utilities() {
    }

    public boolean CharacterToBoolean(String bCharacter) {
        boolean bBooleano;
        if (bCharacter.equals("t")) {
            bBooleano = true;
        } else {
            bBooleano = false;
        }
        return bBooleano;
    }

    public String convertMsjDBForFrontend(String result) {
        int tmp = 0;
        tmp = result.indexOf(":");
        return result.substring(tmp + 1);
    }

    public boolean stringIsNullOrEmpty(String sVal) {
        boolean bRet = false;
        if (sVal == null || sVal.trim().equals("")) {
            bRet = true;
        }
        return bRet;
    }

    public boolean validateNumberWithFormatDB(String number, String format) {
        boolean validate = false;
        if (countCharacters(format, '#') == number.length() || format.equals("")) {
            validate = true;
        }
        return validate;
    }

    /*
     * Metodo para convertir un numero ingresado al formato para almacenar en la base de datos, dependiendo del tipo
     * de numero seleccionado es el formato que se le dara, mismo que ya se encuentra registrado en la BD
     */
    public String convertNumberWithFormatForBD(String number, String format) {
        String tmp = "";
        int indexNumber = 0;
        if (countCharacters(format, '#') == number.length() || format.equals("")) {
            for (int i = 0; i < format.length(); i++) {
                if (format.charAt(i) != '#') {
                    tmp += format.charAt(i);
                } else {
                    tmp += number.charAt(indexNumber);
                    indexNumber++;
                }
            }
            tmp = (format.length() == 0) ? number : tmp;
        }
        return tmp;
    }

    /*
     * Metodo para obtener el numero registrado en la base de datos sin el formato
     * Esto sera util para realizar la consulta de algun numero almacenado
     * En la mayoria de los casos para el registro de llamadas directas
     */
    public String convertNumberFromDB(String number) {
        String rst = "";
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) != '-' || number.charAt(i) != '(' || number.charAt(i) != ')') {
                rst += number.charAt(i);
            }
        }
        return rst;
    }

    //método para calcular el número de veces que se repite un carácter en un String
    public static int countCharacters(String cadena, char caracter) {
        int posicion, contador = 0;
        //se busca la primera vez que aparece
        posicion = cadena.indexOf(caracter);
        while (posicion != -1) { //mientras se encuentre el caracter
            contador++;           //se cuenta
            //se sigue buscando a partir de la posición siguiente a la encontrada
            posicion = cadena.indexOf(caracter, posicion + 1);
        }
        return contador;
    }
}
