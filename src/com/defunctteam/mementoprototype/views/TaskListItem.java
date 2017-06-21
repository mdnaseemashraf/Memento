package com.defunctteam.mementoprototype.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.CheckedTextView;

import com.defunctteam.mementoprototype.tasks.Task;

public class TaskListItem extends LinearLayout {

	private Task task;
	private CheckedTextView checkbox;
	
	public TaskListItem(Context context, AttributeSet attrs) {
		super(context, attrs);		
	}	
	
	@Override
	protected void onFinishInflate() {	
		super.onFinishInflate();
		checkbox = ((CheckedTextView)findViewById(android.R.id.text1));
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
		checkbox.setText(task.getName());
		checkbox.setChecked(task.isChecked());
	}
	
	
	
}
