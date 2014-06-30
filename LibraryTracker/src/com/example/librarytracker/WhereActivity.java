package com.example.librarytracker;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import com.example.librarytracker.MainActivity.PlaceholderFragment;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
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
 //       final TextView outputSearch = (TextView) findViewById(R.id.confirmWho);
        
        buttonNext.setOnClickListener(new View.OnClickListener() {
          	 
            public void onClick(View arg0) {
 //           	outputSearch.setText(inputSearch.getText());
                getData(inputSearch.getText().toString());    
            }
        });
        
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
	}
	   public void getData(String input){
	    	String result = "";
	    	InputStream isr = null;
	    	TextView resultView = (TextView) findViewById(R.id.textView1);;
			try{
	            HttpClient httpclient = new DefaultHttpClient();
	            HttpPost httppost = new HttpPost("http://ragnarokrefreshed.ragnarok.gs/getWhere.php?user="+input); //YOUR PHP SCRIPT ADDRESS 
	            HttpResponse response = httpclient.execute(httppost);
	            HttpEntity entity = response.getEntity();
	            isr = entity.getContent();
	    }
	    catch(Exception e){
	            Log.e("log_tag", "Error in http connection "+e.toString());
	            resultView.setText("Couldnt connect to database");
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
	    catch(Exception e){
	            Log.e("log_tag", "Error  converting result "+e.toString());
	    }
	     
	    //parse json data
	   try {
		   String s = "";
		   JSONArray jArray = new JSONArray(result);
		   
		   for(int i=0; i<jArray.length();i++){
			   JSONObject json = jArray.getJSONObject(i);
			   s = s + 
					   "Title : "+json.getString("title")+"\n"+
					   "Book Status : "+json.getString("whoq")+"\n"+
					   "Location : "+json.getString("where")+"\n\n";
		   }
		   
		   resultView.setText(s);
		
	   } catch (Exception e) {
		// TODO: handle exception
		   Log.e("log_tag", "Error Parsing Data "+e.toString());
	   }
	    
	    }
}

