package mx.com.anzen.genericbank.models;
 
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

import mx.com.anzen.genericbank.config.Conexion;
import mx.com.anzen.genericbank.services.IConexion;
 

public class DataBean {
	
	private IConexion conexion=new Conexion();
	private MongoClient mongo; 
	private DB basedatos;
	private DBCollection table;
	private BasicDBObject searchQuery;
	private DBCursor cursor;
	private BasicDBObject obj; 
	private BasicDBObject objectAlta=new BasicDBObject();
		
	
	
 
	public BasicDBObject getObjectAlta() {
		return objectAlta;
	}

	public void setObjectAlta(BasicDBObject objectAlta) {
		this.objectAlta = objectAlta;
	}

	public IConexion getConexion() {
		return conexion;
	}

	public void setConexion(IConexion conexion) {
		this.conexion = conexion;
	}

	public MongoClient getMongo() {
		return mongo;
	}

	public void setMongo(MongoClient mongo) {
		this.mongo = mongo;
	} 
	public DB getBasedatos() {
		return basedatos;
	}

	public void setBasedatos(DB basedatos) {
		this.basedatos = basedatos;
	}

	public DBCollection getTable() {
		return table;
	}

	public void setTable(DBCollection table) {
		this.table = table;
	}

	public BasicDBObject getSearchQuery() {
		return searchQuery;
	}

	public void setSearchQuery(BasicDBObject searchQuery) {
		this.searchQuery = searchQuery;
	}

	public DBCursor getCursor() {
		return cursor;
	}

	public void setCursor(DBCursor cursor) {
		this.cursor = cursor;
	}

	public BasicDBObject getObj() {
		return obj;
	}

	public void setObj(BasicDBObject obj) {
		this.obj = obj;
	}


}
