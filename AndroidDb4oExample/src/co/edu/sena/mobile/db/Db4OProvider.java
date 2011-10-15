package co.edu.sena.mobile.db;

import java.util.List;

import android.content.Context;

public class Db4OProvider extends Db4oHelper {

	public Db4OProvider(Context ctx) {
		super(ctx);
	
	}
	
	public void store(Object object) {
		db().store(object);
		}
		 
		public void delete(Object object) {
		db().delete(object);
		}
		
		public List findAll(Class clazz) {
		return db().query(clazz);
		}  

}
