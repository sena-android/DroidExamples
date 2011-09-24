package info.llanox.mobile;
import info.llanox.mobile.model.Data;
import info.llanox.util.ListAdapterOptionOne;
import info.llanox.util.OptimizedListAdapterOptionOne;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class CustomListActvity extends ListActivity {
	private List<Data> listData = new ArrayList<Data>();
	
	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		
		   Calendar cal = Calendar.getInstance();
	        Data data = null;
	        
	        for(int i=0; i<=33;i++){        	
	         data = new Data();
	         data.setActualDate(cal.getTime());
	         listData.add(data);
	        }
		
		setListAdapter(new OptimizedListAdapterOptionOne(this,R.id.dataContent,listData));
		
	
	}

}
