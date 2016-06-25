package tablero.controlador.vista;

import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import tablero.controlador.MainApp;
import tablero.controlador.modelo.Personaje;

public class TableroPrincipalController {
	@FXML
	private Circle redondo1;
	@FXML
	private Circle redondo2;
	@FXML
	private GridPane matriz;
	
	private MainApp mainApp;
	
	private Personaje personajeActual;
	private Personaje personaje1;
	private Personaje personaje2;
	private ArrayList<Personaje> OrdenPersonajes;
	
	private Circle redondoActual;
	private ArrayList<Circle> OrdenRedondos;
	
    public TableroPrincipalController() {

    }

    @FXML
    private void initialize(){
    	
    	this.OrdenPersonajes = new ArrayList<>();
    	this.OrdenRedondos = new ArrayList<>();
    	this.personaje1 = new Personaje();
    	this.personaje2 = new Personaje();
    	
    	this.OrdenPersonajes.add(this.personaje2);
    	this.OrdenPersonajes.add(this.personaje1);
    	this.OrdenRedondos.add(this.redondo2);
    	this.OrdenRedondos.add(this.redondo1);
    	
    	this.personajeActual = this.personaje1;
    	this.redondoActual = this.redondo1;
    }
	
	private void realizarMovimiento() {
		matriz.getChildren().remove(this.redondoActual);
		matriz.add(this.redondoActual, personajeActual.posX(), personajeActual.posY());
		this.redondoActual.setTranslateX(25);
	}
	private void comprobarVictoria() {
		if (personajeActual.posX() == 4 && personajeActual.posY() == 4){
			mainApp.showVictoria();
		}
	}

	public void cambiarJugadorActual() {
		this.personajeActual = this.OrdenPersonajes.remove(0);
		this.OrdenPersonajes.add(this.personajeActual);
		this.redondoActual = this.OrdenRedondos.remove(0);
		this.OrdenRedondos.add(this.redondoActual);
	}
	
	public void moverArriba(){
				
		personajeActual.moverArriba();
		realizarMovimiento();
		comprobarVictoria();
	}

	public void moverAbajo(){
		personajeActual.moverAbajo();
		this.realizarMovimiento();
		comprobarVictoria();
	}
	
	public void moverIzquierda(){
		personajeActual.moverIzquierda();
		this.realizarMovimiento();
		comprobarVictoria();
	}
	
	public void moverDerecha(){
		personajeActual.moverDerecha();
		this.realizarMovimiento();
		comprobarVictoria();
	}
	
	public void cambiarColorChocolate(){
		this.redondoActual.fillProperty().set(Color.CHOCOLATE);
	}
	
	public void cambiarColorRojo(){
		this.redondoActual.fillProperty().set(Color.RED);
	}
	
	public void cambiarColorDefecto(){
		this.redondoActual.fillProperty().set(Color.DODGERBLUE);
	}

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
}
