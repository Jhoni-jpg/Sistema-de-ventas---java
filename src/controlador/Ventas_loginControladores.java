package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import animatefx.animation.*;
import javafx.scene.input.MouseEvent;
import iniciar.Main;
import java.io.IOException;
import javafx.animation.FadeTransition;
import javafx.animation.FillTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PauseTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.StrokeTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.util.Duration;
import medios.Verificate;
import controlador.controllers_users;
import java.util.function.UnaryOperator;
import javafx.scene.control.TextFormatter;
import javafx.scene.shape.QuadCurve;
import modelos.Users;
import utilidades.CrearAlerta;

public class Ventas_loginControladores implements Initializable {

    @FXML
    private AnchorPane AnchuraPanel;
    @FXML
    private StackPane stack_pane;
    @FXML
    private GridPane Grid_Pane_Registrar;
    @FXML
    private ImageView redimensionar;
    @FXML
    private ImageView Mover_Ventana;
    @FXML
    private Pane PanelLoginComponent;
    @FXML
    private Rectangle Borde_Contraseña;
    @FXML
    private PasswordField password_login;
    @FXML
    private TextField prueba;
    @FXML
    private Label TIniciar_Login;
    @FXML
    private TextField TUsuarioLogin;
    @FXML
    private Label TRegistrar_Login;
    @FXML
    private Label TRecuperar_Login;
    @FXML
    private Label LRegistro_Registrar;
    @FXML
    private TextField TIdentificacion_Registrar;
    @FXML
    private TextField TNombre_Registrar;
    @FXML
    private TextField TCorreo_Registrar;
    @FXML
    private Rectangle Boton_Login;
    @FXML
    private Text TextoBTN_Login;
    @FXML
    private Rectangle Boton_Registrar;
    @FXML
    private Text TextoBTN_Registrar;
    @FXML
    private ImageView Flecha_Regresar;
    @FXML
    private ImageView Ocultar_Contraseña;
    @FXML
    private ImageView Ver_Contraseña;
    @FXML
    private Rectangle correoInexistente_Cuadro;
    @FXML
    private QuadCurve correoInexistente_Idea;
    @FXML
    private Text correoInexistente_Texto;
    @FXML
    private Rectangle faltaDigitos_rectangulo;
    @FXML
    private QuadCurve faltaDigito_idea;
    @FXML
    private Text faltaDigito_texto;
    @FXML
    private Rectangle soloLetras_rectangulo;
    @FXML
    private QuadCurve soloLetras_idea;
    @FXML
    private Text soloLetras_texto;
    @FXML
    private Rectangle digitosValidos_rectangulo;
    @FXML
    private QuadCurve digitosValidos_idea;
    @FXML
    private Text digitosValidos_texto;
    @FXML
    private Rectangle bordeContraseña_Registrar;
    @FXML
    private ImageView ocultrarContraseña_Registrar;
    @FXML
    private Rectangle bordeContraseña_Confirmar;
    @FXML
    private PasswordField TConfirmar_Contrasena;
    @FXML
    private ImageView ocultrarContraseña_Confirmar;
    @FXML
    private PasswordField TContrasena_Registrar;
    @FXML
    private ImageView verContraseña_Registrar;
    @FXML
    private ImageView verContraseña_Confirmar;
    @FXML
    private TextField TMostrarConfirmar;
    @FXML
    private TextField TMostrarRegistrar;
    @FXML
    private QuadCurve correoRegistrado_Idea;
    @FXML
    private Text correoRegistrado_Texto;
    @FXML
    private Rectangle correoRegistrado_rectangulo;
    @FXML
    private QuadCurve dniExistente_Idea;
    @FXML
    private Text dniExistente_Texto;
    @FXML
    private Rectangle dniExistente_rectangulo;
    @FXML
    private Text registroExitoso_Texto;
    @FXML
    private Rectangle registroExitoso_rectangulo;

