
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
<table class="display nowrap" style="width:100%" id="templateDataTable">

	<thead>
	
		<tr>
		    
			<th>Account Num</th>
			<th>File Name</th>
			<th>File Location</th>
			<th>File Format</th>
			<th>File Type</th>
			<th>Download|Delete <input id="checkAll" onclick="checkAll();" type="checkbox"  class="custom-checkbox chkCheckBoxId" /></th>
		</tr>
	</thead>
	<tbody>
		
			<c:if test="${not empty documentList}">
			 <c:forEach var="document" items="${documentList}">
				<tr>
				<td>${document.accnum}</td>
				<td>${document.filename}</td>
				<td>${document.location}</td>
				<td>${document.doctype}</td>
				<td>${document.filecode}</td>
				<td>
				  <a href="/file/${document.filename}.${document.doctype}"><button class="btn btn-primary"  id="${document.id}" value="${document.id}">Download</button> </a>
						   
				<input id="${document.id}"  type="checkbox" name="docCheck" onclick="checkEach();" value="${document.id}" class="custom-checkbox chkCheckBoxId check-each" />
				</td>
				</tr>
			</c:forEach>
		</c:if>
	</tbody> 
</table>