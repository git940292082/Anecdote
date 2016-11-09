package com.ark.pocket.read.entity.xh;

import java.io.Serializable;

public class WenBen implements Serializable {
	private String id;
	private String title;
	private String text;
	private int type;
	private String ct;
	private String img;

	public WenBen() {
		super();
	}

	public WenBen(String id, String title, String text, int type, String ct, String img) {
		super();
		this.id = id;
		this.title = title;
		this.text = text;
		this.type = type;
		this.ct = ct;
		this.img = img;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getCt() {
		return ct;
	}

	public void setCt(String ct) {
		this.ct = ct;
	}

	@Override
	public String toString() {
		return "WenBen [id=" + id + ", title=" + title + ", text=" + text + ", type=" + type + ", ct=" + ct + ", img="
				+ img + "]";
	}

}
