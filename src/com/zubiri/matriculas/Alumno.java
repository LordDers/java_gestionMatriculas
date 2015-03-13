package com.zubiri.matriculas;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Alumno extends Persona {
	
	//Año en el que se inscribió por primera vez en alguna asignatura
	int anyoInscripcion = -1;
	//Ciclo que cursa el alumno
	String ciclo = null;
	
	//Matrículas realizadas a lo largo de los años en las distintas asignaturas
	ArrayList<Matricula> matriculas = null;
	
	int numAlumnos;
	
	public Alumno (String dni, String nombre, String apellido, int anyoInscripcion, String ciclo) {
		super(dni, nombre, apellido);
		this.anyoInscripcion = anyoInscripcion;
		this.ciclo = ciclo;
		this.numAlumnos++;
	}
	
	public Alumno (Scanner sc) {
		super(sc);
		do {
			try {
				System.out.print("Año de inscripción: ");
				this.setAnyoInscripcion(sc.nextInt());
			} catch (InputMismatchException e) {
				 System.out.println("Debes introducir un año superior a 0.\n");
				 sc.nextLine();
			}
		} while (anyoInscripcion <= 0);
		System.out.print("Ciclo: ");
		this.setCiclo(sc.next());
		this.numAlumnos++;
		Matriculas.crearMatriculas(sc);
		setMatriculas(Matriculas.getMatriculas());
	}
	
	public int getAnyoInscripcion() {
		return anyoInscripcion;
	}
	
	public void setAnyoInscripcion(int anyoInscripcion) {
		this.anyoInscripcion = anyoInscripcion;
	}
	
	public ArrayList<Matricula> getMatriculas() {
		return matriculas;
	}
	
	public void setMatriculas(ArrayList<Matricula> matriculas) {
		this.matriculas = matriculas;
	}
	
	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}
	
	@Override
	public String formatted() {
		String personaStr = 
		super.formatted() + 
		"Año de inscripción: " + this.anyoInscripcion + "\n" + 
		"Ciclo: " + this.ciclo  + "\n";
				
		return personaStr;
	}
	
	@Override
	public void mostrarPersona() {

		super.mostrarPersona();
		System.out.println("Año de inscipción: " + this.getAnyoInscripcion());
		System.out.println("Ciclo: " + this.getCiclo());
		Matriculas.mostrarMatriculas(this.matriculas);
	}

	public int getNumAlumnos() {
		return numAlumnos;
	}

	public void setNumAlumnos(int numAlumnos) {
		this.numAlumnos = numAlumnos;
	}
	
	public void numeroAlumnos() {
		System.out.println("Hay " + this.numAlumnos + " alumnos");
	}
	
	public static void anyadirMatriculaAlumno() {
		
	}
}
