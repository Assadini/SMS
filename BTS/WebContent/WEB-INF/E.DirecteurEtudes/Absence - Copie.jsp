<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Absence</title>

<meta http-equiv="content-type" content="text/html; charset=utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/all.min.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css" type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/dataTables.bootstrap.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/jquery.dataTables.min.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/fontawesome.min.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstap.min.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/jquery-ui.min.css"
	type="text/css">

<style type="text/css">
body {
	background-color: #fff;
}
/* Modal confirm **/
.modal-confirm {
	color: #636363;
	width: 325px;
}

.modal-confirm .modal-content {
	padding: 20px;
	border-radius: 5px;
	border: none;
}

.modal-confirm .modal-header {
	border-bottom: none;
	position: relative;
}

.modal-confirm h4 {
	width: 100%;
	text-align: center;
	font-size: 26px;
	margin: 30px 0 -15px;
}

.modal-confirm .form-control, .modal-confirm .btn {
	min-height: 40px;
	border-radius: 3px;
}

.modal-confirm .close {
	position: absolute;
	top: -5px;
	right: -5px;
}

.modal-confirm .modal-footer {
	border: none;
	text-align: center;
	border-radius: 5px;
	font-size: 13px;
}

.modal-confirm .icon-box {
	color: #fff;
	position: absolute;
	margin: 0 auto;
	left: 0;
	right: 0;
	top: -70px;
	width: 95px;
	height: 95px;
	border-radius: 50%;
	z-index: 9;
	/* background: #82ce34; */
	padding: 15px;
	text-align: center;
	box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.1);
}

.modal-confirm .icon-box i {
	font-size: 58px;
	position: relative;
	top: 3px;
}

.modal-confirm.modal-dialog {
	margin-top: 80px;
}

.modal-confirm .btn {
	color: #fff;
	border-radius: 4px;
	text-decoration: none;
	transition: all 0.4s;
	line-height: normal;
	border: none;
	width: 100%;
}

/****/
.page-header h3 {
	padding: 10px;
}

.panel-primary {
	border: 1px solid #3071a9 !important;
}

.panel-body {
	padding: 20px;
}

.panel.with-nav-tabs .panel-heading {
	padding: 5px 5px 0 5px;
	background-color: #3071a9;
}

.panel.with-nav-tabs.panel-body {
	padding: 10px 15px;
}

.panel.with-nav-tabs .nav-tabs {
	border-bottom: none;
}

.panel.with-nav-tabs .nav-justified {
	margin-bottom: -1px;
}
/* PANEL PRIMARY */
.with-nav-tabs.panel-primary .nav-tabs>a, .with-nav-tabs.panel-primary .nav-tabs>a:hover,
	.with-nav-tabs.panel-primary .nav-tabs>a:focus {
	color: #fff;
}

.with-nav-tabs.panel-primary .nav-tabs>.open>a, .with-nav-tabs.panel-primary .nav-tabs>.open>a:hover,
	.with-nav-tabs.panel-primary .nav-tabs>.open>a:focus, .with-nav-tabs.panel-primary .nav-tabs>a:hover,
	.with-nav-tabs.panel-primary .nav-tabs>a:focus {
	color: #fff;
	background-color: #3071a9;
	border-color: transparent;
}

.with-nav-tabs.panel-primary .nav-tabs>a.active, .with-nav-tabs.panel-primary .nav-tabs>a.active>a:hover,
	.with-nav-tabs.panel-primary .nav-tabs>a.active>a:focus {
	color: #428bca;
	background-color: #fff;
	border-color: #428bca;
	border-bottom-color: transparent;
}

.with-nav-tabs.panel-primary .nav-tabs>li.dropdown .dropdown-menu {
	background-color: #428bca;
	border-color: #3071a9;
}

.with-nav-tabs.panel-primary .nav-tabs>li.dropdown .dropdown-menu>li>a {
	color: #fff;
}

.with-nav-tabs.panel-primary .nav-tabs>li.dropdown .dropdown-menu>li>a:hover,
	.with-nav-tabs.panel-primary .nav-tabs>li.dropdown .dropdown-menu>li>a:focus
	{
	background-color: #3071a9;
}

.with-nav-tabs.panel-primary .nav-tabs>li.dropdown .dropdown-menu>.active>a,
	.with-nav-tabs.panel-primary .nav-tabs>li.dropdown .dropdown-menu>.active>a:hover,
	.with-nav-tabs.panel-primary .nav-tabs>li.dropdown .dropdown-menu>.active>a:focus
	{
	background-color: #4a9fe9;
}
/****/
input.error {
	border-color: #f00 !important;
}

small.required {
	color: #f00;
}

.stat {
	border-radius: 50%;
	background-color: blue;
	width: 300px;
	height: 300px;
	display: inline-flex;
	margin-right: 60px;
}

.main {
	display: flex;
	align-items: center;
	justify-content: center;
}

.modal-backdrop {
	/* display: none; */
	
}
/* Data Table **/
.pie {
	border: black 2px;
}

