package disburse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import disburse.dao.HouseDisburseDAO;

@Controller
public class HouseDisburseController {
	
	@Autowired
	HouseDisburseDAO hdDAO;
	//Challenge 1
	@RequestMapping("all")
	public String getHomePage(Model model) {
		//System.out.println("get All Page MyBatis begin");
        model.addAttribute("hdList", hdDAO.getListOfAllHds());
		return "disburse.html";
	}
	//Challenge 2
	@GetMapping("bioGuideID/{id}")
	public String getHDbyID(@PathVariable String id, Model model) {
		model.addAttribute("hdList", hdDAO.getHDById(id));
		return "disburse.html";
	}
	//Challenge 4
	@GetMapping("highestAmount")
	public String getHighestAmount(Model model) {
		model.addAttribute("hdList", hdDAO.getHighestAmount());
		return "disburse.html";
	}

}
