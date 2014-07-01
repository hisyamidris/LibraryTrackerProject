package com.example.librarytracker.test;

import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
//import android.test.TouchUtils;
import android.test.ViewAsserts;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.librarytracker.WhatActivity;

public class WhatActivityTest extends ActivityInstrumentationTestCase2<WhatActivity> {
	
	private WhatActivity mActivity;
    private Button mButton1, mButton2;
    private EditText mEText;
    private String resourceString1, resourceString2, resourceString3;
    private ListView mList;
    
	public WhatActivityTest() {
		super(WhatActivity.class);
	}
	
	protected void setUp() throws Exception {        
		super.setUp();        
		mActivity = this.getActivity();        
		mButton1 = (Button) mActivity.findViewById(com.example.librarytracker.R.id.back);        
		mButton2 = (Button) mActivity.findViewById(com.example.librarytracker.R.id.buttonNext);
		mEText = (EditText) mActivity.findViewById(com.example.librarytracker.R.id.whatText);
		mList = (ListView) mActivity.findViewById(com.example.librarytracker.R.id.list);
		resourceString1 = mActivity.getString(com.example.librarytracker.R.string.back);
		resourceString2 = mActivity.getString(com.example.librarytracker.R.string.whoq);
//		resourceString3 = mActivity.getString(com.example.librarytracker.R.string.blank);
}
	public void testPreconditions() {
		assertNotNull(mButton1);
		assertNotNull(mButton2);
		assertNotNull(mEText);
		assertNotNull(mList);
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
		final View decorView = mActivity.getWindow().getDecorView();
		
		ViewAsserts.assertOnScreen(decorView, mEText);
		final ViewGroup.LayoutParams layoutParams =
		            mEText.getLayoutParams();
		assertNotNull(layoutParams);
	}
	
	public void testListViewLayout() {
		final View decorView = mActivity.getWindow().getDecorView();
		
		ViewAsserts.assertOnScreen(decorView, mList);
		final ViewGroup.LayoutParams layoutParams =
		            mList.getLayoutParams();
		assertNotNull(layoutParams);
	}
	
	/*public void testButton2() {
		getInstrumentation().waitForIdleSync();
		getInstrumentation().sendStringSync("Andy");
		getInstrumentation().waitForIdleSync();
		
		TouchUtils.clickView(this, mButton2);
	}
	*/
	
}
