package mx.com.anzen.genericbank.services;

import java.util.List;
import java.util.Map;

import mx.com.anzen.genericbank.models.NameBean;

public interface NameService {
	
	// Inserta en catalogo un nuevo estado
	public String alta(String nombreDB, String nombreTabla, Map<String,Object> map);
	
	// Recuperar estado por ID
	public Map<String,Object> consulta(String nombreDB, String nombreTabla,Map<String,Object> map);
}
