<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<nav class="uk-navbar-container uk-container-expand" uk-navbar>
	<div class="uk-navbar-left">
		<ul class="uk-navbar-nav">
			<li class="hp-brand"><a href="home/index.htm">ExamOnline</a></li>
		</ul>
	</div>

	<div class="uk-navbar-right">
		<ul class="uk-navbar-nav uk-visible@m">
			<c:if test="${!empty user}">
				<li><a href="account/account-management.htm">Manage Working
						Account</a></li>

				<li><a href="#"><span uk-icon="icon: user"></span>
						${user.userName} <span uk-icon="chevron-down"></span></a>
					<div class="uk-navbar-dropdown">
						<ul class="uk-nav uk-navbar-dropdown-nav">
							<li><a href="account/account-log.htm?signout"><span
									uk-icon="icon: sign-out"></span> Sign out</a></li>
						</ul>
					</div></li>
			</c:if>
		</ul>
		<a uk-navbar-toggle-icon="" href="#offcanvas" uk-toggle=""
			class="uk-navbar-toggle uk-hidden@m uk-navbar-toggle-icon uk-icon"><svg
				width="10" height="10" viewBox="0 0 10 10"
				xmlns="http://www.w3.org/2000/svg">
        </svg></a>
		<div id="offcanvas" uk-offcanvas="mode: push; overlay: true"
			class="uk-offcanvas">
			<div class="uk-offcanvas-bar">
				<div class="uk-panel">
					<ul class="uk-nav uk-nav-default tm-nav">
						<li class="uk-nav-header">ExamOnline</li>
					</ul>
					<ul class="uk-nav uk-nav-default tm-nav">
						<li class="uk-nav-header"><span uk-icon="icon: user"></span>HungPham</li>
						<li class="uk-active"><a href="account/account-log.htm?signout">Sign Out</a></li>
					</ul>
					<ul class="uk-nav uk-nav-default tm-nav">
						<li class="uk-nav-header">Manage Working Account</li>
						<li class="uk-active"><a href="account/account-management.htm?editaccount">Edit Account
								Information</a></li>
						<li class="uk-active"><a href="account/account-management.htm">Account Overview</a></li>
						<!-- <li class="uk-active"><a href="account/account-management.htm?appoitment">Manage Appointment</a></li> -->
					</ul>
				</div>
			</div>
		</div>
	</div>
</nav>