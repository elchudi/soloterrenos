package com.soloterrenos.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.maps.client.Maps;
import com.google.gwt.maps.client.control.LargeMapControl;
import com.google.gwt.maps.client.geom.LatLng;
import com.google.gwt.maps.client.overlay.GroundOverlay;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.StackPanel;
import com.google.gwt.user.client.ui.Widget;

public class Mapa implements EntryPoint {

	
	final private static String API_KEY =  "ABQIAAAACsToES8RLtg8ObnZu_1ObxQnd1TU0jAjSNFYCEckUpeMZG470RTjwCbwjOCz1CZf7DSTSKi_AQV_Jw";
	@Override
	public void onModuleLoad() {
		
		Maps.loadMapsApi(Mapa.API_KEY, "2", false, new Runnable() {
			  public void run() {
				  buildUi();
			  }
		  });
		
		
		}
	  
	  
		  
		private Button hideButton;
		private GroundOverlay groundOverlay;
		private void buildUi() {
		    
			AbsolutePanel panel = new AbsolutePanel();
			panel.setSize("100%","550px");
			
			final MapWidget map = new MapWidget();
			map.setSize("100%", "100%");
			
			panel.add(map);
			map.setCenter(LatLng.newInstance(-34.618418,-58.443161), 12);
			
			hideButton = new Button("Hide");
			panel.add(hideButton);
			hideButton.addClickListener(new ClickListener() {
			
			  public void onClick(Widget sender) {
			    if (groundOverlay.isVisible()) {
			      hideButton.setText("Show");
			    } else {
			    	hideButton.setText("Hide");
			    }
			    groundOverlay.setVisible(!groundOverlay.isVisible());
			  }
			});
			RootPanel.get("mapa").add(panel);
			RootPanel.get("mapa").setSize(SoloTerrenos.MAP_PERCE_SIZE, "100%");
		    // Add some controls for the zoom level
		    map.addControl(new LargeMapControl());

	 

	}
		
}
