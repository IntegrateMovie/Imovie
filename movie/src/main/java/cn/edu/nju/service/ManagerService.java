package cn.edu.nju.service;

import cn.edu.nju.entity.HotelmanagementEntity;
import cn.edu.nju.entity.ModifyApplicationEntity;
import cn.edu.nju.entity.OpenApplicationEntity;
import cn.edu.nju.entity.SettlementEntity;

import java.util.List;
import java.util.Map;

/**
 * @author Qiang
 * @since 02/03/2017
 */
public interface ManagerService {

    /**
     *
     * @param onlyOpen only return applications that are still not tackled
     * @param page     the pages num start from 0, -1 means return all
     * @return         the applications
     */
    List<OpenApplicationEntity> getAllOpenApplication(boolean onlyOpen, int page);



    /**
     *
     * @param onlyOpen only return applications that are still not tackled
     * @param page     the pages num start from 0, -1 means return all
     * @return         the applications
     */
    List<ModifyApplicationEntity> getAllModifyApplication(boolean onlyOpen, int page);
    /**
     *
     * @param onlyOpen only return settlements that are still not tackled
     * @param page     the pages num start from 0, -1 means return all
     * @return         the settlements
     */
    List<SettlementEntity> getAllSettlements(boolean onlyOpen, int page);

    List<HotelmanagementEntity> getAllHotelBill(int page);

    Map<String,Object> approve(boolean approve, boolean openOrModify, List<Integer> applicationId);

    Map<String,Object> settle(boolean isApprove, List<Integer> operationArray);


    /**
     * Return the hotel status of the whole Hostel World
     * @return
     */
    Map<String,Object> getHotelStatus();

    /**
     * Return the member status of the whole Hostel World
     * @return
     */
    Map<String,Object> getMemberStatus();

    /**
     * Return the Finance Status of the whole Hostel World
     * @return
     */
    Map<String,Object> getFinanceStatus();
}
