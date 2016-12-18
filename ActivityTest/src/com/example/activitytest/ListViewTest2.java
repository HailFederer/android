package com.example.activitytest;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ListViewTest2 extends ListActivity {
	
	private String[] items = {"이보영","박보영","한효주"};
	private TextView tv;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		
	    super.onCreate(savedInstanceState);
	
	    setContentView(R.layout.listviewtest2);
	    
	    ArrayAdapter<String> aa = new ArrayAdapter<String>(this, 
	    		android.R.layout.simple_list_item_1, items);
	    
	    setListAdapter(aa);
	    
	    tv = (TextView)findViewById(R.id.myText);
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id){
		
		tv.setText(items[position]);
	}
}
