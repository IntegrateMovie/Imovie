package cn.edu.nju.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import cn.edu.nju.entity.CommentEntity;

public interface CommentRepository  extends PagingAndSortingRepository<CommentEntity, Integer>{
	
	@Query("select a from CommentEntity a where a.movie_name = ?1")
	List<CommentEntity> findByNameAndResource(String movie_name);

}
