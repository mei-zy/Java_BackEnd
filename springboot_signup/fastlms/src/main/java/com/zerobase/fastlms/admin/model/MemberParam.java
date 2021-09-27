package com.zerobase.fastlms.admin.model;

import lombok.Data;

import javax.persistence.criteria.CriteriaBuilder;

@Data
public class MemberParam {
    long pageIndex;
    long pageSize;

    String searchType;
    String searchValue;

    public long getPageStart(){
        Init();
        return (pageIndex-1)*pageSize;
    }
    public long getPageEnd(){
        Init();
        return pageSize;
    }
    public void Init(){
        if(pageIndex<1)
            pageIndex=1;
        if(pageSize<10){
            pageSize=10;
        }
    }
}
