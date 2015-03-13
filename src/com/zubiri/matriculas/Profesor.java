package com.zubiri.matriculas;

import java.util.Scanner;

public class Profesor extends Persona {
	
	String titulacion;
	String departamento;
	int numProfesores;
	
	public Profesor (String dni, String nombre, String apellido, String titulacion, String departamento) {
		super(dni, nombre, apellido);
		this.titulacion = titulacion;
		this.departamento = departamento;
		this.numProfesores++;
	}
	
	public Profesor(Scanner sc) {
		super(sc);
		System.out.print("Introduce la titulación del profesor: ");
		this.setTitulacion(sc.next());
		System.out.print("Introduce el departamento del profesor: ");
		this.setDepartamento(sc.next());
		this.numProfesores++;
	}
	
	public String getTitulacion() {
		return titulacion;
	}
	
	public void setTitulacion(String titulacion) {
		this.titulacion = titulacion;
	}
	
	public String getDepartamento() {
		return departamento;
	}
	
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
	@Override
	public String formatted() {
		String personaStr = 
		super.formatted() + 
		"Titulación: " + this.titulacion + "\n" + 
		"Departamento: " + this.departamento  + "\n";
				
		return personaStr;
	}
	
	@Override
	public void mostrarPersona() {

		super.mostrarPersona();
		System.out.println("Titulación: " + this.getTitulacion());
		System.out.println("Departamento: " + this.getDepartamento());
	}

	public int getNumProfesores() {
		return numProfesores;
	}

	public void setNumProfesores(int numProfesores) {
		this.numProfesores = numProfesores;
	}
	
	public void numeroProfesores() {
		System.out.println("Hay " + this.numProfesores + " profesores");
	}
}
