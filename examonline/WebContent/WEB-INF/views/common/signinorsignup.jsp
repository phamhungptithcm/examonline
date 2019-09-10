<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Account Creation - ExamOnline</title>
</head>
<body>
	<div
		class="uk-section uk-flex uk-flex-middle uk-animation-slide-bottom">
		<div class="uk-width-1-1">
			<div class="uk-container">
				<div class="uk-grid-margin uk-grid uk-grid-stack" uk-grid>
					<div class="uk-width-1-1@m">
						<div
							class="uk-margin uk-width-large uk-margin-auto uk-card uk-card-default uk-card-body uk-box-shadow-large">
							<ul class="uk-tab uk-flex-center" uk-grid
								uk-switcher="animation: uk-animation-fade">
								
								<li><a href="#">Sign In</a></li>
								<li class="uk-hidden">Forgot Password?</li>
								<li><a href="#">Sign Up</a></li>
								
							</ul>
							<ul class="uk-switcher uk-margin">
								<li>
									<h3 class="uk-card-title uk-text-center">Welcome back!</h3> <form:form
										action="account/signin.htm" method="post"
										modelAttribute="loginInfoDTO">
										<div class="uk-margin">
											<div class="uk-inline uk-width-1-1">
												<span class="uk-form-icon" uk-icon="icon: user"></span>
												<form:input path="userName" class="uk-input uk-form-large"
													type="text" placeholder="Username/Email address" value="${cookie.uid.value}"/>
											</div>
										</div>
										<div class="uk-margin">
											<div class="uk-inline uk-width-1-1">
												<span class="uk-form-icon" uk-icon="icon: lock"></span>
												<form:input path="password" class="uk-input uk-form-large"
													type="password" placeholder="Password" value="${cookie.pwd.value}"/>
											</div>
										</div>
										<div class="uk-column-1-2 uk-margin">
											<div class="uk-grid-small uk-child-width-auto uk-grid">
												<label><form:checkbox path="remember"
														class="uk-checkbox"/> Remember
													me?</label>
											</div>
											<div class="uk-text-right@s uk-text-center uk-text-small">
												<a href="#" uk-switcher-item="1">Forgot Password?</a>
											</div>
										</div>
										<div class="uk-margin verve-right">
											<button class="uk-button uk-button-primary verve-btn-primary"
												type="submit">Sign in</button>
										</div>
										<div class="uk-text-small uk-text-center">
											Not registered? <a href="#" uk-switcher-item="2">Create
												an account</a>
										</div>
									</form:form>
								</li>
								<li>
									<h3 class="uk-card-title uk-text-center">Forgot your
										password?</h3>
									<p class="uk-text-center uk-width-medium@s uk-margin-auto">Enter
										your email address and we will send you a link to reset your
										password.</p>
									<form>
										<div class="uk-margin">
											<div class="uk-inline uk-width-1-1">
												<span class="uk-form-icon" uk-icon="icon: mail"></span> <input
													class="uk-input uk-form-large" type="text"
													placeholder="Email Address">
											</div>
										</div>
										<div class="uk-column-1-2 uk-margin">
											<div class="uk-text-lighter uk-text-middle">
												<a href="#" uk-switcher-item="0"><span
													uk-icon="chevron-left"></span> Back to login</a>
											</div>
											<div class="verve-right">
												<button
													class="uk-button uk-button-primary verve-btn-primary">Send
													Email</button>
											</div>
										</div>
									</form>
								</li>
								<li>
									<h3 class="uk-card-title uk-text-center">Sign up today.
										It's free!</h3> <form:form action="account/signup.htm"
										method="post" modelAttribute="">
										<div class="uk-margin">
											<div class="uk-inline uk-width-1-1">
												<span class="uk-form-icon" uk-icon="icon: user"></span> <input
													class="uk-input uk-form-large" type="text"
													placeholder="UserName">
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
										<div class="uk-margin">
											<div class="uk-column-1-2">
												<div class="uk-inline uk-width-1-1">
													<span class="uk-form-icon" uk-icon="icon: users"></span> <input
														class="uk-input uk-form-large" type="text"
														placeholder="First Name">
												</div>
												<div class="uk-width-1-1">
													<input class="uk-input uk-form-large" type="text"
														placeholder="Last Name">
												</div>
											</div>
										</div>
										<!-- <div
											class="uk-margin uk-grid-small uk-child-width-auto uk-grid">
											<label><input class="uk-radio" type="radio"
												name="gender" checked> Male</label> <label><input
												class="uk-radio" type="radio" name="gender"> Female</label>
										</div> -->
										<div class="uk-margin">
											<div class="uk-inline uk-width-1-1">
												<span class="uk-form-icon" uk-icon="icon: mail"></span> <input
													class="uk-input uk-form-large" type="text"
													placeholder="Email Address">
											</div>
										</div>
										<div class="uk-margin">
											<div class="uk-inline uk-width-1-1">
												<span class="uk-form-icon" uk-icon="icon: receiver"></span>
												<input class="uk-input uk-form-large" type="text"
													placeholder="Phone Number">
											</div>
										</div>
										<div class="uk-column-1-2 uk-margin">
											<div
												class="uk-grid-small uk-child-width-auto uk-grid verve-middle">
												<label><input
													class="uk-checkbox uk-margin-small-right" type="checkbox"><small>Accept
														our <a href="#">Terms of Service</a> and <a href="#">Privacy
															Policy</a>.
												</small></label>
											</div>
											<div class="verve-right">
												<button
													class="uk-button uk-button-primary verve-btn-primary ">Sign
													up</button>
											</div>
										</div>
										<div class="uk-text-small uk-text-center">
											Already have an account? <a href="#" uk-switcher-item="0">Sign
												in</a>
										</div>
									</form:form>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>