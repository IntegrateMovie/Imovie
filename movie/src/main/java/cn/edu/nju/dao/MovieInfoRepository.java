package cn.edu.nju.dao;

import org.springframework.data.repository.CrudRepository;

import cn.edu.nju.entity.MovieEntity;

public interface MovieInfoRepository extends CrudRepository<MovieEntity, Integer>  {

}
