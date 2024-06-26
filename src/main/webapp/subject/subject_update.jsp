<%@page contentType="text/html; charset=UTF-8" %>

<head>
    <meta charset="UTF-8">
    <title>2Test</title>
    <link rel="stylesheet" href="../css/subject_update.css">
</head>
<body>
    <header>
        <h1>得点管理システム</h1>
    </header>
    <!-- 科目表示するところ -->
    <div id="wrapper">
        <div id="main">
            <h2>科目情報変更</h2>
            <h3>科目コード</h3>
            <!-- ここに科目コードを出すような変数 -->
            <p>+科目コード出力</p>
            <form method="post" action="#">
                <p>科目名</p>
            <!-- テキストボックス入力エラーで検索すると、いろいろ出てくる -->
                <div class="search-container">
                    <input type="text" class="search-input" id="searchInput" required>
                    <label for="searchInput" class="default-text">科目名を入力してください</label>
                </div>
                
                <p><input type="submit" value="登録" id="subscribe"></p>
            </form>
        <!-- 科目管理一覧画面に戻る -->
        <h5><a href="subject_list.jsp">戻る</a></h5>
        </div>

        <!-- さいどばー -->
        <aside id="sidebar">
            <section id="side_banner">
                <ul>
                    <li class="ue"><a href="">メニュー</a></li>
                    <li class="naka"><a href="">学生管理</a></li>
                    <li>成績管理</li>
                    <li class="naka2"><a href="">成績登録</a></li>
                    <li class="naka2"><a href="">成績参照</a></li>
                    <li class="naka"><a href="">科目管理</a></li>
                </ul>
            </section>
        </aside>
    </div>
    <footer>
        <h5>ふったー</h5>
    </footer>
</body>