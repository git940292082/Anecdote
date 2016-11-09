package com.ark.pocket.read.adapter;

import java.util.List;

import com.ark.pocket.read.R;
import com.ark.pocket.read.entity.cm.MiYuLeiXing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CaiMiFenLeiAdapter extends BaseAdapter {
	Context context;
	List<MiYuLeiXing> mylist;

	public CaiMiFenLeiAdapter(Context context, List<MiYuLeiXing> mylist) {
		super();
		this.context = context;
		this.mylist = mylist;
	}

	@Override
	public int getCount() {
		return mylist.size();
	}

	@Override
	public MiYuLeiXing getItem(int position) {
		return mylist.get(position);
	}

	@Override
	public long getItemId(int position) {
		return mylist.size();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHold hold = null;
		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(R.layout.miyufenlei_item, null);
			hold = new ViewHold();
			hold.tvName = (TextView) convertView.findViewById(R.id.tv_miyuleixing_name);
			convertView.setTag(hold);
		}

		hold = (ViewHold) convertView.getTag();
		MiYuLeiXing leiXing = getItem(position);
		hold.tvName.setText(leiXing.getName());
		return convertView;
	}

	class ViewHold {
		TextView tvName;
	}

}
