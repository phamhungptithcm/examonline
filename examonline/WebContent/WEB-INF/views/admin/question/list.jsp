<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<table class="uk-table uk-table-hover uk-table-divider">
	<thead>
		<tr>
			<th class="uk-table-shrink">STT</th>
			<th class="uk-table-expand">Content</th>
			<th class="uk-width-small">Subject</th>
			<th class="uk-width-small">Created By</th>
			<th style="width: 4%"></th>
			<th style="width: 4%; color: #0081E4"><a
				href="admin/question/insert.htm" uk-icon="icon: plus"
				uk-tooltip="Add New"></th>
			<th style="width: 4%"></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="question" items="${questions}"
			varStatus="indexQuestion">
			<tr id="${question.questionId}">
				<td>${indexQuestion.index +1 }</td>
				<td style="word-wrap: break-word;">${question.content}</td>

				<td>${question.level == 1 ? 'Java Core': (question.level == 2 ? 'Java Servlet':'Spring MVC') }</td>
				<td>${question.createdBy}</td>
				<td><a href="#answer-${question.questionId}" uk-toggle
					uk-icon="icon: info"></a></td>
				<td><a href="admin/question/edit.htm?id=${question.questionId}"
					uk-icon="icon: pencil" uk-tooltip="Edit"></a></td>
				<td><a uk-icon="icon: trash" style="color: #F93434;"
					uk-tooltip="Move to trash"
					onclick="deleteData(${question.questionId},'question')"></a></td>
			</tr>
			<div id="answer-${question.questionId}" class="uk-flex-top" uk-modal>
				<div class="uk-modal-dialog uk-modal-body uk-margin-auto-vertical">

					<button class="uk-modal-close-default" type="button" uk-close></button>

					<div class="uk-modal-header uk-text-center">
						<h2 class="uk-modal-title">List Answer</h2>
					</div>
					<ul class="uk-list uk-list-divider">
						<c:forEach var="answer" items="${question.anwsers}"
							varStatus="indexA">
							<c:choose>
								<c:when test="${answer.status == true}">
									<li style="color: #F93434"><span class="verve-index">
											<c:if test="${indexA.index == 0}"> A.</c:if> <c:if
												test="${indexA.index == 1}"> B.</c:if> <c:if
												test="${indexA.index == 2}"> C.</c:if> <c:if
												test="${indexA.index == 3}"> D.</c:if>
									</span>${answer.content}</li>
								</c:when>
								<c:otherwise>
									<li><span class="verve-index"> <c:if
												test="${indexA.index == 0}"> A.</c:if> <c:if
												test="${indexA.index == 1}"> B.</c:if> <c:if
												test="${indexA.index == 2}"> C.</c:if> <c:if
												test="${indexA.index == 3}"> D.</c:if>
									</span>${answer.content}</li>
								</c:otherwise>
							</c:choose>

						</c:forEach>
					</ul>
				</div>
			</div>
		</c:forEach>
	</tbody>
</table>
