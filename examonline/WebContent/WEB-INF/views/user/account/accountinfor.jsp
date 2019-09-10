<%@ page pageEncoding="utf-8"%>
<div class="uk-margin">
	<div class="row">
		<div class="col-md-6">
			<div>
				ACCOUNT STUDENT <span>Active</span>
			</div>
			<div>#000000345</div>
			<h2>Hung Pham</h2>
		</div>
		<div class="col-md-6">
			<ul class="uk-list">
				<li><span uk-icon="icon: mail"></span> phamhung.pitit@gmail.com</li>
				<li><span uk-icon="icon: receiver"></span> (036)-336 5053</li>
				<li><span uk-icon="icon: location"></span> Quang Phuong, Quang
					Trach, Quang Binh</li>
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
					<li class="uk-active"><a href="account/account-overview.htm" onclick="changeTitle('overview')">Acount Overview</a></li>
					<li class="uk-nav-divider"></li>
					<!-- <li><a href="account/manage-appointment.htm">Manage Appointment</a></li> -->
					<li><a href="account/edit-account.htm" onclick="changeTitle('accinfor')">Edit Account Information</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>