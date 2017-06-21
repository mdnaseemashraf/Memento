package com.defunctteam.mementoprototype;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AboutActivity extends MementoPrototypeActivity{
		
	private Button cancelButton;	
	private Button naseemButton;	
	private Button praveenButton;	
	private Button sumitButton;	
	private Button rahulButton;	

	@Override
	public void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_menu_view);
		setUpViews();
	}

	//Defining View Components and Component Listeners
	private void setUpViews() {		
		//Binding XML Components to Java Objects					
		cancelButton = (Button)findViewById(R.id.exit_button);				
		naseemButton = (Button)findViewById(R.id.naseem_button);				
		praveenButton = (Button)findViewById(R.id.praveen_button);				
		sumitButton = (Button)findViewById(R.id.sumit_button);				
		rahulButton = (Button)findViewById(R.id.rahul_button);				
		
		//Cancel Button Listener		
		cancelButton.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				cancel();				
			}
		});						
						
		//Naseem Button Click Listener
		naseemButton.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				Intent intent = new Intent(AboutActivity.this, NaseemActivity.class);
				startActivity(intent);
				}				
			});
		
		//Praveen Button Click Listener
		praveenButton.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				Intent intent = new Intent(AboutActivity.this, PraveenActivity.class);
				startActivity(intent);
				}				
			});
		//Sumit Button Click Listener
		sumitButton.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				Intent intent = new Intent(AboutActivity.this, SumitActivity.class);
				startActivity(intent);
				}				
			});		
		
		//Rahul Button Click Listener
		rahulButton.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				Intent intent = new Intent(AboutActivity.this, RahulActivity.class);
				startActivity(intent);
				}				
			});
				
	}
		
	//Finish this activity
	protected void cancel() {				
			finish();	//Exit view without any Cancel Confirmation Dialog					
	}
}
