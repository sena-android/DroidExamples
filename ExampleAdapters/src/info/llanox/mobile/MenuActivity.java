package info.llanox.mobile;

import info.llanox.util.ActivitiesFlowUtil;
import android.app.Activity;
import android.os.Bundle;

public class MenuActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        ActivitiesFlowUtil.addNavigationRule(R.id.btn_spinner, this, SpinnerActivity.class); 
        ActivitiesFlowUtil.addNavigationRule(R.id.btn_custom_list_view, this, CustomListActvity.class); 
        
    }
}