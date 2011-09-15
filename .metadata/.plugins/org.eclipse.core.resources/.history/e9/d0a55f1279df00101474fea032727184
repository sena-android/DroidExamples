package co.edu.sena.mobile.jukebox;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import co.edu.sena.mobile.jukebox.services.PlayerService;

public class PlayerActivity extends Activity {
	

	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.player);
	        
	        
	        
	        ImageButton btnPlay = (ImageButton) this.findViewById(R.id.btnPlay);
	        
			btnPlay.setOnClickListener(new OnClickListener() {

				public void onClick(View v) {
					
					startPlayer(); 

				}

			
			});	

	        
	    }
	 
		private void startPlayer() {			
			this.startService(new Intent(this,PlayerService.class));
		}
	 
	 
	
}
