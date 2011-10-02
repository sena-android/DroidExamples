package co.edu.sena.mobile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


/**
 *  Ejemplo de como podemos inciar una segunda actividad y
 *  esperar a que esta segunda regrese datos a la
 *  primera actividad. 
 * */


public class ActivityResultTwo extends Activity {
	@Override
	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.two);
		Bundle extras = getIntent().getExtras();
		if (extras == null) {
			return;
		}
		String value1 = extras.getString("Dato1");
		String value2 = extras.getString("Dato2");
		if (value1 != null && value2 != null) {
			EditText text1 = (EditText) findViewById(R.id.editText1);
			EditText text2 = (EditText) findViewById(R.id.editText2);
			text1.setText(value1);
			text2.setText(value2);
		}
	}

	public void onClick(View view) {
		finish();
	}

	@Override
	public void finish() {
		Intent data = new Intent();
		data.putExtra("returnKey1", "Sena Android ");
		data.putExtra("returnKey2", "Desarrollador Java ");
		setResult(RESULT_OK, data);
		super.finish();
	}
}