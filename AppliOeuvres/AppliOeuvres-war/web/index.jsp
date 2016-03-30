<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="lib/css/appStyles.css" rel="stylesheet" type="text/css"/>
        <link href="lib/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="lib/jquery-ui/jquery-ui.css" rel="stylesheet" type="text/css"/>        
        <script src="lib/jquery/jquery-2.1.3.min.js" type="text/javascript"></script>        
        <script src="lib/bootstrap/js/bootstrap.js" type="text/javascript"></script>
        <script src="lib/bootstrap/js/ui-bootstrap-tpls.js" type="text/javascript"></script>
        <script src="lib/jquery-ui/jquery-ui.js" type="text/javascript"></script>
        <title>Gestion des oeuvres</title>
    </head>
    <body class="body">       
        <div class="container">
            <c:import url="/menu.jsp"/>
            <div>
                <c:if test="${pageR != null}">
                    <c:import url="${pageR}"/>
                </c:if>
                <c:if test="${erreurR != null}">
                    <c:import url="/erreur.jsp"/>
                </c:if>   
            </div>
        </div>
    </body>
</html>
