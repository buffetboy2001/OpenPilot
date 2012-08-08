package org.openpilot.androidgcs;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.openpilot.androidgcs.OPTelemetryService.LocalBinder;
import org.openpilot.androidgcs.OPTelemetryService.TelemTask;
import org.openpilot.uavtalk.UAVDataObject;
import org.openpilot.uavtalk.UAVObject;
import org.openpilot.uavtalk.UAVObjectManager;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity; 
import com.google.android.maps.MapController; 
import com.google.android.maps.MapView; 
import com.google.android.maps.Overlay;
import com.google.android.maps.Projection;
import com.google.android.maps.MyLocationOverlay;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class UAVLocation extends MapActivity 
{ 
	private final String TAG = "UAVLocation";
	private static int LOGLEVEL = 0;
//	private static boolean WARN = LOGLEVEL > 1;
	private static boolean DEBUG = LOGLEVEL > 0;

	private MapView mapView; 
	private MapController mapController;

	UAVObjectManager objMngr;
    boolean mBound = false;
    boolean mConnected = false;
    LocalBinder binder;

    GeoPoint homeLocation;
    GeoPoint uavLocation;

    @Override public void onCreate(Bundle icicle) {
		super.onCreate(icicle); 
		setContentView(R.layout.map_layout); 
		mapView = (MapView)findViewById(R.id.map_view);
		mapController = mapView.getController();

		mapView.displayZoomControls(true);
		Double lat = 37.422006*1E6; 
		Double lng = -122.084095*1E6; 
		homeLocation = new GeoPoint(lat.intValue(), lng.intValue());
		uavLocation = homeLocation;
		mapController.setCenter(homeLocation); 
		mapController.setZoom(18);
		
		List<Overlay> overlays = mapView.getOverlays();
		UAVOverlay myOverlay = new UAVOverlay(); 
		overlays.add(myOverlay); 
		
		MyLocationOverlay myLocationOverlay = new MyLocationOverlay(this, mapView);
		myLocationOverlay.enableMyLocation();
		myLocationOverlay.enableCompass();
		overlays.add(myLocationOverlay);
	    
		mapView.postInvalidate();

		// ObjectManager related stuff (can't inherit standard class)
		BroadcastReceiver connectedReceiver = new BroadcastReceiver() {
			@Override
			public void onReceive(Context context, Intent intent) {
				Log.d(TAG, "Received intent");
				TelemTask task;
				if(intent.getAction().compareTo(OPTelemetryService.INTENT_ACTION_CONNECTED) == 0) {
					
					if(binder  == null)
						return;
					if((task = binder.getTelemTask(0)) == null)
						return;
					objMngr = task.getObjectManager();
					mConnected = true;
					onOPConnected();
					Log.d(TAG, "Connected()");
				} else if (intent.getAction().compareTo(OPTelemetryService.INTENT_ACTION_DISCONNECTED) == 0) {
					objMngr = null;
					mConnected = false;
					onOPDisconnected();
					Log.d(TAG, "Disonnected()");
				}
			}			
		};
		
		IntentFilter filter = new IntentFilter();
		filter.addCategory(OPTelemetryService.INTENT_CATEGORY_GCS);
		filter.addAction(OPTelemetryService.INTENT_ACTION_CONNECTED);
		filter.addAction(OPTelemetryService.INTENT_ACTION_DISCONNECTED);
		registerReceiver(connectedReceiver, filter);
	}

	//@Override 
	protected boolean isRouteDisplayed() {
		// IMPORTANT: This method must return true if your Activity // is displaying driving directions. Otherwise return false. 
		return false;
	}

	public class UAVOverlay extends Overlay {
		Bitmap homeSymbol = BitmapFactory.decodeResource(getResources(), R.drawable.ic_home);
		Bitmap uavSymbol = BitmapFactory.decodeResource(getResources(), R.drawable.ic_uav);
		@Override 
		public void draw(Canvas canvas, MapView mapView, boolean shadow) {
			
			Projection projection = mapView.getProjection();
			
			if (shadow == false) {

				Point myPoint = new Point(); 
				projection.toPixels(uavLocation, myPoint);
				
				//// Draw UAV
				// Create and setup your paint brush 
				Paint paint = new Paint(); 
				paint.setARGB(250, 255, 0, 0); 
				paint.setAntiAlias(true); 
				paint.setFakeBoldText(true);
								
				// Draw on the canvas 
				canvas.drawBitmap(uavSymbol, myPoint.x - uavSymbol.getWidth() / 2, 
						myPoint.y - uavSymbol.getHeight() / 2, paint);
				canvas.drawText("UAV", myPoint.x+uavSymbol.getWidth() / 2, myPoint.y, paint);								
				
				//// Draw Home
				myPoint = new Point();
				projection.toPixels(homeLocation, myPoint);

				// Create and setup your paint brush 
				paint.setARGB(250, 0, 0, 0); 
				paint.setAntiAlias(true); 
				paint.setFakeBoldText(true);
				
				canvas.drawBitmap(homeSymbol, myPoint.x - homeSymbol.getWidth() / 2, 
						myPoint.y - homeSymbol.getHeight() / 2, paint);
				canvas.drawText("Home", myPoint.x+homeSymbol.getWidth(), myPoint.y, paint);								

			} 
		}

		@Override
		public boolean onTap(GeoPoint point, MapView mapView1) {
			// Return true if screen tap is handled by this overlay
			return false; 
		}
	}
	
	void onOPConnected() {
		UAVObject obj = objMngr.getObject("HomeLocation");
		if(obj != null)
			obj.addUpdatedObserver(new Observer() {
				public void update(Observable observable, Object data) {
					UAVDataObject obj = (UAVDataObject) data;
					Double lat = obj.getField("Latitude").getDouble() / 10;
					Double lon = obj.getField("Longitude").getDouble() / 10;
					homeLocation = new GeoPoint(lat.intValue(), lon.intValue());
					runOnUiThread(new Runnable() {
						public void run() {
							mapController.setCenter(homeLocation);							
						}						
					});
					System.out.println("HomeLocation: " + homeLocation.toString());
				}				
			});
		obj.updateRequested();
		
		obj = objMngr.getObject("PositionActual");
		if(obj != null)
			obj.addUpdatedObserver(new Observer() {
				public void update(Observable observable, Object data) {
					uavLocation = getUavLocation();
					runOnUiThread(new Runnable() {
						public void run() {
							mapView.invalidate();
						}
					});
				}				
			});

	}

	private GeoPoint getUavLocation() {
		UAVObject pos = (UAVObject) objMngr.getObject("PositionActual");
		if (pos == null)
			return new GeoPoint(0,0);
		
		UAVObject home = (UAVObject) objMngr.getObject("HomeLocation");
		if (home == null) 
			return new GeoPoint(0,0);
		
		double lat, lon, alt;
		lat = home.getField("Latitude").getDouble() / 10.0e6;
		lon = home.getField("Longitude").getDouble() / 10.0e6;
		alt = home.getField("Altitude").getDouble();

		// Get the home coordinates
		double T0, T1;
		T0 = alt+6.378137E6;
		T1 = Math.cos(lat * Math.PI / 180.0)*(alt+6.378137E6);
		
		// Get the NED coordinates
		double NED0, NED1;
		NED0 = pos.getField("North").getDouble();
		NED1 = pos.getField("East").getDouble();
		
		// Compute the LLA coordinates
		lat = lat + (NED0 / T0) * 180.0 / Math.PI;
		lon = lon + (NED1 / T1) * 180.0 / Math.PI;

		return new GeoPoint((int) (lat * 1e6), (int) (lon * 1e6));
	}
	
	void onOPDisconnected() {
		
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()) {
		case R.id.menu_connect:
			binder.openConnection();
			return true;
		case R.id.menu_disconnect:
			binder.stopConnection();
			return true;
		case R.id.menu_settings:
			startActivity(new Intent(this, Preferences.class));
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.options_menu, menu);
		return true;
	}

	@Override
	public void onStart() {
		super.onStart();
		Intent intent = new Intent(this, OPTelemetryService.class);
		bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
	}
	
	public void onBind() {
		
	}

	/** Defines callbacks for service binding, passed to bindService() */
	private ServiceConnection mConnection = new ServiceConnection() {
		public void onServiceConnected(ComponentName arg0, IBinder service) {
			// We've bound to LocalService, cast the IBinder and attempt to open a connection			
			if (DEBUG) Log.d(TAG,"Service bound");
			mBound = true;
			binder = (LocalBinder) service;

			if(binder.isConnected()) {
				TelemTask task;
				if((task = binder.getTelemTask(0)) != null) {
					objMngr = task.getObjectManager();
					mConnected = true;
					onOPConnected();
				}
			
			}
		}

		public void onServiceDisconnected(ComponentName name) {
			mBound = false;
			binder = null;
			mConnected = false;
			objMngr = null;
			objMngr = null;
			mConnected = false;
			onOPDisconnected();
		}
	};
}