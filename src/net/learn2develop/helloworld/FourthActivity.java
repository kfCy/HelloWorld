package net.learn2develop.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.Display;
import android.view.WindowManager;

public class FourthActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//---add Fragment dynamic according to the display mode---
		//addFragmentDynamic();
		
		setContentView(R.layout.fourthactivity);
	}
	
	private void addFragmentDynamic() {
		FragmentManager fragmentManager = getFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
		
		//---get the current display info---
		WindowManager wm = getWindowManager();
		Display d = wm.getDefaultDisplay();
		if (d.getWidth() > d.getHeight()) {
			//---landscape mode---
			Fragment1 fragment1 = new Fragment1();
			// android.R.id.content refers to the content
			// view of the activity
			fragmentTransaction.replace(android.R.id.content, fragment1);
		}
		else {
			//---portrait mode---
			Fragment2 fragment2 = new Fragment2();
			fragmentTransaction.replace(android.R.id.content, fragment2);
		}
		fragmentTransaction.commit();
	}

}
