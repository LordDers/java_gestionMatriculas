package com.zubiri.matriculas;

import java.util.ArrayList;

public class Alumnos {
	public static ArrayList<Persona> alumnos = new ArrayList<Persona>();
	
	public static String formattedAlumnos(){
		String alumnosStr = "Listad de Alumnos matriculados\n";
		try{
			for (int i=0;i<alumnos.size();i++){
				alumnosStr += "Alumno " + (i+1) + "\n" + alumnos.get(i).formatted() + "\n";
			}
		}catch(NullPointerException e){
			System.out.println("No hay alumnos matriculados");
		}
		//alumnosStr += Matriculas.formattedMatriculas();
		return alumnosStr;
	}
	
	public static void mostrarAlumnos(){
		try{
			System.out.println("Listad de Alumnos matriculados: ");	
			for (int i=0;i<alumnos.size();i++){
				System.out.println("Alumno "+(i+1)+": \n");
				alumnos.get(i).mostrarPersona();
			}
		}catch(NullPointerException e){
			System.out.println("No hay alumnos matriculados");
		}
	}
	
	public static void borrarAlumno(String dni){
		for (int b = 0; b < alumnos.size(); b++) {
			if (alumnos.get(b).getDni().equalsIgnoreCase(dni)) {
				alumnos.remove(b);
			}
		}
	}
	
	public static void anyadirAlumno(Alumno alumno){
		alumnos.add(alumno);
	}
	
	public static void buscarAlumno(String dni) {
		int i;
		
		for(i =0; i<alumnos.size(); i++) {
			if (alumnos.get(i).getDni().equalsIgnoreCase(dni)) {
				System.out.println(alumnos.get(i).formatted());
				break;
			}
		}
		if (i == alumnos.size()) {
			System.out.println("No se han encontrado alumnos");
		}
	}
}