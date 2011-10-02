package co.edu.sena.mobile;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ActivityExampleUICode extends Activity {
   private LinearLayout lLayout =null;
   private TextView tView= null;
   
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        
        //Crea la interface de forma programatica
        lLayout = new LinearLayout(this);
        lLayout.setOrientation(LinearLayout.VERTICAL);

        lLayout.setLayoutParams(new LayoutParams(
        		LayoutParams.MATCH_PARENT,
        		LayoutParams.MATCH_PARENT));
        tView = new TextView(this);
        tView.setText("Texto ");
        tView.setLayoutParams(new LayoutParams(
        		LayoutParams.MATCH_PARENT,
        		LayoutParams.WRAP_CONTENT));
        lLayout.addView(tView);        
        
        
        setContentView(lLayout);
    }
}