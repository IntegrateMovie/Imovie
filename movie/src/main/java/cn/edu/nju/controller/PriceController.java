package cn.edu.nju.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 11946 on 2017/6/5.
 */
@org.springframework.stereotype.Controller
public class PriceController {

    @ResponseBody
    @RequestMapping(value="/getPriceList",method= RequestMethod.POST)
    public String getPriceList(@RequestParam(value="date") String date){
        return null;
    }

}
