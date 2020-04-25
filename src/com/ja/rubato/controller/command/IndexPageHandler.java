package com.ja.rubato.controller.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ja.rubato.model.BoardDao;
import com.ja.rubato.vo.BoardVo;
import com.ja.rubato.vo.ContentDataVo;

public class IndexPageHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<ContentDataVo> contentList = new ArrayList<ContentDataVo>();
		
		ArrayList<BoardVo> mainList = new BoardDao().selectAll();
		
		request.setAttribute("mainList", mainList);
		
		return "/WEB-INF/view/index.jsp";
	}

}
