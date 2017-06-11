package cn.edu.nju.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.nju.dao.UserbillRepository;
import cn.edu.nju.entity.BillEntity;
import cn.edu.nju.service.UserbillService;
import cn.edu.nju.vo.RfmAnalysis;
/**
 * 用户关系管理的实现
 * @author alice
 *
 */
@Service
public class UserbillServiceImpl implements UserbillService {
	private final UserbillRepository userbillRepository;
	
	@Autowired
	public UserbillServiceImpl(UserbillRepository userbillRepository) {
		this.userbillRepository = userbillRepository;
	}

	@Override
	public List<RfmAnalysis> rfm(int HotelID, int day, int frequency, int money) {
		List<BillEntity> billrecords =  userbillRepository.findByHotelId(HotelID);
		List<RfmAnalysis> result = new ArrayList<RfmAnalysis>();
     
		  int firstcus = 0;
		  double firstmoney = 0;
		  int secondcus = 0;
		  double secondmoney = 0;
		  int thirdcus = 0;
		  double thirdmoney = 0;
		  int forcus = 0;
		  double formoney = 0;
		  int fivcus = 0;
		  double fivmoney = 0;
		  int sixcus = 0;
		  double sixmoney = 0;
		  int sevcus = 0;
		  double sevmoney = 0;
	      int eightcus = 0;
		  double eightmoney = 0;
		
		
		for(BillEntity bill:billrecords){
			int bday = bill.getCondate();
			int bfrequency = bill.getFrequency();
			double bmoney = bill.getAvg();
			if(bday<=day&&bfrequency>frequency&&bmoney>money){
				firstcus++;
				firstmoney+=bmoney;
			}else if(bday<=day&&bfrequency<=frequency&&bmoney<=money){
				secondcus++;
				secondmoney+=bmoney;
			}else if(bday<=day&&bfrequency<=frequency&&bmoney>money){
				thirdcus++;
				thirdmoney+=bmoney;
			}else if(bday>day&&bfrequency>frequency&&bmoney>money){
				forcus++;
				formoney+=bmoney;
			}else if(bday<=day&&bfrequency>frequency&&bmoney<=money){
				fivcus++;
				fivmoney+=bmoney;
			}else if(bday>day&&bfrequency<=frequency&&bmoney>money){
				sixcus++;
				sixmoney+=bmoney;
			}else if(bday>day&&bfrequency>frequency&&bmoney<=money){
				sevcus++;
				sevmoney+=bmoney;
			}else if(bday>day&&bfrequency<=frequency&&bmoney<=money){
				eightcus++;
				eightmoney+=bmoney;
			}
			
		}
		RfmAnalysis first = new RfmAnalysis(1,firstcus,firstmoney);
		result.add(first);
		RfmAnalysis second = new RfmAnalysis(2,secondcus,secondmoney);
		result.add(second);
		RfmAnalysis third = new RfmAnalysis(3,thirdcus,thirdmoney);
		result.add(third);
		RfmAnalysis forth = new RfmAnalysis(4,forcus,formoney);
		result.add(forth);
		RfmAnalysis five = new RfmAnalysis(5,fivcus,fivmoney);
		result.add(five);
		RfmAnalysis six = new RfmAnalysis(6,sixcus,sixmoney);
		result.add(six);
		RfmAnalysis seven = new RfmAnalysis(7,sevcus,sevmoney);
		result.add(seven);
		RfmAnalysis eight = new RfmAnalysis(8,eightcus,eightmoney);
		result.add(eight);
		return result;
	}
	

}
