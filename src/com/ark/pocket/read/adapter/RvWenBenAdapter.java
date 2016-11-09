package com.ark.pocket.read.adapter;

import java.util.List;

import com.ark.pocket.read.R;
import com.ark.pocket.read.entity.xh.WenBen;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class RvWenBenAdapter extends RecyclerView.Adapter<RvWenBenAdapter.MYViewHolder> {
	Context context;
	List<WenBen> xhwenben;

	public RvWenBenAdapter(Context context, List<WenBen> xhwenben) {
		super();
		this.context = context;
		this.xhwenben = xhwenben;
	}

	@Override
	public MYViewHolder onCreateViewHolder(ViewGroup arg0, int arg1) {
		MYViewHolder holder = new MYViewHolder(
				LayoutInflater.from(context).inflate(R.layout.xiaohua_wenben_item, arg0, false));
		return holder;
	}

	@Override
	public int getItemCount() {
		return xhwenben.size();
	}

	@Override
	public void onBindViewHolder(MYViewHolder holder, int position) {
		holder.tvTitle.setText(xhwenben.get(position).getTitle());
		holder.tvContent.setText(xhwenben.get(position).getText());
	}

	class MYViewHolder extends ViewHolder {
		TextView tvTitle;
		TextView tvContent;

		public MYViewHolder(View itemView) {
			super(itemView);
			tvTitle = (TextView) itemView.findViewById(R.id.tv_wenben_item_title);
			tvContent = (TextView) itemView.findViewById(R.id.tv_wenben_item_content);

		}

	}

}
