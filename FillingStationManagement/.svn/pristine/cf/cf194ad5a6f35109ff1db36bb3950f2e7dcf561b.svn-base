/*
 * 调价表
 * Revised history
 * Copyright(c) 2010 FR Co.,Ltd
 */


package com.fr.station.common.entity.card;


import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fr.station.common.bean.system.StandardBean;


/**
 * 调价表
 * 
 * @version 1.0
 * @authorguyj
 */
 @Entity
 @Table(name = "CHANGE_INFO")
public class ChangeInfoEntity implements StandardBean {


    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
     @Id
     @Column(name = "`ID`")
     @GeneratedValue
    private Integer id;

    /**
     * 调价单号
     */
     @Column(name = "`NO`")
    private String no;

    /**
     * 品名
     */
     @Column(name = "`TYPE`")
    private String type;

    /**
     * 新单价
     */
     @Column(name = "`OLD_PRICE`")
    private String oldPrice;

    /**
     * 旧单价
     */
     @Column(name = "`NEW_PRICE`")
    private String newPrice;

    /**
     * 新密度
     */
     @Column(name = "`NEW_DENSITY`")
    private String newDensity;

    /**
     * 旧密度
     */
     @Column(name = "`OLD_DENSITY`")
    private String oldDensity;

    /**
     * 创建时间
     */
     @Column(name = "`CREATE_DATE`")
    private Timestamp createDate;

    /**
     * 更新时间
     */
     @Column(name = "`UPDATE_DATE`")
    private Timestamp updateDate;

    /**
     * 操作员编号
     */
     @Column(name = "`USERID`")
    private Integer userid;



    /**
     * id的取得
     *
     * @return Integer id
     */
    public Integer getId() {
        return id;
    }


    /**
     * 调价单号的取得
     *
     * @return String 调价单号
     */
    public String getNo() {
        return no;
    }


    /**
     * 品名的取得
     *
     * @return String 品名
     */
    public String getType() {
        return type;
    }


    /**
     * 新单价的取得
     *
     * @return String 新单价
     */
    public String getOldPrice() {
        return oldPrice;
    }


    /**
     * 旧单价的取得
     *
     * @return String 旧单价
     */
    public String getNewPrice() {
        return newPrice;
    }


    /**
     * 新密度的取得
     *
     * @return String 新密度
     */
    public String getNewDensity() {
        return newDensity;
    }


    /**
     * 旧密度的取得
     *
     * @return String 旧密度
     */
    public String getOldDensity() {
        return oldDensity;
    }


    /**
     * 创建时间的取得
     *
     * @return Timestamp 创建时间
     */
    public Timestamp getCreateDate() {
        return createDate;
    }


    /**
     * 更新时间的取得
     *
     * @return Timestamp 更新时间
     */
    public Timestamp getUpdateDate() {
        return updateDate;
    }


    /**
     * 操作员编号的取得
     *
     * @return Integer 操作员编号
     */
    public Integer getUserid() {
        return userid;
    }


    /**
     * id的设定
     *
     * @param newInteger id
     */
    public void setId(Integer newId) {
        this.id = newId;
    }


    /**
     * 调价单号的设定
     *
     * @param newString 调价单号
     */
    public void setNo(String newNo) {
        this.no = newNo;
    }


    /**
     * 品名的设定
     *
     * @param newString 品名
     */
    public void setType(String newType) {
        this.type = newType;
    }


    /**
     * 新单价的设定
     *
     * @param newString 新单价
     */
    public void setOldPrice(String newOldPrice) {
        this.oldPrice = newOldPrice;
    }


    /**
     * 旧单价的设定
     *
     * @param newString 旧单价
     */
    public void setNewPrice(String newNewPrice) {
        this.newPrice = newNewPrice;
    }


    /**
     * 新密度的设定
     *
     * @param newString 新密度
     */
    public void setNewDensity(String newNewDensity) {
        this.newDensity = newNewDensity;
    }


    /**
     * 旧密度的设定
     *
     * @param newString 旧密度
     */
    public void setOldDensity(String newOldDensity) {
        this.oldDensity = newOldDensity;
    }


    /**
     * 创建时间的设定
     *
     * @param newTimestamp 创建时间
     */
    public void setCreateDate(Timestamp newCreateDate) {
        this.createDate = newCreateDate;
    }


    /**
     * 更新时间的设定
     *
     * @param newTimestamp 更新时间
     */
    public void setUpdateDate(Timestamp newUpdateDate) {
        this.updateDate = newUpdateDate;
    }


    /**
     * 操作员编号的设定
     *
     * @param newInteger 操作员编号
     */
    public void setUserid(Integer newUserid) {
        this.userid = newUserid;
    }
}
