package cn.edu.nju.service;

import java.util.List;

import cn.edu.nju.entity.BillEntity;
import cn.edu.nju.vo.RfmAnalysis;

public interface UserbillService {
	
	List<RfmAnalysis> rfm(int HotelID, int day,int frequency,int money);

}
