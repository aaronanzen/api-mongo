package mx.com.anzen.genericbank.services;

import com.mongodb.MongoClient;

/**
 * Interface que contiene a declaración del metodo que realiza ña conexión hacia el manejador de 
 * base de datos.
 * @author anzen
 *
 */
public interface IConexion {
	
	public MongoClient conexion();

}
