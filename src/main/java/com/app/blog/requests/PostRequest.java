package com.app.blog.requests;

public class PostRequest {
	
	private String title;
	private String article;
	private String author;
	private String imgArticle;
			
	public PostRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PostRequest(String title, String article, String author, String imgArticle) {
		super();
		this.title = title;
		this.article = article;
		this.author = author;
		this.imgArticle = imgArticle;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getImgArticle() {
		return imgArticle;
	}

	public void setImgArticle(String imgArticle) {
		this.imgArticle = imgArticle;
	}

}
