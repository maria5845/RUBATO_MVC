package com.ja.rubato.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ja.rubato.model.BoardDao;

public class DeletContentProcessHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
	     int b_no = Integer.parseInt(request.getParameter("b_no"));
         new BoardDao().delete(b_no);
         
         return "redirect:./board_list_page.do";
	}

}
