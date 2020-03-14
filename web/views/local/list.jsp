<jsp:include page="../../header.jsp"/>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- **********************************************************************************************************************************************************
MAIN SIDEBAR MENU
*********************************************************************************************************************************************************** -->
<!--sidebar start-->
<aside>
    <div id="sidebar" class="nav-collapse ">
        <!-- sidebar menu start-->
        <ul class="sidebar-menu" id="nav-accordion">
            <p class="centered"><a href="profile.html"><img src="public/template/img/3.jpg" class="img-circle" width="205"></a></p>
            <h5 class="centered">Elpress SERVER</h5>
            <li class="mt">
                <a class="active" href="Accueil">
                    <i class="fa fa-dashboard"></i>
                    <span>Accueil</span>
                </a>
            </li>
            <li class="sub-menu">
                <a href="javascript:;">
                    <i class="fa fa-th"></i>
                    <span>Data Tables</span>
                </a>
                <ul class="sub">
                    <li><a href="Local">Local</a></li>
                    <li><a href="Serveur">Serveur</a></li>
                </ul>
            </li>

            <li>
                <a href="google_maps.html">
                    <i class="fa fa-map-marker"></i>
                    <span>Google Maps </span>
                </a>
            </li>
        </ul>
        <!-- sidebar menu end-->
    </div>
</aside>
<!--sidebar end-->
<!-- **********************************************************************************************************************************************************
MAIN CONTENT
*********************************************************************************************************************************************************** -->
<!--main content start-->
<section id="main-content">
    <section class="wrapper">
        <div class="row">
            <div class="col-lg-9 main-chart">
                <!--CUSTOM CHART START -->
                <div class="border-head">
                    <h3>LIST</h3>
                </div>

                <div class="card-body">
                    <table class="table table-bordered table-striped">
                        <tr>
                            <th>Identifiant</th>
                            <th>Nom du Local</th>
                            <th>Action</th>
                            <th>Action</th>
                        </tr>
                        <c:forEach items="${locals}" var="L">
                            <tr>
                                <td>${L.idL}</td>
                                <td>${L.nomL}</td>
                                <td><a class="btn btn-success" href="edit.jsp?idT=${typel.idL}">Editer</a></td>
                                <td><a class="btn btn-danger" href="delete.jsp?idT=${typel.idL}">Supprimer</a></td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>

                <!--custom chart end-->
                <div class="row mt">
                    <!-- SERVER STATUS PANELS -->
                    <div class="col-md-4 col-sm-4 mb">
                        <div class="grey-panel pn donut-chart">
                            <div class="grey-header">
                                <h5>SERVER LOAD</h5>
                            </div>
                            <canvas id="serverstatus01" height="120" width="120"></canvas>
                            <script>
                                var doughnutData = [{
                                    value: 70,
                                    color: "#FF6B6B"
                                },
                                    {
                                        value: 30,
                                        color: "#fdfdfd"
                                    }
                                ];
                                var myDoughnut = new Chart(document.getElementById("serverstatus01").getContext("2d")).Doughnut(doughnutData);
                            </script>
                            <div class="row">
                                <div class="col-sm-6 col-xs-6 goleft">
                                    <p>Usage<br/>Increase:</p>
                                </div>
                                <div class="col-sm-6 col-xs-6">
                                    <h2>21%</h2>
                                </div>
                            </div>
                        </div>
                        <!-- /grey-panel -->
                    </div>
                    <!-- /col-md-4-->
                    <div class="col-md-4 col-sm-4 mb">
                        <div class="darkblue-panel pn">
                            <div class="darkblue-header">
                                <h5>SERVERS STATICS</h5>
                            </div>
                            <canvas id="serverstatus02" height="120" width="120"></canvas>
                            <script>
                                var doughnutData = [{
                                    value: 60,
                                    color: "#1c9ca7"
                                },
                                    {
                                        value: 40,
                                        color: "#f68275"
                                    }
                                ];
                                var myDoughnut = new Chart(document.getElementById("serverstatus02").getContext("2d")).Doughnut(doughnutData);
                            </script>
                            <p>Fevrier 16, 2020</p>
                            <footer>
                                <div class="pull-left">
                                    <h5><i class="fa fa-hdd-o"></i> 17 GB</h5>
                                </div>
                                <div class="pull-right">
                                    <h5>60% Used</h5>
                                </div>
                            </footer>
                        </div>
                        <!--  /darkblue panel -->
                    </div>
                    <!-- /col-md-4 -->
                    <div class="col-md-4 col-sm-4 mb">
                        <!-- REVENUE PANEL -->
                        <div class="green-panel pn">
                            <div class="green-header">
                                <h5>LOCAL</h5>
                            </div>
                            <div class="chart mt">
                                <div class="sparkline" data-type="line" data-resize="true" data-height="75" data-width="90%" data-line-width="1" data-line-color="#fff" data-spot-color="#fff" data-fill-color="" data-highlight-line-color="#fff" data-spot-radius="4" data-data="[200,135,667,333,526,996,564,123,890,464,655]"></div>
                            </div>
                            <p class="mt"><b>$ 17,980</b><br/>Month Income</p>
                        </div>
                    </div>
                    <!-- /col-md-4 -->
                </div>

                <!-- /row -->
            </div>
            <!-- /col-lg-9 END SECTION MIDDLE -->
            <!-- **********************************************************************************************************************************************************
                RIGHT SIDEBAR CONTENT
                *********************************************************************************************************************************************************** -->
            <div class="col-lg-3 ds">
                <!--COMPLETED ACTIONS DONUTS CHART-->
                <div class="donut-main">
                    <h4>FORMULAIRE</h4>
                </div>

                <div class="card-body">
                    <jsp:include page="add.jsp" />
                </div>

                <!-- CALENDAR-->
                <div id="calendar" class="mb">
                    <div class="panel green-panel no-margin">
                        <div class="panel-body">
                            <div id="date-popover" class="popover top" style="cursor: pointer; disadding: block; margin-left: 33%; margin-top: -50px; width: 175px;">
                                <div class="arrow"></div>
                                <h3 class="popover-title" style="disadding: none;"></h3>
                                <div id="date-popover-content" class="popover-content"></div>
                            </div>
                            <div id="my-calendar"></div>
                        </div>
                    </div>
                </div>
                <!-- / calendar -->

            </div>
            <!-- /col-lg-3 -->
        </div>
        <!-- /row -->
    </section>
</section>
<!--main content end-->

<jsp:include page="../../footer.jsp"/>


