package com.fr.station.component.card.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.QueryException;
import org.springframework.stereotype.Repository;

import com.fr.station.common.bean.card.UpdateCardInfoBean;
import com.fr.station.common.consts.SqlConsts;
import com.fr.station.common.data.ApplicationContext;
import com.fr.station.common.entity.card.CardEntity;
import com.fr.station.common.utility.DateUtil;
import com.fr.station.common.utility.ErrorLogUtil;
import com.fr.station.common.utility.StringUtil;
import com.fr.station.component.card.dao.CardInfoDAO;
import com.fr.station.component.system.dao.AbstractBaseDAO;

/**
 * 卡片明细的DAO的实现
 * 
 * @author _yy
 */
@Repository
public class CardInfoDaoImpl extends AbstractBaseDAO<CardEntity> implements CardInfoDAO {

	// ------- Constants (static final) ----------------------------------------
	private static Logger log = Logger.getLogger(CardInfoDaoImpl.class);

	// ------- Static Variables (static) ---------------------------------------

	private static final String CARD_NO = "cardNo";

	private static final String STATION_NO = "stationNo";

	private static final String GUEST_CARD_NO = "guest.cardNo";

	private static final String GUEST_GUEST_NO = "guest.guestNo";

	private static final String CARD_GUEST_NO = "card.guestNo";

	private static final String CARD_CARD_NO = "card.cardNo";

	private static final String CARDTZ_CARD_NO = "cardtz.cardNo";

	private static final String GUEST_STATION_NO = "guest.stationno";

	private static final String CARD_FALG = "cardFlag";

	private static final String NOT = "N";

	private static final String CARD_GUEST_NAME = "card.guestname";

	private static final String CARD_GUEST_TYPE = "card.guesttype";

	private static final String CARD_GUEST_NUM = "card.guestnum";

	private static final String CARD_STATION_NO = "card.stationno";

	private static final String CARDACC_CARD_NO = "cardAcc.cardNo";

	private static final String CARD_GUEST_TEL = "card.guestTel";

	// 获得主卡下所有副卡信息

	private final String selectViceCardsListSql = "select card.guestName, card.cardNo, card.cardStatus,guest.guestNo,cardTZ.pre,card.cardFlag,guest.cardno,card.id, (SELECT guestdep.depName from FK_T_GUESTDEP guestdep where guestdep.depno = card.depno) as depName from FK_T_GUEST guest,"
			+ " FK_T_CARD card, FK_T_CardTZ cardTZ  where ";

	// 获得副卡数量
	private final String selectAllCountViceCardsListSql = "select count(*) from FK_T_GUEST guest, FK_T_CARD card, FK_T_CardTZ cardTZ  where ";

	// ------- Instance Variables (private) ------------------------------------
	/**
	 * 查询卡片信息SQL
	 */
	private final String getCardInfoHql = "FROM CardEntity WHERE  ";

	/**
	 * 查询卡片明细SQL
	 */
	private final String getCardDetailSql = "SELECT card.cardNo,card.guestName ,card.guesttel,card.guestType,card.guestNum,card.guestpost,card.email,card.guestAdd,card.cardType,card.cardStatus,card.cardExno,cardAcc.cardBal,cardAcc.score,cardAcc.create_date,cardAcc.update_date,card.xoil,card.xvol,card.xcount,card.xamn,card.xcarno,card.xeare,cardAcc.pre FROM FK_T_CARD card,"
			+ "FK_T_CARDTZ cardAcc WHERE  ";

	// ------- Constructors ----------------------------------------------------

	public CardInfoDaoImpl() {
		super();
	}

	// ------- Instance Methods (public) ---------------------------------------

