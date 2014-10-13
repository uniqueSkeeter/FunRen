/*
 * 对客户进行的一览基本信息进行管理和维护 
 * 提供检索、导出功能。衔接交费、发卡、编辑、预分配等功能实现
 * 更新履历： guyj 2014/05/26 新规作成
 */


package com.fr.station.component.customer.service;


import java.sql.Timestamp;
import java.util.List;

import com.fr.station.common.bean.customer.CustomBean;
import com.fr.station.common.entity.card.FkTGuestEntity;
import com.fr.station.component.system.service.BaseService;


/**
 * 客户管理一览
 * @author guyejun
 * @version 1.0
 */
@SuppressWarnings("rawtypes")
public interface CustomService extends BaseService {

    /**
     * 获取客户一览信息
     * @param userType 检索条件_用户类型
     * @param idcardType 检索条件_联系人证件类型
     * @param idcardNum 检索条件_联系人证件编号
     * @param stats 检索条件_状态
     * @param beginDate 检索条件_开始时间
     * @param endDate 检索条件_结束时间
     * @return 客户一览信息
     */
    public List<FkTGuestEntity> getCustomInfo(String userType, String idcardType,
        String idcardNum, String stats, Timestamp beginDate, Timestamp endDate);

    /**
     * 客户注册登录
     * @param fkTGuest 客户信息
     */
    public boolean saveOrUpdateCustom(CustomBean fkTGuest);

    /**
     * 客户情报取得
     * @param customId 客户ID
     * @return 客户情报
     */
    public CustomBean getCustomInfoById(String customId);

    /**
     * 金额支付
     * @param customId 客户Id
     * @param money 交费金额
     * @return 成功失败
     */
    public boolean customPayMoney(String customId, String money);
}
