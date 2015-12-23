package com.dreamcatcher.admin.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.dreamcatcher.action.Action;
import com.dreamcatcher.admin.model.StatisticsDto;
import com.dreamcatcher.admin.model.service.AdminServiceImpl;
import com.dreamcatcher.util.*;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

public class AdminSiteRankAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		
		int range = NumberCheck.nullToOne(request.getParameter("range"));
		
		if( range != 0){
		
			List<StatisticsDto> siteStatisticsList = AdminServiceImpl.getInstance().siteRankByRecommend(range);
		
			Gson gson = new Gson();
			
			JsonElement siteElement = gson.toJsonTree(siteStatisticsList);
				
			response.setContentType("text/plain; charset="+CharacterConstant.DEFAULT_CHAR);
			response.getWriter().write(siteElement.toString());
	
		}
		return null;
	}

}
