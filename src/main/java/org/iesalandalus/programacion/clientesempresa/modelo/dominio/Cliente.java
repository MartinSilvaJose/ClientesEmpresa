package org.iesalandalus.programacion.clientesempresa.modelo.dominio;

import java.util.Date;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cliente {
	private String ER_CORREO,ER_DNI,ER_TELEFONO,FORMATO_FECHA,nombre,dni,correo,telefono;
	private Date fechaNacimiento;
	
	public String formateaNombre(String nombre) {
		if(!nombre.matches("[a-z A-Z]+")) {
			throw new IllegalArgumentException("ERROR: El nombre solo puede contener las letras del abecedario y espacios.");
		}
		String stg="";

		for(int i=0;i<nombre.length();i++) {
			String letraActual=String.valueOf(nombre.charAt(i));
			if (i==0) {
				letraActual=String.valueOf(Character.toUpperCase(nombre.charAt(i)));
			}
			while (letraActual.matches("[ ]")) {
				letraActual=String.valueOf(Character.toUpperCase(nombre.charAt(i+1)));
				i++;
			}
			stg+=letraActual;
		}
		return stg;
	}
	public boolean comprobarLetraDni(String dni) {
		Pattern pat=Pattern.compile("([0-9]{8})([Tt|Rr|Ww|Aa|Gg|Mm|Yy|Ff|Pp|Dd|Xx|Bb|Nn|Jj|Zz|Ss|Qq|Vv|Hh|Ll|Cc|Kk|Ee])");
		Matcher mat=pat.matcher(dni);

		if(!mat.find()) {
			throw new IllegalArgumentException("ERROR: El DNI está mal formado.");
		}
		
		int calculo=0;
		String extraerLetra=mat.group(2);
		char letra=Character.toUpperCase(extraerLetra.charAt(0));
		boolean valido=false;
		
		calculo=Integer.parseInt(mat.group(1));
		calculo=calculo%23;
		switch(calculo) {
		case 0:
			if(letra=='T') {
				valido=true;
				break;
			}
		case 1:
			if(letra=='R') {
				valido=true;
				break;
			}
		case 2:
			if(letra=='W') {
				valido=true;
				break;
			}
		case 3:
			if(letra=='A') {
				valido=true;
				break;
			}
		case 4:
			if(letra=='G') {
				valido=true;
				break;
			}
		case 5:
			if(letra=='M') {
				valido=true;
				break;
			}
		case 6:
			if(letra=='Y') {
				valido=true;
				break;
			}
		case 7:
			if(letra=='F') {
				valido=true;
				break;
			}
		case 8:
			if(letra=='P') {
				valido=true;
				break;
			}
		case 9:
			if(letra=='D') {
				valido=true;
				break;
			}
		case 10:
			if(letra=='X') {
				valido=true;
				break;
			}
		case 11:
			if(letra=='B') {
				valido=true;
				break;
			}
		case 12:
			if(letra=='N') {
				valido=true;
				break;
			}
		case 13:
			if(letra=='J') {
				valido=true;
				break;
			}
		case 14:
			if(letra=='Z') {
				valido=true;
				break;
			}
		case 15:
			if(letra=='S') {
				valido=true;
				break;
			}
		case 16:
			if(letra=='Q') {
				valido=true;
				break;
			}
		case 17:
			if(letra=='V') {
				valido=true;
				break;
			}
		case 18:
			if(letra=='H') {
				valido=true;
				break;
			}
		case 19:
			if(letra=='L') {
				valido=true;
				break;
			}
		case 20:
			if(letra=='C') {
				valido=true;
				break;
			}
		case 21:
			if(letra=='K') {
				valido=true;
				break;
			}
		case 22:
			if(letra=='E') {
				valido=true;
				break;
			}
		default:
			valido=false;
			
		}
		if(!valido==true) {
			throw new IllegalArgumentException("ERROR: El DNI no es válido.");
		}
		else {
			return true;
		}

	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		if(nombre.matches("[a-z A-Z]")) {
			this.nombre = nombre;
		}
		else {
			throw new IllegalArgumentException("ERROR:El nombre debe de contener únicamente carácteres del abecedario.");
		}
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		if(dni.matches("([0-9]{8})([Tt|Rr|Ww|Aa|Gg|Mm|Yy|Ff|Pp|Dd|Xx|Bb|Nn|Jj|Zz|Ss|Qq|Vv|Hh|Ll|Cc|Kk|Ee])")) {
			this.dni = dni;
		}
		else {
			throw new IllegalArgumentException("ERROR:El DNI introducido no esta bien formado.");
		}
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {

		if(correo.matches(".+@.+\\..+")) {
			this.correo = correo;
		}
		else {
			throw new IllegalArgumentException("ERROR:El correo introducido no esta bien formado.");
		}
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
		if(telefono.matches("[0-9]{9}")) {
			this.telefono = telefono;
		}
		else {
			throw new IllegalArgumentException("ERROR:El teléfono introducido no esta bien formado.");
		}
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public Cliente(String nombre, String dni, String correo, String telefono, Date fechaNacimiento) {
		this.nombre = nombre;
		this.dni = dni;
		this.correo = correo;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
	}
	public Cliente(Cliente c) {
		this.nombre = c.nombre;
		this.dni = c.dni;
		this.correo = c.correo;
		this.telefono = c.telefono;
		this.fechaNacimiento = c.fechaNacimiento;
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
	
	public static String getIniciales(String nombre) {
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
		return "Cliente [nombre=" +"("+getIniciales(formateaNombre(nombre))+")"+ nombre + ", dni=" + dni + ", correo=" + correo + ", telefono=" + telefono
				+ ", fechaNacimiento=" + fechaNacimiento + "]";
	}
	
	
	
	
			
}
