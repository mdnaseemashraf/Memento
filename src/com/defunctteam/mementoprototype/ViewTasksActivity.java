package com.defunctteam.mementoprototype;

import com.defunctteam.mementoprototype.adapter.TaskListAdapter;
import com.defunctteam.mementoprototype.tasks.Task;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import android.content.Intent;
import android.app.ListActivity;

//Behaviour file for Task View [list_tasks_view.xml] and custom layout [task_list_item.xml]
public class ViewTasksActivity extends ListActivity {

	private Button addTaskButton;	
	private MementoPrototypeApplication app;
	private TaskListAdapter adapter;
	private Button removeTaskButton;
	private Button aboutButton;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_tasks_view);
		setUpViews();
		
		app = (MementoPrototypeApplication)getApplication();
		adapter = new TaskListAdapter(app.getCurrentTasks(), this);
		
		setListAdapter(adapter);		
	}	
	
	@Override
	public void onResume() {		
		super.onResume();
		adapter.forceReload();
	}			
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {		
		super.onListItemClick(l, v, position, id);
		adapter.toggleTaskCheckedAtPosition(position);
		Task t = adapter.getItem(position);
		app.saveTask(t);
	}

	//Defining View Components and Component Listeners
	private void setUpViews() {
		addTaskButton = (Button)findViewById(R.id.add_tasks_button);		
		removeTaskButton = (Button)findViewById(R.id.remove_tasks_button);		
		aboutButton = (Button)findViewById(R.id.about_button);		
		
		//Add Task Button Click Listener
		addTaskButton.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				Intent intent = new Intent(ViewTasksActivity.this, AddTaskActivity.class);
				startActivity(intent);
			}
			
		});
		
		//Remove Task Button Click Listener
		removeTaskButton.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				removeCheckedTasks();
			}
			
		});
		
		//About Button Click Listener
		aboutButton.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				Intent intent = new Intent(ViewTasksActivity.this, AboutActivity.class);
				startActivity(intent);
				}		
		});
	}

	protected void removeCheckedTasks() {		
		Long[] ids = adapter.removeCheckedTasks();
		app.deleteTask(ids);
	}
			
}
