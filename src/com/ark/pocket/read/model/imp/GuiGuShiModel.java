package com.ark.pocket.read.model.imp;

import android.util.Log;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.ark.pocket.read.app.PocketApp;
import com.ark.pocket.read.entity.ggs.GGSContentRoot;
import com.ark.pocket.read.entity.ggs.GuiGuShiRoot;
import com.ark.pocket.read.entity.xh.XiaoHua;
import com.ark.pocket.read.model.IGuiGuShiModel;
import com.ark.pocket.read.model.IXiaoHuaModel;
import com.ark.pocket.read.utils.QuWenCallBack;
import com.google.gson.Gson;

public class GuiGuShiModel implements IGuiGuShiModel {

	@Override
	public void getGuiGuShiXiaoYuan(String name,int page, final QuWenCallBack qwCallBack) {
		String url = "https://route.showapi.com/955-1?page="
				+ page
				+ "&showapi_appid=25054&showapi_timestamp=20161009202958&type="+name+"&showapi_sign=5c93c3ab7ea17a09e5d1f90b97328d7f";
		StringRequest request = new StringRequest(url, new Listener<String>() {

			@Override
			public void onResponse(String response) {
				Gson gson = new Gson();
				GuiGuShiRoot ggs = gson.fromJson(response, GuiGuShiRoot.class);
				qwCallBack.loaderQuWen(ggs);
			}
		}, new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {

			}
		});
		PocketApp.getmQueue().add(request);
	}

	@Override
	public void getGuiGuShiXiaoYuan(int page, String id, final QuWenCallBack qwCallBack) {
		String url = "https://route.showapi.com/955-2?id=" + id + "&page=" + page
				+ "&showapi_appid=25054&showapi_timestamp=20161012104440&showapi_sign=0dcf2520d7da3e013917ef3d53666178";
		StringRequest request = new StringRequest(url, new Listener<String>() {

			@Override
			public void onResponse(String response) {
				Gson gson = new Gson();
				GGSContentRoot ggs = gson.fromJson(response, GGSContentRoot.class);
				qwCallBack.loaderQuWen(ggs);
			}
		}, new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {

			}
		});
		PocketApp.getmQueue().add(request);
	}

}
