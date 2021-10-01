package com.app.blog.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.blog.Dto.PostDto;
import com.app.blog.requests.PostRequest;
import com.app.blog.responses.PostResponse;
import com.app.blog.services.PostService;

@RestController
@RequestMapping("/api/v1/")
public class PostController {
	
	
	@Autowired
	private PostService postService;
	
	@GetMapping(
			path = "/posts/{id}",
			produces = {MediaType.APPLICATION_XML_VALUE , MediaType.APPLICATION_JSON_VALUE}
			) // id post
	public ResponseEntity<PostResponse> getPost(@PathVariable Long id) {
		return new ResponseEntity<PostResponse>(postService.getPost(id), HttpStatus.OK);
	}

	@GetMapping(path = "/posts", produces = {MediaType.APPLICATION_XML_VALUE , MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<PostResponse>> getPosts()  {
		return new ResponseEntity<List<PostResponse>>(postService.getPosts(), HttpStatus.OK);
	}
	
	@PostMapping(path = "/posts" , consumes = {MediaType.APPLICATION_XML_VALUE , MediaType.APPLICATION_JSON_VALUE} , produces = {MediaType.APPLICATION_XML_VALUE , MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> addPost(@RequestBody PostRequest postRequest , Principal principal) {
		
		// get the current user email to filter if are admin or not
		String email = principal.getName();
		
		PostDto postDto = new PostDto();
		BeanUtils.copyProperties(postRequest, postDto);
		
		String response = postService.addNewPost(postDto , email);
		
		return new ResponseEntity<String>(response, HttpStatus.CREATED);
	}
	
	@PutMapping(path = "posts/{id}", consumes = {MediaType.APPLICATION_XML_VALUE , MediaType.APPLICATION_JSON_VALUE} , produces = {MediaType.APPLICATION_XML_VALUE , MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> updatePost(@PathVariable Long id , @RequestBody PostRequest postRequest , Principal principal) {
		
		String email = principal.getName();
		
		PostDto postDto = new PostDto();
		BeanUtils.copyProperties(postRequest, postDto);
		
		String response = postService.updatePost(id, postDto , email);
		
		return new ResponseEntity<String>(response, HttpStatus.ACCEPTED);
		
	}
	
	
	@DeleteMapping(path = "posts/{id}")
	public ResponseEntity<String> deletePost(@PathVariable Long id , Principal principal) {
		
		String email = principal.getName();
		
		String response = postService.deletePost(id, email);
		
		return new ResponseEntity<String>(response, HttpStatus.NO_CONTENT);
	}
	
	
}
