package com.example.activitytest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class ButtonTest extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		
	    super.onCreate(savedInstanceState);
	
	    setContentView(R.layout.buttontest);
	    
	    Button basic_button = (Button)findViewById(R.id.basic_button);
	    
	    basic_button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Toast.makeText(ButtonTest.this, "일반버튼클릭", Toast.LENGTH_SHORT).show();
			}
		});
	    
	    ImageButton image_button = (ImageButton)findViewById(R.id.image_button);
	    
	    image_button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Toast.makeText(ButtonTest.this, "이미지버튼클릭", Toast.LENGTH_SHORT).show();
			}
		});
	    
	    final ToggleButton toggle_button = (ToggleButton)findViewById(R.id.toggle_button);
	    
	    toggle_button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				TextView tv = (TextView)findViewById(R.id.text_feature);
				tv.setText(toggle_button.isChecked()?"ON":"OFF");
			}
		});
	    
	    final Button submit_button = (Button)findViewById(R.id.submit);
	    submit_button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				ToggleButton tb = (ToggleButton)findViewById(R.id.toggle_button);
				
				Toast.makeText(ButtonTest.this, tb.isChecked()?"ON":"OFF", Toast.LENGTH_LONG).show();
				
				ButtonTest.this.finish();
			}
		});
	    
	    final CheckBox check_button = (CheckBox)findViewById(R.id.checkbox);
	    check_button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				TextView tv = (TextView)findViewById(R.id.checkbox);
				tv.setText(check_button.isChecked()?"체크":"안체크");
			}
		});
	    
	    final RadioGroup group = (RadioGroup)findViewById(R.id.radioGroup);
	    group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				
				TextView tv = (TextView)findViewById(R.id.textView);
				
				if(checkedId!=-1){
					
					RadioButton rb = (RadioButton)findViewById(checkedId);
					
					if(rb!=null)
						tv.setText("선택: " + rb.getText());
				}else{
					
					tv.setText("Choose");
				}
			}
		});
	    
	    final Button clear_choice = (Button)findViewById(R.id.button);
	    clear_choice.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				RadioGroup group = (RadioGroup)findViewById(R.id.radioGroup);
				
				if(group!=null)
					group.clearCheck();
			}
		});
	}
}
















