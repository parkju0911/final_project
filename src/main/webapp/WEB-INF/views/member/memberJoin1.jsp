<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		var kind = "user";

		$("#join").click(function() {
			if (job == "user") {
				$("#company").remove();
				$("#frm").attr("action", "./user/memberJoin")
			} else {
				$("#user").remove();
				$("#frm").attr("action", "./company/memberJoin")
			}
			$("#frm").submit();
		});

		$(".kind").click(function() {
			job = $(this).val();
			if (kind == "company") {
				$("#company").css("display", "block");
				$("#user").css("display", "none")
			} else {
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
	<form
		action="https://timeticket.co.kr:46392/happy_member.php?mode=joinus_reg"
		target="regist_frame" method="post" name="happy_member_reg"
		onsubmit="return happyMemberCheckForm(this);"
		enctype="multipart/form-data">
		<input type="hidden" name="id_check" value="input"> <input
			type="hidden" name="nick_check" value="input"> <input
			type="hidden" name="blank_3" value=""> <input type="hidden"
			name="group" value="1"> <input type="hidden"
			name="iso_hphone" value="">
		<!--
<div style="text-align:center; font-size:28px; font-weight:300; padding:20px 0 0 0;">
	합리적인 문화생활, 타임티켓과 함께하세요!
</div>
-->
		<div style="width: 700px; margin: 20px auto; padding: 30px 70px; border: 1px solid #e8e8e8; background: #fff; text-align: center;">
			<!-- 타이틀 영역-->
			<div>
				<div style="float: left; text-align: left;">
					<span style="font-size: 24px; font-weight: 400;">타임티켓 회원가입</span>
				</div>
				<div
					style="font-size: 13px; font-weight: 300; text-align: right; padding-top: 15px; vertical-align: bottom;">
					* 필수 입력항목 (아이디/비밀번호는 4자 이상 입력해주세요)</div>
				<div style="border-top: 1px solid #e8e8e8; width: 100%; margin-top: 10px;"></div>
			</div>
			<!-- 타이틀 영역 끝-->
			<div alt="입력필드" style="padding: 20px; overflow: hidden;">
				<div class="o">▼ 기본정보(필수)</div>
				<div>
					<div style="text-align: left; padding: 15px 0; clear: both; vertical-align: middle; height: 35px;">
						<div style="float: left; font-size: 16px; font-weight: 500; width: 170px;">아이디*</div>
						<div style="float: left; font-size: 16px; font-weight: 300;">
							<input type="text" name="user_id" value="" class="member_txt"
								onkeyup="startRequest(this)"
								onfocus="startRequest(this);happyShowLayer_nick_check()"
								onblur="happyCloseLayer_nice_check()" hname="아이디*" required="">
							<div id="id_check_msg"></div>
						</div>
						<div style="text-align: left; padding: 15px 0; clear: both; vertical-align: middle; height: 35px;">
							<div style="float: left; font-size: 16px; font-weight: 500; width: 170px;">비밀번호*</div>
							<div style="float: left; font-size: 16px; font-weight: 300;">
								<input type="password" name="user_pass" value=""
									class="member_txt" size="20" hname="비밀번호*" required="">
							</div>
							<div style="text-align: left; padding: 15px 0; clear: both; vertical-align: middle; height: 35px;">
								<div
									style="float: left; font-size: 16px; font-weight: 500; width: 170px;">비밀번호
									확인*</div>
								<div style="float: left; font-size: 16px; font-weight: 300;">
									<input type="password" name="user_pass2" value=""
										class="member_txt" size="20" hname="비밀번호확인*" required="">
								</div>
								<div style="text-align: left; padding: 15px 0; clear: both; vertical-align: middle; height: 35px;">
									<div style="float: left; font-size: 16px; font-weight: 500; width: 170px;">이름*</div>
									<div style="float: left; font-size: 16px; font-weight: 300;">
										<input type="text" name="user_name" value=""
											class="member_txt" size="10" hname="이름*" required="">
									</div>
									<div
										style="text-align: left; padding: 15px 0; clear: both; vertical-align: middle; height: 35px;">
										<div
											style="float: left; font-size: 16px; font-weight: 500; width: 170px;">
											<br>
											<span class="o">▼ 부가정보(선택)</span>
										</div>
										<div style="float: left; font-size: 16px; font-weight: 300;">
										</div>
										<div
											style="text-align: left; padding: 15px 0; clear: both; vertical-align: middle; height: 35px;">
											<div
												style="float: left; font-size: 16px; font-weight: 500; width: 170px;">성별</div>
											<div style="float: left; font-size: 16px; font-weight: 300;">
												<input type="radio" id="user_prefix_0" name="user_prefix"
													value="man" class="member_radio"> <label
													for="user_prefix_0" style="cursor: hand">남성</label> &nbsp;<input
													type="radio" id="user_prefix_1" name="user_prefix"
													value="girl" class="member_radio"> <label
													for="user_prefix_1" style="cursor: hand">여성</label> &nbsp;
											</div>
											<div
												style="text-align: left; padding: 15px 0; clear: both; vertical-align: middle; height: 35px;">

												<div
													style="float: left; font-size: 16px; font-weight: 500; width: 170px;">이메일</div>

												<div style="float: left; font-size: 16px; font-weight: 300;">
													<input onkeyup="email_input_check()" type="text"
														name="user_email" value="" class="member_txt"><span
														style="font-size: 14px; color: #777; padding-left: 10px;">아이디/비밀번호
														찾기에 필요합니다.</span>

												</div>
												<div style="text-align: left; padding: 15px 0; clear: both; vertical-align: middle; height: 35px;">
													<div style="float: left; font-size: 16px; font-weight: 500; width: 170px;">휴대폰</div>
													<div style="float: left; font-size: 16px; font-weight: 300;">
														<input type="tel" name="user_hphone" value=""
															id="user_hphone" maxlength="13" class="member_txt"
															onkeypress="if( (event.keyCode<48) || (event.keyCode>57) ) event.returnValue=false;">
														<span style="font-size: 14px; color: #777; padding-left: 10px;">숫자만 입력해 주세요.</span>
													</div>
													<div style="text-align: left; padding: 15px 0; clear: both; vertical-align: middle; height: 35px;">
														<div style="float: left; font-size: 16px; font-weight: 500; width: 170px;">푸시알림(앱)</div>
														<div style="float: left; font-size: 16px; font-weight: 300;">
															<input type="radio" id="message_0" name="message" value="y" class="member_radio">
															<label for="message_0" style="cursor: hand">수신</label> &nbsp;
															<input type="radio" id="message_1" name="message" value="n" class="member_radio">
															<label for="message_1" style="cursor: hand">거부</label> &nbsp;
														</div>
														<div style="text-align: left; padding: 15px 0; clear: both; vertical-align: middle; height: 35px;">
															<div style="float: left; font-size: 16px; font-weight: 500; width: 170px;">이메일수신</div>
															<div style="float: left; font-size: 16px; font-weight: 300;">
																<input type="checkbox" id="email_forwarding_0" name="email_forwarding[]" value="y" class="member_radio" checked="">
																<label for="email_forwarding_0" style="cursor: hand">동의</label>&nbsp;
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<table cellspacing="0" cellpadding="0" width="85%" border="1"
						bordercolor="#dcdcdc" style="border-collapse: collapse;">
					</table>

				</div>
			</div>

			<div style="border-top: 1px solid #e8e8e8; width: 100%;"></div>

			<div
				style="padding-top: 30px; text-align: center; font-size: 14px; font-weight: 300; color: #333;">
				* 예매관련 정보는 수신동의 여부와 관계없이 SMS/이메일로 발송됩니다.<br> * 오타나 잘못된 정보를 입력할
				경우 티켓이용이 불가할 수 있으니 주의해주세요.<br> * 푸시알림은 앱을 설치한 경우 수신 가능하며,
				이벤트/기획전/특가할인 정보가 제공됩니다.<br>
			</div>
			<div alt="약관동의" style="padding-top: 30px;">
				<div style="font-size: 16px; color: #555; font-weight: 300;">
					<input type="checkbox" name="chkok" value="약관동의"
						style="vertical-align: middle; height: 18px; width: 18px;">
					<a
						href="html_file.php?file1=default_company.html&amp;file2=user_stipulation.html"
						target="_blank"
						style="padding-left: 3px; color: #ed3d84; font-weight: 500; text-decoration: underline;">회원이용약관</a>
					및 <a
						href="html_file.php?file1=default_company.html&amp;file2=user_private.html"
						target="_blank"
						style="color: #ed3d84; font-weight: 500; text-decoration: underline;">개인정보
						수집/이용</a>에 대해 동의합니다.
				</div>
			</div>
			<div alt="가입버튼" style="text-align: center; margin: 40px 0 40px 0;">
				<button
					style="width: 300px; height: 55px; border: none; background: #ee5b96; color: #fff; font-size: 18px; font-weight: 400; margin-top: 15px;">가입완료</button>
			</div>
		</div>
		
		<script>
// 휴대폰 번호 자동 하이픈(-) 스크립트
function autoHypenPhone(str){
		str = str.replace(/[^0-9]/g, '');
		var tmp = '';
		if( str.length < 4){
			return str;
		}else if(str.length < 8){
			tmp += str.substr(0, 3);
			tmp += '-';
			tmp += str.substr(3);
			return tmp;
		}else if(str.length < 12){
			tmp += str.substr(0, 3);
			tmp += '-';
			tmp += str.substr(3, 4);
			tmp += '-';
			tmp += str.substr(7);
			return tmp;
		}
		return str;
	}
var cellPhone = document.getElementById('user_hphone');
cellPhone.onkeyup = function(event){
		event = event || window.event;
		var _val = this.value.trim();
		this.value = autoHypenPhone(_val) ;
}
// 휴대폰 번호 자동 하이픈(-) 스크립트 END
</script>

	</form>
</body>
</html>