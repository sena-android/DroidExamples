package co.edu.sena.mobile;

import java.util.Calendar;
import java.util.Date;

import co.edu.sena.mobile.DBProvider;
import co.edu.sena.mobile.modelo.Registro;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
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
    	
    	ActivitiesFlowUtil.addNavigationRule(R.id.btn_cancelar, this, DashBoard.class);
    }	
    
    
    
    public void capturarImagen(View view){
    	
    	if(view.getId()==R.id.btn_portatil){
    		//Toast toast = Toast.makeText(getApplicationContext(), "Tomar foto portatil", Toast.LENGTH_SHORT);
    		//toast.show();
    		Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");    		
    		startActivityForResult(intent, 0);
    		
    	}
    	else{
    		Toast toast = Toast.makeText(getApplicationContext(), "Tomar foto propietario", Toast.LENGTH_SHORT);
    		toast.show();
    	}
    	
    	
    	
    	
    }
    
    @Override public void onActivityResult(int requestCode, int resultCode, Intent data) { 
    	
    	if (resultCode == Activity.RESULT_OK && requestCode == 0) {  
    		
    		String result = data.toURI();    // ...  }}
    		Toast.makeText(getApplicationContext(), "Foto tomada", Toast.LENGTH_SHORT).show();
    		
    		
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
