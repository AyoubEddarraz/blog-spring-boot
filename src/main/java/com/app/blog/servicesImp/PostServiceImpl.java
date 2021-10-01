package com.app.blog.servicesImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.blog.Dto.PostDto;
import com.app.blog.entities.PostEntity;
import com.app.blog.entities.UserEntity;
import com.app.blog.repositories.PostRepository;
import com.app.blog.repositories.UserRepository;
import com.app.blog.responses.PostResponse;
import com.app.blog.services.PostService;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public PostResponse getPost(Long id) {
		
		PostEntity post = postRepository.getById(id);
		
		PostResponse postResponse = new PostResponse();
		BeanUtils.copyProperties(post, postResponse);
		
		return postResponse;
	}
	
	@Override
	public List<PostResponse> getPosts() {
		
		List<PostResponse> posts = new ArrayList<PostResponse>();
		List<PostEntity> postsEntity = postRepository.findAll();
		
		for (PostEntity postEntity : postsEntity) {
			PostResponse postResponse = new PostResponse();
			BeanUtils.copyProperties(postEntity, postResponse);
			posts.add(postResponse);
		}
		
		return posts;

	}

	@Override
	public String addNewPost(PostDto postDto , String email) {
		
		UserEntity currentUser = userRepository.findByEmail(email);
		
		if(currentUser.getAdmin()){
			PostEntity postEntity = new PostEntity();
			BeanUtils.copyProperties(postDto, postEntity);
			
			postRepository.save(postEntity);
			
			return "post added with Success.";
			
		}
		
		return "You do not have the authority to do this.";
		
	}

	@Override
	public String updatePost(Long id, PostDto postDto , String email) {
		
		UserEntity currentUser = userRepository.findByEmail(email);
		
		if(currentUser.getAdmin()) {
			PostEntity postFounded = postRepository.getById(id);
			BeanUtils.copyProperties(postDto, postFounded);
			postFounded.setId(id);
			
			postRepository.save(postFounded);
			
			return "post updated with Success.";
			
		}
		
		return "You do not have the authority to do this.";
		
	}

	@Override
	public String deletePost(Long id , String email) {
		
		UserEntity currentUser = userRepository.findByEmail(email);
		
		if(currentUser.getAdmin()) {
			PostEntity postFounded = postRepository.getById(id);
			postRepository.delete(postFounded);
			
			return "post removed with Success.";
			
		}
		
		return "You do not have the authority to do this.";
		
	}


}
