package com.ark.pocket.read.fragment;

import org.xutils.x;
import org.xutils.view.annotation.ViewInject;

import com.ark.pocket.read.R;
import com.ark.pocket.read.activity.LoginActivity;
import com.ark.pocket.read.activity.PocketMainActivity;
import com.ark.pocket.read.app.PocketApp;
import com.ark.pocket.read.entity.user.User;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class MyFragment extends Fragment {
	@ViewInject(R.id.iv_my_icon)
	ImageView ivIcon;
	@ViewInject(R.id.tv_my_name)
	TextView tvName;
	@ViewInject(R.id.tv_my_exit)
	TextView tvExit;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_my, null);
		x.view().inject(this, view);

		setListeners();
		
		return view;
	}

	@Override
	public void onResume() {
		super.onResume();
		
		if (PocketApp.user.getIcon() != null) {
			ivIcon.setImageBitmap(PocketApp.user.getIcon());
		}
		if (PocketApp.user.getNickname() != null) {
			tvName.setText(PocketApp.user.getNickname());
		}
	}
	private void setName() {
		User user = ((PocketApp) PocketApp.context).getCurrentUser();
		String name = user.getNickname();
		tvName.setText(name);
	}

	private void setListeners() {
		ivIcon.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), LoginActivity.class);
				startActivityForResult(intent, 1);
			}
		});

		tvExit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				PocketMainActivity.pocket.finish();
			}
		});
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (requestCode) {
		case 1:
			if (resultCode == Activity.RESULT_OK) {
				setName();
			}
			break;

		}
		super.onActivityResult(requestCode, resultCode, data);
	}

}
