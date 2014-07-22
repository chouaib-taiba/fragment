package com.example.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.fragment.R;


public class Dynamic1Fragment extends ListFragment {
	 @Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			return inflater.inflate(R.layout.fragment_main, container, false);
		}
	 
	 @Override
		public void onActivityCreated(Bundle savedInstanceState) {
			super.onActivityCreated(savedInstanceState);

			final String[] items = getResources().getStringArray(R.array.exemple_liste);
			final ArrayAdapter<String> aa = new ArrayAdapter<String>(getActivity(),
					android.R.layout.simple_list_item_1, items);
			
			setListAdapter(aa);
		}
	 
	 
	 
	}
	

