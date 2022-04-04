package disburse.dao;

import org.springframework.beans.factory.annotation.Autowired;

import disburse.mapper.HouseDisburseMapper;

public class HouseDisburseDAO {
	//Field Injection below!
	@Autowired
	HouseDisburseMapper hdm;
}
