package cn.edu.nju.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import cn.edu.nju.entity.TimeandLocationEntity;

public interface TimeandLocationRepository  extends CrudRepository<TimeandLocationEntity, Integer>{
	
	
	@Query("select a from TimeandLocationEntity a where a.movie_name = ?1 and a.resource = ?2 ")
      List<TimeandLocationEntity> findByMovieAndResource(String movie, String resource);
      
	@Query("select a from TimeandLocationEntity a where a.movie_name = ?1 and a.cinema_id = ?2")
      List<TimeandLocationEntity> findByMovieAndCinema_id(String movie,int cinema_id);
}
