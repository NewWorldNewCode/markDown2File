package com.markdown.entity;

public class Markdown {
	private String id;
	
	private String content;

	public Markdown() {
	      super();
	}
	public Markdown(String id, String content) {
		 super();// TODO Auto-generated constructor stub
		 this.id=id;
		 this.content=content;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
