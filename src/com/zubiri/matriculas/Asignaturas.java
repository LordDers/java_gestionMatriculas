package com.zubiri.matriculas;

import java.util.ArrayList;
import java.util.Scanner;

public class Asignaturas extends Asignatura {
	
	private static ArrayList<Asignatura> listaAsignaturas = new ArrayList<Asignatura>();
	
	public Asignaturas(Scanner sc) {
		super(sc);
	}
	
	public Asignaturas(String nombre, int creditos, Profesor profesor) {
		super(nombre, creditos, profesor);
	}
	
	public static void anyadirAsignatura(Asignatura asignatura){
		listaAsignaturas.add(asignatura);
	}
	
	public static void buscarAsignaturas(String nombre) {
		int i;
		
		for(i =0; i<listaAsignaturas.size(); i++) {
			if (listaAsignaturas.get(i).getNombre().equalsIgnoreCase(nombre)) {
				System.out.println(listaAsignaturas.get(i).formatted());
				break;
			}
		}
		if (i == listaAsignaturas.size()) {
			System.out.println("No se han encontrado asignaturas");
		}
	}
	
	public static void mostrarAsignaturas() {
		
		if (listaAsignaturas.size() == 0) {
			System.out.println("No se han cargado las matriculas");
		}
		for (int i = 0;i < listaAsignaturas.size();i++) {
			System.out.println(listaAsignaturas.get(i).formatted());
		}
	}
}