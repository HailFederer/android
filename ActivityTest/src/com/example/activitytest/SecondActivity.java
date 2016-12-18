package com.example.activitytest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	
	    setContentView(R.layout.secondtest);
	    
	    Button btn = (Button)findViewById(R.id.btnPre);
	    
	    btn.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				
				finish();
			}
	    });
	    
	    Button btn2 = (Button)findViewById(R.id.btnNext);
	    
	    btn2.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				
				Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
				
				startActivity(intent);
			}
	    });
	}

}
