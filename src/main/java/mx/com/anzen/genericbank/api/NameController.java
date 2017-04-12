package mx.com.anzen.genericbank.api;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import mx.com.anzen.genericbank.models.ConexionBean;
import mx.com.anzen.genericbank.services.NameService; 

@RestController
public class NameController {

	// Inyeccion de dependencias del servicio
	@Autowired
	private NameService nameService;
	
	@Autowired
	private ConexionBean conexion;
	 
	
	@RequestMapping(value="/layout")
    public Map<String,Object> layout() throws UnknownHostException{  
		Map<String,Object> map=new HashMap(); 
//		map.put("nombre","yuni 2");
//		map.put("am","sanchez 2");
//		map.put("ap","ramirez 2");
		/**
		 * Realiza el alta
		 */
//		String result=operaciones.alta("rey","persona",map);
//		System.out.println("resultados  "+result); 
		/**
		 * Realiza la consulta
		 */
		System.out.println("antes  "+conexion.getHost());
		
		Map<String,Object> mapResult=nameService.consulta("BancaGenerica","BancaGenerica",map);
		System.out.println("Result   "+mapResult);
		  
        return mapResult;
    }
}
