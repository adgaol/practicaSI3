package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.Cliente;
import entities.Compra;
import repositories.ClienteRepository;
import repositories.CompraRepository;
@Service
public class PurchaseService {
	@Autowired
	private CompraRepository repositorio;
	public void guardarCompra(Compra c){
		repositorio.save(c);
	}
}
