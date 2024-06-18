package ar.edu.unlam.inmobiliaria;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class Inmobiliaria {
HashSet<Propiedad>propiedades;
HashSet<Cliente>clientes;
HashSet<Operacion>operaciones;
public Inmobiliaria() {
	super();
	this.clientes= new HashSet<>();
	this.propiedades = new HashSet<>();
	this.operaciones= new HashSet<>();
}
public boolean agregarPropiedad(Propiedad propiedad) {
	// TODO Auto-generated method stub
	return propiedades.add(propiedad);
}
public void modificarPropiedad(Integer idPropiedad, Double nuevoPrecio) throws Exception {
	Propiedad propiedad= buscarPropiedad(idPropiedad);
	propiedad.setPrecio(nuevoPrecio);
	
}
private Propiedad buscarPropiedad(Integer idPropiedad) throws Exception {
	for (Propiedad propiedad : propiedades) {
		if(propiedad.getId().equals(idPropiedad)) {
			return propiedad;
		}
	}
	throw new Exception("Propiedad no encontrada");
}
public boolean agregarCliente(Cliente cliente) {
	// TODO Auto-generated method stub
	return clientes.add(cliente);
}
public TreeSet<Propiedad> ordenarPropiedadesPorPrecio() {
	TreeSet<Propiedad>propiedadesOrdenadas= new TreeSet<>();
	propiedadesOrdenadas.addAll(this.propiedades);
	return propiedadesOrdenadas;
}
public TreeSet<Propiedad> ordenarPropiedadesPorUbicacion() {
	TreeSet<Propiedad>propiedadesOrdenadas= new TreeSet<>();
	propiedadesOrdenadas.addAll(this.propiedades);
	return propiedadesOrdenadas;

}
public void realizarVenta(Integer idPropiedad, Integer dni) throws Exception {
	Propiedad aVender=buscarPropiedad(idPropiedad);
	Cliente aComprar=buscarCliente(dni);
	verificarQueElClienteAComprarSeaUnClienteComprador(aComprar);
	registrarOperacion(aVender,aComprar,TipoOperacion.venta);
	
}

	
private void registrarOperacion(Propiedad aVender, Cliente aComprar, TipoOperacion venta) {
	Operacion operacion= new Operacion(this.operaciones.size()+1, aVender, aComprar, venta);
	this.operaciones.add(operacion);
	
}
private void verificarQueElClienteAComprarSeaUnClienteComprador(Cliente aComprar) throws Exception {
	if(!(aComprar instanceof Comprador)) {
		throw new Exception("El cliente No Es Un comprador");
	
}


}
private Cliente buscarCliente(Integer dni) throws Exception {
	for (Cliente cliente : clientes) {
		if(cliente.getDni().equals(dni)) {
			return cliente;
		}
	}throw new Exception("Cliente no encontrado");

}
public Operacion buscarOperacion(int idOperacion) throws Exception {
	for (Operacion operacion : operaciones) {
		if(operacion.getId().equals(idOperacion)) {
			return operacion;
		}
	}
	throw new Exception("Operacion no Encontrada");
}
public HashSet<Propiedad> obtenerCuantasPropiedadesTieneUnCliente(Integer dni) throws Exception {
	Cliente cliente=buscarCliente(dni);
	HashSet<Propiedad>propiedadesObtenidas= new HashSet<>();
	for (Operacion operacion : operaciones) {
		if(operacion.getCliente().equals(cliente)) {
			propiedadesObtenidas.add(operacion.getPropiedad());
			
		}
	}
	return propiedadesObtenidas;
	
}


}
