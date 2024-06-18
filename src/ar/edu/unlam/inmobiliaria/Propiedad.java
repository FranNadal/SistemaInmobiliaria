package ar.edu.unlam.inmobiliaria;

import java.util.Objects;

public class Propiedad implements Comparable<Propiedad>{
Integer id;
Double precio;
String ubicacion;
TipoPropiedad tipoPropiedad;
public Propiedad(Integer id, Double precio, String ubicacion, TipoPropiedad tipoPropiedad) {
	super();
	this.id = id;
	this.precio = precio;
	this.ubicacion = ubicacion;
	this.tipoPropiedad = tipoPropiedad;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public Double getPrecio() {
	return precio;
}
public void setPrecio(Double precio) {
	this.precio = precio;
}
public String getUbicacion() {
	return ubicacion;
}
public void setUbicacion(String ubicacion) {
	this.ubicacion = ubicacion;
}
public TipoPropiedad getTipoPropiedad() {
	return tipoPropiedad;
}
public void setTipoPropiedad(TipoPropiedad tipoPropiedad) {
	this.tipoPropiedad = tipoPropiedad;
}
@Override
public int hashCode() {
	return Objects.hash(id);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Propiedad other = (Propiedad) obj;
	return Objects.equals(id, other.id);
}
@Override
public int compareTo(Propiedad o) {
	int resultado=this.precio.compareTo(o.getPrecio());
	if(resultado==0) {
		resultado=this.ubicacion.compareTo(o.getUbicacion());
	}
	return resultado;
}

}

