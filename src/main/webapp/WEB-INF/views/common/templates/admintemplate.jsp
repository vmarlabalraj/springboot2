<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%-- <%@page import="com.ms.admin.web.security.SecurityHelper"%> --%>

<!doctype html>
<html class="no-js" lang="">
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>ePortal Admin Dashboard</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://fonts.googleapis.com/css?family=Lato:400,700,700i,900"
	rel="stylesheet">

<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/dataTables.bootstrap.css">
<link rel="stylesheet" href="css/jquery-ui.min.css">
<link rel="stylesheet" href="css/selectric.css">
<link rel="stylesheet" href="css/buttons.dataTables.min.css">
<link rel="stylesheet" href="css/bootstrap-datepicker.min.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/select/1.3.0/css/select.dataTables.min.css">
<link href="lib/google-code-prettify/prettify.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="css/font-awesome.min.css" rel="stylesheet">
<link
	href="https://netdna.bootstrapcdn.com/font-awesome/3.0.2/css/font-awesome.css"
	rel="stylesheet">

<link rel="stylesheet" href="css/spinner.css">
<link rel="stylesheet" href="css/admin.css">
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script
	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/select/1.3.0/js/dataTables.select.min.js"></script>

<script src="lib/jquery-3.1.0.min.js"></script>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/buttons/1.5.6/js/dataTables.buttons.min.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/buttons/1.5.6/js/buttons.flash.min.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/buttons/1.5.6/js/buttons.html5.min.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/buttons/1.5.6/js/buttons.print.min.js"></script>


<script src="lib/jquery-3.1.0.min.js"></script>
<script src="lib/jquery-ui.min.js"></script>
<script src="lib/jquery.ui.widget.js"></script>
<script src="lib/bootstrap.min.js"></script>
<script src="lib/jquery.fileupload.js"></script>
<script src="lib/jquery.selectric.min.js"></script>
<script src="lib/jquery.dataTables.min.js"></script>
<script src="lib/dataTables.bootstrap.min.js"></script>
<script src="lib/dataTables.buttons.min.js"></script>
<script src="lib/moment.min.js"></script>
<script src="lib/bootstrap-datepicker.min.js"></script>
<script src="lib/google-code-prettify/prettify.js"></script>
<script src="lib/jquery.hotkeys.js"></script>
<script src="lib/bootstrap-wysiwyg.js"></script>

<script src="https://cdn.tinymce.com/4/tinymce.min.js"></script>
<script src="js/menu.js"></script>
<script src="js/main.js"></script>
<script src="js/common.js"></script>

<script src="js/accountManagement.js"></script>
<script src="js/alerts.js"></script>
<script src="js/content.js"></script>
<script src="js/errors.js"></script>
<script src="js/payment.js"></script>
<script src="js/rebates.js"></script>
<script src="js/listmanagement.js"></script>
<script src="js/users.js"></script>
<script src="js/roles.js"></script>
<script src="js/templates.js"></script>
<script src="js/cobrowse.js"></script>
<script src="js/document.js"></script>
</head>

<script>
	var csrf_token = '${_csrf.token}';
</script>
<body>

	<%-- <form action="${adminaccessurl}" id="guest_screen" method="post"
		target="_blank" rel="noopener noreferrer" onsubmit="return true">
		<input type="hidden" name="token" id="token"
			value=" <%=session.getAttribute("adminToken")%>"> <input
			type="hidden" name="custId" id="custId" value=""> <input
			type="hidden" name="userId" id="adminUserId"
			value="<%=SecurityHelper.getUserDetails().getUsername()%>">
	</form> --%>

	<!-- Modal -->
	<div class="modal fade" id="spinner" role="dialog" style="top: 200px;">
		<div class="modal-dialog" style="margin: auto; width: 300px;">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-body"
					style="background-color: black !important; color: white">
					<div class="sk-cube-grid">
						<div class="sk-cube sk-cube1"></div>
						<div class="sk-cube sk-cube2"></div>
						<div class="sk-cube sk-cube3"></div>
						<div class="sk-cube sk-cube4"></div>
						<div class="sk-cube sk-cube5"></div>
						<div class="sk-cube sk-cube6"></div>
						<div class="sk-cube sk-cube7"></div>
						<div class="sk-cube sk-cube8"></div>
						<div class="sk-cube sk-cube9"></div>
					</div>
					<p class="loader" id="spiinerText">Loading...Please wait</p>
				</div>
			</div>
		</div>

	</div>


	<tiles:insertAttribute name="header" ignore="true"></tiles:insertAttribute>
	<tiles:insertAttribute name="body" ignore="true"></tiles:insertAttribute>
	<tiles:insertAttribute name="footer" ignore="true"></tiles:insertAttribute>

	<div id="alert_dialog_div"></div>
	<div id="confirm_dialog_div"></div>
	<div id="notification_dialog_div"></div>
	<script>
		function notificationMessage(msg) {
			$('#notification_dialog_div').dialog({
				title : "Notification Deatils",
				resizable : false,
				modal : true,
				open : function() {
					var markup = msg;
					$(this).html(markup);
				},
				buttons : {
					"OK" : function() {
						$(this).dialog("close");
					}
				}
			});
		}

		function showMessage(msg) {
			$('#alert_dialog_div').dialog({
				title : "Message",
				resizable : false,
				modal : true,
				open : function() {
					var markup = msg;
					$(this).html(markup);
				},
				buttons : {
					"OK" : function() {
						$(this).dialog("close");
					}
				}
			});
		}

		function showConfirmDialog(msg) {
			var def = $.Deferred();
			$("#dialog:ui-dialog").dialog("destroy");
			$("#confirm_dialog_div").dialog({
				resizable : false,
				title : "Confirm",
				height : 140,
				width : 400,
				modal : true,
				open : function() {
					var markup = msg;
					$(this).html(markup);
				},
				buttons : {
					"Yes" : function() {
						$(this).dialog("close");
						def.resolve();
					},
					"Cancel" : function() {
						$(this).dialog("close");
						def.reject();
					}
				}
			});

			return def.promise();
		}
	</script>
</body>
</html>
