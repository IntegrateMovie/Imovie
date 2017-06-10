package cn.edu.nju.service.impl;

import java.sql.Timestamp;
import java.util.List;

import cn.edu.nju.model.Cinema;
import cn.edu.nju.model.CinemaAndPrice;
import cn.edu.nju.model.TimeAndLocation;
import cn.edu.nju.util.MySQL5DialectUTF8;

public interface  TimeAndLocationService {
	/**
	 * 电影的具体场次信息（电影院，电影院地址（如果在前一页显示了在具体场次信息可以不显示），放映厅，时间，余座，平台，票价）
	 * @param movie_name
	 * @param cinema_id
	 * @return
	 */
	List<TimeAndLocation> timeAndLocationLits(String movie_name, int cinema_id);
	
	
	/**
	 * 根据电影院id获得电影院信息（电影院名字，地址）
	 * @param cinema_id
	 * @return
	 */
	Cinema cinemaInfo(int cinema_id);
	/**
	 * 根据电影名获得电影在各家影院信息（电影院名、电影院地址，各平台在本电影院最低价）
	 * @param movie_name
	 * @return
	 */
	List<CinemaAndPrice> cinemaAndPriceInfo(String movie_name);

}
