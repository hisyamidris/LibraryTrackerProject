package com.example.librarytracker.test;

import android.test.ActivityInstrumentationTestCase2;
//import android.test.TouchUtils;
import android.test.ViewAsserts;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.librarytracker.WhereActivity;

public class WhereActivityTest extends ActivityInstrumentationTestCase2<WhereActivity> {
	
	private WhereActivity mActivity;
    private Button mButton1, mButton2;
    private EditText mEText;
    private String resourceString1, resourceString2;
    private TextView mText;
    
	public WhereActivityTest() {
		super(WhereActivity.class);
	}
	
	protected void setUp() throws Exception {        
		super.setUp();        
		mActivity = this.getActivity();        
		mButton1 = (Button) mActivity.findViewById(com.example.librarytracker.R.id.back);        
		mButton2 = (Button) mActivity.findViewById(com.example.librarytracker.R.id.buttonWho);
		mEText = (EditText) mActivity.findViewById(com.example.librarytracker.R.id.inputWho);
		mText = (TextView) mActivity.findViewById(com.example.librarytracker.R.id.textView1);
		resourceString1 = mActivity.getString(com.example.librarytracker.R.string.back);
		resourceString2 = mActivity.getString(com.example.librarytracker.R.string.whereq);
}
	public void testPreconditions() {
		assertNotNull(mButton1);
		assertNotNull(mButton2);
		assertNotNull(mEText);
		assertNotNull(mText);
	}
	
	public void testView() {
		assertEquals(this.getActivity().getCurrentViewById(), 2130903068);
	}
	
	//testing first button
	public void testButton1Layout() {
		final View decorView = mActivity.getWindow().getDecorView();

	    ViewAsserts.assertOnScreen(decorView, mButton1);

	    //Verify layout
    final ViewGroup.LayoutParams layoutParams =
	            mButton1.getLayoutParams();
	    assertNotNull(layoutParams);
		assertEquals(resourceString1,(String)mButton1.getText());
	}
	
	public void testButton2Layout() {
		final View decorView = mActivity.getWindow().getDecorView();

	    ViewAsserts.assertOnScreen(decorView, mButton2);

	    final ViewGroup.LayoutParams layoutParams =
	            mButton2.getLayoutParams();
	    assertNotNull(layoutParams);
		assertEquals(resourceString2,(String)mButton2.getText());
	}
	
	public void testEditTextLayout() {
		   /**Search matches between the input and the database and produce result in textView */
		final View decorView = mActivity.getWindow().getDecorView();
		
		ViewAsserts.assertOnScreen(decorView, mEText);
		final ViewGroup.LayoutParams layoutParams =
		            mEText.getLayoutParams();
		assertNotNull(layoutParams);
	}
	
	public void testTextViewLayout() {
		final View decorView = mActivity.getWindow().getDecorView();
		
		ViewAsserts.assertOnScreen(decorView, mText);
		final ViewGroup.LayoutParams layoutParams =
		            mText.getLayoutParams();
		assertNotNull(layoutParams);
	}
	
	public void testButton2Alpha() throws Exception{
		   /**Test that checks the output of the result obtained from database */
		    getActivity().runOnUiThread(new Runnable() {
		    String NEW_TEXT = "Code Complete 2";
		      public void run() {	   
			        mEText.setText(NEW_TEXT);
					assertEquals("Text incorrect", NEW_TEXT, mEText.getText().toString());
					
				   	mButton2.performClick();
				   	
		        	assertEquals(mText.getText(), "Title : Code Complete 2\nBook Status : Andy\nLocation : Unavailable\n\n");
		      }
		    });
		    
		    getInstrumentation().waitForIdleSync();
	}
	
	public void testButton2Alpha2() throws Exception{
		   /**Test that checks the output of the result obtained from database */
		    getActivity().runOnUiThread(new Runnable() {
		      String NEW_TEXT = "The Art of War";
		      public void run() {	   
		    	    mEText.setText(NEW_TEXT);
					assertEquals("Text incorrect", NEW_TEXT, mEText.getText().toString());
				   	mButton2.performClick();
				   	
		        	assertNotSame(mText.getText(), "Title : The Art of War\nBook Status : Available\nLocation : Library Section N2\n\n");
		      }
		    });
		    
		    getInstrumentation().waitForIdleSync();
	}
	
	public void testButton2Numeric() throws Exception{
		   /**Test that checks the output of the result obtained from database */
		    getActivity().runOnUiThread(new Runnable() {
		      String NEW_TEXT = "23489528349582";
		      public void run() {
		    	    mEText.setText(NEW_TEXT);
					assertEquals("Text incorrect", NEW_TEXT, mEText.getText().toString());
				   	mButton2.performClick();
				   	
		        	assertEquals(mText.getText(), "");
		      }
		    });
		    
		    getInstrumentation().waitForIdleSync();
	}
	
	public void testButton2Blank() throws Exception{
		   /**Test that checks the output of the result obtained from database */
		    getActivity().runOnUiThread(new Runnable() {
		      String NEW_TEXT = "";
		      public void run() {
		    	    mEText.setText(NEW_TEXT);
					assertEquals("Text incorrect", NEW_TEXT, mEText.getText().toString());
				   	mButton2.performClick();
				   	
		        	assertEquals(mText.getText(), "");
		      }
		    });
		    
		    getInstrumentation().waitForIdleSync();
	}
	
	public void testButton2AnotherTest() throws Exception{
		   /**Test that checks the output of the result obtained from database */
		    getActivity().runOnUiThread(new Runnable() {
		      String NEW_TEXT = "";
		      public void run() {	   
		    	    mEText.setText(NEW_TEXT);
					assertEquals("Text incorrect", NEW_TEXT, mEText.getText().toString());
				   	mButton2.performClick();
				   	
		        	assertNotSame(mText.getText(), "asdhfajshdfjklhasldjkhf");
		      }
		    });
		    
		    getInstrumentation().waitForIdleSync();
	}
}
