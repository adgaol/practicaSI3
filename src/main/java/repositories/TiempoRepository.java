package repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import entities.Tiempo;

@RepositoryRestResource(collectionResourceRel = "tiempo", path = "tiempo")
public interface TiempoRepository extends CrudRepository<Tiempo,Long>{
	Tiempo findByDiamesAndNumeromesAndAnio(@Param("diaMes") Integer diaMes,@Param("numMes") Integer numMes,@Param("anio") Integer anio);
}
