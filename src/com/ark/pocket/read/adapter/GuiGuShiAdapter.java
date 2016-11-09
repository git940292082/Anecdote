package com.ark.pocket.read.adapter;

import java.util.List;

import com.ark.pocket.read.R;
import com.ark.pocket.read.entity.ggs.GuiGuShiList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GuiGuShiAdapter extends BaseAdapter {
	Context context;
	List<GuiGuShiList> list;
	LayoutInflater inflater;

	public GuiGuShiAdapter(Context context, List<GuiGuShiList> list) {
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
	public GuiGuShiList getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return list.size();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.guigushi_item, null);
			holder = new ViewHolder();
			holder.tvTitle = (TextView) convertView.findViewById(R.id.tv_guigs_item_title);
			holder.tvContent = (TextView) convertView.findViewById(R.id.tv_guigs_item_source);
			// holder.wvImage = (ImageView)
			// convertView.findViewById(R.id.wv_guigs_item_image);
			convertView.setTag(holder);
		}
		holder = (ViewHolder) convertView.getTag();
		GuiGuShiList ggs = getItem(position);
		holder.tvTitle.setText(ggs.getTitle());
		holder.tvContent.setText("         " + ggs.getDesc());
		// 使用web显示失败
		// holder.wvImage.loadUrl(ggs.getImg());

		// 使用xutils显示失败
		// if (ggs.getImg() != null) {
		// Log.i("sas", ggs.getImg().toString());
		// x.image().bind(holder.ivContent, ggs.getImg());
		//
		// } else {
		// holder.ivContent.setImageResource(R.drawable.selector_guigushi);
		// }

		return convertView;
	}

	class ViewHolder {
		TextView tvTitle;
		TextView tvContent;
		ImageView wvImage;
	}

}
