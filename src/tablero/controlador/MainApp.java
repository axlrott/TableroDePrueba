package tablero.controlador;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import tablero.controlador.vista.InicioDeJuegoController;
import tablero.controlador.vista.PanelIzquierdoColorController;
import tablero.controlador.vista.PanelIzquierdoMovimientoController;
import tablero.controlador.vista.TableroPrincipalController;

public class MainApp extends Application {
	private String nombreJugador;
	private Stage primaryStage;
	private BorderPane stageRaiz;
	private TableroPrincipalController tablero;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("TableroDeJuego");
		
		showInicio();
		
	}

	public void showInicio() {
		try{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("vista/InicioDeJuego.fxml"));
			AnchorPane inicio = (AnchorPane) loader.load();
			
            Scene scene = new Scene(inicio);
            primaryStage.setScene(scene);
            primaryStage.show();
            
            InicioDeJuegoController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}
	
	public void showPanelIzquierdoMovimiento(){
		try{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("vista/PanelIzquierdoMovimiento.fxml"));
			AnchorPane panelIzquierdo = (AnchorPane) loader.load();
			
            stageRaiz.setLeft(panelIzquierdo);
            PanelIzquierdoMovimientoController controladorPanelIzquierdo = loader.getController();
            
            controladorPanelIzquierdo.setMainApp(this);
            controladorPanelIzquierdo.setNombreJugador(this.nombreJugador);

        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void showPanelIzquierdoCambioColor(){
		try{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("vista/PanelIzquierdoColor.fxml"));
			AnchorPane panelIzquierdaColor = (AnchorPane) loader.load();
			
            stageRaiz.setLeft(panelIzquierdaColor);
            
            PanelIzquierdoColorController controladorPanelIzquierdoColor = loader.getController();
            
            controladorPanelIzquierdoColor.setMainApp(this);
            controladorPanelIzquierdoColor.setTablero(this.tablero);
			
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void showPanelDerecho(){
		try{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("vista/PanelDerecho.fxml"));
			AnchorPane panelDerecho = (AnchorPane) loader.load();
			
            this.stageRaiz.setRight(panelDerecho);
			
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}

	public void showTablero() {
		try{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("vista/TableroPrincipal.fxml"));
			
			this.stageRaiz = (BorderPane) loader.load();
            Scene scene = new Scene(this.stageRaiz);
            
            TableroPrincipalController controller = loader.getController();
            controller.setMainApp(this);
            
            this.tablero = controller;
            
            primaryStage.setScene(scene);
            primaryStage.sizeToScene();
            primaryStage.show();
           
			
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void showVictoria() {
		try{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("vista/AnuncioVictoria.fxml"));
			AnchorPane victoria = (AnchorPane) loader.load();
			
            Scene scene = new Scene(victoria);
            primaryStage.setScene(scene);
            primaryStage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}

	public TableroPrincipalController getTablero() {
		return this.tablero;
	}
	
	public void setNombreJugador(String nombre){
		this.nombreJugador = nombre;
	}
	
	public String getNombreJugador(){
		return (this.nombreJugador);
	}
}
