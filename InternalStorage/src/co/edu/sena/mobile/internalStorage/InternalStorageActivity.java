package co.edu.sena.mobile.internalStorage;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class InternalStorageActivity extends Activity {
    /** Called when the activity is first created. */
	
	public static final String PASSWORD_FILE ="passwordFIle";
	private FileOutputStream fos;
	
	public static final String TAG ="InternalStorageActivity";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
   
   
      
		
        
    }
    
    //Este metodo es llamado desde el xml usando el parametro onClick
    public void savePassword(View view){
    	
    	EditText etPassw = (EditText) view;
    	try {
			fos = openFileOutput(PASSWORD_FILE, Context.MODE_PRIVATE);
			fos.write(etPassw.getText().toString().getBytes());
			fos.close();
	        
		} catch (FileNotFoundException e) {
			Log.e(TAG, "Archivo no encontrado",e);
			
		} catch (IOException e) {
			Log.e(TAG, "I/0 error ",e);
		}
    }
    
}