    public void cambiarVentana(MouseEvent event, String fxmlfile) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
        try {
            FXMLLoader cargar = new FXMLLoader();

            cargar.setLocation(Main.class.getResource(fxmlfile));

            Parent ventana = cargar.load();
            ventana.getStylesheets().add(getClass().getResource("/Codigo_css/ventas_menuvista.css").toExternalForm());

            Stage nueva_ventana = new Stage();
            nueva_ventana.setTitle("Menu ventas");
            nueva_ventana.setScene(new Scene(ventana));
            nueva_ventana.centerOnScreen();

            nueva_ventana.setMinWidth(900);
            nueva_ventana.setMinHeight(700);

            nueva_ventana.show();
        } catch (IOException e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText(null);
            alerta.setTitle("Error");
            alerta.setContentText("Ha ocurrido un error inesperado: " + e.toString());
            alerta.showAndWait();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        prueba.textProperty().bindBidirectional(password_login.textProperty());
        TMostrarConfirmar.textProperty().bindBidirectional(TConfirmar_Contrasena.textProperty());
        TMostrarRegistrar.textProperty().bindBidirectional(TContrasena_Registrar.textProperty());

        DropShadow sombra = new DropShadow();
        sombra.setColor(Color.WHITE);
        sombra.setRadius(15);
        sombra.setSpread(0.2);
        Flecha_Regresar.setEffect(sombra);

        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(8);
        dropShadow.setOffsetX(2);
        dropShadow.setOffsetY(4);

        PanelLoginComponent.setEffect(dropShadow);

        UnaryOperator<TextFormatter.Change> filter = change -> {
            if (change.getText().matches("\\d*")) {
                return change;
            }
            return null;
        };

        TextFormatter<String> textFormatter = new TextFormatter<>(filter);
        TIdentificacion_Registrar.setTextFormatter(textFormatter);

        //<editor-fold defaultstate="collapsed" desc="Imagen ver contraseña - animacion">
        Ocultar_Contraseña.setOnMousePressed(ev -> {
            ScaleTransition scale_presionar = new ScaleTransition(Duration.seconds(0.1), Ocultar_Contraseña);
            scale_presionar.setToX(0.7);
            scale_presionar.setToY(0.7);
            scale_presionar.play();

            scale_presionar.setOnFinished(e -> {
                Ocultar_Contraseña.setVisible(false);
                password_login.setVisible(false);
                Ver_Contraseña.setVisible(true);
                if (Ver_Contraseña.getOpacity() == 0) {
                    Ver_Contraseña.setOpacity(1);
                }
                prueba.setVisible(true);
                prueba.setOpacity(1);
                ScaleTransition scale = new ScaleTransition(Duration.seconds(0.1), Ver_Contraseña);
                scale.setToX(0.7);
                scale.setToY(1.0);
                scale.play();
            });
        });

        Ver_Contraseña.setOnMousePressed(ev -> {
            ScaleTransition scale_presionar = new ScaleTransition(Duration.seconds(0.1), Ver_Contraseña);
            scale_presionar.setToX(0.7);
            scale_presionar.setToY(0.7);
            scale_presionar.play();

            scale_presionar.setOnFinished(e -> {
                Ver_Contraseña.setVisible(false);
                password_login.setVisible(true);
                Ocultar_Contraseña.setVisible(true);
                prueba.setVisible(false);
                ScaleTransition scale = new ScaleTransition(Duration.seconds(0.1), Ocultar_Contraseña);
                scale.setToX(0.7);
                scale.setToY(1.0);
                scale.play();
            });
        });
        //</editor-fold>       

        //<editor-fold defaultstate="collapsed" desc="Imagen ver contraseña confirmar registro - animacion">
        ocultrarContraseña_Confirmar.setOnMousePressed(ev -> {
            ScaleTransition scale_presionar = new ScaleTransition(Duration.seconds(0.1), ocultrarContraseña_Confirmar);
            scale_presionar.setToX(0.7);
            scale_presionar.setToY(0.7);
            scale_presionar.play();

            scale_presionar.setOnFinished(e -> {
                ocultrarContraseña_Confirmar.setVisible(false);
                TConfirmar_Contrasena.setVisible(false);
                verContraseña_Confirmar.setVisible(true);
                if (verContraseña_Confirmar.getOpacity() == 0) {
                    verContraseña_Confirmar.setOpacity(1);
                }
                TMostrarConfirmar.setVisible(true);
                if (TMostrarConfirmar.getOpacity() == 0) {
                    TMostrarConfirmar.setOpacity(1);
                }
                ScaleTransition scale = new ScaleTransition(Duration.seconds(0.1), verContraseña_Confirmar);
                scale.setToX(0.7);
                scale.setToY(1.0);
                scale.play();
            });
        });

        verContraseña_Confirmar.setOnMousePressed(ev -> {
            ScaleTransition scale_presionar = new ScaleTransition(Duration.seconds(0.1), verContraseña_Confirmar);
            scale_presionar.setToX(0.7);
            scale_presionar.setToY(0.7);
            scale_presionar.play();

            scale_presionar.setOnFinished(e -> {
                verContraseña_Confirmar.setVisible(false);
                TConfirmar_Contrasena.setVisible(true);
                ocultrarContraseña_Confirmar.setVisible(true);
                if (ocultrarContraseña_Confirmar.getOpacity() == 0) {
                    ocultrarContraseña_Confirmar.setOpacity(1);
                }
                TMostrarConfirmar.setVisible(false);
                ScaleTransition scale = new ScaleTransition(Duration.seconds(0.1), ocultrarContraseña_Confirmar);
                scale.setToX(0.7);
                scale.setToY(1.0);
                scale.play();
            });
        });

        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Imagen ver contraseña registrar registro - animacion">
        ocultrarContraseña_Registrar.setOnMousePressed(ev -> {
            ScaleTransition scale_presionar = new ScaleTransition(Duration.seconds(0.1), ocultrarContraseña_Registrar);
            scale_presionar.setToX(0.7);
            scale_presionar.setToY(0.7);
            scale_presionar.play();

            scale_presionar.setOnFinished(e -> {
                ocultrarContraseña_Registrar.setVisible(false);
                TContrasena_Registrar.setVisible(false);
                verContraseña_Registrar.setVisible(true);
                if (verContraseña_Registrar.getOpacity() == 0) {
                    verContraseña_Registrar.setOpacity(1);
                }
                TMostrarRegistrar.setVisible(true);
                if (TMostrarRegistrar.getOpacity() == 0) {
                    TMostrarRegistrar.setOpacity(1);
                }
                ScaleTransition scale = new ScaleTransition(Duration.seconds(0.1), verContraseña_Registrar);
                scale.setToX(0.7);
                scale.setToY(1.0);
                scale.play();
            });
        });

        verContraseña_Registrar.setOnMousePressed(ev -> {
            ScaleTransition scale_presionar = new ScaleTransition(Duration.seconds(0.1), verContraseña_Registrar);
            scale_presionar.setToX(0.7);
            scale_presionar.setToY(0.7);
            scale_presionar.play();

            scale_presionar.setOnFinished(e -> {
                verContraseña_Registrar.setVisible(false);
                TContrasena_Registrar.setVisible(true);
                ocultrarContraseña_Registrar.setVisible(true);
                if (ocultrarContraseña_Confirmar.getOpacity() == 0) {
                    ocultrarContraseña_Confirmar.setOpacity(1);
                }
                TMostrarRegistrar.setVisible(false);
                ScaleTransition scale = new ScaleTransition(Duration.seconds(0.1), ocultrarContraseña_Registrar);
                scale.setToX(0.7);
                scale.setToY(1.0);
                scale.play();
            });
        });

        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Bordes de shapes">
        Borde_Contraseña.setArcHeight(35);
        Borde_Contraseña.setArcWidth(35);
        bordeContraseña_Registrar.setArcHeight(35);
        bordeContraseña_Registrar.setArcWidth(35);
        bordeContraseña_Confirmar.setArcHeight(35);
        bordeContraseña_Confirmar.setArcWidth(35);
        Boton_Login.setArcHeight(15);
        Boton_Login.setArcWidth(15);
        Boton_Registrar.setArcHeight(15);
        Boton_Registrar.setArcWidth(15);
        //</editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Llamar metodos de boton - login"> 
        Boton_Login.setOnMouseEntered(e -> {
            pasar_mause(TextoBTN_Login, Boton_Login);
        });

        Boton_Login.setOnMouseExited(e -> {
            retirar_mause(TextoBTN_Login, Boton_Login);
        });

        Boton_Login.setOnMousePressed(e -> {
            presionar_botonD(TextoBTN_Login, Boton_Login);
        });
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Llamar metodos de boton - registrar"> 
        Boton_Registrar.setOnMouseEntered(e -> {
            pasar_mause(TextoBTN_Registrar, Boton_Registrar);
        });

        Boton_Registrar.setOnMouseExited(e -> {
            retirar_mause(TextoBTN_Registrar, Boton_Registrar);
        });

        Boton_Registrar.setOnMousePressed(e -> {
            presionar_botonD(TextoBTN_Registrar, Boton_Registrar);
        });
        // </editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Flecha regresar - animaciones">
        Flecha_Regresar.setOnMouseEntered(e -> {
            Pulse pulse = new Pulse(Flecha_Regresar);
            pulse.setSpeed(1);
            pulse.play();
        });

        Flecha_Regresar.setOnMousePressed(e -> {
            ScaleTransition scale = new ScaleTransition(Duration.seconds(0.1), Flecha_Regresar);
            scale.setToX(0.7);
            scale.setToY(0.7);
            scale.play();
        });

        Flecha_Regresar.setOnMouseReleased(e -> {
            ScaleTransition scale = new ScaleTransition(Duration.seconds(0.1), Flecha_Regresar);
            scale.setToX(1.0);
            scale.setToY(1.0);
            scale.play();
        });
        //</editor-fold>
    }

