package mx.com.anzen.genericbank;
 
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
 
import mx.com.anzen.genericbank.models.ConexionBean;
import mx.com.anzen.repository.SPRepository;
 

@Configuration
@EnableAutoConfiguration
public class NameAppConfig {
	
	@Value("${host}")
	private String host;
	
	@Value("${port}")
	private String puerto;
	 
	
	// Realizar la inyección de dependencia para el repositorio de persistencia
	@Bean
    public SPRepository entityManager() {
        return new SPRepository();
    }
	
	@Bean
	public ConexionBean conexion(){ 
		return new ConexionBean(host, puerto);
	}
	
}
