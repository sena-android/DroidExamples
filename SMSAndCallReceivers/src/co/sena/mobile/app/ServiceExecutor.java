package co.sena.mobile.app;


import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class ServiceExecutor extends Service {

	@Override
	public IBinder onBind(Intent arg0) {
	
		return null;
	}
	
	
	/**
	 * Este es el metodo que es llamado por el sistema
	 * para crear el servicio
	 * */
	@Override
	public void onCreate() {
		
		Toast.makeText(this, "Servicio Creado", Toast.LENGTH_SHORT).show();
		
	}

}
