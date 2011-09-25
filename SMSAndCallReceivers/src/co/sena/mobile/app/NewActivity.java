package co.sena.mobile.app;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


public class NewActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_activity);
        
        Bundle extras = getIntent().getExtras();
        String incomingNumber = extras.getCharSequence(ReceptorLlamada.INCOMING_NUMBER).toString();
        
        TextView tvTel = (TextView) this.findViewById(R.id.tv_tel);
        
        tvTel.setText(incomingNumber);
        
    }
}