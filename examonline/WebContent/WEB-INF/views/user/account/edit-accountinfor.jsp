<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
			<form action="account-management/account-edit.htm?changepassword"
				method="post">
				<div class="uk-margin">
					<div class="uk-inline uk-width-1-1">
						<span class="uk-form-icon" uk-icon="icon: user"></span> <input
							class="uk-input uk-form-large" type="text" placeholder="UserName"
							value="${user.userName}" name="username" readonly>
					</div>
				</div>
				<div class="uk-margin">
					<div class="uk-inline uk-width-1-1">
						<span class="uk-form-icon" uk-icon="icon: lock"></span> <input
							class="uk-input uk-form-large" type="password"
							placeholder="Password" name="password">
					</div>
				</div>
				<div class="uk-margin">
					<div class="uk-inline uk-width-1-1">
						<span class="uk-form-icon" uk-icon="icon: lock"></span> <input
							class="uk-input uk-form-large" type="password"
							placeholder="Confirm Password" name="confirmPassword">
					</div>
				</div>
				<div class="uk-margin verve-right">
					<button class="uk-button uk-button-primary verve-btn-primary"
						type="submit">Save</button>
				</div>
			</form>
		</div>
		<div class="col-md-1"></div>
		<div class="col-md-6">
			<h3 class="uk-card-title uk-text-center">Update account
				information</h3>
			<form:form action="account-management/account-edit.htm?updateinfo"
				method="post" modelAttribute="personInfo">
				<div class=" row uk-margin">
					<div class="col-md-6">
						<div class="uk-inline uk-width-1-1">
							<span class="uk-form-icon" uk-icon="icon: users"></span>
							<form:input path="firstName" class="uk-input uk-form-large"
								type="text" placeholder="First Name" />
						</div>
					</div>
					<div class="col-md-6">
						<div class="uk-width-1-1">
							<form:input path="lastName" class="uk-input uk-form-large"
								type="text" placeholder="Last Name" />
						</div>
					</div>
				</div>
				<div class=" row">
					<div class="col-md-6">
						<div class="js-upload uk-placeholder uk-text-center">
							<span uk-icon="icon: cloud-upload"></span> <span
								class="uk-text-middle">Attach binaries by dropping them
								here or</span>
							<div uk-form-custom>
								<input type="file" accept="image/x-png,image/gif,image/jpeg"> <span class="uk-link">selecting
									one</span>
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="uk-grid-small uk-child-width-auto uk-grid">
							<label> <form:radiobutton path="gender" class="uk-radio"
									value="true"/> Male
							</label> <label><form:radiobutton path="gender" class="uk-radio"
									value="false" /> Female</label>
						</div>
					</div>

				</div>
				<progress id="js-progressbar" class="uk-progress" value="0"
					max="100" hidden></progress>
				<div class="uk-margin">
					<div class="uk-inline uk-width-1-1">
						<span class="uk-form-icon" uk-icon="icon: mail"></span>
						<form:input path="email" class="uk-input uk-form-large"
							type="text" placeholder="Email Address" />
					</div>
				</div>
				<div class="uk-margin">
					<div class="uk-inline uk-width-1-1">
						<span class="uk-form-icon" uk-icon="icon: receiver"></span>
						<form:input path="phoneNum" class="uk-input uk-form-large"
							type="text" placeholder="Phone Number" />
					</div>
				</div>
				<div class="uk-margin">
					<div class="uk-inline uk-width-1-1">
						<span class="uk-form-icon" uk-icon="icon: location"></span>
						<form:input path="address" class="uk-input uk-form-large"
							type="text" placeholder="Home Address" />
					</div>
				</div>
				<div class="uk-margin verve-right">
					<button class="uk-button uk-button-primary verve-btn-primary">Update</button>
				</div>
			</form:form>
		</div>
	</div>
	<script>
		var bar = document.getElementById('js-progressbar');

		UIkit.upload('.js-upload', {

			url : '',
			multiple : true,

			beforeSend : function() {
				console.log('beforeSend', arguments);
			},
			beforeAll : function() {
				console.log('beforeAll', arguments);
			},
			load : function() {
				console.log('load', arguments);
			},
			error : function() {
				console.log('error', arguments);
			},
			complete : function() {
				console.log('complete', arguments);
			},

			loadStart : function(e) {
				console.log('loadStart', arguments);

				bar.removeAttribute('hidden');
				bar.max = e.total;
				bar.value = e.loaded;
			},

			progress : function(e) {
				console.log('progress', arguments);

				bar.max = e.total;
				bar.value = e.loaded;
			},

			loadEnd : function(e) {
				console.log('loadEnd', arguments);

				bar.max = e.total;
				bar.value = e.loaded;
			},

			completeAll : function() {
				console.log('completeAll', arguments);

				setTimeout(function() {
					bar.setAttribute('hidden', 'hidden');
				}, 1000);

				alert('Upload Completed');
			}

		});
	</script>
</body>
</html>