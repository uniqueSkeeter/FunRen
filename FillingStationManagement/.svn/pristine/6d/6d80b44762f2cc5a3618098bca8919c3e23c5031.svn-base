/*
 * 加油记录
 * Revised history
 * Copyright(c) 2010 FR Co.,Ltd
 */
package com.fr.station.common.entity.report;


import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fr.station.common.bean.system.StandardBean;


/**
 * 加油记录
 * 
 * @version 1.0
 * _wsq
 */
 @Entity
 @Table(name = "OPERATELOG")
public class OperatelogEntity implements StandardBean {


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
     * 接收时间
     */
     @Column(name = "`RECTIME`")
    private Timestamp rectime;

    /**
     * 终端号
     */
     @Column(name = "`POS_P`")
    private Integer posP;

    /**
     * 终端交易号
     */
     @Column(name = "`POS_TTC`")
    private Integer posTtc;

    /**
     * 交易类型 
     */
     @Column(name = "`T_TYPE`")
    private Integer tType;

    /**
     * 交易时间
     */
     @Column(name = "`STIME`")
    private Timestamp stime;

    /**
     * 卡号
     */
     @Column(name = "`ASN`")
    private String asn;

    /**
     * 余额
     */
     @Column(name = "`BAL`")
    private BigDecimal bal;

    /**
     * 金额
     */
     @Column(name = "`AMN`")
    private BigDecimal amn;

    /**
     * CTC
     */
     @Column(name = "`CTC`")
    private Integer ctc;

    /**
     * TAC
     */
     @Column(name = "`TAC`")
    private String tac;

    /**
     * GMAC
     */
     @Column(name = "`GMAC`")
    private String gmac;

    /**
     * PSAM_TAC
     */
     @Column(name = "`PSAM_TAC`")
    private String psamTac;

    /**
     * PSAM_ASN
     */
     @Column(name = "`PSAM_ASN`")
    private String psamAsn;

    /**
     * PSAM_TID
     */
     @Column(name = "`PSAM_TID`")
    private String psamTid;

    /**
     * PSAM_TTC
     */
     @Column(name = "`PSAM_TTC`")
    private Integer psamTtc;

    /**
     * 扣款来源
     */
     @Column(name = "`DS`")
    private Integer ds;

    /**
     * 单位
     */
     @Column(name = "`UNIT`")
    private Integer unit;

    /**
     * 卡类型
     */
     @Column(name = "`C_TYPE`")
    private Integer cType;

    /**
     * 版本号
     */
     @Column(name = "`VER`")
    private Integer ver;

    /**
     * 油枪号
     */
     @Column(name = "`NZN`")
    private Integer nzn;

    /**
     * 油品代码
     */
     @Column(name = "`G_CODE`")
    private String gCode;

    /**
     * 数量
     */
     @Column(name = "`VOL`")
    private BigDecimal vol;

    /**
     * 单价
     */
     @Column(name = "`PRC`")
    private BigDecimal prc;

    /**
     * 班组号
     */
     @Column(name = "`EMP`")
    private Integer emp;

    /**
     * 总累
     */
     @Column(name = "`V_TOT`")
    private BigDecimal vTot;

    /**
     * 备用
     */
     @Column(name = "`RFU`")
    private String rfu;

    /**
     * T_MAC
     */
     @Column(name = "`T_MAC`")
    private String tMac;

    /**
     * 油品名称
     */
     @Column(name = "`OILNAME`")
    private String oilname;

    /**
     * 实收金额
     */
     @Column(name = "`AMN2`")
    private BigDecimal amn2;

    /**
     * 班结号
     */
     @Column(name = "`ACCNO`")
    private String accno;

    /**
     * 班结日期
     */
     @Column(name = "`ACCDATE`")
    private Timestamp accdate;

    /**
     * 日结日期
     */
     @Column(name = "`RJRQ`")
    private String rjrq;

    /**
     * 网点号
     */
     @Column(name = "`STATIONNO`")
    private Integer stationno;

    /**
     * 记账账号（车号）
     */
     @Column(name = "`CARNO`")
    private String carno;

    /**
     * 支付类型
     */
     @Column(name = "`PAYTYPE`")
    private String paytype;

    /**
     * 备用
     */
     @Column(name = "`BZ`")
    private Integer bz;

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
     * 接收时间的取得
     *
     * @return Timestamp 接收时间
     */
    public Timestamp getRectime() {
        return rectime;
    }


    /**
     * 终端号的取得
     *
     * @return Integer 终端号
     */
    public Integer getPosP() {
        return posP;
    }


    /**
     * 终端交易号的取得
     *
     * @return Integer 终端交易号
     */
    public Integer getPosTtc() {
        return posTtc;
    }


    /**
     * 交易类型 的取得
     *
     * @return Integer 交易类型 
     */
    public Integer getTType() {
        return tType;
    }


