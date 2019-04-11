package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long productoid;
	private String nombre;
	private String descripción;
	public Producto() {
		super();
	}
	public Producto(String nombre, String descripción) {
		super();
		this.nombre = nombre;
		this.descripción = descripción;
	}
	public long getProductoid() {
		return productoid;
	}
	public void setProductoid(long productoid) {
		this.productoid = productoid;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripción() {
		return descripción;
	}
	public void setDescripción(String descripción) {
		this.descripción = descripción;
	}
	
	
}
