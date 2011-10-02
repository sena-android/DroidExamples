package co.edu.sena.mobile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


/**
 *  Ejemplo de como podemos inciar una segunda actividad y
 *  esperar a que esta segunda regrese datos a la
 *  primera actividad. 
 * */
public class ActivityResultOne extends Activity {
	private static final int REQUEST_CODE = 1;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	public void onClick(View view) {
		Intent i = new Intent(this, ActivityResultTwo.class);
		i.putExtra("Dato1", "This value one for ActivityTwo ");
		i.putExtra("Daro2", "This value two ActivityTwo");
		// Set the request code to any code you like, you can identify the
		// callback via this code
		startActivityForResult(i, REQUEST_CODE);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
			if (data.hasExtra("returnKey1")) {
				Toast.makeText(this, data.getExtras().getString("returnKey1"),
						Toast.LENGTH_SHORT).show();
			}
		}
	}
}