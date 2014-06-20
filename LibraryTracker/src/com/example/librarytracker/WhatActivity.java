package com.example.librarytracker;

import com.example.librarytracker.MainActivity.PlaceholderFragment;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;


public class WhatActivity extends ActionBarActivity {
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.whatquery);
        
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
	}
}
