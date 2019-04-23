package repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import entities.Cliente;
import entities.Producto;

@RepositoryRestResource(collectionResourceRel = "cliente", path = "cliente")
public interface ClienteRepository extends CrudRepository<Cliente,Long>{
	Cliente findByNombreAndApellidoAndDiaaltaAndMesalta(@Param("nombre") String nombre,@Param("apellido") String apellido,@Param("diaalta") Integer diaAlta,@Param("mesalta") Integer mesalta);
}