canvas {
	max-width: 550px;
	max-height: 400px;
}
</style>
</head>
<body>
	<div class="wrapper d-flex align-items-stretch">
		<nav id="sidebar" class="active">
		<h1>
			<a href="index.html" class="logo"><span class="fa fa-cubes"></span></a>
		</h1>
		<%@include file="MenuDirecteurEtudes.jsp"%> </nav>
		<!-- Page Content  -->
		<div id="content" class="container">
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<div class="container-fluid">

				<button type="button" id="sidebarCollapse" class="btn btn-primary">
					<i class="fa fa-bars"></i> <span class="sr-only">Toggle Menu</span>
				</button>
				<button class="btn btn-dark d-inline-block d-lg-none ml-auto"
					type="button" data-toggle="collapse"
					data-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<i class="fa fa-bars"></i>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="nav navbar-nav ml-auto">
						<li class="nav-item active"><a class="nav-link" href="#"><span
								class="fa fa-home mr-2"></span></a></li>
						<li class="nav-item"><a class="nav-link" href="#"><span
								class="fa fa-envelope mr-2"></span></a></li>
						<li class="nav-item"><a class="nav-link" href="#"><span
								class="fa fa-bell mr-2"></span></a></li>
						<li class="nav-item">
							<div class="dropdown">
								<button class="btn btn-default dropdown-toggle" type="button"
									id="menu1" data-toggle="dropdown">
									<img
										src="${pageContext.request.contextPath}/Document/Download?file=${sessionScope.userPhoto}"
										class="rounded-circle" style="width: 20px; height: 20px;">

								</button>
								<div class="dropdown-menu dropdown-menu-right" role="menu">
									<div class="dropdown-item text-center">
										<img
											src="${pageContext.request.contextPath}/Document/Download?file=${sessionScope.userPhoto}"
											class="rounded-circle" style="width: 60px; height: 60px;">

									</div>
									<h5 class="dropdown-header text-primary text-center">${sessionScope.userFirstName_Fr}
										&nbsp; ${sessionScope.userLastName_Fr}</h5>
									<h5 class="dropdown-header text-muted text-center">${sessionScope.userRole}</h5>
									<div class="dropdown-divider"></div>
									<a class="dropdown-item"
										href="${pageContext.request.contextPath}/E.DirecteurEtudes/Profile?userId=${sessionScope.userID}">
										<span class="fa fa-id-card mr-2"></span> Profile
									</a>
									<div class="dropdown-divider"></div>
									<a class="dropdown-item"
										href="${pageContext.request.contextPath}/Logout"> <span
										class="fa fa-external-link-square-alt mr-2"></span>
										Déconnexion
									</a>
								</div>
							</div>
						</li>

					</ul>
				</div>
			</div>
			</nav>
			<!-- Start content -->

			<div class="container">
				<!-- Col 0 -->
				<div class="alert bg-light text-muted">
					<div class="alert bg-light text-secondary" role="alert">
						<i class="fa fa-list-ol mr-2"></i> Absence<br>
						<select id="try_Selector" class="form-control"
							name="anneScolaireCourante"
							style="width: 250px; display: inline;" required></select> <select
							id="anneeScolaireCourante_Selector" class="form-control"
							name="anneScolaireCourante"
							style="width: 250px; display: inline;" required></select> <input
							type="date" id="date_Selector"
							style="width: 250px; display: inline;" class="form-control">
					</div>
				</div>
				<!--/ Col 0 -->
				<div class="row">
					<div class="col-md-9">
						<!-- Col 1 -->
						<div class="panel with-nav-tabs panel-primary">
							<div class="panel-heading">
								<nav class="nav nav-tabs flex-column flex-sm-row"
									id="Tab-Content" role="tablist"> <a id="tab_absence"
									href="#content-tab-Cycles" class="nav-item nav-link active"
									data-toggle="tab" role="tab" aria-controls="content-absence"
									aria-selected="false"> <i class="fa fa-list-ol mr-2"></i>
									Absence
								</a> <a id="tab_stats" href="#content-tab-stats"
									class="nav-item nav-link" data-toggle="tab" role="tab"
									aria-controls="content-absence" aria-selected="false"> <i
									class="fa fa-cubes mr-2"></i> Statistiques etudiants
								</a> <a id="tab_Filieres" href="#content-tab-Filieres"
									class="nav-item nav-link" data-toggle="tab" role="tab"
									aria-controls="content-absence" aria-selected="false"> <i
									class="fa fa-sitemap mr-2"></i>Statistiques
								</a> </nav>
							</div>
							<div class="panel-body">
								<!-- Tab content -->
								<div class="tab-content" id="Tab-Content">
									<!-- Content tab 1	: Cycles-->

									<div id="content-tab-Cycles" class="tab-pane active"
										role="tabpanel" aria-labelledby="tab-bootstrap">
										<div class="alert bg-light text-secondary" role="alert">
											<i class="fa fa-list-ol mr-2"></i> Absence <a href="#"
												data-toggle="modal" data-target="#cycle_Add_Modal"
												class="btn btn-outline-info float-right"
												title="Ajouter un cycle"><i class="fa fa-plus"></i></a>
										</div>
										<table id="data_table_AbsenceEtudiant"
											class="table table-striped table-bordered" cellspacing="0"
											width="100%">
											<thead>
												<tr>
													<th>N°</th>
													<th>Etudiant</th>
													<th>Matiere</th>
													<th>Date</th>
													<th>Duree</th>
													<th>Plus</th>
												</tr>
											</thead>
											<tbody>
											</tbody>
										</table>
										<!-- Début : Modal Update Cycle -->
									<div id="cycle_Update_Modal" class="modal" tabindex="-1" role="dialog" aria-labelledby="edit" aria-hidden="true" data-backdrop="false">
									<div class="modal-dialog">
									<form id="Absence_Update_Form" method="POST" action="../Absence/Update" >
								      	<div class="modal-content shadow-lg p-3 mb-5 bg-white rounded">
								          	<div class="modal-header bg-info">
								        		<h4 class="modal-title text-white">
								        			Ajouter un document justificatif
								        		</h4>
								        		<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							    					<span aria-hidden="true">&times;</span>
							  					</button>
								        	</div>
								          	<div class="modal-body">
								          		<div class="form-group row">
										    		<label for="cycle_code" class="col-sm-3 control-label">Etudiant</label>
												    <div class="col-sm-9">
												      <input  type="hidden" class="form-control" name="id" />
												      <input id="etd_nom" type="text" class="form-control" name="code" placeholder="Code du cycle" required/>  
												      
												    </div>
										  		</div>
												<div class="form-group row">
												  <label for="cycle_Nom_Fr" class="col-sm-3 control-label">Motif</label>
												  <div class="col-sm-9">
						    					      <input id="absence_motif" type="text" class="form-control" name="code" placeholder="Code du cycle" required/>  
												  </div>
												</div>
										  		<div class="form-group row">
												  <label for="cycle_Nom_Ar" class="col-sm-3 control-label">Document Justificatif</label>
												  <div class="col-sm-9">
												    <select id="document_justificatif_Selector" class="form-control" name="document_justificatif"  required></select>
												  </div>
												</div>
								      	</div>
								        <div class="modal-footer ">
							        		<input type="submit" class="btn btn-primary" value="Enregistrer" />
									        <button type="button" class="btn btn-secondary" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Annuler</button>
							      		</div>
								        </div>
								   	</form>
									</div>
							    </div>
							 <!-- Fin : Modal Update Absence -->
							 <!-- Début : Modal Details Absence -->
								<div id="anneeScolaire_Details_Modal" class="modal" tabindex="-1" role="dialog" aria-labelledby="edit" aria-hidden="true" data-backdrop="false">
												<div class="modal-dialog">
											      	<div class="modal-content shadow-lg p-3 mb-5 bg-white rounded">
											          	<div class="modal-header bg-info">
											        		<h4 class="modal-title text-white">
											        			Détails de l'absence
											        		</h4>
											        		<button type="button" class="close" data-dismiss="modal" aria-label="Close">
										    					<span aria-hidden="true">&times;</span>
										  					</button>
											        	</div>
											          	<div class="modal-body">
											          		<ul class="list-group">
																<!-- Affichage dynamique des détails du anneeScolaire-->
															</ul>
														</div>
														<div class="modal-footer ">
															<button type="button" class="btn btn-secondary" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Fermer</button>
														</div>
											        </div>
												</div>
										    </div>
										    	<div id="Stats_Details_Modal" class="modal" tabindex="-1" role="dialog" aria-labelledby="edit" aria-hidden="true" data-backdrop="false">
												<div class="modal-dialog">
											      	<div class="modal-content shadow-lg p-3 mb-5 bg-white rounded">
											          	<div class="modal-header bg-info">
											        		<h4 class="modal-title text-white">
											        			Détails de l'absence
											        		</h4>
											        		<button type="button" class="close" data-dismiss="modal" aria-label="Close">
										    					<span aria-hidden="true">&times;</span>
										  					</button>
											        	</div>
											          	<div class="modal-body">
											          		<ul class="list-group">
																<!-- Affichage dynamique des détails du anneeScolaire-->
															</ul>
														</div>
														<div class="modal-footer ">
															<button type="button" class="btn btn-secondary" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Fermer</button>
														</div>
											        </div>
												</div>
										    </div>
										<!-- Fin : Modal Details Cycle -->
									</div>
									<!-- /Content tab 1	: Cycles-->
									<div id="content-tab-Filieres" class="tab-pane "
										role="tabpanel" aria-labelledby="tab-bootstrap">
										<div class="alert bg-light text-secondary" role="alert">
											<i class="fa fa-sitemap mr-2"></i> Statistiques
										</div>
										<div class="main">

											<!-- aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa -->
											<canvas id="stat"></canvas>
										</div>

										<!-- Début : Modal Add New Filiere -->
										<div id="filiere_Add_Modal" class="modal" tabindex="-1"
											role="dialog" aria-labelledby="edit" aria-hidden="true">
											<div class="modal-dialog">
												<form id="filiere_Add_Form" method="POST"
													action="../Filiere/Add">
													<div
														class="modal-content shadow-lg p-3 mb-5 bg-white rounded">
														<div class="modal-header bg-info">
															<h4 class="modal-title text-white">Ajouter un
																document jutificatif</h4>
															<button type="button" class="close" data-dismiss="modal"
																aria-label="Close">
																<span aria-hidden="true">&times;</span>
															</button>
														</div>
														<div class="modal-body">
															<div class="form-group row">
																<label for="filiere_code" class="col-sm-3 control-label">Nom</label>
																<div class="col-sm-9">
																	<input id="filiere_code" type="text"
																		class="form-control" name="code"
																		placeholder="Nom de l'etudiant" required />
																</div>
															</div>
															<div class="form-group row">
																<label for="filiere_Nom_Fr"
																	class="col-sm-3 control-label">Document</label>
																<div class="col-sm-9">
																	<input id="filiere_Nom_Fr" type="file"
																		class="form-control" name="nom_Fr" required />
																</div>
															</div>
															<div class="form-group row">
																<label for="filiere_Nom_Ar"
																	class="col-sm-3 control-label">Motif</label>
																<div class="col-sm-9">
																	<input id="filiere_Nom_Ar" type="text-field"
																		class="form-control" name="nom_Ar" dir="rtl"
																		placeholder="Motif" />
																</div>
															</div>
														</div>
														<div class="modal-footer ">
															<input type="submit" class="btn btn-primary"
																value="Enregistrer"  />
															<button type="button" class="btn btn-secondary"
																data-dismiss="modal">
																<span class="glyphicon glyphicon-remove"></span> Annuler
															</button>
														</div>
													</div>
												</form>
											</div>
										</div>
										<!-- Fin : Modal Add New Filiere -->
										<!-- Début : Modal Update Filiere -->
										<div id="filiere_Update_Modal" class="modal" tabindex="-1"
											role="dialog" aria-labelledby="edit" aria-hidden="true"
											data-backdrop="false">
											<div class="modal-dialog">
												<form id="filiere_Update_Form" method="POST"
													action="../Filiere/Update">
													<div
														class="modal-content shadow-lg p-3 mb-5 bg-white rounded">
														<div class="modal-header bg-info">
															<h4 class="modal-title text-white">Modifier la
																filière</h4>
															<button type="button" class="close" data-dismiss="modal"
																aria-label="Close">
																<span aria-hidden="true">&times;</span>
															</button>
														</div>
														<div class="modal-body">
															<div class="form-group row">
																<label for="filiere_code" class="col-sm-3 control-label">Code</label>
																<div class="col-sm-9">
																	<input type="hidden" class="form-control" name="id" />
																	<input id="filiere_code" type="text"
																		class="form-control" name="code"
																		placeholder="Code de la filière" required />
																</div>
															</div>
															<div class="form-group row">
																<label for="filiere_Nom_Fr"
																	class="col-sm-3 control-label">Nom de la
																	filière</label>
																<div class="col-sm-9">
																	<input id="filiere_Nom_Fr" type="text"
																		class="form-control" name="nom_Fr"
																		placeholder="Nom de la filière" required />
																</div>
															</div>
															<div class="form-group row">
																<label for="filiere_Nom_Ar"
																	class="col-sm-3 control-label">إسم الشعبة</label>
																<div class="col-sm-9">
																	<input id="filiere_Nom_Ar" type="text"
																		class="form-control" name="nom_Ar" dir="rtl"
																		placeholder="إسم الشعبة بالعربية" />
																</div>
															</div>
														</div>
														<div class="modal-footer ">
															<input type="submit" class="btn btn-primary"
																value="Enregistrer"  />
															<button type="button" class="btn btn-secondary"
																data-dismiss="modal">
																<span class="glyphicon glyphicon-remove"></span> Annuler
															</button>
														</div>
													</div>
												</form>
											</div>
										</div>
										<!-- Début : Modal Details Filiere -->
										<div id="filiere_Details_Modal" class="modal" tabindex="-1"
											role="dialog" aria-labelledby="edit" aria-hidden="true"
											data-backdrop="false">
											<div class="modal-dialog">
												<div
													class="modal-content shadow-lg p-3 mb-5 bg-white rounded">
													<div class="modal-header bg-info">
														<h4 class="modal-title text-white">Détails de la
															filière</h4>
														<button type="button" class="close" data-dismiss="modal"
															aria-label="Close">
															<span aria-hidden="true">&times;</span>
														</button>
													</div>
													<div class="modal-body">
														<ul class="list-group">
															<!-- Affichage dynamique des détails de la filiere-->
														</ul>
													</div>
													<div class="modal-footer ">
														<button type="button" class="btn btn-secondary"
															data-dismiss="modal">
															<span class="glyphicon glyphicon-remove"></span> Fermer
														</button>
													</div>
												</div>
											</div>
										</div>
										<!-- Fin : Modal Details Filiere -->
									</div>
									<!-- /Content tab 2	: Filières-->
									<div id="content-tab-stats" class="tab-pane" role="tabpanel"
										aria-labelledby="content-tab-Niveaux">
										<div class="alert bg-light text-secondary" role="alert">
											<i class="fa fa-cubes mr-2"></i> Niveaux

										</div>
										<table id="data_table_stats"
											class="table table-striped table-bordered" cellspacing="0"
											width="130%">
											<thead>
												<tr>
													<th>N°</th>
													<th>Etudiant</th>
													<th>Nombre d'heures d'absence</th>
													<th>plus</th>
												</tr>
											</thead>
											<tbody>
											</tbody>
										</table>
										<!-- Début : Modal Add New Niveau -->

									</div>
								</div>

								<!-- /Tab content -->
							</div>

						</div>
					</div>
					<!-- /Col 1 -->
					<div class="col-md-3">
						<!-- Col 2 -->
						<div class="panel with-nav-tabs panel-primary">
							<div class="panel-heading">
								<nav class="nav nav-tabs flex-column flex-sm-row"
									id="Tab-Content-2" role="tablist"> <a id="tab_Annonces"
									href="#content-tab-Annonces" class="nav-item nav-link active"
									data-toggle="tab" role="tab"
									aria-controls="content-tab-Annonces" aria-selected="false">
									<span class="fa fa-bullhorn mr-1"></span> Annonces
								</a> <a id="tab_Actualites" href="#content-tab-Actualites"
									class="nav-item nav-link" data-toggle="tab" role="tab"
									aria-controls="content-tab-Actualites" aria-selected="false">
									<span class="fa fa-newspaper mr-1"></span> Actualites
								</a> </nav>
							</div>
							<div class="panel-body">
								<!-- Début : Tab content  2-->
								<div class="tab-content" id="Tab-Content-Communication">
									<!-- Content tab 1 	: Annonces-->
									<div id="content-tab-Annonces" class="tab-pane active"
										role="tabpanel" aria-labelledby="content-tab-Annonces">
										<ul>
											<li>Annonce 1</li>
											<li>Annonce 2</li>
											<li>Annonce 3</li>
										</ul>
									</div>
									<!-- /Content tab 1 : Annonces-->
									<!-- Content tab 2 	: Actualites-->
									<div id="content-tab-Actualites" class="tab-pane"
										role="tabpanel" aria-labelledby="content-tab-Actualites">
										<ul>
											<li>Actualité 1</li>
											<li>Actualité 2</li>
											<li>Actualité 3</li>
											<li>Actualite 4</li>
											<li>Actualité 5</li>
										</ul>
									</div>
									<!-- /Content tab 2	: Actualites-->
								</div>
								<!-- Fin : Tab content 2 -->
							</div>
						</div>
					</div>
					<!-- Col 2 -->
				</div>
				<!-- /row 1 -->

				<!-- /Page Content  -->
			</div>
		</div>
	</div>
	<!-- Modal Success -->
	<div id="modalSuccess" class="modal" tabindex="-1" role="dialog">
		<div class="modal-dialog modal-dialog-centered modal-confirm">
			<div class="modal-content">
				<div class="modal-header">
					<div class="icon-box bg-success">
						<i class="material-icons fa fa-check"></i>
					</div>
					<h4 class="modal-title text-center">Succès !</h4>
				</div>
				<div class="modal-body">
					<p class="text-center">
						<!-- On affiche ici le message obtenu du coté serveur -->
					</p>
				</div>
				<div class="modal-footer">
					<button class="btn btn-success btn-block" data-dismiss="modal">Fermer</button>
				</div>
			</div>
		</div>
	</div>
	<!-- Fin : Moad Success -->
	<!-- Début : Modal error -->
	<div id="modalError" class="modal" tabindex="-1" role="dialog">
		<div class="modal-dialog modal-dialog-centered modal-confirm">
			<div class="modal-content">
				<div class="modal-header">
					<div class="icon-box bg-danger">
						<i class="material-icons fa fa-exclamation-triangle"></i>
					</div>
					<h4 class="modal-title text-center">Echec !</h4>
				</div>
				<div class="modal-body">
					<p class="text-center">
						<!-- On affiche ici le message obtenu du coté serveur -->
					</p>
				</div>
				<div class="modal-footer">
					<button class="btn btn-secondary btn-block" data-dismiss="modal">Fermer</button>
				</div>
			</div>
		</div>
	</div>
	<!-- Fin : Moad Error -->
	<!-- Début : Moad Confirmation -->
	<div id="modalConfirm" class="modal" tabindex="-1" role="dialog">
		<div class="modal-dialog modal-dialog-centered modal-confirm "
			role="document">
			<div class="modal-content">
				<div class="modal-header">
					<div class="icon-box bg-warning">
						<i class="material-icons fa fa-exclamation-triangle"></i>
					</div>
					<h4 class="modal-title text-center">Supprimer ?</h4>
				</div>
				<div class="modal-body">
					<p class="text-center">Etes vous sûre de vouloir supprimer cet
						enregistrement ?</p>
				</div>
				<div class="modal-footer">
					<button type="button" data-dismiss="modal"
						class="btn btn-warning  mr-auto" id="delete">Supprimer</button>
					<button type="button" data-dismiss="modal"
						class="btn btn-secondary  ">Annuler</button>
				</div>
			</div>
		</div>
	</div>
	<!-- Fin : Moad Confirmation-->
	<!-- Début : Moad Loading Ajax -->
	<div id="loading-image" class="modal" tabindex="-1" role="dialog">
		<div class="modal-dialog modal-dialog-centered modal-sm">
			<div class="modal-content" style="width: 48px; color: orange;">
				<span class="fa fa-spinner fa-spin fa-3x"></span>
			</div>
		</div>
	</div>
	<!-- Fin : Moad Loading Ajax -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>

	<script src="${pageContext.request.contextPath}/js/popper.js"
		type="text/javascript"></script>


	<script
		src="${pageContext.request.contextPath}/js/jquery.dataTables.min.js"
		type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/js/dataTables.bootstrap.js"
		type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/main.js"
		type="text/javascript"></script>


	<script
		src="${pageContext.request.contextPath}/js/dataTables.buttons.min.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/js/buttons.flash.min.js"
		type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/jszip.min.js"
		type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/pdfmake.min.js"
		type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/vfs_fonts.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/js/buttons.html5.min.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/js/buttons.print.min.js"
		type="text/javascript"></script>


	<script type="text/javascript">
  	
  	$(document).ready(function() {
  		/* Début : Ajax Load Animation **/
  		$(document).ajaxStart(function(){
  			$('#loading-image').show();
		 });
  		$(document).ajaxStop(function(){
  			$('#loading-image').hide();
		 });
		/**Fin : Ajax Load Animation **/
		
				
  		/* DataTable du Tab : Absence*/
	  		// Initialisation du DataTable Cycles
	  		//$('#data_table_cycles').append('<caption style="caption-side: bottom">Liste d'absence.</caption>');
	  		$('#data_table_AbsenceEtudiant').DataTable(
	  			{	
	  				"language": {
	  				    "paginate": {
	  				      "previous": "Précèdent",
	  				      "next": "Suivant"
	  				    }
	  				  },
	  				"paging": true,
	  				"autoWidth": true,
	  				"columnDefs": [
	  					{ "orderable": false, "targets": 3 }
	  				],
	  				
	  				dom: 'Blfrtip',
	  		        buttons: [
	  		       {
	  		           extend: 'pdf',
	  		           title: 'Liste dabsence',
	  		           footer: true,
	  		           exportOptions: {
	  		                columns: [0.1,2]
	  		            }
	  		       },
	  		       {
	  		           extend: 'csv',
	  		           title: 'Liste dabsence',
	  		           footer: false,
	  		           exportOptions: {
	  		                columns: [0.1,2]
	  		            }
	  		          
	  		       },
	  		       {
	  		           extend: 'excel',
	  		           footer: false,
	  		           title: 'Liste dabsence',
	  		           exportOptions: {
	  		                columns: [0.1,2]
	  		            }
	  		       },
	  		       {
	  		           extend: 'print',
	  		           title: 'Liste dabsence',
	  		           footer: false,
	  		           exportOptions: {
	  		                columns: [0.1,2]
	  		            }
	  		       }         
	  		    ]  
	  				
	  			}
	  		);
	  		/* fonction pour charger la liste d'absence dans la TableData AbsenceEtudiant **/
			function populateAbsenceDataTable(){
				var tableData = $('#data_table_AbsenceEtudiant').DataTable();
				//tableData.DataTable().rows().remove().draw();		// Vider la TableData 
				$.ajax({
					url : "../Absence/List",
					type: "GET",
					dataType: 'json',	
					contentType: "application/json; charset=UTF-8",
					success: function(response,textStatus ,jqXHR){
						console.log("success");
						
						for( i=0;i<response.length;i++){
							var rang =i+1;
							var btns='<div class="btn-group dropleft"> \
										  <button type="button" class="btn btn-outline-info btn-sm" title="Actions"><span class="fa fa-ellipsis-h"></span></button> \
										  <button type="button" class="btn btn-outline-info btn-sm dropdown-toggle dropdown-toggle-split" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> \
										    <span class="sr-only">Toggle Dropdown</span> \
										  </button> \
										  <div class="dropdown-menu shadow p-3 mb-5 bg-white rounded" id="dropdownAbsence"> \
										    <div class="bg-info text-white px-3 py-1"><span class="fa fa-ellipsis-h mr-4"></span> Actions</div> \
									        <div class="dropdown-divider"></div> \
										  	<a class="dropdown-item Absence-details text-primary" href="#" AbsenceId="'+response[i].id+'"><span class="fa fa-info-circle mr-4"></span>Détails</a> \
										  </div> \
										</div> ';
										
										var NomComplet =response[i].etudiant.nom_Fr+" "+response[i].etudiant.prenom_Fr;
							tableData.row.add( [
							             rang,
							             NomComplet,
							             response[i].seance.seanceGenerique.matiere.nom_Fr,
							             response[i].seance.date,
							             response[i].seance.seanceGenerique.duree+"H",
							             btns
							         ] ).draw( false );
						}

					
				    },
				    error: function(response,textStatus ,jqXHR){
				    	console.log("error");
				    	console.log(response);
				    	$("#modalError .modal-body p").html("");
						$("#modalError .modal-body p").html(jqXHR.responseText);
				   		$('#modalError .modal-body p').modal('show'); 
				        }
				});
			};
			
			/*
			 // Cahargement des cycles au chargement de la page
			*/
			populateAbsenceDataTable();
			/* Au click sur le tab Cycles : 
			/* On charger la liste des Cycles dans la TableData Cycles
			*/
			
			
			
			
			$('#tab_absence').on('click', function(e){
				// Effacer le DataTable Cycles
				$('#data_table_AbsenceEtudiant').DataTable().rows().remove().draw();
				// Charger la liste des cycles dans le DataTable Cycles
	  			populateAbsenceDataTable();
				e.preventDefault();
		});
  	});
  	
  	 /*Fonction de chargement de la table Statistiques des etudiants*/
	 function populateStatsDataTable(){
			var tableData = $('#data_table_stats').DataTable();
			//tableData.DataTable().rows().remove().draw();		// Vider la TableData 
			$.ajax({
				url : "../Absence/Stats",
				type: "GET",
				dataType: 'json',	
				contentType: "application/json; charset=UTF-8",
				success: function(response,textStatus ,jqXHR){
					console.log("success");
					
					for( i=0;i<response.length;i++){
						var rang =i+1;
						var btns='<div class="btn-group dropleft"> \
									  <button type="button" class="btn btn-outline-info btn-sm" title="Actions"><span class="fa fa-ellipsis-h"></span></button> \
									  <button type="button" class="btn btn-outline-info btn-sm dropdown-toggle dropdown-toggle-split" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> \
									    <span class="sr-only">Toggle Dropdown</span> \
									  </button> \
									  <div class="dropdown-menu shadow p-3 mb-5 bg-white rounded" id="dropdownAbsence"> \
									    <div class="bg-info text-white px-3 py-1"><span class="fa fa-ellipsis-h mr-4"></span> Actions</div> \
								        <div class="dropdown-divider"></div> \
									  	<a class="dropdown-item Stats-details text-primary" href="#" EtdId="'+response[i].e.id+'"><span class="fa fa-info-circle mr-4"></span>Détails</a> \
									  </div> \
									</div> ';
									
									var NomComplet =response[i].e.nom_Fr+" "+response[i].e.prenom_Fr;
						tableData.row.add( [
						             rang,
						             NomComplet,
						             response[i].nbreabs,
						             btns
						         ] ).draw( false );
					}

				
			    },
			    error: function(response,textStatus ,jqXHR){
			    	console.log("errorzbi");
			    	console.log(response);
			    	$("#modalError .modal-body p").html("");
					$("#modalError .modal-body p").html(jqXHR.responseText);
			   		$('#modalError .modal-body p').modal('show'); 
			        }
			});
  	 }
			populateStatsDataTable();
  	
  	function loadClasses(){
		//Effacer le contenu du select
		$("#anneeScolaireCourante_Selector").html("");
       //Chargement de toutes les années scolaires dans le Select : anneeScolaireCourante_Selector
       var id=$('#try_Selector').val();
				$.ajax({
			url : "../ClassebyFil/List?id="+id,
			type: "GET",
			dataType: 'json',
			contentType: "application/json; charset=UTF-8",
			success: function(response,textStatus ,jqXHR){
				console.log("success clas");
				for(i=0;i<response.length;i++){
					var item  ='<option value="'+response[i].id+'">'+response[i].code+'</option>';
					$("#anneeScolaireCourante_Selector").append(item);       
				}	
		    },
		    error: function(response,textStatus ,jqXHR){
				console.log("error clas");
		    	$("#modalError .modal-body p").html("");
				$("#modalError .modal-body p").html(jqXHR.responseText);
		   		$('#modalError .modal-body p').modal('show'); 
		        }
		});
	};
	
	
	
	
	function loadTry(){
		//Effacer le contenu du select
		$("#try_Selector").html("");
       //Chargement de toutes les années scolaires dans le Select : anneeScolaireCourante_Selector
				$.ajax({
			url : "../Filiere/List",
			type: "GET",
			dataType: 'json',
			contentType: "application/json; charset=UTF-8",
			success: function(response,textStatus ,jqXHR){
				
				for(i=0;i<response.length;i++){
					var item  ='<option value="'+response[i].id+'">'+response[i].nom_Fr+'</option>';
					$("#try_Selector").append(item);       
				}	
				
		    },
		    error: function(response,textStatus ,jqXHR){
		    	$("#modalError .modal-body p").html("");
				$("#modalError .modal-body p").html(jqXHR.responseText);
		   		$('#modalError .modal-body p').modal('show'); 
		        }
		});
	};
	loadTry();
	
	
	
	
	
	$('#try_Selector').on('change', function(e){
		var tableData = $('#data_table_AbsenceEtudiant').DataTable();
		tableData.rows().remove().draw();		// Vider la TableData 
	       var id=$('#try_Selector').val();

		$.ajax({
			url : "../Absence/List",
			type: "GET",
			dataType: 'json',	 
			contentType: "application/json; charset=UTF-8",
			success: function(response,textStatus ,jqXHR){
				loadClasses();
				console.log("taha");
				for( i=0;i<response.length;i++){
					if(response[i].etudiant.filiere.id==$('#try_Selector').val()){
					var rang =i+1;
					var btns='<div class="btn-group dropleft"> \
								  <button type="button" class="btn btn-outline-info btn-sm" title="Actions"><span class="fa fa-ellipsis-h"></span></button> \
								  <button type="button" class="btn btn-outline-info btn-sm dropdown-toggle dropdown-toggle-split" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> \
								    <span class="sr-only">Toggle Dropdown</span> \
								  </button> \
								  <div class="dropdown-menu shadow p-3 mb-5 bg-white rounded" id="dropdownAbsence"> \
								    <div class="bg-info text-white px-3 py-1"><span class="fa fa-ellipsis-h mr-4"></span> Actions</div> \
							        <div class="dropdown-divider"></div> \
								  	<a class="dropdown-item Absence-details text-primary" href="#" AbsenceId="'+response[i].id+'"><span class="fa fa-info-circle mr-4"></span>Détails</a> \
								  </div> \
								</div> ';
								
								var NomComplet =response[i].etudiant.nom_Fr+" "+response[i].etudiant.prenom_Fr;
					tableData.row.add( [
					             rang,
					             NomComplet,
					             response[i].seance.seanceGenerique.matiere.nom_Fr,
					             response[i].seance.date,
					             response[i].seance.seanceGenerique.duree+"H",
					             btns
					         ] ).draw( false );
					} 
}
				
			
		    },
		    error: function(response,textStatus ,jqXHR){
		    	console.log("error");
		    	console.log(response);
		    	$("#modalError .modal-body p").html("");
				$("#modalError .modal-body p").html(jqXHR.responseText);
		   		$('#modalError .modal-body p').modal('show'); 
		        }
		});
		
		e.preventDefault();
	});
	
	
	
	
	
	
	
	$('#data_table_stats').on('click','.Stats-details', function(evt){
		$this = $(this);
		var id= $this.attr('EtdId');
		$.ajax({
			url : "../Absence/Details?id="+id,
			type: "GET",
			
			dataType: 'json',
			contentType: "application/json; charset=UTF-8",
			success: function(response,textStatus ,jqXHR){
				console.log(response);
				var codeItem ='<li class="list-group-item"><span><strong>justification </strong></span><span class="float-right">'+response.justification+'</span></li>';
				var nom_FrItem ='<li class="list-group-item"><span><strong>Motif</strong></span><span class="float-right">'+response.motif+'</span></li>';
				var nom_ArItem ='<li class="list-group-item"><span><strong>Ajouter un documentJustificatif</strong></span><span class="float-right"><form id="Absence_Update_Form" method="POST" action="../Absence/Update" ><input type="hidden" value="'+response.id+'" name="id"></input>Motif:<br><textarea name="motif"></textarea><br><br>Document:<input type="file"><br><br><button type="submit" class="btn btn-secondary" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Ajouter</button></form></span></li>';
				$("#Stats_Details_Modal .list-group").html("");
				$("#Stats_Details_Modal .list-group").append(codeItem);
				$("#Stats_Details_Modal .list-group").append(nom_FrItem);
				$("#Stats_Details_Modal .list-group").append(nom_ArItem);
				$('#Stats_Details_Modal').modal('show');
		    },
		    error: function(response,textStatus ,jqXHR){
		    	console.log("mafhmtch error");
		    	$("#modalError .modal-body p").html("");
				$("#modalError .modal-body p").html(jqXHR.responseText);
		   		$('#modalError .modal-body p').modal('show'); 
		        }
		});
		
		return false;
	});
	
	
	$('#data_table_AbsenceEtudiant').on('click','.Absence-details', function(evt){
		$this = $(this);
		var id= $this.attr('AbsenceId');
		$.ajax({
			url : "../Absence/Details?id="+id,
			type: "GET",
			
			dataType: 'json',
			contentType: "application/json; charset=UTF-8",
			success: function(response,textStatus ,jqXHR){
				console.log(response);
				var codeItem ='<li class="list-group-item"><span><strong>justification </strong></span><span class="float-right">'+response.justification+'</span></li>';
				var nom_FrItem ='<li class="list-group-item"><span><strong>Motif</strong></span><span class="float-right">'+response.motif+'</span></li>';
				var nom_ArItem ='<li class="list-group-item"><span><strong>Ajouter un documentJustificatif</strong></span><span class="float-right"><form id="Absence_Update_Form" method="POST" action="../Absence/Update" ><input type="hidden" value="'+response.id+'" name="id"></input>Motif:<br><textarea name="motif"></textarea><br><br>Document:<input type="file"><br><br><button type="submit" class="btn btn-secondary" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Ajouter</button></form></span></li>';
				$("#anneeScolaire_Details_Modal .list-group").html("");
				$("#anneeScolaire_Details_Modal .list-group").append(codeItem);
				$("#anneeScolaire_Details_Modal .list-group").append(nom_FrItem);
				$("#anneeScolaire_Details_Modal .list-group").append(nom_ArItem);
				$('#anneeScolaire_Details_Modal').modal('show');
		    },
		    error: function(response,textStatus ,jqXHR){
		    	console.log("mafhmtch error");
		    	$("#modalError .modal-body p").html("");
				$("#modalError .modal-body p").html(jqXHR.responseText);
		   		$('#modalError .modal-body p').modal('show'); 
		        }
		});
		
		return false;
	});
	
	
	
		
			//par date
		/*	$('#date_Selector').on('select', function(e){
				var selectedDate = $('#Date_Selector').val();
				var tableData = $('#data_table_AbsenceEtudiant').DataTable();
				tableData.rows().remove().draw();		// Vider la TableData 
			       var id=$('#try_Selector').val();
				$.ajax({
					url : "../AbsenceByDate/List?id="+id+",date="+selectedDate,
					type: "GET",
					dataType: 'json',	 
					contentType: "application/json; charset=UTF-8",
					success: function(response,textStatus ,jqXHR){
						loadClasses();
						console.log("taha");
						for( i=0;i<response.length;i++){
							if(response[i].etudiant.filiere.id==$('#try_Selector').val()){
							var rang =i+1;
							var btns='<div class="btn-group dropleft"> \
										  <button type="button" class="btn btn-outline-info btn-sm" title="Actions"><span class="fa fa-ellipsis-h"></span></button> \
										  <button type="button" class="btn btn-outline-info btn-sm dropdown-toggle dropdown-toggle-split" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> \
										    <span class="sr-only">Toggle Dropdown</span> \
										  </button> \
										  <div class="dropdown-menu shadow p-3 mb-5 bg-white rounded" id="dropdownAbsence"> \
										    <div class="bg-info text-white px-3 py-1"><span class="fa fa-ellipsis-h mr-4"></span> Actions</div> \
									        <div class="dropdown-divider"></div> \
										  	<a class="dropdown-item Absence-details text-primary" href="#" AbsenceId="'+response[i].id+'"><span class="fa fa-info-circle mr-4"></span>Détails</a> \
										  	<a class="dropdown-item cycle-delete text-primary" href="#" AbsenceId="'+response[i].id+'"><span class="fa fa-trash mr-4"></span>Supprimer</a> \
										  </div> \
										</div> ';
										
										var NomComplet =response[i].etudiant.nom_Fr+" "+response[i].etudiant.prenom_Fr;
							tableData.row.add( [
							             rang,
							             NomComplet,
							             response[i].seance.seanceGenerique.matiere.nom_Fr,
							             response[i].seance.date,
							             response[i].seance.seanceGenerique.heureDebut,
							             response[i].seance.seanceGenerique.heureFin,
							             btns
							         ] ).draw( false );
							} 
		}
						
					
				    },
				    error: function(response,textStatus ,jqXHR){
				    	console.log("error");
				    	console.log(response);
				    	$("#modalError .modal-body p").html("");
						$("#modalError .modal-body p").html(jqXHR.responseText);
				   		$('#modalError .modal-body p').modal('show'); 
				        }
				});
				
				e.preventDefault();
			});*/
			//Ajout de Document Justificatif
				$("#Absence_Update_Form").submit(function(event){ 
				var post_url = $(this).attr("action"); 			//Lire l'action (URL) du formulaire
				var request_method = $(this).attr("method"); 	//Lire la méthode du formulaire  GET/POST 
				var form_data = $(this).serialize(); 			//Encoder les données du formulaire pour envoie
				$('#Absence_Update_Form').modal('hide');			//Fermer la fenetre modal apres envoie du formulaire
				$.ajax({
					url : post_url,
					type: request_method,
					data : form_data,
					dataType: 'json',
					contentType: "application/x-www-form-urlencoded;charset=UTF-8",
					success: function(response,textStatus ,jqXHR){
						console.log("ah");
						$("#modalSuccess .modal-body p").html("");
						$("#modalSuccess .modal-body p").html(response);
				   		$('#modalSuccess').modal('show');
				    	//setTimeout(function() { $('#modalSuccess').modal('hide'); }, 5000);
						
				    },
				    error: function(response,textStatus ,jqXHR){
				    	console.log("Laaa");
				    	$("#modalError .modal-body p").html("");
						$("#modalError .modal-body p").html(response);
				   		$('#modalError').modal('show'); 
				        },
				    complete: function (response,textStatus ,jqXHR) {
				    	
						//Effacer le DataTable Cycles
						$('#data_table_cycles').DataTable().rows().remove().draw();
			  			//Raffrichir le DataTable Cycles
						populateAbsenceDataTable();
				    }   
				});
				return false;
			});	
			
			function statabs(){
				$.ajax({
			url : "../Absence/Count",
			type: "GET",
			dataType: 'json',
			contentType: "application/json; charset=UTF-8",
			success: function(response,textStatus ,jqXHR){
				var i;
				var just=0;
				var njustfiee=0;
				console.log(response);
				for(i=0;i<response.length;i++)
					if(response[i].justification==true)
						just=just+1;
				var njust=response.length-just;
				console.log(njust);
				console.log(just);
				var justifiee=just*100/response.length;
				just=just*360/response.length;
				njustifiee=100-justifiee;
				console.log(just+'%');
				$("#stat").css("background","repeating-conic-gradient(from 0deg,#005FAF 0deg "+just+"deg,lightblue "+just+"deg 360deg)");
				$("#just").html("Absence Justifiéé "+justifiee+"%");
				$("#njust").html("Absence Non Justifiéé "+njustifiee+"%");

		    },
		    error: function(response,textStatus ,jqXHR){
		    	$("#modalError .modal-body p").html("");
				$("#modalError .modal-body p").html(jqXHR.responseText);
		   		$('#modalError .modal-body p').modal('show'); 
		        }
		});
	};
	
	/*$(document).ready(function() {
		  $.ajax({
		    url: "../Absence/Count",
		    type: "GET",
		    dataType: "json",
			contentType: "application/json; charset=UTF-8",
		    success: function(response,textStatus ,jqXHR) {
		    	createPieChart();
		    },
		    error: function(jqXHR, textStatus, errorThrown) {
		      console.log("Error retrieving chart data: " + errorThrown);
		    }
		  });
		});*/
		
		/*
		**
		*
		* creation dune chart de pie est la diviser selon les pourcentages d'absences
		*
		*
		*/
		
		var myChart;
	$(document).ready(function() {
		$.ajax({
		    url: "../Absence/Count",
		    type: "GET",
		    dataType: "json",
			contentType: "application/json; charset=UTF-8",
		    success: function(response,textStatus ,jqXHR) {
		    /*recuperation et calcules des valeurs*/
		    	var just=0;
		    	for(i=0;i<response.length;i++)
					if(response[i].justification==true)
						just=just+1;
		    	var justifiee=just*100/response.length;
		    	var njustifiee=100-justifiee;
		    	/*creation et instantiation de la charte par les valeurs calculées*/
		var ctx = document.getElementById("stat").getContext("2d");
	       myChart = new Chart(ctx, {
	        type: "pie",
	        data: {
	        	labels:["Justifiée :"+justifiee.toFixed(2)+"%","Non justifiée :"+njustifiee.toFixed(2)+"%"],
	          datasets: [{
	            data: [justifiee, njustifiee],
	            backgroundColor: ['#005FAF','lightblue'],
	            borderWidth:2
	          }]
	        },
	        options: {
	          responsive: true,
	          title: {
	            display: true,
	            text: "Statistiques des absences"
	          },
	        legend:{
	        	  position:'right',
	        		  labels:{
	     	        	 fontSize:15,
	     	         }
	          },
	          }
	        
	      });
		    },
	      error: function(response,textStatus ,jqXHR){
		    	$("#modalError .modal-body p").html("");
				$("#modalError .modal-body p").html(jqXHR.responseText);
		   		$('#modalError .modal-body p').modal('show'); 
		        }
		 
		});

	});
	/*
	**
	*
	* Mise a jour du chart chaque 6 seconde
	*
	*
	*/
		 setInterval(function() {
			    $.ajax({
			    	 url: "../Absence/Count",
					    type: "GET",
					    dataType: "json",
						contentType: "application/json; charset=UTF-8",
						 success: function(response,textStatus ,jqXHR) {
							 var just=0;
						    	for(i=0;i<response.length;i++)
									if(response[i].justification==true)
										just=just+1;
						    	var justifiee=just*100/response.length;
						    	var njustifiee=100-justifiee;
			       
			        myChart.data.datasets[0].data[0] = justifiee;
			        myChart.data.datasets[0].data[1] = njustifiee;
			        myChart.data.labels[0]= "Justifiée : "+justifiee.toFixed(2)+"%";
			        myChart.data.labels[1] = "Non justifiée : "+njustifiee.toFixed(2)+"%";
			      
			        myChart.update();
			      },
			      error: function(response,textStatus ,jqXHR){
				    	$("#modalError .modal-body p").html("");
						$("#modalError .modal-body p").html(jqXHR.responseText);
				   		$('#modalError .modal-body p').modal('show'); 
				        }
			    });
			  }, 4000);
		 </script>
		
		
   

</body>
</html>