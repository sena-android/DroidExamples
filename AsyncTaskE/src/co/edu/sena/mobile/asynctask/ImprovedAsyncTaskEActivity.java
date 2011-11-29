package co.edu.sena.mobile.asynctask;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class ImprovedAsyncTaskEActivity extends Activity{
	
	
	private static TextView mResult;

	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
		  // Inicializaci�n de la actividad, layout, etc
		 
			super.onCreate(savedInstanceState);
			setContentView(R.layout.asyntask2);
			
		    mResult = (TextView) this.findViewById(R.id.tv_result);
	
			
	        MyLongTask task = new MyLongTask(this);
	        task.execute("http://grupo-ingenieriaysoftware.udea.edu.co/~rchavarria/trabajo-grado/trabajoGrado.pdf");
	    }
	 
	    @Override
	    protected void onPause() {
	       super.onPause();
	       
	    }
	 
	                                      //En esta ocasión definimos String como el tipo de datos de entrada para el proceso
	                                      //Long el tipo de datos que nos permitirá reportar el progreso a la parte grafica
	                                      //usando el método publishProgress
	                                      //Y el último Long es el resultado del proceso
	    static class MyLongTask extends AsyncTask<String, Long, Long> {
	        WeakReference<ImprovedAsyncTaskEActivity> context;
	 
	        public MyLongTask(ImprovedAsyncTaskEActivity activity) {
	            context = new WeakReference<ImprovedAsyncTaskEActivity>(activity);
	        }
	 
	        @Override
	        protected void onPreExecute() {
	            // Av�sele al usuario que estamos trabajando
	        	Log.d("Task","Aqui podemos avisarle al usuario que un proceso laro esta por iniciarse .....");
	            Toast.makeText(context.get(),"Aqui podemos avisarle al usuario que un proceso largo esta por iniciarse", Toast.LENGTH_LONG).show();
	        
	        }
	 
	        //Aqui se hace el trabajo duro. La tarea que toma tiempo para llevarse acabo.
	        //En este método no es permitido acceder o modicar objetos gráficos.
	        @Override
	        protected Long doInBackground(String... params) {
	            //variable to store total downloaded bytes
                long downloadedSize = 0;
	            	        	
	        	try {
	                //set the download URL, a url that points to a file on the internet
	                //this is the file to be downloaded
	                URL url = new URL(params[0]);

	                //create the new connection
	                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

	                //set up some things on the connection
	                urlConnection.setRequestMethod("GET");
	                urlConnection.setDoOutput(true);

	                //and connect!
	                urlConnection.connect();

	                //set the path where we want to save the file
	                //in this case, going to save it on the root directory of the
	                //sd card.
	                File SDCardRoot = Environment.getExternalStorageDirectory();
	                //create a new file, specifying the path, and the filename
	                //which we want to save the file as.
	                File file = new File(SDCardRoot,"file.pdf");

	                //this will be used to write the downloaded data into the file we created
	                FileOutputStream fileOutput = new FileOutputStream(file);

	                //this will be used in reading the data from the internet
	                InputStream inputStream = urlConnection.getInputStream();

	                //this is the total size of the file
	                int totalSize = urlConnection.getContentLength();
	       

	                //create a buffer...
	                byte[] buffer = new byte[1024];
	                int bufferLength = 0; //used to store a temporary size of the buffer

	                //now, read through the input buffer and write the contents to the file
	                while ( (bufferLength = inputStream.read(buffer)) > 0 ) {
	                        //add the data in the buffer to the file in the file output stream (the file on the sd card
	                        fileOutput.write(buffer, 0, bufferLength);
	                        //add up the size so we know how much is downloaded
	                        downloadedSize += bufferLength;
	                        //this is where you would do something to report the prgress, like this maybe
	                        publishProgress((downloadedSize*100)/totalSize); //Al publishProgress recibe Integer 


	                }
	                //close the output stream when done
	                fileOutput.close();

	        //catch some possible errors...
	        } catch (MalformedURLException e) {
	                e.printStackTrace();
	        } catch (IOException e) {
	                e.printStackTrace();
	        }
	            return downloadedSize;
	        }
	        
	        @Override
	        protected void onProgressUpdate(Long... progress) {
	        	mResult.setText("Descargando....  "+progress[0]+"%");
	        }

	        
	 
	        @Override
	        protected void onPostExecute(Long result) {
	        	ImprovedAsyncTaskEActivity activity = context.get();
	            if (activity != null && !activity.isFinishing()) {
	                // Aqu� actualizamos la UI con el resultado
	            	
	               	Log.d("Task","Hemos terminado.....");
		        	mResult.setText("descargado "+result+" bytes");
	            }
	        }
	    }
}
