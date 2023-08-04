<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SHOES4JO | 회원 탈퇴</title>
<%@include file="header-head.jsp"%>

<style>
.simplesignup {
	border: 1px solid black;
	background-color: #ccc;
	border-radius: 10rem;
	height: 64px;
	width: 64px;
	display: inline-block;
	margin: 1rem;
	cursor: pointer;
}
</style>

<script>
    document.getElementById("deleteMemberBtn").addEventListener("click", function() {
        var confirmed = confirm("정말로 회원 정보를 삭제하시겠습니까?");
        if (!confirmed) {
            // 사용자가 취소를 선택한 경우 이전 페이지로 돌아감
            window.history.back();
            return;
        }

        // 회원 아이디를 가져옴
        var member_id = "member_id";

        deleteMember(member_id);
    });

    function deleteMember(id) {
        $.ajax({
            method: "POST",
            url: "deleteMember",
            data: { memberId: id },
            success: function(response) {
                if (response == 1) {
                    alert("회원 정보가 성공적으로 삭제되었습니다.");
                    window.location.href = "/";
                } else {
                    alert("회원 정보 삭제에 실패하였습니다.");
                }
            },
            error: function(xhr, status, error) {
                console.log("Class 호출 실패: ", status, error);
            }
        });
    }
</script>

</head>

<body>
	<%@include file="header.jsp"%>

	<div class="contents">
		<div class="container">

			<div class="form-wrapper">
				<h1>회원 탈퇴</h1>
				<form name="deleteForm" onsubmit="return delete();">
					<div class="form-button-wrapper">
						<button class="btn btn-danger" id="deleteMemberBtn" type="submit">회원 탈퇴</button>
					</div>
				</form>
				<br>
				<hr>
				<br>
			</div>

		</div>
	</div>

	<%@include file="footer.jsp"%>

</body>
</html>