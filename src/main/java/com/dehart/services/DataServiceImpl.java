package com.dehart.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dehart.controller.BaseController;
import com.dehart.dao.BLSDAO;
import com.dehart.domain.BLSArea;
import com.dehart.domain.BLSData;
import com.dehart.domain.BLSItem;
import com.dehart.domain.BLSYear;

@Service("dataService")
public class DataServiceImpl implements DataService {
	
	private final static Logger logger = Logger.getLogger(BaseController.class);
	
	@Autowired
	private BLSDAO blsDAO;
	
	public void init() throws Exception {
		logger.info("DataService has be initialized");
	}
	
	public List<BLSData> getBLSData() throws Exception {
		logger.info("get blsData");
		List<BLSData> blsData = new ArrayList<BLSData>();
		try {
			blsData.addAll(blsDAO.getBlsData());
		} catch (SQLException e) {
			logger.error(e);
		}
		
		logger.info("returning with: " + blsData.size() + " results");
		return blsData;
	}
	
	public List<BLSItem> getBLSItem() throws Exception {
		logger.info("get blsItem");
		List<BLSItem> blsItem = new ArrayList<BLSItem>();
		try {
			blsItem.addAll(blsDAO.getBlsItem());
		} catch (SQLException e) {
			logger.error(e);
		}
		
		logger.info("returning with: " + blsItem.size() + " results");
		return blsItem;
	}
	
	public List<BLSYear> getBLSYear(String itemCode, String areaCode) throws Exception {
		logger.info("get blsYear");
		List<BLSYear> blsYear = new ArrayList<BLSYear>();
		try {
			blsYear.addAll(blsDAO.getBlsYear(itemCode, areaCode));
		} catch (SQLException e) {
			logger.error(e);
		}
		
		logger.info("returning with: " + blsYear.size() + " results");
		return blsYear;
	}
	
	public List<BLSArea> getBLSArea(String itemCode) throws Exception {
		logger.info("get blsYear");
		List<BLSArea> blsArea = new ArrayList<BLSArea>();
		try {
			blsArea.addAll(blsDAO.getBlsArea(itemCode));
		} catch (SQLException e) {
			logger.error(e);
		}
		
		logger.info("returning with: " + blsArea.size() + " results");
		return blsArea;
	}

}
