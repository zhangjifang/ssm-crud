package com.atguigu.crud.dao;

import com.atguigu.crud.bean.ReturnInfo;
import com.atguigu.crud.bean.ReturnInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReturnInfoMapper {
    long countByExample(ReturnInfoExample example);

    int deleteByExample(ReturnInfoExample example);

    int deleteByPrimaryKey(String studentid);

    int insert(ReturnInfo record);

    int insertSelective(ReturnInfo record);

    List<ReturnInfo> selectByExample(ReturnInfoExample example);
    
    List<ReturnInfo> selectByExampleWithStudent(ReturnInfoExample example);

    ReturnInfo selectByPrimaryKey(String studentid);

    int updateByExampleSelective(@Param("record") ReturnInfo record, @Param("example") ReturnInfoExample example);

    int updateByExample(@Param("record") ReturnInfo record, @Param("example") ReturnInfoExample example);

    int updateByPrimaryKeySelective(ReturnInfo record);

    int updateByPrimaryKey(ReturnInfo record);

	
}