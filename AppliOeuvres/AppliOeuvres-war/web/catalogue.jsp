<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div  class="col-md-11 col-md-offset-1">
    <h1 align='center'>Catalogue des oeuvres</h1>
    <table class="table table-bordered table-striped">
        <thead>
            <tr>
                <td>Titre</td>
                <td>Prix</td>
                <td>Prénom propriétaire</td>
                <td>Nom propriétaire</td>
                <td>Réserver</td>
                <td>Modifier</td>
                <td>Supprimer</td>                
            </tr>  
        </thead>
        <tbody>
            <c:forEach var="oeuvre" items="${lstOeuvresR}">
                <tr>
                    <td>${oeuvre.titre}</td>
                    <td>${oeuvre.prix}</td>
                    <td>${oeuvre.proprietaire.prenomProprietaire}</td>
                    <td>${oeuvre.proprietaire.nomProprietaire}</td>
                    <td><a class="btn btn-primary" href="reserver.res?id=${oeuvre.idOeuvre}">Réserver</a></td>
                    <td><a class="btn btn-primary" href="modifier.oe?id=${oeuvre.idOeuvre}">Modifier</a></td> 
                    <td><a class="btn btn-primary" onclick="javascript:if (confirm('Suppression confirmée ?')){ window.location='supprimer.oe?id=${oeuvre.idOeuvre}';}">Supprimer</a></td>                     
                </tr>
            </c:forEach>
        </tbody>
    </table>          
</div>