    @FXML
    private void mauseEntered(MouseEvent event) {
        Pulse pulse = new Pulse(TRegistrar_Login);
        pulse.play();
    }

    @FXML
    private void mausePressed(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // <editor-fold defaultstate="collapsed" desc="Desvanecer y aparecer">
        desvanecer_nodos(TIniciar_Login);
        desvanecer_nodos(TUsuarioLogin);
        desvanecer_nodos(password_login);
        desvanecer_nodos(Borde_Contraseña);
        desvanecer_nodos(TRegistrar_Login);
        desvanecer_nodos(TRecuperar_Login);
        desvanecer_nodos(Boton_Login);
        desvanecer_nodos(prueba);
        desvanecer_nodos(TextoBTN_Login);

        if (Ver_Contraseña.isVisible()) {
            desvanecer_nodos(Ver_Contraseña);
        }

        Flecha_Regresar.setDisable(true);
        TRegistrar_Login.setDisable(true);
        Ver_Contraseña.setDisable(true);
        Ocultar_Contraseña.setDisable(true);

        ocultrarContraseña_Registrar.setDisable(false);
        ocultrarContraseña_Confirmar.setDisable(false);
        verContraseña_Confirmar.setDisable(false);
        verContraseña_Registrar.setDisable(false);

        FadeTransition fadeout_desvanecer = new FadeTransition(Duration.seconds(1), Ocultar_Contraseña);
        fadeout_desvanecer.setToValue(0.0);
        fadeout_desvanecer.play();

        fadeout_desvanecer.setOnFinished(e -> {
            TUsuarioLogin.setVisible(false);
            password_login.setVisible(false);
            Borde_Contraseña.setVisible(false);
            TRegistrar_Login.setVisible(false);
            TRecuperar_Login.setVisible(false);
            Boton_Login.setVisible(false);
            TextoBTN_Login.setVisible(false);
            TIniciar_Login.setVisible(false);
            Ocultar_Contraseña.setVisible(false);
            Ver_Contraseña.setVisible(false);
            prueba.setVisible(false);

            TIdentificacion_Registrar.setVisible(true);
            TNombre_Registrar.setVisible(true);
            TCorreo_Registrar.setVisible(true);
            TContrasena_Registrar.setVisible(true);
            LRegistro_Registrar.setVisible(true);
            Boton_Registrar.setVisible(true);
            TextoBTN_Registrar.setVisible(true);
            Flecha_Regresar.setVisible(true);
            TConfirmar_Contrasena.setVisible(true);
            TContrasena_Registrar.setVisible(true);
            ocultrarContraseña_Registrar.setVisible(true);
            ocultrarContraseña_Confirmar.setVisible(true);
            bordeContraseña_Confirmar.setVisible(true);
            bordeContraseña_Registrar.setVisible(true);
            verContraseña_Registrar.setVisible(true);
            verContraseña_Confirmar.setVisible(true);
            TMostrarConfirmar.setVisible(true);
            TMostrarRegistrar.setVisible(true);

            aparecer_nodos(TIdentificacion_Registrar);
            aparecer_nodos(TNombre_Registrar);
            aparecer_nodos(TCorreo_Registrar);
            aparecer_nodos(TContrasena_Registrar);
            aparecer_nodos(TContrasena_Registrar);
            aparecer_nodos(bordeContraseña_Registrar);

            FadeTransition fadein_ocultarR = new FadeTransition(Duration.seconds(2), ocultrarContraseña_Registrar);
            fadein_ocultarR.setFromValue(0);
            fadein_ocultarR.setToValue(0.5);
            fadein_ocultarR.play();

            FadeTransition fadein_registro = new FadeTransition(Duration.seconds(2), LRegistro_Registrar);
            fadein_registro.setFromValue(0.0);
            fadein_registro.setToValue(1.0);
            fadein_registro.play();

            fadein_registro.setOnFinished(evento_registro -> {

                TranslateTransition transition_pane = new TranslateTransition(Duration.seconds(0.5), PanelLoginComponent);
                transition_pane.setByY(-30);
                transition_pane.play();

                Timeline timeline = new Timeline(
                        new KeyFrame(Duration.seconds(0.5), new KeyValue(PanelLoginComponent.prefHeightProperty(), 460))
                );
                timeline.play();

                aparecer_nodos(bordeContraseña_Confirmar);
                aparecer_nodos(Boton_Registrar);
                aparecer_nodos(TextoBTN_Registrar);
                aparecer_nodos(TConfirmar_Contrasena);

                FadeTransition fadein_ocultarC = new FadeTransition(Duration.seconds(2), ocultrarContraseña_Confirmar);
                fadein_ocultarC.setFromValue(0);
                fadein_ocultarC.setToValue(0.5);
                fadein_ocultarC.play();

                FadeTransition fadein_flecha = new FadeTransition(Duration.seconds(1), Flecha_Regresar);
                fadein_flecha.setFromValue(0.0);
                fadein_flecha.setToValue(1.0);
                fadein_flecha.play();
                fadein_flecha.setOnFinished(evento_flecha -> {
                    Flecha_Regresar.setDisable(false);
                });

                stage.setHeight(640);
            });
        });
        // </editor-fold>
    }

