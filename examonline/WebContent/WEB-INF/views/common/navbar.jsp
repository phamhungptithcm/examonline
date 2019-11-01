<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<nav class="uk-navbar-container uk-container-expand" uk-navbar>
	<div class="uk-navbar-left">
		<ul class="uk-navbar-nav">
			<c:if test="${!empty user}">
				<c:if test="${user.isAdmin == true}">
					<li class="hp-brand"><a href="admin/home/index.htm">ExamOnline</a></li>
				</c:if>
				<c:if test="${user.isAdmin == false}">
					<li class="hp-brand"><a href="home/index.htm">ExamOnline</a></li>
				</c:if>
			</c:if>
		</ul>
	</div>

	<div class="uk-navbar-right">
		<ul class="uk-navbar-nav uk-visible@m">
			<c:if test="${!empty user}">
				<c:if test="${user.isAdmin == true}">
					<li><a href="#">Account Reference</a>
						<div class="uk-navbar-dropdown uk-navbar-dropdown-width-2">
							<div class="uk-navbar-dropdown-grid uk-child-width-1-2" uk-grid>
								<div>
									<ul class="uk-nav uk-navbar-dropdown-nav">
										<li class="uk-nav-header">Account</li>
										<li class="uk-nav-divider"></li>
										<li><a href="admin/account-management/index.htm">Manage Accounts</a></li>
										<li><a href="admin/account-status/index.htm">Manage Account Status</a></li>
										<li><a href="admin/account-plan/index.htm">Manage Account Plan</a></li>
									</ul>
								</div>
								<div>
									<ul class="uk-nav uk-navbar-dropdown-nav">
										<li class="uk-nav-header">Details</li>
										<li class="uk-nav-divider"></li>
										<li><a href="admin/student/index.htm">Manage Students</a></li>
										<li><a href="admin/person/index.htm">Manage Persons</a></li>
									</ul>
								</div>
							</div>
						</div></li>
					<li><a href="admin/quiz/index.htm">Quiz Reference</a></li>
					<li><a href="admin/question/index.htm">Q&A Reference</a></li>
				</c:if>
				<c:if test="${user.isAdmin == false}">
					<li><a href="account-management/account-overview.htm">Account
							Management</a></li>
				</c:if>
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
						<li class="uk-nav-header">GENERAL</li>
						<c:if test="${!empty user}">
							<c:if test="${user.isAdmin == true}">
								<li><a href="admin/home/index.htm"><span
										uk-icon="icon: home"></span> Home</a></li>
								<ul class="uk-nav uk-nav-default tm-nav uk-margin-top">
									<li class="uk-nav-header">Account Management</li>
									<li exact=""><a href="">Introduction</a></li>
									<li exact=""><a href="">Alert</a></li>
									<li exact=""><a href="">Align</a></li>
								</ul>
								<ul class="uk-nav uk-nav-default tm-nav uk-margin-top">
									<li class="uk-nav-header">Quiz Management</li>
									<li exact=""><a href="">Accordion</a></li>
									<li exact=""><a href="">Alert</a></li>
									<li exact=""><a href="">Align</a></li>
								</ul>
								<ul class="uk-nav uk-nav-default tm-nav uk-margin-top">
									<li class="uk-nav-header">Question Management</li>
									<li exact=""><a href="">Accordion</a></li>
									<li exact=""><a href="">Alert</a></li>
									<li exact=""><a href="">Align</a></li>
								</ul>
							</c:if>
							<c:if test="${user.isAdmin == false}">
								<li><a href="home/index.htm"><span uk-icon="icon: home"></span>
										Home</a></li>
								<li><a href="account-management/account-overview.htm">Account
										Management</a></li>
							</c:if>
							<li><a href="account/account-log.htm?signout"><span
									uk-icon="icon: sign-out"></span> Sign out</a></li>
						</c:if>
					</ul>
				</div>
			</div>
		</div>
	</div>
</nav>