	/**
	 * 得到个人卡片的内容
	 */
	@Override
	public UpdateCardInfoBean getCardInfo(UpdateCardInfoBean updateCardInfoBean) throws Exception {
		UpdateCardInfoBean resultCardBean = null;
		try {
			// retrieve search value from client request.
			StringBuilder builder = this.validateInputCardCriteria(updateCardInfoBean);
			CardEntity cardEntity = null;
			// 执行查询语句
			List<CardEntity> cardEntityList = this.findByHql(this.getCardInfoHql + builder);
			if (cardEntityList.size() > 0) {
				cardEntity = cardEntityList.get(0);
			}
			// get result list.
			resultCardBean = this.convertDataToBean(cardEntity);
		} catch (QueryException e) {
			log.info("Sql is not correct, please check it again, more detail please see the detail log" + e.getMessage() + "\n"
					+ ErrorLogUtil.printInfo(e));
		} catch (Exception e) {
			log.info("Get card detail info occured error, more detail please see the detail log" + e.getMessage() + "\n"
					+ ErrorLogUtil.printInfo(e));
		}
		return resultCardBean;
	}

	/**
	 * Inherited java doc
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<UpdateCardInfoBean> getViceCardsRecordsByCriteria(UpdateCardInfoBean updateCardInfoBean) throws Exception {
		List<UpdateCardInfoBean> resultList = null;
		try {
			// retrieve search value from client request.
			StringBuilder builder1 = this.validateInputCriteria(updateCardInfoBean);
			StringBuilder builder2 = this.validateInputCountCriteria(updateCardInfoBean);
			// retrieve current query by input sql.
			Query query = this.createSpecifiedQuery(builder1, this.selectViceCardsListSql);

			// get total records by specified sql.
			int totalSize = this.getTotalCount(builder2, this.selectAllCountViceCardsListSql);

			// this is for pagination.
			this.setPaginationNumber(updateCardInfoBean, query);

			// get result list.
			List<Object[]> result = query.list();

			resultList = this.convertDataToBean(result, totalSize);

		} catch (QueryException e) {
			log.info("Sql is not correct, please check it again, more detail please see the detail log" + e.getMessage() + "\n"
					+ ErrorLogUtil.printInfo(e));
		} catch (Exception e) {
			log.info("Get DB data occured error, more detail please see the detail log" + e.getMessage() + "\n"
					+ ErrorLogUtil.printInfo(e));
		}
		return resultList;

	}

	/**
	 * 得到司机卡的内容
	 */

	@Override
	public UpdateCardInfoBean getDriverCardInfo(UpdateCardInfoBean updateCardInfoBean) throws Exception {
		UpdateCardInfoBean resultCardBean = null;
		try { // retrieve search value from client request. StringBuilder builder =
			  // retrieve search value from client request.
			StringBuilder builder = this.validateInputDriverCardCriteria(updateCardInfoBean);
			CardEntity cardEntity = null;
			// 执行查询语句
			List<CardEntity> cardEntityList = this.findByHql(this.getCardInfoHql + builder);
			if (cardEntityList.size() > 0) {
				cardEntity = cardEntityList.get(0);
			}
			// get result list.
			resultCardBean = this.convertDataToBean(cardEntity);
		} catch (QueryException e) {
			log.info("Sql is not correct, please check it again, more detail please see the detail log" + e.getMessage() + "\n"
					+ ErrorLogUtil.printInfo(e));
		} catch (Exception e) {
			log.info("Get card detail info occured error, more detail please see the detail log" + e.getMessage() + "\n"
					+ ErrorLogUtil.printInfo(e));
		}
		return resultCardBean;
	}

	// ------- Instance Methods (private) --------------------------------------

	/**
	 * 增加SQL判断条件
	 */
	private StringBuilder validateInputCardCriteria(UpdateCardInfoBean updateCardInfoBean) {
		StringBuilder builder = new StringBuilder();
		// FK_T_CARD,FK_T_GUEST,FK_T_CARDTZ,FK_T_GUESTACC表关联
		// FK_T_CARD,FK_T_GUEST通过客户编号guestNo关联，FK_T_CARD，FK_T_CARDTZ通过card的ID关联
		// FK_T_GUEST,FK_T_GUESTACC通过客户编号guestNo关联
		builder.append(STATION_NO).append(SqlConsts.EQUAL)
				.append(Integer.valueOf(ApplicationContext.getInstance().getStationNum()));
		if (StringUtils.isNotEmpty(updateCardInfoBean.getCardNo())) {
			builder.append(SqlConsts.ADD).append(CARD_NO).append(SqlConsts.EQUAL).append(SqlConsts.SINGLE_QUOTES)
					.append(updateCardInfoBean.getCardNo()).append(SqlConsts.SINGLE_QUOTES).append(SqlConsts.ADD)
					.append(CARD_FALG).append(SqlConsts.EQUAL).append(SqlConsts.SINGLE_QUOTES).append(NOT)
					.append(SqlConsts.SINGLE_QUOTES);
		}
		return builder;
	}

