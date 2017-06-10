package cn.edu.nju.controller;

import cn.edu.nju.model.*;
import cn.edu.nju.service.impl.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import javax.servlet.http.HttpSession;

/**
 * Created by 11946 on 2017/6/5.
 */
@Controller

public class PriceController {
	 @Autowired
    private MovieInfoService movieInfoService;
	 @Autowired
    private CommentService commentService ;
	 @Autowired
    private TimeAndLocationService timeAndLocationService;

  
    @RequestMapping({"/" , "/index"})
    public String getPriceList(Model model){
    	System.out.println("index pages");
    	//TODO
    	List<MovieInfo> movieInfo = movieInfoService.movieGeneralList("taobao", "zhifubao", "dazhongdianping");
    	model.addAttribute("movieInfo", movieInfo);   	
        return "/index";
    }

    
    @RequestMapping(value="/getComment", method=RequestMethod.GET)
    public String getComment(@RequestParam(value="movieName") String movieName, Model model){
       List<Comment> commentList = commentService.getComment(movieName);
       model.addAttribute("commentList",commentList);
    	return "/getComment";
    }

    
    @RequestMapping(value="/timeAndLocation", method=RequestMethod.GET)
    public String getTimeAndLocation(HttpSession session, @RequestParam(value="cinemaid") String cinemaid,Model model){
        List<TimeAndLocation> list = timeAndLocationService.timeAndLocationLits(session.getAttribute("moviename").toString(),Integer.parseInt(cinemaid));
        model.addAttribute("timeAndLocation", list);
        return "/timeAndLocation";
    }

    @ResponseBody
    @RequestMapping(value="/getCine", method=RequestMethod.GET)
    public Cinema getCinemaInfo(@RequestParam(value="cinemaId") int cinemaId){
        return timeAndLocationService.cinemaInfo(cinemaId);
    }

    
    @RequestMapping(value="/cinema", method=RequestMethod.GET)
    public String getCinemaAndPrice(HttpSession session,@RequestParam(value="moviename") String movieName,Model model){
    	System.out.println(" movieName： "+ movieName);
    	session.setAttribute("moviename", movieName);
    	// session.setAttribute();
    	List<CinemaAndPrice>  list =  timeAndLocationService.cinemaAndPriceInfo(movieName);
    	model.addAttribute("cinemaInfo", list);
    	
        return "/cinema";
    }

}
