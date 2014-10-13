/*
 * $Id: NumberConstants.java 33525 2009-06-11 01:41:24Z xuefeng $
 * 更新履歴： yangxin 2009/07/31 新規リリース
 */


package com.fr.station.common.consts;


/**
 * 业务定義用クラス
 * @version 1.0
 * @author yangxin
 */
public interface AppConsts {

    /** 树上显示 */
    public static final int TREE_SHOW = 1;

    /** 树上不显示 */
    public static final int TREE_NOT_SHOW = 0;
    
    /** 客户状态：使用中 */
    public static final String CUSTOM_STATS_INUSE = "11";
    
    /** 客户状态：退费 */
    public static final String CUSTOM_STATS_NOINUSE = "12";
    
    /** 客户状态：注销 */
    public static final String CUSTOM_STATS_NOTHING = "13";
}
