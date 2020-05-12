<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>ePortal Admin Dashboard</title>
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">

<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/dataTables.bootstrap.css">
<link rel="stylesheet" href="css/buttons.dataTables.min.css">
<link rel="stylesheet" href="css/selectric.css">
<link rel="stylesheet" href="css/bootstrap-datepicker.min.css">
 
<link rel="stylesheet" href="dashboard/analytics.css">
<link rel="stylesheet" href="css/admin.css">

<script src="lib/charts/fusioncharts.js"></script>
<script src="lib/charts/fusioncharts.charts.js"></script>
<script src="lib/charts/fusioncharts.theme.fint.js"></script>

</head>
<body>
<script>
var csrf_token='${_csrf.token}';


var openLink = function(link){
	window.open(link);
}

</script>


<div class="modal fade" id="spinner" role="dialog" style="top: 300px;;">
			<div class="modal-dialog">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-body">
						<p class="loader" id="spiinerText" style="text-align:center;">Loading...Please wait</p>
					</div>
				</div>
			</div>
		</div>
		
	<script src="lib/jquery-3.1.0.min.js"></script>
	
	<tiles:insertAttribute name="header" ignore="true"></tiles:insertAttribute>
	<tiles:insertAttribute name="body" ignore="true"></tiles:insertAttribute>
	<tiles:insertAttribute name="footer" ignore="true"></tiles:insertAttribute>
	
	<script src="lib/jquery-ui.min.js"></script>
	<script src="lib/bootstrap.min.js"></script>
	<script src="lib/moment.min.js"></script>
	<script src="lib/jquery.selectric.min.js"></script>
	<script src="lib/jquery.dataTables.min.js"></script>
	<script src="lib/dataTables.bootstrap.min.js"></script>
	<script src="lib/dataTables.buttons.min.js"></script>
	<script src="lib/bootstrap-datepicker.min.js"></script>
	<script src="lib/jszip.min.js"></script>
	<script src="lib/buttons.html5.min.js"></script>
	
    <script src="js/menu.js"></script>
    <script src="js/common.js"></script>

</body>
</html>
