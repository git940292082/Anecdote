package com.ark.pocket.read.entity.xh;

import java.util.List;

import com.ark.pocket.read.entity.ggs.GuiGuShiList;

public class Pagebean {
	private String allPages;

	private List<GuiGuShiList> contentlist;

	private int currentPage;

	private String maxResult;

	public void setAllPages(String allPages) {
		this.allPages = allPages;
	}

	public String getAllPages() {
		return this.allPages;
	}

	public void setContentlist(List<GuiGuShiList> contentlist) {
		this.contentlist = contentlist;
	}

	public List<GuiGuShiList> getContentlist() {
		return this.contentlist;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getCurrentPage() {
		return this.currentPage;
	}

	public void setMaxResult(String maxResult) {
		this.maxResult = maxResult;
	}

	public String getMaxResult() {
		return this.maxResult;
	}
}
