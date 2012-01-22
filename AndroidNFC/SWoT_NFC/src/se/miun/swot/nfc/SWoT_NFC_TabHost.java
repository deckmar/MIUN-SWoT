package se.miun.swot.nfc;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

public class SWoT_NFC_TabHost extends TabActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.launcher);
		
		Resources res = getResources(); // get drawables
		TabHost tabHost = getTabHost(); // activity's TabHost
		TabHost.TabSpec spec; // TabSpec for each tab
		Intent intent; // intent for each tab
		
		// create intent to launch the simulator class
		intent = new Intent().setClass(this, SWoT_NFC_Simulator.class);
		// init. spec for each tab and then add it to the TabHost
		spec = tabHost.newTabSpec("simulator").setIndicator("Simulator", 
				res.getDrawable(R.drawable.ic_tab_sim)).setContent(intent);
		tabHost.addTab(spec);
		
		// same for the display class
		intent = new Intent().setClass(this, SWoT_NFC_Display.class);
		spec = tabHost.newTabSpec("display").setIndicator("Display", 
				res.getDrawable(R.drawable.ic_tab_display)).setContent(intent);
		tabHost.addTab(spec);
		
		tabHost.setCurrentTab(1);
	}
	
}
