/*
 * tata inc. 
 * Copyright (c) 2011-2013 All Rights Reserved.
 */
package net.learn2develop.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.EditText;

/**
 * <p>TODO</p>
 *
 * @author <a href="mailto:yangkaifeng1985@126.com">Kaifeng Yang</a>
 * @version $Id: SecondActivity.java, v0.1 Jun 15, 2013 4:39:13 PM, Kaifeng Yang Exp $
 */
public class SecondActivity extends Activity{
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.secondactivity);
	}
	
	public void onClick(View view) {
		Intent data = new Intent();
		
		//---get the EditText view---
		EditText txt_username = (EditText) findViewById(R.id.txt_username);
		
		//---set the data to pass back---
		data.setData(Uri.parse(txt_username.getText().toString()));
		setResult(RESULT_OK, data);
		
		//---close the activity---
		finish();
	}

}
