package com.ja.rubato.controller.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ja.rubato.model.BoardDao;
import com.ja.rubato.model.CommentDao;
import com.ja.rubato.model.MemberDao;
import com.ja.rubato.vo.BoardVo;
import com.ja.rubato.vo.CommentVo;
import com.ja.rubato.vo.ContentDataVo;
import com.ja.rubato.vo.MemberVo;

public class BoardViewPageHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
	      
		int b_no = Integer.parseInt(request.getParameter("b_no")); 
           
		   BoardVo boardVo =new BoardDao().selectByNo(b_no);
          
           MemberVo memberVo =new MemberDao().selectByNo(boardVo.getM_no());
           
           System.out.println(memberVo);
           
           new BoardDao().updateViewCount(b_no);
           
           ContentDataVo contentDataVo = new ContentDataVo(memberVo, boardVo);
           
           request.setAttribute("contentDataVo", contentDataVo);
           
           
           
 //---- 댓글 리스트 불러오기 
           
           ArrayList<ContentDataVo> contentList = new ArrayList<ContentDataVo>();
           ArrayList<CommentVo> commentList = new CommentDao().select(b_no);
           MemberDao memberDao = new MemberDao();
           for (CommentVo commentVo : commentList ) {
			     memberVo = memberDao.selectByNo(commentVo.getM_no());
			    contentDataVo = new ContentDataVo(memberVo, commentVo);
			    contentList.add(contentDataVo);
			}
			request.setAttribute("contentList2", contentList);
			return "/WEB-INF/view/board_view.jsp";
	}

}
