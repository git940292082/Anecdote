package com.ark.pocket.read.activity;

import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.x;
import org.xutils.view.annotation.ViewInject;

import com.ark.pocket.read.R;
import com.ark.pocket.read.app.PocketApp;
import com.ark.pocket.read.model.IUserModel;
import com.ark.pocket.read.model.imp.UserModel;
import com.ark.pocket.read.utils.QuWenCallBack;
import com.tencent.connect.UserInfo;
import com.tencent.connect.auth.QQAuth;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity implements OnClickListener {
	@ViewInject(R.id.qq_login)
	LinearLayout llQQLogin;
	@ViewInject(R.id.weixin_login)
	LinearLayout llWeiXin;
	@ViewInject(R.id.xinlang_login)
	LinearLayout llXinLang;
	@ViewInject(R.id.tv_register)
	TextView tvRegister;

	@ViewInject(R.id.et_login_email)
	EditText etEmail;
	@ViewInject(R.id.et_login_password)
	EditText etPassword;
	@ViewInject(R.id.ib_login)
	Button btnLogin;
	@ViewInject(R.id.iv_login_top_return)
	ImageView ivLoginReturn;

	IUserModel model;

	// QQ
	private static final String TAG = LoginActivity.class.getName();
	public static String mAppid= "222222";
	public static QQAuth mQQAuth;
	private UserInfo mInfo;
	private Tencent mTencent;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		x.view().inject(this);
		model = new UserModel();
		llQQLogin.setOnClickListener(this);
		llWeiXin.setOnClickListener(this);
		llXinLang.setOnClickListener(this);
		tvRegister.setOnClickListener(this);

		btnLogin.setOnClickListener(this);
		ivLoginReturn.setOnClickListener(this);

	}

	@Override
	protected void onStart() {
		super.onStart();
		mQQAuth = QQAuth.createInstance(mAppid, getApplicationContext());
		mTencent = Tencent.createInstance(mAppid, getApplicationContext());
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.qq_login:
			onClickLogin();
			break;
		case R.id.weixin_login:
			Toast.makeText(LoginActivity.this, "（づ￣3￣）づ╭❤～，微信以跪，请注册使用哦", Toast.LENGTH_SHORT).show();
			break;
		case R.id.xinlang_login:
			Toast.makeText(LoginActivity.this, "（づ￣3￣）づ╭❤～，新浪以跪，请注册使用哦", Toast.LENGTH_SHORT).show();
			break;
		case R.id.tv_register:
			Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
			startActivity(intent);
			break;
		case R.id.ib_login:
			String loginemail = etEmail.getText().toString();
			String password = etPassword.getText().toString();
			if (loginemail.equals("") || password.equals("")) {
				Toast.makeText(getApplicationContext(), "请输入用户名和密码", Toast.LENGTH_SHORT).show();
			}
			model.login(loginemail, password, new QuWenCallBack() {

				@Override
				public void onError(Object error) {

				}

				@Override
				public void loaderQuWen(Object object) {
					setResult(RESULT_OK);
					finish();
				}
			});
			break;
		case R.id.iv_login_top_return:
			finish();
			break;
		}

	}

	private void onClickLogin() {
		if (!mQQAuth.isSessionValid()) {
			IUiListener listener = new BaseUiListener() {
				@Override
				protected void doComplete(JSONObject values) {
					updateUserInfo();
				}
			};
			mQQAuth.login(this, "all", listener);
			// mTencent.loginWithOEM(this, "all",
			// listener,"10000144","10000144","xxxx");
			mTencent.login(this, "all", listener);
		} else {
			mQQAuth.logout(this);
			updateUserInfo();
		}
	}

	private class BaseUiListener implements IUiListener {

		@Override
		public void onComplete(Object response) {
			Log.i("TAG", response.toString());
			doComplete((JSONObject) response);
		}

		protected void doComplete(JSONObject values) {

		}

		@Override
		public void onError(UiError e) {
		}

		@Override
		public void onCancel() {
		}
	}

	private void updateUserInfo() {
		if (mQQAuth != null && mQQAuth.isSessionValid()) {
			IUiListener listener = new IUiListener() {

				@Override
				public void onError(UiError e) {
					Toast.makeText(getApplicationContext(), "登录失败", Toast.LENGTH_SHORT).show();
				}

				@Override
				public void onComplete(final Object response) {
					Message msg = new Message();
					msg.obj = response;
					msg.what = 0;
					mHandler.sendMessage(msg);
				}

				@Override
				public void onCancel() {
				}
			};
			mInfo = new UserInfo(this, mQQAuth.getQQToken());
			mInfo.getUserInfo(listener);

		} else {
		}
	}

	Handler mHandler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			if (msg.what == 0) {
				JSONObject response = (JSONObject) msg.obj;
				if (response.has("nickname")) {
					try {

						PocketApp.user.setNickname(response.getString("nickname"));
						startActivity(new Intent(LoginActivity.this, PocketMainActivity.class));
						finish();
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} else if (msg.what == 1) {
				Bitmap bitmap = (Bitmap) msg.obj;
				PocketApp.user.setIcon(bitmap);
				startActivity(new Intent(LoginActivity.this, PocketMainActivity.class));
				finish();
			}
		}

	};

}
