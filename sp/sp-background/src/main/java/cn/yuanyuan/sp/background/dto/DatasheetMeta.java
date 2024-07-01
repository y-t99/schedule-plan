package cn.yuanyuan.sp.background.dto;

import cn.yuanyuan.sp.mbg.model.TmsAttribute;
import cn.yuanyuan.sp.mbg.model.TmsAttributeDefinitionDict;

import java.util.List;

public class DatasheetMeta extends TmsAttribute {

    private List<TmsAttributeDefinitionDict> childrens;

    public List<TmsAttributeDefinitionDict> getChildrens() {
        return childrens;
    }

    public void setChildrens(List<TmsAttributeDefinitionDict> childrens) {
        this.childrens = childrens;
    }
}
