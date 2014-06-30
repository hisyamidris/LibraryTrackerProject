package com.example.librarytracker;

import com.example.librarytracker.MainActivity.PlaceholderFragment;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;


public class WhereActivity extends ActionBarActivity {
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wherequery);
        StrictMode.enableDefaults();
        final EditText inputSearch = (EditText) findViewById(R.id.inputWho);
        Button buttonNext = (Button) findViewById(R.id.buttonWho);
        //final TextView outputSearch = (TextView) findViewById(R.id.confirmWho);
        
        buttonNext.setOnClickListener(new View.OnClickListener() {
          	 
            public void onClick(View arg0) {
            	//outputSearch.setText(inputSearch.getText());
                
            }
        });
        
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
	}
}