	private StringBuilder validateInputDriverCardCriteria(UpdateCardInfoBean updateCardInfoBean) {
		StringBuilder builder = new StringBuilder();
		if (updateCardInfoBean.getId() != null) {
			builder.append("id").append(SqlConsts.EQUAL).append(SqlConsts.SINGLE_QUOTES).append(updateCardInfoBean.getId())
					.append(SqlConsts.SINGLE_QUOTES);
		}
		return builder;
	}

	/**
	 * 
	 * 为获得副卡信息构建where条件
	 * 
	 * @param UpdateCardInfoBean updateCardInfoBean
	 * @return StringBuilder
	 */

	private StringBuilder validateInputCriteria(UpdateCardInfoBean updateCardInfoBean) {
		StringBuilder builder = new StringBuilder();
		builder.append(GUEST_STATION_NO).append(SqlConsts.EQUAL)
				.append(Integer.valueOf(ApplicationContext.getInstance().getStationNum())).append(SqlConsts.ADD)
				.append(GUEST_GUEST_NO).append(SqlConsts.EQUAL).append(CARD_GUEST_NO).append(SqlConsts.ADD)
				.append(CARD_CARD_NO).append(SqlConsts.EQUAL).append(CARDTZ_CARD_NO);
		if (StringUtil.isNotEmpty(updateCardInfoBean.getMainCardNo())) {
			builder.append(SqlConsts.ADD).append(GUEST_CARD_NO).append(SqlConsts.EQUAL).append(SqlConsts.SINGLE_QUOTES)
					.append(updateCardInfoBean.getMainCardNo()).append(SqlConsts.SINGLE_QUOTES);
		}
		builder.append("  ORDER BY card.cardFlag desc,card.cardno,depno ");
		return builder;
	}

	private StringBuilder validateInputCountCriteria(UpdateCardInfoBean updateCardInfoBean) {
		StringBuilder builder = new StringBuilder();
		builder.append(GUEST_STATION_NO).append(SqlConsts.EQUAL)
				.append(Integer.valueOf(ApplicationContext.getInstance().getStationNum())).append(SqlConsts.ADD)
				.append(GUEST_GUEST_NO).append(SqlConsts.EQUAL).append(CARD_GUEST_NO).append(SqlConsts.ADD)
				.append(CARD_CARD_NO).append(SqlConsts.EQUAL).append(CARDTZ_CARD_NO);
		if (StringUtil.isNotEmpty(updateCardInfoBean.getMainCardNo())) {
			builder.append(SqlConsts.ADD).append(GUEST_CARD_NO).append(SqlConsts.EQUAL).append(SqlConsts.SINGLE_QUOTES)
					.append(updateCardInfoBean.getMainCardNo()).append(SqlConsts.SINGLE_QUOTES);
		}
		return builder;
	}

	/**
	 * list 得到卡片明细的内容
	 */
	@Override
	public List<UpdateCardInfoBean> getCardDetailInfo(UpdateCardInfoBean updateCardInfoBean) throws Exception {
		List<UpdateCardInfoBean> resultList = null;
		try {
			// retrieve search value from client request.
			StringBuilder builder = this.validateInputDetailCardCriteria(updateCardInfoBean);

			// retrieve current query by input sql.
			Query query = this.createSpecifiedQuery(builder, this.getCardDetailSql);

			// get result list.
			List<Object[]> result = query.list();

			resultList = this.convertDetailDataToBean(result);
		} catch (QueryException e) {
			log.info("Sql is not correct, please check it again, more detail please see the detail log" + e.getMessage() + "\n"
					+ ErrorLogUtil.printInfo(e));
		} catch (Exception e) {
			log.info("Get card detail info occured error, more detail please see the detail log" + e.getMessage() + "\n"
					+ ErrorLogUtil.printInfo(e));
		}
		return resultList;
	}

