//package cn.edu.nju.controller;
//
//import java.util.List;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import cn.edu.nju.model.MovieInfo;
//
//@Controller
//public class LoginController {
//	
//	 @RequestMapping({"/", "/getPriceList" , "/index"})
//	    public String getPriceList(Model model){
//	    	List<MovieInfo> movieInfo = movieInfoService.movieGeneralList("淘宝", "支付宝", "大众点评");
//	    	model.addAttribute("movieInfo", movieInfo);   	
//	        return "/getPriceList";
//	    }
//
//}
