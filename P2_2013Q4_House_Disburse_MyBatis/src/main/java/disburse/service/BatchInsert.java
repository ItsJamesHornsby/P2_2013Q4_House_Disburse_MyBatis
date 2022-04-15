package disburse.service;

import java.util.List;

import disburse.vo.HouseDisburseDetail;

public interface BatchInsert {
	void insertBatch(List<HouseDisburseDetail> hdList);
}
