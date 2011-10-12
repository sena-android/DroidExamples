package co.edu.sena.mobile.examples;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
	private File musicDirectory;

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
    	 
    	 try {
    		    FileWriter out = new FileWriter(new File(musicDirectory, "test.mp3"));
    		    out.write("Writing test!");
    		    out.close();
    		}
    		catch (IOException e) {
    		    Log.e("Test", "What? " + e);
    		}
    	  
    		
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
		
		
				

		

		musicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);

		Log.d("Test", "  External storage dir (Music) from Context: " + musicDirectory);
		sb.append("  External storage dir (Music) from Context: " + musicDirectory);
		sb.append("\n");
		
		musicDirectory.mkdirs();
		
		
			
		
		
		
		this.showMsg(sb.toString());
		tvOutPut.setText(sb.toString());
    	
    }
    
    private void showMsg(String msg){
    	
    	Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}