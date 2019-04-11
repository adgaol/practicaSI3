package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "lugar")
public class Lugar {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long lugarid;
	private String capital;
	private String pais;
	private Integer numhabitantes;
	
	
	
	/*@ManyToOne
    @JoinColumn(name = "userid")
	private Usuario profesional;*/
	public Lugar() {
		super();
	}



	public Lugar(String capital, String pais, Integer numhabitantes) {
		super();
		
		this.capital = capital;
		this.pais = pais;
		this.numhabitantes = numhabitantes;
	}



	public long getLugarid() {
		return lugarid;
	}



	public void setLugarid(long lugarid) {
		this.lugarid = lugarid;
	}



	public String getCapital() {
		return capital;
	}



	public void setCapital(String capital) {
		this.capital = capital;
	}



	public String getPais() {
		return pais;
	}



	public void setPais(String pais) {
		this.pais = pais;
	}



	public Integer getNumhabitantes() {
		return numhabitantes;
	}



	public void setNumhabitantes(Integer numhabitantes) {
		this.numhabitantes = numhabitantes;
	}
	
}
