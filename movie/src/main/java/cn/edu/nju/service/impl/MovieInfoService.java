package cn.edu.nju.service.impl;

import java.util.List;

import cn.edu.nju.model.MovieInfo;

public interface MovieInfoService {
	
	List<MovieInfo>  movieGeneralList(String platform1,String platform2,String platform3);

}
