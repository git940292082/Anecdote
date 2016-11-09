package com.ark.pocket.read.entity.ggs;

import java.io.Serializable;

public class GuiGuShiList implements Serializable {

	private String id;

	private String title;

	private String desc;

	private String link;

	private String img;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getDesc() {
		return this.desc;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getLink() {
		return this.link;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getImg() {
		return this.img;
	}

	@Override
	public String toString() {
		return "GuiGuShiList [id=" + id + ", title=" + title + ", desc=" + desc + ", link=" + link + ", img=" + img
				+ "]";
	}

}
