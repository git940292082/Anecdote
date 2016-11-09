package com.ark.pocket.read.fragment;

import org.xutils.x;
import org.xutils.view.annotation.ViewInject;

import com.ark.pocket.read.R;
import com.ark.pocket.read.activity.CaiMiActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class DiscoverFragment extends Fragment implements OnClickListener {
	private View view;

	@ViewInject(R.id.bt_riddle)
	Button btRiddke;
	@ViewInject(R.id.bt_robot)
	Button btRobot;
	@ViewInject(R.id.bt_game)
	Button btGame;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		if (view == null) {
			view = inflater.inflate(R.layout.fragment_discover, null);
			x.view().inject(this, view);
			setListeners();
		} else {
			((ViewGroup) view.getParent()).removeView(view);
		}
		return view;
	}

	private void setListeners() {
		btRiddke.setOnClickListener(this);
		btRobot.setOnClickListener(this);
		btGame.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bt_riddle:
			Intent intent = new Intent(getActivity(), CaiMiActivity.class);
			startActivity(intent);
			break;
		case R.id.bt_robot:

			break;
		case R.id.bt_game:

			break;

		}
	}

}
