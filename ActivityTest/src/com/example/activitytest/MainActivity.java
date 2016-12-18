package com.example.activitytest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_main);
        
        // intent : 액티비티 화면을 호출하는 메세지 객체
        
        Button btn = (Button)findViewById(R.id.btn1);
        
        btn.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				
				Intent intent = new Intent(MainActivity.this, SecondActivity.class);
				
				startActivity(intent);
			}
        });
        
        Button btn2 = (Button)findViewById(R.id.btn2);
        
        btn2.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				
				Intent intent = new Intent(MainActivity.this, ListViewTest1.class);
				
				startActivity(intent);
			}
        });
        
        Button btn3 = (Button)findViewById(R.id.btn3);
        
        btn3.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				
				Intent intent = new Intent(MainActivity.this, ListViewTest2.class);
				
				startActivity(intent);
			}
        });
        
        Button btn4 = (Button)findViewById(R.id.btn4);
        
        btn4.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				
				Intent intent = new Intent(MainActivity.this, RadioCheck.class);
				
				startActivity(intent);
			}
        });
        
        Button btn5 = (Button)findViewById(R.id.btn5);
        
        btn5.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				
				Intent intent = new Intent(MainActivity.this, ButtonTest.class);
				
				startActivity(intent);
			}
        });
        
        Button btn6 = (Button)findViewById(R.id.btn6);
        
        btn6.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				
				Intent intent = new Intent(MainActivity.this, CalcTest.class);
				
				startActivity(intent);
			}
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
