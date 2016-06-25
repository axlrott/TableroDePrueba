package tablero.controlador.vista;

import javafx.fxml.FXML;
import tablero.controlador.MainApp;

public class PanelIzquierdoColorController {
	
	private TableroPrincipalController tablero; 
	private MainApp mainApp;
	
	@FXML
	public void handleBotonDefecto(){
		this.tablero.cambiarColorDefecto();
	}
	
	@FXML
	public void handleBotonChocolate(){
		this.tablero.cambiarColorChocolate();
	}
	
	@FXML
	public void handleBotonRojo(){
		this.tablero.cambiarColorRojo();
	}
	
	@FXML
	public void handleBotonFinalizar(){
		this.mainApp.showPanelIzquierdoMovimiento();
	}
	
	public void setTablero(TableroPrincipalController tablero){
		this.tablero = tablero;
	}
	
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    
}
