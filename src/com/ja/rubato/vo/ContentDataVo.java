package com.ja.rubato.vo;

import com.ja.rubato.vo.BoardVo;
import com.ja.rubato.vo.MemberVo;

public class ContentDataVo {
	  private MemberVo memberVo;
      private BoardVo boardVo;
      private CommentVo commentVo;
      
      
	public ContentDataVo() {
		super();
	}



	public ContentDataVo(MemberVo memberVo, BoardVo boardVo) {
		super();
		this.memberVo = memberVo;
		this.boardVo = boardVo;
	}


	public ContentDataVo(MemberVo memberVo, CommentVo commentVo) {
		super();
		this.memberVo = memberVo;
		this.commentVo = commentVo;
	}


	public CommentVo getCommentVo() {
		return commentVo;
	}



	public void setCommentVo(CommentVo commentVo) {
		this.commentVo = commentVo;
	}



	public MemberVo getMemberVo() {
		return memberVo;
	}



	public void setMemberVo(MemberVo memberVo) {
		this.memberVo = memberVo;
	}



	public BoardVo getBoardVo() {
		return boardVo;
	}



	public void setBoardVo(BoardVo boardVo) {
		this.boardVo = boardVo;
	}
      
	
	
}
