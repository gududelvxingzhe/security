package com.jettech.ElasticSearch.bean;

import io.searchbox.annotations.JestId;

public class Article {

	@JestId
	private int id;
	private String author;
	private String title;
	private String content;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Article(int id, String author, String title, String content) {
		super();
		this.id = id;
		this.author = author;
		this.title = title;
		this.content = content;
	}
	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Article [id=" + id + ", author=" + author + ", title=" + title + ", content=" + content + "]";
	}
	
	
}
