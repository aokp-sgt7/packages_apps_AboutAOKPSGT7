package com.aokp.sgt7.about;

import com.aokp.sgt7.about.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CategoryView extends LinearLayout {
	private String TAG = "CategoryView";
	
	private LinearLayout mContentArea;
	private ImageView mExpand;
	private RelativeLayout mHeader;
	private TextView mTitle;
	private TextView mSummary;
	private boolean isExpanded = true;

	public CategoryView(Context context) {
		this(context, null);
	}

	public CategoryView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}
	
	public CategoryView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		LayoutInflater.from(context).inflate(R.layout.category_layout, this);
	
		mContentArea = (LinearLayout)findViewById(R.id.cat_content_area);
		mExpand = (ImageView)findViewById(R.id.cat_header_image);
		mHeader = (RelativeLayout)findViewById(R.id.cat_header);
		mTitle = (TextView)findViewById(R.id.cat_header_title);
		mSummary = (TextView)findViewById(R.id.cat_header_summary);

		TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.catOptions);
		
		String catTitle = a.getString(R.styleable.catOptions_catTitle);
		if (catTitle != null) { setCatTitle(catTitle.toString()); }
		
		String catSummary = a.getString(R.styleable.catOptions_catSummary);
		if (catSummary != null) { setCatSummary(catSummary.toString()); }
		
		isExpanded = a.getBoolean(R.styleable.catOptions_isExpanded, true);
		if (!isExpanded) { 
			collapseCategory(); 
		} else {
			mExpand.setRotation(180f);
		}
		
		a.recycle();
		
		mHeader.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (isExpanded) {
					collapseCategory();
				} else {
					expandCategory();
				}
			}
		});
	}
	
	@Override
	protected void onFinishInflate() {
        int i = getChildCount();
        View[] children = new View[i];
        while(--i >= 1) {
            children[i] = getChildAt(i);
            detachViewFromParent(i);
        }
        
        for(i = 1 ; i < children.length ; i++) {
            mContentArea.addView(children[i]);
        }
		super.onFinishInflate();
	}
	
	public void setCatTitle(String mCatTitle) {
		mTitle.setText(mCatTitle);
	}

	public void setCatSummary(String mCatSummary) {
		mSummary.setText(mCatSummary);
	}

	public void expandCategory() {
		mContentArea.setVisibility(VISIBLE);
		mExpand.setRotation(180f);
		isExpanded = true;
	}

	public void collapseCategory() {
		mContentArea.setVisibility(GONE);
		mExpand.setRotation(0f);
		isExpanded = false;
	}
}
