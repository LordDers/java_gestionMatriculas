package com.zubiri.matriculas;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Matricula extends Asignatura {
	
	int anyoMatriculacion;
    double precio;
    
    public Matricula(Scanner sc) {
    	super(sc);
    	do {
	    	try {
	    		System.out.print("Año de matriculación: ");
		    	this.setAnyoMatriculacion(sc.nextInt());
	    	} catch (InputMismatchException e) {
				 System.out.println("Debes introducir un año superior a 0.\n");
				 sc.nextLine();
			}
    	} while(anyoMatriculacion <=0);
    	do {
    		try {
    			System.out.print("Precio: ");
		    	this.setPrecio(sc.nextDouble());
    		} catch (InputMismatchException e) {
				 System.out.println("Debes introducir un número.\n");
				 sc.nextLine();
			}
    	} while(precio <= 0);
    	
    	System.out.print("¿Familia Numerosa? (Si/No) ");
    	if(sc.next().equalsIgnoreCase("Si")){
    		this.setPrecio(this.descuentoFamiliaNumerosa(this.pedirPorcentaje()));
    	} else {
    		this.setPrecio(precio);
    	}
    	Matriculas.anyadirMatricula(this);
    }
    
    public Matricula(String nombre, int creditos, Profesor profesor, int anyoMatriculacion, double precio) {
    	super(nombre, creditos, profesor);
    	this.anyoMatriculacion = anyoMatriculacion;
    	this.precio = precio;
    	Matriculas.anyadirMatricula(this);
    }
    
	/*public String getAsignatura() {
		return asignatura;
	}
	
	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}*/
	
	public int getAnyoMatriculacion() {
		return anyoMatriculacion;
	}
	
	public void setAnyoMatriculacion(int anyoMatriculacion) {
		this.anyoMatriculacion = anyoMatriculacion;
	}
	
	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
    
	/**
	 * Metodo que calcula un descuento basado en porcentaje sobre el precio original
	 * de la matrícula.
	 * @return
	 */
	public double descuentoFamiliaNumerosa(int porcentaje) {
		Double dtoFamiliaNumerosa;
		dtoFamiliaNumerosa = this.precio - (this.precio * porcentaje) / 100;
		
		return dtoFamiliaNumerosa;
	}
	
	@Override
	public String formatted() {
		String asignaturaStr = 
		"Año de matriculación: " + this.anyoMatriculacion + "\n" + 
		"Precio: " + this.precio  + "\n" + 
		super.formatted();
		
		return asignaturaStr;
	}
	
	@Override
	public void mostrarAsignatura() {

		super.mostrarAsignatura();
		System.out.println("Año de matriculación: " + this.getAnyoMatriculacion());
		System.out.println("Precio: " + this.getPrecio());
	}
	
	public int pedirPorcentaje()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Porcentaje de familia numerosa: ");
		return sc.nextInt();
	}
}