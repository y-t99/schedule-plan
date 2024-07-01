package cn.yuanyuan.sp.mbg.mapper;

import cn.yuanyuan.sp.mbg.model.MmsResourceLink;
import cn.yuanyuan.sp.mbg.model.MmsResourceLinkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MmsResourceLinkMapper {
    long countByExample(MmsResourceLinkExample example);

    int deleteByExample(MmsResourceLinkExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MmsResourceLink record);

    int insertSelective(MmsResourceLink record);

    List<MmsResourceLink> selectByExample(MmsResourceLinkExample example);

    MmsResourceLink selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MmsResourceLink record, @Param("example") MmsResourceLinkExample example);

    int updateByExample(@Param("record") MmsResourceLink record, @Param("example") MmsResourceLinkExample example);

    int updateByPrimaryKeySelective(MmsResourceLink record);

    int updateByPrimaryKey(MmsResourceLink record);
}