﻿/*
 * 车辆信息
 * Revised history
 * Copyright(c) 2010 FR Co.,Ltd
 */


package com.fr.station.common.entity.card;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fr.station.common.bean.system.StandardBean;


/**
 * 车辆信息
 * 
 * @version 1.0
 * @authorguyj
 */
 @Entity
 @Table(name = "CAR")
public class CarEntity implements StandardBean {


    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
     @Id
     @Column(name = "`ID`")
     @GeneratedValue
    private Integer id;

    /**
     * 车号
     */
     @Column(name = "`CARNO`")
    private String carno;

    /**
     * 卡号
     */
     @Column(name = "`ASN`")
    private String asn;

    /**
     * 单位号
     */
     @Column(name = "`GUESTNO`")
    private String guestno;



    /**
     * ID的取得
     *
     * @return Integer ID
     */
    public Integer getId() {
        return id;
    }


    /**
     * 车号的取得
     *
     * @return String 车号
     */
    public String getCarno() {
        return carno;
    }


    /**
     * 卡号的取得
     *
     * @return String 卡号
     */
    public String getAsn() {
        return asn;
    }


    /**
     * 单位号的取得
     *
     * @return String 单位号
     */
    public String getGuestno() {
        return guestno;
    }


    /**
     * ID的设定
     *
     * @param newInteger ID
     */
    public void setId(Integer newId) {
        this.id = newId;
    }


    /**
     * 车号的设定
     *
     * @param newString 车号
     */
    public void setCarno(String newCarno) {
        this.carno = newCarno;
    }


    /**
     * 卡号的设定
     *
     * @param newString 卡号
     */
    public void setAsn(String newAsn) {
        this.asn = newAsn;
    }


    /**
     * 单位号的设定
     *
     * @param newString 单位号
     */
    public void setGuestno(String newGuestno) {
        this.guestno = newGuestno;
    }
}
