package cn.yuanyuan.sp.background.service;

import cn.yuanyuan.sp.mbg.model.UmsUser;

import java.util.List;

public interface WorkTableService {

    int toDoCount();

    int messageCount();

    List<UmsUser> verifications();

    List<String> agreementNotifies();

    String disagreementNotifies();

    Integer approval(Integer id, Integer statue);

    Integer closeNotify(Integer id);
}
