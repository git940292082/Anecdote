package com.ark.pocket.read.activity;

import org.xutils.x;
import org.xutils.image.ImageOptions;
import org.xutils.view.annotation.ViewInject;

import com.ark.pocket.read.R;
import com.ark.pocket.read.entity.user.User;
import com.ark.pocket.read.model.IUserModel;
import com.ark.pocket.read.model.imp.UserModel;
import com.ark.pocket.read.utils.QuWenCallBack;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class RegisterActivity extends Activity implements OnClickListener {
	@ViewInject(R.id.et_register_email)
	private EditText etEmail;
	@ViewInject(R.id.et_register_password)
	private EditText etPassword;
	@ViewInject(R.id.et_register_name)
	private EditText etName;
	@ViewInject(R.id.et_register_code)
	private EditText etCode;
	@ViewInject(R.id.iv_register_top_return)
	private ImageView ivReturn;
	@ViewInject(R.id.iv_register_code)
	private ImageView ivCode;
	@ViewInject(R.id.ib_register)
	private Button btnRegist;

	IUserModel model;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		x.view().inject(this);
		model = new UserModel();
		btnRegist.setOnClickListener(this);
		ivCode.setOnClickListener(this);
		ivReturn.setOnClickListener(this);
		setCode();

	}

	private void setCode() {
		model.imagecode(new QuWenCallBack() {

			@Override
			public void onError(Object error) {

			}

			@Override
			public void loaderQuWen(Object object) {
				Bitmap bitmap = (Bitmap) object;
				if (bitmap != null) {
					ivCode.setImageBitmap(bitmap);
				}
			}
		});
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.ib_register:
			User user = new User();
			user.setEmail(etEmail.getText().toString());
			user.setPassword(etPassword.getText().toString());
			user.setNickname(etName.getText().toString());
			String code = etCode.getText().toString();
			model.register(user, code, new QuWenCallBack() {
				@Override
				public void onError(Object error) {
				}
				@Override
				public void loaderQuWen(Object object) {
					if (object==null) {
						Toast.makeText(getApplicationContext(), "◊¢≤· ß∞‹£¨«Î…‘∫Û‘Ÿ ‘", Toast.LENGTH_LONG).show();
					}else{
					finish();
					}
				}
			});
			break;
		case R.id.iv_register_code:
			setCode();
			break;
		case R.id.iv_register_top_return:
			onBackPressed();
			break;

		}

	}
	@Override
	public void onBackPressed() {
		super.onBackPressed();
	}

}
