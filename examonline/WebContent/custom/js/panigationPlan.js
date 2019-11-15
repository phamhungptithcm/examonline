var pageNo = 0;
var pageSize = 5;
var pageCount = 0;

function getPage() {
	$.ajax({
		url : "admin/account-plan/get-page.htm",
		data : {
			pageNo : pageNo,
			pageSize : pageSize
		},
		success : function(response) {
			$("#result").html(response);
			document.getElementById("curpage").innerHTML = (pageNo + 1)
					+ " of " + pageCount + " pages";
		}
	});
}

$(function() {
	$.ajax({
		url : "admin/account-plan/get-page-count.htm",
		data : {
			pageSize : pageSize
		},
		success : function(response) {
			pageCount = response;
			getPage();
		}
	});

	$(".pager a:first").click(function() {
		if (pageNo > 0) {
			pageNo--;
			getPage();
		}
		return false;
	});

	$(".pager a:last").click(function() {
		if (pageNo < pageCount - 1) {
			pageNo++;
			getPage(this.urlGetData);
		}
		return false;
	});
});