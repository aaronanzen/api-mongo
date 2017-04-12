package mx.com.anzen.genericbank.models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@ComponentScan
@PropertySource("classpath:/application.properties")
public class ConexionBean {
	
	
	public ConexionBean(String host, String puerto) {
		super();
		this.host = host;
		this.puerto = puerto; 
	}

	public ConexionBean() {
		
	}
	@Value("${host}")
	private String host;
	
	@Value("${port}")
	private String puerto;
	 
	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPuerto() {
		return puerto;
	}

	public void setPuerto(String puerto) {
		this.puerto = puerto;
	}
 
	

	

}
