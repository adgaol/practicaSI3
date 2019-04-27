package repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import entities.Compra;

@RepositoryRestResource(collectionResourceRel = "compra", path = "compra")
public interface CompraRepository extends CrudRepository<Compra,Long> {
	ArrayList<Compra> findAll();

}
