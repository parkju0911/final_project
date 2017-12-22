<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		var kind = "user";
		
		$("#join").click(function() {
			if(kind=="user"){
				$("#company").remove();
				$("#frm").attr("action", "./user/memberJoin")
			}else{
				$("#user").remove();
				$("#frm").attr("action", "./company/memberJoin")
			}
			$("#frm").submit();
		});
		
		$(".kind").click(function() {
			kind = $(this).val();
			if(kind=="company"){
				$("#company").css("display", "block");
				$("#user").css("display", "none")
			} else{
				$("#user").css("display", "block")
				$("#company").css("display", "none");
			}
		});
	});
</script>
<style type="text/css">
	#company {
		display: none;
	}
</style>
</head>
<body>
	<form id="frm" action="./memberJoin" method="post">
		<p>아이디 <input type="text" name="id"></p>
		<p>비밀번호 <input type="password" name="pw"></p>
		<p>이름 <input type="text" name="name"></p>
		<p>휴대전화 <input type="text" name="phone"></p>
		<p>이메일 <input type="text" name="email"></p>
		개인회원<input type="radio" class="kind" name="kind" checked="checked" value="user">
		회사회원<input type="radio" class="kind" name="kind" value="company">
		
		<!-- User -->
		<div id="user">
			<p>생일 <input type="date" name="birth"></p>
		</div>
		
		<!-- Company -->
		<div id="company">
			<p>사업자등록번호 <input type="number" name="company_num"></p>
			<p>가로 <input type="number" name="row_num"></p>
			<p>세로 <input type="number" name="col_num"></p>
		</div>
		
		<input type="button" value="JOIN" id="join">
	</form>
</body>
</html>