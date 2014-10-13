package com.fr.station.component.card.dao;

import java.util.List;

import com.fr.station.common.bean.card.UpdateCardInfoBean;

/**
 * 卡片明细DAO
 * 
 * @author _yy
 */
public interface CardInfoDAO {

	/**
	 * 传递cardinfo数据
	 */
	public UpdateCardInfoBean getCardInfo(UpdateCardInfoBean updateCardInfoBean) throws Exception;

	/**
	 * 传递driver cardinfo数据
	 */
	public UpdateCardInfoBean getDriverCardInfo(UpdateCardInfoBean updateCardInfoBean) throws Exception;

	/**
	 * get each vice card records in order to display in the jsp page.
	 */
	public List<UpdateCardInfoBean> getViceCardsRecordsByCriteria(UpdateCardInfoBean updateCardInfoBean) throws Exception;

	/**
	 * 传递carddetail数据
	 */
	public List<UpdateCardInfoBean> getCardDetailInfo(UpdateCardInfoBean updateCardInfoBean) throws Exception;
}
