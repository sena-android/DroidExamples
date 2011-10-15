package co.edu.sena.mobile.sqliteexample;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

public class SQliteExampleActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        
        DBAdapter adapter = new DBAdapter(this);
        adapter.open();
        
        adapter.insertContact("Juan Gabriel Gutierrez", "correo.del.llanox@gmail.com");
        
        adapter.close();
        
        
        adapter.open();
        Cursor c = adapter.getAllContacts();
        if (c.moveToFirst())
        {
            do {
                DisplayContact(c);
            } while (c.moveToNext());
        }
        adapter.close();
    }
    
    
    
    public void DisplayContact(Cursor c)
    {
        Toast.makeText(this,
        		"id: " + c.getString(0) + "\n" +
        		"Name: " + c.getString(1) + "\n"+
        		"Email: " + c.getString(2),
                Toast.LENGTH_LONG).show();
    }


        
    
}