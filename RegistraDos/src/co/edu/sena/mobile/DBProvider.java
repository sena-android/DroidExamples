package co.edu.sena.mobile;

import java.util.ArrayList;
import java.util.List;

import com.db4o.ObjectSet;

import android.content.Context;

public class DBProvider extends DB4oConnection {

	public DBProvider(Context context) {
		super(context);
	
	}
	
	
	public void insert(Object o){
		db().store(o);		
	}
	
	public List<Object> queryByExample(Object o){

	  ObjectSet set = db().queryByExample(o);
	  		  
	  return set;
	}
	


}
