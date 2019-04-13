package repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;



import entities.Lugar;

@RepositoryRestResource(collectionResourceRel = "lugar", path = "lugar")
public interface LugarRepository extends CrudRepository<Lugar,Long> {
	Lugar findByCapital(@Param("capital") String capital);

}
