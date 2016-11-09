package com.ark.pocket.read.activity;

import org.xutils.x;
import org.xutils.view.annotation.ViewInject;

import com.ark.pocket.read.R;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class LogoActivity extends Activity {
	// logo控件
	@ViewInject(R.id.logo_iv_icon)
	private ImageView logoIvIcon;
	// 文字
	@ViewInject(R.id.logo_tv_kou)
	private TextView logoTvKou;
	@ViewInject(R.id.logo_tv_dai)
	private TextView logoTvDai;
	@ViewInject(R.id.logo_tv_yue)
	private TextView logoTvYue;
	@ViewInject(R.id.logo_tv_du)
	private TextView logoTvDu;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_logo);
		// X注解
		x.view().inject(this);

		// 补间动画
		setAnimations();

		Handler handler=new Handler();
		handler.postDelayed(new Runnable() {
			
			@Override
			public void run() {
				Intent intent = new Intent(getApplicationContext(), PocketMainActivity.class);
				startActivity(intent);
				finish();
			}
		}, 5000);

	}

	/**
	 * 补间动画
	 */
	private void setAnimations() {
		Animation iconAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.logo_icon_animation);
		logoIvIcon.startAnimation(iconAnimation);
		Animation kouAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.logo_kou_animation);
		logoTvKou.startAnimation(kouAnimation);
		Animation daiAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.logo_dai_animation);
		logoTvDai.startAnimation(daiAnimation);
		Animation yinAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.logo_yue_animation);
		logoTvYue.startAnimation(yinAnimation);
		Animation yueAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.logo_du_animation);
		logoTvDu.startAnimation(yueAnimation);

	}

}
