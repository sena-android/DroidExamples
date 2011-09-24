package co.edu.sena.mobile.sharedPreferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;

public class SharedPreferencesActivity extends Activity {
	
	private static final String PREFS_NAME = "configuracion";
	private static final String SELECCIONADO_KEY ="repetirCancion";
	private boolean seleccionado = false;
	
    @Override
    protected void onCreate(Bundle state){
       super.onCreate(state);
       this.setContentView(R.layout.settings);

       // Restore preferences
       SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
       seleccionado = settings.getBoolean(SELECCIONADO_KEY, false);
      
    }

    
    
    @Override
    protected void onStop(){
       super.onStop();

      //El editor es el que nos permite hacer los cambios en el archivo de preferencias
       
      SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
      SharedPreferences.Editor editor = settings.edit();
      editor.putBoolean(SELECCIONADO_KEY, seleccionado);
      

      // Haciendo efectivo los cambios 
      editor.commit();
    }
}