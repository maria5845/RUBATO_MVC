<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head> 
<meta charset="utf-8">
<title>클래식기타 커뮤니티</title>
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="css/header.css">
<link rel="stylesheet" type="text/css" href="css/footer.css">
<link rel="stylesheet" type="text/css" href="css/board_left.css">
<link rel="stylesheet" type="text/css" href="css/board_view_main.css">
</head>
<body>
<div id="wrap">
<header>
  <a href="index.html"><img id="logo" src="img/logo.png"></a>
<nav id="top_menu">
  HOME | LOGIN | JOIN | NOTICE
</nav>
<nav id="main_menu">
  <ul>
    <li><a href="board_list_page.do">자유 게시판</a></li>
    <li><a href="#">기타 연주</a></li>
    <li><a href="#">공동 구매</a></li>
    <li><a href="#">연주회 안내</a></li>
    <li><a href="#">회원 게시판</a></li>
  </ul>
</nav>
</header> <!-- header -->
<aside>
  <jsp:include page="jsp_include.jsp"></jsp:include>
  <nav id="sub_menu">
    <ul>
      <li><a href="board_list_page.do">+ 자유 게시판</a></li>
      <li><a href="#">+ 방명록</a></li>
      <li><a href="#">+ 공지사항</a></li>
      <li><a href="#">+ 등업요청</a></li>
      <li><a href="#">+ 포토갤러리</a></li>
    </ul>
  </nav>
  <article id="sub_banner">
    <ul>
      <li><img src="img/banner1.png"></li>
      <li><img src="img/banner2.png"></li>		
      <li><img src="img/banner3.png"></li>
    </ul>	
  </article>
</aside> 

<section id="main">
  <img src="img/comm.gif">
  <h2 id="board_title">자유 게시판 </h2>
  <div id="view_title_box"> 
    <span>${contentDataVo.boardVo.b_title }</span>
    <span id="info">${contentDataVo.memberVo.m_nick} | 조회 : ${contentDatavo.boardVo.b_count } | ${contentDataVo.boardVo.b_writedate }</span>
  </div>	
  <p id="view_content">
    ${contentDataVo.boardVo.b_content }
  </p>		
  <div id="comment_box">
    <c:forEach items="${contentList2}" var="data2">
       <tr>
        <td class="col3">${data2.memberVo.m_nick }</td>
         <td class="col5">${data2.commentVo.c_content }</td>
         <td class="col4">${data2.commentVo.c_writedate }</td>
         </tr>
    </c:forEach>
  </div>
  <form action="" method="post">
    <div id="comment_box">
    <img id="title_comment" src="img/title_comment.gif">
    <textarea ></textarea>
    <img id="ok_ripple" src="img/ok_ripple.gif">
  </div>
  </form>
  <div id="buttons">
    <a href="delete_content_process.do?b_no=${contentDataVo.boardVo.b_no }"><input type="image" src="img/delete.png"></a>		
    <a href="board_list_page.do"><img src="img/list.png"></a>
    <a href="board_write_page.do"><img src="img/write.png"></a>			
  </div>
</section> <!-- section main -->
<div class="clear"></div>
<footer>
  <img id="footer_logo" src="img/footer_logo.gif">
  <ul id="address">
    <li>서울시 강남구 삼성동 1234 우 : 123-1234</li>  
    <li>TEL : 031-123-1234  Email : email@domain.com</li>
    <li>COPYRIGHT (C) 루바토 ALL RIGHTS RESERVED</li>
  </ul>
  <ul id="footer_sns">
    <li><img src="img/facebook.gif"></li>  
    <li><img src="img/blog.gif"></li>
    <li><img src="img/twitter.gif"></li>
  </ul>
</footer> <!-- footer -->
</div> <!-- wrap -->
</body>
</html>