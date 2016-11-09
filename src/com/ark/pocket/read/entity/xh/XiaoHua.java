package com.ark.pocket.read.entity.xh;

public class XiaoHua {
	private int showapi_res_code;
	private String showapi_res_error;
	private XiaoHuaBody showapi_res_body;

	public XiaoHua() {
		super();
	}

	public XiaoHua(int showapi_res_code, String showapi_res_error, XiaoHuaBody showapi_res_body) {
		super();
		this.showapi_res_code = showapi_res_code;
		this.showapi_res_error = showapi_res_error;
		this.showapi_res_body = showapi_res_body;
	}

	public int getShowapi_res_code() {
		return showapi_res_code;
	}

	public void setShowapi_res_code(int showapi_res_code) {
		this.showapi_res_code = showapi_res_code;
	}

	public String getShowapi_res_error() {
		return showapi_res_error;
	}

	public void setShowapi_res_error(String showapi_res_error) {
		this.showapi_res_error = showapi_res_error;
	}

	public XiaoHuaBody getShowapi_res_body() {
		return showapi_res_body;
	}

	public void setShowapi_res_body(XiaoHuaBody showapi_res_body) {
		this.showapi_res_body = showapi_res_body;
	}

}
