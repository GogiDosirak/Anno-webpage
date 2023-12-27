<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ page import="java.util.List"%>
<%@ page import="com.springbook.biz.board.BoardVO"%>
<%@ page import="com.springbook.biz.user.UserVO" %>
<%
List<BoardVO> boardList = (List) session.getAttribute("boardList");
UserVO user = (UserVO) session.getAttribute("user");
%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>미니 프로젝트</title>
<meta charset="EUC-KR">
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
					<li><a href="logout.do"><span class="glyphicon glyphicon-log-in"></span>
							Logout</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<form action="searchList.do" method="post">
	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-2 sidenav">
			</div>
			<div class="col-sm-8 text-center">
				<center>
					<h1>글 목록</h1> 
					<table border="1" width="1250">
						<tr>
							<td align="right"><select name="searchCondition">
									<option value="title">제목
									<option value="content">내용
							</select> <input type="text" name="searchKeyword"> <input
								type="submit" value="검색"></td>
								</form>
					</table>
					<table border="1" width="1250">
						<tr>
							<th bgcolor="WhiteSmoke" width="150" style="text-align: center;">번호</th>
							<th bgcolor="WhiteSmoke" width="300" style="text-align: center;">제목</th>
							<th bgcolor="WhiteSmoke" width="300" style="text-align: center;">작성자</th>
							<th bgcolor="WhiteSmoke" width="200" style="text-align: center;">날짜</th>
							<th bgcolor="WhiteSmoke" width="150" style="text-align: center;">조회수</th>
							<th bgcolor="WhiteSmoke" width="150" style="text-align: center;">좋아요</th>
						</tr>
						<c:forEach items="${boardList}" var="board">
							<tr>
								<td>${board.seq }</td>
								<td><a href="getBoard.do?seq=${board.seq }">${board.title }</a></td>
								<td>${board.writer }</td>
								<td>${board.regDate }</td>
								<td>${board.cnt }</td>
								<td>${board.b_like }</td>
							</tr>
						</c:forEach>
					</table>
					<center>
					<h5><a href="insertBoard.jsp" class="btn btn-primary pull-center">새글 쓰기</a></h5>
			</div>
			</center>

			<div class="col-sm-2 sidenav">
				<div class="well">
					<p></p>
				</div>
				<div class="well">
					<p></p>
				</div>
			</div>
		</div>
	</div>
	<br>
	<br>
	<br>
	<footer class="container-fluid text-center">
		<p>Footer Text</p>
	</footer>

</body>
</html>