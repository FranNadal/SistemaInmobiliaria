package ar.edu.unlam.inmobiliaria;

import java.util.Objects;

public class Cliente {
Integer dni;
String nombre;
public Cliente(Integer dni, String nombre) {
	super();
	this.dni = dni;
	this.nombre = nombre;
}
public Integer getDni() {
	return dni;
}
public void setDni(Integer dni) {
	this.dni = dni;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
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


}
