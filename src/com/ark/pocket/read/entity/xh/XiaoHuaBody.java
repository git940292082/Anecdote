package com.ark.pocket.read.entity.xh;

import java.util.List;

public class XiaoHuaBody {
	private int allPages;
	private int ret_code;
	private List<WenBen> contentlist;
	private int currentPage;
	private int allNum;
	private int maxResult;

	public XiaoHuaBody() {
		super();
	}

	public XiaoHuaBody(int allPages, int ret_code, List<WenBen> contentlist, int currentPage, int allNum,
			int maxResult) {
		super();
		this.allPages = allPages;
		this.ret_code = ret_code;
		this.contentlist = contentlist;
		this.currentPage = currentPage;
		this.allNum = allNum;
		this.maxResult = maxResult;
	}

	public int getAllPages() {
		return allPages;
	}

	public void setAllPages(int allPages) {
		this.allPages = allPages;
	}

	public int getRet_code() {
		return ret_code;
	}

	public void setRet_code(int ret_code) {
		this.ret_code = ret_code;
	}

	public List<WenBen> getContentlist() {
		return contentlist;
	}

	public void setContentlist(List<WenBen> contentlist) {
		this.contentlist = contentlist;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getAllNum() {
		return allNum;
	}

	public void setAllNum(int allNum) {
		this.allNum = allNum;
	}

	public int getMaxResult() {
		return maxResult;
	}

	public void setMaxResult(int maxResult) {
		this.maxResult = maxResult;
	}

}
