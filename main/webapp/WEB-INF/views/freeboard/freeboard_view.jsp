<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>${freeboard.title.length() > 10 ? freeboard.title.substring(0, 10).concat("...") : freeboard.title} | SHOES4JO</title>
<%@ include file="../common/header-head.jsp"%>
<style>
.form-wrapper {
	max-width: 768px;
}

.table {
	vertical-align: middle;
}

.thumb img {
	width: 100%;
	max-width: 500px;
	margin: 2rem 0;
}

table td:nth-child(1) {
	width: 20%;
	font-weight: bold;
}

table td:nth-child(2) {
	text-align: left;
}

.line {
	background: linear-gradient(60deg, #6ECCAF 0%, #ADE792 30%, #ADE792 50%, #E9FFC2 90%, #FDFFAE 100%);
	height: 3px;
	margin: 1rem 0;
}
</style>
<script>
        function checkDelete(fno) {
            var remove = confirm("글을 삭제하시겠습니까?");
            if (remove) {
                location.href = '<%=context%>/freeboard/delete.do?fno=' + fno;
            }
        }
    </script>
</head>

<body>
	<%@ include file="../common/header.jsp"%>
	<div class="container">
		<div class="form-wrapper">
			<div style="display: flex; justify-content: space-evenly;">
				<a href="<%=context%>/freeboard/list.do?category=${freeboard.category}"
					style="font-size: 1.2rem;"><b>${freeboard.category}</b></a>
			</div>
			<p style="font-size: 2.2rem; margin-top: 1.5rem; font-weight: 500;">${freeboard.title}</p>
			<div style="display: flex; justify-content: space-between; color: #999">
				<div>
					<b>작성자</b> ${freeboard.member_id}
				</div>
				<div>${freeboard.viewcnt} Views | ${freeboard.regdate.substring(0, 10)}</div>
			</div>

			<div class="line"></div>

			<div class="content" style="padding: 0 2rem; line-height: 1.8;">
			<div class="thumb">
				<c:if test="${freeboard.file_path != null && not empty freeboard.file_path}">
					<img src="<%=context%>/assets/img/${freeboard.file_path}">
				</c:if>
			</div>
			</div>

			<p>${freeboard.content}</p>

			<div class="form-button-wrapper">
				<button class="btn-basic btn-color1"
					onclick="window.open('${freeboard.comment}')">💬💬댓글 달기</button>

			</div>


		<div class="line"></div>

		<div class="form-button-wrapper">
			<span class="btn-basic btn-line-red"
				onclick="checkDelete(${freeboard.fno})">삭제하기</span>
			<button class="btn-basic"
				onclick="location.href='<%=context%>/freeboard/update.do?fno=${freeboard.fno}'">수정하기</button>
		</div>
		<div class="form-button-wrapper">
			<button class="btn-basic btn-line-basic"
				onclick="location.href='<%=context%>/freeboard/list.do'">글 목록
				보기</button>
		</div>
		</div>
	</div>
	<%@ include file="../common/footer.jsp"%>
</body>

</html>