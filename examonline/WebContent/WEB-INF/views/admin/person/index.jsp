<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Admin - Person</title>
</head>
<body>
	<div class="uk-container">
		<h1 class="uk-heading-line uk-text-center">
			<span>List Person</span>
		</h1>
		<div class="uk-margin-top">
			<div id="result"></div>
			<ul class="uk-pagination uk-flex-center pager" uk-margin>
				 <li class="link-paging"><a href="#"><span uk-pagination-previous></span></a></li>
				<li class="uk-disabled"><span id="curpage">1 of 1 pages</span></li>
				<li class="link-paging"><a href="#"><span uk-pagination-next></span></a></li>
			</ul>
		</div>
	</div>
	<script type="text/javascript" src="custom/js/helper.js"></script>
	<script type="text/javascript" src="custom/js/ajax.js"></script>
	<script type="text/javascript">
		var myParam = location.search.split('status=')[1];
		if (myParam == 'true') {
			showMessage('top-end', 'Successful', 'success');
		}
	</script>
	<script type="text/javascript" src="custom/js/panigationPerson.js"></script>
</body>
</html>