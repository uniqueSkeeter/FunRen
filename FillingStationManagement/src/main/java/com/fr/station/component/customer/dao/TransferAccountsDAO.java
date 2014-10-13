package com.fr.station.component.customer.dao;

import java.util.List;

import com.fr.station.common.bean.customer.TransferAccountsBean;

public interface TransferAccountsDAO {

	/**
	 * get each vice card records in order to display in the jsp page.
	 * 
	 * @param args which is retrieved in the input jsp page
	 * @param TransferAccountsBean transferAccountsBean include the search criteria.
	 * 
	 * @return return list which is loaded in DB against the search criteria.
	 */
	public List<TransferAccountsBean> getViceCardsRecordsByCriteria(TransferAccountsBean transferAccountsBean);

	/**
	 * get each account records in order to display in the jsp page.
	 * 
	 * @param args which is retrieved in the input jsp page
	 * @param TransferAccountsBean transferAccountsBean include the search criteria.
	 * 
	 * @return return list which is loaded in DB against the search criteria.
	 */
	public List<TransferAccountsBean> getAccountsInfoByCriteria(TransferAccountsBean transferAccountsBean);

	/**
	 * 
	 * get class num
	 */
	public Object[] getClassNum();

	/**
	 * 当进行账户分配时从页面获取金额，更新FK_T_CardTZ和FK_T_GUESTACC两张表，增加FK_T_CardTZ表中的pre,增加FK_T_GUESTACC表中的inuse,减少FK_T_GUESTACC表中的bal
	 * 
	 * @param TransferAccountsBean transferAccountsBean
	 * @return void
	 */
	public void updateAccounts(TransferAccountsBean transferAccountsBean);

	/**
	 * 当进行账户分配时从页面获取金额，更新FK_T_CardTZ和FK_T_GUESTACC两张表，减少FK_T_CardTZ表中的pre,增加FK_T_GUESTACC表中的bal
	 * 
	 * @param TransferAccountsBean transferAccountsBean
	 * @return void
	 */
	public void updateAccountsForGather(TransferAccountsBean transferAccountsBean);

	/**
	 * 当进行圈存时从页面获取金额，更新FK_T_CardTZ，减少FK_T_CardTZ表中的pre,增加cardbal
	 * 
	 * @param TransferAccountsBean transferAccountsBean
	 * @return void
	 */
	public void updateAccountsForCreditForLoad(TransferAccountsBean transferAccountsBean);

	/**
	 * 当进行分配时获得单据编号
	 * 
	 * @param void
	 * @return Integer
	 */
	public Integer getBillNo();

	/**
	 * 更新单据编号
	 * 
	 * @param void
	 * @return Integer
	 */
	public void updateBillNo();

	/**
	 * 当进行汇总时获得交易序号
	 * 
	 * @param void
	 * @return Integer
	 */
	public Integer getTradeNo();

	/**
	 * 更新交易序号
	 * 
	 * @param void
	 * @return Integer
	 */
	public void updateTradeNo();

}
