<%@page contentType="text/html; charset=UTF-8" %>
<link rel="stylesheet" type="text/css" href="../css/aside.css">

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Servlet/JSP Samples</title>
</head>

<body>
    <!-- 科目表示するところ -->
    <div class="wrapper">
        <div class="main">
        </div>
        <!-- さいどばー -->
        <nav class="sidebar">
            <section id="side_banner">
                <ul>
                    <li class="ue"><a href="../mainmenu/menu.jsp">メニュー</a></li>
                    <li class="naka"><a href="../student/student_list.jsp">学生管理</a></li>
                    <li><label>成績管理</label></li>
                    <li class="naka2"><a href="subject_create.jsp">成績登録</a></li>
                    <li class="naka2"><a href="">成績参照</a></li>
                    <li class="naka"><a href="">科目管理</a></li>
                </ul>
            </section>
        </nav>
    </div>
    
</body>
</html>    

