package disburse.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import disburse.vo.HouseDisburseDetail;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;

@Mapper
public interface HouseDisburseMapper {
	
	//Code Challenge 1
	@Select("SELECT * from T_2013Q4_HOUSE_DISBURSE")
	@Results (id = "hdResultMap", value = {
			@Result(property = "bioGuideID", column = "BIOGUIDE_ID"),
			@Result(property = "startDate", column = "START_DATE"),
			@Result(property = "endDate", column = "END_DATE"),	
	})
	public List<HouseDisburseDetail> getListOfAllHds();
	
	@ResultMap("hdResultMap")
	@Select("SELECT * from T_2013Q4_HOUSE_DISBURSE")
	public List<HouseDisburseDetail> getListOfAllHdsMap();

	//Code Challenge 2
	@ResultMap("hdResultMap")
	@Select("SELECT * from T_2013Q4_HOUSE_DISBURSE WHERE BIOGUIDE_ID = #{id}")
	public List<HouseDisburseDetail> getHDById(String id);
	
	//Code Challenge 4
	@ResultMap("hdResultMap")
	@Select("SELECT * from T_2013Q4_HOUSE_DISBURSE where AMOUNT = (SELECT MAX(AMOUNT) from T_2013Q4_HOUSE_DISBURSE)")
	public List<HouseDisburseDetail> getHighestAmount();

	@ResultMap("hdResultMap")
	@Select("INSERT INTO T_2013Q4_HOUSE_DISBURSE(bioGuideID, office, category, payee, startDate"
			+ "endDate, purpose, amount, year) +"
			+ "VALUES"
			+ "(#{bioGuideID}, #{office}, #{category},"
			+ "#{payee}, #{startDate}, #{endDate}, #{purpose}, #{amount}, #{year})" )
	public void postHD(String bioGuideID, String office, String category, String payee, String startDate,
			String endDate, String purpose, double amount, String year);

	//Code Challenge 2.5
	@ResultMap("hdResultMap")
	@Select("SELECT * from T_2013Q4_HOUSE_DISBURSE WHERE YEAR = 2020")
	public List<HouseDisburseDetail> postHDByYear();
	
	@Insert({
		"<script>",
		"INSERT INTO T_2013Q4_HOUSE_DISBURSE",
		"(BIOGUIDE_ID, OFFICE, CATEGORY, PAYEE, START_DATE, END_DATE, PURPOSE, AMOUNT, YEAR)",
		"VALUES",
		 "<foreach collection='hd' item='houseDisburseDetail' open='' separator=',' close=''>",
		  "(",
		   "#{houseDisburseDetail.bioGuideID}",
		   "#{houseDisburseDetail.office}",
		   "#{houseDisburseDetail.category}",
		   "#{houseDisburseDetail.payee}",
		   "#{houseDisburseDetail.startDate}",
		   "#{houseDisburseDetail.endDate}",
		   "#{houseDisburseDetail.purpose}",
		   "#{houseDisburseDetail.amount}",
		   "#{houseDisburseDetail.year}",
		  ")",
		 "</foreach>",
		"</script>"
	})
	public int insertHDBatch(@Param("hd") List<HouseDisburseDetail> hdList);
	
	@Insert({"INSERT INTO T_2013Q4_HOUSE_DISBURSE (BIOGUIDE_ID, OFFICE, CATEGORY, PAYEE, START_DATE, END_DATE, PURPOSE, AMOUNT, YEAR)",
			"VALUES",
			"(",
			   "#{hd.bioGuideID},",
			   "#{hd.office},",
			   "#{hd.category},",
			   "#{hd.payee},",
			   "#{hd.startDate},",
			   "#{hd.endDate},",
			   "#{hd.purpose},",
			   "#{hd.amount},",
			   "#{hd.year})"})
	@Options(useGeneratedKeys=false, keyProperty="bioGuideID")
	public int insertHD(@Param("hd") HouseDisburseDetail hd );
	

}
