package repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import entities.Producto;

@RepositoryRestResource(collectionResourceRel = "producto", path = "producto")
public interface ProductoRepository extends CrudRepository<Producto,Long>{
	Producto findByNombre(@Param("nombre") String nombre);

}
