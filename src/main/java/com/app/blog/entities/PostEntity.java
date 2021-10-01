package com.app.blog.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "posts")
public class PostEntity {
	
	@Id
	@SequenceGenerator(
			name = "id_post_sequence",
			sequenceName = "id_post_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "id_post_sequence"
	)
	private Long id;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false , columnDefinition = "TEXT")
	private String article;
	
	@Column(nullable = false)
	private String author;
	
	@Column(nullable = false)
	private String imgArticle;

	public PostEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PostEntity(Long id, String title, String article, String author, String imgArticle) {
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
