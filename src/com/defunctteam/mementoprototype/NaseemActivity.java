package com.defunctteam.mementoprototype;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NaseemActivity extends MementoPrototypeActivity{

	private Button cancelButton;
		
	@Override
	public void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.naseem_view);
		setUpViews();
	}

	//Defining View Components and Component Listeners
	private void setUpViews() {		
		//Binding XML Components to Java Objects				
		cancelButton = (Button)findViewById(R.id.exit_button);				
		
		//Cancel Button Listener		
		cancelButton.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				finish();				
			}
		});		
	}			
}
