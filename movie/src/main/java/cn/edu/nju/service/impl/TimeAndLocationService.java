package cn.edu.nju.service.impl;

import java.util.List;

import cn.edu.nju.model.Cinema;
import cn.edu.nju.model.TimeAndLocation;

public interface TimeAndLocationService {
	
	List<TimeAndLocation> timeAndLocationLits(String movie_name, int cinema_id);
	
	Cinema cinemaInfo(int cinema_id);
	
	

}
