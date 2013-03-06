// Jimmy Kim
// Java 1 Project 1
// Term 1303
// Due 3-7-2013

package com.jimmykim.java1project1;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	LinearLayout ll;
	LinearLayout.LayoutParams lp;
	EditText et;
	TextView result;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// sets layout to linear
		ll = new LinearLayout(this);
		ll.setOrientation(LinearLayout.VERTICAL);
		lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
		ll.setLayoutParams(lp);
		
		// adds a text view with text
		TextView tv = new TextView(this);
		
		// used Resource to get text field title text, from strings.xml
		tv.setText(getString(R.string.textfield_title));
		ll.addView(tv);
		
		// create String for place holder text
		String placeholderText = "Enter an Integer Here";
		
		// edit text
		et = new EditText(this);
		et.setHint(placeholderText);
		//ll.addView(et);
		
		// Button
		Button b = new Button(this);
		
		// used Resource to get text field title text, from number.xml
		b.setText(getString(R.string.button_title));
		//ll.addView(b);
		b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				// get data from resource
				int usa = getResources().getInteger(R.integer.usa);
				int canada = getResources().getInteger(R.integer.canadian);
				
				// cast the entry data
				int entry = Integer.parseInt(et.getText().toString());
				
				int numUsa = (80/usa)*entry;
				int numCan = (100/canada)*entry;
				
				// boolean defaults to true
				Boolean highScore = true;
				
				// conditional statement to check for high score
				if (numUsa > 200){
					highScore = false;
				} else {
					highScore = true;
				}
				
				int sum = 0;
				
				// For Loop that adds together values from resources and entry
				for (int i = 0; i < 10; i++){
					sum = numUsa + numCan + entry;
				}
				
				int functionResult = add(numUsa, numCan);
				
				result.setText("USA: "+ numUsa + "\r\n" + "Canada: " + numCan + "\r\n" + "High Score: " + highScore + "\r\n" + "Sum from Loop: " + sum + "\r\n" + "Sum from Function: " + functionResult + "\r\n");
			}
		});
		
		
		
		LinearLayout form = new LinearLayout(this);
		form.setOrientation(LinearLayout.HORIZONTAL);
		lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		form.setLayoutParams(lp);
		
		form.addView(et);
		form.addView(b);
		
		ll.addView(form);
		
		result = new TextView(this);
		ll.addView(result);
		
		// sets the view
		setContentView(ll);
	}
	
	public int add(int x, int y)
	 { 
	  return x + y;
	  
	 }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
