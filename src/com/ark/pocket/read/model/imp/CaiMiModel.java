package com.ark.pocket.read.model.imp;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.ark.pocket.read.app.PocketApp;
import com.ark.pocket.read.entity.cm.CMContentlist;
import com.ark.pocket.read.entity.cm.CMRoot;
import com.ark.pocket.read.model.ICaiMiModel;
import com.ark.pocket.read.utils.QuWenCallBack;
import com.google.gson.Gson;

import android.util.Log;

public class CaiMiModel implements ICaiMiModel {

	@Override
	public void getRandomCaiMiXiaoYuan(final QuWenCallBack qwCallBack) {
		String url = "https://route.showapi.com/151-2?showapi_appid=25054&showapi_timestamp=20161019201418&showapi_sign=089ed6c1d44fe1ad7d4928ba21a2094e";
		StringRequest request = new StringRequest(url, new Listener<String>() {

			@Override
			public void onResponse(String response) {
				Gson gson = new Gson();
				CMRoot cmRoot = gson.fromJson(response, CMRoot.class);
				qwCallBack.loaderQuWen(cmRoot);
			}
		}, new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {

			}
		});
		PocketApp.getmQueue().add(request);
	}

	@Override
	public void getMiYuLeiXing(final QuWenCallBack qwCallBack) {
		String url = "https://route.showapi.com/151-3?showapi_appid=25054&showapi_timestamp=20161027210124&showapi_sign=31d1aa328fb62c32cfa734ea2ecb3848";
		StringRequest request = new StringRequest(url, new Listener<String>() {

			@Override
			public void onResponse(String response) {
				Gson gson = new Gson();
				CMRoot cmRoot = gson.fromJson(response, CMRoot.class);
				qwCallBack.loaderQuWen(cmRoot);
			}
		}, new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {

			}
		});
		PocketApp.getmQueue().add(request);
	}

}
