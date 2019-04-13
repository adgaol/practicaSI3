package service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.Tiempo;
import repositories.TiempoRepository;

@Service
public class TimeService extends Tiempo {
	@Autowired
	private TiempoRepository repositorio;
	/*
	public List<Tiempo> getTiempo(){
		return (List<Tiempo>) repositorio.findAll();
	}
	*/
	public void guardarTiempo(Tiempo t){
		repositorio.save(t);
	}
	/*public String numToNameMouth(Integer num) {
		switch(num){
		
		}
	}*/
	public Integer nameToNumMouth(String name) {
		switch(name){
		case "Enero":
			return 1;
		case "Febrero":
			return 2;
		case "Marzo":
			return 3;
		case "Abril":
			return 4;
		case "Mayo":
			return 5;
		case "Junio":
			return 6;
		case "Julio":
			return 7;
		case "Agosto":
			return 8;
		case "Septiembre":
			return 9;
		case "Octubre":
			return 10;
		case "Noviembre":
			return 11;
		case "diciembre":
			return 12;
		
		default:
			return -1;
		}
	}
	public String diaDeLaSemana(Integer dia, Integer mes , Integer anio) {
        String inputDateStr = String.format("%s/%s/%s", dia, mes, anio);
        Date inputDate=null;
        
		try {
			inputDate = new SimpleDateFormat("dd/MM/yyyy").parse(inputDateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(inputDate);
        String dayOfWeek = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US).toUpperCase();
        return dayOfWeek;
	}
	public Boolean isWeekend(String dia) {
		Boolean es=false;
		if(dia.equals("Sabado")||dia.equals("Domingo")) {
			es=true;
		}
		return es;
	}
	public Tiempo getTiempo(Integer diaMes,Integer numMes, Integer anio) {
		return repositorio.findByDiamesAndNumeromesAndAnio(diaMes, numMes, anio);
	}
	
	/*public long comprobarTiempo(Tiempo t){
		Tiempo time = repositorio.findByAnioAndDiaAndMesAndHora(t.getAnio(),t.getDia(),t.getMes(),t.getHora());
		if (time!= null){
			long id = time.getIdt();
			return id;
		}
		else{
			return (repositorio.save(t).getIdt());
		}
	}*/

}
