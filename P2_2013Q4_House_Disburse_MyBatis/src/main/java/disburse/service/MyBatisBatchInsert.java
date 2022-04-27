package disburse.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import disburse.mapper.HouseDisburseMapper;
import disburse.vo.HouseDisburseDetail;

@Service
public class MyBatisBatchInsert implements BatchInsert {
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Override
	@Transactional
	public void insertBatch(List<HouseDisburseDetail> hddList) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH)) {
			HouseDisburseMapper mapper = sqlSession.getMapper(HouseDisburseMapper.class);
			//System.out.println("I am in the MyBatisBatchInsert!!!!");
			//mapper.insertHDBatch(hddList);
			for (HouseDisburseDetail hd : hddList) {
				mapper.insertHD(hd);
			}
			sqlSession.commit();
		}
	}
}
