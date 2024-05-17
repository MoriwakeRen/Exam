<%@page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" type="text/css" href="../css/student_list.css">
<%@include file="../header.jsp"%>
<%@include file="../aside.jsp"%>

<div id="maincontent"> 
    <h2>学生管理</h2>
	<section>
		<ul>
			<li id="newregist"><a href="">新規登録</a></li>
		</ul>
	</section>
	<div id="search-container">
		<div id="row">
			<div id="col-4">
<div id="col-4">
    <form action="Filter.action" method="post">
        <label for="f1">入学年度</label><br>
        <select title="選択してください" id="f1" name="f1">
            <option selected value="0">---------</option>
            <c:forEach var="year" items="${yearlist}">
                <option value="${year.entYear}">${year.entYear}</option>
            </c:forEach>
        </select>
</div>
<div id="col-4">
    <label for="f2">クラス</label><br> 
    <select title="選択してください" id="f2" name="f2">
        <option selected value="0">---------</option>
        <c:forEach var="classnum" items="${classnumlist}">
            <option value="${classnum.classNum}">${classnum.classNum}</option>
        </c:forEach>
    </select>
</div>
<div class="student-action">
    <label for="f3"><input type="checkbox" id="f3" name="f3" value="true">在学中</label>
</div>
<input type="submit" value="絞込み" class="button">
	<c:if test="${not empty errorMessage}">
	    <div class="error">${errorMessage}</div>
	</c:if>
</form>

             </div>
		</div>
	</div>

<div class="table-container">
    <table class="table table-striped">
            <tr>
                <th scope="col">入学年度</th>
                <th scope="col">学生番号</th>
                <th scope="col">氏名</th>
                <th scope="col">クラス</th>
                <th scope="col">在学中</th>
            </tr>
            <c:forEach var="students" items="${list}">
                <tr>
                    <td>${students.entYear}</td>
                    <td>${students.no}</td>
                    <td>${students.name}</td>
                    <td>${students.classNum}</td>
                    <td>${students.isAttend ? '〇' : '×'}</td>
                    <td>
                     <section>
                      <ul>
			           <li id="change"><a href="">変更</a></li>
		              </ul>
	                 </section>
	                 <td/>

                </tr>
            </c:forEach>
     </table>
     </div>
   </div>
</div>
