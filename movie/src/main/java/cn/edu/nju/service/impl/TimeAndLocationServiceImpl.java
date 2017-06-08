package cn.edu.nju.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.nju.dao.CinemaRepository;
import cn.edu.nju.dao.TimeandLocationRepository;
import cn.edu.nju.entity.CinemaEntity;
import cn.edu.nju.entity.TimeandLocationEntity;
import cn.edu.nju.model.Cinema;
import cn.edu.nju.model.TimeAndLocation;

public class TimeAndLocationServiceImpl implements TimeAndLocationService {
	@Autowired
	private TimeandLocationRepository timeandLocationRepository; 
	@Autowired
    private CinemaRepository cinemaRepository;
	@Override
	public List<TimeAndLocation> timeAndLocationLits(String movie_name, int cinema_id) {
		List<TimeandLocationEntity> entityList = timeandLocationRepository.findByMovieAndCinema_id(movie_name, cinema_id);
		List<TimeAndLocation> result = new ArrayList<TimeAndLocation>();
		for(TimeandLocationEntity e: entityList){
			TimeAndLocation t = new TimeAndLocation();
			t.setHall(e.getHall());
		    t.setPlatform(e.getResource());
		    t.setPrice(e.getPrice()+"");
		    t.setTime(e.getTime());
		    t.setRemain_seat(e.getRemain_seat()+"");	
		    t.setLocation(cinemaInfo(cinema_id).getLocation());
		    t.setCinema_name(cinemaInfo(cinema_id).getName());
		}
		return result;
	}
	
	@Override
	public Cinema cinemaInfo(int cinema_id) {
		//查询电影院信息
		CinemaEntity e =   cinemaRepository.findOne(cinema_id);
		Cinema c = new Cinema();
		c.setName(e.getName());
		c.setLocation(e.getAddress());		
		return c;
	}

}
