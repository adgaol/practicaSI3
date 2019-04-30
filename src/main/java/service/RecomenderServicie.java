package service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.EuclideanDistanceSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.model.JDBCDataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.ItemBasedRecommender;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mysql.cj.jdbc.MysqlDataSource;

import entities.Cliente;
import entities.Compra;
import repositories.ClienteRepository;
import repositories.ProductoRepository;

@Component
public class RecomenderServicie {
	@Autowired
	private PurchaseService servicioCompra;
	@Autowired
	private ClienteRepository repositorio;
	@Autowired
	private ProductoRepository repositorioItem;
	@PostConstruct
	//Abrimos el archivo
	public void process(){
		servicioCompra.fileToRecomender();
	/**/DataModel model=null;
	try {
		model = new FileDataModel(new File("./valoraciones.csv"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		/*MysqlDataSource datasource = new MysqlDataSource();
		datasource.setServerName("localhost");
		datasource.setUser("root");
		datasource.setPassword("");
		datasource.setDatabaseName("mahout");

		JDBCDataModel dataModel = new MySQLJDBCDataModel(datasource, "recom",
				"user_id", "item_id", "preference", null);*/
	UserSimilarity similarity=null;
	try {
		similarity = new PearsonCorrelationSimilarity(model);
	} catch (TasteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.1, similarity, model);
	UserBasedRecommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);
	List<RecommendedItem> recommendations=null;
	File result=new File("./recomendaciones.csv");
	BufferedWriter output = null;
	try {
		       
	    output = new BufferedWriter(new FileWriter(result));
	    for(Cliente cliente:repositorio.findAll()) {
	    	try {
	    		recommendations = recommender.recommend(cliente.getClienteid(), 3);
	    	} catch (TasteException e) {
			// TODO Auto-generated catch block
	    		e.printStackTrace();
	    	}
		
			output.write(cliente.getNombre()+" "+cliente.getApellido());
			
		    for (RecommendedItem recommendation : recommendations) {
		    	System.out.println(recommendation);
		
		   
		    	output.write(","+repositorioItem.findByProductoid(recommendation.getItemID()).getNombre()+","+recommendation.getValue());
		    	
		
			
		    }
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
	}
	
	
}
