package disburse.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import disburse.dao.HouseDisburseDAO;
import disburse.vo.HouseDisburseDetail;

@Controller
public class CRMRestController {

	@Autowired
	HouseDisburseDAO hdDAO;
	
	@PostMapping("loadDisburse")
	public @ResponseBody List<HouseDisburseDetail> loadList(@RequestBody final List<HouseDisburseDetail> hdList) {
		hdDAO.insert(hdList);
		//System.out.println(hdList.get(0).toString());
		return hdDAO.hDByYear();
		//return hdDAO.getListOfAllHds();
	}
	
}