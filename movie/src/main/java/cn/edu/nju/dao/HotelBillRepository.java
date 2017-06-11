package cn.edu.nju.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import cn.edu.nju.entity.HotelmanagementEntity;
import cn.edu.nju.entity.SettlementEntity;

public interface HotelBillRepository extends PagingAndSortingRepository<HotelmanagementEntity, Integer> {

}
