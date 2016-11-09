package com.ark.pocket.read.fragment.xh;

import org.xutils.x;
import org.xutils.view.annotation.ViewInject;

import com.ark.pocket.read.R;
import com.ark.pocket.read.activity.DongTuWebActivity;
import com.ark.pocket.read.adapter.DongTuAdapter;
import com.ark.pocket.read.entity.xh.WenBen;
import com.ark.pocket.read.entity.xh.XiaoHua;
import com.ark.pocket.read.model.IXiaoHuaModel;
import com.ark.pocket.read.model.imp.XiaoHuaModel;
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
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AbsListView.OnScrollListener;

public class DongTuFragment extends Fragment {
	private View view;
	@ViewInject(R.id.lv_xiaohua_list)
	private ListView lvXiaohua;

	@ViewInject(R.id.refreshable_view)
	private RefreshableView rvRefresh;
	protected boolean isBotton;
	int page = 1;
	private DongTuAdapter adapter;

	XiaoHua xiaoHua;

	IXiaoHuaModel xhmodel;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		if (view == null) {
			view = inflater.inflate(R.layout.fragment_xiaohua_list, null);
			x.view().inject(this, view);
			xhmodel = new XiaoHuaModel();
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

		lvXiaohua.setOnScrollListener(new OnScrollListener() {

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

		lvXiaohua.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				WenBen dongtu = xiaoHua.getShowapi_res_body().getContentlist().get(position);
				Intent intent = new Intent(getActivity(), DongTuWebActivity.class);
				intent.putExtra("dongtu", dongtu);
				startActivity(intent);
			}
		});
	}

	private void setAdapter() {
		xhmodel.getXiaoHuaDongTu(page, new QuWenCallBack() {

			@Override
			public void loaderQuWen(Object object) {
				xiaoHua = (XiaoHua) object;
				if (xiaoHua.getShowapi_res_body() != null) {
					adapter = new DongTuAdapter(getActivity(), xiaoHua.getShowapi_res_body().getContentlist());
					lvXiaohua.setAdapter(adapter);
				} else {
					Toast.makeText(getActivity(), "数据获取失败，请检查网络", Toast.LENGTH_LONG).show();
				}
			}

			@Override
			public void onError(Object error) {
				
			}
		});
	}

}
