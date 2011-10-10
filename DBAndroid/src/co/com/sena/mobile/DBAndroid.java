package co.com.sena.mobile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import co.com.sena.mobile.model.Ambiente;
import co.com.sena.mobile.model.Persona;
import co.com.sena.mobile.model.Rama;
import co.com.sena.mobile.model.SedeSena;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class DBAndroid extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        DBProvider prov=new DBProvider(this);
        
        
        List<Rama> ramas = new ArrayList<Rama>();
        List<Ambiente> ambientes = new ArrayList<Ambiente>();
        Ambiente ambiente = new Ambiente();
        
        Rama rama = new Rama();
        rama.setNombre("Dllo software");  
        
        ambiente.setId("8-4");
        ambiente.setNumeroEquipos(5);
        ambiente.setNumeroMesas(12);
        ambientes.add(ambiente);
        
        rama.setAmbientes(ambientes);
        
        
        
        
        
        SedeSena sen1 = new SedeSena(); 
        SedeSena sen2 = new SedeSena(); 
        
        sen1.setDireccion("Calle 20 No 2"); 
        sen1.setNombre("Sede Central"); 
        
        Persona persona = new Persona(); 
        persona.setApellido("Alviz"); 
        persona.setNombre("Daymer"); 
        persona.setFechaNacimiento(new Date());
        persona.setCedula("714444");
        
        sen1.setDirector(persona);
        
        
        
        sen2.setDireccion("Calle 50 No 2"); 
        sen2.setNombre("Minorista"); 
        
        persona = new Persona(); 
        persona.setApellido("Agudelo"); 
        persona.setNombre("Victo"); 
        persona.setFechaNacimiento(new Date());
        persona.setCedula("8844448");
        
        sen2.setDirector(persona);
        sen2.setRamas(ramas);
        
        prov.insert(sen1);
        prov.insert(sen2);
        
        Persona p = new Persona();
        p.setApellido(null);
        p.setCedula(null);
        p.setFechaNacimiento(null);
        p.setNombre(null);
        
        List<Object> personas = prov.queryByExample(p);
        
        for(Object o: personas){
        	
        	Log.i("Persona", o.toString());
        	
        }
        
        
        
        
        
    }
}