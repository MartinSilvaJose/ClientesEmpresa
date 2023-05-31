package org.iesalandalus.programacion.clientesempresa.modelo.dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Cliente {
	private String nombre,dni,correo,telefono;
	private LocalDate fechaNacimiento;
	private final String ER_DNI="([0-9]{8})([Tt|Rr|Ww|Aa|Gg|Mm|Yy|Ff|Pp|Dd|Xx|Bb|Nn|Jj|Zz|Ss|Qq|Vv|Hh|Ll|Cc|Kk|Ee])";
	private final String ER_TELEFONO="[0-9]{9}";
	private final String ER_CORREO=".+@.+\\..+";
	public final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	
	private String formateaNombre(String nombre) {
		nombre = nombre.trim();
		String[] palabras = nombre.toLowerCase().split("\\s+");
		String nuevoNombre = "";

		for (int i = 0; i < palabras.length; i++) {
			String palabra = palabras[i];
			String letra = palabra.charAt(0) + "";
			String minus = palabra.substring(1, palabras[i].length());
			String resultado = letra.toUpperCase() + minus + " ";
			nuevoNombre = nuevoNombre + resultado;
		}
		return nuevoNombre.trim();
	}
		
	private boolean comprobarLetraDni(String dni) {
		if(dni==null) {
			throw new NullPointerException("ERROR:No se puede comprobar la letra de un dni nulo.");
		}
		if(!dni.matches(ER_DNI)) {
			throw new IllegalArgumentException("ERROR:El dni no tiene un formato válido.");
		}
		int calculo=(Integer.parseInt(dni.substring(0,8)))%23;
		char letraDni=dni.toUpperCase().charAt(8);
		char [] letraPosible= {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
		
		
		if(letraPosible[calculo]==letraDni)  {
			return true;
		}
		else {
			return false;
		}
	}
//		Pattern pat=Pattern.compile(ER_DNI);
//		Matcher mat=pat.matcher(dni);
//
//		if(!mat.find()) {
//			throw new IllegalArgumentException("ERROR: La letra del dni del cliente no es correcta.");
//		}
//		
//		int calculo=0;
//		String extraerLetra=mat.group(2);
//		char letra=Character.toUpperCase(extraerLetra.charAt(0));
//		boolean valido=false;
//		
//		calculo=Integer.parseInt(mat.group(1));
//		calculo=calculo%23;
//		switch(calculo) {
//		case 0:
//			if(letra=='T') {
//				valido=true;
//				break;
//			}
//		case 1:
//			if(letra=='R') {
//				valido=true;
//				break;
//			}
//		case 2:
//			if(letra=='W') {
//				valido=true;
//				break;
//			}
//		case 3:
//			if(letra=='A') {
//				valido=true;
//				break;
//			}
//		case 4:
//			if(letra=='G') {
//				valido=true;
//				break;
//			}
//		case 5:
//			if(letra=='M') {
//				valido=true;
//				break;
//			}
//		case 6:
//			if(letra=='Y') {
//				valido=true;
//				break;
//			}
//		case 7:
//			if(letra=='F') {
//				valido=true;
//				break;
//			}
//		case 8:
//			if(letra=='P') {
//				valido=true;
//				break;
//			}
//		case 9:
//			if(letra=='D') {
//				valido=true;
//				break;
//			}
//		case 10:
//			if(letra=='X') {
//				valido=true;
//				break;
//			}
//		case 11:
//			if(letra=='B') {
//				valido=true;
//				break;
//			}
//		case 12:
//			if(letra=='N') {
//				valido=true;
//				break;
//			}
//		case 13:
//			if(letra=='J') {
//				valido=true;
//				break;
//			}
//		case 14:
//			if(letra=='Z') {
//				valido=true;
//				break;
//			}
//		case 15:
//			if(letra=='S') {
//				valido=true;
//				break;
//			}
//		case 16:
//			if(letra=='Q') {
//				valido=true;
//				break;
//			}
//		case 17:
//			if(letra=='V') {
//				valido=true;
//				break;
//			}
//		case 18:
//			if(letra=='H') {
//				valido=true;
//				break;
//			}
//		case 19:
//			if(letra=='L') {
//				valido=true;
//				break;
//			}
//		case 20:
//			if(letra=='C') {
//				valido=true;
//				break;
//			}
//		case 21:
//			if(letra=='K') {
//				valido=true;
//				break;
//			}
//		case 22:
//			if(letra=='E') {
//				valido=true;
//				break;
//			}
//		default:
//			valido=false;
//			
//		}
//		if(!valido==true) {
//			throw new IllegalArgumentException("ERROR: La letra del dni del cliente no es correcta.");
//		}
//		else {
//			return true;
//		}

	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		if(nombre==null) {
			throw new NullPointerException("ERROR: El nombre de un cliente no puede ser nulo.");
		}
		if(nombre.trim().isEmpty()) {
			throw new IllegalArgumentException("ERROR: El nombre de un cliente no puede estar vacío.");
		}
		else {
			this.nombre=formateaNombre(nombre);
		}
	}
	public String getDni() {
		return dni;
	}
	private void setDni(String dni) {
		if(dni==null) {
			throw new NullPointerException("ERROR: El dni de un cliente no puede ser nulo.");
		}
		if(dni.trim().isEmpty()) {
			throw new IllegalArgumentException("ERROR: El dni del cliente no tiene un formato válido.");
		}

		if(comprobarLetraDni(dni)) {
				this.dni = dni;
		}
		else {
			throw new IllegalArgumentException("ERROR: El dni del cliente no tiene un formato válido.");
		}
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		if(correo==null) {
			throw new NullPointerException("ERROR: El correo de un cliente no puede ser nulo.");
		}
		if(correo.trim().isEmpty()) {
			
			throw new IllegalArgumentException("ERROR: El correo del cliente no tiene un formato válido.");
		}

		if(correo.matches(ER_CORREO)) {
			this.correo = correo;
		}
		else {
			throw new IllegalArgumentException("ERROR: El correo del cliente no tiene un formato válido.");
		}
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		if(telefono==null) {
			throw new NullPointerException("ERROR: El teléfono de un cliente no puede ser nulo.");
		}
		if(telefono.trim().isEmpty()) {
			throw new IllegalArgumentException("ERROR: El teléfono del cliente no tiene un formato válido.");
		}
		if(telefono.matches(ER_TELEFONO)) {
			this.telefono = telefono;
		}
		else {
			throw new IllegalArgumentException("ERROR: El teléfono del cliente no tiene un formato válido.");
		}
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		if(fechaNacimiento==null) {
			throw new NullPointerException("ERROR: La fecha de nacimiento de un cliente no puede ser nula.");
		}
			this.fechaNacimiento = fechaNacimiento;
	}
		
	public Cliente(String nombre, String dni, String correo, String telefono, LocalDate fechaNacimiento) {
		setNombre(nombre);
		setDni(dni);
		setCorreo(correo);
		setTelefono(telefono);
		setFechaNacimiento(fechaNacimiento);
	}
	public Cliente(Cliente c) {
		if(c==null) {
			throw new NullPointerException("ERROR: No es posible copiar un cliente nulo.");
		}
		setNombre(c.getNombre());
		setDni(c.getDni());
		setCorreo(c.getCorreo());
		setTelefono(c.getTelefono());
		setFechaNacimiento(c.getFechaNacimiento());
	}
	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(dni, other.dni);
	}
	
	private static String getIniciales(String nombre) {
		String stg="";
		
		for(int i=0;i<nombre.length();i++) {
			String letraActual=String.valueOf(nombre.charAt(i));
			if(letraActual.matches("[A-Z]")) {
				stg+=letraActual;
			}

		}
		return stg;
	}
	@Override
	public String toString() {
		return "nombre=" + nombre + " ("+getIniciales(getNombre())+")" + ", DNI=" + getDni() + ", correo=" + getCorreo() + ", teléfono=" + getTelefono()
				+ ", fecha nacimiento=" + getFechaNacimiento().format(FORMATO_FECHA);
	}
		
}
