package net.learn2develop.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import android.widget.TimePicker;

public class TimePickerActivity extends Activity {
	
	String tag = "TimePickerActivity";
	TimePicker timePicker;
	
	/* Called when the activity is first created. */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);	
		setContentView(R.layout.timepicker);
		Log.d(tag, "In the onCreate() event");
		
		timePicker = (TimePicker) findViewById(R.id.timePicker);
		timePicker.setIs24HourView(true);
	}
	
	public void onClick(View v)
	{
		Toast.makeText(getBaseContext(), 
				"Time selected:" + 
				timePicker.getCurrentHour() +
				":" + timePicker.getCurrentMinute(), 
				Toast.LENGTH_SHORT).show();
	}

}
