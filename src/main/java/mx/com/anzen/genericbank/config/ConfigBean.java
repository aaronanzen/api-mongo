package mx.com.anzen.genericbank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import mx.com.anzen.genericbank.models.DataBean;
 

/**
 * Clase que contiene los beans para la configuración de Spring.
 * @author anzen
 *
 */
@Configuration
public class ConfigBean {
	
	@Bean(name="iconexionbd")
	public DataBean conexionBean(){
		
		return new DataBean();
	}
	
//	@Bean(name="conexion")
//	public IConexion conexion(){
//		return new Conexion();
//	}

}
