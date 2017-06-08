package cn.edu.nju.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import cn.edu.nju.entity.CinemaEntity;

public interface CinemaRepository extends CrudRepository<CinemaEntity, Integer>  {
   CinemaEntity findById(int id);
}
