package cn.yuanyuan.sp.api.service;

import cn.yuanyuan.sp.mbg.model.MmsQuestion;
import cn.yuanyuan.sp.mbg.model.MmsResourceLink;

import java.util.List;

public interface MmsQuestionService {

    int addQuestion(MmsQuestion question);
    int deleteQuestion(int id);
    List<MmsQuestion> queryAllQuestion();

}
