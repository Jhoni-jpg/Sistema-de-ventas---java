package utilidades;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class CrearAlerta {

    public void Alerta(String titulo, String contenido, String tipo) {
        AlertType type = tipo(tipo);
        Alert alerta = new Alert(type);
        alerta.setHeaderText(null);
        alerta.setTitle(titulo);
        alerta.setContentText(contenido);
        alerta.showAndWait();
    }

    //<editor-fold defaultstate="collapsed" desc="Tipos de alerta">
    public static AlertType tipo(String tipo) {
        String tipo_lower = tipo.toLowerCase();
        if (tipo_lower.equals("error")) {
            return Alert.AlertType.ERROR;
        }
        
        if (tipo_lower.equals("advertencia")) {
            return Alert.AlertType.WARNING;
        }
        
        if (tipo_lower.equals("informacion")) {
            return Alert.AlertType.INFORMATION;
        }
        
        if (tipo_lower.equals("confirmar")) {
            return Alert.AlertType.CONFIRMATION;
        }
        
        if (tipo_lower.equals("nada")) {
            return Alert.AlertType.NONE;
        }
        
        return null;
    }
    //</editor-fold>
}
