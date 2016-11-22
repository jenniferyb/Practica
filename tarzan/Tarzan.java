package tarzan;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Tarzan {

	private boolean[] estado;
	private int[] anterior;
	private int[] distancia;
	private int[][] matriz;
	private PriorityQueue<Nodo> cola;
	private int cantidadArboles;
	private Nodo nodoActual;
	private ArrayList<String> arboles;

	public Tarzan(String nombreArchivo) {
		FileReader fr = null;
		BufferedReader archivo = null;
		try {
			fr = new FileReader(nombreArchivo + ".in");
			archivo = new BufferedReader(fr);
			String linea;
			cantidadArboles = 0;
			arboles = new ArrayList<String>();
			while ((linea = archivo.readLine()) != null) {
				arboles.add(linea);
			}
			cantidadArboles = arboles.size();
			archivo.close();
			inicializa();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void inicializa() {
		estado = new boolean[cantidadArboles];
		anterior = new int[cantidadArboles];
		distancia = new int[cantidadArboles];
		String[] datos = new String[2];
		int cordenadaX;
		int cordenaday;
		double distanciaArboles;
		matriz = new int[cantidadArboles][cantidadArboles];
		for (int i = 0; i < cantidadArboles; i++) {
			estado[i] = false;
			anterior[i] = -1;
			distancia[i] = 1000;
			datos = arboles.get(i).split(" ");
			cordenadaX = Integer.parseInt(datos[0]);
			cordenaday = Integer.parseInt(datos[1]);
			for (int j = 0; j < cantidadArboles; j++) {
				datos = arboles.get(j).split(" ");
				distanciaArboles = Math.sqrt(Math.pow((Double.parseDouble(datos[0]) - cordenadaX), 2)
						+ Math.pow((Double.parseDouble(datos[1]) - cordenaday), 2));
				// agregar esta condidion
				if (distanciaArboles <= 50) {
					matriz[i][j] = 1;
				} else {
					matriz[i][j] = 0;
				}
			}
			distancia[0] = 0;// la distancia y antecesor del primero en 0
			anterior[0] = 0;
		}
		cola = new PriorityQueue<Nodo>();
	}

	public void resuelve() {
		cola.add(new Nodo(0, 0));
		int pesoAuxiliar;
		while (!cola.isEmpty()) {
			nodoActual = cola.poll();
			if (estado[nodoActual.getPrimero()] == false) {
				estado[nodoActual.getPrimero()] = true;
				for (int i = 0; i < cantidadArboles; i++) {
					if (matriz[nodoActual.getPrimero()][i] != 0 && estado[i] == false) {
						pesoAuxiliar = matriz[nodoActual.getPrimero()][i];
						if (distancia[nodoActual.getPrimero()] + pesoAuxiliar < distancia[i]) {
							distancia[i] = distancia[nodoActual.getPrimero()] + pesoAuxiliar;
							anterior[i] = nodoActual.getPrimero();
							cola.add(new Nodo(i, pesoAuxiliar));
						}
					}
				}
			}
		}
	}

	public void mostrarMatriz() {
		for (int i = 0; i < cantidadArboles; i++) {
			for (int j = 0; j < cantidadArboles; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println(" ");
		}
	}

	public void mostrarDistancias() {
		for (int i = 0; i < cantidadArboles; i++) {
			System.out.print(distancia[i] + " ");
		}
		System.out.println(" ");
	}

	public void mostrarAnterior() {
		for (int i = 0; i < cantidadArboles; i++) {
			System.out.print(anterior[i] + " ");
		}
		System.out.println(" ");
	}

	public void encuentraCamino(String nombreArchivo) {
		PrintWriter archivo = null;
		int cantidad = distancia[cantidadArboles - 1];
		int[] respuesta = new int[cantidad];
		try {
			archivo = new PrintWriter(nombreArchivo + ".out");
			if (cantidad != 1000 && cantidad > 1) {
				for (int i = 0; i < cantidad; i++) {
					if (i == 0) {
						respuesta[i] = anterior[cantidadArboles - 1];
					} else {
						respuesta[i] = anterior[respuesta[i - 1]];
					}
				}
				for (int i = cantidad - 1; i >= 0; i--) {
					archivo.println(arboles.get(respuesta[i]));
				}
				archivo.println(arboles.get(cantidadArboles - 1));
			} else {
				archivo.println("NO HAY RUTA");
			}
			archivo.close();
		} catch (Exception e) {
			e.getMessage();
		}
	}
}
