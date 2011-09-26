package co.sena.mobile.app;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;


/**
 * Este es un broadcastreceiver que escucha eventos del sistema 
 * y redirecciona al servicio o actividad indicado para manejarlo.  
 * 
 * Los broadcastreceiver deben estar matriculados en el AndroidManifest.xml
 * del proyecto y debe tener al menos Intent Filter que define sobre cuales
 * eventos va a responder el broadcastreceivers.
 * 
 * En el AndroidManifest.xml se deben definir los permisos que sea necesarios
 * para que los componentes de aplicación accedan a ciertos recursos
 * del sistema.
 * 
 * @author J.Gabriel G. - llanox
 * 
 * */

public class ReceptorLlamada extends BroadcastReceiver {
  public static final String TAG="ReceptorLlamada";
  public static final String INCOMING_NUMBER="incoming_number";
  
	@Override
	public void onReceive(Context context, Intent intent) {
		Log.i(TAG, "recibi la llamada"+intent.getAction());
		
		
		TelephonyManager telephony = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
		
		Bundle bundle = intent.getExtras();
		String phoneNr= bundle.getString(INCOMING_NUMBER);
		
		Intent i = new Intent(context,NewActivity.class);		
		i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		i.putExtras(bundle);
		context.startActivity(i); 
		
		
		Log.i(TAG, "recibi la llamada de "+phoneNr);
	}

}
