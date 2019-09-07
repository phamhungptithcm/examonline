<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Account Overview - ExamOnline</title>
</head>
<body>
	<jsp:include page="accountinfor.jsp"></jsp:include>
	<div style="border-bottom: 2px solid black;">
		<div class="col-sm-6">
			<div class="uk-inline">
				<h3 class="uk-card-title">
					<a href><span class="uk-link-heading">Acount Overview </span> <span
						uk-icon="icon: chevron-down"></span> </a>
				</h3>
				<div uk-dropdown="pos: bottom-justify">
					<ul class="uk-nav uk-dropdown-nav">
						<li class="uk-active"><a href="#">Acount Overview</a></li>
						<li class="uk-nav-divider"></li>
						<li><a href="#">Manage Appointment</a></li>
						<li><a href="#">Edit Account Information</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div class="row verve-margin-top">
		<div class="col-md-4">
			<div class="uk-card uk-card-default uk-card-body uk-width-1-1@m" uk-tooltip="Exam information with the highest score">
				<div class="row">
					<div class="col-md-6">
						<h3 class="uk-card-title">Score</h3>
					</div>
					<div class="col-md-6 uk-text-right">
						<h3 class="uk-card-title">10</h3>
					</div>
				</div>
				<ul class="uk-list">
					<li class=""><span uk-icon="icon: info"></span> Total number
						of correct/error answers<span class=""> 10/0</span></li>
					<li class=""><span uk-icon="icon: clock"></span> Total times
						to do lesson <span> 100 seconds</span></li>
					<li class=""><span uk-icon="icon: question"></span>Total
						number of questions ignored <span> 0</span></li>
				</ul>
			</div>
		</div>
		<div class="col-md-8">
			<h5 class="uk-card-title">
				<span uk-icon="icon: history"></span> Recent History
			</h5>
		</div>
	</div>
</body>
</html>