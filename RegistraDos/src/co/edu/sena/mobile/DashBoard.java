package co.edu.sena.mobile;

import java.util.List;

import co.edu.sena.mobile.modelo.Registro;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class DashBoard extends Activity {
    /** Called when the activity is first created. */
    @Override
    
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
        
        ActivitiesFlowUtil.addNavigationRule(R.id.btn_propietario, this, Registrar.class);
        
        DBProvider prov=new DBProvider(this);
        
        List<Object> registros = prov.queryByExample(new Registro());
        
        for(Object o: registros){
        	
        	Log.i("TAG", "info db "+o.toString());
        }
        
    }
}