package com.example.librarytracker;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.librarytracker.MainActivity.PlaceholderFragment;

public class WhatActivity extends ActionBarActivity {
    
	private int currentViewId = -2;
	/**
     * Upon start of the class, onCreate function sets the view and state of the program
     */
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCurrentViewById(R.layout.whatquery);
        StrictMode.enableDefaults();
	     
	     // Find the ListView resource. 
	     mainListView = (ListView) findViewById( R.id.list );

	     // Create a List of names.
	     String[] books = new String[] { "" };  
	     final ArrayList<String> bookList = new ArrayList<String>();
	     bookList.addAll( Arrays.asList(books) );
	     
	     // Create ArrayAdapter
	     listAdapter = new ArrayAdapter<String>(this, R.layout.simplerow, bookList);
	     
	     // Set the ArrayAdapter as the ListView's adapter.
	     mainListView.setAdapter( listAdapter );      
	     
	    	   
        final EditText inputSearch = (EditText) findViewById(R.id.whatText);
        Button buttonNext = (Button) findViewById(R.id.buttonNext);
        Button previousScreen = (Button) findViewById(R.id.back);
        
        buttonNext.setOnClickListener(new View.OnClickListener() {
        	/** After clicking on the button, the SQL query is sent*/
            public void onClick(View arg0) {
            	bookList.clear();         	
     		  listAdapter.notifyDataSetChanged();
            	bookList.addAll( Arrays.asList(getData(inputSearch.getText().toString())));   
            }
        });
        
        previousScreen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                //Starting a new Intent
                Intent nextScreen = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(nextScreen);
 
            }
        });
        
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
	}
	/**
	 * @brief      Searches the librarybooks database for names that matches with the input string.
	 *
	 * @param      input     Collected string from input box.
	 *
	 * @return     An array of string consisting all matching results.
	 *
	 */
	   public String[] getData(String input){
		   String[] list = new String[] { "" };  
			input = input.replaceAll(" ", "%20");
			String result = "";
	    	InputStream isr = null;
			try{
	            HttpClient httpclient = new DefaultHttpClient();
	            HttpPost httppost = new HttpPost("http://ragnarokrefreshed.ragnarok.gs/getWho.php?user="+input); //YOUR PHP SCRIPT ADDRESS 
	            HttpResponse response = httpclient.execute(httppost);
	            HttpEntity entity = response.getEntity();
	            isr = entity.getContent();
	    }

	    catch(Exception e){
	            Log.e("log_tag", "Error in http connection "+e.toString());
	    }
	    //convert response to string
	    try{
	            BufferedReader reader = new BufferedReader(new InputStreamReader(isr,"iso-8859-1"),8);
	            StringBuilder sb = new StringBuilder();
	            String line = null;
	            while ((line = reader.readLine()) != null) {
	                    sb.append(line + "\n");
	            }
	            isr.close();
	     
	            result=sb.toString();
	    }
	    //Error message in event that conversion fails
	    catch(Exception e){
	            Log.e("log_tag", "Error  converting result "+e.toString());
	    }
	     
	   // parse the JSON data
	   try {
		   JSONArray jArray = new JSONArray(result);
		   for(int i=0; i<jArray.length();i++){
			   JSONObject json = jArray.getJSONObject(i);
			   listAdapter.add( json.getString("title") );
		   }
		
	   } catch (Exception e) {
		// TODO: handle exception
		   Log.e("log_tag", "Error Parsing Data "+e.toString());
	   }
	    return list;
	    }
	   private ListView mainListView ;
	   private ArrayAdapter<String> listAdapter ;
	   
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
	   public int getCurrentViewById() {
	        return currentViewId;
	    }

}