    @FXML
    private void Tamaño_Ventana(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setWidth(event.getSceneX());
        stage.setHeight(event.getSceneY());

    }

    private double xOffset;
    private double yOffset;

    @FXML
    private void Nuevo_Posicionamiento(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setX(event.getScreenX() - xOffset);
        stage.setY(event.getScreenY() - yOffset);
    }

    @FXML
    private void Cambiar_Posicion(MouseEvent event) {
        xOffset = event.getSceneX();
        yOffset = event.getSceneY();
    }

    @FXML
    private void Cerrar_Ventana(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void PasarM_Recuperar(MouseEvent event) {
        Pulse pulse = new Pulse(TRecuperar_Login);
        pulse.play();
    }

    //<editor-fold defaultstate="collapsed" desc="Boton diseño">
    private void pasar_mause(Shape texto, Shape boton) {
        FillTransition textTransition = new FillTransition(Duration.seconds(0.2), texto);
        textTransition.setToValue(Color.BLACK);
        textTransition.play();

        FillTransition fondoTransicion = new FillTransition(Duration.seconds(0.2), boton);
        fondoTransicion.setToValue(Color.rgb(52, 152, 219));
        fondoTransicion.play();

        StrokeTransition borderTransition = new StrokeTransition(Duration.seconds(0.2), boton);
        borderTransition.setToValue(Color.TRANSPARENT);
        borderTransition.play();

        borderTransition.setOnFinished(e -> {
            DropShadow sombra = new DropShadow();
            sombra.setColor(Color.WHITE);
            sombra.setRadius(15);
            sombra.setSpread(0.2);
            boton.setEffect(sombra);
        });
    }

    private void retirar_mause(Shape texto, Shape boton) {
        FillTransition textTransition = new FillTransition(Duration.seconds(0.2), texto);
        textTransition.setToValue(Color.WHITE);
        textTransition.play();

        FillTransition fondoTransicion = new FillTransition(Duration.seconds(0.2), boton);
        fondoTransicion.setToValue(Color.TRANSPARENT);
        fondoTransicion.play();

        StrokeTransition borderTransition = new StrokeTransition(Duration.seconds(0.2), boton);
        borderTransition.setToValue(Color.WHITE);
        borderTransition.play();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Desvanecer">
    private void desvanecer_nodos(Node nodos_login) {
        FadeTransition fadeout_desvanecer = new FadeTransition(Duration.seconds(1), nodos_login);
        fadeout_desvanecer.setFromValue(1.0);
        fadeout_desvanecer.setToValue(0.0);
        fadeout_desvanecer.play();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Aparecer">
    private void aparecer_nodos(Node nodos_registro) {
        FadeTransition fadein_registro = new FadeTransition(Duration.seconds(1), nodos_registro);
        fadein_registro.setFromValue(0.0);
        fadein_registro.setToValue(1.0);
        fadein_registro.play();

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Presionar y bajar opacidad">
    private void presionar_botonD(Shape texto, Shape boton) {
        FadeTransition desvanecer_boton = new FadeTransition(Duration.millis(200), boton);
        desvanecer_boton.setToValue(0.5);
        desvanecer_boton.play();

        FadeTransition desvanecer_texto = new FadeTransition(Duration.millis(200), texto);
        desvanecer_texto.setToValue(0.5);
        desvanecer_texto.play();

        desvanecer_texto.setOnFinished(e -> {
            FadeTransition aparecer_boton = new FadeTransition(Duration.millis(200), boton);
            aparecer_boton.setToValue(1.0);
            aparecer_boton.play();

            FadeTransition aparecer_texto = new FadeTransition(Duration.millis(200), texto);
            aparecer_texto.setToValue(1.0);
            aparecer_texto.play();
        });
    }
    //</editor-fold>

    @FXML
    private void Regresar_Login(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // <editor-fold defaultstate="collapsed" desc="Desvanecer y aparecer - regresar">
        desvanecer_nodos(TIdentificacion_Registrar);
        desvanecer_nodos(TNombre_Registrar);
        desvanecer_nodos(TCorreo_Registrar);
        desvanecer_nodos(LRegistro_Registrar);
        desvanecer_nodos(Boton_Registrar);
        desvanecer_nodos(TextoBTN_Registrar);
        desvanecer_nodos(Flecha_Regresar);
        desvanecer_nodos(TConfirmar_Contrasena);
        desvanecer_nodos(bordeContraseña_Confirmar);
        desvanecer_nodos(TContrasena_Registrar);
        desvanecer_nodos(TConfirmar_Contrasena);
        desvanecer_nodos(TMostrarConfirmar);
        desvanecer_nodos(TMostrarRegistrar);
        desvanecer_nodos(bordeContraseña_Registrar);

        if (!ocultrarContraseña_Registrar.isVisible()) {
            FadeTransition fadeVerR = new FadeTransition(Duration.seconds(1), verContraseña_Registrar);
            fadeVerR.setFromValue(0.5);
            fadeVerR.setToValue(0);
            fadeVerR.play();
            ocultrarContraseña_Registrar.setOpacity(0);
        } else {
            FadeTransition fadeOcultarR = new FadeTransition(Duration.seconds(0.5), ocultrarContraseña_Registrar);
            fadeOcultarR.setFromValue(0.5);
            fadeOcultarR.setToValue(0);
            fadeOcultarR.play();
        }

        if (!ocultrarContraseña_Confirmar.isVisible()) {
            FadeTransition fadeOcultarC = new FadeTransition(Duration.seconds(1), verContraseña_Confirmar);
            fadeOcultarC.setFromValue(0.5);
            fadeOcultarC.setToValue(0);
            fadeOcultarC.play();
            ocultrarContraseña_Confirmar.setOpacity(0);
        } else {
            FadeTransition fadeVerC = new FadeTransition(Duration.seconds(0.5), ocultrarContraseña_Confirmar);
            fadeVerC.setFromValue(0.5);
            fadeVerC.setToValue(0);
            fadeVerC.play();
        }

        TRegistrar_Login.setDisable(true);
        Flecha_Regresar.setDisable(true);

        Ver_Contraseña.setDisable(false);
        Ocultar_Contraseña.setDisable(false);

        ocultrarContraseña_Registrar.setDisable(true);
        ocultrarContraseña_Confirmar.setDisable(true);
        verContraseña_Confirmar.setDisable(true);
        verContraseña_Registrar.setDisable(true);
        verContraseña_Confirmar.setOpacity(0);
        verContraseña_Registrar.setOpacity(0);

        FadeOut fadeout_desvanecer = new FadeOut(TContrasena_Registrar);
        fadeout_desvanecer.setSpeed(0.5);
        fadeout_desvanecer.play();

        fadeout_desvanecer.setOnFinished(e -> {
            TIdentificacion_Registrar.setVisible(false);
            TNombre_Registrar.setVisible(false);
            TCorreo_Registrar.setVisible(false);
            TContrasena_Registrar.setVisible(false);
            LRegistro_Registrar.setVisible(false);
            Boton_Registrar.setVisible(false);
            TextoBTN_Registrar.setVisible(false);
            Flecha_Regresar.setVisible(false);
            TConfirmar_Contrasena.setVisible(false);
            TContrasena_Registrar.setVisible(false);
            bordeContraseña_Confirmar.setVisible(false);
            bordeContraseña_Registrar.setVisible(false);
            ocultrarContraseña_Registrar.setVisible(false);
            ocultrarContraseña_Confirmar.setVisible(false);
            verContraseña_Registrar.setVisible(false);
            verContraseña_Confirmar.setVisible(false);
            TMostrarConfirmar.setVisible(false);
            TMostrarRegistrar.setVisible(false);
            Flecha_Regresar.setDisable(true);

            TUsuarioLogin.setVisible(true);
            password_login.setVisible(true);
            Borde_Contraseña.setVisible(true);
            TRegistrar_Login.setVisible(true);
            TRecuperar_Login.setVisible(true);
            Boton_Login.setVisible(true);
            TextoBTN_Login.setVisible(true);
            TIniciar_Login.setVisible(true);
            prueba.setVisible(true);
            Ocultar_Contraseña.setVisible(true);
            Ver_Contraseña.setDisable(false);
            Ocultar_Contraseña.setDisable(false);

            aparecer_nodos(password_login);
            aparecer_nodos(Borde_Contraseña);
            aparecer_nodos(TRegistrar_Login);
            aparecer_nodos(TRecuperar_Login);
            aparecer_nodos(Boton_Login);
            aparecer_nodos(TextoBTN_Login);
            aparecer_nodos(TIniciar_Login);
            aparecer_nodos(TUsuarioLogin);

            FadeTransition aparecer = new FadeTransition(Duration.seconds(1), Ocultar_Contraseña);
            aparecer.setToValue(0.5);
            aparecer.play();

            TranslateTransition transition_pane = new TranslateTransition(Duration.seconds(0.5), PanelLoginComponent);
            transition_pane.setToY(0);
            transition_pane.play();

            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.seconds(0.5), new KeyValue(PanelLoginComponent.prefHeightProperty(), 350))
            );
            timeline.play();

            stage.setHeight(504);

            timeline.setOnFinished(evento_regresar -> {
                TRegistrar_Login.setDisable(false);
                Flecha_Regresar.setDisable(false);
            });
        });
        // </editor-fold>
    }

    @FXML
    private boolean BTN_Ingresar_p(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        if (!validarCorreo(stage, event)) {
            return false;
        }

        if (!validarContraseña()) {
            return false;
        }

        cambiarVentana(event, "/vista/Ventas_menuVista.fxml");
        return true;
    }

    @FXML
    private void Presionar_RecuperarCuenta(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        validarCorreo(stage, event);

    }

    //<editor-fold defaultstate="collapsed" desc="Validar correo">
    boolean popupVisualizado = false;

    private boolean validarCorreo(Stage stage, MouseEvent evt) {
        controllers_users Controladores = new controllers_users();
        Verificate verificacion = new Verificate();
        Label label = new Label();
        Popup popup = new Popup();

        if (!verificacion.isValidAddress(TUsuarioLogin.getText())) {
            return false;
        }

        if (!verificacion.isValidEmail(TUsuarioLogin.getText())) {
            if (!popupVisualizado) {
                popup.setX(evt.getScreenX());
                popup.setY(evt.getSceneY());
                label.setText("Parametros de Email incorrectos");
                label.setStyle("-fx-background-color: black; -fx-background-radius: 5px; -fx-text-fill: white; -fx-padding: 10px; -fx-border-radius: 5px; -fx-font: normal bold 12px System; -fx-effect: dropshadow(gaussian, rgba(244, 254, 253, 0.5), 6, 0.5, 0, 0);");
                popup.getContent().add(label);

                popup.show(stage);

                PauseTransition delay = new PauseTransition(Duration.seconds(3));
                delay.setOnFinished(event -> {
                    popup.hide();
                    popupVisualizado = false;
                });
                delay.play();

                popupVisualizado = true;
            }
            return false;
        }

        if (!Controladores.validarEmail(TUsuarioLogin.getText())) {
            aparecer_nodos(correoInexistente_Texto);
            aparecer_nodos(correoInexistente_Cuadro);
            aparecer_nodos(correoInexistente_Idea);

            PauseTransition delay = new PauseTransition(Duration.seconds(2));
            delay.setOnFinished(event -> {
                desvanecer_nodos(correoInexistente_Texto);
                desvanecer_nodos(correoInexistente_Cuadro);
                desvanecer_nodos(correoInexistente_Idea);
            });
            delay.play();
            return false;
        }

        System.out.println("Validacion de correo completada");
        return true;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Validar correo - registro">
    private boolean validarCorreo_Registrar(Stage stage, MouseEvent evt) {
        Verificate verificacion = new Verificate();
        controllers_users Controladores = new controllers_users();
        Label label = new Label();
        Popup popup = new Popup();

        if (!verificacion.isValidAddress(TCorreo_Registrar.getText())) {
            return false;
        }

        if (!verificacion.isValidEmail(TCorreo_Registrar.getText())) {
            if (!popupVisualizado) {
                popup.setX(evt.getScreenX());
                popup.setY(evt.getSceneY());
                label.setText("Parametros de Email incorrectos");
                label.setStyle("-fx-background-color: black; -fx-background-radius: 5px; -fx-text-fill: white; -fx-padding: 10px; -fx-border-radius: 5px; -fx-font: normal bold 12px System; -fx-effect: dropshadow(gaussian, rgba(244, 254, 253, 0.5), 6, 0.5, 0, 0);");
                popup.getContent().add(label);

                popup.show(stage);

                PauseTransition delay = new PauseTransition(Duration.seconds(3));
                delay.setOnFinished(event -> {
                    popup.hide();
                    popupVisualizado = false;
                });
                delay.play();

                popupVisualizado = true;
            }
            return false;
        }

        if (Controladores.validarEmail(TCorreo_Registrar.getText())) {
            aparecer_nodos(correoRegistrado_rectangulo);
            aparecer_nodos(correoRegistrado_Idea);
            aparecer_nodos(correoRegistrado_Texto);

            PauseTransition delay = new PauseTransition(Duration.seconds(2));
            delay.setOnFinished(ev -> {
                desvanecer_nodos(correoRegistrado_rectangulo);
                desvanecer_nodos(correoRegistrado_Idea);
                desvanecer_nodos(correoRegistrado_Texto);
            });
            delay.play();
            return false;

        }

        return true;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Validar contraseña">
    private boolean validarContraseña() {
        controllers_users Controladores = new controllers_users();
        if (!Controladores.login(TUsuarioLogin.getText(), password_login.getText())) {
            StrokeTransition borderTransition = new StrokeTransition(Duration.seconds(0.2), Borde_Contraseña);
            borderTransition.setToValue(Color.RED);
            borderTransition.play();

            PauseTransition delay = new PauseTransition(Duration.seconds(2));
            delay.setOnFinished(event -> {
                StrokeTransition reestablecer_Borde = new StrokeTransition(Duration.seconds(0.2), Borde_Contraseña);
                reestablecer_Borde.setToValue(Color.WHITE);
                reestablecer_Borde.play();

                FadeTransition fadeout_desvanecer = new FadeTransition(Duration.seconds(0.2), Borde_Contraseña);
                fadeout_desvanecer.setFromValue(1.0);
                fadeout_desvanecer.setToValue(0.5);
                fadeout_desvanecer.play();
            });
            delay.play();

            return false;
        }
        System.out.println("Validacion de contraseña completada");
        return true;
    }
    //</editor-fold>

    @FXML
    private void BTN_Registrar(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        almacenarDatos(verificarDatos(stage, event));
    }

    //<editor-fold defaultstate="collapsed" desc="Validar datos de registro">
    private boolean verificarDatos(Stage stage, MouseEvent event) {
        Verificate verificar = new Verificate();
        controllers_users controladores = new controllers_users();

        if (controladores.validarIdentificacion(TIdentificacion_Registrar.getText())) {
            aparecer_nodos(dniExistente_rectangulo);
            aparecer_nodos(dniExistente_Idea);
            aparecer_nodos(dniExistente_Texto);

            PauseTransition delay = new PauseTransition(Duration.seconds(2));
            delay.setOnFinished(evt -> {
                desvanecer_nodos(dniExistente_rectangulo);
                desvanecer_nodos(dniExistente_Idea);
                desvanecer_nodos(dniExistente_Texto);
            });
            delay.play();
            return false;
        }

        if (!verificar.isValidDNI(TIdentificacion_Registrar.getText())) {

            aparecer_nodos(faltaDigitos_rectangulo);
            aparecer_nodos(faltaDigito_idea);
            aparecer_nodos(faltaDigito_texto);

            PauseTransition delay = new PauseTransition(Duration.seconds(2));
            delay.setOnFinished(evt -> {
                desvanecer_nodos(faltaDigitos_rectangulo);
                desvanecer_nodos(faltaDigito_idea);
                desvanecer_nodos(faltaDigito_texto);
            });
            delay.play();
            return false;
        }

        if (!verificar.isValidName(TNombre_Registrar.getText())) {
            aparecer_nodos(soloLetras_rectangulo);
            aparecer_nodos(soloLetras_idea);
            aparecer_nodos(soloLetras_texto);

            PauseTransition delay = new PauseTransition(Duration.seconds(2));
            delay.setOnFinished(evt -> {
                desvanecer_nodos(soloLetras_rectangulo);
                desvanecer_nodos(soloLetras_idea);
                desvanecer_nodos(soloLetras_texto);
            });
            delay.play();
            return false;
        }

        if (!validarCorreo_Registrar(stage, event)) {
            return false;
        }

        if (!verificar.isValidPassword(TContrasena_Registrar.getText())) {
            aparecer_nodos(digitosValidos_idea);
            aparecer_nodos(digitosValidos_texto);
            aparecer_nodos(digitosValidos_rectangulo);

            PauseTransition delay = new PauseTransition(Duration.seconds(2));
            delay.setOnFinished(evt -> {
                desvanecer_nodos(digitosValidos_idea);
                desvanecer_nodos(digitosValidos_texto);
                desvanecer_nodos(digitosValidos_rectangulo);
            });
            delay.play();
            return false;
        }

        if (!TContrasena_Registrar.getText().equals(TConfirmar_Contrasena.getText())) {
            StrokeTransition borderTransition = new StrokeTransition(Duration.seconds(0.2), bordeContraseña_Confirmar);
            borderTransition.setToValue(Color.RED);
            borderTransition.play();

            PauseTransition delay = new PauseTransition(Duration.seconds(2));
            delay.setOnFinished(evt -> {
                StrokeTransition reestablecer_Borde = new StrokeTransition(Duration.seconds(0.2), bordeContraseña_Confirmar);
                reestablecer_Borde.setToValue(Color.WHITE);
                reestablecer_Borde.play();

                FadeTransition fadeout_desvanecer = new FadeTransition(Duration.seconds(0.2), bordeContraseña_Confirmar);
                fadeout_desvanecer.setFromValue(1.0);
                fadeout_desvanecer.setToValue(0.5);
                fadeout_desvanecer.play();
            });
            delay.play();
            return false;
        }

        return true;
    }

    //</editor-fold>
    private void almacenarDatos(boolean validado) {
        controllers_users controladores = new controllers_users();
        Users usuario = new Users();
        CrearAlerta Alerta = new CrearAlerta();
        registroExitoso_Texto.setVisible(true);
        registroExitoso_rectangulo.setVisible(true);

        try {
            if (validado) {
                usuario.setDniUsuario(TIdentificacion_Registrar.getText());
                usuario.setNombreUsuario(TNombre_Registrar.getText());
                usuario.setCorreoUsuario(TCorreo_Registrar.getText());

                String password = null;

                if (TConfirmar_Contrasena.isVisible()) {
                    password = TConfirmar_Contrasena.getText();
                }
                if (TMostrarConfirmar.isVisible()) {
                    password = TMostrarConfirmar.getText();
                }

                usuario.setContraseñaUsuario(password);
                
                controladores.Insert_User(usuario);

                aparecer_nodos(registroExitoso_Texto);
                aparecer_nodos(registroExitoso_rectangulo);
                PauseTransition delay = new PauseTransition(Duration.seconds(3));
                delay.setOnFinished(e -> {
                    desvanecer_nodos(registroExitoso_Texto);
                    desvanecer_nodos(registroExitoso_rectangulo);
                });
                delay.play();
                limpiarCampos();
            }
        } catch (Exception e) {
            Alerta.Alerta("Error", "Ha ocurrido un error en el registro: " + e.getMessage(), "error");
        } finally {
            registroExitoso_Texto.setVisible(false);
            registroExitoso_rectangulo.setVisible(false);
        }
    }

    private void limpiarCampos() {
        TIdentificacion_Registrar.setText("");
        TNombre_Registrar.setText("");
        TCorreo_Registrar.setText("");
        TConfirmar_Contrasena.setText("");
        TContrasena_Registrar.setText("");
        TMostrarConfirmar.setText("");
        TMostrarRegistrar.setText("");
    }
}
