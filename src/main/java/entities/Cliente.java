package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long clienteid;
	private String nombre;
	private String apellido;
	private String correo;
	private String dominiocorreo;
	private Integer diaalta;
	private Integer mesalta;
	private Integer anioalta;
	public Cliente() {
		super();
	}
	public Cliente(String nombre, String apellido, String correo, String dominiocorreo, Integer diaalta,
			Integer mesalta, Integer anioalta) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.dominiocorreo = dominiocorreo;
		this.diaalta = diaalta;
		this.mesalta = mesalta;
		this.anioalta = anioalta;
	}
	public long getClienteid() {
		return clienteid;
	}
	public void setClienteid(long clienteid) {
		this.clienteid = clienteid;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getDominiocorreo() {
		return dominiocorreo;
	}
	public void setDominiocorreo(String dominiocorreo) {
		this.dominiocorreo = dominiocorreo;
	}
	public Integer getDiaalta() {
		return diaalta;
	}
	public void setDiaalta(Integer diaalta) {
		this.diaalta = diaalta;
	}
	public Integer getMesalta() {
		return mesalta;
	}
	public void setMesalta(Integer mesalta) {
		this.mesalta = mesalta;
	}
	public Integer getAnioalta() {
		return anioalta;
	}
	public void setAnioalta(Integer anioalta) {
		this.anioalta = anioalta;
	}
	
}
