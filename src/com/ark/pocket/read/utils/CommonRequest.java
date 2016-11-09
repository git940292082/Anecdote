package com.ark.pocket.read.utils;
import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Created by hanamingming on 16/2/28.
 */
public class CommonRequest extends StringRequest {

	public static String JSESSIONID = null;

	public CommonRequest(int method, String url, Response.Listener<String> listener,
			Response.ErrorListener errorListener) {
		super(method, url, listener, errorListener);
	}

	public CommonRequest(String url, Response.Listener<String> listener, Response.ErrorListener errorListener) {
		super(url, listener, errorListener);
	}

	@Override
	protected Response<String> parseNetworkResponse(NetworkResponse response) {
		Map<String, String> headers = response.headers;
		String sessionid = headers.get("Set-Cookie");
		if (sessionid != null) {
			JSESSIONID = sessionid.split(";")[0];
		}
		String parsed;
		try {
			parsed = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
		} catch (UnsupportedEncodingException e) {
			parsed = new String(response.data);
		}
		return Response.success(parsed, HttpHeaderParser.parseCacheHeaders(response));
	}
}
