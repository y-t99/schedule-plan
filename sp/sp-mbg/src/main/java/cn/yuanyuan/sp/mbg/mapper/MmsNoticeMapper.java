package cn.yuanyuan.sp.mbg.mapper;

import cn.yuanyuan.sp.mbg.model.MmsNotice;
import cn.yuanyuan.sp.mbg.model.MmsNoticeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MmsNoticeMapper {
    long countByExample(MmsNoticeExample example);

    int deleteByExample(MmsNoticeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MmsNotice record);

    int insertSelective(MmsNotice record);

    List<MmsNotice> selectByExample(MmsNoticeExample example);

    MmsNotice selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MmsNotice record, @Param("example") MmsNoticeExample example);

    int updateByExample(@Param("record") MmsNotice record, @Param("example") MmsNoticeExample example);

    int updateByPrimaryKeySelective(MmsNotice record);

    int updateByPrimaryKey(MmsNotice record);
}