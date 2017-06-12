<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="Header.jsp"/>

	<h1 class="text-center" ><img class="img-circle" src="add.jpg" height="100" width="100">Créer une nouvelle catégorie</h1>
	<br><br><br>
	<div>
	
	<!-- Form to add information in the new project -->
	
		<form class="col-lg-offset-3 col-sm-6" method="post"
			action="AddCategorie">
			<div class="form-group">
				<label class="control-label">Nom de catégorie : </label> <input
					type="text" class="form-control" name="nom_categorie">
			</div>
			<button class="pull-right btn btn-primary glyphicon glyphicon-plus"> Créer</button>
		</form>
	</div>


</body>
</html>