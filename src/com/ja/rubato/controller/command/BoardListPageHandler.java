package com.ja.rubato.controller.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ja.rubato.model.BoardDao;
import com.ja.rubato.model.MemberDao;
import com.ja.rubato.vo.BoardVo;
import com.ja.rubato.vo.ContentDataVo;
import com.ja.rubato.vo.MemberVo;

public class BoardListPageHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		
		ArrayList<ContentDataVo> contentList = new ArrayList<ContentDataVo>();
			
			ArrayList<BoardVo> boardList = new BoardDao().selectAll();
			
			MemberDao memberDao = new MemberDao();
			for (BoardVo boardVo : boardList) {
				// 포이치문 사용으로 전체 selectByNo의 메서드를 담아낸다 .
				MemberVo memberVo = memberDao.selectByNo(boardVo.getM_no());
				// 조인쿼리대신 ContentDataVo 안에 MemberVo와 BoardVo를 담아서 사용
				ContentDataVo contentDataVo = new ContentDataVo(memberVo, boardVo);
				
				contentList.add(contentDataVo);

			}
			request.setAttribute("contentList", contentList);

			return "/WEB-INF/view/board_list.jsp";
		}

}
