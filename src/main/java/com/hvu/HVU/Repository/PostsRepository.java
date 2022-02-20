package com.hvu.HVU.Repository;

import com.hvu.HVU.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {
}
