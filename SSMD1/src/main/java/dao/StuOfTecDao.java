package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import dto.StuOfTec;
import entity.Student;

public interface StuOfTecDao {
	public StuOfTec getStusOfTec(@Param("userid")String userId);
}
