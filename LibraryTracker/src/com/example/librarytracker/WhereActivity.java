package com.example.librarytracker;

import com.example.librarytracker.MainActivity.PlaceholderFragment;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class WhereActivity extends ActionBarActivity {
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wherequery);
        
        final EditText inputSearch = (EditText) findViewById(R.id.inputWho);
        Button buttonNext = (Button) findViewById(R.id.buttonWho);
        final TextView outputSearch = (TextView) findViewById(R.id.confirmWho);
        
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
