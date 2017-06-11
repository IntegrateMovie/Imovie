package cn.edu.nju.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import cn.edu.nju.entity.BillEntity;
import cn.edu.nju.entity.HotelEntity;

public interface UserbillRepository extends CrudRepository<BillEntity, Integer> {
	
	 List<BillEntity> findByHotelId(int HotelID);

}
