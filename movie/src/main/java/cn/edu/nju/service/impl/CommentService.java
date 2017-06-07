package cn.edu.nju.service.impl;

import java.util.List;

public interface CommentService<CommentEntity> {
	/**
	 * 分电影名称和平台获得评论
	 * @param movie_name
	 * @param Platform
	 * @return
	 */
	List<CommentEntity> getComment(String movie_name, String Platform);
}
