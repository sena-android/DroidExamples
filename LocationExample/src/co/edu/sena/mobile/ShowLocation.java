package co.edu.sena.mobile;

import android.app.Activity;
import android.os.Bundle;

import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ShowLocation extends Activity implements LocationListener {
	private TextView latituteField;
	private TextView longitudeField;
	private LocationManager locationManager;
	private String provider;

	
/** Called when the activity is first created. */

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		latituteField = (TextView) findViewById(R.id.textView02);
		longitudeField = (TextView) findViewById(R.id.textView04);

		// Get the location manager
		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		// Define the criteria how to select the locatioin provider -> use
		// default
		Criteria criteria = new Criteria();		
		criteria.setAccuracy(Criteria.ACCURACY_FINE);
		provider = locationManager.getBestProvider(criteria, true);
		
		validateProvider();
		
		Toast.makeText(this, "Provider "+provider, Toast.LENGTH_LONG).show();
		Location location = locationManager.getLastKnownLocation(provider);

		
		// Initialize the location fields
		if (location != null) {
			Log.d("LocationManager","Provider " + provider + " has been selected.");
			int lat = (int) (location.getLatitude());
			int lng = (int) (location.getLongitude());
			latituteField.setText(String.valueOf(lat));
			longitudeField.setText(String.valueOf(lng));
		} else {
			latituteField.setText("Provider not available");
			longitudeField.setText("Provider not available");
		}
	}

	/* Request updates at startup */
	@Override
	protected void onStart() {
		super.onStart();
		
		validateProvider();
		
		locationManager.requestLocationUpdates(provider, 400, 1, this);
		Toast.makeText(this, "Getting provider  "+provider, Toast.LENGTH_LONG).show();
	}

	private void validateProvider() {
		
		Location location = locationManager.getLastKnownLocation(provider);
		if (location == null) {
			
			if(LocationManager.NETWORK_PROVIDER.equalsIgnoreCase(provider)){				
				provider= LocationManager.GPS_PROVIDER;
			}else{
				provider= LocationManager.NETWORK_PROVIDER;
			}
			
		}
		
		Log.d("LocationExample", "Valid location for "+provider);
	}

	/* Remove the locationlistener updates when Activity is paused */
	@Override
	protected void onPause() {
		super.onPause();
		locationManager.removeUpdates(this);
	}

	@Override
	public void onLocationChanged(Location location) {
		int lat = (int) (location.getLatitude());
		int lng = (int) (location.getLongitude());
		latituteField.setText(String.valueOf(lat));
		longitudeField.setText(String.valueOf(lng));
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		Toast.makeText(this, "onStatusChanged " + provider,
				Toast.LENGTH_SHORT).show();

	}

	@Override
	public void onProviderEnabled(String provider) {
		Toast.makeText(this, "Enabled new provider " + provider,
				Toast.LENGTH_SHORT).show();

	}

	@Override
	public void onProviderDisabled(String provider) {
		Toast.makeText(this, "Disenabled provider " + provider,
				Toast.LENGTH_SHORT).show();
	}
}