package info.llanox.mobile;
import info.llanox.mobile.model.Data;
import info.llanox.util.OptimizedListAdapter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;

/**
 * Esta clase hereda de ListActivity lo que la define ya
 * como una actividad que va mostrar una lista, es por ello
 * que no tenemos que asignarle una vista en xml. La sentencia
 * setContentView(R.id.cualquier.xml) no es necesaria. Simplemente
 * debemos definir el adapter que pintará los items de la lista. 
 * 
 * @author J.Gabriel G. - llanox
 * */
public class CustomListActvity extends ListActivity {
	private List<Data> listData = new ArrayList<Data>();
	private static final String TAG="CustomListActvity";
	
	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		
		
		   Calendar cal = Calendar.getInstance();
	        Data data = null;
	        
	        for(int i=0; i<=33;i++){        	
	         data = new Data();
	         data.setActualDate(cal.getTime());
	         listData.add(data);
	        }
		//El constructor recibe como parametros el context, el id del layout del xml donde se va mostrar
	    // cada item de la lista, un id de un textView que esta contenido en la lista(en este caso cero pues no lo vamos a usar) y
	    //los datos a ser usados para pintar la vista.
	       
		setListAdapter(new OptimizedListAdapter(this,R.layout.item_data,0,listData));
	Log.i(TAG, "onCreate ........");
	
	}
	

	
	

}
