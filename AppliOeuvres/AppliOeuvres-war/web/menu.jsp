<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse-target">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.oe">Accueil</a>
            </div>
            <div class="collapse navbar-collapse" id="navbar-collapse-target">
                <c:if test="${sessionScope.userId != null}">
                    <ul class="nav navbar-nav">
                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown">Oeuvres<b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="catalogue.oe">Lister</a></li>
                                <li><a href="ajouter.oe">Ajouter</a></li>
                            </ul>
                        </li>                           
                    </ul> 
                    <ul class="nav navbar-nav">
                        <li><a href="listeReservations.res">Réservations</a></li>
                    </ul>     
                </c:if>
                <ul class="nav navbar-nav navbar-right"> 
                    <c:if test="${sessionScope.userId != null}">
                        <li><a href="deconnecter.oe">Se déconnecter</a></li>
                    </c:if>  
                    <c:if test="${sessionScope.userId == null}">                   
                        <li><a href="login.oe">Se connecter</a></li>
                    </c:if>  
                </ul>
            </div>
        </div>
    </nav>
</div><!--/.container-fluid -->

