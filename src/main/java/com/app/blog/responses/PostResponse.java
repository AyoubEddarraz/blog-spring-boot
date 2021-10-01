package com.app.blog.responses;

public class PostResponse {
	
	private Long id;
	private String title;
	private String article;
	private String author;
	private String imgArticle;
	
	public PostResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PostResponse(Long id, String title, String article, String author, String imgArticle) {
		super();
		this.id = id;
		this.title = title;
		this.article = article;
		this.author = author;
		this.imgArticle = imgArticle;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
