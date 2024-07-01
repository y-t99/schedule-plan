package cn.yuanyuan.sp.mbg.mapper;

import cn.yuanyuan.sp.mbg.model.MmsVersionLog;
import cn.yuanyuan.sp.mbg.model.MmsVersionLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MmsVersionLogMapper {
    long countByExample(MmsVersionLogExample example);

    int deleteByExample(MmsVersionLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MmsVersionLog record);

    int insertSelective(MmsVersionLog record);

    List<MmsVersionLog> selectByExample(MmsVersionLogExample example);

    MmsVersionLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MmsVersionLog record, @Param("example") MmsVersionLogExample example);

    int updateByExample(@Param("record") MmsVersionLog record, @Param("example") MmsVersionLogExample example);

    int updateByPrimaryKeySelective(MmsVersionLog record);

    int updateByPrimaryKey(MmsVersionLog record);
}