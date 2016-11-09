package com.ark.pocket.read.model.imp;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.ark.pocket.read.app.PocketApp;
import com.ark.pocket.read.entity.xh.XiaoHua;
import com.ark.pocket.read.model.IXiaoHuaModel;
import com.ark.pocket.read.utils.QuWenCallBack;
import com.google.gson.Gson;

public class XiaoHuaModel implements IXiaoHuaModel {

	@Override
	public void getXiaoHuaWenBen(int page, final QuWenCallBack xhCallBack) {
		String url = "https://route.showapi.com/341-1?maxResult=50&page=" + page
				+ "&showapi_appid=25054&showapi_timestamp=20161007000235&time=2015-07-10&showapi_sign=950d431dc45da60a3b4f70fe9785692b";
		StringRequest request = new StringRequest(url, new Listener<String>() {

			@Override
			public void onResponse(String response) {
				Gson gson = new Gson();
				XiaoHua xiaoHua = gson.fromJson(response, XiaoHua.class);
				xhCallBack.loaderQuWen(xiaoHua);
			}
		}, new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {

			}
		});
		PocketApp.getmQueue().add(request);
	}

	@Override
	public void getXiaoHuaTuPian(int page, final QuWenCallBack xhCallBack) {
		String url = "https://route.showapi.com/341-2?maxResult=50&page=" + page
				+ "&showapi_appid=25054&showapi_timestamp=20161007165131&time=2015-07-10&showapi_sign=9255623b819b835d11297580d044f001";
		StringRequest request = new StringRequest(url, new Listener<String>() {

			@Override
			public void onResponse(String response) {
				Gson gson = new Gson();
				XiaoHua xiaoHua = gson.fromJson(response, XiaoHua.class);
				xhCallBack.loaderQuWen(xiaoHua);
			}
		}, new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {

			}
		});
		PocketApp.getmQueue().add(request);
	}

	@Override
	public void getXiaoHuaDongTu(int page, final QuWenCallBack xhCallBack) {
		String url = "https://route.showapi.com/341-3?maxResult=20&page=" + page
				+ "&showapi_appid=25054&showapi_timestamp=20161007174502&showapi_sign=925c21f67fc3d0248e57b3c6e30d3465";

		StringRequest request = new StringRequest(url, new Listener<String>() {

			@Override
			public void onResponse(String response) {
				Gson gson = new Gson();
				XiaoHua xiaoHua = gson.fromJson(response, XiaoHua.class);
				xhCallBack.loaderQuWen(xiaoHua);
			}
		}, new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {

			}
		});
		PocketApp.getmQueue().add(request);
	}

}
