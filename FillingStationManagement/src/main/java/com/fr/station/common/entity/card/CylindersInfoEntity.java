/*
 * 气瓶信息
 * Revised history
 * Copyright(c) 2010 FR Co.,Ltd
 */


package com.fr.station.common.entity.card;


import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fr.station.common.bean.system.StandardBean;


/**
 * 气瓶信息
 * 
 * @version 1.0
 * @authorguyj
 */
 @Entity
 @Table(name = "CYLINDERS_INFO")
public class CylindersInfoEntity implements StandardBean {


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
     * 气瓶编号
     */
     @Column(name = "`CYLINDERS_NO`")
    private String cylindersNo;

    /**
     * 气瓶类型
     */
     @Column(name = "`CYLINDERS_TYPE`")
    private String cylindersType;

    /**
     * 气瓶容量
     */
     @Column(name = "`CYLINDERS_CAP`")
    private String cylindersCap;

    /**
     * 气瓶出厂日期
     */
     @Column(name = "`CYLINDERS_SALE_DATE`")
    private Date cylindersSaleDate;

    /**
     * 气瓶鉴定日期
     */
     @Column(name = "`CYLINDERS_APP_DATE`")
    private Date cylindersAppDate;

    /**
     * 气瓶截止日期
     */
     @Column(name = "`CYLINDERS_COL_DATE`")
    private Date cylindersColDate;

    /**
     * 气瓶状态
     */
     @Column(name = "`CYLINDERS_STATS`")
    private Integer cylindersStats;

    /**
     * 备注
     */
     @Column(name = "`REMARK`")
    private String remark;

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
     * 气瓶编号的取得
     *
     * @return String 气瓶编号
     */
    public String getCylindersNo() {
        return cylindersNo;
    }


    /**
     * 气瓶类型的取得
     *
     * @return String 气瓶类型
     */
    public String getCylindersType() {
        return cylindersType;
    }


    /**
     * 气瓶容量的取得
     *
     * @return String 气瓶容量
     */
    public String getCylindersCap() {
        return cylindersCap;
    }


    /**
     * 气瓶出厂日期的取得
     *
     * @return Date 气瓶出厂日期
     */
    public Date getCylindersSaleDate() {
        return cylindersSaleDate;
    }


    /**
     * 气瓶鉴定日期的取得
     *
     * @return Date 气瓶鉴定日期
     */
    public Date getCylindersAppDate() {
        return cylindersAppDate;
    }


    /**
     * 气瓶截止日期的取得
     *
     * @return Date 气瓶截止日期
     */
    public Date getCylindersColDate() {
        return cylindersColDate;
    }


    /**
     * 气瓶状态的取得
     *
     * @return Integer 气瓶状态
     */
    public Integer getCylindersStats() {
        return cylindersStats;
    }


    /**
     * 备注的取得
     *
     * @return String 备注
     */
    public String getRemark() {
        return remark;
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
     * 气瓶编号的设定
     *
     * @param newString 气瓶编号
     */
    public void setCylindersNo(String newCylindersNo) {
        this.cylindersNo = newCylindersNo;
    }


    /**
     * 气瓶类型的设定
     *
     * @param newString 气瓶类型
     */
    public void setCylindersType(String newCylindersType) {
        this.cylindersType = newCylindersType;
    }


    /**
     * 气瓶容量的设定
     *
     * @param newString 气瓶容量
     */
    public void setCylindersCap(String newCylindersCap) {
        this.cylindersCap = newCylindersCap;
    }


    /**
     * 气瓶出厂日期的设定
     *
     * @param newDate 气瓶出厂日期
     */
    public void setCylindersSaleDate(Date newCylindersSaleDate) {
        this.cylindersSaleDate = newCylindersSaleDate;
    }


    /**
     * 气瓶鉴定日期的设定
     *
     * @param newDate 气瓶鉴定日期
     */
    public void setCylindersAppDate(Date newCylindersAppDate) {
        this.cylindersAppDate = newCylindersAppDate;
    }


    /**
     * 气瓶截止日期的设定
     *
     * @param newDate 气瓶截止日期
     */
    public void setCylindersColDate(Date newCylindersColDate) {
        this.cylindersColDate = newCylindersColDate;
    }


    /**
     * 气瓶状态的设定
     *
     * @param newInteger 气瓶状态
     */
    public void setCylindersStats(Integer newCylindersStats) {
        this.cylindersStats = newCylindersStats;
    }


    /**
     * 备注的设定
     *
     * @param newString 备注
     */
    public void setRemark(String newRemark) {
        this.remark = newRemark;
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
