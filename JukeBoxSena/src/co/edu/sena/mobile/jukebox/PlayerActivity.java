package co.edu.sena.mobile.jukebox;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import co.edu.sena.mobile.jukebox.services.PlayerService;
/**
 *  Actividad que representa la UI de un reproductor.
 * 
 * 
 * @author Gabriel
 * **/
public class PlayerActivity extends Activity {
	
 private boolean playing = false;
 
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.player);
	        
	        
	        
	        ImageButton btnPlayOrPause = (ImageButton) this.findViewById(R.id.btnPlayOrPause);
	        
			btnPlayOrPause.setOnClickListener(new OnClickListener() {

				public void onClick(View v) {
					String command = null;
					ImageButton ibPlayOrButton = (ImageButton) v;
					
					if(!playing){
						//establecemos a play como el comando a enviar al servicio
					  command = PlayerService.COMMAND_PLAY;					  
					  playing = true;
					  //Cambiamos la imagen del boton
					  ibPlayOrButton.setImageResource(android.R.drawable.ic_media_play);
					}else{		
				    //establecemos a pause como el comando a enviar al servicio
					  command = PlayerService.COMMAND_PAUSE;
					  playing = false;
					  //Cambiamos la imagen del boton 
					  ibPlayOrButton.setImageResource(android.R.drawable.ic_media_pause);
					}
					
					commandToPlayer(command);

				}

			

			
			});	

	        
	    }
        
	   
		private void commandToPlayer(String command) {	
			
			Intent intent = new Intent(this,PlayerService.class);
			Bundle bundle = new Bundle();
			
			bundle.putCharSequence(PlayerService.COMMAND_KEY, command);
			intent.putExtras(bundle);
			
			startService(intent);
		}
	 
	
		
	 
	
}
