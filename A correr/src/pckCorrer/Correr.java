package pckCorrer;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Correr {

	private int cantCorredores;
	private int cantCF;
	private int cantCM;
	private int cantCorredoresMeta;
	private int [][] edadCategoria;
	private String [][] corredores;
	private int [] nroDeCadaCorredor;
	private int [][] resultado;
	
	public Correr(String path){
		Scanner sc = null;
		try{
			sc=new Scanner(new File(path));
			cantCorredores=sc.nextInt();
			cantCF=sc.nextInt();
			cantCM=sc.nextInt();
			cantCorredoresMeta=sc.nextInt();
			
			edadCategoria = new int [cantCF + cantCM][2];
			for (int i = 0; i < cantCF + cantCM; i++) {
				edadCategoria[i][0]=sc.nextInt();
				edadCategoria[i][1]=sc.nextInt();
			}
			
			
			corredores=new String[cantCorredores][2];
			for (int i = 0; i < cantCorredores; i++) {
				corredores[i][0]=sc.next();
				corredores[i][1]=sc.next();			
			}
			
			nroDeCadaCorredor = new int[cantCorredoresMeta];
			for (int i = 0; i < cantCorredoresMeta; i++) {
				nroDeCadaCorredor[i]=sc.nextInt();
			}
			resultado=new int [cantCF + cantCM][4];
			for (int i = 0; i < cantCF + cantCM; i++) {
				for (int j = 0; j < 4; j++) {
					resultado[i][j]=0;
				}
				
			}
			sc.close();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Excepcion en contructor: " + e.getMessage());
		}
	}
	
	public int[][] GanadoresDeCadaCategoria(){
		int k;
		int z=1;
		for (int i = 0; i < edadCategoria.length; i++) {			
			k=1;
			if (i<cantCF){
				resultado[i][0]=i+1;
				for (int j = 0; j <cantCorredoresMeta; j++) {
					
					if (Integer.parseInt(corredores[j][0])>=edadCategoria[i][0] && Integer.parseInt( corredores[j][0])<=edadCategoria[i][1] &&  corredores[j][1].equals("F")  && k <4  ){ 
						System.out.println(nroDeCadaCorredor[j]);
						resultado[i][k]=nroDeCadaCorredor[j];						
						System.out.println(resultado[i][k]);
						k++;
					}
				
				}
			}
			else{
				
				resultado[i][0]=z;
				
				for (int j = 0; j < cantCorredoresMeta; j++) {
					if (Integer.parseInt(corredores[j][0])>=edadCategoria[i][0] && Integer.parseInt(corredores[j][0])<=edadCategoria[i][1] && corredores[j][1].equals("M") && k <4  ){
						resultado[i][k]=nroDeCadaCorredor[j];					
						System.out.println(resultado[i][k]);
						k++;
					}
				}
				z++;
			}
				
		}
		return resultado;
	}
	
	public int[][]Resolver(){
		return this.GanadoresDeCadaCategoria();
	}
	
	public void GenerarSalida(String rutaSalida, int [][] res){
		try{
			FileWriter fw = new FileWriter(rutaSalida);
			for (int i = 0; i < res.length; i++) {
				for (int j = 0; j < 4; j++) {
					fw.write(res[i][j] + " ");
				}
				fw.write(System.getProperty("line.separator"));
			}
			
			fw.close();
			
		}catch(Exception e){
			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
