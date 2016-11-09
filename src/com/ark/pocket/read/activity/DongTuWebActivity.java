package com.ark.pocket.read.activity;

import org.xutils.x;
import org.xutils.view.annotation.ViewInject;

import com.ark.pocket.read.R;
import com.ark.pocket.read.entity.xh.WenBen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;
import android.widget.TextView;

public class DongTuWebActivity extends Activity {
	@ViewInject(R.id.tv_dongtu_web_title)
	TextView tvTitle;
	@ViewInject(R.id.wv_dongtu)
	WebView wvDongTu;

	WenBen dongtu;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dong_tu_web);
		x.view().inject(this);

		Intent intent = getIntent();
		dongtu = (WenBen) intent.getSerializableExtra("dongtu");
		WebSettings mWebSettings = wvDongTu.getSettings();
		mWebSettings.setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);
		wvDongTu.loadUrl(dongtu.getImg());
		tvTitle.setText(dongtu.getTitle());
	}

}
