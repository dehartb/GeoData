package com.dehart.domain;

public class Constants {
	
	public static final String SQL_GET_DATA = "{call dbo.sp_GetBLSData2()}";
	public static final String SQL_GET_ITEM = "{call dbo.sp_GetBLSItems()}";
	public static final String SQL_GET_YEAR = "{call dbo.sp_GetBLSYears(?,?)}";
	public static final String SQL_GET_AREA = "{call dbo.sp_getBLSArea(?)}";

}
