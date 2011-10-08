package co.edu.sena.mobile.examples;

import java.io.File;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ExternalStorageActivity extends Activity {
	private boolean mExternalStorageAvailable = false;
	private boolean mExternalStorageWriteable = false;
	private TextView tvOutPut;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        tvOutPut = (TextView) this.findViewById(R.id.tvOutPut);
        
    }
    
    
    public void writeToExternalStorage(View v){
    	
    	 checkAvailability();
    	 
    	 if(!mExternalStorageAvailable || !mExternalStorageWriteable )
    		 return;
    	 
    	 
    	  
    		
    	}	
    	
    	
  
    
    private void checkAvailability() {

    	String state = Environment.getExternalStorageState();

    	if (Environment.MEDIA_MOUNTED.equals(state)) {
    		showMsg("Se puede leer y escribir en la memoria externa");
    		
    	    mExternalStorageAvailable = mExternalStorageWriteable = true;
    	    
    	} else if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
    		
    		showMsg("Solo se puede leer la memoria externa");
    		
    	    mExternalStorageAvailable = true;
    	    mExternalStorageWriteable = false;
    	    
    	} else {
    		
    		showMsg("Algo esta mal y no se puede tener acceso a la memoria externa");
    	    mExternalStorageAvailable = mExternalStorageWriteable = false;
    	}
    	
		
	}


	public void readFromExternalStorage(View v){
    	
		 checkAvailability();
		
		if(!mExternalStorageAvailable)
			return;
		
		StringBuffer sb = new StringBuffer();
		
		
		
		

		File extDir1 = Environment.getExternalStorageDirectory();		
		Log.d("Test", "  External storage dir from Environment: " + extDir1);
		
		sb.append("  External storage dir from Environment:  " + extDir1);
		sb.append("\n");
		
		File extDir2 = Environment.getExternalStoragePublicDirectory("AnyStringExceptNull");
		Log.d("Test", "  External storage public dir from Environment: " + extDir2);
		sb.append("  External storage public dir from Environment:  " + extDir2);
		sb.append("\n");
		
		
		File extDir3 = getExternalFilesDir(null);
		Log.d("Test", "External storage dir (root) from Context: " + extDir3);
		sb.append("  External storage dir (root) from Context: " + extDir3);
		sb.append("\n");

		File extDir4 = getExternalFilesDir(Environment.DIRECTORY_MUSIC);
		Log.d("Test", "  External storage dir (Music) from Context: " + extDir4);
		sb.append("  External storage dir (Music) from Context: " + extDir4);
		sb.append("\n");
		
		File extDir5 = getExternalFilesDir("MyOwnType");
		Log.d("Test", "  External storage dir (MyOwnType) from Context: " + extDir5);
		sb.append("  External storage dir (MyOwnType) from Context: " + extDir5);
		sb.append("\n");
		
		this.showMsg(sb.toString());
		tvOutPut.setText(sb.toString());
    	
    }
    
    private void showMsg(String msg){
    	
    	Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}