    /**
     * 交易时间的取得
     *
     * @return Timestamp 交易时间
     */
    public Timestamp getStime() {
        return stime;
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
     * 余额的取得
     *
     * @return BigDecimal 余额
     */
    public BigDecimal getBal() {
        return bal;
    }


    /**
     * 金额的取得
     *
     * @return BigDecimal 金额
     */
    public BigDecimal getAmn() {
        return amn;
    }


    /**
     * CTC的取得
     *
     * @return Integer CTC
     */
    public Integer getCtc() {
        return ctc;
    }


    /**
     * TAC的取得
     *
     * @return String TAC
     */
    public String getTac() {
        return tac;
    }


    /**
     * GMAC的取得
     *
     * @return String GMAC
     */
    public String getGmac() {
        return gmac;
    }


    /**
     * PSAM_TAC的取得
     *
     * @return String PSAM_TAC
     */
    public String getPsamTac() {
        return psamTac;
    }


    /**
     * PSAM_ASN的取得
     *
     * @return String PSAM_ASN
     */
    public String getPsamAsn() {
        return psamAsn;
    }


    /**
     * PSAM_TID的取得
     *
     * @return String PSAM_TID
     */
    public String getPsamTid() {
        return psamTid;
    }


    /**
     * PSAM_TTC的取得
     *
     * @return Integer PSAM_TTC
     */
    public Integer getPsamTtc() {
        return psamTtc;
    }


    /**
     * 扣款来源的取得
     *
     * @return Integer 扣款来源
     */
    public Integer getDs() {
        return ds;
    }


    /**
     * 单位的取得
     *
     * @return Integer 单位
     */
    public Integer getUnit() {
        return unit;
    }


    /**
     * 卡类型的取得
     *
     * @return Integer 卡类型
     */
    public Integer getCType() {
        return cType;
    }


    /**
     * 版本号的取得
     *
     * @return Integer 版本号
     */
    public Integer getVer() {
        return ver;
    }


    /**
     * 油枪号的取得
     *
     * @return Integer 油枪号
     */
    public Integer getNzn() {
        return nzn;
    }


    /**
     * 油品代码的取得
     *
     * @return String 油品代码
     */
    public String getGCode() {
        return gCode;
    }


    /**
     * 数量的取得
     *
     * @return BigDecimal 数量
     */
    public BigDecimal getVol() {
        return vol;
    }


    /**
     * 单价的取得
     *
     * @return BigDecimal 单价
     */
    public BigDecimal getPrc() {
        return prc;
    }


    /**
     * 班组号的取得
     *
     * @return Integer 班组号
     */
    public Integer getEmp() {
        return emp;
    }


    /**
     * 总累的取得
     *
     * @return BigDecimal 总累
     */
    public BigDecimal getVTot() {
        return vTot;
    }


    /**
     * 备用的取得
     *
     * @return String 备用
     */
    public String getRfu() {
        return rfu;
    }


    /**
     * T_MAC的取得
     *
     * @return String T_MAC
     */
    public String getTMac() {
        return tMac;
    }


    /**
     * 油品名称的取得
     *
     * @return String 油品名称
     */
    public String getOilname() {
        return oilname;
    }


    /**
     * 实收金额的取得
     *
     * @return BigDecimal 实收金额
     */
    public BigDecimal getAmn2() {
        return amn2;
    }


    /**
     * 班结号的取得
     *
     * @return String 班结号
     */
    public String getAccno() {
        return accno;
    }


    /**
     * 班结日期的取得
     *
     * @return Timestamp 班结日期
     */
    public Timestamp getAccdate() {
        return accdate;
    }


    /**
     * 日结日期的取得
     *
     * @return String 日结日期
     */
    public String getRjrq() {
        return rjrq;
    }


    /**
     * 网点号的取得
     *
     * @return Integer 网点号
     */
    public Integer getStationno() {
        return stationno;
    }


    /**
     * 记账账号（车号）的取得
     *
     * @return String 记账账号（车号）
     */
    public String getCarno() {
        return carno;
    }


    /**
     * 支付类型的取得
     *
     * @return String 支付类型
     */
    public String getPaytype() {
        return paytype;
    }


    /**
     * 备用的取得
     *
     * @return Integer 备用
     */
    public Integer getBz() {
        return bz;
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
     * 接收时间的设定
     *
     * @param newTimestamp 接收时间
     */
    public void setRectime(Timestamp newRectime) {
        this.rectime = newRectime;
    }


    /**
     * 终端号的设定
     *
     * @param newInteger 终端号
     */
    public void setPosP(Integer newPosP) {
        this.posP = newPosP;
    }


    /**
     * 终端交易号的设定
     *
     * @param newInteger 终端交易号
     */
    public void setPosTtc(Integer newPosTtc) {
        this.posTtc = newPosTtc;
    }


    /**
     * 交易类型 的设定
     *
     * @param newInteger 交易类型 
     */
    public void setTType(Integer newTType) {
        this.tType = newTType;
    }


    /**
     * 交易时间的设定
     *
     * @param newTimestamp 交易时间
     */
    public void setStime(Timestamp newStime) {
        this.stime = newStime;
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
     * 余额的设定
     *
     * @param newBigDecimal 余额
     */
    public void setBal(BigDecimal newBal) {
        this.bal = newBal;
    }


    /**
     * 金额的设定
     *
     * @param newBigDecimal 金额
     */
    public void setAmn(BigDecimal newAmn) {
        this.amn = newAmn;
    }


    /**
     * CTC的设定
     *
     * @param newInteger CTC
     */
    public void setCtc(Integer newCtc) {
        this.ctc = newCtc;
    }


    /**
     * TAC的设定
     *
     * @param newString TAC
     */
    public void setTac(String newTac) {
        this.tac = newTac;
    }


    /**
     * GMAC的设定
     *
     * @param newString GMAC
     */
    public void setGmac(String newGmac) {
        this.gmac = newGmac;
    }


    /**
     * PSAM_TAC的设定
     *
     * @param newString PSAM_TAC
     */
    public void setPsamTac(String newPsamTac) {
        this.psamTac = newPsamTac;
    }


    /**
     * PSAM_ASN的设定
     *
     * @param newString PSAM_ASN
     */
    public void setPsamAsn(String newPsamAsn) {
        this.psamAsn = newPsamAsn;
    }


    /**
     * PSAM_TID的设定
     *
     * @param newString PSAM_TID
     */
    public void setPsamTid(String newPsamTid) {
        this.psamTid = newPsamTid;
    }


    /**
     * PSAM_TTC的设定
     *
     * @param newInteger PSAM_TTC
     */
    public void setPsamTtc(Integer newPsamTtc) {
        this.psamTtc = newPsamTtc;
    }


    /**
     * 扣款来源的设定
     *
     * @param newInteger 扣款来源
     */
    public void setDs(Integer newDs) {
        this.ds = newDs;
    }


    /**
     * 单位的设定
     *
     * @param newInteger 单位
     */
    public void setUnit(Integer newUnit) {
        this.unit = newUnit;
    }


    /**
     * 卡类型的设定
     *
     * @param newInteger 卡类型
     */
    public void setCType(Integer newCType) {
        this.cType = newCType;
    }


    /**
     * 版本号的设定
     *
     * @param newInteger 版本号
     */
    public void setVer(Integer newVer) {
        this.ver = newVer;
    }


    /**
     * 油枪号的设定
     *
     * @param newInteger 油枪号
     */
    public void setNzn(Integer newNzn) {
        this.nzn = newNzn;
    }


    /**
     * 油品代码的设定
     *
     * @param newString 油品代码
     */
    public void setGCode(String newGCode) {
        this.gCode = newGCode;
    }


    /**
     * 数量的设定
     *
     * @param newBigDecimal 数量
     */
    public void setVol(BigDecimal newVol) {
        this.vol = newVol;
    }


    /**
     * 单价的设定
     *
     * @param newBigDecimal 单价
     */
    public void setPrc(BigDecimal newPrc) {
        this.prc = newPrc;
    }


    /**
     * 班组号的设定
     *
     * @param newInteger 班组号
     */
    public void setEmp(Integer newEmp) {
        this.emp = newEmp;
    }


    /**
     * 总累的设定
     *
     * @param newBigDecimal 总累
     */
    public void setVTot(BigDecimal newVTot) {
        this.vTot = newVTot;
    }


    /**
     * 备用的设定
     *
     * @param newString 备用
     */
    public void setRfu(String newRfu) {
        this.rfu = newRfu;
    }


    /**
     * T_MAC的设定
     *
     * @param newString T_MAC
     */
    public void setTMac(String newTMac) {
        this.tMac = newTMac;
    }


    /**
     * 油品名称的设定
     *
     * @param newString 油品名称
     */
    public void setOilname(String newOilname) {
        this.oilname = newOilname;
    }


    /**
     * 实收金额的设定
     *
     * @param newBigDecimal 实收金额
     */
    public void setAmn2(BigDecimal newAmn2) {
        this.amn2 = newAmn2;
    }


    /**
     * 班结号的设定
     *
     * @param newString 班结号
     */
    public void setAccno(String newAccno) {
        this.accno = newAccno;
    }


    /**
     * 班结日期的设定
     *
     * @param newTimestamp 班结日期
     */
    public void setAccdate(Timestamp newAccdate) {
        this.accdate = newAccdate;
    }


    /**
     * 日结日期的设定
     *
     * @param newString 日结日期
     */
    public void setRjrq(String newRjrq) {
        this.rjrq = newRjrq;
    }


    /**
     * 网点号的设定
     *
     * @param newInteger 网点号
     */
    public void setStationno(Integer newStationno) {
        this.stationno = newStationno;
    }


    /**
     * 记账账号（车号）的设定
     *
     * @param newString 记账账号（车号）
     */
    public void setCarno(String newCarno) {
        this.carno = newCarno;
    }


    /**
     * 支付类型的设定
     *
     * @param newString 支付类型
     */
    public void setPaytype(String newPaytype) {
        this.paytype = newPaytype;
    }


    /**
     * 备用的设定
     *
     * @param newInteger 备用
     */
    public void setBz(Integer newBz) {
        this.bz = newBz;
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
