package com.ark.pocket.read.fragment;

import java.util.ArrayList;
import java.util.List;

import org.xutils.x;
import org.xutils.view.annotation.ViewInject;

import com.ark.pocket.read.R;
import com.ark.pocket.read.fragment.ggs.ChangpianFragment;
import com.ark.pocket.read.fragment.ggs.DuanpianFragment;
import com.ark.pocket.read.fragment.ggs.JialiFragment;
import com.ark.pocket.read.fragment.ggs.LingyiFragment;
import com.ark.pocket.read.fragment.ggs.MinjianFragment;
import com.ark.pocket.read.fragment.ggs.NeihanFragment;
import com.ark.pocket.read.fragment.ggs.XiaoyuanFragment;
import com.ark.pocket.read.fragment.ggs.YiyuanFragment;
import com.ark.pocket.read.fragment.ggs.YuanchuanFragment;

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

public class GuiGuShiFragment extends Fragment {
	@ViewInject(R.id.rg_guigushi)
	RadioGroup rgGuigushi;
	@ViewInject(R.id.rb_guigushi_xiaoyuan)
	RadioButton rbXiaoyuan;
	@ViewInject(R.id.rb_guigushi_minjian)
	RadioButton rbMinjian;
	@ViewInject(R.id.rb_guigushi_yiyuan)
	RadioButton rbYiyuan;
	@ViewInject(R.id.rb_guigushi_jiali)
	RadioButton rbJiali;
	@ViewInject(R.id.rb_guigushi_changpian)
	RadioButton rbChangpian;
	@ViewInject(R.id.rb_guigushi_duanpian)
	RadioButton rbDuanpian;
	@ViewInject(R.id.rb_guigushi_lingyi)
	RadioButton rbLingyi;
	@ViewInject(R.id.rb_guigushi_neihan)
	RadioButton rbNeihan;
	@ViewInject(R.id.rb_guigushi_yuanchuan)
	RadioButton rbYuanchuan;
	@ViewInject(R.id.vp_guigushi)
	ViewPager vpGuigushi;

	List<Fragment> ggsfragments;
	private View view;

	private GuigushiPrageAdapter guidgushiAdapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		if (view == null) {
			view = inflater.inflate(R.layout.fragment_guigushi, null);
			x.view().inject(this, view);
			setFragmentAdapter();
			setListeners();
		} else {
			((ViewGroup) view.getParent()).removeView(view);
		}
		return view;
	}

	private void setListeners() {
		rgGuigushi.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
				case R.id.rb_guigushi_xiaoyuan:
					vpGuigushi.setCurrentItem(0);
					break;
				case R.id.rb_guigushi_minjian:
					vpGuigushi.setCurrentItem(1);
					break;
				case R.id.rb_guigushi_yiyuan:
					vpGuigushi.setCurrentItem(2);
					break;
				case R.id.rb_guigushi_jiali:
					vpGuigushi.setCurrentItem(3);
					break;
				case R.id.rb_guigushi_lingyi:
					vpGuigushi.setCurrentItem(4);
					break;
				case R.id.rb_guigushi_changpian:
					vpGuigushi.setCurrentItem(5);
					break;
				case R.id.rb_guigushi_duanpian:
					vpGuigushi.setCurrentItem(6);
					break;
				case R.id.rb_guigushi_yuanchuan:
					vpGuigushi.setCurrentItem(7);
					break;
				case R.id.rb_guigushi_neihan:
					vpGuigushi.setCurrentItem(8);
					break;

				}
			}
		});
		vpGuigushi.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				switch (arg0) {
				case 0:
					rbXiaoyuan.setChecked(true);
					break;
				case 1:
					rbMinjian.setChecked(true);
					break;
				case 2:
					rbYiyuan.setChecked(true);
					break;
				case 3:
					rbJiali.setChecked(true);
					break;
				case 4:
					rbLingyi.setChecked(true);
					break;
				case 5:
					rbChangpian.setChecked(true);
					break;
				case 6:
					rbDuanpian.setChecked(true);
					break;
				case 7:
					rbYuanchuan.setChecked(true);
					break;
				case 8:
					rbNeihan.setChecked(true);
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
		ggsfragments = new ArrayList<Fragment>();
		ggsfragments.add(new XiaoyuanFragment());
		ggsfragments.add(new MinjianFragment());
		ggsfragments.add(new YiyuanFragment());
		ggsfragments.add(new JialiFragment());
		ggsfragments.add(new LingyiFragment());
		ggsfragments.add(new ChangpianFragment());
		ggsfragments.add(new DuanpianFragment());
		ggsfragments.add(new YuanchuanFragment());
		ggsfragments.add(new NeihanFragment());

		guidgushiAdapter = new GuigushiPrageAdapter(getFragmentManager());
		vpGuigushi.setAdapter(guidgushiAdapter);

	}

	class GuigushiPrageAdapter extends FragmentPagerAdapter {

		public GuigushiPrageAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int arg0) {
			return ggsfragments.get(arg0);
		}

		@Override
		public int getCount() {
			return ggsfragments.size();
		}

	}

}
