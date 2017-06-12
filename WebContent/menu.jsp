<%@page import="java.util.*,modell.Categorie"%>
<nav class="navbar navbar-default sidebar" role="navigation">
    <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-sidebar-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>      
    </div>
    <div class="collapse navbar-collapse" id="bs-sidebar-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Home<span style="font-size:16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-home"></span></a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">Catégorie<span class="caret"></span><span style="font-size:16px;" class=" pull-right hidden-xs showopacity glyphicon glyphicon-th-list"></span></a>
          <ul class="dropdown-menu forAnimate" role="menu">
          	<%
								DAO.ContactDAO L1 = new DAO.ContactDAO ();
								List DATA = L1.ListCategorie();
								Iterator IT = DATA.listIterator();
								while (IT.hasNext()) {
									modell.Categorie L2 = (modell.Categorie) IT.next();
							%>
						<li><a href="ListParCategorie.jsp?IdCategorie=<%=L2.getId_categorie()%>&NomCategorie=<%=L2.getNom_categorie()%>"><%=L2.getNom_categorie()%></a></li>
						  <li class="divider"></li>
						<%
								}
							%>
          
          
            
            <li><a href="ListContact.jsp">Tout</a></li>
            
          </ul>
        </li>          
        <li ><a href="AddContact.jsp">Nouveau Contact <span style="font-size:16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-user"></span></a></li>        
     
             <li ><a href="AddCategorie.jsp">Nouvelle Catégorie<span style="font-size:16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-tags"></span></a></li>
     
      </ul>
    </div>
  </div>
</nav>