<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form id="filterForm" name="filterForm" method="POST" onsubmit="javascript: return true">
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

<div class="filter-container">
	<div class="filter-col filter-field-length">
		<label>Filter</label>
		<select id="daterange_pre" name="filterRange" onchange="setFilterDatesByDD()"></select>
	</div>
	<div class="filter-col filter-field-length">
		<label>From</label>
		<input type="text" id="fromDate" name="d1" class="form-control txt-field" value="${filterData.startDate}" />
	</div>
	<div class="filter-col filter-field-length">
		<label>To</label>
		<input type="text" id="toDate" name="d2"  class="form-control txt-field" value="${filterData.endDate}" />
	</div>
	
	<div class="filter-col filter-acct-field form-group has-feedback">
		<label>Account</label> 
		<input type="text" class="form-control txt-field" id="accountNum" maxlength="16" name="accountNum" value="${filterData.accountNum}"/>
	</div>
	<div class="filter-col filter-btn">
		<input type="button" id="searchBtn" value="Find" class="btn btn-primary btn-flat" />
	</div>
	<div class="filter-col filter-btn clear-btn">
		<input type="button" id="searchBtn" value="Clear" class="btn cancel-btn btn-primary btn-flat" onclick="javascript:clearFilters()"/>
	</div>
	
	<!-- 
	<input type="hidden" name="${_csrf.parameterName}" id="csrf_token" value="${_csrf.token}" />
	-->
							
	<input type="hidden" name="apiNames" id="apiNames"/>
</div>
	
</form>
<script src="lib/jquery.validate.min.js"></script>

<script type="text/javascript" >

var d1;
var d2;
var filteredAccountNum;

$(document).ready(
		
		function() {
			
			 d1 = $("#fromDate").val();
			 d2 = $("#toDate").val();
			 
			 var filterRange='${filterData.filterRange}';
			 
			 accountNum=$("#accountNum").val();
		
		  $( "#searchBtn" ).on( "click", function() {
				
				var d1 = $("#fromDate").val();
				var d2 = $("#toDate").val();

				/*var preRageDate=$('#daterange_pre').val();
				if(preRageDate && preRageDate.length>0){
					var dateRangeArr=preRageDate.split(":");
					if(!d1 && !d2){
						
						d1=moment(dateRangeArr[1],'x').format("MM/DD/YYYY");
						d2=moment(dateRangeArr[2],'x').format("MM/DD/YYYY");
						}
				}else{
					if(!d1 && !d2){
						alert('Please select a date range');
					}
				}*/
				
				applyFilters(d1,d2);
			});
			
			 $('#daterange_pre').append($("<option></option>").attr("value","Today").text('Today')); 
			 $('#daterange_pre').append($("<option></option>").attr("value","Yesterday").text('Yesterday')); 
			 $('#daterange_pre').append($("<option></option>").attr("value","Last7Days").text('Last 7 Days')); 
			 $('#daterange_pre').append($("<option></option>").attr("value","Last30Days").text('Last 30 Days')); 
			 $('#daterange_pre').append($("<option></option>").attr("value","ThisMonth").text('This Month')); 
			 $('#daterange_pre').append($("<option></option>").attr("value","LastMonth").text('Last Month'));
			 $('#daterange_pre').append($("<option></option>").attr("value","Custom").text('Custom'));
			 
			 
			  $("#daterange_pre").val(filterRange);
			  setFilterDatesByDD();
			 
			$('#fromDate').datepicker({autoclose:true,orientation:'top'});
			$('#toDate').datepicker({autoclose:true,orientation:'top'});
			
			$('#fromDate').datepicker('update',d1);
			$('#toDate').datepicker('update',d2);
			
			$('#daterange_pre').selectric();
	 }
	);

function clearFilters(){
	
	
	$('#fromDate').val('');
	$('#toDate').val('');
	$('#accountNum').val('');
	$('#daterange_pre').prop('selectedIndex',0);
	$('#daterange_pre').selectric('refresh');
	
	$('#apiNameFilter').prop('selectedIndex',0);
	$('#apiNameFilter').selectric('refresh');
	
}
</script>