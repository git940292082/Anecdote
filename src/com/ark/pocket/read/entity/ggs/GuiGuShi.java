package com.ark.pocket.read.entity.ggs;

import com.ark.pocket.read.entity.xh.Pagebean;

public class GuiGuShi {
	private int ret_code;

	private Pagebean pagebean;

	public void setRet_code(int ret_code) {
		this.ret_code = ret_code;
	}

	public int getRet_code() {
		return this.ret_code;
	}

	public void setPagebean(Pagebean pagebean) {
		this.pagebean = pagebean;
	}

	public Pagebean getPagebean() {
		return this.pagebean;
	}
}
