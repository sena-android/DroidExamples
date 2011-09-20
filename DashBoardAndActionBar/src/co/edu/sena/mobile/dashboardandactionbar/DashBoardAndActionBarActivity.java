package co.edu.sena.mobile.dashboardandactionbar;




import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class DashBoardAndActionBarActivity extends Activity  implements OnClickListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);          
        setContentView(R.layout.dashboard);
        
        //Traemos el objeto java que corresponde al componente xml definido con se Id        
        Button btnTwo = (Button) this.findViewById(R.id.action_three_button);
        
        //Agregamos el escuchador al boton usando una clase anonima
        btnTwo.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {

				
				//Aqui usamos un Intent Explicito para navegar de la
				//actividad actual a la que se especifica
				
				Intent intent = new Intent();
				intent.setClass(v.getContext(), OtraActividad.class);

				//Envia el mensaje o intent al sistema android para que incie la nueva actividad
				//y la actual la deja en pause
				startActivity(intent);

			}
		});
        
      //Traemos el objeto java que corresponde al componente xml definido con se Id   
        Button btnThree = (Button) this.findViewById(R.id.action_three_button);
        //Agregamos el escuchador al boton, siendo el escuchador la Actividad que implementa
        //la interface OnClickListener
        btnThree.setOnClickListener(this);
        
        
        
        
        
    }
    
    //Este metodo es llamado cuando ocurre un click sobre el boton que define en el
    // xml el parametro  android:onClick="onActionOneClick" . No se necesita definir un escuchador para el
    // boton.
    public void onActionOneClick(View view) {        
        Toast.makeText(this, "One", Toast.LENGTH_SHORT).show();
        
    }
    

    

	public void onClick(View v) {
	
		 Toast.makeText(this, "Two", Toast.LENGTH_SHORT).show();
	}
	
	
    
    //Este metodo es llamado cuando ocurre un click sobre el boton que define en el
    // xml el parametro  android:onClick="onActionOneClick" . No se necesita definir un escuchador para el
    // boton.
    public void onActionFourClick(View view) {        
        Toast.makeText(this, "One", Toast.LENGTH_SHORT).show();
        
    }
    
    
    //Este metodo es llamado cuando ocurre un click sobre el boton que define en el
    // xml el parametro  android:onClick="onActionOneClick" . No se necesita definir un escuchador para el
    // boton.
    public void onActionFiveClick(View view) {        
        Toast.makeText(this, "Five", Toast.LENGTH_SHORT).show();
        
    }
    
    
    //Este metodo es llamado cuando ocurre un click sobre el boton que define en el
    // xml el parametro  android:onClick="onActionOneClick" . No se necesita definir un escuchador para el
    // boton.
    public void onActionSixClick(View view) {        
        Toast.makeText(this, "Six", Toast.LENGTH_SHORT).show();
        
    }
}