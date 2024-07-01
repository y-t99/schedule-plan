package cn.yuanyuan.sp.background.controller;

import cn.yuanyuan.sp.background.dto.ApprovalParameter;
import cn.yuanyuan.sp.background.dto.LogParameter;
import cn.yuanyuan.sp.background.dto.NoticeParameter;
import cn.yuanyuan.sp.background.dto.Notify;
import cn.yuanyuan.sp.background.service.WorkTableService;
import cn.yuanyuan.sp.common.api.CommonResult;
import cn.yuanyuan.sp.mbg.mapper.MmsNoticeMapper;
import cn.yuanyuan.sp.mbg.mapper.MmsVersionLogMapper;
import cn.yuanyuan.sp.mbg.model.MmsNotice;
import cn.yuanyuan.sp.mbg.model.MmsVersionLog;
import cn.yuanyuan.sp.mbg.model.MmsVersionLogExample;
import cn.yuanyuan.sp.mbg.model.UmsUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("work-table")
public class WorkTableController {

    @Autowired
    WorkTableService workTableService;

    @Autowired
    MmsNoticeMapper noticeMapper;

    @Autowired
    MmsVersionLogMapper versionLogMapper;

    @GetMapping("/notice/list")
    public CommonResult<Notify> notifyList() {
        // 代办事项
        int toDoCount = workTableService.toDoCount();
        // 通知
        int messageCount = workTableService.messageCount();
        // 待审批成员
        List<UmsUser> verifications = workTableService.verifications();
        // 同意列表
        List<String> agreementNotifies = workTableService.agreementNotifies();
        // 同意列表
        String disagreementNotifies = workTableService.disagreementNotifies();
        Notify notify = new Notify();
        notify.setToDoCount(toDoCount);
        notify.setMessageCount(messageCount);
        notify.setVerifications(verifications);
        notify.setAgreementNotifies(agreementNotifies);
        notify.setDisagreementNotify(disagreementNotifies);
        return CommonResult.success(notify);
    }

    @PutMapping("/approval")
    public CommonResult<Integer> approval(@RequestBody ApprovalParameter approvalParameter) {
        Integer count = workTableService.approval(approvalParameter.getId(), approvalParameter.getStatue());
        return CommonResult.success(count);
    }

    @PutMapping("/close-notify/{id}")
    public CommonResult<Integer> closeNotify(@PathVariable("id")Integer id) {
        Integer count = workTableService.closeNotify(id);
        return CommonResult.success(count);
    }

    @GetMapping("/notice")
    public CommonResult<MmsNotice> notice() {
        MmsNotice notice = noticeMapper.selectByPrimaryKey(1);
        return CommonResult.success(notice);
    }

    @PutMapping("/notice")
    public CommonResult<MmsNotice> pushNotice(@RequestBody NoticeParameter notice) {
        MmsNotice update = new MmsNotice();
        update.setId(1);
        update.setTitle(notice.getTitle());
        update.setContent(notice.getContent());
        noticeMapper.updateByPrimaryKeySelective(update);
        return CommonResult.success(noticeMapper.selectByPrimaryKey(1));
    }

    @GetMapping("/defaultLogs")
    public CommonResult<List<MmsVersionLog>> defaultLogs() {
        List<MmsVersionLog> list = versionLogMapper.selectByExample(new MmsVersionLogExample());
        return CommonResult.success(list.subList(0, 7));
    }

    @GetMapping("/logs")
    public CommonResult<List<MmsVersionLog>> logs() {
        List<MmsVersionLog> list = versionLogMapper.selectByExample(new MmsVersionLogExample());
        return CommonResult.success(list);
    }

    @PostMapping("/log")
    public CommonResult<Integer> log(@RequestBody LogParameter logParameter) {
        MmsVersionLog log = new MmsVersionLog();
        log.setTitle(logParameter.getTitle());
        log.setContent(logParameter.getContent());
        log.setType(logParameter.getType());
        log.setVersion(logParameter.getVersion());
        log.setTimePoint(System.currentTimeMillis()/1000);
        int i = versionLogMapper.insertSelective(log);
        return CommonResult.success(i);
    }

    @DeleteMapping("/log/{id}")
    public CommonResult<Integer> removeLog(@PathVariable("id")Integer id) {
        int count = versionLogMapper.deleteByPrimaryKey(id);
        return CommonResult.success(count);
    }
}
