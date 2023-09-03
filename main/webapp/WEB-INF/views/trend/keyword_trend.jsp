<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	isELIgnored = "false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색어 트렌드 | SHOES4JO</title>
<%@include file="../common/header-head.jsp"%>

<style>
.container {
	text-align: center;
}

.header {
	text-align: center;
}

h2 {
	margin: 0 auto;
}

.header span {
	font-size: 1.6rem;
}
</style>

<script>
document.addEventListener('DOMContentLoaded', () => {
	getCode();
});

function getCode() {
	const queryString = window.location.search;
	const urlParams = new URLSearchParams(queryString);
	const code = urlParams.get('q');

	if (code === "get") {
	    location.href="get_model";
    }
}
</script>
</head>
<body>
	<%@include file="../common/header.jsp"%>

	<div class="container">
		<h1>키워드 트렌드</h1>
		<div style="display: grid; grid-template-columns: repeat(2, 1fr); grid-gap: 3rem;">

			<div class="subject">
				<div class="header">
					<h2>SHOES4JO</h2>
					<span>추천 상품</span>
				</div>
				<div class="list" id="shoes4jo">
				<ul>
					<c:forEach var="keywords" items="${shoes4jo}">
					<li>${keywords.query}</li>
					</c:forEach>
				</ul>
				</div>
			</div>

			<div class="subject">
				<div class="header">
					<h2>신발</h2>
					<span>인기 키워드</span>
				</div>
				<div class="list" id="shoes">
				<ul>
					<c:forEach var="keywords" items="${shoes}">
					<li>${keywords.query}</li>
					</c:forEach>
				</ul>
				</div>
			</div>

			<div class="subject">
				<div class="header">
					<h2 class="kind-selector">
						<select>
							<option value="runningshoes">운동화</option>
						</select>
					</h2>
					<span>인기 키워드</span>
				</div>
				<div class="list" id="kind">
				<ul class="kind-ul" id="">
					<c:forEach var="keywords" items="${runnigshoes}">
					<li>${keywords.query}</li>
					</c:forEach>
				</ul>
				</div>
			</div>

			<div class="subject">
				<div class="header">
					<h2 class="brand-selector">나이키</h2>
					<span>인기 키워드</span>
				</div>
				<div class="list" id="brand">
				<ul>
					<c:forEach var="keywords" items="${nike}">
					<li>${keywords.query}</li>
					</c:forEach>
				</ul>
				</div>
			</div>

		</div>
	</div>
	<%@include file="../common/footer.jsp"%>
</body>
</html>