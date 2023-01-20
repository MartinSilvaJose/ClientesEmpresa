package org.iesalandalus.programacion.clientesempresa.modelo.negocio;
import org.iesalandalus.programacion.clientesempresa.modelo.dominio.*;
public class Clientes {
	private int capacidad;
	private int tamano;
	private Cliente [] coleccionClientes;
	
	public Clientes(int capacidad) {
		if (capacidad<=0) {
			throw new IllegalArgumentException("ERROR:La capacidad de clientes no puede ser menor que 0.");
		}
		this.capacidad=capacidad;
		this.tamano=0;
		coleccionClientes= new Cliente[capacidad];
	}
	public int getCapacidad() {
		return capacidad;
	}
	public int getTamano() {
		return tamano;
	}
	public Cliente [] get(){
		for(int i=0;i<coleccionClientes.length;i++) {
			int indice=0;
			if (coleccionClientes[i]!=null){
				coleccionClientes[indice]=new Cliente(coleccionClientes[i]);
			}
		}
		return coleccionClientes;
	}
	
	private boolean capacidadSuperada(int indice) {
		int contador=0;
		for(int i=indice;i<coleccionClientes.length;i++) {
			if (coleccionClientes[i]==null) {
				contador++;
			}
		}
		if (contador==0) {
			return true;				
		}
		else {
			return false;
		}
	}
	private boolean tamanoSuperado(int indice) {
		if (indice>coleccionClientes.length) {
			return true;
		}
		else {
			return false;
		}
		
		
	}
	private int buscarIndice(Cliente cliente) {
		
		int indice=0;
		for(int i=0;i<coleccionClientes.length;i++) {
			if (cliente.equals(coleccionClientes[i])) {
				indice=i;
			}
		}
		if (indice!=0) {
			return indice;
		}
		else
			indice=coleccionClientes.length+1;
		return indice;
		
	}
	public void insertar(Cliente cliente){
		
		if(capacidadSuperada(capacidad)) {
			throw new IllegalArgumentException("ERROR:No caben más clientes en la lista");
		}
		if(tamanoSuperado(capacidad)) {
			throw new IllegalArgumentException("ERROR:Se esta superando el tamaño de la lista");
		}
		for(int i=0;i<coleccionClientes.length;i++) {
			if(coleccionClientes[i]==null) {
				coleccionClientes[i]=new Cliente(cliente);
			}
		}
	}
	public void buscar(Cliente cliente) {
		if(cliente==null) {
			throw new NullPointerException("ERROR:El cliente a borrar no puede ser null.");
		}
		for(int i=0;i<coleccionClientes.length;i++) {
			if (cliente.equals(coleccionClientes[i])) {
				coleccionClientes[i]=new Cliente(cliente);
			}
			else {
				cliente=null;
			}
		}
	}
	private void desplazarUnaPosicionHaciaIzquierda(int indice) {

		while(coleccionClientes[(indice+1)]!=null && indice<coleccionClientes.length) {
			coleccionClientes[indice]=coleccionClientes[indice+1];
			indice++;
		}
	}
	public void borrar(Cliente cliente) {
		if(cliente==null) {
			throw new NullPointerException("ERROR:El cliente a borrar no puede ser null.");
		}
		else {
			desplazarUnaPosicionHaciaIzquierda(buscarIndice(cliente));
		}


	}
}


