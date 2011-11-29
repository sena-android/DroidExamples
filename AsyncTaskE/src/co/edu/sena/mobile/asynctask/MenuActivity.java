package co.edu.sena.mobile.asynctask;

import co.edu.sena.mobile.asynctask.ImprovedAsyncTaskEActivity.MyLongTask;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends Activity {

	
	
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
		  // Inicialización de la actividad, layout, etc
		 
			super.onCreate(savedInstanceState);
			setContentView(R.layout.menu);
	    }
	 
	 public void task1(View view){
		 
		 goTo(this,AsyncTaskEActivity.class);
		 
	 }
	 
	 private void goTo(Context ctx, Class clazz) {
		Intent intent = new Intent(this,clazz);
		this.startActivity(intent);
		
	}

	public void task2(View view){		 
		 goTo(this,ImprovedAsyncTaskEActivity.class);
	 }
}
