package com.defunctteam.mementoprototype;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class SplashScreenActivity extends MementoPrototypeActivity{
	
	private ImageButton imgButton;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_screen);
		setUpViews();
	}
	
	//Defining View Components and Component Listeners
		private void setUpViews() {		
			//Binding XML Components to Java Objects			
			imgButton = (ImageButton)findViewById(R.id.imButton1);			
			
			//Splash Screen Button Listener
			imgButton.setOnClickListener(new View.OnClickListener(){
				@Override
				public void onClick(View v){
					Intent intent = new Intent(SplashScreenActivity.this, ViewTasksActivity.class);
					startActivity(intent);
				}
			});
						
		}
}
