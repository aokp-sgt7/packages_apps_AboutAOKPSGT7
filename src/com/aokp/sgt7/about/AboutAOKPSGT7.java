/*
 * AboutAOKPSGT7 - by stimpz0r (19/08/2013)
 * 
 * Implements Scrolling Tricks (Copyright 2012 Roman Nurik + Nick Butcher)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.aokp.sgt7.about;

import com.aokp.sgt7.about.R;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;

public class AboutAOKPSGT7 extends Activity implements ObservableScrollView.Callbacks {
    private ObservableScrollView mObservableScrollView;
    private RelativeLayout mTitleBar;
    private View mPlaceholder;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about_aokp_sgt7);

        mObservableScrollView = (ObservableScrollView) findViewById(R.id.scroll_view);
        mObservableScrollView.setCallbacks(this);
        mTitleBar = (RelativeLayout) findViewById(R.id.title_bar);
        mPlaceholder = (View) findViewById(R.id.placeholder);

        mObservableScrollView.getViewTreeObserver().addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        onScrollChanged();
                    }
                });

	}

    @Override
    public void onScrollChanged() {
    	mTitleBar.setTranslationY(
                Math.max(0, mPlaceholder.getTop() - mObservableScrollView.getScrollY()));
    }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return false;
	}

	public void sgt7Facebook (View v) {
		launchUrl(getString(R.string.about_aokp_sgt7_url_facebook));
	}

    public void sgt7GitHub (View v) {
        launchUrl(getString(R.string.about_aokp_sgt7_url_github));
    }

    public void sgt7GPlus (View v) {
		launchUrl(getString(R.string.about_aokp_sgt7_url_googleplus));
	}

    public void sgt7Goo (View v) {
        launchUrl(getString(R.string.about_aokp_sgt7_url_goo));
    }

    public void sgt7Twitter (View v) {
        launchUrl(getString(R.string.about_aokp_sgt7_url_twitter));
    }

    public void sgt7Website (View v) {
        launchUrl(getString(R.string.about_aokp_sgt7_url_website));
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
