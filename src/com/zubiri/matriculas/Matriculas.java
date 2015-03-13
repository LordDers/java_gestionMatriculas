package com.zubiri.matriculas;

import java.util.ArrayList;
import java.util.Scanner;

public class Matriculas extends Matricula {
	
	private static ArrayList<Matricula> listaMatriculas = new ArrayList<Matricula>();
	
	public Matriculas(Scanner sc) {
		super(sc);
	}
	
	public Matriculas(String nombre, int creditos, Profesor profesor, int anyoMatriculacion, double precio) {
		super(nombre, creditos, profesor, anyoMatriculacion, precio);
	}
	
	public static ArrayList<Matricula> getMatriculas(){
		return listaMatriculas;
	}
	
	public static void setMatriculas(ArrayList<Matricula> matris){
		listaMatriculas=matris;
	}
	
	
	public static void buscarMatriculasNombre(String nombre) {
		int i;
		
		for(i =0; i<listaMatriculas.size(); i++) {
			if (listaMatriculas.get(i).getNombre().equalsIgnoreCase(nombre)) {
				System.out.println(listaMatriculas.get(i).formatted());
				break;
			}
		}
		if (i == listaMatriculas.size()) {
			System.out.println("No se han encontrado matriculas");
		}
	}
	
	public static void buscarMatriculasAnyo(int anyoMatriculacion) {
		int i;
		
		for(i =0; i<listaMatriculas.size(); i++) {
			if (listaMatriculas.get(i).getAnyoMatriculacion() == anyoMatriculacion) {
				System.out.println(listaMatriculas.get(i).formatted());
			}
		}
		if (i == listaMatriculas.size()) {
			System.out.println("No se ha encontrado la matricula");
		}
	}
	
	public static void mostrarMatriculas() {
		
		if (listaMatriculas.size() == 0) {
			System.out.println("No se han cargado las matriculas");
		}
		for (int i = 0;i < listaMatriculas.size();i++) {
			System.out.println(listaMatriculas.get(i).formatted());
		}
	}
	
	public static String formattedMatriculas(){
		String matriculasStr = "Listad de Alumnos matriculados\n";
		try{
			if (listaMatriculas.size() == 0) {
				System.out.println("No se han cargado las matriculas");
			}
			for (int i = 0;i < listaMatriculas.size();i++) {
				System.out.println(listaMatriculas.get(i).formatted());
			}
		}catch(NullPointerException e){
			System.out.println("No hay alumnos matriculados");
		}
		return matriculasStr;
	}
	
	public static void mostrarMatriculas(ArrayList<Matricula> matris) {
		
		setMatriculas(matris);
		
		if (listaMatriculas.size() == 0) {
			System.out.println("No se han cargado las matriculas");
		}
		for (int i = 0;i < listaMatriculas.size();i++) {
			System.out.println(listaMatriculas.get(i).formatted());
		}
	}
	
	public static /*ArrayList<Matricula>*/void crearMatriculas(Scanner sc){
		int opcion;
		System.out.println("¿Cuántos matriculas quieres crear? ");
		opcion = sc.nextInt();
		for (int a = 0; a < opcion; a++) {
			//listaMatriculas.add(new Matricula(sc));
			new Matricula(sc);
		}
		//return listaMatriculas;
	}
	
	public static void anyadirMatricula(Matricula matricula){
		listaMatriculas.add(matricula);
	}
}