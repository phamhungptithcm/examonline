const MESSAGE_CONFIRM = "Are you sure?";
const MESSAGE_WARNING= "You won't be able to revert this!";

const CONFIRM_YES = "Yes";
const CONFIRM_NO = "No";
var switchMode = document.getElementById("switchMode");

function updateAccountStatus(id) {
	if (switchMode.checked == false) {
		$.ajax({
			url : "admin/account-status/update.htm",
			data : {
				accountStatusId : id
			},
			dataType : "json",
			success : function(response) {
				$('#statusId').val(response.accountStatusId); 
				$('#code').val(response.accountStatusCode); 
				$('#shortDescription').val(response.shortDescription); 
			}
		});
	} else {
		this.showMessage('top-end','You are now in "Add New" mode.','warning');
	}
}
function updateQuiz(id) {
	$.ajax({
		url : "admin/quiz/update.htm",
		data : {
			examId : id
		},
		dataType : "json",
		success : function(response) {
			$('#examId').val(response.examId); 
			$('#score').val(response.score); 
		}
	});
}
function updateAccountPlan(id) {
	if (switchMode.checked == false) {
		$.ajax({
			url : "admin/account-plan/update.htm",
			data : {
				accountPlanId : id
			},
			dataType : "json",
			success : function(response) {
				$('#planId').val(response.accountPlanId); 
				$('#code').val(response.planCode); 
				$('#shortDescription').val(response.shortDescription); 
			}
		});
	} else {
		this.showMessage('top-end','You are now in "Add New" mode.','warning');
	}
}
function updateAccount(id) {
	if (switchMode.checked == false) {
		$.ajax({
			url : "admin/account-management/update.htm",
			data : {
				accountNumber : id
			},
			dataType : "json",
			success : function(response) {
				$('#accountNumber').val(response.accountNumber); 
				$('#username').val(response.username); 
				$('#password').val(response.password);
				$('#accountStatus').val(response.accountStatusId);
				$('#accountPlan').val(response.accountPlanId);
			}
		});
	} else {
		this.showMessage('top-end','You are now in "Add New" mode.','warning');
	}
}
function deleteData(id,mode) {
	var element = document.getElementById(id);
	const swalWithBootstrapButtons = Swal.mixin({
		  customClass: {
		    confirmButton: 'btn btn-success',
		    cancelButton: 'btn btn-danger'
		  },
		  buttonsStyling: false
		})

		swalWithBootstrapButtons.fire({
		  title: MESSAGE_CONFIRM,
		  text: MESSAGE_WARNING,
		  type: 'warning',
		  showCancelButton: true,
		  confirmButtonText: CONFIRM_YES,
		  cancelButtonText: CONFIRM_NO,
		  reverseButtons: true
		}).then((result) => {
		  if (result.value) {
			  this.getAction(id,mode);
		  }  else if (
		    result.dismiss === Swal.DismissReason.cancel
		  ) {
			  // Canceled
		  }
		});
}
function getAction(id,mode) {
	switch (mode) {
	case "account_status":
		this.deleteStatus(id);
		break;
	case "account_plan":
		this.deletePlan(id);
		break;
	case "account_main":
		this.deleteAccount(id);
		break;
	case "question":
		this.deleteQuestion(id);
		break;
	default:
		break;
	}
}
function deleteQuestion(id) {
	var element = document.getElementById(id);
	  $.ajax({
			url : "admin/question/delete.htm",
			data : {
				id : id
			},
			dataType : "json",
			success : function(response) {
				if (response != "0") {
					this.showMessage('top-end','Successful','success');
					element.remove();
				} else {
					this.showMessage('top-end','Deleted fail','error');
				}
			}
		});
}
function deleteStatus(id) {
	var element = document.getElementById(id);
	  $.ajax({
			url : "admin/account-status/delete.htm",
			data : {
				accountStatusId : id
			},
			dataType : "json",
			success : function(response) {
				if (response == true) {
					element.remove();
					this.showMessage('top-end','Successful','success');
				} else {
					this.showMessage('top-end','Deleted fail','error');
				}
			}
		});
}
function deletePlan(id) {
	var element = document.getElementById(id);
	  $.ajax({
			url : "admin/account-plan/delete.htm",
			data : {
				accountPlanId : id
			},
			dataType : "json",
			success : function(response) {
				if (response == true) {
					element.remove();
					this.showMessage('top-end','Successful','success');
				} else {
					this.showMessage('top-end','Deleted fail','error');
				}
			}
		});
}
function deleteAccount(id) {
	var element = document.getElementById(id);
	  $.ajax({
			url : "admin/account-management/delete.htm",
			data : {
				accountNumber : id
			},
			dataType : "json",
			success : function(response) {
				if (response != null) {
					var cell = element.cells;
					cell[3].innerHTML = response.accountStatus;
					cell[5].innerHTML = "";
					this.showMessage('top-end','Successful','success');
				} else {
					this.showMessage('top-end','Deleted fail','error');
				}
			}
		});
}

function showMessage(position, title, type) {
	const Toast = Swal.mixin({
		  toast: true,
		  position: position,
		  showConfirmButton: false,
		  timer: 3000
		})

		Toast.fire({
		  type: type,
		  title: title
		})
}
function updateResult(questionId, answerId) {
	var like = "fa-circle";
	var unlike = "fa-circle-thin";
	$.ajax({
		url : "exam/update-result.htm",
		data : {
			questionId : questionId,
			answerId : answerId
		},
		dataType : "json",
		success : function(response) {
			var dataQuestion = document
					.getElementsByClassName(response.questionId + "-display");
			var element = document.getElementById(response.answerId);
			if (dataQuestion[0] == element) {
				element.classList.remove(unlike);
				element.classList.add(like);
				dataQuestion[1].classList.remove(like);
				dataQuestion[1].classList.add(unlike);
				dataQuestion[2].classList.remove(like);
				dataQuestion[2].classList.add(unlike);
				dataQuestion[3].classList.remove(like);
				dataQuestion[3].classList.add(unlike);
			} else if (dataQuestion[1] == element) {
				element.classList.remove(unlike);
				element.classList.add(like);
				dataQuestion[0].classList.remove(like);
				dataQuestion[0].classList.add(unlike);
				dataQuestion[2].classList.remove(like);
				dataQuestion[2].classList.add(unlike);
				dataQuestion[3].classList.remove(like);
				dataQuestion[3].classList.add(unlike);
			} else if (dataQuestion[2] == element) {
				element.classList.remove(unlike);
				element.classList.add(like);
				dataQuestion[0].classList.remove(like);
				dataQuestion[0].classList.add(unlike);
				dataQuestion[1].classList.remove(like);
				dataQuestion[1].classList.add(unlike);
				dataQuestion[3].classList.remove(like);
				dataQuestion[3].classList.add(unlike);
			} else if (dataQuestion[3] == element) {
				element.classList.remove(unlike);
				element.classList.add(like);
				dataQuestion[0].classList.remove(like);
				dataQuestion[0].classList.add(unlike);
				dataQuestion[1].classList.remove(like);
				dataQuestion[1].classList.add(unlike);
				dataQuestion[2].classList.remove(like);
				dataQuestion[2].classList.add(unlike);
			}

		}
	});
}