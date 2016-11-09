package com.ark.pocket.read.adapter;

import java.util.List;

import com.ark.pocket.read.R;
import com.ark.pocket.read.entity.xh.WenBen;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class WenBenAdapter extends BaseAdapter {
	Context context;
	List<WenBen> xhwenben;
	LayoutInflater inflater;

	public WenBenAdapter(Context context, List<WenBen> xhwenben) {
		super();
		this.context = context;
		this.xhwenben = xhwenben;
		this.inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return xhwenben.size();
	}

	@Override
	public WenBen getItem(int position) {
		return xhwenben.get(position);
	}

	@Override
	public long getItemId(int position) {
		return xhwenben.size();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.xiaohua_wenben_item, null);
			holder = new ViewHolder();
			holder.tvTitle = (TextView) convertView.findViewById(R.id.tv_wenben_item_title);
			holder.tvContent = (TextView) convertView.findViewById(R.id.tv_wenben_item_content);
			convertView.setTag(holder);
		}
		holder = (ViewHolder) convertView.getTag();
		WenBen wenBen = getItem(position);
		holder.tvTitle.setText(Html.fromHtml(wenBen.getTitle()));
		holder.tvContent.setText(Html.fromHtml(wenBen.getText()));

		return convertView;
	}

	class ViewHolder {
		TextView tvTitle;
		TextView tvContent;
	}

}
