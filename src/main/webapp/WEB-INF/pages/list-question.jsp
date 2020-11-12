<%-- 
    Document   : list-question
    Created on : Aug 3, 2020, 3:31:06 PM
    Author     : Huy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<title>Online quiz</title>
<!-- Favicon-->
<link rel="icon" href="<c:url value="/resources/icon/favicon.ico"/>"
	type="image/x-icon">

<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Roboto:400,700&subset=latin,cyrillic-ext"
	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet" type="text/css">

<!-- Bootstrap Core Css -->
<link
	href="<c:url value="/resources/plugins/bootstrap/css/bootstrap.css"/>"
	rel="stylesheet" type="text/css" />
<!-- Waves Effect Css -->
<link href="<c:url value="/resources/plugins/node-waves/waves.css"/>"
	rel="stylesheet" type="text/css" />

<!-- Animation Css -->
<link href="<c:url value="/resources/plugins/animate-css/animate.css"/>"
	rel="stylesheet" type="text/css" />

<!-- Custom Css -->
<link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet"
	type="text/css" />
<!-- AdminBSB Themes. You can choose a theme from css/themes instead of get all themes -->
<link href="<c:url value="/resources/css/themes/theme-green.css"/>"
	rel="stylesheet" type="text/css" />

<link href="<c:url value="/resources/css/custom.css"/>" rel="stylesheet"
	type="text/css" />
	
<link href="<c:url value="/resources/css/styles.css"/>" rel="stylesheet"
	type="text/css" />
</head>

