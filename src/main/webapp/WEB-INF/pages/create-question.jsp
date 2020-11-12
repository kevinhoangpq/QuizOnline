<%-- 
    Document   : create-question
    Created on : Aug 3, 2020, 3:22:22 PM
    Author     : Huy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <title>Online quiz</title>
    <!-- Favicon-->
        <link rel="icon" href="<c:url value="/resources/icon/favicon.ico"/>" type="image/x-icon">

        <!-- Google Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Roboto:400,700&subset=latin,cyrillic-ext" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" type="text/css">

        <!-- Bootstrap Core Css -->
        <link href="<c:url value="/resources/plugins/bootstrap/css/bootstrap.css"/>" rel="stylesheet" type="text/css"/>
        <!-- Waves Effect Css -->
        <link href="<c:url value="/resources/plugins/node-waves/waves.css"/>" rel="stylesheet" type="text/css"/>

        <!-- Animation Css -->
        <link href="<c:url value="/resources/plugins/animate-css/animate.css"/>" rel="stylesheet" type="text/css"/>

        <!-- Custom Css -->
        <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet" type="text/css"/>
        <!-- AdminBSB Themes. You can choose a theme from css/themes instead of get all themes -->
        <link href="<c:url value="/resources/css/themes/theme-green.css"/>" rel="stylesheet" type="text/css"/>

        <link href="<c:url value="/resources/css/custom.css"/>" rel="stylesheet" type="text/css"/>
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
                    <a href="javascript:void(0);" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse" aria-expanded="false"></a>
                    <a href="javascript:void(0);" class="bars"></a>
                    <a class="navbar-brand" href="<c:url value="/index.jsp"/>"></a>
                </div>
                <div class="collapse navbar-collapse" id="navbar-collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <!-- Call Search -->
                        <li><a href="javascript:void(0);" class="js-search" data-close="true"><i class="material-icons">search</i></a></li>
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
                        <li>
                            <a href="<c:url value="/index.jsp"/>">
                                <span>Home</span>
                            </a>
                        </li>
                        <li>
                            <a href="javascript:void(0);" class="menu-toggle">
                                <span>Question management</span>
                            </a>
                            <ul class="ml-menu">
                                <li>
                                    <a href="<c:url value="/question/list"/>">Question list</a>
                                </li>
                                <li>
                                    <a href="<c:url value="/question/createQuestionForm"/>">Create question</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="javascript:void(0);" class="menu-toggle">
                                <span>Test management</span>
                            </a>
                            <ul class="ml-menu">
                                <li>
                                    <a href="<c:url value="/test/list"/>">Test list</a>
                                </li>
                                <li>
                                    <a href="<c:url value="/test/createTestForm"/>">Create test</a>
                                </li>
                            </ul>
                        </li>
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
            <div class="block-header align-center">
                <h2>CREATE QUESTION</h2>
            </div>
            <!-- Horizontal Layout -->
            <div class="row clearfix">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="card">
                        <div class="body">
                            <form:form class="form-horizontal" action="saveQuestion" method="POST" modelAttribute="question">
                                <div class="row clearfix">
                                    
                                    <form:hidden path="question_id"/>
                                    
                                    <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                        <label for="content">Question content:</label>
                                    </div>
                                    <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                        <div class="form-group">
                                            <div class="form-line">
                                                <form:textarea path="content" rows="4" class="form-control no-resize" maxlength="1000"></form:textarea>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row clearfix">
                                    <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                        <label for="correct_answer">Answer:</label>
                                    </div>
                                    <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                        <div class="form-group">
                                            <div class="form-line">
                                            <form:input type="text" path="correct_answer" class="form-control" maxlength="100"/>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row clearfix">
                                    <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                        <label for="answer_1">Answer 1:</label>
                                    </div>
                                    <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                        <div class="form-group">
                                            <div class="form-line">
                                                <form:input type="text" path="answer_1" class="form-control" maxlength="100"/>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row clearfix">
                                    <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                        <label for="answer_2">Answer 2:</label>
                                    </div>
                                    <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                        <div class="form-group">
                                            <div class="form-line">
                                                <form:input type="text" path="answer_2" class="form-control" maxlength="100"/>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row clearfix">
                                    <div class="col-lg-2 col-md-2 col-sm-4 col-xs-5 form-control-label">
                                        <label for="answer_3">Answer 3:</label>
                                    </div>
                                    <div class="col-lg-10 col-md-10 col-sm-8 col-xs-7">
                                        <div class="form-group">
                                            <div class="form-line">
                                                <form:input type="text" path="answer_3" class="form-control" maxlength="100"/>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row clearfix">
                                    <div class="col-lg-offset-2 col-md-offset-2 col-sm-offset-4 col-xs-offset-5">
                                        <form:button type="submit" class="btn btn-success m-t-15 w-90 waves-effect">Save</form:button>
                                        <a href="<c:url value="/question/list"/>" class="btn btn-warning m-t-15 w-90 waves-effect" >Cancel</a>
                                    </div>
                                </div>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
            <!-- #END# Horizontal Layout -->
        </section>

        <!-- Jquery Core Js -->
        <script src="<c:url value="/resources/plugins/jquery/jquery.min.js"/>" type="text/javascript"></script>
        <!-- Bootstrap Core Js -->
        <script src="<c:url value="/resources/plugins/bootstrap/js/bootstrap.js"/>" type="text/javascript"></script>

        <!-- Select Plugin Js -->
        <script src="<c:url value="/resources/plugins/bootstrap-select/js/bootstrap-select.js"/>" type="text/javascript"></script>

        <!-- Slimscroll Plugin Js -->
        <script src="<c:url value="/resources/plugins/jquery-slimscroll/jquery.slimscroll.js"/>" type="text/javascript"></script>

        <!-- Waves Effect Plugin Js -->
        <script src="<c:url value="/resources/plugins/node-waves/waves.js"/>" type="text/javascript"></script>

        <!-- Custom Js -->
        <script src="<c:url value="/resources/js/admin.js"/>" type="text/javascript"></script>
    </body>
</html>
