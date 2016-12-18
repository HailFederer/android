package com.example.activitytest;

import android.R.string;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalcTest extends Activity {
	
	private TextView txtResult;				// 피연산자와 결과값이 출력되는 텍스트뷰
	
	private Calc c = new Calc();			// 실제 연산을 위한 메서드와 변수를 설정해 준 클래스
	
	private String preOperator = "";		// 연산자를 입력했을 때 이 프로퍼티에 해당 연산자를 할당해두고,
											// 다음 차례로 피연산자를 입력할 때 이 프로퍼티가 ""값인지를 검사하여
											// 새로운 피연산자를 입력 가능케 해주는 변수
	@Override
	public void onCreate(Bundle savedInstanceState) {
		
	    super.onCreate(savedInstanceState);
	    
	    setContentView(R.layout.calctest);
	    
	    txtResult = (TextView)findViewById(R.id.txtResult);
	}
	
	public void btnListener(View v){
		
		Button btn = (Button)v;
		
		String btnTitle = btn.getText().toString();
		String txtText = txtResult.getText().toString();
		
		if(!isString(btnTitle)){	// 숫자입력 시(처음 & 연산자 입력 후)
			
			if(!preOperator.equals("")){	// 1. 두번째 피연산자 입력 시, 피연산자의 첫째자리 수 출력
											// 2. 연산 종료 후 첫번째 피연산자 입력 시, 피연산자의 첫째자리 수 출력				
				txtResult.setText(btnTitle);
			
			}else{ // 이전 숫자
				
				if(txtText.equals("0.0")){
					
					if(btnTitle.equals("0")){	
					
						txtResult.setText("0");	// 클리어상태(0.0)에서 0.?을 첫번째 피연산자로 사용가능케 함
						
						return;
					}
					else{						// 초기화상태(0.0)에서 숫자 입력 시,
												// txtResult의 0.0을 아무것도 입력하지 않은 상태로 설정
						txtText = "";
					}
				}
				
				txtResult.setText(txtText + btnTitle);	// txtResult에 숫자 누적
			}
			
			preOperator = "";					// 피연산자의 첫 숫자 입력 후,
												// 그 다음 숫자들 입력 시, 위의 if(!preOperator.equals(""))
												// 조건문에 걸리지 않고 else에 걸리게 해,
												// txtResult에 숫자가 누적되어 보이게 하기 위함
			
		}else if(btnTitle.equals(".")){
			
			if(txtText.indexOf(".")==-1){
									
				txtResult.setText(txtText + btnTitle);
				preOperator = "";
			}
			
		}else{
			
			if(!preOperator.equals("") && !preOperator.equals("=")){
				// !preOperator.equals("") : 사용자가 피연산자 입력 후, 연산자나 등호를 제대로 바로 입력했을 경우를 위한 조건
				// !preOperator.equals("=") : 연산자를 제대로 입력할 때까지, 등호를 그 전에 얼마나 입력하든 상관없게 해주는 조건
				if(!btnTitle.equals("="))
					c.setOp(btnTitle.charAt(0));
			
				return;
			}
			
			String result = c.result(txtText, btnTitle);
			txtResult.setText(result);
			preOperator = btnTitle;
		}
	}
	
	public void btnClear(View v){			// 전체 연산 클리어
		
		preOperator = "";
		c.setSu(0.0);
		c.setOp('=');
		txtResult.setText("0.0");
	}
	
	public void btnNumClear(View v){		// 입력 중이던 피연산자 클리어
		
		if(preOperator.equals(""))		
			txtResult.setText("0.0");
	}
	
	private boolean isString(String str){	// 스트링: true, 스트링x: false 반환
											
		for(int i=0; i<str.length(); i++){
			
			if(Character.isDigit(str.charAt(i)))
				return false;
		}
		
		return true;
	}
}

class Calc{
	
	private double su = 0.0;			// 첫번째 피연산자와 하나의 연산의 결과값을 담고 있음
	private char op = '=';				// 연산자와 등호를 담고 있음
	
	public void setSu(double su){
											
		this.su = su;
	}
	
	public void setOp(char op){
											
		this.op = op;
	}
	
	public String result(String ssu, String sop){
										
		double su = Double.parseDouble(ssu);
		
		switch (op) {
		case '=':
			this.su = su;
			break;
			
		case '+':
			this.su = this.su + su;
			break;
			
		case '-':
			this.su = this.su - su;
			break;
			
		case '*':
			this.su = this.su * su;
			break;
			
		case '/':
			this.su = this.su / su;
			break;
		}
		
		this.op = sop.charAt(0);
		
		return "" + this.su;
	}
}























