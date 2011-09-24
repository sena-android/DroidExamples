package co.sena.mobile.app;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;


public class ReceptorLlamada extends BroadcastReceiver {
  public static final String TAG="Receptor de llamadas";
	@Override
	public void onReceive(Context context, Intent intent) {
		Log.i(TAG, "recibi la llamada"+intent.getAction());
		
		
		TelephonyManager telephony = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
		
		Bundle bundle = intent.getExtras();
		String phoneNr= bundle.getString("incoming_number");
		
		Intent i = new Intent(context,EmailSender.class);		
		i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(i); 
		
		
		Log.i(TAG, "recibi la llamada de "+phoneNr);
	}

}
