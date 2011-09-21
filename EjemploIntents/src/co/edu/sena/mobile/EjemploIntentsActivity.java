package co.edu.sena.mobile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class EjemploIntentsActivity extends Activity implements OnClickListener {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// Agregando la clase EjemploIntentsActivity como escuchador
		Button buttonOne = (Button) this.findViewById(R.id.btnOne);
		buttonOne.setOnClickListener(this);

		//Agregando un escuchador que  es una implimentaci`on de una clase anonima
		Button buttonTwo = (Button) this.findViewById(R.id.btnTwo);
		buttonTwo.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				
				    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
					startActivityForResult(intent, 0);
			}
		});

	}

	@Override
	public void onClick(View view) {

	}
	
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
	  if (resultCode == Activity.RESULT_OK && requestCode == 0) {
	    String result = data.toURI();
	    Toast.makeText(this, result, Toast.LENGTH_LONG);
	  }
	}
}