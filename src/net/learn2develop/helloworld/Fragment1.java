package net.learn2develop.helloworld;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment1 extends Fragment {
	
	String tag = "Fragment1";

	@Override
	public View onCreateView(LayoutInflater inflater, 
			ViewGroup container, Bundle savedInstanceState) {
		//---Inflate the layout for this fragment---
		return inflater.inflate(R.layout.fragment1, container, false);
	}

}
