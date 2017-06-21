package com.defunctteam.mementoprototype;

import android.app.Activity;

//Superclass for all other Activity classes
public class MementoPrototypeActivity extends Activity {
	
	//Handle to Application
	protected MementoPrototypeApplication getMementoPrototypeApplication() {		
		MementoPrototypeApplication mpa = (MementoPrototypeApplication)getApplication();
		return mpa;
	}	

}
