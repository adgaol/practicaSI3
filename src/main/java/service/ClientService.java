package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.Cliente;
import entities.Producto;
import repositories.ClienteRepository;
import repositories.ProductoRepository;

@Service
public class ClientService extends Cliente {
	@Autowired
	private ClienteRepository repositorio;
	public void guardarCliente(Cliente c){
		repositorio.save(c);
	}
	public Cliente getCliente(String nombre , String apellido,Integer diaalta,Integer mesalta) {
		return repositorio.findByNombreAndApellidoAndDiaaltaAndMesalta(nombre, apellido,diaalta,mesalta);
		
	}
	public String getNombreSolo(String nombreApellido) {
		if(nombreApellido.contains(",")) {
			return nombreApellido.split(", ")[1];
		}
		else
			return nombreApellido.split(" ")[0];
	}
	public String getApellidoSolo(String nombreApellido) {
		if(nombreApellido.contains(",")) {
			return nombreApellido.split(",")[0];
		}
		else
			return nombreApellido.split(" ")[1];
	}
	
	public String getDominio(String correo){
		return correo.split("@")[1];
	}
	public Integer getDiaSolo(String fecha){
		return Integer.parseInt(fecha.split(" ")[0]);
	}
	public Integer getMesSolo(String fecha){
		return nameToNumMouth(fecha.split(" ")[2]);
	}
	public Integer getAnioSolo(String fecha){
		return Integer.parseInt(fecha.split(" ")[4]);
	}
	public Integer nameToNumMouth(String name) {
		if(name.contains(".")) {
			switch(name){
			case "Ene.":
				return 1;
			case "Feb.":
				return 2;
			case "Mar.":
				return 3;
			case "Abr.":
				return 4;
			case "May.":
				return 5;
			case "Jun.":
				return 6;
			case "Jul.":
				return 7;
			case "Ago.":
				return 8;
			case "Sep.":
				return 9;
			case "Oct.":
				return 10;
			case "Nov.":
				return 11;
			case "Dic.":
				return 12;
			
			default:
				return -1;
			}
		}
		else {
			switch(name){
			case "enero":
				return 1;
			case "febrero":
				return 2;
			case "marzo":
				return 3;
			case "abril":
				return 4;
			case "mayo":
				return 5;
			case "junio":
				return 6;
			case "julio":
				return 7;
			case "agosto":
				return 8;
			case "septiembre":
				return 9;
			case "octubre":
				return 10;
			case "noviembre":
				return 11;
			case "diciembre":
				return 12;
			
			default:
				return -1;
			}
		}
	}
}
