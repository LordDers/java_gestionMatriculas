package com.zubiri.matriculas;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Asignatura {

	String nombre;
	int creditos;
	Profesor profesor;
	
	public Asignatura (Scanner sc) {
		System.out.print("Asignatura: ");
		this.setNombre(sc.next());
		do {
			try {
				System.out.print("Créditos: ");
				this.setCreditos(sc.nextInt());
			} catch (InputMismatchException e) {
				 System.out.println("Debes introducir un número.\n");
				 sc.nextLine();
			}
		} while (creditos <= 0);
		System.out.println("Datos del profesor: \n");
		setProfesor(new Profesor(sc));
	}
	
	public Asignatura (String nombre, int creditos, Profesor profesor) {
		this.nombre = nombre;
		this.creditos = creditos;
		this.profesor = profesor;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getCreditos() {
		return creditos;
	}
	
	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}
	
	public Profesor getProfesor() {
		return profesor;
	}
	
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	
	/**
	 * Metodo que retorna un String con los valores de las propiedades
	 * formateados del siguiente modo:
	 *  <NOMBRE_PROPIEDAD1> : <VALOR_PROPIEDAD1>\n
	 *  <NOMBRE_PROPIEDAD2> : <VALOR_PROPIEDAD2>\n 
	 *  .....
	 * @return String
	 */
	
	public String formatted() {
		String asignaturaStr = 
		"Nombre Asignatura: " + this.nombre + "\n" + 
		"Créditos: " + this.creditos  + "\n" +
		"Profesor: \n" + this.profesor.formatted() + "\n";
		
		return asignaturaStr;
	}
	
	/**
	 * Método que obtiene valores de una asignatura a partir de un String y 
	 * un caracter separador.
	 */
	public void split(String personaStr, String separator) {
		String[] strArray = personaStr.split(separator);
		this.setNombre(strArray[0]);
		this.setCreditos(Integer.parseInt(strArray[1]));
	}
	
	public void mostrarAsignatura() {

		System.out.println("Nombre: " + this.getNombre());
		System.out.println("Créditos: " + this.getCreditos());
		profesor.mostrarPersona();
	}
}
