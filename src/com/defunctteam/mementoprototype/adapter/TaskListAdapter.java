package com.defunctteam.mementoprototype.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import android.content.Context;

import java.util.ArrayList;

import com.defunctteam.mementoprototype.R;
import com.defunctteam.mementoprototype.tasks.Task;
import com.defunctteam.mementoprototype.views.TaskListItem;

public class TaskListAdapter extends BaseAdapter {

	private ArrayList<Task> tasks;
	private Context context;
		
	public TaskListAdapter(ArrayList<Task> tasks, Context context) {
		super();
		this.tasks = tasks;
		this.context = context;
	}

	@Override
	public int getCount() {
		return tasks.size(); 		
	}

	@Override
	public Task getItem(int position) {
		return (null == tasks) ? null : tasks.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent){
		TaskListItem tli;
		if(null == convertView) 
		{
			tli = (TaskListItem)View.inflate(context, R.layout.task_list_item, null);
		}
		else
		{
			tli = (TaskListItem)convertView;
		}
		tli.setTask(tasks.get(position));
		return tli;
	}

	public void forceReload() {
		notifyDataSetChanged();									//NOTIFY android OS of change in application status.
	}

	//Toggle Checkbox status of selected index "position" list entry
	public void toggleTaskCheckedAtPosition(int position) {
		Task t = tasks.get(position);
		t.toggleChecked();
		notifyDataSetChanged();									//NOTIFY android OS of change in application status.
	}

	//Remove Checked Tasks
	public Long[] removeCheckedTasks() {
		ArrayList<Long> completedIds = new ArrayList<Long>();
		ArrayList<Task> checkedTasks = new ArrayList<Task>();	//Take an ArrayList of Completed Tasks
		for(Task task : tasks){
			if(task.isChecked()){								//Check for Checkbox status
				completedIds.add(task.getId());
				checkedTasks.add(task);							//Add Checked Tasks to ArrayList
			}						
		}		
		tasks.removeAll(checkedTasks);							//Remove checkedTasks ArrayList from tasks ArrayList
		notifyDataSetChanged();									//NOTIFY android OS of change in application status.
		
		return completedIds.toArray(new Long[]{});
	}

}
