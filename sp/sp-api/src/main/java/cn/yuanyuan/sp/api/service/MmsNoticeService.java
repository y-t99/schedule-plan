package cn.yuanyuan.sp.api.service;

import cn.yuanyuan.sp.mbg.model.MmsNotice;

import java.util.List;

public interface MmsNoticeService {

    int updateNotice(MmsNotice notice);
    List<MmsNotice> queryAllNotice();


}
