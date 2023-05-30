package org.iesalandalus.programacion.clientesempresa.vista;

import org.iesalandalus.programacion.utilidades.Entrada;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.iesalandalus.programacion.clientesempresa.modelo.dominio.*;

public class Consola {
	private Consola() {
		
	}
	public static void mostrarMenu() {
		System.out.println("Elija la opcion a realizar:");
		System.out.println("1.-Insertar un cliente.");
		System.out.println("2.-Buscar un cliente.");
		System.out.println("3.-Borrar un cliente.");
		System.out.println("4.-Mostrar todos los clientes.");
		System.out.println("5.-Buscar cliente por fecha de nacimiento.");
		System.out.println("6.-Salir.");
	}
	public static Opcion elegirOpcion() {
		int opcionElegida;
		do{
			System.out.println("Elija del 1-6.");
			opcionElegida=Entrada.entero();
			
		}while(opcionElegida<0 && opcionElegida>7);
		
		
		switch(opcionElegida){
		case 1:
			
				return Opcion.INSERTAR_CLIENTE;

		case 2:

				return Opcion.BUSCAR_CLIENTE;

		case 3:

				return Opcion.BORRAR_CLIENTE;

		case 4:

				return Opcion.MOSTRAR_CLIENTES;

		case 5:

				return Opcion.MOSTRAR_CLIENTES_FECHA;
				
		case 6:

				return Opcion.SALIR;
				
		default:
			throw new IllegalArgumentException("ERROR:La opcion elegida no esta entre las opciones del menú.");
		}
		/*Opcion [] opcion=Opcion.values();
		System.out.println("Eliga una opción.");
		for(int i=0;i<opcion.length;i++) {
			System.out.println((i+1)+".-"+opcion[i]);
		}
		int eleccion=Entrada.entero()-1;
		return opcion[eleccion];*/
	}
	
	
	public static Cliente leerCliente() {
		
		System.out.println("Introduzca el nombre.");
		String nombre=Entrada.cadena();
		System.out.println("Introduzca el dni.");
		String dni=Entrada.cadena();
		System.out.println("Introduzca el correo.");
		String correo=Entrada.cadena();
		System.out.println("Introduzca el telefono.");
		String telefono=Entrada.cadena();
		System.out.println("Introduzca la fecha de nacimiento dd/MM/yyyy.");
		LocalDate fechaNacimiento=leerFechaNacimiento();

		Cliente cliente=new Cliente(nombre,dni,correo,telefono,fechaNacimiento);
		return cliente;
		

	}
	public static Cliente leerClienteDni() {
		System.out.println("Introduzca el DNI del cliente que buscas.");
		String dni=Entrada.cadena();
		
		Cliente cliente= new Cliente("Bob Esponja",dni,"bob_esponja@patricio.mar","616161616",LocalDate.now());
		
		return cliente;
	}
	public static LocalDate leerFechaNacimiento() {
		String ER_FECHA = "^([0-2][0-9]|3[0-1])(\\/|-)(0[1-9]|1[0-2])\\2(\\d{4})$";
		DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String fecha = "";
		do {
			fecha = Entrada.cadena();
		} while (!fecha.matches(ER_FECHA));

		LocalDate fechaNacimiento = LocalDate.parse(fecha, FORMATO);

		return fechaNacimiento;
	}
	
}
