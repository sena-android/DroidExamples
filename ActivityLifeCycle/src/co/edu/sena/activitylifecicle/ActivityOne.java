package co.edu.sena.activitylifecicle;

import co.edu.sena.activitylifecicle.R;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import android.content.Intent;

public class ActivityOne extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
       Log.d("ActivityOne", "onCreate() Actividad 1....");
    }
    
    public void onRestart(){
    	super.onRestart();
    	Toast.makeText(this, "onRestart() Actividad 1....", Toast.LENGTH_SHORT).show();
    	
    }
    
    public void onPause(){
    	super.onPause();
    	Toast.makeText(this, "onPause() Actividad 1....", Toast.LENGTH_SHORT).show();
    	
    }
    
    public void onResume(){
    	super.onResume();
    	Toast.makeText(this, "onResume() Actividad 1....", Toast.LENGTH_SHORT).show();
    	
    }
    
    public void onStart(){
    	super.onStart();
    	Toast.makeText(this, "onStart() Actividad 1....", Toast.LENGTH_SHORT).show();
    	
    }
    
    
    public void goToActivity2(View view){
    	
    	Toast.makeText(this, "Going to Activity 2....", Toast.LENGTH_SHORT).show();
    	
    	Intent intent = new Intent(this,ActivityTwo.class);
    	this.startActivity(intent);
    	
    }
    
    
}