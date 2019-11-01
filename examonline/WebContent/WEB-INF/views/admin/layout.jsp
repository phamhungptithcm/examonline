<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<jsp:include page="../common/libraries.jsp"></jsp:include>
</head>
<body>
	<div uk-sticky="media: 960"
		class="uk-navbar-container tm-navbar-container uk-sticky uk-active uk-sticky-below uk-sticky-fixed">
		<jsp:include page="../common/navbar.jsp"></jsp:include>
	</div>
	<jsp:include page="${view}" />
</body>
</html>