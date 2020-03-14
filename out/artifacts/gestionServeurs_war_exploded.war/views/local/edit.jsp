<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modifier un local</title>
</head>
<body>
<form action="Local" method="POST">
    <div class="form-group">
        <label>ID Local</label>
        <input type="text" name="idL" readonly="" class="form-control" required="">
    </div>
    <div class="form-group">
        <label class="form-control-label">Nom du Local</label>
        <input class="form-control" type="text" name="nom">
    </div>
    <div class="form-group">
        <input type="submit" name="valider" value="Valider" class="btn btn-success"/>
        <input type="reset" name="annuler" value="Annuler" class="btn btn-danger" />
    </div>
</form>
</body>
</html>
