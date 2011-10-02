package co.sena.edu.mobile;

import java.util.HashMap;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

public class GameActivity extends Activity implements OnClickListener{
    /** Called when the activity is first created. */
	private HashMap<String,ImageButton> buttonsMap = new HashMap<String,ImageButton>();
	int ficha [][]=new int [4][4];
	ImageButton btn;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);       
        setContentView(R.layout.game);    	
        
        LinearLayout tablero= (LinearLayout) this.findViewById(R.id.tablero);
        
        int numeroFilas = tablero.getChildCount();
        
        Log.i("GameActivity", "Filas "+numeroFilas);
        int h = 0;
        for (int i=0; i< numeroFilas; i++){
        	LinearLayout fila =(LinearLayout) tablero.getChildAt(i);
        	int numerFichos = fila.getChildCount();
        	
        	Log.i("GameActivity", "Fichos "+numerFichos);
        	
        	for (int j=0; j<numerFichos; j++){
        		btn = (ImageButton) fila.getChildAt(j);
        		btn.setId(h);
        		btn.setOnClickListener(this);
        		
        		h++;
        		Log.i("GameActivity", "Id "+h);
        	}
        	
        }
     }

	@Override
	public void onClick(View v) {
		Toast.makeText(this, "Id "+ v.getId(), Toast.LENGTH_SHORT).show();
		v.setBackgroundColor(Color.BLUE);	
		
		
		
		Log.i("GameActivity", "llamo evento boton");
		
		
		//imagenesAleatorias();
	}
	
	public void imagenesAleatorias (){
		int x,y=0;int numero=-1;
		double x1,y1=0;
	
		//Pone la matriz de las fichas a -1. El número -1 indica que no tiene ficha
	  	for(int i=0;i<4;i++){
	  		for(int j=0;j<4;j++){
	  			 ficha[i][j]=-1;
	  		}
	  	}
	  	
	  	//Crear Numeros aleatorios. 
	        for (int i=0;i<4;i++){
	          for(int j=0;j<4;j++){
	          	//Genera una posición aleatoria dentro de la matriz dada
	          	do{
	        	  x1=Math.random()*4;
	 	   		  y1=Math.random()*4;
	 	   		  x=(int)x1;
	 	   		  y=(int)y1;
	        	 }
	            while(ficha[x][y]!=-1);
	            numero++;
	 			if (numero==8)numero=0;
	 	    	ficha[x][y]=numero;
	 	    	btn.setImageDrawable(getResources().getDrawable(R.drawable.icon));
	 	    	//boton[i][j].setIcon(vacia);
	          }
	        }	
	    //  Solucion: Poner esto para visualizar la matriz en la consola de java  
	      for (int i=0;i<5;i++) {
	          for(int j=0;j<8;j++)  {
	        	  Log.i( " GameActivity    " + ficha[i][j], "  " );
	 		  }
	          Log.i("GameActivity", "   ");
	 	   }
	 	  
	}
	
}