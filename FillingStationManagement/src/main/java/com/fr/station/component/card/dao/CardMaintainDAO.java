package com.fr.station.component.card.dao;

import java.util.List;

import com.fr.station.common.bean.card.CardMaintainBean;

/**
 * 卡信息维护DAO
 * 
 * @author _yy
 */
public interface CardMaintainDAO {

	/**
	 * 卡维护信息
	 */
	public List<CardMaintainBean> getCardMaintainRecordsByCriteria(CardMaintainBean cardMaintainBean);

	/**
	 * 更新挂失信息
	 */
	public void updateCardLost(CardMaintainBean cardMaintainBean);

	/**
	 * 更新所有卡挂失信息
	 */
	public List<Object[]> updateAllCardLost(CardMaintainBean cardMaintainBean) throws Exception;

	/**
	 * 得到挂失卡的信息
	 */
	public List<CardMaintainBean> getCardLostInfo(CardMaintainBean cardMaintainBean) throws Exception;

	/**
	 * 更新止挂信息
	 */
	public void updateCancelLossCard(CardMaintainBean cardMaintainBean);

	/**
	 * 更新解灰信息
	 */
	public void updateUnLockCard(CardMaintainBean cardMaintainBean);

	/**
	 * 得到需要止挂的卡的信息
	 */
	public List<CardMaintainBean> getCancelLossCardInfo(CardMaintainBean cardMaintainBean) throws Exception;

	/**
	 * 得到需要解灰的卡的信息
	 */
	public List<CardMaintainBean> getUnLockCardInfo(CardMaintainBean cardMaintainBean) throws Exception;

	/**
	 * 更新修改密码
	 */
	public void updateChangePass(CardMaintainBean cardMaintainBean);

	/**
	 * 得到旧密码，检测密码
	 */
	public List<CardMaintainBean> getPassInfo(CardMaintainBean cardMaintainBean);

	/**
	 * 得到需要修改密码的卡片信息
	 */
	public List<CardMaintainBean> getChangePassInfo(CardMaintainBean cardMaintainBean) throws Exception;

	/**
	 * 得到补卡的信息
	 */
	public List<CardMaintainBean> getExistCardInfo(CardMaintainBean cardMaintainBean) throws Exception;

	/**
	 * 更新补卡
	 */
	public void updateReplaceCard(CardMaintainBean cardMaintainBean);

}
