/*
 * $Id: DateUtil.java 46730 2010-12-28 03:08:29Z wangwei $ 峏怴棜楌丗 guga 2009/07/31 怴婯儕儕乕僗
 */

package com.fr.station.common.utility;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import com.fr.station.common.consts.NumberConsts;

public final class DateUtil {

	private DateUtil() {
	}

	public static final String DATE_PATTERN_0 = "yyyyMMdd";

	public static final String DATE_PATTERN_1 = "yyyyMMddHHmmssSSS";

	public static final String DATE_PATTERN_2 = "yyyy/MM/dd";

	public static final String DATE_PATTERN_3 = "yyyy/MM/dd HH:mm:ss";

	public static final String DATE_PATTERN_4 = "yy/MM/dd";

	public static final String DATE_PATTERN_5 = "yyyy/MM/dd HH:mm:ss.SSS";

	public static final String DATE_PATTERN_6 = "yyyyMM";

	public static final String DATE_PATTERN_7 = "yyMMdd";

	public static final String DATE_PATTERN_8 = "yyyy-MM-dd HH:mm:ss.SSS";

	public static final String DATE_PATTERN_9 = "yyyy/MM/dd HH:mm";

	public static final String DATE_PATTERN_10 = "yyyy/MM";

	public static final String DATE_PATTERN_11 = "yyyyMMddHHmmss";

	public static final String DATE_PATTERN_12 = "yyyy擭MM寧dd擔";

	public static final String DATE_PATTERN_13 = "yy/MM";

	public static final String DATE_PATTERN_14 = "yy/MM/dd HH:mm:ss";

	public static final String DATE_PATTERN_15 = "yy擭MM寧dd擔";

	public static final String DATE_PATTERN_16 = "yy/MM/dd HH:mm";

	public static final String DATE_PATTERN_17 = "yyyy-MM-dd";

	public static final String DATE_PATTERN_18 = "MMM.  dd, yyyy";

	public static final String DATE_PATTERN_19 = "yyyy.MM.dd";

	public static final String DATE_PATTERN_20 = "yy.MM.dd";

	public static final String DATE_PATTERN_21 = "MMMMM dd, yyyy";

	public static final String DATE_PATTERN_22 = "yyyy-MM-dd.HH.mm.ss.SSS";

	public static final String DATE_PATTERN_23 = "MMM dd HH:mm:ss yyyy z";

	public static final String DATE_PATTERN_24 = "M/d";

	public static final String DATE_PATTERN_25 = "yyyy-MM-dd HH:mm";

	public static final Locale LOCALE_US = Locale.US;

	private static Timestamp curTimestamp = null;

	private static Map<String, String> formatMonths = new HashMap<String, String>();

	static {
		formatMonths.put("JAN. ", "01");
		formatMonths.put("FEB. ", "02");
		formatMonths.put("MARCH", "03");
		formatMonths.put("APR. ", "04");
		formatMonths.put("MAY  ", "05");
		formatMonths.put("JUNE ", "06");
		formatMonths.put("JULY ", "07");
		formatMonths.put("AUG. ", "08");
		formatMonths.put("SEPT.", "09");
		formatMonths.put("OCT. ", "10");
		formatMonths.put("NOV. ", "11");
		formatMonths.put("DEC. ", "12");
	}

	public static Map<String, String> getFormatMonths() {
		return formatMonths;
	}

	public static String formatDate(java.util.Date date, String format) {
		if (null == date) {
			return null;
		}
		SimpleDateFormat sdFromat = new SimpleDateFormat(format);
		return sdFromat.format(date);
	}

	public static String formatDate(java.util.Date date, String format, Locale locale) {
		if (null == date) {
			return null;
		}
		SimpleDateFormat sdFromat = new SimpleDateFormat(format, locale);
		return sdFromat.format(date);
	}

	public static Timestamp currentTimestamp() {
		if (null == curTimestamp) {
			return new Timestamp(System.currentTimeMillis());
		} else {
			return curTimestamp;
		}
	}

	public static String getCurrentDate(String format) {
		return formatDate(currentTimestamp(), format);
	}

	public static String addDays(String date, int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(DateUtil.toDate(date, DATE_PATTERN_17));
		calendar.add(Calendar.DATE, days);
		return DateUtil.formatDate(calendar.getTime(), DATE_PATTERN_17);
	}

