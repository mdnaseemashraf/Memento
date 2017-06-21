package com.defunctteam.mementoprototype;

import com.defunctteam.mementoprototype.tasks.Task;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.app.AlertDialog;
import android.content.DialogInterface;


//Behaviour file for Adding Tasks View [add_tasks_view.xml]
public class AddTaskActivity extends MementoPrototypeActivity{

	private EditText taskNameEditText;
	private Button addButton;
	private Button cancelButton;
	protected boolean changesPending;
	protected AlertDialog unsavedChangesDialog;

	@Override
	public void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_tasks_view);
		setUpViews();
	}

	//Defining View Components and Component Listeners
	private void setUpViews() {		
		//Binding XML Components to Java Objects
		taskNameEditText = (EditText)findViewById(R.id.task_name);
		addButton = (Button)findViewById(R.id.add_task_button);		
		cancelButton = (Button)findViewById(R.id.cancel_button);
		
		//Add Task Button Listener
		addButton.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				addTask();
			}
		});
		
		//Cancel Button Listener		
		cancelButton.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				cancel();				
			}
		});		
		
		//Check of Changed Text in taskNameEditText
		taskNameEditText.addTextChangedListener(new TextWatcher(){
			//On Text Changed event method
			@Override
			public void onTextChanged(CharSequence s, int start, int count, int after){
				changesPending = true;
			}
			
			//Before Text Changed event method
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after){}
			
			//After Text Changed event method
			@Override
			public void afterTextChanged(Editable s){}									
		});
	}
	
	//Add Task Method
	protected void addTask() {		
		String taskName = taskNameEditText.getText().toString();	//Retrieving Text String from user input				
		Task t = new Task(taskName);								//Create Task object t				
		getMementoPrototypeApplication().addTask(t);				//Add task t to Application
		finish();	 												//Finish this activity
	}		
	
	//Finish this activity
	protected void cancel() {
		
		String taskName = taskNameEditText.getText().toString();	//Retrieving Text String from user input
		//Check for changes and neglect empty string
		if(changesPending && !taskName.equals(""))
		{
			 //Cancel Confirmation Alert Dialog
            unsavedChangesDialog = new AlertDialog.Builder(this)
            .setTitle(R.string.add_task_unsaved_title)
            .setMessage(R.string.unsaved_task_changes_message)
            .setPositiveButton(R.string.add_task, new AlertDialog.OnClickListener()	//Set Positive/Accept button
            {
    			@Override
				public void onClick(DialogInterface dialog, int which)
    			{
    				addTask();
    			}
            })
            .setNeutralButton(R.string.discard_task_changes, new AlertDialog.OnClickListener()	//Set Neutral/Discard button
            {
               @Override
			public void onClick(DialogInterface dialog, int which)
               {                       
            	   finish();                       
               }
            })
            .setNegativeButton(R.string.cancel_string, new AlertDialog.OnClickListener(){	//Set Negative/Cancel button
               @Override
			public void onClick(DialogInterface dialog, int which)
               {
            	   unsavedChangesDialog.cancel();
               }
            })
            .create();
            unsavedChangesDialog.show();	//Show Cancel Alert Dialog
		}
		else
		{
			finish();	//Exit view without any Cancel Confirmation Dialog
		}			
	}
												
}
