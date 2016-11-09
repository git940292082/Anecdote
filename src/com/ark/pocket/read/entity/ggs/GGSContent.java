package com.ark.pocket.read.entity.ggs;

public class GGSContent {

	private int allPages;

	private String text;

	private int ret_code;

	private String currentPage;

	public void setAllPages(int allPages) {
		this.allPages = allPages;
	}

	public int getAllPages() {
		return this.allPages;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getText() {
		return this.text;
	}

	public void setRet_code(int ret_code) {
		this.ret_code = ret_code;
	}

	public int getRet_code() {
		return this.ret_code;
	}

	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}

	public String getCurrentPage() {
		return this.currentPage;
	}

	@Override
	public String toString() {
		return "GGSContent [allPages=" + allPages + ", text=" + text + ", ret_code=" + ret_code + ", currentPage="
				+ currentPage + "]";
	}

}
