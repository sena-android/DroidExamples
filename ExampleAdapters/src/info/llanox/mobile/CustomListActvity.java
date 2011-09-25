package info.llanox.mobile;
import info.llanox.mobile.model.Data;
import info.llanox.util.OptimizedListAdapter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;

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
		
		setListAdapter(new OptimizedListAdapter(this,R.id.itemLayout,listData));
	Log.i(TAG, "onCreate ........");
	
	}
	

	
	

}
