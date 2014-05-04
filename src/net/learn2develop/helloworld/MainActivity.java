package net.learn2develop.helloworld;

import android.os.Bundle;
import android.preference.PreferenceManager.OnActivityResultListener;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.view.Window;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;

public class MainActivity extends Activity {
	CharSequence[] items = {"Google", "Apple", "Microsoft"};
	boolean[] itemsChecked = new boolean [items.length];
	
	ProgressDialog progressDialog;
	
	int request_code = 1;
	
	String tag = "Lifecycle";

	/* Called when the activity is first created. */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);	
		setContentView(R.layout.activity_main);
		Log.d(tag, "In the onCreate() event");
	}
	
	public void onClick(View v)
	{
		showDialog(0);
	}
	
	public void onClick2(View v)
	{
		//---show progress---
		final ProgressDialog dialog = ProgressDialog.show(
				this, "Doing something", "Please wait...", true);
		new Thread(new Runnable(){
			public void run(){
				try {
					//---simulate doing something lengthy---
					Thread.sleep(5000);
					//---dismiss the dialog---
					dialog.dismiss();
				}catch (InterruptedException e){
					e.printStackTrace();
				}
			}
		}).start();
	}
	
	public void onClick3(View v) {
		showDialog(1);
		progressDialog.setProgress(0);
		
		new Thread(new Runnable() {
			public void run() {
				for (int i = 1; i <= 15; i++) {
					try {
						//---simulate doing something lengthy---
						Thread.sleep(1000);
						//---update the dialog---
						progressDialog.incrementProgressBy((int)(100/15));
					}catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				progressDialog.dismiss();
			}
		}).start();
	}
	
	public void onClick4(View v) {
		//startActivity(new Intent("net.learn2develop.helloworld.SecondActivity"));
		startActivityForResult(new Intent("net.learn2develop.helloworld.SecondActivity"), request_code);
	}
	
	
	
	public void onClickPassingData(View v) {
		Intent i = new Intent("net.learn2develp.helloworld.ThirdActivity");
		
		//---use putExtra() to add new name/value pairs---
		i.putExtra("str1", "This is a string");
		i.putExtra("age1", 28);
		
		//---use a Bundle objec to add new name/values pairs---
		Bundle extras = new Bundle();
		extras.putString("str2", "This is another string");
		extras.putInt("age2", 25);
		
		//---attach the Bundle object to the Intent object---
		i.putExtras(extras);
		
		//---start the activity to get a result back---
		startActivityForResult(i, 3);
		//startActivity(i);
	}
	
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		Log.d(tag, "in onActivityResult() event");
		if (requestCode == request_code) {
			Log.d(tag, "in onActivityResult() requestCode = 1");
			if (resultCode == RESULT_OK) {
				Log.d(tag, "in onActivityResult() resultCode = RESULT_OK");
				Toast.makeText(this, data.getData().toString(), Toast.LENGTH_SHORT).show();
			}
		}
		else if (requestCode == 3) {
			//---if te result is oK---
			if (resultCode == RESULT_OK) {
				//---get the result using getIntExtra()---
				Toast.makeText(this, Integer.toString(data.getIntExtra("age3", 0)), Toast.LENGTH_SHORT).show();
				
				//---get the result using getData()---
				Toast.makeText(this, data.getData().toString(), Toast.LENGTH_SHORT).show();
			}
		}
	}
	
	public void onClickFragment(View v) {
		startActivityForResult(new Intent("net.learn2develp.helloworld.FourthActivity"), 4);
	}
	
	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id)	{
		case 0:
			return new AlertDialog.Builder(this)
			.setIcon(R.drawable.ic_launcher)
			.setTitle("This is a dialog with some simple text...")
			.setPositiveButton("OK", 
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int whichButton)
						{
							Toast.makeText(getBaseContext(), "OK clicked!", Toast.LENGTH_SHORT).show();
						}
					}
			)
			.setNegativeButton("Cancel",
					new DialogInterface.OnClickListener() {
						
						public void onClick(DialogInterface dialog, int whichButton) {
							// TODO Auto-generated method stub
							Toast.makeText(getBaseContext(), "Cancel clicked!", Toast.LENGTH_SHORT).show();
						}
					}
			)
			.setMultiChoiceItems(items, itemsChecked,
					new DialogInterface.OnMultiChoiceClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which, boolean isChecked) {
							// TODO Auto-generated method stub
							Toast.makeText(getBaseContext(), 
									items[which] + (isChecked ? " checked!" : "unchecked!"), 
									Toast.LENGTH_SHORT).show();
						}
					}
			).create();
			
		case 1: {
			progressDialog = new ProgressDialog(this);
			progressDialog.setProgress(0);
			progressDialog.setIcon(R.drawable.ic_launcher);
			progressDialog.setTitle("Downloading files...");
			progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			progressDialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK",
					new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							Toast.makeText(getBaseContext(), "OK clicked!", Toast.LENGTH_SHORT).show();
						}
					});
			progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", 
					new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							Toast.makeText(getBaseContext(), "Cancel clicked!", Toast.LENGTH_SHORT).show();
						}
					});
			return progressDialog;
		}
		}
		
		return null;
	}
	
	public void onClickTimePicker(View v) {
		startActivity(new Intent("net.learn2develop.helloworld.TimePickerActivity"));
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

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem menu) {
		switch(menu.getItemId()) {
		case R.id.action_settings:
			Toast q = new Toast(this);
			q.makeText(this, R.string.hello_world, Toast.LENGTH_LONG);
			q.show();
			Log.e("TAG","nihao");
			break;
		}
		return true;
	}

}
