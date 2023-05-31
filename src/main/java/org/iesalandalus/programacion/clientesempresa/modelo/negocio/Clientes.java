package org.iesalandalus.programacion.clientesempresa.modelo.negocio;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.clientesempresa.modelo.dominio.Cliente;

public class Clientes {
	private int capacidad;
	private int tamano;
	public Cliente [] coleccionClientes;
	
	public Clientes(int capacidad){
		if(capacidad<1) {
			throw new IllegalArgumentException("ERROR: La capacidad debe ser mayor que cero.");
		}
		this.tamano=0;
		this.capacidad=capacidad;
		this.coleccionClientes=new Cliente[capacidad];
	}
	public int getCapacidad() {
		return this.capacidad;
	}
	public int getTamano() {
		return this.tamano;
	}

	private boolean tamanoSuperado(int indice){
		return indice>=getTamano();
	}
	
	private boolean capacidadSuperada(int indice) {
		return indice>=getCapacidad();
	}
	
	private int buscarIndice(Cliente cliente) {
		if(cliente==null) {
			throw new NullPointerException("ERROR:No puedes buscar un cliente nulo.");
		}
		
		for(int i=0;i<coleccionClientes.length;i++) {
			if(cliente.equals(coleccionClientes[i])){
				return i;
			}
		}

		return tamano;
	}
	public void insertar(Cliente cliente) throws OperationNotSupportedException {
		if(cliente==null){
			throw new NullPointerException("ERROR: No se puede insertar un cliente nulo.");
		}
		int indice;
		if(coleccionClientes[0]!=null) {
			indice=buscarIndice(cliente);
			
		}else {
			indice=0;
		}

		if(coleccionClientes[indice]==null) {
			if(!capacidadSuperada(tamano)) {
				coleccionClientes[indice]=new Cliente(cliente);
				tamano++;
			}else {
				throw new OperationNotSupportedException("ERROR: No se aceptan más clientes.");
			}

		}else {
			throw new OperationNotSupportedException("ERROR: Ya existe un cliente con ese dni.");
		}
	}
	public Cliente buscar(Cliente cliente) {
		if(cliente==null){
			throw new NullPointerException("");
		}
		
		for(int i=0;i<coleccionClientes.length;i++) {
			if(cliente.equals(coleccionClientes[i])) {
				return new Cliente(coleccionClientes[i]);
			}
		}
		return null;
		
	}
	private void desplazarUnaPosicionHaciaIzquierda(int indice) throws OperationNotSupportedException {
		if(tamanoSuperado(indice) && indice<0) {
			throw new OperationNotSupportedException("ERROR: El indice esta fuera de rango.");
		}
		for(int i=indice;i<coleccionClientes.length;i++) {
			if(coleccionClientes[indice+1]==null) {
				coleccionClientes[indice]=null;
			}else {
				coleccionClientes[indice]=new Cliente(coleccionClientes[indice+1]);
			}
		}

	}
	public void borrar(Cliente cliente) throws OperationNotSupportedException {
		if(cliente==null){
			throw new NullPointerException("ERROR: No se puede borrar un cliente nulo.");
		}
		Cliente clienteEncontrado=buscar(cliente);
		
		if(clienteEncontrado!=null) {
			desplazarUnaPosicionHaciaIzquierda(buscarIndice(clienteEncontrado));
			tamano--;
		}else {
			throw new OperationNotSupportedException("ERROR: No existe ningún cliente como el indicado.");
		}
	}
	private Cliente[] copiaProfundaClientes() {
		if(coleccionClientes==null) {
			throw new NullPointerException("ERROR: La coleccion es nula.");
		}
		Cliente [] nuevaColeccion=new Cliente[capacidad];
		for(int i=0;i<coleccionClientes.length;i++) {
			nuevaColeccion[i]=null;
			if(coleccionClientes[i]!=null) {
				nuevaColeccion[i]=new Cliente(coleccionClientes[i]);
			}
		}
		return nuevaColeccion;
	}
	public Cliente[] get() {
		
		return copiaProfundaClientes();
	}
	
}


