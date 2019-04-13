package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.Lugar;
import entities.Tiempo;
import repositories.LugarRepository;


@Service
public class PlaceService extends Lugar{
	@Autowired
	private LugarRepository repositorio;	
	public void guardarLugar(Lugar l){
		repositorio.save(l);
	}
	public Lugar getLugar(String capital) {
		return repositorio.findByCapital(capital);
		
	}
}
