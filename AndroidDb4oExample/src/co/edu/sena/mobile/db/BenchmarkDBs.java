package co.edu.sena.mobile.db;

import java.util.List;

import co.edu.sena.mobiel.db.R;
import co.edu.sena.mobile.db.model.Song;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class BenchmarkDBs extends Activity {
	
	public static final int TOTAL_RECORDS=2000;
	public static final String TAG="BenchmarkDBs" ;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Db4OProvider bm = new Db4OProvider(this);
        Song song =null;
        Long startTime =null;
        Long endTime = null;
       
        startTime = System.currentTimeMillis();
        
        for(int i=0; i<TOTAL_RECORDS;i++){
        	
        	song = new Song();
        	song.setName("Sabor " +i);
            song.setAuthor("Boby ");
            song.setGenre("Indie");
            song.setAlbum("Caido");
            song.setTrack(1);
            song.setYear(1980);
        bm.store(song);
        }
        endTime = System.currentTimeMillis();
        
        Log.i(TAG, TOTAL_RECORDS+" registros insertados en "+ (endTime-startTime)/1000+" milesimas de segundo");
        
        startTime = System.currentTimeMillis();
        List all = bm.findAll(Song.class);
        endTime = System.currentTimeMillis();
        
        for(Object o : all){        	
        	Log.i("DATA", o+"");
        }
        
       	Log.i("DATA", "FIN ");
//       
       	Log.i(TAG, TOTAL_RECORDS+" registros listados en "+ (endTime-startTime)/1000+"  de segundos"); 
        
        
        
    }
}