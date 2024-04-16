<%@page contentType="text/html; charset=UTF-8"%>
<%@include file="../header.html"%>

<form action="LoginExecute.action" method="post">
<span class="label label-danger">${message}</span>
<h2>ログイン</h2>
<p>ID<input type="text" name="id" placeholder="半角でご入力ください" required></p>
<p>パスワード<input type="password" name="password" id="password" placeholder="20文字以内の半角英数字でご入力ください" required></p>
<input type="checkbox" name="chk_d_ps" id="chk_d_ps">パスワードを表示

<script type="text/javascript">
var pw = document.getElementById('password');
var pwCheck = document.getElementById('chk_d_ps');
pwCheck.addEventListener('change', function() {
    if(pwCheck.checked) {
        pw.setAttribute('type', 'text');
    } else {
        pw.setAttribute('type', 'password');
    }
}, false);
</script>

<p><input type="button" name="login" value="ログイン"></p>
</form>

<%@include file="../footer.html"%>
