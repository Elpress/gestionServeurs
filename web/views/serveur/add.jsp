<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajout du Serveur</title>
</head>
<body>
<form action="Serveur" method="POST">
    <div class="form-group">
        <label class="form-control-label">Nom du Serveur</label>
        <input class="form-control" type="text" name="nomS">
    </div>
    <div class="form-group">
        <label class="form-control-label">Adrip du Serveur</label>
        <input class="form-control" type="text" name="adripS">
    </div>
    <div class="form-group">
        <select name="idL">
            <option name="nomL" value="">Choisissez un Local</option>
            <c:forEach items="${locals}" var="loc">
                <option value="${loc.idL}">${loc.nomL}</option>
            </c:forEach>
        </select>
    </div>

    <div class="form-group">
        <input type="submit" name="valider" value="Valider" class="btn btn-success"/>
        <input type="reset" name="annuler" value="Annuler" class="btn btn-danger" />
    </div>
</form>
</body>
</html>
