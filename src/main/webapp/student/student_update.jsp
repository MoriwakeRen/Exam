<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.jsp" %>
<%@include file="../aside.jsp" %>
<link rel="stylesheet" type="text/css" href="../css/student_update.css">


       <h2 class="subtitle">学生情報変更
      </h2>
<form action="StudentUpdateExecute.action">
<dt>入学年度</dt>
      <dd><input type="text" value="" readonly="readonly"></dd>
      
<dt>学生番号</dt>
      <dd><input type="text" value="" readonly="readonly"></dd>
      
      
<dt>氏名<dt>
            <dd><input type="text" value="" required></dd>
            
            
<dt>クラス<dt>
            <dd><select name ="class" id="class">
            <option value="131">131</option>
            <option value="201">201</option>
            <option value="101">101</option>
            <option value="201">201</option>
            </select></dd>
            
      在学中<input type="checkbox" name="checkbox" value="is_attend">
      
      
      
      <input type="submit" value="変更" style="background-color : #1e90ff; color : #ffffff; border : none; border-radius: 7px;">
      
      <div class=modoru2>
      <a href="../student/student_list.jsp">戻る</a>
<%@include file="../footer.jsp" %>
