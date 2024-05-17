<%@page contentType="text/html; charset=UTF-8" %>
<link rel="stylesheet" type="text/css" href="../css/menu.css">
<%@include file="../header.jsp"%>
<%@include file="../aside.jsp"%>
   <h2>メニュー</h2>
   <div class=gakuseikanri>
   	<a href="../student/StudentList.action">学生管理</a>
   </div>
   <div class=seisekikanri>成績管理
   	<a href="../certification/error.jsp">成績登録</a>
   	<a href="../certification/error.jsp">成績参照</a>
   </div>
   <div class=kamokukanri>
   	<a href="../subject/subject_list.jsp">科目管理</a>
   </div>
    
<%@include file="../footer.jsp"%>
    