	public static String addDaysPatternEight(String date, int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(DateUtil.toDate(date, DATE_PATTERN_8));
		calendar.add(Calendar.DATE, days);
		return DateUtil.formatDate(calendar.getTime(), DATE_PATTERN_8);
	}

	public static String addDays(String date, int days, String pattern) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(DateUtil.toDate(date, pattern));
		calendar.add(Calendar.DATE, days);
		return DateUtil.formatDate(calendar.getTime(), pattern);
	}

	public static Timestamp addDays(Timestamp date, int days) {
		if (null != date) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.DATE, days);
			return new Timestamp(calendar.getTime().getTime());
		} else {
			return null;
		}
	}

	public static Date toDate(String date, String format) {
		if (StringUtil.isEmpty(date)) {
			return null;
		}
		try {
			return new SimpleDateFormat(format).parse(date);
		} catch (ParseException e) {
			return null;
		}
	}

	public static Timestamp formatStrTOStampBySmt(String dateStr, String smft) {
		if (StringUtil.isEmpty(dateStr) || StringUtil.isEmpty(smft)) {
			return null;
		}
		Timestamp rs = null;
		try {
			SimpleDateFormat formatter = new SimpleDateFormat(smft);
			rs = new Timestamp(formatter.parse(dateStr).getTime());
			return rs;
		} catch (ParseException e) {
			return null;
		}
	}

	public static Timestamp formatGMTStrTOStampBySmt(String gmtStr, String smft) {
		if (StringUtil.isEmpty(gmtStr) || StringUtil.isEmpty(smft)) {
			return null;
		}
		Timestamp rs = null;
		try {
			Timestamp sysDate = DateUtil.currentTimestamp();
			Calendar c = Calendar.getInstance();
			c.setTime(sysDate);
			int offset = Calendar.getInstance().getTimeZone().getRawOffset();
			SimpleDateFormat formatter = new SimpleDateFormat(smft, LOCALE_US);
			rs = new Timestamp(formatter.parse(gmtStr).getTime() - offset);
			return rs;
		} catch (ParseException e) {
			return null;
		}
	}

	public static String formatDateYYYYMM(String strDateYYYYMM) {

		if (StringUtil.isEmpty(strDateYYYYMM)) {
			return StringUtil.BLANK;
		}
		if (strDateYYYYMM.trim().length() == NumberConsts.NUM_6) {
			String yyyy = strDateYYYYMM.substring(NumberConsts.NUM_0, NumberConsts.NUM_4);
			String mm = strDateYYYYMM.substring(NumberConsts.NUM_4);
			return yyyy + StringUtil.OBLIQUELINE + mm;
		}
		return strDateYYYYMM;
	}

	public static String formatDateYYMM(String strDateYYYYMM) {

		if (StringUtil.isEmpty(strDateYYYYMM)) {
			return StringUtil.BLANK;
		}
		if (strDateYYYYMM.trim().length() == NumberConsts.NUM_6) {
			String yyyy = strDateYYYYMM.substring(NumberConsts.NUM_2, NumberConsts.NUM_4);
			String mm = strDateYYYYMM.substring(NumberConsts.NUM_4);
			return yyyy + StringUtil.OBLIQUELINE + mm;
		}
		return strDateYYYYMM;
	}

	public static String formatDate(Timestamp date, String format) {

		if (null == date) {
			return null;
		}
		SimpleDateFormat sdFromat = new SimpleDateFormat(format);
		return sdFromat.format(date);
	}

	public static Date getAddMonthEnday(Date dt, int iMonth) {
		if (null != dt) {
			Calendar c = Calendar.getInstance();
			c.setTime(dt);
			c.add(Calendar.MONTH, iMonth + 1);
			c.set(Calendar.DATE, 1);
			c.add(Calendar.DAY_OF_MONTH, -1);
			return new Date(c.getTime().getTime());
		} else {
			return null;
		}
	}

	public static Date getAddDay(Date dt, int iDay) {
		if (null != dt) {
			Calendar c = Calendar.getInstance();
			c.setTime(dt);
			c.add(Calendar.DAY_OF_YEAR, iDay);
			return new Date(c.getTime().getTime());
		} else {
			return null;
		}
	}

	public static Date getAddMonth(Date dt, int iMonth) {
		if (null != dt) {
			Calendar c = Calendar.getInstance();
			c.setTime(dt);
			c.add(Calendar.MONTH, iMonth);
			return new Date(c.getTime().getTime());
		} else {
			return null;
		}
	}

	public static Date getAddYear(Date dt, int iYear) {
		if (null != dt) {
			Calendar c = Calendar.getInstance();
			c.setTime(dt);
			c.add(Calendar.YEAR, iYear);
			return new Date(c.getTime().getTime());
		} else {
			return null;
		}
	}

	public static String addMonth(String date, int months) {
		if (StringUtil.isEmpty(date)) {
			return StringUtil.BLANK;
		}

		try {

			SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_PATTERN_6);

			Calendar calendar = dateFormat.getCalendar();
			calendar.setTime(dateFormat.parse(date));

			calendar.add(Calendar.MONTH, months);
			return dateFormat.format(calendar.getTime()).substring(NumberConsts.NUM_0, NumberConsts.NUM_6);

		} catch (ParseException ex) {
			return StringUtil.BLANK;
		}
	}

	public static String formatDateYYYYMMDD(String strDateYYYYMMDD) {

		if (StringUtil.isEmpty(strDateYYYYMMDD)) {
			return StringUtil.BLANK;
		}
		if (strDateYYYYMMDD.trim().length() == NumberConsts.NUM_10) {
			String yyyy = strDateYYYYMMDD.substring(NumberConsts.NUM_0, NumberConsts.NUM_4);
			String mm = strDateYYYYMMDD.substring(NumberConsts.NUM_5, NumberConsts.NUM_7);
			String dd = strDateYYYYMMDD.substring(NumberConsts.NUM_8);
			return yyyy + mm + dd;
		}
		return strDateYYYYMMDD;
	}

	public static String formatDateYMD(String strYMD) {

		if (StringUtil.isEmpty(strYMD)) {
			return StringUtil.BLANK;
		}
		if (strYMD.trim().length() == NumberConsts.NUM_8) {
			String yyyy = strYMD.substring(NumberConsts.NUM_0, NumberConsts.NUM_4);
			String mm = strYMD.substring(NumberConsts.NUM_4, NumberConsts.NUM_6);
			String dd = strYMD.substring(NumberConsts.NUM_6, NumberConsts.NUM_8);
			return yyyy + StringUtil.OBLIQUELINE + mm + StringUtil.OBLIQUELINE + dd;
		}
		return strYMD;
	}

	public static String formatDateYYYY_MM_DD(String strYMD) {

		if (StringUtil.isEmpty(strYMD)) {
			return StringUtil.BLANK;
		}
		if (strYMD.trim().length() == NumberConsts.NUM_19) {
			String yyyy = strYMD.substring(NumberConsts.NUM_0, NumberConsts.NUM_4);
			String mm = strYMD.substring(NumberConsts.NUM_5, NumberConsts.NUM_7);
			String dd = strYMD.substring(NumberConsts.NUM_8, NumberConsts.NUM_10);
			return yyyy + StringUtil.HAIFUN + mm + StringUtil.HAIFUN + dd;
		}
		return strYMD;
	}

	public static String formatDateYYYY_MM_DD_HH_MM(String strYMD) {

		if (StringUtil.isEmpty(strYMD)) {
			return StringUtil.BLANK;
		}
		if (strYMD.trim().length() == NumberConsts.NUM_19) {
			String yyyy = strYMD.substring(NumberConsts.NUM_0, NumberConsts.NUM_4);
			String mm = strYMD.substring(NumberConsts.NUM_5, NumberConsts.NUM_7);
			String dd = strYMD.substring(NumberConsts.NUM_8, NumberConsts.NUM_10);
			String hh = strYMD.substring(NumberConsts.NUM_11, NumberConsts.NUM_13);
			String mi = strYMD.substring(NumberConsts.NUM_14, NumberConsts.NUM_16);
			return yyyy + StringUtil.HAIFUN + mm + StringUtil.HAIFUN + dd + " " + hh + StringUtil.COLON + mi;
		}
		return strYMD;
	}

	public static Date formatDateDeleteHMS(java.util.Date date) {
		if (null == date) {
			return null;
		}
		return toDate(formatDate(date, DATE_PATTERN_2), DATE_PATTERN_2);
	}

}
