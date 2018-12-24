//Richard Daniel Oliva Denis
public abstract class Lienzo{
	public char [][] tablero;
	public char [][][] almacen;
	public final int TAMANOTABLERO = 9;
	public final int TAMANOALMACEN = 2;

	public Lienzo(){
		inicializar();
	}

	private void inicializar(){
		tablero = new char[TAMANOTABLERO][TAMANOTABLERO];
		almacen = new char[TAMANOALMACEN][TAMANOTABLERO][TAMANOTABLERO];
	}

	protected void mostrar(){
		for (int a = 0; a < TAMANOTABLERO; a++) {
			for (int b = 0; b < TAMANOTABLERO; b++) {
				System.out.print(tablero[a][b] + " | ");
			}	
			System.out.println("");
		}
	}

	protected abstract void interactuar();

}