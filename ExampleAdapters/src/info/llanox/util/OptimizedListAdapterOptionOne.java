package info.llanox.util;



import info.llanox.mobile.CustomListActvity;
import info.llanox.mobile.R;
import info.llanox.mobile.model.Data;

import java.util.Date;
import java.util.List;
import java.util.Random;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.ImageButton;

/**
 * Esta clase es un adaptador que nos permite pintar
 * cada item de un ListView de la forma que mejor queramos.
 * 
 * Aquï¿½ el mï¿½todo getView es invocado por el proceso de renderizado
 * de las vistas de Android, por cada dato que haya sido pasado
 * por parï¿½metro.
 * 
 * Para entenderlo mejor piensen en lo siguiente, un escritor puede ser muy
 * hï¿½bil describiendo paisajes usando las palabras pero a veces
 * los libros requieren de ilustraciones, para ello la editorial contrata
 * a un pintor para que basado en la narraciï¿½n del escritor trate de 
 * dibujar lo que ï¿½l escribio.
 * 
 * La editorial lo ï¿½nico que hace es pasarle la descripciï¿½n de cada
 * uno de los paisajes a dibujar y pï¿½ginas con un formato definido para que
 * el pintor pinte sobre ellas y les devuelva cada hoja despuï¿½s de pintada.
 * 
 * La editorial es el framework android que llama el mï¿½todo getView de cada componente
 * y el adaptador es el pintor contrato en esta ocaciï¿½n para dibujar las ilustraciones. Y la
 * pï¿½gina con formato es el id al xml que define cada item. *  
 * 
 * @author J.Gabriel G. - llanox
 * **/

public class OptimizedListAdapterOptionOne extends ArrayAdapter<Data>{
	
	
	static class ViewHolder {
		protected TextView text;
		protected ImageButton imageButton;
	
	}
	
	
	
	
	
	
	
    //Lista que contiene objetos de tipo Data
	private List<Data> info;
	//Arreglo de colores disponibles a ser mostrados al azar. 
	private int colors[] ={Color.BLUE,Color.BLACK,Color.CYAN,Color.DKGRAY,Color.GRAY,Color.GREEN,Color.LTGRAY,Color.MAGENTA,Color.RED,Color.WHITE,Color.YELLOW};
	
	public OptimizedListAdapterOptionOne(Context context,int idView, List<Data> info) {
		super(context,  idView, info);
		this.info = info;
		
	}

	



	public View  getView(int position, View convertView, ViewGroup parent) { 
		
		// Usando vistas ya existentes se ahorra memoria y tiempo de procesador.
		//Para esto debe checkear si convertView es no nulo para reutilizar la vista para 
		//settear nuevos datos
		   
		   View v = convertView;
		   
           if (v == null) {
        	   //Aquï¿½ inflamos el layout xml que representa cada item de la lista
        	   // Inflar significa aca que obtenemos un objeto java que representa el
        	   // layout inflado
               LayoutInflater vi = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
               v = vi.inflate(R.layout.item_data, null);
               //Usamos el vieHolder para mantener una instancia del los objetos de la vista del otem
               //y poder reusarlos al pintar una nueva.
               
               // ViewHolder  hace un 175% mas eficiente un ListView en especial para lista de datos grandes.
               final ViewHolder viewHolder = new ViewHolder();
               viewHolder.imageButton = (ImageButton) v.findViewById(R.id.dataButton);
               //Traemos el textView del item_data que hemos inflado
               viewHolder.text = (TextView) v.findViewById(R.id.dataContent);
               
               v.setTag(viewHolder);
           }
           
         
           ViewHolder viewHolder = (ViewHolder) v.getTag();
           TextView tv = viewHolder.text;
           
           //verificamos si es par, entonces le aplicamos un color aleatorio
           if( position%2 == 0)
        	   tv.setTextColor(randomColor());
           
           //Obtonemos un objeto data  que corresponda a la posiciï¿½n indicada el cual contiene la fecha
           //a ser mostrada
           Data data = info.get(position);
           
           // con el  + estamos concatenando la representaciï¿½n en string de Date
           // con un string vacï¿½o. Esto lo hice para obligar al objeto Date 
           // a mostrar su representaciï¿½n en string y colocarla en el textView
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
