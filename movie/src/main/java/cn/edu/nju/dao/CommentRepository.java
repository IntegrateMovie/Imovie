package cn.edu.nju.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import cn.edu.nju.entity.CommentEntity;

public interface CommentRepository  extends PagingAndSortingRepository<CommentEntity, Integer>{
	
	List<CommentEntity> findByNameAndResource(String movie_name,String resource);

}
