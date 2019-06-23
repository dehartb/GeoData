package com.dehart.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.dehart.domain.BLSArea;
import com.dehart.domain.BLSData;
import com.dehart.domain.BLSItem;
import com.dehart.domain.BLSYear;
import com.dehart.domain.Constants;

public class BLSDAO {
	
	private final static Logger logger = Logger.getLogger(BLSDAO.class);
	
	//@Resource(name="DataDS")
	@Autowired
	private DataSource dataSource;
	
	public DataSource getDataSource() {
		return dataSource;
	}

	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}


	public List<BLSData> getBlsData() throws SQLException {
		logger.info("Getting BLS Data");
		Connection conn = null;
		CallableStatement stmt = null;
		ResultSet rs = null;
		List<BLSData> blsData = new ArrayList<BLSData>();
		
		try {
			conn = dataSource.getConnection();
			stmt = conn.prepareCall(Constants.SQL_GET_DATA);
			logger.info("Opened connection");
			
			//Protection against lack of SET NOCOUNT
			boolean bResults = stmt.execute();
//			int iRows = 0;
			
			logger.info("executed the statment");
//			while(bResults || iRows != -1) {
//				if(bResults) {
//					logger.info("executed the statment1");
//					rs = stmt.getResultSet();
//					logger.info("executed the statment2");
//				} else {
//					logger.info("executed the statment3");
//					iRows = stmt.getUpdateCount();
//					logger.info("executed the statment4");
//				}
//				logger.info("executed the statment5");
//				bResults = stmt.getMoreResults();
//				logger.info("executed the statment6");
//			}
			
			if(bResults)
				rs = stmt.getResultSet();
			
			logger.info("extracting the results");
			//Get the results
			while(rs!= null && rs.next()) {
				BLSData temp = new BLSData();
				temp.setAreaCode(rs.getString("AreaCode"));
				temp.setAreaName(rs.getString("AreaName"));
				temp.setBeginPeriod(rs.getString("BeginPeriod"));
				temp.setBeginYear(rs.getString("BeginYear"));
				temp.setEndPeriod(rs.getString("EndPeriod"));
				temp.setEndYear(rs.getString("EndYear"));
				temp.setItemCode(rs.getString("ItemCode"));
				temp.setItemName(rs.getString("ItemName"));
				temp.setSeriesId(rs.getString("SeriesId"));
				temp.setSeriesTitle(rs.getString("SeriesTitle"));
				temp.setYear(rs.getString("Year"));
				temp.setValue(rs.getString("Value"));
				temp.setPeriod(rs.getString("Period"));
				
				blsData.add(temp);
			}
			
			//Return results
			logger.info("returning with: " + blsData.size() + " results");
			return blsData;

		} catch (Exception e) {
			logger.error(e);
			throw new SQLException(e);
			
		} finally {
			//Close all connections
			if(rs != null && !rs.isClosed())
				rs.close();
			if(stmt != null && !stmt.isClosed())
				stmt.close();
			if(conn != null && !conn.isClosed())
				conn.close();
		}		
	}
	

	public List<BLSItem> getBlsItem() throws SQLException {
		logger.info("Getting BLS BLSItem");
		Connection conn = null;
		CallableStatement stmt = null;
		ResultSet rs = null;
		List<BLSItem> blsItem = new ArrayList<BLSItem>();
		
		try {
			conn = dataSource.getConnection();
			stmt = conn.prepareCall(Constants.SQL_GET_ITEM);
			logger.info("Opened connection");
			
			//Protection against lack of SET NOCOUNT
			boolean bResults = stmt.execute();
//			int iRows = 0;
			
			logger.info("executed the statment");
//			while(bResults || iRows != -1) {
//				if(bResults) {
//					logger.info("executed the statment1");
//					rs = stmt.getResultSet();
//					logger.info("executed the statment2");
//				} else {
//					logger.info("executed the statment3");
//					iRows = stmt.getUpdateCount();
//					logger.info("executed the statment4");
//				}
//				logger.info("executed the statment5");
//				bResults = stmt.getMoreResults();
//				logger.info("executed the statment6");
//			}
			
			if(bResults)
				rs = stmt.getResultSet();
			
			logger.info("extracting the results");
			//Get the results
			while(rs!= null && rs.next()) {
				BLSItem temp = new BLSItem();
				temp.setItemCode(rs.getString("ItemCode"));
				temp.setItemName(rs.getString("ItemName"));
				
				blsItem.add(temp);
			}
			
			//Return results
			logger.info("returning with: " + blsItem.size() + " results");
			return blsItem;

		} catch (Exception e) {
			logger.error(e);
			throw new SQLException(e);
			
		} finally {
			//Close all connections
			if(rs != null && !rs.isClosed())
				rs.close();
			if(stmt != null && !stmt.isClosed())
				stmt.close();
			if(conn != null && !conn.isClosed())
				conn.close();
		}		
	}
	
	public List<BLSYear> getBlsYear(String itemCode, String areaCode) throws SQLException {
		logger.info("Getting BLS BLSYear");
		Connection conn = null;
		CallableStatement stmt = null;
		ResultSet rs = null;
		List<BLSYear> blsYear = new ArrayList<BLSYear>();
		
		try {
			conn = dataSource.getConnection();
			stmt = conn.prepareCall(Constants.SQL_GET_YEAR);
			logger.info("Opened connection");
			
			stmt.setString("ItemCodeParm", itemCode);
			stmt.setString("AreaCodeParm", areaCode);
			
			//Protection against lack of SET NOCOUNT
			boolean bResults = stmt.execute();
//			int iRows = 0;
			
			logger.info("executed the statment");
//			while(bResults || iRows != -1) {
//				if(bResults) {
//					logger.info("executed the statment1");
//					rs = stmt.getResultSet();
//					logger.info("executed the statment2");
//				} else {
//					logger.info("executed the statment3");
//					iRows = stmt.getUpdateCount();
//					logger.info("executed the statment4");
//				}
//				logger.info("executed the statment5");
//				bResults = stmt.getMoreResults();
//				logger.info("executed the statment6");
//			}
			
			if(bResults)
				rs = stmt.getResultSet();
			
			logger.info("extracting the results");
			//Get the results
			while(rs!= null && rs.next()) {
				BLSYear temp = new BLSYear();
				temp.setYearId(rs.getString("YearId"));
				temp.setYear(rs.getString("Year"));
				
				blsYear.add(temp);
			}
			
			//Return results
			logger.info("returning with: " + blsYear.size() + " results");
			return blsYear;

		} catch (Exception e) {
			logger.error(e);
			throw new SQLException(e);
			
		} finally {
			//Close all connections
			if(rs != null && !rs.isClosed())
				rs.close();
			if(stmt != null && !stmt.isClosed())
				stmt.close();
			if(conn != null && !conn.isClosed())
				conn.close();
		}		
	}
	
	public List<BLSArea> getBlsArea(String itemCode) throws SQLException {
		logger.info("Getting BLS BLSArea");
		Connection conn = null;
		CallableStatement stmt = null;
		ResultSet rs = null;
		List<BLSArea> blsArea = new ArrayList<BLSArea>();
		
		try {
			conn = dataSource.getConnection();
			stmt = conn.prepareCall(Constants.SQL_GET_AREA);
			logger.info("Opened connection");
			
			stmt.setString("ItemCodeParm", itemCode);
			
			//Protection against lack of SET NOCOUNT
			boolean bResults = stmt.execute();
//			int iRows = 0;
			
			logger.info("executed the statment");
//			while(bResults || iRows != -1) {
//				if(bResults) {
//					logger.info("executed the statment1");
//					rs = stmt.getResultSet();
//					logger.info("executed the statment2");
//				} else {
//					logger.info("executed the statment3");
//					iRows = stmt.getUpdateCount();
//					logger.info("executed the statment4");
//				}
//				logger.info("executed the statment5");
//				bResults = stmt.getMoreResults();
//				logger.info("executed the statment6");
//			}
			
			if(bResults)
				rs = stmt.getResultSet();
			
			logger.info("extracting the results");
			//Get the results
			while(rs!= null && rs.next()) {
				BLSArea temp = new BLSArea();
				temp.setAreaCode(rs.getString("AreaCode"));
				temp.setAreaName(rs.getString("AreaName"));
				
				blsArea.add(temp);
			}
			
			//Return results
			logger.info("returning with: " + blsArea.size() + " results");
			return blsArea;

		} catch (Exception e) {
			logger.error(e);
			throw new SQLException(e);
			
		} finally {
			//Close all connections
			if(rs != null && !rs.isClosed())
				rs.close();
			if(stmt != null && !stmt.isClosed())
				stmt.close();
			if(conn != null && !conn.isClosed())
				conn.close();
		}		
	}
}
