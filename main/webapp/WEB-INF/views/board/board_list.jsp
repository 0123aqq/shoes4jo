<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시판 | SHOES4JO</title>

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
    <h2 class="text-center">게시판</h2>

    <div style="display: flex; justify-content: space-between; margin: 1rem 0;">
        
		<select class="form-select" style="width: fit-content"
			onchange="window.open(value,'_self')">
			<option value="">카테고리 선택</option>
			<option value="${context}/board/list.do">전체 글 보기</option>
			<option value="${context}/board/list.do?category=news">뉴스</option>
			<option value="${context}/board/list.do?category=events">이벤트</option>
			<option value="${context}/board/list.do?category=columns">칼럼</option> 
	    </select> 

	    <a href="${context}/board/write.do" class="btn-basic">글쓰기</a>
			
		</div>
		
		
		
		<table class="table table-board table-hover">
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
				<c:forEach var="board" items="${list}">
					<tr>
						<td class="text-center">${board.bno }</td>
						<td class="text-center">${board.category}</td>
						<td class="text-center"><a href="<%=context %>/board/view.do?bno=${board.bno}">${board.title} </a></td>
						<td class="text-center">${board.writer}</td>
						<td class="text-center">${board.viewcnt}</td>
						<td class="text-center">${board.regdate.substring(0,16)}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
 
	</div>

<div>
		<ul class="pagination">

			<c:if test="${pageMaker.prev}">
				<li><a class="page-link"
					href="${context}/board/list.do${pageMaker.makeQuery(pageMaker.startPage - 1)}">이전</a></li>
			</c:if>

			<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}"
				var="idx">
				<li><a class="page-link"
					href="${context}/board/list.do${pageMaker.makeQuery(idx)}">${idx}</a></li>
			</c:forEach>

			<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
				<li><a class="page-link"
					href="${context}/board/list.do${pageMaker.makeQuery(pageMaker.endPage + 1)}">다음</a></li>
			</c:if>

		</ul>
	</div>


	<%@include file="../common/footer.jsp"%>
</body>
</html>
