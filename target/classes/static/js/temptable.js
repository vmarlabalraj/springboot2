
$(document).ready(function () {
    $('#templateDataTable').dataTable();
    selectAll();
});
function selectAll(){

	$('#checkAll').click(function () {    
		if($('#checkAll').is(':checked')){
			table =	 $('#templateDataTable').DataTable();
			$(table.rows().nodes()).each(function (idx, tr) {
				$('input', tr).prop('checked', true); 
			});
		} else {
			$(table.rows().nodes()).each(function (idx, tr) {
				$('input', tr).prop('checked', false); 
			});
		} 
	});

	  // Changing state of CheckAll checkbox 
	  $(".check-each").click(function(){
	 
	    if($(".check-each").length == $(".check-each:checked").length) {
	      $("#checkAll").prop("checked", true);
	    } else {
	      $("#checkAll").prop("checked", false);
	    }

	  });
	}
	function checkAll(){
		var table =$('#templateDataTable tr');
	if($('#checkAll').is(':checked')){
		
		$(table).each(function (idx, tr) {
			$('input', tr).prop('checked', true); 
		});
		} else {
			$(table).each(function (idx, tr)  {
				$('input', tr).prop('checked', false); 
			});
		}

	}

	function checkEach(){
		  
	    if($(".check-each").length == $(".check-each:checked").length) {
	      $("#checkAll").prop("checked", true);
	    } else {
	      $("#checkAll").prop("checked", false);
	    }

	  };
function deleteFiles() {
	var table =	 $('#templateDataTable').DataTable();
	var checkedValues=$(table.rows().nodes()).find('input[type="checkbox"]:checkbox:checked').map(
				function () {
					return this.value;
				}).get().join(",");
   console.log("checkedValues"+checkedValues);
   //startLoading("Publishing Content...");
	$.ajax({
		type : "GET",
		url : "deletefiles.htm?checkedValues="+checkedValues,
		success : function(result) {
				$("#document").html(result);
				//stopLoading();
				//showMessage("Deleted the files successfully");
			
			
		},
		error : function() {
			
			if(checkedValues==""){
				console.log("Please select atleast one record to delete");
			}else{
				console.log("Unable to delete");
			}
			//stopLoading();
		}
	});

	return false;
}


$(function() {
$('#hiddenFiletype').val( $('#filetype :selected').text());
$('#filetype').change(function() {
    var x = $('#filetype :selected').text();
    $('#hiddenFiletype').val(x);
});
});

var startLoading = function(message) {

	if (message) {
		$("#spiinerText").html(message);
	} else {
		$("#spiinerText").html("Loading..Please wait");
	}

	$('#spinner').modal({
		backdrop : 'static',
		keyboard : false
	})
}

function uploadpdf() {
	var filetype=$('#filetype').val();
	$.ajax({
		type : "POST",
		url : "uploadpdf.htm",
		success : function(result) {		
			if(result==""){
				console.log("Content  Pulished. Please save before you hit publish");
			}
			
		},
		error : function() {
			
			console.log("Content not Pulished. Please save before you hit publish");
		}
	});

	return false;
}


function downloadFiles(id) {
	$.ajax({
		type : "GET",
		url : "download.htm?id="+id,
		success : function(result) {
			if(result==""){
				console.log("Content  Pulished. Please save before you hit publish");
			}
			
		},
		error : function() {
			
			console.log("Content not Pulished. Please save before you hit publish");
		}
	});

	return false;
}
