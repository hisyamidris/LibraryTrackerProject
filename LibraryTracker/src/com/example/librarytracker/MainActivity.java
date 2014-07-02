package com.example.librarytracker;

import android.support.v7.app.ActionBarActivity;
//import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
//import android.os.Build;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends ActionBarActivity {

	private int currentViewId = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setCurrentViewById(R.layout.activity_main);
        
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
        
        /** Two buttons on screen established here 
         *  and their respective click functionalities
         */
        Button btnNextScreen = (Button) findViewById(R.id.button1);
        Button btnNextScreen2 = (Button) findViewById(R.id.button2);
        
        btnNextScreen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                //Starting a new Intent
                Intent nextScreen = new Intent(getApplicationContext(), WhatActivity.class);
                startActivity(nextScreen);
 
            }
        });
        
        btnNextScreen2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                //Starting a new Intent
                Intent nextScreen2 = new Intent(getApplicationContext(), WhereActivity.class);
 
                startActivity(nextScreen2);
 
            }
        });
    }


    @Override
    /**
     * Upon start of the activity, the menu
     * and items in the menu are created
     */
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        /** Handle action bar item clicks here. The action bar will
        * automatically handle clicks on the Home/Up button, so long
        * as you specify a parent activity in AndroidManifest.xml.
        */
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }
	/**
     * Sets the view and state of the program
     */
    public void setCurrentViewById(int id) {
        setContentView(id);
        currentViewId = id;
    }

	/**
     * Gets the view and state of the program
     */
    public int getCurrentViewById()
    {
        return currentViewId;
    }

}
