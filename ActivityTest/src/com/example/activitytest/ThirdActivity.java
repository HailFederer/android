package com.example.activitytest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ThirdActivity extends Activity{

	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	
	    setContentView(R.layout.thirdtest);
	    
	    Button btn = (Button)findViewById(R.id.btnPre2);
	    
	    btn.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				
				finish();
			}
	    });
	    
	    Button btn2 = (Button)findViewById(R.id.btnEnd);
	    
	    btn2.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				
				moveTaskToBack(true);
				
				finish();
				
				android.os.Process.killProcess(android.os.Process.myPid());
				
				//System.exit(0);
			}
	    });
	}
}
