package com.example.activitytest;

import android.R.string;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalcTest extends Activity {
	
	private TextView txtResult;				// �ǿ����ڿ� ������� ��µǴ� �ؽ�Ʈ��
	
	private Calc c = new Calc();			// ���� ������ ���� �޼���� ������ ������ �� Ŭ����
	
	private String preOperator = "";		// �����ڸ� �Է����� �� �� ������Ƽ�� �ش� �����ڸ� �Ҵ��صΰ�,
											// ���� ���ʷ� �ǿ����ڸ� �Է��� �� �� ������Ƽ�� ""�������� �˻��Ͽ�
											// ���ο� �ǿ����ڸ� �Է� ������ ���ִ� ����
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
		
		if(!isString(btnTitle)){	// �����Է� ��(ó�� & ������ �Է� ��)
			
			if(!preOperator.equals("")){	// 1. �ι�° �ǿ����� �Է� ��, �ǿ������� ù°�ڸ� �� ���
											// 2. ���� ���� �� ù��° �ǿ����� �Է� ��, �ǿ������� ù°�ڸ� �� ���				
				txtResult.setText(btnTitle);
			
			}else{ // ���� ����
				
				if(txtText.equals("0.0")){
					
					if(btnTitle.equals("0")){	
					
						txtResult.setText("0");	// Ŭ�������(0.0)���� 0.?�� ù��° �ǿ����ڷ� ��밡���� ��
						
						return;
					}
					else{						// �ʱ�ȭ����(0.0)���� ���� �Է� ��,
												// txtResult�� 0.0�� �ƹ��͵� �Է����� ���� ���·� ����
						txtText = "";
					}
				}
				
				txtResult.setText(txtText + btnTitle);	// txtResult�� ���� ����
			}
			
			preOperator = "";					// �ǿ������� ù ���� �Է� ��,
												// �� ���� ���ڵ� �Է� ��, ���� if(!preOperator.equals(""))
												// ���ǹ��� �ɸ��� �ʰ� else�� �ɸ��� ��,
												// txtResult�� ���ڰ� �����Ǿ� ���̰� �ϱ� ����
			
		}else if(btnTitle.equals(".")){
			
			if(txtText.indexOf(".")==-1){
									
				txtResult.setText(txtText + btnTitle);
				preOperator = "";
			}
			
		}else{
			
			if(!preOperator.equals("") && !preOperator.equals("=")){
				// !preOperator.equals("") : ����ڰ� �ǿ����� �Է� ��, �����ڳ� ��ȣ�� ����� �ٷ� �Է����� ��츦 ���� ����
				// !preOperator.equals("=") : �����ڸ� ����� �Է��� ������, ��ȣ�� �� ���� �󸶳� �Է��ϵ� ������� ���ִ� ����
				if(!btnTitle.equals("="))
					c.setOp(btnTitle.charAt(0));
			
				return;
			}
			
			String result = c.result(txtText, btnTitle);
			txtResult.setText(result);
			preOperator = btnTitle;
		}
	}
	
	public void btnClear(View v){			// ��ü ���� Ŭ����
		
		preOperator = "";
		c.setSu(0.0);
		c.setOp('=');
		txtResult.setText("0.0");
	}
	
	public void btnNumClear(View v){		// �Է� ���̴� �ǿ����� Ŭ����
		
		if(preOperator.equals(""))		
			txtResult.setText("0.0");
	}
	
	private boolean isString(String str){	// ��Ʈ��: true, ��Ʈ��x: false ��ȯ
											
		for(int i=0; i<str.length(); i++){
			
			if(Character.isDigit(str.charAt(i)))
				return false;
		}
		
		return true;
	}
}

class Calc{
	
	private double su = 0.0;			// ù��° �ǿ����ڿ� �ϳ��� ������ ������� ��� ����
	private char op = '=';				// �����ڿ� ��ȣ�� ��� ����
	
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























