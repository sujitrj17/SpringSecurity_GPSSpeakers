<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html lang="en">
<head>
<link rel="stylesheet" href="../../css/jquery.dataTables.min.css">
<script src="../../js/jquery-3.3.1.js"></script>
 <script src="../../js/controller.js"></script>
 <script src="../../js/jquery.dataTables.min.js"></script>

<script>
 $(document).ready(function() {
	 // Setup - add a text input to each footer cell
	    $('#speakerTable tfoot th').each( function () {
	        var title = $(this).text();
	        $(this).html( '<input type="text" placeholder="Search '+title+'" />' );
	    } );
	 
  var table=  $('#speakerTable').DataTable( {
       
    } );
    
 // Apply the search
    table.columns().every( function () {
        var that = this;
 
        $( 'input', this.footer() ).on( 'keyup change clear', function () {
            if ( that.search() !== this.value ) {
                that.search( this.value ).draw();
            }
        } );
    } );
 
} ); 

</script>
</head>
<body>

 <div class="container">
 <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <h2>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a></h2>
    </c:if>
 <center>
  <header>
   <h2>GPS Speakers Data Report</h2>
  </header>
  </center>
  <div class="container-fluid">
   
   <table id="speakerTable" class="display" style="width: 100%">
   <thead>
    <tr>
    
     <th>Website</th>
     <th>Name</th>
     <th>Position</th>
     <th>Email</th>
     <th>Contact No</th>
     <th>Address</th>
    </tr>
    </thead>
    <tbody>
      <c:forEach var="speakers" items="${speakers}">
      <tr>
     
      <td>${speakers.website}</td>
      <td>${speakers.name}</td>
      <td>${speakers.position}</td>
      <td>${speakers.email}</td>
      <td>${speakers.contactno}</td>
      <td>${speakers.address}</td>
     </tr> 
    </c:forEach>  
    </tbody>
     <tfoot>
    <tr>
    
     <th>Website</th>
     <th>Name</th>
     <th>Position</th>
     <th>Email</th>
     <th>Contact No</th>
     <th>Address</th>
    </tr>
    </tfoot>
   </table>
  </div>

 </div>
</body>
</html>