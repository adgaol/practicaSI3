package service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.Cliente;
import entities.Compra;
import repositories.ClienteRepository;
import repositories.CompraRepository;
@Service
public class PurchaseService {
	@Autowired
	private CompraRepository repositorio;
	public void guardarCompra(Compra c){
		repositorio.save(c);
	}
	public File fileToRecomender() {
		ArrayList<Compra> compras=repositorio.findAll();
		File result=new File("./valoraciones.csv");
		BufferedWriter output = null;
	    try {
	       
		    output = new BufferedWriter(new FileWriter(result));
		    for(Compra compra:compras) {
		    	output.write(compra.getCliente().getClienteid()+","+compra.getProducto().getProductoid()+","+compra.getValoracion());
		    	output.newLine();
		}
			
		    
		} catch ( IOException e ) {
		    e.printStackTrace();
		} finally {
		  if ( output != null ) {
		    try {
				output.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
		}
		return result;
				
	}
}
