package mx.com.anzen.genericbank.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;
 
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import mx.com.anzen.bean.ParametrosSP;
import mx.com.anzen.genericbank.config.ConfigBean;
import mx.com.anzen.genericbank.models.DataBean;
import mx.com.anzen.genericbank.models.NameBean;
import mx.com.anzen.repository.SPRepository;

@Service
public class NameServiceImpl implements NameService{
 
	
	/**
	 * Metodo que realiza el alta de datos hacia la base de datos configurada.
	 * @param nombreDB
	 * @param nombreTabla
	 * @param map
	 * @return
	 */
	public String alta(String nombreDB, String nombreTabla, Map<String,Object> map){
		  
		ApplicationContext appContext;
		appContext=new AnnotationConfigApplicationContext(ConfigBean.class);
		DataBean conexion=(DataBean) appContext.getBean("iconexionbd");
		
        DB db= conexion.getConexion().conexion().getDB(nombreDB);
        DBCollection table= db.getCollection(nombreTabla); 
  
        Iterator it = map.keySet().iterator();
		while(it.hasNext()){
		  Object key = it.next();
		  conexion.getObjectAlta().put(key.toString(), map.get(key));
		} 
		
		try{
			table.insert(conexion.getObjectAlta());
			((ConfigurableApplicationContext) appContext).close();
		}catch (Exception e) {
			return "Error: "+e.getMessage();
		}
		
		 return "OK";
	}
	
	/**
	 * Metodo que realiza la Consulta de datos de la base de datos configurada.
	 * @param nombreDB
	 * @param nombreTabla
	 * @param map
	 * @return
	 */
	public Map<String,Object> consulta(String nombreDB, String nombreTabla,Map<String,Object> map){
		System.out.println("inicia consulta");
		
		ApplicationContext appContext =new AnnotationConfigApplicationContext(ConfigBean.class);
		System.out.println("entre");
		DataBean conexion=(DataBean) appContext.getBean("iconexionbd");
		  
//		System.out.println("nombre base datos "+nombreDB+"  inicia 1 "+conexion.getConexion().conexion());
		DB db= conexion.getConexion().conexion().getDB(nombreDB);  
        DBCollection table= db.getCollection(nombreTabla); 
        System.out.println("inicia 2");
        Map<String,Object> mapa= new HashMap<String, Object>();
        Map<String,Object> result= new HashMap<String, Object>();
        Iterator it = map.keySet().iterator();
		while(it.hasNext()){
		  Object key = it.next(); 
		  conexion.getObjectAlta().put(key.toString(), map.get(key));
		}
        DBCursor cursor;
        try{
        	cursor=table.find(conexion.getObjectAlta());  
            while(cursor.hasNext()) {
            	DBObject key = cursor.next();
            	String id= key.get("_id").toString();
            	Set<String> keyset=key.keySet();
            	for (String s: keyset){
            		if (!s.equals("_id")){
            			mapa.put(s, key.get(s)); 
            		}
            		System.out.println(mapa);
            		result.put(id, mapa);
            	}
            }
            ((ConfigurableApplicationContext) appContext).close(); 
        	
        }catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
        
		 return result;
	}
	
}
