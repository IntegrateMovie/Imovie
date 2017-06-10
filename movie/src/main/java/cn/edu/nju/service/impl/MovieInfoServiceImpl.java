package cn.edu.nju.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.nju.dao.CommentRepository;
import cn.edu.nju.dao.MovieInfoRepository;
import cn.edu.nju.dao.TimeandLocationRepository;
import cn.edu.nju.entity.CommentEntity;
import cn.edu.nju.entity.MovieEntity;
import cn.edu.nju.entity.TimeandLocationEntity;
import cn.edu.nju.model.Mark;
import cn.edu.nju.model.MovieInfo;
import cn.edu.nju.model.Price;
import cn.edu.nju.util.platform;
@Service
public class MovieInfoServiceImpl implements MovieInfoService {
    @Autowired
	private MovieInfoRepository movieInfoRepository;
    @Autowired
    private TimeandLocationRepository timeandLocationRepository;
    @Autowired
    private  CommentRepository  commentRepository;
    
    public static void main(String[] args){
    	MovieInfoService service = new MovieInfoServiceImpl();
    	//service.movieGeneralList("taobao", platform2, platform3)
    }

	@Override
	public List<MovieInfo> movieGeneralList(String platform1, String platform2, String platform3) {
		System.out.println(movieInfoRepository.findAll().size());
    	List<MovieEntity> movieEntitys =  movieInfoRepository.findAll();
    	List<MovieInfo> infos = new ArrayList<MovieInfo>();
    	for(MovieEntity entity:movieEntitys){
    		//对每一个电影进行取数据查询
    		MovieInfo movieInfo = new MovieInfo();
    		String movie_name = entity.getMoive_name();
    		movieInfo.setName(movie_name);
    		System.out.println("加勒比");
    		//获取价格
    		Price price1 = getlowest(movie_name,platform1);
    		Price price2 = getlowest(movie_name,platform2);
    		Price price3 = getlowest(movie_name,platform3);
    		List<Price> priceList = new ArrayList<Price>();
    		priceList.add(price1);
    		priceList.add(price2);
    		priceList.add(price3);
    		movieInfo.setPriceList(priceList);
    		//获取评分
    		List<Mark> markList = new ArrayList<Mark>();   		
    		movieInfo.setMark(computeMark(movie_name, platform1)+"");
    		infos.add(movieInfo);
    		
    	}
		return infos;
    	
    }
    
    private Price getlowest(String movie_name,String platform){
    	List<TimeandLocationEntity> list = timeandLocationRepository.findByMovieAndResource(movie_name,platform);
    	
    	Price price = new Price();
    	
    	double lowest=list.get(0).getPrice();
    	price.setPlatform(platform);
    	for(TimeandLocationEntity entity:list){
    		if(entity.getPrice()<lowest){
    			lowest = entity.getPrice();
    		}
        price.setPrice(lowest+"");			
    	}
		return price;
    }
    
    private Mark computeMark(String movie_name, String platform){
    	Mark mark = new Mark();
    	mark.setPlatform(platform);
    	List<CommentEntity> comments = commentRepository.findByNameAndResource(movie_name, platform);
    	double sum = 0;
    	for(CommentEntity entity: comments){
    		sum+=entity.getGrade();
    	}
    	mark.setMark(sum/comments.size()+"");   	
		return mark;	
    }
    
    
}
