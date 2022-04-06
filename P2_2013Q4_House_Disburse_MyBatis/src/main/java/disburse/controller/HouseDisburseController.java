package disburse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import disburse.dao.HouseDisburseDAO;

@Controller
public class HouseDisburseController {
	
	@Autowired
	HouseDisburseDAO hdDAO;
	
	@RequestMapping("all")
	public String getHomePage(Model model) {
		//System.out.println("get All Page MyBatis begin");
        model.addAttribute("hdList", hdDAO.getListOfAllHds());
		return "disburse.html";
	}

}
