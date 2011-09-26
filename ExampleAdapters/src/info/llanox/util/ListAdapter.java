package info.llanox.util;



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

/**
 * Esta clase es un adaptador que nos permite pintar
 * cada item de un ListView de la forma que mejor queramos.
 * 
 * Aqu� el m�todo getView es invocado por el proceso de renderizado
 * de las vistas de Android, por cada dato que haya sido pasado
 * por par�metro.
 * 
 * Para entenderlo mejor piensen en lo siguiente, un escritor puede ser muy
 * h�bil describiendo paisajes usando las palabras pero a veces
 * los libros requieren de ilustraciones, para ello la editorial contrata
 * a un pintor para que basado en la narraci�n del escritor trate de 
 * dibujar lo que �l escribio.
 * 
 * La editorial lo �nico que hace es pasarle la descripci�n de cada
 * uno de los paisajes a dibujar y p�ginas con un formato definido para que
 * el pintor pinte sobre ellas y les devuelva cada hoja despu�s de pintada.
 * 
 * La editorial es el framework android que llama el m�todo getView de cada componente
 * y el adaptador es el pintor contrato en esta ocaci�n para dibujar las ilustraciones. Y la
 * p�gina con formato es el id al xml que define cada item. *  
 * 
 * @author J.Gabriel G. - llanox
 * **/

public class ListAdapter extends ArrayAdapter<Data>{

	//Arreglo de colores disponibles a ser mostrados al azar. 
	private int mColors[] ={Color.BLUE,Color.BLACK,Color.CYAN,Color.DKGRAY,Color.GRAY,Color.GREEN,Color.LTGRAY,Color.MAGENTA,Color.RED,Color.WHITE,Color.YELLOW};
	private List<Data> mData ;
	private int mItemLayotId;
	
	//Aunque recibe como parametro el id del xml que define el item
	public ListAdapter(Context context,int textViewId, List<Data> data) {
		super(context,  textViewId, data);
		mData = data;

		
	}
	
	public ListAdapter(Context context,int itemLayoutId, int textViewId, List<Data> listData) {
		super(context,itemLayoutId,textViewId,listData);
		mItemLayotId =itemLayoutId;
		mData = listData;
		
	}

	
	public View  getView(int position, View convertView, ViewGroup parent) { 
		
		// Usando vistas ya existentes se ahorra memoria y tiempo de procesador.
		//Para esto debe checkear si convertView es no nulo para reutilizar la vista para 
		//settear nuevos datos
		   
		   View view = convertView;
		   
           if (view == null) {
        	   //Aqu� inflamos el layout xml que representa cada item de la lista
        	   // Inflar significa que obtenemos un objeto java que representa el
        	   // layout inflado
        	   
        	   //Se obtiene el inflador
               LayoutInflater vi = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
               
               view = vi.inflate(mItemLayotId, null);
           }
           
           //Traemos el textView del item_data que hemos inflado
           TextView textView = (TextView) view.findViewById(R.id.dataContent);
           
           //verificamos si es par, entonces le aplicamos un color aleatorio
           if( position%2 == 0)
        	   textView.setTextColor(randomColor());
           
           //Obtonemos un objeto data  que corresponda a la posici�n indicada el cual contiene la fecha
           //a ser mostrada
           Data data = mData.get(position);
           
           // con el  + estamos concatenando la representaci�n en string de Date
           // con un string vac�o. Esto lo hice para obligar al objeto Date 
           // a mostrar su representaci�n en string y colocarla en el textView
           Date date = data.getActualDate();
           
           textView.setText(date +"");
           
     
		
		return view;
	}


	//Permite seleccionar un color identificado con un entero
	//que se encuentra en un arreglo inicialmente definido
	private int randomColor() {
		Random ran = new Random();
		int n  = mColors.length;
		//me devuelve un n�mero al azar entre 0 y n
		int selected = ran.nextInt(n);
		
		return mColors[selected];
	}
}
