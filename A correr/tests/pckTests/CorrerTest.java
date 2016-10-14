package pckTests;

import java.io.File;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

import pckCorrer.Correr;

public class CorrerTest {
	@Test
	public void caso1(){
		
		Correr co = new Correr(".\\Preparacion de Prueba\\Lote de Prueba\\Entrada\\Caso1.in");
		int [][] res=co.Resolver();
		co.GenerarSalida(".\\Ejecucion de Prueba\\Salida obtenida\\Caso1.out", res);
		int [][] resEsperado=new int[3][4];
		Scanner sc = null;
		try{
			
			sc = new Scanner(new File(".\\Preparacion de Prueba\\Lote de Prueba\\SalidaEsperada\\Caso1.out"));
			for (int i = 0; i < resEsperado.length; i++) {
				for (int j = 0; j < 4; j++) {
					resEsperado[i][j]=sc.nextInt();
				}
			}
		
			sc.close();
		}catch(Exception e){
			System.out.println("Mensaje de la excepción: " + e.getMessage());
		}
		finally{
			sc.close();
		}
		Assert.assertArrayEquals(resEsperado,res);
	}
	@Test
	public void caso2(){
		
		Correr co = new Correr(".\\Preparacion de Prueba\\Lote de Prueba\\Entrada\\Caso2.in");
		int [][] res=co.Resolver();
		co.GenerarSalida(".\\Ejecucion de Prueba\\Salida obtenida\\Caso2.out", res);
		int [][] resEsperado=new int[3][4];
		Scanner sc = null;
		try{
			
			sc = new Scanner(new File(".\\Preparacion de Prueba\\Lote de Prueba\\SalidaEsperada\\Caso2.out"));
			for (int i = 0; i < resEsperado.length; i++) {
				for (int j = 0; j < 4; j++) {
					resEsperado[i][j]=sc.nextInt();
				}
			}
		
			sc.close();
		}catch(Exception e){
			System.out.println("Mensaje de la excepción: " + e.getMessage());
		}
		finally{
			sc.close();
		}
		Assert.assertArrayEquals(resEsperado,res);
	}
	@Test
	public void caso3(){
		
		Correr co = new Correr(".\\Preparacion de Prueba\\Lote de Prueba\\Entrada\\Caso3.in");
		int [][] res=co.Resolver();
		co.GenerarSalida(".\\Ejecucion de Prueba\\Salida obtenida\\Caso3.out", res);
		int [][] resEsperado=new int[4][4];
		Scanner sc = null;
		try{
			
			sc = new Scanner(new File(".\\Preparacion de Prueba\\Lote de Prueba\\SalidaEsperada\\Caso3.out"));
			for (int i = 0; i < resEsperado.length; i++) {
				for (int j = 0; j < 4; j++) {
					resEsperado[i][j]=sc.nextInt();
				}
			}
		
			sc.close();
		}catch(Exception e){
			System.out.println("Mensaje de la excepción: " + e.getMessage());
		}
		finally{
			sc.close();
		}
		Assert.assertArrayEquals(resEsperado,res);
	}
}
