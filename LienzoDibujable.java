//Richard Daniel Oliva Denis
import java.util.Scanner;
public class LienzoDibujable extends Lienzo implements Dibujable{
		/* METODOS A IMPLEMENTAR:
		A- Dibujable.java:
			public void dibuja(int x, int y);
			public void borra(int x, int y);
			public void guarda(int almacen);
			public void recupera(int almacen);
			public void ejecutaComando(String comando) throws CoordenadaIcorrecta. ComandoIncorrecto. AlmacenIncorrecto;
		B - Lienzo.java:
			public void interactuar();
	*/
	private boolean controlSalida = true;

	public LienzoDibujable(){
		super();
	}

	public void dibuja(int x, int y){
		tablero[x][y] = '*';
	}

	public void borra(int x, int y){
		tablero[x][y] = ' ';
	}

	public void guarda(int almacen){
		for (int a = 0; a < TAMANOTABLERO; a++) {
			for (int b = 0; b < TAMANOTABLERO; b++) {
				this.almacen[almacen][a][b] = tablero[a][b];
			}	
		}
	}

	public void recupera(int almacen){
		for (int a = 0; a < TAMANOTABLERO; a++) {
			for (int b = 0; b < TAMANOTABLERO; b++) {
				tablero[a][b] = this.almacen[almacen][a][b];
			}	
		}
		mostrar();
	}

	public void ejecutaComando (String comando) throws CoordenadaIncorrecta, ComandoIncorrecto, AlmacenIncorrecto {
		
		if (!comando.equalsIgnoreCase("FIN")){ // Primero verificamos que no quiera terminar
			//dado que lo comandos tienen valores finales diferentes, diferenciamos.
			String comandoImplementarOpcionDibBorr = comando.substring(0, (comando.length() - 4));  //Este String se utilizara para Dibujar o Borrar
			String comandoImplementarOpcionGuarRecur = comando.substring(0, (comando.length() - 2)); //Este String se utilizara para Guardar o Recuperar
			//Verificamos que los metodos sean correctos
			if (!(comandoImplementarOpcionDibBorr.equalsIgnoreCase("DIBUJA")||
				comandoImplementarOpcionDibBorr.equalsIgnoreCase("BORRA")||
				comandoImplementarOpcionGuarRecur.equalsIgnoreCase("GUARDA")||
				comandoImplementarOpcionGuarRecur.equalsIgnoreCase("RECUPERA"))) throw new ComandoIncorrecto("Introduzca un comando correcto");
				//Si es el caso de Dibujar o Borrar tomamos este camino
				if (comandoImplementarOpcionDibBorr.equalsIgnoreCase("DIBUJA")||
				comandoImplementarOpcionDibBorr.equalsIgnoreCase("BORRA")) {

					String coorX = comando.substring((comando.length() - 3), (comando.length() - 2));
					String coorY = comando.substring(comando.length()-1);

					if (coorX.length()>3 || coorY.length()>3) throw new CoordenadaIncorrecta("Introduzca una coordenada correcta, bajo el formato: x,y");
					//Verificamos que x y x sean realmente numeros, sino, lanzamos e4
					try {
						int x = Integer.parseInt(coorX);
						int y = Integer.parseInt(coorY);

						if (x > 8 || y > 8) throw new CoordenadaIncorrecta("Introduzca una coordenada correcta, no puede ser 9");
							
						if (comandoImplementarOpcionDibBorr.equalsIgnoreCase("DIBUJA")){
							dibuja(x,y);
							System.out.println("Dibujado!");
						} else {
							borra(x, y);
							System.out.println("Borrado!");
							}
						} catch (NumberFormatException e4) {
							System.out.println("Formato de numero incorrecto. Recuerda: X,Y donde X y Y deben ser numeros!");
						}
				} 
			//Si es el caso de Guardar o Recuperar tomamos este otro camino
			if (comandoImplementarOpcionGuarRecur.equalsIgnoreCase("GUARDA")||
				comandoImplementarOpcionGuarRecur.equalsIgnoreCase("RECUPERA")) {

				String almacenAux = comando.substring(comando.length()-1);
				//Verificamos que x sea realmente un numero, sino, lanzamos e5
				try{
					int almacen = Integer.parseInt(almacenAux);
					if (almacen > 1) throw new AlmacenIncorrecto("Introduzca un almacen correcto, 0 o 1");
					if (comandoImplementarOpcionGuarRecur.equalsIgnoreCase("GUARDA")){
						guarda(almacen);
						System.out.println("Guardado!");
					} else recupera(almacen);
				} catch (NumberFormatException e5){
					System.out.println("Formato de numero incorrecto. Recuerda: X debe ser un numero!");
				}
			}
		} else {
			controlSalida = false;
			System.out.println("Hasta Luego!");
		}
	}

	protected void interactuar(){
		Scanner teclado = new Scanner(System.in);
		do {
			System.out.println("Selecciona: \n DIBUJA x,y \n BORRA x,y \n GUARDA x \n RECUPERA x \n FIN");
			String comando = teclado.nextLine();
			try {
				ejecutaComando(comando);
			} catch (CoordenadaIncorrecta e1){
				System.out.println(e1.getMessage());
			} catch (ComandoIncorrecto e2){
				System.out.println(e2.getMessage());
			} catch (AlmacenIncorrecto e3){
				System.out.println(e3.getMessage());
			}
		} while (controlSalida);
	}
}

