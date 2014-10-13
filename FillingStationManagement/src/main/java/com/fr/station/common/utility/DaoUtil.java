/*
 * $Id: StringUtil.java 46931 2011-01-13 04:14:42Z guyj $
 * 更新履歴： guga 2009/07/31 新規リリース
 */


package com.fr.station.common.utility;


import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;


/**
 * dao的共同函数
 * @version 1.0
 * @author guga
 */
public final class DaoUtil {

    /**
     * 投影集合的取得
     * @param strArr 字段投影
     * @return 投影集合
     */
    public static ProjectionList getProjectionList(String... strArr) {
        ProjectionList pList = Projections.projectionList();
        if (strArr == null || strArr.length == 0) {
            return pList;
        }
        for (String str : strArr) {
            pList.add(Projections.property(str).as(str));
        }

        return pList;
    }
}
