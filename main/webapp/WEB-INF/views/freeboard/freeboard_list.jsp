<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title> 자유게시판 | SHOES4JO</title>

    <%@include file="../common/header-head.jsp"%>

    <style>
        .form-wrapper {
            max-width: 100%;
        }

        .pagination {
            justify-content: center;
        }

        .page-link {
            color: #6ECCAF;
        }

        .page-link:hover {
            background: white;
            filter: brightness(95%);
        }
    </style>
</head>

<body>

<%@include file="../common/header.jsp"%>

<div class="container">
    <h2 class="text-center"><a href="${context}/freeboard/list.do" style="text-decoration: none; color: inherit;">자유게시판</a></h2>

    <div style="display: flex; justify-content: space-between; margin: 1rem 0;">
        
<select class="form-select" style="width: fit-content"
    onchange="window.location.href='<%=context %>/freeboard/category.do?category=' + this.value">
    <option value="">카테고리 선택</option>
    <option value="정보">정보</option>
    <option value="구입 후기">구입 후기</option>
    <option value="중고 거래">중고 거래</option> 
</select> 


	    <button onclick="location.href='<%=context %>/freeboard/write.do'" class="btn-basic">글쓰기</button>
			
		</div>
		
		
		
		<table class="table table-freeboard table-hover">
			<thead>
				<tr>
					<th class="text-center">번호</th>
					<th class="text-center">카테고리</th>
					<th class="text-center">제목</th>
					<th class="text-center">작성자</th>
					<th class="text-center">조회수</th>
					<th class="text-center">등록일</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="freeboard" items="${list}">
					<tr>
						<td class="text-center">${freeboard.fno }</td>
						<td class="text-center">${freeboard.category}</td>
						<td class="text-center"><a href="<%=context %>/freeboard/view.do?fno=${freeboard.fno}">${freeboard.title} </a></td>
						<td class="text-center">${freeboard.member_id}</td>
						<td class="text-center">${freeboard.viewcnt}</td>
						<td class="text-center">${freeboard.date.substring(0,16)}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
 
	</div>

<div>
		<ul class="pagination">

			<c:if test="${pageMaker.prev}">
				<li><a class="page-link"
					href="<%=context %>/freeboard/list.do${pageMaker.makeQuery(pageMaker.startPage - 1)}">이전</a></li>
			</c:if>

			<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}"
				var="idx">
				<li><a class="page-link"
					href="<%=context %>/freeboard/list.do${pageMaker.makeQuery(idx)}">${idx}</a></li>
			</c:forEach>

			<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
				<li><a class="page-link"
					href="<%=context %>/freeboard/list.do${pageMaker.makeQuery(pageMaker.endPage + 1)}">다음</a></li>
			</c:if>

		</ul>
	</div>


	<%@include file="../common/footer.jsp"%>
</body>
</html>