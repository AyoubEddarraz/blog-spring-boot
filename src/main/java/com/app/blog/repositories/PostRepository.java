package com.app.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.blog.entities.PostEntity;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {

}
