package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tiempo")
public class Tiempo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long tiempoid;
	private String diasemana;
	private Integer diames;
	private String nombremes;
	private Integer numeromes;
	private Integer anio;
	private Boolean esfindesemana;
	public Tiempo() {
		super();
	}
	public Tiempo(String diasemana, Integer diames, String nombremes, Integer numeromes, Integer anio,
			Boolean esfindesemana) {
		super();
		this.diasemana = diasemana;
		this.diames = diames;
		this.nombremes = nombremes;
		this.numeromes = numeromes;
		this.anio = anio;
		this.esfindesemana = esfindesemana;
	}
	public long getTiempoid() {
		return tiempoid;
	}
	public void setTiempoid(long tiempoid) {
		this.tiempoid = tiempoid;
	}
	public String getDiasemana() {
		return diasemana;
	}
	public void setDiasemana(String diasemana) {
		this.diasemana = diasemana;
	}
	public Integer getDiames() {
		return diames;
	}
	public void setDiames(Integer diames) {
		this.diames = diames;
	}
	public String getNombremes() {
		return nombremes;
	}
	public void setNombremes(String nombremes) {
		this.nombremes = nombremes;
	}
	public Integer getNumeromes() {
		return numeromes;
	}
	public void setNumeromes(Integer numeromes) {
		this.numeromes = numeromes;
	}
	public Integer getAnio() {
		return anio;
	}
	public void setAnio(Integer anio) {
		this.anio = anio;
	}
	public Boolean getEsfindesemana() {
		return esfindesemana;
	}
	public void setEsfindesemana(Boolean esfindesemana) {
		this.esfindesemana = esfindesemana;
	}
	
}
