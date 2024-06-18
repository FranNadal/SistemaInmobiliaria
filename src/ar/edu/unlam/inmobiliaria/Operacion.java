package ar.edu.unlam.inmobiliaria;

public class Operacion {
Integer id;
Propiedad propiedad;
Cliente cliente;
TipoOperacion tipoOperacion;
public Operacion(Integer id, Propiedad propiedad, Cliente cliente, TipoOperacion tipoOperacion) {
	super();
	this.id = id;
	this.propiedad = propiedad;
	this.cliente = cliente;
	this.tipoOperacion = tipoOperacion;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public Propiedad getPropiedad() {
	return propiedad;
}
public void setPropiedad(Propiedad propiedad) {
	this.propiedad = propiedad;
}
public Cliente getCliente() {
	return cliente;
}
public void setCliente(Cliente cliente) {
	this.cliente = cliente;
}
public TipoOperacion getTipoOperacion() {
	return tipoOperacion;
}
public void setTipoOperacion(TipoOperacion tipoOperacion) {
	this.tipoOperacion = tipoOperacion;
}


}
