package cn.yuanyuan.sp.api.service;

import cn.yuanyuan.sp.mbg.model.MmsResourceLink;

import java.util.List;

public interface MmsResourceLinkService {

    int updateResourceLink(MmsResourceLink resourceLink);
    int addResourceLink(MmsResourceLink resourceLink);
    int deleteResourceLink(int id);
    List<MmsResourceLink> queryAllResourceLink();
    List<MmsResourceLink> queryAllResourceLinkByType(int type);
}
