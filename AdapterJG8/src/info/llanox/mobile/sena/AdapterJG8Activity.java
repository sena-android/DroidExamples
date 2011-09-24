package info.llanox.mobile.sena;

import info.llanox.mobile.sena.model.Data;
import info.llanox.mobile.sena.util.ListAdapterOptionOne;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;


/**
 * Pantallazo inicial de la aplicación, el cual me muestra una lista
 * de datos en un ListView.
 *  
 * @author J.Gabriel G. - llanox
 * **/
public class AdapterJG8Activity extends Activity {
    
	private List<Data> listData = new ArrayList<Data>();
	private ListView listViewData;
	private String[] arrayItems = {"1","2","3"};
	private ListAdapterOptionOne adapterOptionOne;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Calendar cal = Calendar.getInstance();
        Data data = null;
        
        for(int i=0; i<=33;i++){        	
         data = new Data();
         data.setActualDate(cal.getTime());
         listData.add(data);
        }
        
        listViewData = (ListView) this.findViewById(R.id.listData);
        adapterOptionOne = new ListAdapterOptionOne(this,R.id.dataContent,listData);
        
        listViewData.setAdapter(adapterOptionOne);
        
        
    }
}