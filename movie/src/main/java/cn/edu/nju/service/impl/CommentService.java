package cn.edu.nju.service.impl;

import java.util.List;

import cn.edu.nju.model.Comment;

public interface CommentService {
	/**
	 * 分电影名称和平台获得评论
	 * @param movie_name
	 * @param Platform
	 * @return
	 */
	List<Comment> getComment(String movie_name);
}
