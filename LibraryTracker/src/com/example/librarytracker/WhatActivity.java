package com.example.librarytracker;

import com.example.librarytracker.MainActivity.PlaceholderFragment;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;

public class WhatActivity extends ActionBarActivity {
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.whatquery);
        
        final EditText inputSearch = (EditText) findViewById(R.id.whatText);
        Button buttonNext = (Button) findViewById(R.id.buttonNext);
        final TextView outputSearch = (TextView) findViewById(R.id.viewText);
        
        buttonNext.setOnClickListener(new View.OnClickListener() {
          	 
            public void onClick(View arg0) {
            	outputSearch.setText(inputSearch.getText());
                
            }
        });
        
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
	}
}
