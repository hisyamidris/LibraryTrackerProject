package com.example.librarytracker.test;

import android.test.ActivityInstrumentationTestCase2;
//import android.test.TouchUtils;
import android.test.ViewAsserts;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.librarytracker.MainActivity;

public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {
	
	private MainActivity mActivity;
    private Button mButton1, mButton2;
    private TextView mText;
    private String resourceString1, resourceString2, resourceString3;
	public MainActivityTest() {
		super(MainActivity.class);
	}
	
	protected void setUp() throws Exception {        
		super.setUp();        
		mActivity = this.getActivity();     
		mButton1 = (Button) mActivity.findViewById(com.example.librarytracker.R.id.button1);        
		mButton2 = (Button) mActivity.findViewById(com.example.librarytracker.R.id.button2);
		mText = (TextView) mActivity.findViewById(com.example.librarytracker.R.id.textView1);
		resourceString1 = mActivity.getString(com.example.librarytracker.R.string.whoq);
		resourceString2 = mActivity.getString(com.example.librarytracker.R.string.whereq);
		resourceString3 = mActivity.getString(com.example.librarytracker.R.string.welcome_text);
}
	public void testPreconditions() {
		assertNotNull(mButton1);
		assertNotNull(mButton2);
		assertNotNull(mText);
	}
	
	public void testView() {
		assertEquals(this.getActivity().getCurrentViewById(), 2130903063);
	}
	//testing first button
	public void testButton1() {
		final View decorView = mActivity.getWindow().getDecorView();

	    ViewAsserts.assertOnScreen(decorView, mButton1);

	    //Verify layout
    final ViewGroup.LayoutParams layoutParams =
	            mButton1.getLayoutParams();
	    assertNotNull(layoutParams);
		assertEquals(resourceString1,(String)mButton1.getText());
	}
	
	public void testButton2() {
		final View decorView = mActivity.getWindow().getDecorView();

	    ViewAsserts.assertOnScreen(decorView, mButton2);

	    final ViewGroup.LayoutParams layoutParams =
	            mButton2.getLayoutParams();
	    assertNotNull(layoutParams);
		assertEquals(resourceString2,(String)mButton2.getText());
	}
	
	public void testTextView() {
		final View decorView = mActivity.getWindow().getDecorView();
		
		ViewAsserts.assertOnScreen(decorView, mText);
		final ViewGroup.LayoutParams layoutParams =
		            mText.getLayoutParams();
		assertNotNull(layoutParams);
		assertEquals(resourceString3,(String)mText.getText());
	}
}
