package com.jeya.springmvc.springspeccustom;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class DayOfWeekBasedAccessInterceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// if this method returns true ==> application will further handle the request
		// if false ==> application will not further handle the request

		Calendar cal = Calendar.getInstance();
		int dayOfWeek = cal.get(cal.DAY_OF_WEEK); // getting the day on which request is made
		
		if(dayOfWeek == 1) // 1 - Sunday, 2 - Monday, 3 - Tuesday .... 7 - Saturday
		{
			response.getWriter().write("The Website is closed on Sunday; please try accessing it on any other week day!!");
			return false;
		}
		return true;
	}
}