package cn.edu.nju.controller;

import cn.edu.nju.dao.HotelRepository;
import cn.edu.nju.entity.HotelEntity;
import cn.edu.nju.entity.LiveMesEntity;
import cn.edu.nju.entity.RoomsEntity;
import cn.edu.nju.service.HotelService;
import cn.edu.nju.service.MemberService;
import cn.edu.nju.service.UserbillService;
import cn.edu.nju.util.SystemDefault;
import cn.edu.nju.vo.MemberInfoVO;
import cn.edu.nju.vo.RfmAnalysis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.List;
import java.util.Map;

/**
 * @author Qiang
 * @since 27/02/2017
 */
@Controller
@RequestMapping("/hotel")
public class HotelController {



    private final HotelRepository hotelRepository;
    private final HotelService hotelService;
    private final MemberService memberService;
    private final UserbillService userbillService ;

    @Autowired
    public HotelController(HotelRepository hotelRepository, HotelService hotelService, MemberService memberService,UserbillService userbillService ) {
        this.hotelRepository = hotelRepository;
        this.hotelService = hotelService;
        this.memberService = memberService;
        this.userbillService = userbillService;
    }



    @RequestMapping(value = {"/", "/index"})
    public String index(@SessionAttribute(SystemDefault.USER_ID) int id, Model model) {


        HotelEntity hotel = hotelRepository.findOne(id);

        if (hotel == null) {
            return "../index";
        }

        if (hotel.getStatus() == 0) {
            model.addAttribute("status", 0);

        } else {
            model.addAttribute("status", 1);
            List<RoomsEntity> roomsEntities = hotelService.findRoomsByHotelId(id, false, -1 );
            model.addAttribute("rooms", roomsEntities);
        }


        return "hotel/index";
    }

    @RequestMapping("/record")
    public String record(Model model, @SessionAttribute(SystemDefault.USER_ID) int id) {
        System.out.println("id is:"+id);
        HotelEntity hotel = hotelRepository.findOne(id);

        if (hotel.getStatus() == 0) {
            model.addAttribute("status", 0);

        } else {
            model.addAttribute("status", 1);
            //TODO pageable
            List<LiveMesEntity> liveMesEntities = hotelService.findLiveMesByHotelId(id, -1);

            model.addAttribute("records", liveMesEntities);
        }

        return "hotel/record";
    }
    

    @RequestMapping(value = "/cusrelation", method = RequestMethod.POST)
    public String rfm(Model model, @SessionAttribute(SystemDefault.USER_ID) int id,@RequestParam("day")String day,@RequestParam("frequency")String frequency,@RequestParam("avg")String avg) {
    	//得到用户评级信息
    	System.out.println("day is"+day);
    	System.out.println("fre is"+frequency);
    	System.out.println("avg is"+avg);
    	List<RfmAnalysis> rfm = userbillService.rfm(id,Integer.parseInt(day), Integer.parseInt(frequency), Integer.parseInt(avg));
 	    model.addAttribute("rfm",rfm);
        return "hotel/cusrelation";
    }


    @RequestMapping(value = "/addInRecords", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addInRecords(int personNum, String personMes, int isMember, int payMethod, int memberId, int roomId, boolean hasReserved, @SessionAttribute(SystemDefault.USER_ID) int hotelId) {


        return hotelService.addInRecords(personNum, personMes, isMember, payMethod, memberId, roomId, hotelId, hasReserved);
    }

    @RequestMapping(value = "/addOutRecords", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addOutRecords(int recordId) {
        return hotelService.addOutRecords(recordId);
    }

    @RequestMapping("/info")
    public String info(Model model, @SessionAttribute(SystemDefault.USER_ID) int id) {

        HotelEntity hotel = hotelRepository.findOne(id);

        model.addAttribute("hotel", hotel);

        if (hotelService.isApplyingForEditing(id)) {
            model.addAttribute("edit", true);
        }
        if (hotelService.isApplyingForOpen(id)) {
            model.addAttribute("open", true);
        }

        return "hotel/info";
    }


    @RequestMapping("/statistics")
    public String statistics() {
        return "hotel/statistics";
    }
    
    @RequestMapping("/cusrelation")
    public String cusrelation() {
        return "hotel/cusrelation";
    }

    @RequestMapping(value = "/open", method = RequestMethod.POST)
    public String openApplication(Model model, String reason, @SessionAttribute(SystemDefault.USER_ID) int id) {
        hotelService.saveOpenApplication(reason, id);
        return info(model, id);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editApplication(Model model, String name, String address, String description, @SessionAttribute(SystemDefault.USER_ID) int id, String url) {


        hotelService.saveModifyApplication(name, address, description, id, url);

        return info(model, id);
    }

    @RequestMapping(value = "/addRooms", method = RequestMethod.POST)
    @ResponseBody
    public List<RoomsEntity> addNewRooms(String time, boolean wifi, String picUrl, int area, int type, int price, int number, @SessionAttribute(SystemDefault.USER_ID) int id) {

        // TODO REMOVE futile return && allow to upload new room pic
        return hotelService.addRooms(time, wifi, picUrl, area, type, price, number, id);
    }

    @RequestMapping("/register")
    public String register() {
        return "redirect:/register";
    }

    @RequestMapping("/logout")
    public String logout(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "redirect:/index";
    }

    @GetMapping("/reservedStatus")
    @ResponseBody
    public Map<String, Object> getHotelReservedStatus(@SessionAttribute(SystemDefault.USER_ID) int id) {
        return hotelService.getHotelReservedStatus(id);
    }
   
    //新假的客户管理
    @GetMapping("/customerBill")
    @ResponseBody
    public Map<String, Object> getHotelcustomerBill(@SessionAttribute(SystemDefault.USER_ID) int id) {
        return hotelService.getCustomeBill(id);
    }
    
    @GetMapping("/liveStatus")
    @ResponseBody
    public Map<String, Object> getHotelLiveStatus(@SessionAttribute(SystemDefault.USER_ID) int id) {
        return hotelService.getHotelLiveStatus(id);
    }

    @GetMapping("/consumptionStatus")
    @ResponseBody
    public Map<String, Object> getHotelConsumptionStatus(@SessionAttribute(SystemDefault.USER_ID) int id) {
        return hotelService.getHotelConsumptionStatus(id);
    }


    @GetMapping("/getDiscount")
    @ResponseBody
    public int getDiscount(int memberId ){
        MemberInfoVO entity  = memberService.getMemberProfile(memberId);
        if (entity != null) {
            return entity.getDiscount();
        } else {
            return -1;
        }
    }
}
