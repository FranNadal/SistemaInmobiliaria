package ar.edu.unlam.inmobiliaria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

import org.junit.Test;

public class TestInmobiliaria {
@Test
public void queSePuedaAgregarUnaPropiedadAlaInmobiliaria() {
	Inmobiliaria russo= new Inmobiliaria();
	
	Integer idPropiedad=1;
	Double precio=20.000;
	String ubicacion="Luzuriaga";
	TipoPropiedad tipoPropiedad= TipoPropiedad.casa;
	Propiedad propiedad= new Propiedad(idPropiedad,precio,ubicacion,tipoPropiedad);
	
	assertTrue(russo.agregarPropiedad(propiedad));
	
}

@Test
public void queSePuedaModificarUnaPropiedadExistenteEnLaInmobiliaria() throws Exception {
	Inmobiliaria russo= new Inmobiliaria();
	
	Integer idPropiedad=1;
	Double precio=20.000;
	String ubicacion="Luzuriaga";
	TipoPropiedad tipoPropiedad= TipoPropiedad.casa;
	Propiedad propiedad= new Propiedad(idPropiedad,precio,ubicacion,tipoPropiedad);
	russo.agregarPropiedad(propiedad);
	
	Double nuevoPrecio=40.000;
	
	russo.modificarPropiedad(idPropiedad,nuevoPrecio);
	
	assertEquals(nuevoPrecio, propiedad.getPrecio());
}

@Test
public void queSePuedaDarDeAltaUnClienteEnLaInmobiliaria() {
	Inmobiliaria russo= new Inmobiliaria();
	
	Integer dni=4644;
	String nombre="franco";
	
	Cliente cliente= new Cliente(dni,nombre);
	
	assertTrue(russo.agregarCliente(cliente));
}

@Test

public void queSePuedaObtenerElListadoDePropiedadesOrdenadoPorPrecio() {
Inmobiliaria russo= new Inmobiliaria();
	
	Integer idPropiedad=1;
	Double precio=20.000;
	String ubicacion="Luzuriaga";
	TipoPropiedad tipoPropiedad= TipoPropiedad.casa;
	Propiedad propiedad= new Propiedad(idPropiedad,precio,ubicacion,tipoPropiedad);
	Propiedad propiedad1= new Propiedad(2,45.000,ubicacion,tipoPropiedad);
	Propiedad propiedad2= new Propiedad(3,10.000,ubicacion,tipoPropiedad);
	russo.agregarPropiedad(propiedad);
	russo.agregarPropiedad(propiedad1);
	russo.agregarPropiedad(propiedad2);
	
	TreeSet<Propiedad>propiedadesOrdenadas=russo.ordenarPropiedadesPorPrecio();
	ArrayList<Propiedad>propiedadesEsperadas= new ArrayList<>();
	propiedadesEsperadas.add(propiedad2);
	propiedadesEsperadas.add(propiedad);
	propiedadesEsperadas.add(propiedad1);
	
	
	assertEquals(propiedadesEsperadas, new ArrayList<>(propiedadesOrdenadas));
	
}
@Test

public void queSePuedaObtenerElListadoDePropiedadesOrdenadoPorUbicacion() {
Inmobiliaria russo= new Inmobiliaria();
	
	Integer idPropiedad=1;
	Double precio=20.000;
	String ubicacion="luzuriaga";
	TipoPropiedad tipoPropiedad= TipoPropiedad.casa;
	Propiedad propiedad= new Propiedad(idPropiedad,precio,ubicacion,tipoPropiedad);
	Propiedad propiedad1= new Propiedad(2,precio,"avenida",tipoPropiedad);
	Propiedad propiedad2= new Propiedad(3,precio,"ituzaingo",tipoPropiedad);
	russo.agregarPropiedad(propiedad);
	russo.agregarPropiedad(propiedad1);
	russo.agregarPropiedad(propiedad2);
	
	TreeSet<Propiedad>propiedadesOrdenadas=russo.ordenarPropiedadesPorUbicacion();
	ArrayList<Propiedad>propiedadesEsperadas= new ArrayList<>();
	propiedadesEsperadas.add(propiedad1);
	propiedadesEsperadas.add(propiedad2);
	propiedadesEsperadas.add(propiedad);
	
	
	
	assertEquals(propiedadesEsperadas, new ArrayList<>(propiedadesOrdenadas));
	
}

@Test
public void queSePuedaRealizarLaVentaDeUnaPropiedad() throws Exception {
	Inmobiliaria russo= new Inmobiliaria();
	
	Integer idPropiedad=1;
	Double precio=20.000;
	String ubicacion="Luzuriaga";
	TipoPropiedad tipoPropiedad= TipoPropiedad.casa;
	Propiedad propiedad= new Propiedad(idPropiedad,precio,ubicacion,tipoPropiedad);
	russo.agregarPropiedad(propiedad);
	
	
	Integer dni=4644;
	String nombre="franco";
	Cliente cliente= new Comprador(dni,nombre);
	russo.agregarCliente(cliente);
	
	russo.realizarVenta(idPropiedad,dni);
	
	Operacion recibida=russo.buscarOperacion(1);
	
	assertNotNull(recibida);
}

@Test
public void queSePuedaObtenerCuantasPropiedadesComproUnCliente() throws Exception {
	Inmobiliaria russo= new Inmobiliaria();
	
	Integer idPropiedad=1;
	Double precio=20.000;
	String ubicacion="Luzuriaga";
	TipoPropiedad tipoPropiedad= TipoPropiedad.casa;
	Propiedad propiedad= new Propiedad(idPropiedad,precio,ubicacion,tipoPropiedad);
	russo.agregarPropiedad(propiedad);
	Propiedad propiedad1= new Propiedad(2,precio,ubicacion,tipoPropiedad);
	russo.agregarPropiedad(propiedad1);
	
	
	Integer dni=4644;
	String nombre="franco";
	Cliente cliente= new Comprador(dni,nombre);
	russo.agregarCliente(cliente);
	
	russo.realizarVenta(idPropiedad,dni);
	russo.realizarVenta(2,dni);
	
HashSet<Propiedad>propiedadesObtenidas= russo.obtenerCuantasPropiedadesTieneUnCliente(dni);

assertEquals(2, propiedadesObtenidas.size());
}
}
