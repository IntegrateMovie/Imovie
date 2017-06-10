package cn.edu.nju.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.nju.dao.CommentRepository;
import cn.edu.nju.entity.CommentEntity;
import cn.edu.nju.model.Comment;
@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
    private  CommentRepository  commentRepository;

	@Override
	public List<Comment> getComment(String movie_name) {
		List<CommentEntity> comments = new ArrayList<>();
		 comments = commentRepository.findByNameAndResource(movie_name);
		List<Comment> commentList = new ArrayList<Comment>();
		for(CommentEntity e:comments){
			Comment comment = new Comment();
			comment.setMovie_name(e.getMovie_name());//电影名称
			comment.setPlatform(e.getResource());//平台
			comment.setGrade(e.getGrade()+"");//评分
			comment.setContent(e.getComment());//内容
			comment.setTime(e.getTime());//时间
			commentList.add(comment);			
		}		 
		return commentList;
	}
	
	

}
