import com.zubiri.matriculas.Alumno;
import com.zubiri.matriculas.Alumnos;
import com.zubiri.matriculas.Matriculas;

import java.io.IOException;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

	public static void main(String[] args) throws IOException {
		
		int seleccion=-1;
		Scanner sc = new Scanner(System.in);

		do {
			try{
				//Visualiza por terminal (stdout) las opciones del menu
				System.out.println("Matricular---------------------------------------------1");
				System.out.println("Mostrar alumnos matriculados---------------------------2");
				System.out.println("Buscar Alumno------------------------------------------3");
				System.out.println("Borrar Alumno------------------------------------------4");
				System.out.println("Mostrar Matriculas-------------------------------------5");
				System.out.println("SALIR DEL PROGRAMA-------------------------------------0");
				   
				seleccion = sc.nextInt();
				switch (seleccion) {
					
					case 1: //Matricular alumno
						Alumnos.alumnos.add(new Alumno(sc));
						break;
					
					case 2: //Mostrar alumnos
						//Alumnos.mostrarAlumnos();
						System.out.println(Alumnos.formattedAlumnos());
						break;
					case 3: //Buscar alumnos
						System.out.print("DNI del alumno a buscar: ");
						Alumnos.buscarAlumno(sc.next());
						break;
					case 4: //Borrar alumnos
						System.out.print("¿Qué alumno quieres borrar? ");
						Alumnos.borrarAlumno(sc.next());
						break;
					case 5: //Mostrar matriculas
						Matriculas.mostrarMatriculas();
						break;
					case 0: //Salimos
						break;
					default:
						System.out.println("No ha insertado la opción correcta");
				}
			}catch(InputMismatchException e){
				System.out.println("No ha insertado la opción correcta");
				sc.nextLine();
			}
		} while (seleccion != 0);
		System.out.println("Gracias por usar mi programa. Que tenga un buen día!");
		sc.close();
	}
}