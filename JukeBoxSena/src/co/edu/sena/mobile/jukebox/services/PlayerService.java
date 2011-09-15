package co.edu.sena.mobile.jukebox.services;



import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Toast;
import co.edu.sena.mobile.jukebox.R;

/**
 * Esta clase es un servicio o proceso en background que reproduce un 
 * archivo multimedia. Los servicios no estan asociados a una interface
 * gràfica como si lo estan las actividades, pero pueden estar atados a
 * una actividad. Esto quiere decir que la existencia del Servicio puede estar
 * ligada a una Actividad.
 * 
 * @author llanox 
 * **/

public class PlayerService extends Service {

	private MediaPlayer mediaPlayer; 
	public static final String COMMAND_PLAY="play";
	public static final String COMMAND_PAUSE="pause";
	public static final String COMMAND_FORWARD="forward";
	public static final String COMMAND_REWARD="reward";
	public static final String COMMAND_KEY="command";
	
	
	
	
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;			
	}

	/**
	 * Este es el metodo que es llamado por el sistema
	 * para crear el servicio
	 * */
	@Override
	public void onCreate() {
		
		mediaPlayer = MediaPlayer.create(this, R.raw.moonlite);
		mediaPlayer.setLooping(false); // Set looping
		
	}

	@Override
	public void onDestroy (  ) {

		mediaPlayer.stop();
	}
	
	@Override
	public void onStart(Intent intent, int startid) {
		
		Bundle bundle = intent.getExtras();
		String command = bundle.getCharSequence(COMMAND_KEY).toString();
		Toast.makeText(this, "Starting ...."+bundle.getCharSequence(COMMAND_KEY), Toast.LENGTH_SHORT).show();
		
		if(COMMAND_PAUSE.equalsIgnoreCase(command))
		    mediaPlayer.pause();
		
		if(COMMAND_PLAY.equalsIgnoreCase(command))
			mediaPlayer.start();
			
	}
}
