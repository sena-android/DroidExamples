package co.edu.sena.mobile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.util.Calendar;
import java.util.Date;

import co.edu.sena.mobile.DBProvider;
import co.edu.sena.mobile.modelo.Registro;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.MediaStore.Images;
import android.provider.MediaStore.Images.Media;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Registrar extends Activity {
	private Registro registroActual;
	private Spinner spTipo;
	private Spinner spEntrada;
	private EditText edCodigo;
	private Date fechaIngreso;
	private String strTipoU[] = new String[] {"Permanente", "Casual"};
  	private String strEntrada[] = new String[] {"Entrada 1","Entrada 2","Entrada 3","Entrada 4"};
  	public static final int REQUEST_CODE=211;
  	public static final String TAG ="Registrar";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrar);
        
        spTipo = (Spinner)this.findViewById(R.id.sp_tipo_usu);
        spEntrada = (Spinner)this.findViewById(R.id.sp_entrada);
        
      
    	
    	ArrayAdapter tipoUsuario = new ArrayAdapter(this, android.R.layout.simple_spinner_item, strTipoU);
    	ArrayAdapter entrada = new ArrayAdapter(this, android.R.layout.simple_spinner_item, strEntrada);
    	
    	tipoUsuario.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    	entrada.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    	
    	spTipo.setAdapter(tipoUsuario);
    	spEntrada.setAdapter(entrada);
    	
    	//ActivitiesFlowUtil.addNavigationRule(R.id.btn_cancelar, this, DashBoard.class);
    }	
    
    
    
    public void capturarImagen(View view){
    	
    	if(view.getId()==R.id.btn_portatil){
    		//Toast toast = Toast.makeText(getApplicationContext(), "Tomar foto portatil", Toast.LENGTH_SHORT);
    		//toast.show();
    		
       
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            startActivityForResult(intent,REQUEST_CODE);
    		
    	}
    	else{
    		Toast toast = Toast.makeText(getApplicationContext(), "Tomar foto propietario", Toast.LENGTH_SHORT);
    		toast.show();
    	}
    	
    }
    
   
    
    
   
    
    
    
    @Override public void onActivityResult(int requestCode, int resultCode, Intent data) { 
    	super.onActivityResult(requestCode, resultCode, data);
    	Bitmap bitmap=null;
    	if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE) {  
    		
    		String result = data.toURI();    // ..  }}
    		Log.i("Registrar", "Tomo foto!!!   "+result);
    		Toast.makeText(getApplicationContext(), "Foto tomada", Toast.LENGTH_SHORT).show();
    		Log.i("Registrar", "data "+data.getData());
    		
//    		try {
//    			bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), data.getData());
    			bitmap = (Bitmap) data.getExtras().get("data");  
    			((ImageView)findViewById(R.id.ivPortatil)).setImageBitmap(bitmap);
//			} catch (FileNotFoundException e) {
//				Log.e(TAG, " File not found",e);
//			} catch (IOException e) {
//				Log.e(TAG, "I/O error ",e);
//			} 
//    	    Bitmap temp= (Bitmap)data.getExtras().get("data");
//    		 ((ImageView)findViewById(R.id.ivPortatil)).setImageURI(new URI(data.toURI()));
    		
    	}
    }
    
    public void guardarRegistro(View view) {
    	//TextView tvCodigo = (TextView) this.findViewById(R.id.tv_codigo);
    	DBProvider prov=new DBProvider(this);
    	
    	Calendar cal = Calendar.getInstance();
    	this.fechaIngreso =cal.getTime();
    	edCodigo = (EditText) this.findViewById(R.id.ed_documento);
        String codigo = edCodigo.getText().toString();
    	
        if(codigo.length()>0){
    		registroActual = new Registro();
        	
        	registroActual.setDocumento(edCodigo.getText().toString());
        	registroActual.setEntrada(spEntrada.getSelectedItem().toString());
        	registroActual.setTipoUsuario(spTipo.getSelectedItem().toString());
        	registroActual.setFechaIngreso(fechaIngreso);
        	
        	
        	prov.insert(registroActual);
        	
        	Toast.makeText(getApplicationContext(), ""+registroActual, Toast.LENGTH_SHORT).show();
    	}
    	else{
    		Toast.makeText(getApplicationContext(), "Ingrese un documento", Toast.LENGTH_SHORT).show();
    	}

	}
    
    
    
}
