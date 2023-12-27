<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="com.springbook.biz.board.BoardVO"%>
<%@ page import="com.springbook.biz.user.UserVO"%>
<%@ page import="com.springbook.biz.comment.CommentVO"%>
<%@ page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<%
BoardVO board = (BoardVO) session.getAttribute("board");
CommentVO commentList = (CommentVO) session.getAttribute("commentList");
UserVO user = (UserVO) session.getAttribute("user");
%>


<!DOCTYPE html>
<html lang="en">
<head>
<title>미니 프로젝트</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
/* Remove the navbar's default margin-bottom and rounded borders */
.navbar {
	margin-bottom: 0;
	border-radius: 0;
}

/* Set height of the grid so .sidenav can be 100% (adjust as needed) */
.row.content {
	height: 450px
}

/* Set gray background color and 100% height */
.sidenav {
	padding-top: 20px;
	background-color: #f1f1f1;
	height: 100%;
}

/* Set black background color, white text and some padding */
footer {
	background-color: #555;
	color: white;
	padding: 15px;
}

/* On small screens, set height to 'auto' for sidenav and grid */
@media screen and (max-width: 767px) {
	.sidenav {
		height: auto;
		padding: 15px;
	}
	.row.content {
		height: auto;
	}
}
</style>
</head>
<body>



	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="login.jsp">castlejun</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li class="active"><a href="getBoardList.do">Home</a></li>
					<li><a href="getMyList.do?user=${user }">나의 활동</a></li>
					<li><a href="myInfo.do?user=${user }">개인 정보</a></li>
					<li><a href="#">${user.name }</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="logout.do"><span
							class="glyphicon glyphicon-log-in"></span> Logout</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-2 sidenav"></div>
			<div class="col-sm-4 text-left">
				<table border="2" cellpadding="0" cellspacing="0" width="600">
					<input type="hidden" name="seq" value="${board.getSeq()}">
					<form action="updateBoard.do?seq=${board.getSeq() }" method="post">
						<center>
							<h2>글 상세</h2>
						</center>
					<tr>
						<td bgcolor="WhiteSmoke">번호</td>
						<td>${board.getSeq()}</td>
					</tr>
					<tr>
						<td bgcolor="WhiteSmoke">제목</td>
						<td><input type="text" name="title" value="${board.title}"></td>
					</tr>
					<tr>
						<td bgcolor="WhiteSmoke">작성자</td>
						<td>${board.writer}</td>
					</tr>
					<tr>
						<td bgcolor="WhiteSmoke">내용</td>
						<td><textarea rows="10" cols="40" name="content">${board.content}</textarea></td>
					</tr>
					<tr>
						<td bgcolor="WhiteSmoke">날짜</td>
						<td>${board.regDate }</td>
					</tr>
					<tr>
						<td bgcolor="WhiteSmoke">조회수</td>
						<td>${board.cnt }</td>
					</tr>
					<tr>
						<td colspan="6" align="center"><input type="submit"
							value="수정"></td>
						</form>
					</tr>
					<tr>
						<form action="likeBoard.do?seq=${board.getSeq() }" method="post">
							<td bgcolor="WhiteSmoke">추천수</td>
							<td>${board.b_like }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
								type="submit" value="좋아요"></td>
						</form>
					</tr>

				</table>
				<center>
					<c:set var="var1" value="${user.name }" />
					<c:set var="var2" value="${board.writer }" />
					<c:if test="${var1 eq var2 }">
						<br>
						<a href="deleteBoard.do?seq=${board.getSeq()}">글 삭제</a>&nbsp;&nbsp;&nbsp;
						</c:if>
					<a href="insertBoard.jsp">글 등록</a>&nbsp;&nbsp;&nbsp; <a
						href="getBoardList.do">글 목록</a>
				</center>
			</div>
			<div class="col-sm-4 text-left">
				<center>
					<h2>댓글</h2>
				</center>
				<form action="insertComment.do" method="post">
					<table border="2" cellpadding="0" cellspacing="0" width="600">

						<tr>
							<th colspan="3" align="center" bgcolor="WhiteSmoke">댓글 등록</th>
						</tr>

						<tr>
							<td><input type="hidden" name="seq"
								value="${board.getSeq()}"></td>
							<td><input type="hidden" name="co_NickName"
								value="${user.name }"></td>
							<td><textarea rows="5" cols="50" name="co_Content"></textarea></td>
							<td><input type="submit" value="등록"></td>
						</tr>
					</table>
				</form>







				<table border="2" cellpadding="0" cellspacing="0" width="600">

					<tr>
						<th colspan="3" align="center" bgcolor="WhiteSmoke">댓글</th>
					</tr>
					<c:forEach items="${commentList }" var="comment">
						<tr>
							<td>${comment.co_Seq }</td>
							<td>${comment.co_NickName }</td>
							<td>${comment.co_Content }</td>
							<td>${comment.co_RegDate }</td>
						</tr>
					</c:forEach>


				</table>

			</div>
			<div class="col-sm-2 sidenav">
				<div class="well">
					<p>ADS</p>
				</div>
				<div class="well">
					<p>ADS</p>
				</div>
			</div>
		</div>
	</div>
	<br>
	<br>
	<footer class="container-fluid text-center">
		<p>Footer Text</p>
	</footer>

</body>
</html>