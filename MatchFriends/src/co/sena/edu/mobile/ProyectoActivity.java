package co.sena.edu.mobile;


import co.sena.edu.mobile.util.ActivitiesFlowUtil;
import android.app.Activity;
import android.os.Bundle;

public class ProyectoActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);       
        setContentView(R.layout.main);
        
        ActivitiesFlowUtil.addNavigationRule(R.id.btnGame, this,GameActivity.class);
    }
}