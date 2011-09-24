package co.edu.sena.activitylifecicle;

import android.os.Bundle;
import android.app.Activity;
import android.widget.Toast;

public class ActivityTwo extends Activity{
	 
	public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.main);
	        
	        Toast.makeText(this, "onCreate() Actividad 2....", Toast.LENGTH_SHORT).show();
	    }
	    
	    public void onRestart(){
	    	super.onRestart();
	    	Toast.makeText(this, "onRestart() Actividad 2....", Toast.LENGTH_SHORT).show();
	    	
	    }
	    
	    public void onPause(){
	    	super.onPause();
	    	Toast.makeText(this, "onPause() Actividad 2....", Toast.LENGTH_SHORT).show();
	    	
	    }
	    
	    public void onResume(){
	    	super.onResume();
	    	Toast.makeText(this, "onResume() Actividad 2....", Toast.LENGTH_SHORT).show();
	    	
	    }
	    
	    public void onStart(){
	    	super.onStart();
	    	Toast.makeText(this, "onStart() Actividad 2....", Toast.LENGTH_SHORT).show();
	    	
	    }
	    
}
