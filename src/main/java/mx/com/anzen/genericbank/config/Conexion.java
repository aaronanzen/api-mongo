package mx.com.anzen.genericbank.config;

import java.io.IOException;
import java.net.UnknownHostException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;

import mx.com.anzen.genericbank.models.ConexionBean;
import mx.com.anzen.genericbank.models.DataBean;
import mx.com.anzen.genericbank.services.IConexion;
 

/**
 * Clase que realiza la conexión a el manejador de base de datos mongo
 * @author anzen
 *
 */

public class Conexion  implements IConexion{
	
	/**
	 * Declaracion de ApplicationContext
	 */
	
	ApplicationContext appContext; 
	DataBean data=null;  
    
	@Autowired
	private ConexionBean conexion;
     
	
	/**
	 * Metodo que realiza la conexión a la base de datos.
	 * retornando un MongoClient.
	 */
	public MongoClient conexion() {
		System.out.println("antes conexion");
		 System.out.println("Base de datos  "+conexion.getHost());
		 System.out.println("host  "+conexion.getPuerto()); 
		 
		 appContext=new AnnotationConfigApplicationContext(ConfigBean.class); 
		 data=(DataBean) appContext.getBean("iconexionbd");  
		 
		
			try {  
				// Conexion a MongoDB
				data.setMongo(new MongoClient(conexion.getHost(),
						Integer.parseInt(conexion.getPuerto())));
	 
			} catch (UnknownHostException e) { 
				System.out.println("Error: "+e.getMessage());
			} catch (MongoException e) { 
				System.out.println("Error: "+e.getMessage());
			} catch (IOException e) { 
				System.out.println("Error: "+e.getMessage());
			}
			
			return data.getMongo();
	}
	
	/**
	 * Este metodo retorna la conexion de la base de datos 
	 * Retorna un valor de tipo MongoClient
	 */
  
}
