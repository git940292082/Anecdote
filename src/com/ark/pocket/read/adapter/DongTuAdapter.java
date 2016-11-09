package com.ark.pocket.read.adapter;

import java.util.List;

import org.xutils.x;

import com.ark.pocket.read.R;
import com.ark.pocket.read.entity.xh.WenBen;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class DongTuAdapter extends BaseAdapter{
	Context context;
	List<WenBen> list;
	LayoutInflater inflater;

	public DongTuAdapter(Context context, List<WenBen> list) {
		super();
		this.context = context;
		this.list = list;
		this.inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public WenBen getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return list.size();
	}

	@SuppressLint("SetJavaScriptEnabled")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.xiaohua_dongtu_item, null);
			holder = new ViewHolder();
			holder.tvTitle = (TextView) convertView.findViewById(R.id.tv_dongtu_item_title);
			holder.gifView =  (ImageView) convertView.findViewById(R.id.iv_dongtu_item_content);
			convertView.setTag(holder);
		}
		holder = (ViewHolder) convertView.getTag();
		WenBen wenBen = getItem(position);
		holder.tvTitle.setText(wenBen.getTitle());
		x.image().bind(holder.gifView, wenBen.getImg());

		return convertView;
	}

	class ViewHolder {
		TextView tvTitle;
		ImageView gifView;
	}



}
