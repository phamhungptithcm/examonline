
function switchModes(data) {
	var formTitleUp = "Update" + data;
	var formTitleAdd = "Add new" + data;
	var switchModeTitleEdit = "EDIT";
	var switchModeTitleAdd = "ADD NEW";
	var formTitle = document.getElementById("formTitle");
	var switchModeTitle = document.getElementById("switchModeTitle");
	var accStatusForm = document.getElementById("accForm");
	var fieldDisable;
	if(data == 'account') {
		fieldDisable = document.getElementById("username");
	} else {
		fieldDisable = document.getElementById("code");
	}
	var switchMode = document.getElementById("switchMode");
	if (switchMode.checked == true) {
		switchModeTitle.innerHTML = switchModeTitleAdd;
		formTitle.innerHTML = formTitleAdd;
		accStatusForm.reset();
		fieldDisable.disabled = false;
		$('#accForm').attr('action', getActionForm(data,true));
	} else {
		switchModeTitle.innerHTML = switchModeTitleEdit;
		formTitle.innerHTML = formTitleUp;
		
		fieldDisable.disabled = true;
		$('#accForm').attr('action', getActionForm(data,false));
	}
}

function getActionForm(data,status) {
	var action = "";
	switch (data) {
	case "status":
		if(status == true) {
			action="admin/account-status/insert.htm";
		} else {
			action="admin/account-status/update.htm";
		}
		break;
	case "plan":
		if(status == true) {
			action="admin/account-plan/insert.htm";
		} else {
			action="admin/account-plan/update.htm";
		}
		break;
	case "account":
		if(status == true) {
			action="admin/account-management/insert.htm";
		} else {
			action="admin/account-management/update.htm";
		}
		break;
	default:
		break;
	}
	return action;
}
