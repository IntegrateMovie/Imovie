package cn.edu.nju.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import cn.edu.nju.entity.MovieEntity;

public interface MovieInfoRepository extends CrudRepository<MovieEntity, Integer>  {
	@Query("select a from MovieEntity a")
	List<MovieEntity> findAll();
}
