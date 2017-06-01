package cn.edu.nju.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import cn.edu.nju.entity.CommentEntity;

public interface CommentRepository  extends PagingAndSortingRepository<CommentEntity, Integer>{

}
