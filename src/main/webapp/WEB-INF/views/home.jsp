<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ page session="false"%>

<c:url value="/resources" var="resource" />
<html>
<head>
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<link href="${resource}/css/bootstrap-responsive.css" rel="stylesheet">
<link href="${resource}/css/bootstrap.css" rel="stylesheet">
<link href="${resource}/css/docs.css" rel="stylesheet">
<link href="${resource}/css/prettify.css" rel="stylesheet">
<link href="${resource}/css/jquery.pnotify.default.css" rel="stylesheet">
</head>

<body data-spy="scroll" data-target=".bs-docs-sidebar"
	data-twttr-rendered="true">


	<tiles:insertAttribute name="header" />
	<tiles:insertAttribute name="body" />
	<tiles:insertAttribute name="footer" />


	<script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
	<script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
	<script src="${resource}/js/bootstrap-transition.js"></script>
	<script src="${resource}/js/bootstrap-alert.js"></script>
	<script src="${resource}/js/bootstrap-modal.js"></script>
	<script src="${resource}/js/bootstrap-dropdown.js"></script>
	<script src="${resource}/js/bootstrap-scrollspy.js"></script>
	<script src="${resource}/js/bootstrap-tab.js"></script>
	<script src="${resource}/js/bootstrap-tooltip.js"></script>
	<script src="${resource}/js/bootstrap-popover.js"></script>
	<script src="${resource}/js/bootstrap-button.js"></script>
	<script src="${resource}/js/bootstrap-collapse.js"></script>
	<script src="${resource}/js/bootstrap-carousel.js"></script>
	<script src="${resource}/js/bootstrap-typeahead.js"></script>
	<script src="${resource}/js/jquery.pnotify.min.js"></script>
	<script src="${resource}/js/application.js"></script>
</body>
</html>
