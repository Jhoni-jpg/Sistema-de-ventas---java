package iniciar;

import controlador.controllers_users;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utilidades.CrearAlerta;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        CrearAlerta Alerta = new CrearAlerta();

        try {
            FXMLLoader cargar = new FXMLLoader();

            controllers_users controles = new controllers_users();

            String passHashed = controles.hashPassword("prueba");

            controles.insertarContraseña(passHashed);

            cargar.setLocation(Main.class.getResource("/vista/Ventas_loginVista.fxml"));
            Pane ventana = (Pane) cargar.load();

            Scene escena = new Scene(ventana);
            escena.getStylesheets().add(getClass().getResource("/Codigo_css/ventas_login.css").toExternalForm());
            primaryStage.centerOnScreen();
            primaryStage.setScene(escena);

            primaryStage.setTitle("Login");
            primaryStage.initStyle(javafx.stage.StageStyle.UNDECORATED);
            primaryStage.setMinWidth(700);
            primaryStage.setMinHeight(500);

            primaryStage.show();
        } catch (IOException e) {
            Alerta.Alerta("Error", "Ha ocurrido un error inesperado: " + e.getMessage(), "error");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
