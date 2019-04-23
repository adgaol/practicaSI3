package service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import entities.Cliente;
import entities.Lugar;
import entities.Producto;
import entities.Tiempo;
import entities.Compra;

@Component
public class ProcessData {
	@Autowired
	private TimeService servicioTiempo;
	@Autowired
	private PlaceService servicioLugar;
	@Autowired
	private ItemService servicioProducto;
	@Autowired
	private ClientService servicioCliente;
	@Autowired
	private PurchaseService servicioCompra;
	/*@Autowired
 	private AccessService servicioAcceso;
	@Autowired
	private ResourceService servicioRecurso;
	@Autowired
	private DataService servicioDatos;*/
	
	@PostConstruct
	//Abrimos el archivo
	public void process(){
		int contAccT = 0;
		try (BufferedReader br = new BufferedReader(new FileReader("Practica_3_SSII_hechos1.csv"))) { //mas-accesos-servidor-nitflex.log
	            String line;	            
	            while ((line = br.readLine()) != null) {  //Vamos linea a linea separando la informacion	
	            	
	            	String resultado = line;
	            	if(contAccT>0) {
	            		String[] datos=resultado.split(";");
	            		String id=datos[0];
	            		String nombre=datos[1];
	            		String apellidos=datos[2];
	            		String email=datos[3];
	            		Integer dia=Integer.parseInt(datos[4]);
	            		String mes=datos[5];
	            		Integer anio=Integer.parseInt(datos[6]);
	            		String capital=datos[7];
	            		String item=datos[8];
	            		String descripcion=datos[9];
	            		Integer importe=Integer.parseInt(datos[10]);
	            		Integer valoracion=Integer.parseInt(datos[11]);
	            		String fechaPedido=datos[12];
	            		Integer diaPedido=Integer.parseInt(fechaPedido.split("/")[0]);
	            		Integer mesPedido=Integer.parseInt(fechaPedido.split("/")[1]);
	            		Integer anioPedido=Integer.parseInt(fechaPedido.split("/")[2]);
	            		//Integer numMoth=servicioTiempo.nameToNumMounth(mes);
	            		String nameMonth=servicioTiempo.numToNameMounth(mesPedido);
	            		String dayOfWeek=servicioTiempo.diaDeLaSemana(diaPedido,mesPedido, anioPedido);
	            		Tiempo tiempo=servicioTiempo.getTiempo(diaPedido,mesPedido, anioPedido);
	            		if(tiempo==null) {
	            			tiempo=new Tiempo(dayOfWeek, diaPedido,nameMonth,mesPedido , anioPedido, servicioTiempo.isWeekend(dayOfWeek));
	            		}
	            		servicioTiempo.guardarTiempo(tiempo);
	            		Lugar lugar =servicioLugar.getLugar(capital);
	            		if(lugar==null) {
	            			lugar =new Lugar(capital,null,0);
	            		}
	            		servicioLugar.guardarLugar(lugar);
	            		Producto producto=servicioProducto.getProducto(item);
	            		if(producto==null) {
	            			producto=new Producto(item, descripcion);
	            		}
	            		servicioProducto.guardarProducto(producto);
	            		Integer numMes=servicioCliente.nameToNumMouth(mes);
	            		Cliente cliente=servicioCliente.getCliente(nombre, apellidos,dia,numMes);
	            		if(cliente==null) {
	            			//String dominio=servicioCliente.getDominio(email);
	            			
	            			cliente=new Cliente(nombre, apellidos, null, email, dia, numMes, anio);
	            		}
	            		servicioCliente.guardarCliente(cliente);
	            		Compra compra= new Compra(importe, valoracion, lugar, producto, tiempo, cliente);
	            		servicioCompra.guardarCompra(compra);
	            			
	            	}
	            	/*
	            	String ip = resultado.split(" - -")[0];
	            	String fecha = resultado.substring(resultado.indexOf("[")+1, resultado.indexOf("]"));
	            	Tiempo tiempo = guardarfecha(fecha);		            	
	            	resultado = resultado.substring(resultado.indexOf("]")+3);
	            	
	            	//Guarda TODOS los accesos del .log
	            	Recursos recurso = new Recursos(resultado.substring(0, resultado.indexOf("\"")));
	            	if (recurso.getUrl().contains("/nitflex/")){
	            		String tipoRecurso=recurso.getUrl();
	            		if(recurso.getUrl().contains("HTTP/"))
	            			tipoRecurso=tipoRecurso.substring(0,tipoRecurso.indexOf("HTTP/"));
	            		tipoRecurso=tipoRecurso.substring(tipoRecurso.lastIndexOf("/"));
	            		if(tipoRecurso.contains(".")){
	            			tipoRecurso=tipoRecurso.substring(tipoRecurso.lastIndexOf("."));
	            			if(tipoRecurso.contains("?"))
	            				tipoRecurso=tipoRecurso.substring(0,tipoRecurso.indexOf("?"));
	            		}else{
	            			tipoRecurso="Otros";
	            		}
	            		recurso.setUrl(tipoRecurso);
	            		
	            		resultado = resultado.substring(resultado.indexOf("\"")+1);
		            	
		            	String numeros = resultado.substring(1,resultado.indexOf("\"")-1);
		            	resultado = resultado.substring(resultado.indexOf("\"")+1);
		            	
		            	String desde = resultado.substring(0,resultado.indexOf("\""));
		            	resultado = resultado.substring(resultado.indexOf("\"")+3);
		            	if(desde.length()>254)
		            		desde="-";

		            	String buscador = resultado.substring(0,resultado.indexOf("\""));
		            	Datos datos = new Datos(ip,numeros,desde,buscador);
		            	
		            	
		            	//Comprueba si existe el dato de tiempo y obtiene su id
		            	long l = servicioTiempo.comprobarTiempo(tiempo);
		            	tiempo.setIdt(l);
		            	
		            	//Comprueba si existe el dato de recursos y obtiene su id
		            	long r = servicioRecurso.comprobarRecurso(recurso);
		            	recurso.setIdr(r);
		            			            	
		            	servicioDatos.guardarDatos(datos); 
		            	
		            	Accesos acceso = new Accesos(recurso, tiempo);
		            	servicioAcceso.guardarAcceso(acceso);
	            	}//if */	               
	            	contAccT++;
	            }//while
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		contAccT = 0;
		try (BufferedReader br = new BufferedReader(new FileReader("Practica_3_SSII_hechos2.csv"))) { //mas-accesos-servidor-nitflex.log
	            String line;	            
	            while ((line = br.readLine()) != null) {  //Vamos linea a linea separando la informacion	
	            	
	            	String resultado = line;
	            	if(contAccT>0) {
	            		String[] datos=resultado.split(";");
	            		String nombreApellido=datos[0];
	            		String email=datos[1];
	            		String fechaAlta=datos[2];
	            		String pais=datos[3].replaceAll("_", " ");
	            		String capital=datos[4];
	            		String item=datos[5];
	            		String descripcion=datos[6];
	            		Integer importe=Integer.parseInt(datos[7]);
	            		Integer valoracion=Integer.parseInt(datos[8]);
	            		String fechaPedido=datos[9];
	            		Integer diaPedido=Integer.parseInt(fechaPedido.split("/")[0]);
	            		Integer mesPedido=Integer.parseInt(fechaPedido.split("/")[1]);
	            		Integer anioPedido=Integer.parseInt(fechaPedido.split("/")[2]);
	            		//Integer numMoth=servicioTiempo.nameToNumMounth(mes);
	            		String nameMonth=servicioTiempo.numToNameMounth(mesPedido);
	            		String dayOfWeek=servicioTiempo.diaDeLaSemana(diaPedido,mesPedido, anioPedido);
	            		Tiempo tiempo=servicioTiempo.getTiempo(diaPedido,mesPedido, anioPedido);
	            		if(tiempo==null) {
	            			tiempo=new Tiempo(dayOfWeek, diaPedido,nameMonth,mesPedido , anioPedido, servicioTiempo.isWeekend(dayOfWeek));
	            		}
	            		servicioTiempo.guardarTiempo(tiempo);
	            		Lugar lugar =servicioLugar.getLugar(capital);
	            		if(lugar==null) {
	            			lugar =new Lugar(capital,pais,null);
	            		}
	            		else {
	            			lugar.setPais(pais);
	            		}
	            		servicioLugar.guardarLugar(lugar);
	            		Producto producto=servicioProducto.getProducto(item);
	            		if(producto==null) {
	            			producto=new Producto(item, descripcion);
	            		}
	            		servicioProducto.guardarProducto(producto);
	            		String apellidos=servicioCliente.getApellidoSolo(nombreApellido);
	            		String nombre=servicioCliente.getNombreSolo(nombreApellido);
	            		String dominio="";
	            		if(!email.isEmpty())
	            			dominio=servicioCliente.getDominio(email);
	            		Integer dia=servicioCliente.getDiaSolo(fechaAlta);
	            		Integer mes=servicioCliente.getMesSolo(fechaAlta);
	            		Integer anio=servicioCliente.getAnioSolo(fechaAlta);
	            		
	            		Cliente cliente=servicioCliente.getCliente(nombre, apellidos,dia,mes);
	            		if(cliente==null) {
	            			//String dominio=servicioCliente.getDominio(email);
	            			
	            			cliente=new Cliente(nombre, apellidos, email, dominio, dia, mes, anio);
	            		}
	            		else {
	            			cliente.setCorreo(email);
	            		}
	            		servicioCliente.guardarCliente(cliente);
	            		Compra compra= new Compra(importe, valoracion, lugar, producto, tiempo, cliente);
	            		servicioCompra.guardarCompra(compra);
	            			
	            	}
	            	/*
	            	String ip = resultado.split(" - -")[0];
	            	String fecha = resultado.substring(resultado.indexOf("[")+1, resultado.indexOf("]"));
	            	Tiempo tiempo = guardarfecha(fecha);		            	
	            	resultado = resultado.substring(resultado.indexOf("]")+3);
	            	
	            	//Guarda TODOS los accesos del .log
	            	Recursos recurso = new Recursos(resultado.substring(0, resultado.indexOf("\"")));
	            	if (recurso.getUrl().contains("/nitflex/")){
	            		String tipoRecurso=recurso.getUrl();
	            		if(recurso.getUrl().contains("HTTP/"))
	            			tipoRecurso=tipoRecurso.substring(0,tipoRecurso.indexOf("HTTP/"));
	            		tipoRecurso=tipoRecurso.substring(tipoRecurso.lastIndexOf("/"));
	            		if(tipoRecurso.contains(".")){
	            			tipoRecurso=tipoRecurso.substring(tipoRecurso.lastIndexOf("."));
	            			if(tipoRecurso.contains("?"))
	            				tipoRecurso=tipoRecurso.substring(0,tipoRecurso.indexOf("?"));
	            		}else{
	            			tipoRecurso="Otros";
	            		}
	            		recurso.setUrl(tipoRecurso);
	            		
	            		resultado = resultado.substring(resultado.indexOf("\"")+1);
		            	
		            	String numeros = resultado.substring(1,resultado.indexOf("\"")-1);
		            	resultado = resultado.substring(resultado.indexOf("\"")+1);
		            	
		            	String desde = resultado.substring(0,resultado.indexOf("\""));
		            	resultado = resultado.substring(resultado.indexOf("\"")+3);
		            	if(desde.length()>254)
		            		desde="-";

		            	String buscador = resultado.substring(0,resultado.indexOf("\""));
		            	Datos datos = new Datos(ip,numeros,desde,buscador);
		            	
		            	
		            	//Comprueba si existe el dato de tiempo y obtiene su id
		            	long l = servicioTiempo.comprobarTiempo(tiempo);
		            	tiempo.setIdt(l);
		            	
		            	//Comprueba si existe el dato de recursos y obtiene su id
		            	long r = servicioRecurso.comprobarRecurso(recurso);
		            	recurso.setIdr(r);
		            			            	
		            	servicioDatos.guardarDatos(datos); 
		            	
		            	Accesos acceso = new Accesos(recurso, tiempo);
		            	servicioAcceso.guardarAcceso(acceso);
	            	}//if */	               
	            	contAccT++;
	            }//while
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		contAccT = 0;
		try (BufferedReader br = new BufferedReader(new FileReader("Practica_3_SSII_hechos3.csv"))) { //mas-accesos-servidor-nitflex.log
	            String line;	            
	            while ((line = br.readLine()) != null) {  //Vamos linea a linea separando la informacion	
	            	
	            	String resultado = line;
	            	if(contAccT>0) {
	            		String[] datos=resultado.split(";");
	            		String nombreApellido=datos[0];
	            		String dominio=datos[1];
	            		Integer diaAlta=Integer.parseInt(datos[2]);
	            		String mesAlta=datos[3];
	            		Integer anioAlta=Integer.parseInt(datos[4]);
	            		String pais=datos[5].replaceAll("_", " ");
	            		String capital=datos[6];
	            		Integer poblacion=Integer.parseInt(datos[7]);
	            		String item=datos[8];
	            		String descripcion=datos[9];
	            		Integer importe=Integer.parseInt(datos[10]);
	            		Integer valoracion=Integer.parseInt(datos[11]);
	            		String fechaPedido=datos[12];
	            		Integer diaPedido=Integer.parseInt(fechaPedido.split("/")[0]);
	            		Integer mesPedido=Integer.parseInt(fechaPedido.split("/")[1]);
	            		Integer anioPedido=Integer.parseInt(fechaPedido.split("/")[2]);
	            		//Integer numMoth=servicioTiempo.nameToNumMounth(mes);
	            		String nameMonth=servicioTiempo.numToNameMounth(mesPedido);
	            		String dayOfWeek=servicioTiempo.diaDeLaSemana(diaPedido,mesPedido, anioPedido);
	            		Tiempo tiempo=servicioTiempo.getTiempo(diaPedido,mesPedido, anioPedido);
	            		if(tiempo==null) {
	            			tiempo=new Tiempo(dayOfWeek, diaPedido,nameMonth,mesPedido , anioPedido, servicioTiempo.isWeekend(dayOfWeek));
	            		}
	            		servicioTiempo.guardarTiempo(tiempo);
	            		Lugar lugar =servicioLugar.getLugar(capital);
	            		if(lugar==null) {
	            			lugar =new Lugar(capital,pais,poblacion);
	            		}
	            		else {
	            			lugar.setNumhabitantes(poblacion);
	            			lugar.setPais(pais);
	            		}
	            		servicioLugar.guardarLugar(lugar);
	            		Producto producto=servicioProducto.getProducto(item);
	            		if(producto==null) {
	            			producto=new Producto(item, descripcion);
	            		}
	            		servicioProducto.guardarProducto(producto);
	            		String apellidos=servicioCliente.getApellidoSolo(nombreApellido);
	            		String nombre=servicioCliente.getNombreSolo(nombreApellido);
	            		//Integer dia=servicioCliente.getDiaSolo(fechaAlta);
	            		Integer mes=servicioCliente.nameToNumMouth(mesAlta);
	            		//Integer anio=servicioCliente.getAnioSolo(fechaAlta);
	            		
	            		Cliente cliente=servicioCliente.getCliente(nombre, apellidos,diaAlta,mes);
	            		if(cliente==null) {
	            			//String dominio=servicioCliente.getDominio(email);
	            			
	            			cliente=new Cliente(nombre, apellidos, null, dominio, diaAlta,mes, anioAlta);
	            		}
	            		servicioCliente.guardarCliente(cliente);
	            		Compra compra= new Compra(importe, valoracion, lugar, producto, tiempo, cliente);
	            		servicioCompra.guardarCompra(compra);
	            			
	            	}
	            	/*
	            	String ip = resultado.split(" - -")[0];
	            	String fecha = resultado.substring(resultado.indexOf("[")+1, resultado.indexOf("]"));
	            	Tiempo tiempo = guardarfecha(fecha);		            	
	            	resultado = resultado.substring(resultado.indexOf("]")+3);
	            	
	            	//Guarda TODOS los accesos del .log
	            	Recursos recurso = new Recursos(resultado.substring(0, resultado.indexOf("\"")));
	            	if (recurso.getUrl().contains("/nitflex/")){
	            		String tipoRecurso=recurso.getUrl();
	            		if(recurso.getUrl().contains("HTTP/"))
	            			tipoRecurso=tipoRecurso.substring(0,tipoRecurso.indexOf("HTTP/"));
	            		tipoRecurso=tipoRecurso.substring(tipoRecurso.lastIndexOf("/"));
	            		if(tipoRecurso.contains(".")){
	            			tipoRecurso=tipoRecurso.substring(tipoRecurso.lastIndexOf("."));
	            			if(tipoRecurso.contains("?"))
	            				tipoRecurso=tipoRecurso.substring(0,tipoRecurso.indexOf("?"));
	            		}else{
	            			tipoRecurso="Otros";
	            		}
	            		recurso.setUrl(tipoRecurso);
	            		
	            		resultado = resultado.substring(resultado.indexOf("\"")+1);
		            	
		            	String numeros = resultado.substring(1,resultado.indexOf("\"")-1);
		            	resultado = resultado.substring(resultado.indexOf("\"")+1);
		            	
		            	String desde = resultado.substring(0,resultado.indexOf("\""));
		            	resultado = resultado.substring(resultado.indexOf("\"")+3);
		            	if(desde.length()>254)
		            		desde="-";

		            	String buscador = resultado.substring(0,resultado.indexOf("\""));
		            	Datos datos = new Datos(ip,numeros,desde,buscador);
		            	
		            	
		            	//Comprueba si existe el dato de tiempo y obtiene su id
		            	long l = servicioTiempo.comprobarTiempo(tiempo);
		            	tiempo.setIdt(l);
		            	
		            	//Comprueba si existe el dato de recursos y obtiene su id
		            	long r = servicioRecurso.comprobarRecurso(recurso);
		            	recurso.setIdr(r);
		            			            	
		            	servicioDatos.guardarDatos(datos); 
		            	
		            	Accesos acceso = new Accesos(recurso, tiempo);
		            	servicioAcceso.guardarAcceso(acceso);
	            	}//if */	               
	            	contAccT++;
	            }//while
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			//Imprime el informe por consola
		  	/*int a = servicioAcceso.getAccesos().size();
		  	int r = servicioRecurso.getRecursos().size();
	      	List<Tiempo> list = servicioTiempo.getTiempo();
		  	System.out.println("El numero total de accesos procesados es:"+ contAccT);
	      	System.out.println("El numero total de accesos guardados es:"+ a);
	      	System.out.println("El numero total de tipos de recursos es:"+ r);
	      	System.out.println("El rango de tiempo es:");
	      	System.out.println("\t fecha de inicio:"+ list.get(0).getDia()+"/"+list.get(0).getMes()+"/"+ list.get(0).getAnio()+" - "+list.get(0).getHora());
	      	System.out.println("\t fecha de fin:"+ list.get(list.size()-1).getDia()+"/"+list.get(list.size()-1).getMes()+"/"+ list.get(list.size()-1).getAnio()+" - "+list.get(list.size()-1).getHora());
		*/}//process
	
	/*public static Tiempo guardarfecha(String fecha) {
		Tiempo time = new Tiempo();
		time.setDia(Integer.parseInt(fecha.substring(0,2)));
		time.setMes(fecha.substring(3,6));
		time.setAnio(Integer.parseInt(fecha.substring(7,11)));
		time.setHora(Integer.parseInt(fecha.substring(12,14)));
		return time;		
	}*/
}
