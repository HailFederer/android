package com.example.activitytest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewTest1 extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		
	    super.onCreate(savedInstanceState);
	
	    setContentView(R.layout.listviewtest1);
	    
	    String[] items = getResources().getStringArray(R.array.menu);
	    
	    ListView listview = (ListView)findViewById(R.id.list);
	    /*
	    // ���� ��� ǥ��
	    listview.setAdapter(new ArrayAdapter<String>(this, 
	    		android.R.layout.simple_list_item_single_choice, items));
	    listview.setChoiceMode(ListView.CHOICE_MODE_SINGLE);	// ���� ��ư
	    listview.setTextFilterEnabled(true);	// ���� ���� ��, �˻�
	    
	    // �׸� ���� ��, �̺�Ʈ
	    listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adp, View v,
					int position, long id) {
				
				String str = (String)adp.getItemAtPosition(position);
				
				Toast.makeText(ListViewTest1.this, str, Toast.LENGTH_SHORT).show();
			}
		});*/
	    
	    // ���� �׸� (üũ �ڽ�)
	    listview.setAdapter(new ArrayAdapter<String>(this, 
	    		android.R.layout.simple_list_item_multiple_choice, items));
	    
	    listview.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
	}

}
