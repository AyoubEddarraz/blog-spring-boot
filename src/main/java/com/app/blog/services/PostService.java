package com.app.blog.services;

import java.util.List;

import com.app.blog.Dto.PostDto;
import com.app.blog.responses.PostResponse;

public interface PostService {
	
	// get post by id
	PostResponse getPost(Long id);
	
	// Get all posts
	List<PostResponse> getPosts();
	
	// add new post
	String addNewPost(PostDto postDto , String email);
	
	// update post
	String updatePost(Long id, PostDto postDto , String email);
	
	// delete post
	String deletePost(Long id , String email);

}
