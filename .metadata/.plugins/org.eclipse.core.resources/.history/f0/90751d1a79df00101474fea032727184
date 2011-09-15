package co.edu.sena.mobile.jukebox.services;



import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
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
		
		mediaPlayer = MediaPlayer.create(this, R.raw.roxanne);
		mediaPlayer.setLooping(false); // Set looping
		
	}

	@Override
	public void onDestroy (  ) {


		mediaPlayer.stop();
	}
	
	@Override
	public void onStart(Intent intent, int startid) {
		
		Toast.makeText(this, "Starting ....", Toast.LENGTH_SHORT).show();
		
		mediaPlayer.start();
	}
}
