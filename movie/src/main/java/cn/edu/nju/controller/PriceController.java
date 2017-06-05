package cn.edu.nju.controller;

import cn.edu.nju.model.MovieInfo;
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

    @ResponseBody
    @RequestMapping(value="/getPriceList",method= RequestMethod.POST)
    public List<MovieInfo > getPriceList(@RequestParam(value="date") String date){
        return null;
    }

}
