package net.learn2develop.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class ThirdActivity extends Activity {
	
	String tag = "ThirdActivity";
	
	/* Called when the activity is first created. */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);	
		setContentView(R.layout.thirdactivity);
		Log.d(tag, "In the onCreate() event");
		
		//---get the data passed in using getStringExtra()---
		Toast.makeText(this, getIntent().getStringExtra("str1"), Toast.LENGTH_SHORT).show();
		
		//--get the data passed in using getIntExtra()---
		Toast.makeText(this, Integer.toString(getIntent().getIntExtra("age1", 0)), Toast.LENGTH_SHORT).show();
		
		//---get the Bundle object passed in---
		Bundle bundle = getIntent().getExtras();
		
		//---get the data using the getString()---
		Toast.makeText(this, bundle.getString("str2"), Toast.LENGTH_SHORT).show();
		
		//---get the data using the getInt() method---
		Toast.makeText(this, Integer.toString(bundle.getInt("age2")), Toast.LENGTH_SHORT).show();
	}
	
	public void onClick(View v)
	{
		//---use an Intent object to return data---
		Intent i = new Intent();
		
		//---use the putExtras() method to return some value---
		i.putExtra("age3", 45);
		
		//---use the setData() method to return some value---
		i.setData(Uri.parse("Something passed back to main activity"));
		
		//---set the result with OK and the Intent object---
		setResult(RESULT_OK, i);
		
		//---destroy the current activity---
		finish();
	}
	
	public void onStart()
	{
		super.onStart();
		Log.d(tag, "In the onStart() event");
	}
	
	public void onRestart()
	{
		super.onRestart();
		Log.d(tag, "In the onRestart() event");
	}
	
	public void onResume()
	{
		super.onResume();
		Log.d(tag, "In the onResume() event");
	}
	
	public void onPause()
	{
		super.onPause();
		Log.d(tag, "In the onPause() event");
	}
	
	public void onStop()
	{
		super.onStop();
		Log.d(tag, "In the onStop() event");
	}
	
	public void onDestroy()
	{
		super.onDestroy();
		Log.d(tag, "In the onDestroy() evnet");
	}

}
