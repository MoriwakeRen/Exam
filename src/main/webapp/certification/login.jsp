<%@page contentType="text/html; charset=UTF-8"%>

<%@include file="../header.jsp"%>

<link rel="stylesheet" type="text/css" href="../css/login.css">

<div class="login-style">
	<form action="LoginExecute.action" method="post">
		<span class="label label-danger">${message}</span>
		<h2>ログイン</h2>
		<p>
			ID<input type="text" name="id" values="id" placeholder="半角でご入力ください" required>
		</p>
		<p>
			パスワード<input type="password" name="password" values="password" id="password"
				placeholder="20文字以内の半角英数字でご入力ください" required>
		</p>
		<div class="passwordbox">
		<input type="checkbox" name="chk_d_ps" id="chk_d_ps">
		<label>パスワードを表示</label>
		</div>
		
		<script type="text/javascript">
			var pw = document.getElementById('password');
			var pwCheck = document.getElementById('chk_d_ps');
			pwCheck.addEventListener('change', function() {
				if (pwCheck.checked) {
					pw.setAttribute('type', 'text');
				} else {
					pw.setAttribute('type', 'password');
				}
			}, false);
		</script>
		<div class="loginbutton">
		<p>
			<input type="submit" name="login" value="ログイン" class="button">
		</p>
		</div>
	</form>
</div>
<%@include file="../footer.jsp"%>
