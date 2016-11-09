package com.ark.pocket.read.fragment.ggs;

import org.xutils.x;
import org.xutils.view.annotation.ViewInject;

import com.ark.pocket.read.R;
import com.ark.pocket.read.activity.GuiGuShiWebActivity;
import com.ark.pocket.read.adapter.GuiGuShiAdapter;
import com.ark.pocket.read.entity.ggs.GuiGuShiList;
import com.ark.pocket.read.entity.ggs.GuiGuShiRoot;
import com.ark.pocket.read.model.IGuiGuShiModel;
import com.ark.pocket.read.model.imp.GuiGuShiModel;
import com.ark.pocket.read.utils.QuWenCallBack;
import com.ark.pocket.read.view.RefreshableView;
import com.ark.pocket.read.view.RefreshableView.PullToRefreshListener;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;

public class DuanpianFragment extends Fragment {
	private View view;
	@ViewInject(R.id.lv_guigushi_list)
	private ListView lvGuigushi;

	@ViewInject(R.id.refreshable_view)
	private RefreshableView rvRefresh;
	protected boolean isBotton;

	private GuiGuShiAdapter adapter;
	GuiGuShiRoot ggs;
	IGuiGuShiModel ggsmodel;

	// 页数
	int page = 1;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		if (view == null) {
			view = inflater.inflate(R.layout.fragment_guigushi_list, null);
			x.view().inject(this, view);
			ggsmodel = new GuiGuShiModel();
			setAdapter();
			setListeners();

		} else {
			((ViewGroup) view.getParent()).removeView(view);
		}
		return view;
	}

	private void setListeners() {

		rvRefresh.setOnRefreshListener(new PullToRefreshListener() {

			@Override
			public void onRefresh() {
				try {
					if (page == 1) {
						page = 1;
					} else {
						page--;
					}
					setAdapter();
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				rvRefresh.finishRefreshing();
			}

		}, 0);

		lvGuigushi.setOnScrollListener(new OnScrollListener() {

			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) {
				if (scrollState == OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
					if (isBotton) {
						page++;
						setAdapter();
						Toast.makeText(getActivity(), "成功加载新页面", Toast.LENGTH_LONG).show();
					}
				}
			}

			@Override
			public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
				if (firstVisibleItem + visibleItemCount == totalItemCount) {
					isBotton = true;
				} else {
					isBotton = false;
				}
			}
		});

		lvGuigushi.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				GuiGuShiList ggsList = ggs.getShowapi_res_body().getPagebean().getContentlist().get(position);
				Intent intent = new Intent(getActivity(), GuiGuShiWebActivity.class);
				intent.putExtra("ggs", ggsList);
				startActivity(intent);
			}
		});
	}

	String name="dp";

	private void setAdapter() {
		ggsmodel.getGuiGuShiXiaoYuan(name, page, new QuWenCallBack() {
			@Override
			public void loaderQuWen(Object object) {
				ggs = (GuiGuShiRoot) object;
				if (ggs.getShowapi_res_body() != null) {
					adapter = new GuiGuShiAdapter(getActivity(),
							ggs.getShowapi_res_body().getPagebean().getContentlist());
					lvGuigushi.setAdapter(adapter);
				} else {
					Toast.makeText(getActivity(), "数据获取失败，请检查网络", Toast.LENGTH_LONG).show();
				}
			}

			@Override
			public void onError(Object error) {
				// TODO Auto-generated method stub
				
			}
		});

	}



}