	/**
	 * 增加SQL判断条件
	 */
	private StringBuilder validateInputDetailCardCriteria(UpdateCardInfoBean updateCardInfoBean) {
		StringBuilder builder = new StringBuilder();
		// FK_T_CARD,FK_T_GUEST,FK_T_CARDTZ,FK_T_GUESTACC表关联
		// FK_T_CARD,FK_T_GUEST通过客户编号guestNo关联，FK_T_CARD，FK_T_CARDTZ通过card的ID关联
		// FK_T_GUEST,FK_T_GUESTACC通过客户编号guestNo关联
		builder.append(CARD_STATION_NO).append(SqlConsts.EQUAL)
				.append(Integer.valueOf(ApplicationContext.getInstance().getStationNum()));
		builder.append(SqlConsts.ADD).append(CARDACC_CARD_NO).append(SqlConsts.EQUAL).append(CARD_CARD_NO);
		if (StringUtils.isNotEmpty(updateCardInfoBean.getCardNo())) {
			builder.append(SqlConsts.ADD).append(CARD_CARD_NO).append(SqlConsts.EQUAL).append(SqlConsts.SINGLE_QUOTES)
					.append(updateCardInfoBean.getCardNo()).append(SqlConsts.SINGLE_QUOTES);
		} else if (StringUtils.isNotEmpty(updateCardInfoBean.getGuestTel())) {
			builder.append(SqlConsts.ADD).append(CARD_GUEST_TEL).append(SqlConsts.EQUAL).append(SqlConsts.SINGLE_QUOTES)
					.append(updateCardInfoBean.getGuestTel()).append(SqlConsts.SINGLE_QUOTES);
		} else if (StringUtils.isNotEmpty(updateCardInfoBean.getGuestName())) {
			builder.append(SqlConsts.ADD).append(CARD_GUEST_NAME).append(SqlConsts.EQUAL).append(SqlConsts.SINGLE_QUOTES)
					.append(updateCardInfoBean.getGuestName()).append(SqlConsts.SINGLE_QUOTES);
		} else if (StringUtils.isNotEmpty(updateCardInfoBean.getGuestType())
				&& StringUtils.isNotEmpty(updateCardInfoBean.getGuestNum())) {
			builder.append(SqlConsts.ADD).append(CARD_GUEST_TYPE).append(SqlConsts.EQUAL).append(SqlConsts.SINGLE_QUOTES)
					.append(updateCardInfoBean.getGuestType()).append(SqlConsts.SINGLE_QUOTES);
			builder.append(SqlConsts.ADD).append(CARD_GUEST_NUM).append(SqlConsts.EQUAL).append(SqlConsts.SINGLE_QUOTES)
					.append(updateCardInfoBean.getGuestNum()).append(SqlConsts.SINGLE_QUOTES);
		}
		return builder;
	}

