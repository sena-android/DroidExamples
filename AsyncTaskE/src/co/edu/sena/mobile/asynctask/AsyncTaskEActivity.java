package co.edu.sena.mobile.asynctask;


import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class AsyncTaskEActivity extends Activity {
	
	private TextView mResult;
	private TextView mStart;
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
		 
		 
		 
	        // Inicialización de la actividad, layout, etc
		 
			super.onCreate(savedInstanceState);
			setContentView(R.layout.asyntask1);
		    mResult = (TextView) this.findViewById(R.id.tv_result);
		    mStart = (TextView) this.findViewById(R.id.tv_start);
	        MyLongTask task = new MyLongTask();
	        task.execute("http://blog.fr4gus.com/api/test.json");
	    }
	 
	    @Override
	    protected void onPause() {
	        // Persistamos cualquier cosa que ocupemos
	    }
	 
	    class MyLongTask extends AsyncTask<String, Void, Void>{
	 
	        @Override
	        protected void onPreExecute() {
	            // Avísele al usuario que estamos trabajando
	        	
	        	Log.d("Task","Vamos a camellar   .....");
	        	mStart.setText("Vamos a camellar   ");
	        }
	 
	        @Override
	        protected Void doInBackground(String... params) {
	            // Aquí hacemos una tarea laaarga

	        	try {
	        		Log.d("Task","Esperando un rato en mi AsyncTask  .....");
	        	
					Thread.sleep(40000);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
	        	
	            return null;
	        }
	 
	        @Override
	        protected void onPostExecute(Void result) {
	            // Aquí actualizamos la UI con el resultado
	        	Log.d("Task","Hemos terminado.....");
	        	mResult.setText("Ufff Terminamos ....");
	        	
	        }
	    }
}