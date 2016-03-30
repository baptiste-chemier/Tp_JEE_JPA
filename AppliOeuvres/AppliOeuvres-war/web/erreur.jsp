<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
<div class="form-group" >
    <div class="col-md-9  col-md-offset-3">
        <c:if test="${erreurR != ''}">         
            <div class="alert-danger" role="alert"> 
                <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                <c:out value="${erreurR}"/>                            
            </div>
        </c:if>        
    </div>
</div>