package cn.yuanyuan.sp.background.dto;

import cn.yuanyuan.sp.mbg.model.UmsUser;
import lombok.Data;

import java.util.List;

@Data
public class Notify {

    private long toDoCount;

    private Integer messageCount;

    private List<UmsUser> verifications;

    private List<String> agreementNotifies;

    private String disagreementNotify;
}
