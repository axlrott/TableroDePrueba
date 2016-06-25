package tablero.controlador.vista;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import tablero.controlador.MainApp;

public class PanelIzquierdoMovimientoController {
	
	private MainApp mainApp;
	
	@FXML
	private Label nombreJugador;
	@FXML
	private Label cantMovimientos;
	private int numeroMovimientos;
	
	
    @FXML
    private void initialize(){
    	this.numeroMovimientos = 0;
    	this.actualizarMovimientos();
    }
    
	@FXML
	private void handleBotonArriba(){
		this.mainApp.getTablero().moverArriba();
		this.numeroMovimientos ++;
		this.actualizarMovimientos();
	}

	@FXML
	private void handleBotonAbajo(){
		this.mainApp.getTablero().moverAbajo();
		this.numeroMovimientos ++;
		this.actualizarMovimientos();
	}
	
	@FXML
	private void handleBotonIzq(){
		this.mainApp.getTablero().moverIzquierda();
		this.numeroMovimientos ++;
		this.actualizarMovimientos();
	}
	
	@FXML
	private void handleBotonDer(){
		this.mainApp.getTablero().moverDerecha();
		this.numeroMovimientos ++;
		this.actualizarMovimientos();
	}
	
	@FXML
	private void handleColor(){
		this.mainApp.showPanelIzquierdoCambioColor();
		
	}
	@FXML
	private void handleCambioTurno(){
		this.mainApp.getTablero().cambiarJugadorActual();
		this.numeroMovimientos = 0;
		this.actualizarMovimientos();
	}
	
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    public void setNombreJugador(String nombre){
    	this.nombreJugador.setText(nombre);
    }
    
    public void actualizarMovimientos(){
    	String movimientos = String.valueOf(this.numeroMovimientos);
    	this.cantMovimientos.setText(movimientos);
    }

}
