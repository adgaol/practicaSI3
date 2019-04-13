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
	public Cliente getCliente(String nombre , String apellido) {
		return repositorio.findByNombreAndApellido(nombre, apellido);
		
	}

}
