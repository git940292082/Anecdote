package com.ark.pocket.read.activity;

import org.xutils.x;
import org.xutils.view.annotation.ViewInject;

import com.ark.pocket.read.R;
import com.ark.pocket.read.R.id;
import com.ark.pocket.read.R.layout;
import com.ark.pocket.read.R.menu;
import com.ark.pocket.read.entity.xh.WenBen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

public class TupianActivity extends Activity {
	@ViewInject(R.id.tv_tp_title)
	TextView tvTitle;
	@ViewInject(R.id.iv_tp)
	ImageView ivTupian;

	WenBen tupian;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tupian);
		x.view().inject(this);
	}

}
