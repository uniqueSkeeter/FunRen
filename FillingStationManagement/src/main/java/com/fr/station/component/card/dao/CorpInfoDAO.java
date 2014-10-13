package com.fr.station.component.card.dao;

import com.fr.station.common.bean.card.UpdateCardInfoBean;

/**
 * 卡片明细DAO
 * 
 * @author _yy
 */
public interface CorpInfoDAO {

	/**
	 * 传递guest info数据
	 */
	public UpdateCardInfoBean getCorpInfo(UpdateCardInfoBean updateCardInfoBean) throws Exception;

	/**
	 * save guest info when changed
	 */
	public void saveGuestInfo(UpdateCardInfoBean updateCardInfoBean);

}
