package cn.edu.nju.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import cn.edu.nju.entity.TimeandLocationEntity;

public interface TimeandLocationRepository  extends PagingAndSortingRepository<TimeandLocationEntity, Integer>{

}
