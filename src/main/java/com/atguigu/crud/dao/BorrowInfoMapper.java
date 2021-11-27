package com.atguigu.crud.dao;

import com.atguigu.crud.bean.BorrowInfo;
import com.atguigu.crud.bean.BorrowInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BorrowInfoMapper {
    long countByExample(BorrowInfoExample example);

    int deleteByExample(BorrowInfoExample example);

    int deleteByPrimaryKey(String borrowid);

    int insert(BorrowInfo record);

    int insertSelective(BorrowInfo record);

    List<BorrowInfo> selectByExample(BorrowInfoExample example);
    List<BorrowInfo> selectByExampleWithStudent(BorrowInfoExample example);

    BorrowInfo selectByPrimaryKey(String borrowid);

    int updateByExampleSelective(@Param("record") BorrowInfo record, @Param("example") BorrowInfoExample example);

    int updateByExample(@Param("record") BorrowInfo record, @Param("example") BorrowInfoExample example);

    int updateByPrimaryKeySelective(BorrowInfo record);

    int updateByPrimaryKey(BorrowInfo record);
}