package co.sena.mobile.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;


/**
 * Este es un broadcastreceiver que escucha eventos del sistema 
 * y redirecciona al servicio o actividad indicado para manejarlo.  
 * 
 * Los broadcastreceiver deben estar matriculados en el AndroidManifest.xml
 * del proyecto y debe tener al menos Intent Filter que define sobre cuales
 * eventos va a responderel broadcastreceivers.
 * 
 * @author J.Gabriel G. - llanox
 * 
 * */

public class ReceptorSms extends BroadcastReceiver {

	private static final String SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED";
	private static final String TAG = "SMSBroadcastReceiver";

	@Override
	public void onReceive(Context context, Intent intent) {
		Log.i(TAG, "Entrada: " + intent.getAction());

		if (SMS_RECEIVED.equalsIgnoreCase(intent.getAction())) {
			
			Log.i(TAG, "ACCION: " + intent.getAction());
			Bundle bundle = intent.getExtras();
			
			if (bundle != null) {
				Object[] pdus = (Object[]) bundle.get("pdus");
				final SmsMessage[] messages = new SmsMessage[pdus.length];
				for (int i = 0; i < pdus.length; i++) {
					messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
				}
				if (messages.length > -1) {
					Log.i(TAG,"Recibido: " + messages[0].getMessageBody());
				}
				
				Intent intentParameters = new Intent(context,ServiceExecutor.class);
				Bundle bundleData = new Bundle();
				bundle.putCharSequence("Command", "command");
				bundle.putInt("Integer", 25);
				intentParameters.putExtras(bundle);
				context.startService(intentParameters);
				
				
				
			}
		}
	}

}
