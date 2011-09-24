package info.llanox.mobile.sena.util;

import info.llanox.mobile.sena.R;
import info.llanox.mobile.sena.model.Data;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Esta clase es un adaptador que nos permite pintar
 * cada item de un ListView de la forma que mejor queramos.
 * 
 * Aquí el método getView es invocado por el proceso de renderizado
 * de las vistas de Android, por cada dato que haya sido pasado
 * por parámetro.
 * 
 * Para entenderlo mejor piensen en lo siguiente, un escritor puede ser muy
 * hábil describiendo paisajes usando las palabras pero a veces
 * los libros requieren de ilustraciones, para ello la editorial contrata
 * a un pintor para que basado en la narración del escritor trate de 
 * dibujar lo que él escribio.
 * 
 * La editorial lo único que hace es pasarle la descripción de cada
 * uno de los paisajes a dibujar y páginas con un formato definido para que
 * el pintor pinte sobre ellas y les devuelva cada hoja después de pintada.
 * 
 * La editorial es el framework android que llama el método getView del adaptador del componente
 * que se esta pintando, el adaptador es el pintor contratado en esta ocación para dibujar 
 * las ilustraciones. Y la  página con formato es el xml que define cada item de la lista.   
 * 
 * @author J.Gabriel G. - llanox
 * **/

public class ListAdapterOptionTwo extends ArrayAdapter<Data>{
    //Lista que contiene objetos de tipo Data
	private List<Data> info;
	//Arreglo de colores disponibles a ser mostrados al azar. 
	private int colors[] ={Color.BLUE,Color.BLACK,Color.CYAN,Color.DKGRAY,Color.GRAY,Color.GREEN,Color.LTGRAY,Color.MAGENTA,Color.RED,Color.WHITE,Color.YELLOW};
	
	public ListAdapterOptionTwo(Context context,int idView, List<Data> info) {
		super(context,  idView, info);
		this.info = info;
		
	}

	
	public View  getView(int position, View convertView, ViewGroup parent) { 
		 
		   
		   View v = convertView;
           if (v == null) {
        	   //Aquí inflamos el layout xml que representa cada item de la lista
        	   // Inflar significa aca que obtenemos un objeto java que representa el
        	   // layout inflado
               LayoutInflater vi = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
               v = vi.inflate(R.layout.item_data, null);
           }
           
           //Traemos el textView del item_data que hemos inflado
           TextView tv = (TextView) v.findViewById(R.id.dataContent);
           
           //verificamos si es par, entonces le aplicamos un color aleatorio
           if( position%2 == 0)
        	   tv.setTextColor(randomColor());
           
           //Obtonemos un objeto data  que corresponda a la posición indicada el cual contiene la fecha
           //a ser mostrada
           Data data = info.get(position);
           
           // con el  + estamos concatenando la representación en string de Date
           // con un string vacío. Esto lo hice para obligar al objeto Date 
           // a mostrar su representación en string y colocarla en el textView
           Date date = data.getActualDate();
           
           tv.setText(date +"");
           
     
		
		return v;
	}


	//Permite seleccionar un color identificado con un entero
	//que se encuentra en un arreglo inicialmente definido
	private int randomColor() {
		Random ran = new Random();
		int n  = colors.length;
		//me devuelve un número al azar entre 0 y n
		int selected = ran.nextInt(n);
		
		return colors[selected];
	}
}
