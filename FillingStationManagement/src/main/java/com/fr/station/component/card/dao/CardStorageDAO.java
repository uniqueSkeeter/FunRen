package com.fr.station.component.card.dao;

import java.util.List;

import com.fr.station.common.bean.card.CardStorageBean;

/**
 * The interface for get Card Application records .
 * 
 * @trace FK_T_CARDINOUT.Table
 * 
 * @author hjq
 */

public interface CardStorageDAO {

	/**
	 * get each card_application records in order to display in the jsp page.
	 * 
	 * @param CardStorageBean CardInOutBean include the search criteria.
	 * 
	 * @return return list which is loaded in DB against the search criteria.
	 */
	public List<CardStorageBean> getAllCardStorageRecords(CardStorageBean cardInOutBean) throws Exception;

	/**
	 * get each card application records in order to display in the jsp page.
	 * 
	 * @param args which is retrieved in the input jsp page
	 * @param CardStorageBean CardInOutBean include the search criteria.
	 * 
	 * @return return list which is loaded in DB against the search criteria.
	 */
	public List<CardStorageBean> getCardStorageRecordsByCriteria(CardStorageBean cardInOutBean, int startPage, int number);

	public Object[] getClassNum();

	/**
	 * update FK_T_Storage when receipt status = '2'
	 * 
	 * @param args which is retrieved in the input jsp page
	 * @param CardStorageBean CardStorageBean include the search criteria.
	 * 
	 * @return card order to jsp
	 */
	public void updateCardStorage(CardStorageBean cardStorageBean);

	/**
	 * find if there are records in FK_T_Storage
	 */
	public int findRecordsInStorage(CardStorageBean cardStorageBean);
}