<body class="theme-green">
	<!-- Page Loader -->
	<div class="page-loader-wrapper">
		<div class="loader">
			<div class="preloader">
				<div class="spinner-layer pl-green">
					<div class="circle-clipper left">
						<div class="circle"></div>
					</div>
					<div class="circle-clipper right">
						<div class="circle"></div>
					</div>
				</div>
			</div>
			<p>Please wait...</p>
		</div>
	</div>
	<!-- #END# Page Loader -->
	<!-- Overlay For Sidebars -->
	<div class="overlay"></div>
	<!-- #END# Overlay For Sidebars -->
	<!-- Search Bar -->
	<div class="search-bar">
		<div class="search-icon">
			<i class="material-icons">search</i>
		</div>
		<input type="text" placeholder="START TYPING...">
		<div class="close-search">
			<i class="material-icons">close</i>
		</div>
	</div>
	<!-- #END# Search Bar -->
	<!-- Top Bar -->
	<nav class="navbar">
		<div class="container-fluid">
			<div class="navbar-header">
				<a href="javascript:void(0);" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar-collapse"
					aria-expanded="false"></a> <a href="javascript:void(0);"
					class="bars"></a> <a class="navbar-brand"
					href="<c:url value="/index.jsp"/>"></a>
			</div>
			<div class="collapse navbar-collapse" id="navbar-collapse">
				<ul class="nav navbar-nav navbar-right">
					<!-- Call Search -->
					<li><a href="javascript:void(0);" class="js-search"
						data-close="true"><i class="material-icons">search</i></a></li>
					<!-- #END# Call Search -->
				</ul>
			</div>
		</div>
	</nav>
	<!-- #Top Bar -->
	<section>
		<!-- Left Sidebar -->
		<aside id="leftsidebar" class="sidebar">
			<!-- Menu -->
			<div class="menu">
				<ul class="list">
					<li class="header">MENU</li>
					<li><a href="<c:url value="/index.jsp"/>"> <span>Home</span>
					</a></li>
					<li><a href="javascript:void(0);" class="menu-toggle"> <span>Question
								management</span>
					</a>
						<ul class="ml-menu">
							<li><a href="<c:url value="/question/list"/>">Question
									list</a></li>
							<li><a href="<c:url value="/question/createQuestionForm"/>">Create
									question</a></li>
						</ul></li>
					<li><a href="javascript:void(0);" class="menu-toggle"> <span>Test
								management</span>
					</a>
						<ul class="ml-menu">
							<li><a href="<c:url value="/test/list"/>">Test list</a></li>
							<li><a href="<c:url value="/test/createTestForm"/>">Create
									test</a></li>
						</ul></li>
				</ul>
			</div>
			<!-- #Menu -->
			<!-- Footer -->
			<div class="legal">
				<div class="copyright">
					&copy; 2018 <a href="javascript:void(0);">abc123</a>.
				</div>
				<div class="version">
					<b>Version: </b> 1.0.0
				</div>
			</div>
			<!-- #Footer -->
		</aside>
		<!-- #END# Left Sidebar -->
	</section>

	<section class="content">
		<div class="container-fluid">
			<div class="block-header align-center">
				<h2>QUESTION MANAGAMENT</h2>
			</div>
			<!-- Basic Table -->
			<div class="row clearfix">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="card">
						<div class="header">
							<a href="<c:url value="/question/createQuestionForm"/>"
								class="btn btn-success waves-effect">Create question</a>
						</div>
						<div class="body table-responsive">
							<table class="table table-bordered table-striped">
								<thead class="btn-success">
									<tr>
										<th style="width: 25%">Question content</th>
										<th style="width: 15%">Correct Answer</th>
										<th style="width: 15%">Answer 1</th>
										<th style="width: 15%">Answer 2</th>
										<th style="width: 15%">Answer 3</th>
										<th style="width: 15%"></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="question" items="${questions}">
										<c:url var="updateLink" value="/question/updateQuestionForm">
											<c:param name="questionId" value="${question.question_id}" />
										</c:url>

										<c:url var="deleteLink" value="/question/deleteQuestion">
											<c:param name="questionId" value="${question.question_id}" />
										</c:url>
										<tr>
											<td>${question.content}</td>
											<td>${question.correct_answer}</td>
											<td>${question.answer_1}</td>
											<td>${question.answer_2}</td>
											<td>${question.answer_3}</td>
											<td><a href="${deleteLink}"
												class="btn btn-danger btn-delete"
												onclick="if (!(confirm('Are you sure you want to delete this question?'))) return false"><i
													class="material-icons">delete</i></a> <a href="${updateLink}"
												class="btn btn-info" ) returnfalse"><i
													class="material-icons">edit</i></a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<center>
								<ul class="pagination pagination-center">
									<c:url value="/question/list" var="prev">
										<c:param name="page" value="${page-1}" />
									</c:url>
									<c:if test="${page > 1}">
										<li><a href="<c:out value="${prev}" />" class="pn prev">Prev</a></li>
									</c:if>
	
									<c:forEach begin="1" end="${maxPages}" step="1" varStatus="i">
										<c:choose>
											<c:when test="${page == i.index}">
												<li><span>${i.index}</span></li>
											</c:when>
											<c:otherwise>
												<c:url value="/question/list" var="url">
													<c:param name="page" value="${i.index}" />
												</c:url>
												<li><a href='<c:out value="${url}" />'>${i.index}</a></li>
											</c:otherwise>
										</c:choose>
									</c:forEach>
									<c:url value="/question/list" var="next">
										<c:param name="page" value="${page + 1}" />
									</c:url>
									<c:if test="${page + 1 <= maxPages}">
										<li><a href='<c:out value="${next}" />' class="pn next">Next</a></li>
									</c:if>
								</ul>
							</center>
						</div>
					</div>
				</div>
			</div>
			<!-- #END# Basic Table -->
		</div>
	</section>

	<!-- Jquery Core Js -->
	<script src="<c:url value="/resources/plugins/jquery/jquery.min.js"/>"
		type="text/javascript"></script>
	<!-- Bootstrap Core Js -->
	<script
		src="<c:url value="/resources/plugins/bootstrap/js/bootstrap.js"/>"
		type="text/javascript"></script>

	<!-- Select Plugin Js -->
	<script
		src="<c:url value="/resources/plugins/bootstrap-select/js/bootstrap-select.js"/>"
		type="text/javascript"></script>

	<!-- Slimscroll Plugin Js -->
	<script
		src="<c:url value="/resources/plugins/jquery-slimscroll/jquery.slimscroll.js"/>"
		type="text/javascript"></script>

	<!-- Waves Effect Plugin Js -->
	<script src="<c:url value="/resources/plugins/node-waves/waves.js"/>"
		type="text/javascript"></script>

	<!-- Custom Js -->
	<script src="<c:url value="/resources/js/admin.js"/>"
		type="text/javascript"></script>
</body>
</html>
