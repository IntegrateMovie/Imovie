package cn.edu.nju.controller;

import cn.edu.nju.model.*;
import cn.edu.nju.service.impl.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by 11946 on 2017/6/5.
 */
@org.springframework.stereotype.Controller
@RequestMapping("/json")
public class PriceController {

    private MovieInfoService movieInfoService = new MovieInfoServiceImpl();
    private CommentService commentService = new CommentServiceImpl();
    private TimeAndLocationService timeAndLocationService = new TimeAndLocationServiceImpl();

    @ResponseBody
    @RequestMapping(value="/getPriceList",method= RequestMethod.POST)
    public List<MovieInfo > getPriceList(@RequestParam(value="platfrom1") String platform1, @RequestParam(value="platform2") String platform2 , @RequestParam(value="platform3")
                                         String platform3){
        return movieInfoService.movieGeneralList(platform1,platform2,platform3);
    }

    @ResponseBody
    @RequestMapping(value="/getComment", method=RequestMethod.GET)
    public List<Comment> getComment(@RequestParam(value="movieName") String movieName, @RequestParam(value="platform") String platform){
        return commentService.getComment(movieName, platform);
    }

    @ResponseBody
    @RequestMapping(value="/getTimeAndLocation", method=RequestMethod.GET)
    public List<TimeAndLocation> getTimeAndLocation(@RequestParam(value="movieName") String movieName, @RequestParam(value="cinemaid") int cinemaid){
        return timeAndLocationService.timeAndLocationLits(movieName,cinemaid);
    }

    @ResponseBody
    @RequestMapping(value="/getCinemaInfo", method=RequestMethod.GET)
    public Cinema getCinemaInfo(@RequestParam(value="cinemaId") int cinemaId){
        return timeAndLocationService.cinemaInfo(cinemaId);
    }

    @ResponseBody
    @RequestMapping(value="/getCinemaAndPriceInfo", method=RequestMethod.GET)
    public List<CinemaAndPrice> getCinemaAndPrice(@RequestParam(value="cinemaName") String cinemaName){
        return timeAndLocationService.cinemaAndPriceInfo(cinemaName);
    }

}
