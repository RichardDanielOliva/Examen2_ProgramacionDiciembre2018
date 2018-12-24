# Examen 1ª Evaluación (II). Curso 2018-19. Fecha. 12/12/2018
## Módulo Programación. IES Fernando Wirtz Suárez.
Desenvolvemento de Aplicacións Multiplataforma modalidad Dual.

Desenvolvemento de Aplicacións Web modalidad Dual.
## Profesor: 
Alfonso Pereira
## Alumno/Autor: 
Richard Daniel Oliva Denis. danielolivadenis@gmail.com

Nota examen: 10.0

## Descripción del ejercicio:
Se desea realizar un programa para dibujar en pantalla a base de “*” en un tablero de 9x9.

Para ello el usuario puede poner las siguientes ordenes:

- DIBUJA 8,9 → Pone “*” en esa coordenada
- BORRA 8,1 → Pone “ “ en esa coordenada,
- GUARDA 1 → Guarda el dubujo en el almacen 1 (hay dos almacenes de 0 a 1)
- RECUPERA 1 → Pone en pantalla el dibujo del almacen 1.
- FIN para el programa

#### Apartados:

1. Creamos las siguientes excepciones: CoordenadaIcorrecta. ComandoIncorrecto.
AlmacenIncorrecto
2. Crea un interface Dibujable con los siguientes métodos:
1. public void dibuja(int x, int y);
2. public void borra(int x, int y);
3. public void guarda(int almacen);
4. public void recupera(int almacen);
5. public ejecutaComando(String comando)
throws CoordenadaIcorrecta. ComandoIncorrecto. AlmacenIncorrecto;
3. Define la clase Lienzo que tiene:
1. Un tablero donde dibujar
2. 2 almacenes donde guardar los dibujos
3. Un método inicializar
4. Un constructor que llama a inicializar;
5. Un método mostrar que muestra el tablero
6. Un método abstracto dibuja que interactúa con el usuario y le permite dibujar
4. Tenemos una clase LienzoDibujable que hereda de Lienzo e implementa la clase Dibujable.
Debes definir los atributos y métodos necesarios sin implementarlos
5. Implementa el método ejecutaComando (2 puntos)
6. Implementa el método dibuja y borra
7. Implementa el método guarda y recupera
8. Implementa el método dibuja
9. Una clase Pintar con main que inicie el proceso de dibujar
