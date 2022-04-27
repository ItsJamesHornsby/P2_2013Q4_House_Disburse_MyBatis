package disburse.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import disburse.mapper.HouseDisburseMapper;
import disburse.service.MyBatisBatchInsert;
import disburse.vo.HouseDisburseDetail;

@Service
public class HouseDisburseDAO {
	//Field Injection below!
	@Autowired
	HouseDisburseMapper hdm;
	HouseDisburseMapper getHouseDisburseMapper() {
		return hdm;
	}
	void setHouseDisburseMapper(HouseDisburseMapper hdm) {
		this.hdm = hdm;
	}
	
	@Autowired
	private MyBatisBatchInsert mybb;
	//Challenge 1
	public List<HouseDisburseDetail> getListOfAllHds() {
		List<HouseDisburseDetail> hdn = hdm.getListOfAllHds();
		//hdm.getListOfAllHds();
		//hdn.setOffice(StringUtils.capitalize(hdn.getOffice().toLowerCase()));
		for (HouseDisburseDetail hd1 : hdn ) {
			hd1.setOffice(hd1.getOffice().toLowerCase());
		}
		return hdn;
	}
	//Challenge 2
	public List<HouseDisburseDetail> getHDById(String id) {
		List<HouseDisburseDetail> hdd = hdm.getHDById(id);
		return hdd;
	}
	//Challenge 4
	public List<HouseDisburseDetail> getHighestAmount() {
		List<HouseDisburseDetail> hdd = hdm.getHighestAmount();
		return hdd;
	}
	//Challenge 2.5
	public List<HouseDisburseDetail> hDByYear() {
		List<HouseDisburseDetail> hdd = hdm.postHDByYear();
		return hdd;
	}
	public void insert(List<HouseDisburseDetail> hdList) {
		mybb.insertBatch(hdList);
		//return hdm.getListOfAllHds();
		//for (HouseDisburseDetail hdL : hdList) {
		//	hdm.postHD(hdL.getBioGuideID(), hdL.getOffice(), hdL.getCategory(), hdL.getPayee(), hdL.getStartDate(), hdL.getEndDate(), hdL.getPurpose(), hdL.getAmount(), hdL.getYear());
		//}
		
	}

	
}
