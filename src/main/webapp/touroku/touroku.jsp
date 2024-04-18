<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../menu/menu.jsp"%>

<head>
</head>
<body>
<section>
<form id ="touroku">
<form method="POST" action="#">
		
	<dl>
		<dt>入学年度<dt>
		 <select name ="year" id="year">
		<dd><option value="2010">2010</option>
		<option value="2011">2011</option>
		<option value="2012">2012</option>
		<option value="2013">2013</option>
		<option value="2014">2014</option>
		<option value="2015">2015</option>
		<option value="2016">2016</option>
		<option value="2017">2017</option>
		<option value="2018">2018</option>
		<option value="2019">2019</option>
		<option value="2020">2020</option>
		<option value="2021">2021</option>
		<option value="2022">2022</option>
		<option value="2023">2023</option>
		<option value="2024">2024</option>
		<option value="2025">2025</option>
		<option value="2026">2026</option>
		<option value="2027">2027</option>
		<option value="2028">2028</option>
		<option value="2029">2029</option>
		<option value="2030">2030</option>
		</select>
		
		</dd>
		<dt>学生番号<dt>
		<dd><input type="text" value="" required>
		</dd>
		<dt>氏名<dt>
		<dd><input type="text" value="" required></dd>
		<dt>クラス<dt>
		<dd><select name ="class" id="class">
		<option value="131">131</option>
		<option value="201">201</option>
		<option value="101">101</option>
		<option value="201">201</option></dd>
		<input type="submit" value="登録して終了">
		</form> 
</section>
</body>

</html>