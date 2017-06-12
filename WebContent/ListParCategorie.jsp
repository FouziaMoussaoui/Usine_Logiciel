<!-- Jsp file for displaying list of projects already exist -->

<%@page language="java"
	import="modell.Contact,java.util.*"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<html>

<head>
<title>Gestion des contact</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="contact.css">
<!-- DataTable -->
<script type="text/javascript" src="//code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css"/>
<link href="Style.css"/>
</head>
<jsp:include page="menu.jsp"/>

	<script type="text/javascript">

	$(document).ready(function() {
	    $('#example').DataTable();
	} );



	</script>
	<style>


 body{
background-image: url("bg.png") ;

}
html{
background-image: url("bg_.jpg")  ;

}

</style>
<body class="container">
	<h1 class="text-center"><img class="img-circle" src="admin.png" height="100" width="100">Categorie:<%=request.getParameter("NomCategorie") %></h1>
	<br>
	<br>
	<br>
	
	<div class="col-lg-offset-2 col-sm-7 well">
			
<table id="example" class="display" cellspacing="0" width="90%">			<thead>
				<tr>

					<th class="text-center" >Nom et Prenom</th>
					<th class="text-center" >N° Tel</th>
					<th class="text-center" >Type Tel</th>
					<th></th>
					<th></th>
					


				</tr>
			</thead>
			<tbody>
			<%
			DAO.ContactDAO l1 = new DAO.ContactDAO();
			int id_categorie=Integer.parseInt(request.getParameter("IdCategorie"));

				List data1 = l1.List_Par_Categorie(id_categorie);

				Iterator it1 = data1.listIterator();
				

				while (it1.hasNext()) {
					Contact l2 = (Contact) it1.next();

			%>
			<tr class="text-center">
				<td><a"><%=l2.getNom()+"  "+l2.getPrenom()%></a></td>
				<td><a"><%=l2.getNum_tel()%></a></td>
				<td><a"><%=l2.getType_tel()%></a></td>
				<td><a href="DeleteContact?IdContact=<%=l2.getId_contact()%>" class="glyphicon glyphicon-trash" style="color:red"></a></td>
				<td><a href="UpdateContact.jsp?IdContact=<%=l2.getId_contact()%>" class="glyphicon glyphicon-cog" style="color:green"></a></td>
				
				
				
			</tr>
			<%}%>	
			</tbody>
			
			
				</table>
			
			
			
			
			
						

    </table>

	</div>

</body>

</html>
