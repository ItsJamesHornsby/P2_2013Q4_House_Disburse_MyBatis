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

		
		return hdn;
		//return hdm.getListOfAllHds();
	}
	
}
