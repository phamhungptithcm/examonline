<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Edit Account - Examonline</title>
</head>
<body>
	<jsp:include page="accountinfor.jsp"></jsp:include>
	<div class="row verve-margin-top">
		<div class="col-md-5">
			<h3 class="uk-card-title uk-text-center">Change Password</h3>
			<form>
				<div class="uk-margin">
					<div class="uk-inline uk-width-1-1">
						<span class="uk-form-icon" uk-icon="icon: user"></span> <input
							class="uk-input uk-form-large" type="text" placeholder="UserName"
							readonly>
					</div>
				</div>
				<div class="uk-margin">
					<div class="uk-inline uk-width-1-1">
						<span class="uk-form-icon" uk-icon="icon: lock"></span> <input
							class="uk-input uk-form-large" type="password"
							placeholder="Password">
					</div>
				</div>
				<div class="uk-margin">
					<div class="uk-inline uk-width-1-1">
						<span class="uk-form-icon" uk-icon="icon: lock"></span> <input
							class="uk-input uk-form-large" type="password"
							placeholder="Confirm Password">
					</div>
				</div>
				<div class="uk-margin verve-right">
					<button class="uk-button uk-button-primary verve-btn-primary">Save</button>
				</div>
			</form>
		</div>
		<div class="col-md-1"></div>
		<div class="col-md-6">
			<h3 class="uk-card-title uk-text-center">Update account
				information</h3>
			<form>
				<div class=" row uk-margin">
					<div class="col-md-6">
						<div class="uk-inline uk-width-1-1">
							<span class="uk-form-icon" uk-icon="icon: users"></span> <input
								class="uk-input uk-form-large" type="text"
								placeholder="First Name">
						</div>
					</div>
					<div class="col-md-6">
						<div class="uk-width-1-1">
							<input class="uk-input uk-form-large" type="text"
								placeholder="Last Name">
						</div>
					</div>
				</div>
				<div class="uk-grid-small uk-child-width-auto uk-grid verve-paddingleft-55">
					<label><input class="uk-radio" type="radio" name="gender" checked>
						Male</label> <label><input class="uk-radio" name="gender" type="radio">
						Female</label>
				</div>
				<div class="uk-margin">
					<div class="uk-inline uk-width-1-1">
						<span class="uk-form-icon" uk-icon="icon: mail"></span> <input
							class="uk-input uk-form-large" type="text"
							placeholder="Email Address">
					</div>
				</div>
				<div class="uk-margin">
					<div class="uk-inline uk-width-1-1">
						<span class="uk-form-icon" uk-icon="icon: receiver"></span> <input
							class="uk-input uk-form-large" type="text"
							placeholder="Phone Number">
					</div>
				</div>
				<div class="uk-margin">
					<div class="uk-inline uk-width-1-1">
						<span class="uk-form-icon" uk-icon="icon: location"></span> <input
							class="uk-input uk-form-large" type="text"
							placeholder="Home Address">
					</div>
				</div>
				<div class="uk-margin verve-right">
					<button class="uk-button uk-button-primary verve-btn-primary">Update</button>
				</div>
			</form>
		</div>
	</div>
	
</body>
</html>