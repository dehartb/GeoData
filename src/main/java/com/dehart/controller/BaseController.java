package com.dehart.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dehart.domain.BLSArea;
import com.dehart.domain.BLSData;
import com.dehart.domain.BLSItem;
import com.dehart.domain.BLSYear;
import com.dehart.services.DataServiceImpl;

@Controller
public class BaseController {

	@Autowired
	private DataServiceImpl dataService;
	
	
	private static int counter = 0;
	private static final String VIEW_INDEX = "index";
	private final static Logger logger = Logger.getLogger(BaseController.class);

	@RequestMapping(value = "/base", method = RequestMethod.GET)
	public String welcome(ModelMap model) {

		model.addAttribute("message", "Welcome");
		model.addAttribute("counter", ++counter);
		logger.info("[welcome] counter : " + counter + " ");

		// Spring uses InternalResourceViewResolver and return back index.jsp
		return VIEW_INDEX;

	}
	
	@RequestMapping(value = "/base/{name}", method = RequestMethod.GET)
	public String welcomeName(@PathVariable String name, ModelMap model) {

		model.addAttribute("message", "Welcome " + name);
		model.addAttribute("counter", ++counter);
		logger.info("[welcome] counter : " + counter + " ");

		// Spring uses InternalResourceViewResolver and return back index.jsp
		return VIEW_INDEX;

	}

	@RequestMapping(value = "/staticPage", method = RequestMethod.GET)
   	public String redirect() {
      	return "redirect:/pages/final.html";
   	}
	
	@RequestMapping(value = "/getData", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public List<BLSData> getData(HttpServletRequest request, HttpServletResponse response) {

		logger.info("[welcome] counter : " + counter + " ");
		
		List<BLSData> blsData = new ArrayList<BLSData>();
		try {
			blsData.addAll(dataService.getBLSData());
			logger.info("Received " + blsData.size());
		} catch (Exception e) {
			logger.error(e);
		}

		return blsData;

	}
	
	
	@RequestMapping(value = "/getItems", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public List<BLSItem> getItems(HttpServletRequest request, HttpServletResponse response) {

		logger.info("[welcome] counter : " + counter + " ");
		
		List<BLSItem> blsItem = new ArrayList<BLSItem>();
		try {
			blsItem.addAll(dataService.getBLSItem());
			logger.info("Received " + blsItem.size());
		} catch (Exception e) {
			logger.error(e);
		}

		return blsItem;

	}
	
	@RequestMapping(value = "/getYears/{itemCode}/{areaCode}", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public List<BLSYear> getYears(HttpServletRequest request, HttpServletResponse response,
			@PathVariable String itemCode, @PathVariable String areaCode) {

		logger.info("[welcome] counter : " + counter + " ");
		
		List<BLSYear> blsYear = new ArrayList<BLSYear>();
		try {
			blsYear.addAll(dataService.getBLSYear(itemCode, areaCode));
			logger.info("Received " + blsYear.size());
		} catch (Exception e) {
			logger.error(e);
		}

		return blsYear;

	}
	
	@RequestMapping(value = "/getAreas/{itemCode}", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public List<BLSArea> getAreas(HttpServletRequest request, HttpServletResponse response,
			@PathVariable String itemCode) {

		logger.info("[welcome] counter : " + counter + " ");
		
		List<BLSArea> blsArea = new ArrayList<BLSArea>();
		try {
			blsArea.addAll(dataService.getBLSArea(itemCode));
			logger.info("Received " + blsArea.size());
		} catch (Exception e) {
			logger.error(e);
		}

		return blsArea;

	}

}