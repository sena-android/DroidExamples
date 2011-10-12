package co.edu.sena.mobile.db;

import java.io.IOException;

import android.content.Context;
import android.util.Log;

import co.edu.sena.mobile.db.model.Chef;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.EmbeddedConfiguration;



public class Db4oHelper {
	
	private static ObjectContainer oc = null;
	private Context context;
	
	/**      
	* @param ctx
	*/

	public Db4oHelper(Context ctx) {
	context = ctx;
	}
	 
	/**
	* Create, open and close the database
	*/
	public ObjectContainer db() {
	 
	try {
	if (oc == null || oc.ext().isClosed()) {
	oc = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), db4oDBFullPath(context));
	                                   
	}
	 
	return oc;
	 
	} catch (Exception ie) {
	Log.e(Db4oHelper.class.getName(), ie.toString());
	return null;
	}
	}
	 
	 
	/**
	* Configure the behavior of the database
	*/
	 
	private EmbeddedConfiguration dbConfig() throws IOException {
		
	EmbeddedConfiguration configuration = Db4oEmbedded.newConfiguration();
	configuration.common().objectClass(Chef.class).objectField("nombre").indexed(true);
	configuration.common().objectClass(Chef.class).cascadeOnUpdate(true);
	configuration.common().objectClass(Chef.class).cascadeOnActivate(true);
	
	
	
	
	return configuration;
	}
	 
	/**
	* Returns the path for the database location
	*/
	
	private String db4oDBFullPath(Context ctx) {
	return ctx.getDir("database", 0)+ "/" + "pumpup.db4o";
	}
	 
	/**
	* Closes the database
	*/
	 
	public void close() {
	if (oc != null)
	oc.close();
	}
	

}
