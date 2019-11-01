<%@ page pageEncoding="utf-8"%>
<div class="uk-margin">
	<div class="row">
		<div class="col-md-6">
			<div>
				ACCOUNT ${infoDTOGlobal.accountPlan} <span class="uk-badge">${infoDTOGlobal.accountStatus}</span>
			</div>
			<div>#${infoDTOGlobal.accountNumber }</div>
			<h2>${infoDTOGlobal.fullName }</h2>
		</div>
		<div class="col-md-6">
			<ul class="uk-list">
				<li><span uk-icon="icon: mail"></span> ${infoDTOGlobal.email }</li>
				<li><span uk-icon="icon: receiver"></span> ${infoDTOGlobal.phoneNum }</li>
				<li><span uk-icon="icon: location"></span> ${infoDTOGlobal.address }</li>
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
					<li class="uk-active"><a href="account-management/account-overview.htm">Acount Overview</a></li>
					<li class="uk-nav-divider"></li>
					<li><a href="account-management/account-edit.htm">Edit Account Information</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>