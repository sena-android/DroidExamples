package co.edu.sena.mobile.internalStorage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class InternalStorageActivity extends Activity {
	/** Called when the activity is first created. */

	public static final String PASSWORD_FILE = "passwordFIle";
	private FileOutputStream mfos;
	private FileInputStream mfis;
	private TextView mTvOutput;

	public static final String TAG = "InternalStorageActivity";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

	}

	// Este metodo es llamado desde el xml usando el parametro onClick
	public void savePassword(View view) {

		EditText etPassw = (EditText) view;
		try {
			mfos = openFileOutput(PASSWORD_FILE, Context.MODE_PRIVATE);
			mfos.write(etPassw.getText().toString().getBytes());
			mfos.close();

		} catch (FileNotFoundException e) {
			Log.e(TAG, "Archivo no encontrado", e);

		} catch (IOException e) {
			Log.e(TAG, "I/0 error ", e);
		}
	}

	public void validatePassword(View view) {

		EditText etPassw = (EditText) view;
		

		try {

			mfis = openFileInput(PASSWORD_FILE);

			byte[] reader = new byte[mfis.available()];
			while (mfis.read(reader) != -1) {}

			mTvOutput.setText(new String(reader));

		} catch (IOException e) {
			    Log.e(TAG, "I/0 error ", e);
		} finally {
			if (mfis != null) {
				try {
					mfis.close();
				} catch (IOException e) {
					Log.e(TAG, "I/0 error ", e);
				}
			}
		}

	}

}