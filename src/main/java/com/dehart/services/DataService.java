package com.dehart.services;

import java.util.List;

import com.dehart.domain.BLSArea;
import com.dehart.domain.BLSData;
import com.dehart.domain.BLSItem;
import com.dehart.domain.BLSYear;

public interface DataService {
	
	
	public List<BLSData> getBLSData() throws Exception;
	public List<BLSItem> getBLSItem() throws Exception;
	public List<BLSYear> getBLSYear(String itemCode, String areaCode) throws Exception;
	public List<BLSArea> getBLSArea(String itemCode) throws Exception;

}
