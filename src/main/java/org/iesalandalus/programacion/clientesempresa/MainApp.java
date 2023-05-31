package org.iesalandalus.programacion.clientesempresa;

import java.time.LocalDate;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.clientesempresa.modelo.dominio.Cliente;
import org.iesalandalus.programacion.clientesempresa.modelo.negocio.Clientes;
import org.iesalandalus.programacion.clientesempresa.vista.Consola;
import org.iesalandalus.programacion.clientesempresa.vista.Opcion;

public class MainApp {
	private static final int NUM_MAX_CLIENTES = 5;
	private static Clientes clientes=new Clientes(NUM_MAX_CLIENTES);
	int opcion=0;
	
	private static void insertarCliente() {
		try {
			clientes.insertar(Consola.leerCliente());;
		}catch(IllegalArgumentException | NullPointerException | OperationNotSupportedException e) {
			System.out.println(e.getMessage());
		}

		
	}
	private static void buscarCliente() {
		try {
			Cliente cliente=clientes.buscar(Consola.leerClienteDni());
			if(cliente==null) {
				System.out.println("El cliente que esta buscando no existe.");
			}else {
				System.out.println(cliente);
			}
		}catch(IllegalArgumentException | NullPointerException e) {
			System.out.println(e.getMessage());
		}

	}
	private static void borrarCliente() {
		try {
			clientes.borrar(clientes.buscar(Consola.leerClienteDni()));
		}catch(IllegalArgumentException | OperationNotSupportedException | NullPointerException e) {
		System.out.println(e.getMessage());
		}
	}
	private static void mostrarClientes() {
		if(clientes.getTamano()>0) {
			for(Cliente c :clientes.get()) {
				System.out.println(c);
			}
		}else {
			System.out.println("Actualmente no existe ningún cliente.");
		}

	}
	private static void mostrarClientesFecha() {
		try {
			System.out.println("introduzca fecha de nacimiento del cliente.");
			LocalDate fecha = Consola.leerFechaNacimiento();

			Cliente[] clientes1 = clientes.get();

			for (int i = 0; i < clientes1.length; i++) {
				if (clientes1[i] != null && clientes1[i].getFechaNacimiento().equals(fecha)) {
					System.out.println(clientes1[i]);
				}
			}
		} catch (IllegalArgumentException| NullPointerException e) {
			System.out.println(e.getMessage());
		}

	}
	private static void ejecutarOpcion(Opcion opcion) {
		switch (opcion) {
		case INSERTAR_CLIENTE: {
			insertarCliente();
			break;
		}
		case BUSCAR_CLIENTE: {
			buscarCliente();
			break;
		}
		case BORRAR_CLIENTE: {
			borrarCliente();
			break;
		}
		case MOSTRAR_CLIENTES: {
			mostrarClientes();
			break;
		}
		case MOSTRAR_CLIENTES_FECHA: {
			mostrarClientesFecha();
			break;
		}
		case SALIR: {
			System.out.println("Hasta la próxima.");
			break;
		}
		}
	}
	public static void main(String[] args) {
		Opcion opcion;
		do {
			Consola.mostrarMenu();
			opcion = Consola.elegirOpcion();
			ejecutarOpcion(opcion);

		} while (opcion != Opcion.SALIR);

		
	}

}