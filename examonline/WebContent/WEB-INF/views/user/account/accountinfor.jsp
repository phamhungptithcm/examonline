<%@ page pageEncoding="utf-8"%>
<div class="uk-margin">
	<div class="row">
		<div class="col-md-6">
			<div>
				ACCOUNT ${personDetails.accountPlan} <span class="uk-badge">${personDetails.accountStatus}</span>
			</div>
			<div>#${personDetails.accountNumber }</div>
			<h2>${personDetails.fullName }</h2>
		</div>
		<div class="col-md-6">
			<ul class="uk-list">
				<li><span uk-icon="icon: mail"></span> ${personDetails.email }</li>
				<li><span uk-icon="icon: receiver"></span> ${personDetails.phoneNum }</li>
				<li><span uk-icon="icon: location"></span> ${personDetails.address }</li>
			</ul>
		</div>
	</div>
</div>
<div style="border-bottom: 2px solid black;">
	<div class="col-sm-6">
		<div class="uk-inline">
			<h3 class="uk-card-title">
				<a href><span class="uk-link-heading" id="verve-dropdown-title">${btnTitle}</span> <span
					uk-icon="icon: chevron-down"></span> </a>
			</h3>
			<div uk-dropdown="pos: bottom-justify">
				<ul class="uk-nav uk-dropdown-nav">
					<li class="uk-active"><a href="account/account-management.htm">Acount Overview</a></li>
					<li class="uk-nav-divider"></li>
					<!-- <li><a href="account/manage-appointment.htm">Manage Appointment</a></li> -->
					<li><a href="account/account-management.htm?editaccount">Edit Account Information</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>