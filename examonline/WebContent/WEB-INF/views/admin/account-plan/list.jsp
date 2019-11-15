<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<table class="uk-table uk-table-hover uk-table-divider">
	<thead>
		<tr>
			<th>STT</th>
			<th>STATUS CODE</th>
			<th>SHORT DESCRIPTION</th>
			<th><a href="" uk-icon="icon: trash" style="color: #F93434;"
				uk-tooltip="Move all to trash"></a></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="plan" items="${accountPlans}" varStatus="indexPlan">
			<tr id="${plan.accountPlanId}"
				onclick="updateAccountPlan(${plan.accountPlanId})">
				<td>${indexPlan.index +1 }</td>
				<td>${plan.planCode}</td>
				<td>${plan.shortDescription}</td>
				<td><a uk-icon="icon: trash" style="color: #F93434;"
					uk-tooltip="Move to trash"
					onclick="deleteData(${plan.accountPlanId},'account_plan')"></a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>