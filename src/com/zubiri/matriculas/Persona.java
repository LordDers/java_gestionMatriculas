package com.zubiri.matriculas;

import java.util.Scanner;

public abstract class Persona {
	
	String dni;
	String nombre;
	String apellido;

	public Persona(Scanner sc) {
		do {
			try {
				System.out.print("Introduce el DNI de la persona: ");
				this.setDni(sc.next());
			} catch (Exception e) {
				System.err.println(e);
			}
		} while (this.getDni() == null);
		System.out.print("Introduce el nombre: ");
		this.setNombre(sc.next());
		System.out.print("Introduce el apellido: ");
		this.setApellido(sc.next());
	}
	
	public Persona(String dni, String nombre, String apellido) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
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
		String personaStr = 
		"DNI: " + this.dni + "\n" + 
		"Nombre: " + this.nombre  + "\n" +
		"Apellido: " + this.apellido + "\n";
		
		try {
			return personaStr;
		} catch(NullPointerException e) {
			System.out.println("No se ha podido leer");
			return personaStr;
		}
	}
	
	/**
	 * Metodo que obtiene valores de una persona a partir de un String y 
	 * un caracter separador.
	 */
	public void split(String personaStr, char separator) {
		String[] strArray = personaStr.split(separator+"");
		this.setDni(strArray[0]);
		this.setNombre(strArray[1]);
		this.setApellido(strArray[2]);
	}
	
	public void mostrarPersona() {

		System.out.println("DNI: " + this.getDni());
		System.out.println("Nombre: " + this.getNombre());
		System.out.println("Apellido: " + this.getApellido());
	}
}
