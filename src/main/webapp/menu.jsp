<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html"%>
    <header>
        <h1>得点管理システム</h1>
    </header>
    <!-- 科目表示するところ -->
    <div id="wrapper">
        <div id="main">
        </div>
        <!-- さいどばー -->
        <aside id="sidebar">
            <section id="side_banner">
                <ul>
                    <li class="ue"><a href="menu.jsp">メニュー</a></li>
                    <li class="naka"><a href="student_list.jsp">学生管理</a></li>
                    <li>成績管理</li>
                    <li class="naka2"><a href="subject_create.jsp">成績登録</a></li>
                    <li class="naka2"><a href="">成績参照</a></li>
                    <li class="naka"><a href="">科目管理</a></li>
                </ul>
            </section>
        </aside>
    </div>
    
<%@include file="../footer.html"%>
    