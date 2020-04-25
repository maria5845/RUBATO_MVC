package com.ja.rubato.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardWritePageHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {

		if(request.getSession().getAttribute("sessionUserInfo") == null) {
			
			return "/WEB-INF/view/login_necessary.jsp";
		}
	
		return "/WEB-INF/view/board_write.jsp";
		
		
		
		
	}

}
