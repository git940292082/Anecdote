package com.ark.pocket.read.fragment;

import java.util.ArrayList;
import java.util.List;

import org.xutils.x;
import org.xutils.view.annotation.ViewInject;

import com.ark.pocket.read.R;
import com.ark.pocket.read.fragment.xh.DongTuFragment;
import com.ark.pocket.read.fragment.xh.TuPianFragment;
import com.ark.pocket.read.fragment.xh.WenBenFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class XiaoHuaFragment extends Fragment {
	@ViewInject(R.id.rg_xiaohua)
	RadioGroup rgXiaohua;
	@ViewInject(R.id.rb_xiaohua_wenben)
	RadioButton rbWenben;
	@ViewInject(R.id.rb_xiaohua_tupian)
	RadioButton rbTupian;
	@ViewInject(R.id.rb_xiaohua_dongtu)
	RadioButton rbDongtu;

	@ViewInject(R.id.vp_xiaohua)
	ViewPager vpXiaohua;

	List<Fragment> xhfragments;
	private View view;

	private XiaoHuaPrageAdapter xiaohuaAdapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		if (view == null) {
			view = inflater.inflate(R.layout.fragment_xiaohua, null);
			x.view().inject(this, view);
			setFragmentAdapter();
			setListeners();
		} else {
			((ViewGroup) view.getParent()).removeView(view);
		}
		return view;
	}

	private void setListeners() {
		rgXiaohua.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
				case R.id.rb_xiaohua_wenben:
					vpXiaohua.setCurrentItem(0);
					break;
				case R.id.rb_xiaohua_tupian:
					vpXiaohua.setCurrentItem(1);
					break;
				case R.id.rb_xiaohua_dongtu:
					vpXiaohua.setCurrentItem(2);
					break;

				}
			}
		});
		vpXiaohua.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				switch (arg0) {
				case 0:
					rbWenben.setChecked(true);
					break;
				case 1:
					rbTupian.setChecked(true);
					break;
				case 2:
					rbDongtu.setChecked(true);
					break;
				}
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
			}
		});
	}

	private void setFragmentAdapter() {
		xhfragments = new ArrayList<Fragment>();
		xhfragments.add(new WenBenFragment());
		xhfragments.add(new TuPianFragment());
		xhfragments.add(new DongTuFragment());

		xiaohuaAdapter = new XiaoHuaPrageAdapter(getFragmentManager());
		vpXiaohua.setAdapter(xiaohuaAdapter);

	}

	class XiaoHuaPrageAdapter extends FragmentPagerAdapter {

		public XiaoHuaPrageAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int arg0) {
			return xhfragments.get(arg0);
		}

		@Override
		public int getCount() {
			return xhfragments.size();
		}

	}

}
