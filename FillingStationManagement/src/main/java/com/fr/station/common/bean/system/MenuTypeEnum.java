package com.fr.station.common.bean.system;

/**
 * Column Type: represent the systemMangement, customerMangement, cardMangement, dataMangement
 * 
 */
public enum MenuTypeEnum {

	TOP_MENU("0"),
	EMPLOYEE_NAVI_MENU("1"),
	CUSTOMER_NAVI_MENU("2"),
	IC_CARD_NAVI_MENU("3"),
	DEFAULT("DEFAULT");

	private String columnName;

	private MenuTypeEnum(String columnName) {
		this.columnName = columnName;
	}

	public String getColumnName() {
		return this.columnName;
	}

	public static MenuTypeEnum getMenuTypeValue(String typeName) {

		MenuTypeEnum tableTypeEnum = null;
		
		MenuTypeEnum[] values = MenuTypeEnum.values();
		for (MenuTypeEnum tableValue : values) {
			if (tableValue.getColumnName().equals(typeName)) {
				tableTypeEnum = tableValue;
			}
		}
		return tableTypeEnum;
	}
	
}

