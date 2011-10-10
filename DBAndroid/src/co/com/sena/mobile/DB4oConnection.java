package co.com.sena.mobile;

import android.content.Context;
import android.util.Log;



import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

public class DB4oConnection {

	private static ObjectContainer oc = null;
	
	
	private Context context;
	
	public DB4oConnection(Context context) {
		super();
		this.context = context;
		
		db();
	}
	
	
	public ObjectContainer db() {
		 
		try {
		if (oc == null || oc.ext().isClosed()) {
		oc = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), db4oDBFullPath(context));
		                                   
		}
		 
		return oc;
		 
		} catch (Exception ie) {
		Log.e(DB4oConnection.class.getName(), ie.toString());
		return null;
		}
		}
	
	
	     private String db4oDBFullPath(Context ctx) {
	     	return ctx.getDir("db4o", 0)+ "/" + "sena.db4o";
		}
	
}
