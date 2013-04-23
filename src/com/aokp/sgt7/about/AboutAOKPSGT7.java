package com.aokp.sgt7.about;

import com.aokp.sgt7.about.R;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.TextView;

public class AboutAOKPSGT7 extends Activity {
	int lastExpandedGroupPosition = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about_aokp_sgt7);
		
		final ExpandableListView list = (ExpandableListView) findViewById(R.id.expandableListView1);
		list.setGroupIndicator(null);
		list.setChildIndicator(null);
		
		String[] titles = { 
				getString(R.string.about_aokp_sgt7_about_title), 
				getString(R.string.about_aokp_sgt7_features_title), 
				getString(R.string.about_aokp_sgt7_credits_title) 
		};  
		String[] about = { getString(R.string.about_aokp_sgt7_about_content) };
		String[] features = { getString(R.string.about_aokp_sgt7_features_content) };
		String[] credits = { getString(R.string.about_aokp_sgt7_credits_content) };		
		String[][] contents = { about, features, credits };

		HeadersAdapter adapter = new HeadersAdapter(this, titles, contents);
		list.setOnGroupExpandListener(new OnGroupExpandListener() {

			@Override
			public void onGroupExpand(int groupPosition) {
				if (groupPosition != lastExpandedGroupPosition) {
					list.collapseGroup(lastExpandedGroupPosition);
				}
				lastExpandedGroupPosition = groupPosition;
			}

		});
		list.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return false;
	}

	public void sgt7Website (View v) {
		launchUrl(getString(R.string.about_aokp_sgt7_url_website));
	}

	public void sgt7Facebook (View v) {
		launchUrl(getString(R.string.about_aokp_sgt7_url_facebook));
	}

	public void sgt7Twitter (View v) {
		launchUrl(getString(R.string.about_aokp_sgt7_url_twitter));
	}

	public void sgt7GPlus (View v) {
		launchUrl(getString(R.string.about_aokp_sgt7_url_googleplus));
	}

	public void sgt7GitHub (View v) {
		launchUrl(getString(R.string.about_aokp_sgt7_url_github));
	}

	public void sgt7XDA (View v) {
		launchUrl(getString(R.string.about_aokp_sgt7_url_xda));
	}

    private void launchUrl(String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchUrl = new Intent(Intent.ACTION_VIEW, uriUrl);
        this.startActivity(launchUrl);
    }
	
}
