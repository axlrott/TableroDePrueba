package tablero.controlador.modelo;

public class Personaje {
	int posicionX;
	int posicionY;
	int MINIMO = 0;
	int MAXIMO = 4;
	
	public Personaje(){
		this.posicionX = 0;
		this.posicionY = 0;
	}
	public int posX(){
		return this.posicionX;
	}
	public int posY(){
		return this.posicionY;
	}
	public void moverIzquierda(){
		if (this.posicionX - 1 >= MINIMO){
			this.posicionX = this.posicionX - 1;
		}
	}
	public void moverDerecha(){
		if (this.posicionX + 1 <= MAXIMO){
			this.posicionX = this.posicionX + 1;
		}
	}
	public void moverArriba(){
		if (this.posicionY - 1 >= MINIMO){
			this.posicionY = this.posicionY - 1;
		}
	}
	public void moverAbajo(){
		if (this.posicionY + 1 <= MAXIMO){
			this.posicionY = this.posicionY + 1;
		}
	}
	
}
