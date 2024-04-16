<%@page contentType="text/html; charset=UTF-8"%>
<%@include file="../header.html"%>

<form action="LoginExecute.action" method="post">
<span class="label label-danger">${message}</span>
<h2>ログイン</h2>
<p>ID<input type="text" name="id" value="半角でご入力ください" required></p>
<p>パスワード<input type="text" name="password" value="20文字以内の半角英数字でご入力ください" required></p>
<input type="checkbox" name="chk_d_ps" onchange="togglePasswordVisibility()" />
	<label for="chk_d_ps">パスワードを表示</label>

	<script>
		function togglePasswordVisibility() {
			let passwordInput = document.getElementById("password");
			let showPasswordCheckbox = document.getElementById("chk_d_ps");

			if (showPasswordCheckbox.checked) {
				passwordInput.type = "text";
			} else {
				passwordInput.type = "password";
			}
		}
	</script>
<p><input type="button" name="login"></p>
</form>

<%@include file="../footer.html"%>
