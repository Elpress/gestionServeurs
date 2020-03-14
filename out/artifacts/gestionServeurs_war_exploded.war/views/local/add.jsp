<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajout du Local</title>
</head>
<body>
<form action="Local" method="POST">
    <div class="form-group">
        <label class="form-control-label">Nom du local</label>
        <input class="form-control" type="text" name="nom">
    </div>
    <div class="form-group">
        <input type="submit" name="valider" value="Valider" class="btn btn-success"/>
        <input type="reset" name="annuler" value="Annuler" class="btn btn-danger" />
    </div>
</form>
</body>
</html>
