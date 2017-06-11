package cn.edu.nju.controller;

import cn.edu.nju.service.ManagerService;
import cn.edu.nju.service.MemberService;
import cn.edu.nju.vo.MemberInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author Qiang
 * @since 27/02/2017
 */
@Controller
@RequestMapping("/manager")
public class ManagerController {
    private final ManagerService managerService;
    private final MemberService memberService;
    @Autowired
    public ManagerController(ManagerService managerService, MemberService memberService) {
        this.managerService = managerService;
        this.memberService = memberService;
    }

    @RequestMapping({"/", "/index"})
    public String index(Model model) {
        model.addAttribute("opens", managerService.getAllOpenApplication(false, -1));
        model.addAttribute("edits" , managerService.getAllModifyApplication(false, -1));

        return "manager/index";
    }

    @RequestMapping(value = "/settlements", method = RequestMethod.GET)
    public String settlements(Model model) {
        model.addAttribute("settlements", managerService.getAllSettlements(false, -1));
//        model.addAttribute("edits" , managerService.getAllModifyApplication());

        return "manager/settlement";
    }

    @RequestMapping(value = "/business", method = RequestMethod.GET)
    public String business(Model model) {
        model.addAttribute("business", managerService.getAllHotelBill(-1));
//        model.addAttribute("edits" , managerService.getAllModifyApplication());

        return "manager/business";
    }


    @RequestMapping(value = "/approve" , method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> approve(boolean isApprove, boolean openOrModify, @RequestParam("operationArray[]") List<Integer> operationArray){
        return managerService.approve(isApprove, openOrModify, operationArray);
    }

    @RequestMapping(value = "/settlements" , method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> settlements(boolean isApprove, @RequestParam("operationArray[]") List<Integer> operationArray){
        return managerService.settle(isApprove, operationArray);
    }


    @RequestMapping("/statistics")
    public String statistics() {
        return "manager/statistics";
    }

    @RequestMapping("/management")
    public String management() {
        return "manager/management";
    }
    @RequestMapping("/local")
    public String local() {
        return "manager/local";
    }
    
    @RequestMapping("/month")
    public String month() {
        return "manager/month";
    }

    @GetMapping("/hotelStatus")
    @ResponseBody
    public Map<String, Object> getHotelStatus() {

        return managerService.getHotelStatus();

    }
    @GetMapping("/memberStatus")
    @ResponseBody
    public Map<String, Object> getMemberStatus() {

        return managerService.getMemberStatus();

    }
    @GetMapping("/financeStatus")
    @ResponseBody
    public Map<String, Object> getFinanceStatus() {

        return managerService.getFinanceStatus();

    }



}
