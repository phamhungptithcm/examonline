<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
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

								<li><a href="account/account-log.htm">Sign In</a></li>
								<li class="uk-hidden">Forgot Password?</li>
								<li><a href="account/account-log.htm?signup">Sign Up</a></li>

							</ul>
							<ul class="uk-switcher uk-margin">
								<li>
									<h3 class="uk-card-title uk-text-center">Welcome back!</h3>
									<div>
										<form name="formLogin" action="account/account-log.htm?signin"
											method="post" onsubmit="validationFormLogin()">
											<div class="uk-margin">
												<div class="uk-inline uk-width-1-1">
													<span class="uk-form-icon" uk-icon="icon: user"></span> <input
														required name="username" class="uk-input uk-form-large"
														type="text" placeholder="Username/Email address"
														value="${cookie.uid.value}" autocomplete="off" />
												</div>
											</div>
											<div class="uk-margin">
												<div class="uk-inline uk-width-1-1">
													<span class="uk-form-icon" uk-icon="icon: lock"></span> <input
														required name="password" class="uk-input uk-form-large"
														type="password" placeholder="Password"
														value="${cookie.pwd.value}" autocomplete="off" />
												</div>
											</div>
											<div class="uk-column-1-2 uk-margin">
												<div class="uk-grid-small uk-child-width-auto uk-grid">
													<label><input type="checkbox" name="remember"
														class="uk-checkbox" value="true" checked /> Remember me?</label>
												</div>
												<div class="uk-text-right@s uk-text-center uk-text-small">
													<a href="account/account-log.htm?forgot"
														uk-switcher-item="1">Forgot Password?</a>
												</div>
											</div>
											<div class="uk-margin verve-right">
												<button
													class="uk-button uk-button-primary verve-btn-primary"
													type="submit">Sign in</button>
											</div>
											<div class="uk-text-small uk-text-center">
												Not registered? <a href="account/account-log.htm?signup"
													uk-switcher-item="2">Create an account</a>
											</div>
										</form>
									</div>
								</li>
								<li>
									<h3 class="uk-card-title uk-text-center">Forgot your
										password?</h3>
									<p class="uk-text-center uk-width-medium@s uk-margin-auto">Enter
										your email address and we will send you a link to reset your
										password.</p>
									<div>
										<form action="account/account-log.htm?forgot" method="post">
											<div class="uk-margin">
												<div class="uk-inline uk-width-1-1">
													<span class="uk-form-icon" uk-icon="icon: mail"></span> <input
														required class="uk-input uk-form-large" type="text"
														placeholder="Email Address" name="email"
														autocomplete="off" />
												</div>
											</div>
											<div class="uk-column-1-2 uk-margin">
												<div class="uk-text-lighter uk-text-middle">
													<a href="account/account-log.htm?signin"
														uk-switcher-item="0"><span uk-icon="chevron-left"></span>
														Back to signin</a>
												</div>
												<div class="verve-right">
													<button
														class="uk-button uk-button-primary verve-btn-primary"
														type="submit">Send Email</button>
												</div>
											</div>
										</form>
									</div>
								</li>
								<li>
									<h3 class="uk-card-title uk-text-center">Sign up today.
										It's free!</h3>
									<div>
										<form:form name="formSignup" id="formSignup"
											action="account/account-log.htm?signup" method="post"
											modelAttribute="accountDTO">
											<div class="uk-margin">
												<div class="uk-inline uk-width-1-1">
													<span class="uk-form-icon" uk-icon="icon: user"></span>
													<form:input class="uk-input uk-form-large" type="text"
														placeholder="UserName" path="username" autocomplete="off" />
													<form:errors path="username" cssClass="uk-alert-danger" />
												</div>
											</div>

											<div class="uk-margin">
												<div class="uk-inline uk-width-1-1">
													<span class="uk-form-icon" uk-icon="icon: lock"></span>
													<form:input class="uk-input uk-form-large" type="password"
														placeholder="Password" path="password" autocomplete="off" />
													<form:errors path="password" cssClass="uk-alert-danger" />
												</div>
											</div>
											<div class="uk-margin">
												<div class="uk-inline uk-width-1-1">
													<span class="uk-form-icon" uk-icon="icon: lock"></span>
													<form:input class="uk-input uk-form-large" type="password"
														placeholder="Confirm Password" path="confirmPassword" autocomplete="off" />
														<form:errors path="confirmPassword" cssClass="uk-alert-danger" />
												</div>
											</div>
											<div class="uk-margin">
												<div class="uk-column-1-2">
													<div class="uk-inline uk-width-1-1">
														<span class="uk-form-icon" uk-icon="icon: users"></span>
														<form:input class="uk-input uk-form-large" type="text"
															placeholder="First Name" path="firstName"
															autocomplete="off" />
															<form:errors path="firstName" cssClass="uk-alert-danger" />
													</div>
													<div class="uk-width-1-1">
														<form:input class="uk-input uk-form-large" type="text"
															placeholder="Last Name" path="lastName"
															autocomplete="off" />
															<form:errors path="lastName" cssClass="uk-alert-danger" />
													</div>
												</div>
											</div>
											<div class="uk-margin">
												<div class="uk-inline uk-width-1-1">
													<span class="uk-form-icon" uk-icon="icon: mail"></span>
													<form:input class="uk-input uk-form-large" type="text"
														placeholder="Email Address" path="email"
														autocomplete="off" />
														<form:errors path="email" cssClass="uk-alert-danger" />
												</div>
											</div>
											<div class="uk-margin">
												<div class="uk-inline uk-width-1-1">
													<span class="uk-form-icon" uk-icon="icon: receiver"></span>
													<form:input class="uk-input uk-form-large" type="text"
														placeholder="Phone Number" path="phoneNum"
														autocomplete="off" />
														<form:errors path="phoneNum" cssClass="uk-alert-danger" />
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
														class="uk-button uk-button-primary verve-btn-primary "
														type="submit">Sign up</button>
												</div>
											</div>
											<div class="uk-text-small uk-text-center">
												Already have an account? <a
													href="account/account-log.htm?signin" uk-switcher-item="0">Sign
													in</a>
											</div>
										</form:form>
									</div>
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