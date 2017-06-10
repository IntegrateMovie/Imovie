package cn.edu.nju.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.nju.dao.CinemaRepository;
import cn.edu.nju.dao.TimeandLocationRepository;
import cn.edu.nju.entity.CinemaEntity;
import cn.edu.nju.entity.TimeandLocationEntity;
import cn.edu.nju.model.Cinema;
import cn.edu.nju.model.CinemaAndPrice;
import cn.edu.nju.model.Price;
import cn.edu.nju.model.TimeAndLocation;
@Service
public class TimeAndLocationServiceImpl implements TimeAndLocationService {
	@Autowired
	private TimeandLocationRepository timeandLocationRepository; 
	@Autowired
    private CinemaRepository cinemaRepository;
	@Override
	public List<TimeAndLocation> timeAndLocationLits(String movie_name, int cinema_id) {
		List<TimeandLocationEntity> entityList = timeandLocationRepository.findByMovieAndCinema_id(movie_name, cinema_id);
		System.out.println("service  "+movie_name);
		System.out.println("cinema_id   "+cinema_id);
		System.out.println("service size"+entityList.size());
		List<TimeAndLocation> result = new ArrayList<TimeAndLocation>();
		List<Timestamp> timeList = new ArrayList<>();
		
		for(TimeandLocationEntity e: entityList){
			TimeAndLocation t = new TimeAndLocation();
			t.setHall(e.getHall());
		    t.setTime(e.getTime());
	        t.setPrice1(e.getPrice()+"元");
	        t.setPlatform(e.getResource());
		    t.setRemain_seat(e.getRemain_seat()+"");	
		    t.setLocation(cinemaInfo(cinema_id).getLocation());
		    t.setCinema_name(cinemaInfo(cinema_id).getName());
		    result.add(t);
		    
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

	@Override
	public List<CinemaAndPrice> cinemaAndPriceInfo(String movie_name) {
		List<TimeandLocationEntity> entityList = timeandLocationRepository.findByMovie_name(movie_name);
		ArrayList<Integer> cinema_ids  = new ArrayList<Integer>();
		ArrayList<String> resources  = new ArrayList<String>();
	   List<CinemaAndPrice> result = new ArrayList<>();
		for(TimeandLocationEntity timeandLocationEntity:entityList){
			if(!cinema_ids.contains(timeandLocationEntity.getCinema_id())){
			cinema_ids.add(timeandLocationEntity.getCinema_id());
			}
			
			if(!resources.contains(timeandLocationEntity.getResource())){
				resources.add(timeandLocationEntity.getResource());
			}
		}
		
	for(int i = 0;i<cinema_ids.size();i++){
		CinemaAndPrice cinemaAndPrice = new CinemaAndPrice();
		CinemaEntity e = new CinemaEntity();
		 e =   cinemaRepository.findOne(cinema_ids.get(i));
		cinemaAndPrice.setCinema_id(e.getId()+"");
		cinemaAndPrice.setCinema_name(e.getName());
		cinemaAndPrice.setCinema_address(e.getAddress());	
		List<Price> priceList = new ArrayList<>();
		//根据影院和电影和平台，找到最低价	
		for(String resource:resources){
			Price price = getlowest(movie_name,cinema_ids.get(i),resource);
			priceList.add(price);
		}
		cinemaAndPrice.setLowestPriceForEachPlatform(priceList);
		result.add(cinemaAndPrice);
	}
	
		return result;
	}
	
	private Price getlowest(String movie_name, int cinema_id, String resource){
		List<TimeandLocationEntity> entityList = timeandLocationRepository.findByMovie_nameAndCinema_idAndResource(movie_name, cinema_id, resource);
		Price price = new Price();
		price.setPlatform(resource);
		double lowestprice = 1000000;
		for(TimeandLocationEntity t:entityList){
			if(t.getPrice()<lowestprice){
				lowestprice = t.getPrice();
			}
			
		}
		if(lowestprice != 1000000)
		price.setPrice(lowestprice+"");
		else{
			price.setPrice("无出售");
		}
		
		return price;
	}

}
