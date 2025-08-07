package controlador;

import animatefx.animation.Pulse;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import javafx.util.Duration;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class Ventas_menuVistaController implements Initializable {

    @FXML
    private Pane Panel_CajaVertical;
    @FXML
    private Pane PanelSuperior;
    private Label Label_Menu;
    @FXML
    private VBox ComponentesCaja_Vertical;
    @FXML
    private JFXButton Label_Usuario;
    @FXML
    private JFXButton Label_Cliente;
    @FXML
    private JFXButton Label_Proveedor;
    @FXML
    private JFXButton Label_Producto;
    @FXML
    private JFXButton Label_Categoria;
    @FXML
    private JFXButton Label_Factura;
    @FXML
    private JFXButton Label_Historial;
    @FXML
    private ImageView Salir_Img;
    @FXML
    private AnchorPane sidebar;
    private Label Label_Cerrar;
    @FXML
    private Pane Panel_HorizontalSuperior;
    @FXML
    private Pane Panel_AgregarUsuario;
    @FXML
    private Pane PanelComponentes_AgUsuario;
    @FXML
    private Pane Panel_GestionarUsuarios;
    @FXML
    private Pane Panel_AgregarCliente;
    @FXML
    private Pane Panel_GestionarClientes;
    @FXML
    private Pane Panel_AgregarProveedor;
    @FXML
    private Pane PanelComponentes_AgUsuario1;
    @FXML
    private Pane Panel_GestionarProveedores;
    @FXML
    private Pane Panel_AgregarProducto;
    @FXML
    private Pane Panel_GestionarProductos;
    @FXML
    private Pane Panel_AgregarCategoria;
    @FXML
    private Pane Panel_GestionarCategorias;
    @FXML
    private Pane Panel_AgregarFactura;
    @FXML
    private AnchorPane PanelPosterior_CajaHorizontal;
    @FXML
    private Spinner<?> Spinner_Cantidad;
    @FXML
    private Label Cantidad_Label;
    @FXML
    private TextArea Text_AreaComp;
    @FXML
    private ImageView Flecha_AcercarCursor;
    @FXML
    private MenuButton Menu_Reportes;
    @FXML
    private HBox ComponentesCaja_Horizontal;
    @FXML
    private GridPane Panel_GestionarFacturas;
    @FXML
    private ImageView avatarInicio;
    @FXML
    private Label nombreInicio;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        Pulse pulse = new Pulse(Flecha_AcercarCursor);
        pulse.setCycleCount(Animation.INDEFINITE);
        pulse.play();

        Salir_Img.setOnMouseClicked(event -> {
            System.exit(0);
        });

        FadeTransition fadeout_desvanecer = new FadeTransition(Duration.seconds(1), avatarInicio);
        fadeout_desvanecer.setFromValue(1.0);
        fadeout_desvanecer.setToValue(0.0);

        FadeTransition fadeout_desvanecerTexto = new FadeTransition(Duration.seconds(1), nombreInicio);
        fadeout_desvanecerTexto.setFromValue(1.0);
        fadeout_desvanecerTexto.setToValue(0.0);

        PauseTransition delay = new PauseTransition(Duration.seconds(5));
        delay.setOnFinished(evt -> {
            fadeout_desvanecer.play();
            fadeout_desvanecerTexto.play();
        });

        delay.play();

        fadeout_desvanecer.setOnFinished(event -> {
            fadeout_desvanecerTexto.setOnFinished(evt -> {
                avatarInicio.setOpacity(0);
                avatarInicio.setVisible(false);

                nombreInicio.setOpacity(0);
                nombreInicio.setVisible(false);
            });
        });

        sidebar.setTranslateX(-195);

        sidebar.setOnMouseEntered((MouseEvent event) -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.1));
            slide.setNode(sidebar);

            slide.setToX(0);

            slide.play();

            sidebar.setTranslateX(-195);
            RotateTransition rotateTransition = new RotateTransition(Duration.millis(250), Flecha_AcercarCursor);
            rotateTransition.setFromAngle(270);
            rotateTransition.setToAngle(90);

            rotateTransition.play();
        });
        
        sidebar.setOnMouseExited((MouseEvent event) -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.1));
            slide.setNode(sidebar);

            slide.setToX(-195);
            slide.play();

            sidebar.setTranslateX(0);

            RotateTransition rotateTransition = new RotateTransition(Duration.millis(250), Flecha_AcercarCursor);
            rotateTransition.setFromAngle(90);
            rotateTransition.setToAngle(270);

            rotateTransition.play();
        });

        //<editor-fold defaultstate="collapsed" desc="Navegacion menu">
        Label_Usuario.setOnAction(event -> {
            ComponentesCaja_Horizontal.getChildren().clear();
            JFXButton boton1 = new JFXButton("Nuevo usuario");
            JFXButton boton2 = new JFXButton("Gestionar usuarios");

            ComponentesCaja_Horizontal.getChildren().addAll(boton1, boton2);
            ComponentesCaja_Horizontal.setHgrow(boton1, Priority.ALWAYS);
            ComponentesCaja_Horizontal.setMaxHeight(0);
            ComponentesCaja_Horizontal.setHgrow(boton2, Priority.ALWAYS);
            ComponentesCaja_Horizontal.setMargin(boton1, new Insets(10, 30, 10, 10));
            ComponentesCaja_Horizontal.setMargin(boton2, new Insets(10, 30, 10, 10));
            ComponentesCaja_Horizontal.setAlignment(Pos.CENTER_LEFT);
            boton1.getStyleClass().add("Label_ItemBTSuperior");
            boton2.getStyleClass().add("Label_ItemBTSuperior");

            boton1.setOnAction(e -> {
                ocultarPaneles();

                Panel_AgregarUsuario.setVisible(true);
            });

            boton2.setOnAction(e -> {
                ocultarPaneles();
                Panel_GestionarUsuarios.setVisible(true);
            });
        });

        Label_Cliente.setOnAction(event -> {
            ComponentesCaja_Horizontal.getChildren().clear();
            JFXButton boton1 = new JFXButton("Agregar cliente");
            JFXButton boton2 = new JFXButton("Gestionar clientes");

            ComponentesCaja_Horizontal.getChildren().addAll(boton1, boton2);
            ComponentesCaja_Horizontal.setHgrow(boton1, Priority.ALWAYS);
            ComponentesCaja_Horizontal.setMaxHeight(0);
            ComponentesCaja_Horizontal.setHgrow(boton2, Priority.ALWAYS);
            ComponentesCaja_Horizontal.setMargin(boton1, new Insets(10, 30, 10, 10));
            ComponentesCaja_Horizontal.setMargin(boton2, new Insets(10, 30, 10, 10));
            boton1.getStyleClass().add("Label_ItemBTSuperior");
            boton2.getStyleClass().add("Label_ItemBTSuperior");

            boton1.setOnAction(evt -> {
                ocultarPaneles();
                Panel_AgregarCliente.setVisible(true);
            });

            boton2.setOnAction(evt -> {
                ocultarPaneles();
                Panel_GestionarClientes.setVisible(true);
            });
        });

        Label_Proveedor.setOnAction(event -> {
            ComponentesCaja_Horizontal.getChildren().clear();
            JFXButton boton1 = new JFXButton("Agregar proveedor");
            JFXButton boton2 = new JFXButton("Gestionar proveedores");

            ComponentesCaja_Horizontal.getChildren().addAll(boton1, boton2);
            ComponentesCaja_Horizontal.setHgrow(boton1, Priority.ALWAYS);
            ComponentesCaja_Horizontal.setMaxHeight(0);
            ComponentesCaja_Horizontal.setHgrow(boton2, Priority.ALWAYS);
            ComponentesCaja_Horizontal.setMargin(boton1, new Insets(10, 30, 10, 10));
            ComponentesCaja_Horizontal.setMargin(boton2, new Insets(10, 30, 10, 10));
            boton1.getStyleClass().add("Label_ItemBTSuperior");
            boton2.getStyleClass().add("Label_ItemBTSuperior");

            boton1.setOnAction(evt -> {
                ocultarPaneles();
                Panel_AgregarProveedor.setVisible(true);
            });

            boton2.setOnAction(evt -> {
                ocultarPaneles();
                Panel_GestionarProveedores.setVisible(true);
            });
        });

        Label_Producto.setOnAction(event -> {

            ComponentesCaja_Horizontal.getChildren().clear();
            JFXButton boton1 = new JFXButton("Agregar producto");
            JFXButton boton2 = new JFXButton("Gestionar productos");

            ComponentesCaja_Horizontal.getChildren().addAll(boton1, boton2);
            ComponentesCaja_Horizontal.setHgrow(boton1, Priority.ALWAYS);
            ComponentesCaja_Horizontal.setMaxHeight(0);
            ComponentesCaja_Horizontal.setHgrow(boton2, Priority.ALWAYS);
            ComponentesCaja_Horizontal.setMargin(boton1, new Insets(10, 30, 10, 10));
            ComponentesCaja_Horizontal.setMargin(boton2, new Insets(10, 30, 10, 10));
            boton1.getStyleClass().add("Label_ItemBTSuperior");
            boton2.getStyleClass().add("Label_ItemBTSuperior");

            boton1.setOnAction(evt -> {
                ocultarPaneles();
                Panel_AgregarProducto.setVisible(true);
            });

            boton2.setOnAction(evt -> {
                ocultarPaneles();
                Panel_GestionarProductos.setVisible(true);
            });
        });

        Label_Categoria.setOnAction(event -> {

            ComponentesCaja_Horizontal.getChildren().clear();
            JFXButton boton1 = new JFXButton("Agregar categoria");
            JFXButton boton2 = new JFXButton("Gestionar categorias");

            ComponentesCaja_Horizontal.getChildren().addAll(boton1, boton2);
            ComponentesCaja_Horizontal.setHgrow(boton1, Priority.ALWAYS);
            ComponentesCaja_Horizontal.setMaxHeight(0);
            ComponentesCaja_Horizontal.setHgrow(boton2, Priority.ALWAYS);
            ComponentesCaja_Horizontal.setMargin(boton1, new Insets(10, 30, 10, 10));
            ComponentesCaja_Horizontal.setMargin(boton2, new Insets(10, 30, 10, 10));
            boton1.getStyleClass().add("Label_ItemBTSuperior");
            boton2.getStyleClass().add("Label_ItemBTSuperior");

            boton1.setOnAction(evt -> {
                ocultarPaneles();
                Panel_AgregarCategoria.setVisible(true);
            });

            boton2.setOnAction(evt -> {
                ocultarPaneles();
                Panel_GestionarCategorias.setVisible(true);
            });
        });

        Label_Factura.setOnAction(event -> {

            ComponentesCaja_Horizontal.getChildren().clear();
            JFXButton boton1 = new JFXButton("Agregar factura");
            JFXButton boton2 = new JFXButton("Gestionar facturas");

            ComponentesCaja_Horizontal.getChildren().addAll(boton1, boton2);
            ComponentesCaja_Horizontal.setHgrow(boton1, Priority.ALWAYS);
            ComponentesCaja_Horizontal.setMaxHeight(0);
            ComponentesCaja_Horizontal.setHgrow(boton2, Priority.ALWAYS);
            ComponentesCaja_Horizontal.setMargin(boton1, new Insets(10, 30, 10, 10));
            ComponentesCaja_Horizontal.setMargin(boton2, new Insets(10, 30, 10, 10));
            boton1.getStyleClass().add("Label_ItemBTSuperior");
            boton2.getStyleClass().add("Label_ItemBTSuperior");

            boton1.setOnAction(evt -> {
                ocultarPaneles();
                Panel_AgregarFactura.setVisible(true);
            });

            boton2.setOnAction(evt -> {
                ocultarPaneles();
                Panel_GestionarFacturas.setVisible(true);
            });
        });
        //</editor-fold>

    }

    //<editor-fold defaultstate="collapsed" desc="Ocultar paneles">
    private void ocultarPaneles() {
        Panel_AgregarUsuario.setVisible(false);
        Panel_GestionarUsuarios.setVisible(false);
        Panel_AgregarCliente.setVisible(false);
        Panel_GestionarClientes.setVisible(false);
        Panel_AgregarProveedor.setVisible(false);
        Panel_GestionarProveedores.setVisible(false);
        Panel_AgregarProducto.setVisible(false);
        Panel_GestionarProductos.setVisible(false);
        Panel_AgregarCategoria.setVisible(false);
        Panel_GestionarCategorias.setVisible(false);
        Panel_AgregarFactura.setVisible(false);
        Panel_GestionarFacturas.setVisible(false);
    }
    //</editor-fold>

}
