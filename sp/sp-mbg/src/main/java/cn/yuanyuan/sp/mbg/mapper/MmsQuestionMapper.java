package cn.yuanyuan.sp.mbg.mapper;

import cn.yuanyuan.sp.mbg.model.MmsQuestion;
import cn.yuanyuan.sp.mbg.model.MmsQuestionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MmsQuestionMapper {
    long countByExample(MmsQuestionExample example);

    int deleteByExample(MmsQuestionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MmsQuestion record);

    int insertSelective(MmsQuestion record);

    List<MmsQuestion> selectByExample(MmsQuestionExample example);

    MmsQuestion selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MmsQuestion record, @Param("example") MmsQuestionExample example);

    int updateByExample(@Param("record") MmsQuestion record, @Param("example") MmsQuestionExample example);

    int updateByPrimaryKeySelective(MmsQuestion record);

    int updateByPrimaryKey(MmsQuestion record);
}