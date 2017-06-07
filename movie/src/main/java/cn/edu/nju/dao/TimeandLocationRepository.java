package cn.edu.nju.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import cn.edu.nju.entity.TimeandLocationEntity;

public interface TimeandLocationRepository  extends PagingAndSortingRepository<TimeandLocationEntity, Integer>{
      List<TimeandLocationEntity> findByMovieAndResource(String movie, String resource);
}
