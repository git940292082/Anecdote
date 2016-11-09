package com.ark.pocket.read.app;

import org.xutils.x;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.ark.pocket.read.entity.user.User;

import android.app.Application;
import android.content.Context;

public class PocketApp extends Application {
	public static Context context;
	private static RequestQueue mQueue;
	User parseUser;
	public static User user = new User();

	@Override
	public void onCreate() {
		context = getApplicationContext();
		x.Ext.init(this);
		super.onCreate();

		this.mQueue = Volley.newRequestQueue(getApplicationContext());

	}

	public static RequestQueue getmQueue() {
		return mQueue;
	}

	public void saveCurrentUser(User parseUser) {
		this.parseUser = parseUser;
	}

	public User getCurrentUser() {
		return this.parseUser;
	}
}