	/**
	 * 将data转换为bean
	 */
	private List<UpdateCardInfoBean> convertDetailDataToBean(List<Object[]> dataResult) {
		List<UpdateCardInfoBean> updateCardInfoBeanList = new ArrayList<UpdateCardInfoBean>();
		UpdateCardInfoBean updateCardInfoBean = null;
		for (Object[] dataRow : dataResult) {
			updateCardInfoBean = new UpdateCardInfoBean();
			if (dataRow[0] != null) {
				updateCardInfoBean.setCardNo(String.valueOf(dataRow[0]));
			}
			if (dataRow[1] != null) {
				updateCardInfoBean.setGuestName(String.valueOf(dataRow[1]));
			}
			if (dataRow[2] != null) {
				updateCardInfoBean.setGuestTel(String.valueOf(dataRow[2]));
			}
			if (dataRow[3] != null) {
				updateCardInfoBean.setGuestType(String.valueOf(dataRow[3]));
			}
			if (dataRow[4] != null) {
				updateCardInfoBean.setGuestNum(String.valueOf(dataRow[4]));
			}
			if (dataRow[5] != null) {
				updateCardInfoBean.setZipCode(String.valueOf(dataRow[5]));
			}
			if (dataRow[6] != null) {
				updateCardInfoBean.setEmail(String.valueOf(dataRow[6]));
			}
			if (dataRow[7] != null) {
				updateCardInfoBean.setGuestAdd(String.valueOf(dataRow[7]));
			}
			if (dataRow[8] != null) {
				updateCardInfoBean.setCardType(String.valueOf(dataRow[8]));
			}
			if (dataRow[9] != null) {
				updateCardInfoBean.setCardStatus(String.valueOf(dataRow[9]));
			}
			if (dataRow[10] != null) {
				updateCardInfoBean.setPrintNumber(String.valueOf(dataRow[10]));
			}
			if (dataRow[11] != null) {
				updateCardInfoBean.setCardAmount((BigDecimal) (dataRow[11]));
			}
			if (dataRow[12] != null) {
				updateCardInfoBean.setScore(String.valueOf(dataRow[12]));
			}
			if (dataRow[13] != null) {
				updateCardInfoBean.setCreateDate(String.valueOf(dataRow[13]).substring(0, 10));
			}
			if (dataRow[14] != null) {
				updateCardInfoBean.setUpdateDate(String.valueOf(dataRow[14]).substring(0, 10));
			}
			if (dataRow[15] != null) {
				updateCardInfoBean.setOilTypeLimit(String.valueOf(dataRow[15]));
			}
			if (dataRow[16] != null) {
				updateCardInfoBean.setRefuelLimit(String.valueOf(dataRow[16]));
			}
			if (dataRow[17] != null) {
				updateCardInfoBean.setRefuelTimes(String.valueOf(dataRow[17]));
			}
			if (dataRow[18] != null) {
				updateCardInfoBean.setConsumeAmount(String.valueOf(dataRow[18]));
			}
			if (dataRow[19] != null) {
				updateCardInfoBean.setCarNoConstr(String.valueOf(dataRow[19]));
			}
			if (dataRow[20] != null) {
				String[] strs = (String.valueOf(dataRow[20])).split(", ");
				updateCardInfoBean.setStationInfoLimit(Arrays.asList(strs));
			}
			if (dataRow[21] != null) {
				updateCardInfoBean.setPre((BigDecimal) (dataRow[21]));
			}
			updateCardInfoBeanList.add(updateCardInfoBean);
		}
		return updateCardInfoBeanList;
	}

	/**
	 * 将entity转换为bean
	 */
	private UpdateCardInfoBean convertDataToBean(CardEntity cardEntity) {
		UpdateCardInfoBean updateCardInfoBean = null;
		// temporary save the card cash
		ApplicationContext.getInstance().setCardEntity(cardEntity);
		if (cardEntity != null) {
			updateCardInfoBean = new UpdateCardInfoBean();
			if (cardEntity.getCardno() != null) {
				updateCardInfoBean.setCardNo(cardEntity.getCardno());
			}
			if (cardEntity.getCardtype() != null) {
				updateCardInfoBean.setCardType(cardEntity.getCardtype());
			}
			if (cardEntity.getDeposit() != null) {
				updateCardInfoBean.setDeposit(cardEntity.getDeposit());
			}
			if (cardEntity.getEnddate() != null) {
				updateCardInfoBean.setDisEffectiveDate(String.valueOf(cardEntity.getEnddate()));
			}
			if (cardEntity.getCardstatus() != null) {
				updateCardInfoBean.setCardStatus(cardEntity.getCardstatus());
			}
			if (cardEntity.getGuestname() != null) {
				updateCardInfoBean.setGuestName(cardEntity.getGuestname());
			}
			if (cardEntity.getGuesttype() != null) {
				updateCardInfoBean.setGuestType(cardEntity.getGuesttype());
			}
			if (cardEntity.getGuestnum() != null) {
				updateCardInfoBean.setGuestNum(cardEntity.getGuestnum());
			}
			if (cardEntity.getGuesttel() != null) {
				updateCardInfoBean.setGuestTel(cardEntity.getGuesttel());
			}
			if (cardEntity.getGender() != null) {
				updateCardInfoBean.setGender(cardEntity.getGender());
			}
			if (cardEntity.getEmail() != null) {
				updateCardInfoBean.setEmail(cardEntity.getEmail());
			}
			if (cardEntity.getGuestpost() != null) {
				updateCardInfoBean.setZipCode(cardEntity.getGuestpost());
			}
			if (cardEntity.getGuestadd() != null) {
				updateCardInfoBean.setCustomerAddr(cardEntity.getGuestadd());
			}
			if (cardEntity.getCreateDate() != null) {
				updateCardInfoBean.setCreateDate(DateUtil.formatDate(cardEntity.getCreateDate(), DateUtil.DATE_PATTERN_17));
			}
			if (cardEntity.getBz() != null) {
				updateCardInfoBean.setRemark(cardEntity.getBz());
			}
			if (cardEntity.isPassFlag()) {
				updateCardInfoBean.setPassFlag("Y");
			} else {
				updateCardInfoBean.setPassFlag("N");
			}
			if (cardEntity.getXcarno() != null) {
				updateCardInfoBean.setCarNoConstr(cardEntity.getXcarno());
			}
			if (cardEntity.getXcount() != null) {
				updateCardInfoBean.setRefuelTimes(cardEntity.getXcount());
			}
			if (cardEntity.getXamn() != null) {
				updateCardInfoBean.setConsumeAmount(cardEntity.getXamn());
			}
			if (cardEntity.getXvol() != null) {
				updateCardInfoBean.setRefuelLimit(cardEntity.getXvol());
			}
			if (cardEntity.getXoil() != null) {
				updateCardInfoBean.setOilTypeLimit(cardEntity.getXoil());
			}
			if (cardEntity.getBillType() != null) {
				updateCardInfoBean.setBillType(cardEntity.getBillType());
			}
			if (cardEntity.getXeare() != null) {
				String[] strs = cardEntity.getXeare().split(", ");
				updateCardInfoBean.setStationInfoLimit(Arrays.asList(strs));
			}
			if (cardEntity.getId() != null) {
				updateCardInfoBean.setId(Integer.valueOf(cardEntity.getId()));
			}
		}

		return updateCardInfoBean;
	}

