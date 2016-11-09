package com.ark.pocket.read.entity.cm;

public class CMContentlist {
	private String typeName;

	private String Answer;

	private String typeId;

	private String Title;

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public void setAnswer(String Answer) {
		this.Answer = Answer;
	}

	public String getAnswer() {
		return this.Answer;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getTypeId() {
		return this.typeId;
	}

	public void setTitle(String Title) {
		this.Title = Title;
	}

	public String getTitle() {
		return this.Title;
	}

	@Override
	public String toString() {
		return "CMContentlist [typeName=" + typeName + ", Answer=" + Answer + ", typeId=" + typeId + ", Title=" + Title
				+ "]";
	}

}
