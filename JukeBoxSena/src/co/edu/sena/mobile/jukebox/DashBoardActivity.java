package co.edu.sena.mobile.jukebox;


import co.edu.sena.mobile.jukebox.util.ActivitiesFlowUtil;



import android.app.Activity;
import android.os.Bundle;

/**
 * Es la actividad principal de la aplicación. Nos permite visualizar
 * en el primer pantallazo las funcionalidades de la aplicación.
 * 
 *  @author llanox
 * 
 * */

public class DashBoardActivity extends Activity {
  
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
        
        ActivitiesFlowUtil.addNavigationRule(R.id.action_player, this,PlayerActivity.class);
        ActivitiesFlowUtil.addNavigationRule(R.id.action_statics, this,StaticsActivity.class);

        
        
    }
}