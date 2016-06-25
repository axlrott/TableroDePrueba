package tablero.controlador.vista;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import tablero.controlador.MainApp;

public class InicioDeJuegoController {
	@FXML
	TextField nombreInput;
	@FXML
	Button botonOK;
	
	private MainApp mainApp;
	
	public InicioDeJuegoController(){
		
	}
	
    @FXML
    private void initialize(){

    }
    
    @FXML
    private void handlerBotonOK(){
    	if(!nombreInput.getText().isEmpty()){
        	this.mainApp.setNombreJugador(nombreInput.getText());
        	
        	this.mainApp.showTablero();
            this.mainApp.showPanelDerecho();
            this.mainApp.showPanelIzquierdoMovimiento();
    	}
    }
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
}
