package org.victoralvarez.system.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * Clase utilitaria para mostrar alertas en la aplicación JavaFX.
 */
public class AlertInformation {

    /**
     * Constructor vacío público.
     */
    public AlertInformation() {
    }

    /**
     * Muestra una alerta en pantalla según el tipo, título, encabezado y mensaje indicados.
     *
     * @param tipoAlerta  Cadena que identifica el tipo de alerta (INFO, WARNING, ERROR, CONFIRMATION, NONE).
     * @param titulo      Título de la ventana de alerta.
     * @param encabezado  Texto del encabezado (puede ser null para ocultarlo).
     * @param mensaje     Mensaje principal de la alerta.
     */
public void viewAlert(String tipoAlerta, String titulo, String encabezado, String mensaje) {

// Variable local de tipo AlertType donde se guardará el resultado del switch
AlertType tipo = switch (tipoAlerta.toUpperCase()) {
case "INFO", "INFORMATION" -> AlertType.INFORMATION;
case "WARNING", "WARN" -> AlertType.WARNING;
case "ERROR", "ERR" -> AlertType.ERROR;
case "CONFIRMATION", "CONFIRM" -> AlertType.CONFIRMATION;
case "NONE" -> AlertType.NONE ;
default -> AlertType.INFORMATION;
}; // Si el tipo no es reconocido, se muestra una de información por defecto

// Instanciamos la alerta con el tipo resultante del switch
Alert alert = new Alert(tipo);

// Configuramos los parámetros recibidos
alert.setTitle(titulo);
alert.setHeaderText (encabezado);
alert.setContentText(mensaje);

// Mostramos la alerta y esperamos a que el usuario la cierre
alert.showAndWait();
}
}