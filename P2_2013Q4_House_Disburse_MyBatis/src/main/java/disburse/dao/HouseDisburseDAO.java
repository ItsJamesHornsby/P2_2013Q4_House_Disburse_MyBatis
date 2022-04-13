package disburse.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import disburse.mapper.HouseDisburseMapper;
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
	
	public List<HouseDisburseDetail> getListOfAllHds() {
		List<HouseDisburseDetail> hdn = hdm.getListOfAllHds();
		//hdm.getListOfAllHds();
		//hdn.setOffice(StringUtils.capitalize(hdn.getOffice().toLowerCase()));
		for (HouseDisburseDetail hd1 : hdn ) {
			hd1.setOffice(hd1.getOffice().toLowerCase());
		}
		return hdn;
	}
	
	public List<HouseDisburseDetail> getHDById(String id) {
		List<HouseDisburseDetail> hdd = hdm.getHDById(id);
		return hdd;
	}
	
	public List<HouseDisburseDetail> getHighestAmount() {
		List<HouseDisburseDetail> hdd = hdm.getHighestAmount();
		return hdd;
	}
	
	public List<HouseDisburseDetail> hDByYear() {
		List<HouseDisburseDetail> hdd = hdm.postHDByYear();
		return hdd;
	}
	public int insert(List<HouseDisburseDetail> hdList) {
		int status = hdm.insertHDBatch(hdList);
		return status;
		//for (HouseDisburseDetail hdL : hdList) {
		//	hdm.postHD(hdL.getBioGuideID(), hdL.getOffice(), hdL.getCategory(), hdL.getPayee(), hdL.getStartDate(), hdL.getEndDate(), hdL.getPurpose(), hdL.getAmount(), hdL.getYear());
		//}
		
	}

	
}