	/**
	 * 
	 * 将查询到的副卡信息放入javabean中
	 * 
	 * @param dataResult
	 * @return UpdateCardInfoBean 的 List
	 */

	private List<UpdateCardInfoBean> convertDataToBean(List<Object[]> dataResult, int totalAccount) {
		List<UpdateCardInfoBean> updateCardInfoBeanList = new ArrayList<UpdateCardInfoBean>();
		UpdateCardInfoBean updateCardInfoBean = null;
		for (Object[] dataRow : dataResult) {
			updateCardInfoBean = new UpdateCardInfoBean();
			updateCardInfoBean.setGuestName(String.valueOf(dataRow[0]));
			updateCardInfoBean.setCardNo(String.valueOf(dataRow[1]));
			updateCardInfoBean.setCardStatus(String.valueOf(dataRow[2]));
			updateCardInfoBean.setGuestNo(String.valueOf(dataRow[3]));
			updateCardInfoBean.setProvisionAccount(String.valueOf(dataRow[4]));
			updateCardInfoBean.setCardFlag(String.valueOf(dataRow[5]));
			updateCardInfoBean.setMainCardNo(String.valueOf(dataRow[6]));
			updateCardInfoBean.setId(Integer.valueOf(String.valueOf(dataRow[7])));
			updateCardInfoBean.setDepName(String.valueOf(dataRow[8]));
			updateCardInfoBean.setTotalData(totalAccount);
			updateCardInfoBeanList.add(updateCardInfoBean);
		}
		return updateCardInfoBeanList;
	}

	private void setPaginationNumber(UpdateCardInfoBean updateCardInfoBean, Query query) {
		query.setFirstResult(updateCardInfoBean.getStartNumber());
		query.setMaxResults(updateCardInfoBean.getTotalNumber());
	}

	private int getTotalCount(StringBuilder builder, String sql) throws Exception {
		List<?> dataResultList = this.findBySql(new StringBuilder().append(sql).append(builder).toString());
		if (dataResultList.size() > 0) {
			return (int) dataResultList.toArray()[0] + 1;
		}
		return 0;
	}

	private Query createSpecifiedQuery(StringBuilder builder, String sql) throws Exception {
		return this.getQueryByCriteria(new StringBuilder().append(sql).append(builder).toString());
	}

	// ------- Static Methods --------------------------------------------------

	// ------- Optional Inner Class ------------------------------------------

}
