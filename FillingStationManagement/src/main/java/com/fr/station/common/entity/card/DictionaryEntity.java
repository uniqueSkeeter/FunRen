/*
 * 一些系统的固定数据
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
 * 字典表
 * 
 * @version 1.0
 * _wsq
 */
 @Entity
 @Table(name = "DICTIONARY")
public class DictionaryEntity implements StandardBean {


    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
     @Id
     @Column(name = "ID")
     @GeneratedValue
    private int id;

    /**
     * 类型
     */
     @Column(name = "TYPE")
    private int type;

    /**
     * 名称
     */
     @Column(name = "NAME")
    private String name;

    /**
     * 值
     */
     @Column(name = "VALUE")
    private String value;

    /**
     * 使用状态
     */
     @Column(name = "USE_STATS")
    private int useStats;

    /**
     * 创建时间
     */
     @Column(name = "CREATE_DATE")
    private Timestamp createDate;

    /**
     * 更新时间
     */
     @Column(name = "UPDATE_DATE")
    private Timestamp updateDate;

    /**
     * id的取得
     *
     * @return int id
     */
    public int getId() {
        return id;
    }


    /**
     * 类型的取得
     *
     * @return int 类型
     */
    public int getType() {
        return type;
    }


    /**
     * 名称的取得
     *
     * @return String 名称
     */
    public String getName() {
        return name;
    }


    /**
     * 值的取得
     *
     * @return String 值
     */
    public String getValue() {
        return value;
    }


    /**
     * 使用状态的取得
     *
     * @return int 使用状态
     */
    public int getUseStats() {
        return useStats;
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
     * id的设定
     *
     * @param newint id
     */
    public void setId(int newId) {
        this.id = newId;
    }


    /**
     * 类型的设定
     *
     * @param newint 类型
     */
    public void setType(int newType) {
        this.type = newType;
    }


    /**
     * 名称的设定
     *
     * @param newString 名称
     */
    public void setName(String newName) {
        this.name = newName;
    }


    /**
     * 值的设定
     *
     * @param newString 值
     */
    public void setValue(String newValue) {
        this.value = newValue;
    }


    /**
     * 使用状态的设定
     *
     * @param newint 使用状态
     */
    public void setUseStats(int newUseStats) {
        this.useStats = newUseStats;
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

}
