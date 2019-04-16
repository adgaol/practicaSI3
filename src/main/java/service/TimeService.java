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
	public Integer nameToNumnMouth(String name) {
		switch(name){
		case "enero":
			return 1;
		case "febrero":
			return 2;
		case "marzo":
			return 3;
		case "abril":
			return 4;
		case "mayo":
			return 5;
		case "junio":
			return 6;
		case "julio":
			return 7;
		case "agosto":
			return 8;
		case "septiembre":
			return 9;
		case "octubre":
			return 10;
		case "noviembre":
			return 11;
		case "diciembre":
			return 12;
		
		default:
			return -1;
		}
	}
	public String numToNameMounth(Integer num) {
		switch(num){
		case 1:
			return "enero";
		case 2:
			return "febrero";
		case 3:
			return "marzo";
		case 4:
			return "abril";
		case 5:
			return "mayo";
		case 6:
			return "junio";
		case 7:
			return "julio";
		case 8:
			return "agosto";
		case 9:
			return "septiembre";
		case 10:
			return "octubre";
		case 11:
			return "noviembre";
		case 12:
			return "diciembre";
		
		default:
			return "error";
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
		if(dia.equals("SATURDAY")||dia.equals("SUNDAY")) {
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
