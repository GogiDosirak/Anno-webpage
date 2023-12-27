<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ page import="com.springbook.biz.board.BoardVO"%>
<%@ page import="com.springbook.biz.user.UserVO" %>
<%
BoardVO board = (BoardVO) session.getAttribute("board");
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
					<li><a href="logout.do"><span class="glyphicon glyphicon-log-in"></span>
							Logout</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-2 sidenav">
			</div>
			<div class="col-sm-8 text-left">
				<center>
					<form action="insertBoard.do" method="post">
						<h2>글 등록</h2>
				</center>
				<left>
				<hr>
				<table border="1">
					<tr>
						<td bgcolor="WhiteSmoke" width="100" align="center">제목</td>
						<td><input type="text" name="title" width="1000"></td>
					</tr>
					<tr>
						<td bgcolor="WhiteSmoke" width="100" align="center">작성자</td>
						<td>${user.name }</td>
						<input type="hidden" name="writer" value="${user.name }">
					</tr>
					<tr>
						<td bgcolor="WhiteSmoke" width="100" align="center">내용</td>
						<td><textarea type="text" name="content" cols="40" rows="9"></textarea>
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit"
							value="등록"></td>
				</table>
				<h5>
						 &nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;<a href="getBoardList.do" class="btn btn-primary">글 목록</a>
				</h5>
				</form>
				<left>
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
	<br>
	<footer class="container-fluid text-center">
		<p>Footer Text</p>
	</footer>

</body>
</html>