package com.ark.pocket.read.entity.cm;

import java.util.List;

public class CMPagebean {
	private int allPages;

	private List<CMContentlist> contentlist;

	private int currentPage;

	private int allNum;

	private int maxResult;

	public int getAllPages() {
		return allPages;
	}

	public void setAllPages(int allPages) {
		this.allPages = allPages;
	}

	public List<CMContentlist> getContentlist() {
		return contentlist;
	}

	public void setContentlist(List<CMContentlist> contentlist) {
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
