package com.example.activitytest;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.ToggleButton;

public class RadioCheck extends Activity 
implements RadioGroup.OnCheckedChangeListener, CompoundButton.OnCheckedChangeListener{

	private ToggleButton toggleBtn;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		
	    super.onCreate(savedInstanceState);
	
	    setContentView(R.layout.radiocheck);
	    
	    toggleBtn = (ToggleButton)findViewById(R.id.myToggle);
	    
	    RadioGroup colGroup = (RadioGroup)findViewById(R.id.colorGroup);
	    colGroup.setOnCheckedChangeListener(this);
	    
	    CheckBox chkBig = (CheckBox)findViewById(R.id.bigFont);
	    chkBig.setOnCheckedChangeListener(this);
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		
		if(group.getId()==R.id.colorGroup){
			
			switch(checkedId){
			
			case R.id.red:
				toggleBtn.setTextColor(Color.RED);
				break;
				
			case R.id.green:
				toggleBtn.setTextColor(Color.GREEN);
				break;
				
			case R.id.blue:
				toggleBtn.setTextColor(Color.BLUE);
				break;
			}
		}
	}

	@Override
	public void onCheckedChanged(CompoundButton btnView, boolean isChecked) {
		
		if( btnView.getId()==R.id.bigFont){
			
			if(isChecked){
				toggleBtn.setTextSize(50);
			}else{
				toggleBtn.setTextSize(20);
			}
		}
		
	}

	

}
