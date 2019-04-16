package entities;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "compra")
public class Compra {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long compraid;
	private Integer importe;
	private Integer valoracion;
	
	@ManyToOne
    @JoinColumn(name = "lugarid")
	private Lugar lugar;
    @ManyToOne
    @JoinColumn(name = "productoid")
   	private  Producto producto;
    @ManyToOne
    @JoinColumn(name = "tiempoid")
   	private Tiempo tiempo;
    @ManyToOne
    @JoinColumn(name = "clienteid")
   	private Cliente cliente;
	public Compra() {
		super();
	}
	
	public Compra(Integer importe, Integer valoracion, Lugar lugar, Producto producto, Tiempo tiempo, Cliente cliente) {
		super();
		this.importe = importe;
		this.valoracion = valoracion;
		this.lugar = lugar;
		this.producto = producto;
		this.tiempo = tiempo;
		this.cliente = cliente;
	}

	public long getCompraid() {
		return compraid;
	}
	public void setCompraid(long compraid) {
		this.compraid = compraid;
	}
	public Integer getImporte() {
		return importe;
	}
	public void setImporte(Integer importe) {
		this.importe = importe;
	}
	public Integer getValoracion() {
		return valoracion;
	}
	public void setValoracion(Integer valoracion) {
		this.valoracion = valoracion;
	}
	public Lugar getLugar() {
		return lugar;
	}
	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}
	
	public Tiempo getTiempo() {
		return tiempo;
	}
	public void setTiempo(Tiempo tiempo) {
		this.tiempo = tiempo;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
    
}
