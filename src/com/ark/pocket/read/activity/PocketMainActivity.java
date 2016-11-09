package com.ark.pocket.read.activity;

import org.xutils.x;
import org.xutils.view.annotation.ViewInject;

import com.ark.pocket.read.R;
import com.ark.pocket.read.fragment.DiscoverFragment;
import com.ark.pocket.read.fragment.GuiGuShiFragment;
import com.ark.pocket.read.fragment.MyFragment;
import com.ark.pocket.read.fragment.XiaoHuaFragment;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class PocketMainActivity extends FragmentActivity implements OnClickListener {
	@ViewInject(R.id.btn_main_xiaohua)
	private Button btnXiaoHua;
	@ViewInject(R.id.btn_main_guigushi)
	private Button btnGuiGuShi;
	@ViewInject(R.id.btn_main_discover)
	private Button btnDiscover;
	@ViewInject(R.id.btn_main_my)
	private Button btnMy;

	XiaoHuaFragment xiaohuafragment;
	GuiGuShiFragment guigushifragment;
	DiscoverFragment discoverfragment;
	MyFragment myfragment;
	// 单击的是第几个按钮
	int clickButtonIndex;
	Button[] btn = new Button[4];
	// 当前显示的是第几个fragment
	int currentShowFragmentIndex = 0;
	Fragment[] fragments = new Fragment[4];
	
	public static PocketMainActivity pocket;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		try {
			setContentView(R.layout.activity_pocket_main);
			x.view().inject(this);
			setListeners();
			xiaohuafragment = new XiaoHuaFragment();
			showFirstFragment();
			guigushifragment = new GuiGuShiFragment();
			discoverfragment = new DiscoverFragment();
			myfragment = new MyFragment();
			fragments[0] = xiaohuafragment;
			fragments[1] = guigushifragment;
			fragments[2] = discoverfragment;
			fragments[3] = myfragment;
			pocket=this;
		} catch (Exception e) {

		}
	}
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
	}

	private void showFirstFragment() {
		// 开始事务
		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
		// 动作1:add
		transaction.add(R.id.ll_fragment_page, xiaohuafragment);
		// 动作2:show
		transaction.show(xiaohuafragment);
		// 提交事务
		transaction.commit();

	}

	private void setListeners() {
		btnXiaoHua.setOnClickListener(this);
		btnGuiGuShi.setOnClickListener(this);
		btnDiscover.setOnClickListener(this);
		btnMy.setOnClickListener(this);

	}
	public void exit(){
		finish();
	}

	@Override
	public void onClick(View v) {
		try {
			switch (v.getId()) {
			case R.id.btn_main_xiaohua:
				clickButtonIndex = 0;
				btnGuiGuShi.setEnabled(true);
				btnDiscover.setEnabled(true);
				btnMy.setEnabled(true);
				btnXiaoHua.setEnabled(false);
				break;
			case R.id.btn_main_guigushi:
				clickButtonIndex = 1;
				btnGuiGuShi.setEnabled(false);
				btnDiscover.setEnabled(true);
				btnMy.setEnabled(true);
				btnXiaoHua.setEnabled(true);
				break;
			case R.id.btn_main_discover:
				clickButtonIndex = 2;
				btnGuiGuShi.setEnabled(true);
				btnDiscover.setEnabled(false);
				btnMy.setEnabled(true);
				btnXiaoHua.setEnabled(true);
				break;
			case R.id.btn_main_my:
				clickButtonIndex = 3;
				btnGuiGuShi.setEnabled(true);
				btnDiscover.setEnabled(true);
				btnMy.setEnabled(false);
				btnXiaoHua.setEnabled(true);
				break;

			}
			if (clickButtonIndex != currentShowFragmentIndex) {
				FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
				// action1:隐藏正在显示的fragment
				Fragment hideFragment = fragments[currentShowFragmentIndex];
				fragmentTransaction.hide(hideFragment);
				// action2:添加要显示的fragment
				Fragment showfragment = fragments[clickButtonIndex];
				if (!showfragment.isAdded()) {
					fragmentTransaction.add(R.id.ll_fragment_page, showfragment);
				}
				fragmentTransaction.show(showfragment);
				fragmentTransaction.commit();
				currentShowFragmentIndex = clickButtonIndex;

			}

		} catch (Exception e) {
			
		}

	}

}
