package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.Producto;
import repositories.ProductoRepository;

@Service
public class ItemService extends Producto {
	@Autowired
	private ProductoRepository repositorio;
	public void guardarProducto(Producto p){
		repositorio.save(p);
	}
	public Producto getProducto(String name) {
		return repositorio.findByNombre(name);
	}
}
