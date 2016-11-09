package com.ark.pocket.read.entity.cm;

import java.util.List;

public class CMShowapi_res_body {
	private int ret_code;

	private CMPagebean pagebean;

	private List<MiYuLeiXing> typeList;

	public int getRet_code() {
		return ret_code;
	}

	public void setRet_code(int ret_code) {
		this.ret_code = ret_code;
	}

	public CMPagebean getPagebean() {
		return pagebean;
	}

	public void setPagebean(CMPagebean pagebean) {
		this.pagebean = pagebean;
	}

	public List<MiYuLeiXing> getTypeList() {
		return typeList;
	}

	public void setTypeList(List<MiYuLeiXing> typeList) {
		this.typeList = typeList;
	}

}
