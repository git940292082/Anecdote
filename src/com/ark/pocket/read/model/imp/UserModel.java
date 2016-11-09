package com.ark.pocket.read.model.imp;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import android.graphics.Bitmap;

import com.android.volley.Request.Method;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ark.pocket.read.app.PocketApp;
import com.ark.pocket.read.entity.user.User;
import com.ark.pocket.read.model.IUserModel;
import com.ark.pocket.read.utils.CommonRequest;
import com.ark.pocket.read.utils.JSONParser;
import com.ark.pocket.read.utils.QuWenCallBack;

public class UserModel implements IUserModel {
	RequestQueue queue;

	public UserModel() {
		queue = Volley.newRequestQueue(PocketApp.context);
	}

	@Override
	public void register(final User user, final String code, final QuWenCallBack callBack) {

		String url = "http://45.78.24.178:8080/dang/user/register.action";
		Listener<String> listener = new Listener<String>() {
			@Override
			public void onResponse(String response) {
				try {
					JSONObject object = new JSONObject(response);
					if (object.getInt("code") == 1001) {
						callBack.loaderQuWen(null);
					} else {
						callBack.onError(object.getString("error_msg"));
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}

			}
		};
		ErrorListener errorListener = new ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {

			}
		};
		CommonRequest request = new CommonRequest(Method.POST, url, listener, errorListener) {
			@Override
			protected Map<String, String> getParams() throws AuthFailureError {
				Map<String, String> map = new HashMap<String, String>();
				map.put("user.email", user.getEmail());
				map.put("user.nickname", user.getNickname());
				map.put("user.password", user.getPassword());
				map.put("number", code);
				return map;
			}
		};
		queue.add(request);
	}

	@Override
	public void imagecode(final QuWenCallBack callBack) {
		String uri = "http://45.78.24.178:8080/dang/user/getImage.action";
		ImageRequest request = new ImageRequest(uri, new Response.Listener<Bitmap>() {
			@Override
			public void onResponse(Bitmap response) {
				callBack.loaderQuWen(response);
			}
		}, 130, 50, Bitmap.Config.ARGB_8888, new Response.ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {

			}
		}) {
			@Override
			protected Response<Bitmap> parseNetworkResponse(NetworkResponse response) {
				Map<String, String> headers = response.headers;
				String sessionid = headers.get("Set-Cookie");
				if (sessionid != null) {
					CommonRequest.JSESSIONID = sessionid.split(";")[0];
				}
				return super.parseNetworkResponse(response);
			}
		};
		queue.add(request);
	}

	@Override
	public void login(final String loginemail, final String password, final QuWenCallBack callBack) {
		String url = "http://45.78.24.178:8080/dang/user/login.action";
		CommonRequest request = new CommonRequest(Method.POST, url, new Listener<String>() {
			@Override
			public void onResponse(String response) {
				try {
					JSONObject object = new JSONObject(response);
					if (object.getInt("code") == 1001) {
						JSONObject userobject = object.getJSONObject("user");
						PocketApp app = (PocketApp) PocketApp.context;
						app.saveCurrentUser(JSONParser.parseUser(userobject));
					} else {
						callBack.onError(object.getString("error_msg"));
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		}, new ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {
				callBack.onError("µÇÂ¼Ê§°Ü");
			}
		}) {
			@Override
			protected Map<String, String> getParams() throws AuthFailureError {
				Map<String, String> map = new HashMap<String, String>();
				map.put("email", loginemail);
				map.put("password", password);
				return map;
			}
		};
		queue.add(request);
	}

}
