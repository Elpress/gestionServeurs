<jsp:include page="../../header.jsp"/>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-xl-8 col-lg-7">
    <div class="card shadow mb-4">
        <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
            <h6 class="m-0 font-weight-bold text-primary">Liste</h6>
        </div>
        <div class="card-body">
            <table class="table table-bordered table-striped">
                <tr>
                    <th>Identifiant</th>
                    <th>Nom du Local</th>
                    <th>Action</th>
                    <th>Action</th>
                </tr>
                <c:forEach items="${typelocal}" var="typel">
                    <tr>
                        <td>${typel.idL}</td>
                        <td>${typel.nomL}</td>
                        <td><a class="btn btn-success" href="edit.jsp?idT=${typel.idL}">Editer</a></td>
                        <td><a class="btn btn-danger" href="delete.jsp?idT=${typel.idL}">Supprimer</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>

<div class="col-xl-4 col-lg-5">
    <div class="card shadow mb-4">
        <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
            <h6 class="m-0 font-weight-bold text-primary">Formulaire</h6>
        </div>
        <!-- Card Body -->
        <div class="card-body">
            <jsp:include page="add.jsp"/>
        </div>
    </div>
</div>

<jsp:include page="../../footer.jsp"/>


