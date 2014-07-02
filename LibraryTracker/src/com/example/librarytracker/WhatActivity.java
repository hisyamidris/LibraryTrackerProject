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
    
	private int currentViewId = 2130903067;
	/**
     * Upon start of the class, onCreate function sets the view and state of the program
     */
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCurrentViewById(R.layout.whatquery);
        StrictMode.enableDefaults();
	     
	     // Find the ListView resource. 
	     mainListView = (ListView) findViewById( R.id.list );

	     // Create and populate a List of planet names.
	     String[] books = new String[] { "" };  
	     final ArrayList<String> bookList = new ArrayList<String>();
	     bookList.addAll( Arrays.asList(books) );
	     
	     // Create ArrayAdapter using the planet list.
	     listAdapter = new ArrayAdapter<String>(this, R.layout.simplerow, bookList);
	     
	     // Add more planets. If you passed a String[] instead of a List<String> 
	     // into the ArrayAdapter constructor, you must not add more items. 
	     // Otherwise an exception will occur.
	     
	     // Set the ArrayAdapter as the ListView's adapter.
	     mainListView.setAdapter( listAdapter );      
	     
	    	   
        final EditText inputSearch = (EditText) findViewById(R.id.whatText);
        Button buttonNext = (Button) findViewById(R.id.buttonNext);
  //      final TextView outputSearch = (TextView) findViewById(R.id.textView1);
        Button previousScreen = (Button) findViewById(R.id.back);
        
        buttonNext.setOnClickListener(new View.OnClickListener() {
        	/** After clicking on the button, the SQL query is sent*/
            public void onClick(View arg0) {
        //     	outputSearch.setText(inputSearch.getText());
            	bookList.clear();         	
 //    		   for(int i=0; i == planetList.size();i++) listAdapter.remove(listAdapter.getItem(i));
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
		 * This methods gets the data from the database using SQL queries
		 * @param input
		 */
	   public String[] getData(String input){
		   String[] list = new String[] { "" };  
//		   String s = "";
			input = input.replaceAll(" ", "%20");
			String result = "";
	    	InputStream isr = null;
//	    	TextView resultView = (TextView) findViewById(R.id.textView2);
//	    	resultView.setText(s);
			try{
	            HttpClient httpclient = new DefaultHttpClient();
	            HttpPost httppost = new HttpPost("http://ragnarokrefreshed.ragnarok.gs/getWho.php?user="+input); //YOUR PHP SCRIPT ADDRESS 
	            HttpResponse response = httpclient.execute(httppost);
	            HttpEntity entity = response.getEntity();
	            isr = entity.getContent();
	    }
			/** In the event of an error connecting to the database
			 *  the error message is displayed below
			 */
	    catch(Exception e){
	            Log.e("log_tag", "Error in http connection "+e.toString());
//	            resultView.setText("Couldn't connect to database");
	    }
	    /**convert response to string */
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
	    /**Error message in event that conversion fails*/
	    catch(Exception e){
	            Log.e("log_tag", "Error  converting result "+e.toString());
	    }
	     
	   /** parse the JSON data*/
	   try {
//		   s = "";
		   JSONArray jArray = new JSONArray(result);
		   //int j;
		   for(int i=0; i<jArray.length();i++){
//			   j = i+1;
			   JSONObject json = jArray.getJSONObject(i);
//			   s = s + 
//					   j + ". "+json.getString("title")+"\n";
//			   list[i] = json.getString("title");
			   listAdapter.add( json.getString("title") );
		   }
		   
//		   resultView.setText(s);
		
	   } catch (Exception e) {
		// TODO: handle exception
		   Log.e("log_tag", "Error Parsing Data "+e.toString());
	   }
	    return list;
	    }
	   private ListView mainListView ;
	   private ArrayAdapter<String> listAdapter ;
	   
	   public void setCurrentViewById(int id) {
	        setContentView(id);
	        currentViewId = id;
	    }

	   public int getCurrentViewById() {
	        return currentViewId;
	    }

}
