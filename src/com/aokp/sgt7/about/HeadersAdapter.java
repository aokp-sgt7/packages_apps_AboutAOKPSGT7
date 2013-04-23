package com.aokp.sgt7.about;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class HeadersAdapter extends BaseExpandableListAdapter implements OnGroupClickListener {
	private Context mContext;
	private String[][] mContent;
	private String[] mTitles;
	private LayoutInflater inflater;
	
	public HeadersAdapter(Context context, String[] titles, String[][] contents) {
		mContext = context;
		mTitles = titles;
		mContent = contents;
		inflater = LayoutInflater.from(context);
	}
	
	@Override
	public Object getChild(int groupPosition, int childPosition) {
		return mContent[groupPosition][childPosition];
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return 0;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View view,
			ViewGroup parent) {
		if (view == null) {
			view = inflater.inflate(R.layout.list_item_child, parent, false);
		}
		TextView text = (TextView) view.findViewById(R.id.list_item_child_text);
		text.setText(mContent[groupPosition][childPosition]);
		return view;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		return mContent[groupPosition].length;
	}

	@Override
	public Object getGroup(int groupPosition) {
		return mContent[groupPosition];
	}

	@Override
	public int getGroupCount() {
		return mContent.length;
	}

	@Override
	public long getGroupId(int arg0) {
		return 0;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded, View view, ViewGroup parent) {
		if (view == null) {
			view = inflater.inflate(R.layout.list_item_parent, parent, false);
		}
		TextView text = (TextView) view.findViewById(R.id.list_item_parent_text);
		text.setText(mTitles[groupPosition]);
		ImageView expandImage = (ImageView) view.findViewById(R.id.expand_image);
		if (isExpanded) {
			expandImage.setRotation(180f);
		} else {
			expandImage.setRotation(0f);
		}
		return view;
	}

	@Override
	public boolean hasStableIds() {
		return false;
	}

	@Override
	public boolean isChildSelectable(int arg0, int arg1) {
		return false;
	}

	@Override
	public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
	    parent.smoothScrollToPosition(groupPosition);
	    return true;
	}

}
