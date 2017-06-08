package cn.edu.nju.service.impl;

import java.util.List;

import cn.edu.nju.model.MovieInfo;

public interface MovieInfoService {
	
	/**
	 * 获得所有电影的信息（电影名，评分，各个平台最低价）
	 * @param platform1
	 * @param platform2
	 * @param platform3
	 * @return
	 */
	List<MovieInfo>  movieGeneralList(String platform1,String platform2,String platform3);

}
