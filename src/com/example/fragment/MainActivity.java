package com.example.fragment;

import com.example.fragment.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

public class MainActivity extends FragmentActivity {
	
	private static final String KEY_FRAGMENT ="fragment_save";
	private String mFragment;
	
	private final Dynamic1Fragment mDynamic1 = new Dynamic1Fragment();
	private final Dynamic2Fragment mDynamic2 = new Dynamic2Fragment();

			
			
    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		if ( savedInstanceState!=null)
			mFragment = savedInstanceState.getString(KEY_FRAGMENT);
		else 
			mFragment = getIntent().getStringExtra(KEY_FRAGMENT);
		
		if (mFragment != null){
			if(mFragment.equals(((Object)mDynamic1).getClass().getSimpleName())) {
				showFragment(this.mDynamic1);
			}
			else if (mFragment.equals(((Object)mDynamic2).getClass().getSimpleName())) {
				showFragment(this.mDynamic2);
				}
		}
			else {
				showFragment(this.mDynamic1);
				}
		}
    
			
		
		@Override
		protected void onSaveInstanceState(Bundle outState){
			outState.putString(KEY_FRAGMENT, mFragment != null ? mFragment : "");
			super.onSaveInstanceState(outState);
		}
	
    
    private void showFragment(final Fragment fragment) {
    	if (fragment == null)
    		return;
    	//update current fragment
    	mFragment = ((Object)fragment).getClass().getSimpleName();
    	// Begin a fragment transaction.
    	final FragmentManager fm = getSupportFragmentManager();
    	final FragmentTransaction ft = fm.beginTransaction();
    	// We can also animate the changing of fragment.
    	ft.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    	// Replace current fragment by the new one.
    	ft.replace(R.id.layoutToReplace, fragment);
    	// Null on the back stack to return on the previous fragment when user
    	// press on back button.
    	ft.addToBackStack(null);

    	// Commit changes.
    	ft.commit();
    }

    public void goToFragment1(View v) {
    	showFragment(this.mDynamic1);
    }

    public void goToFragment2(View v) {
    	showFragment(this.mDynamic2);
    }
	}
