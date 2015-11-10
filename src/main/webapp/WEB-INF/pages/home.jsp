<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="author" content="Chhorn Elit">
<meta lang="en">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- CSS Library -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/lib/bootstrap.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/lib/font-awesome-4.3.0/css/font-awesome.min.css">
<!-- End CSS Library -->

<!-- Custom StyleSheet -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/index.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/modal.css">
<!-- End Custom StyleSheet -->

</head>
<body>
	<div id="main" class="container-fluid">
		<div class="col-sm-12 center-block">
			<div class="col-sm-12 card form-horizontal">
				<h1>
					All User
					<button type="button" class="btn btn-add-modal pull-right" data-toggle="modal"
						data-target="#modal-fullscreen">
						<i class="fa fa-plus fa-2x"></i>
					</button>
					<div class="modal modal-fullscreen fade" id="modal-fullscreen"
						tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
						aria-hidden="true">

						<div class="col-sm-12 form">
							<div class="col-sm-8 center-block" style="margin-bottom: 40px;">
								<input type="hidden" class="form-control" maxlength="100"
									id="id" value="">
								<div class="form-group">
									<label class="col-sm-3">Username:</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" id="username"
											placeholder="Enter Username" maxlength="100" value=''>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3">Email:</label>
									<div class="col-sm-9">
										<input type="email" class="form-control" id="email"
											placeholder="Enter Email" maxlength="100" value=''>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3">Password: </label>
									<div class="col-sm-9">
										<input type="text" class="form-control" id="password"
											placeholder="Enter Password" maxlength="100" value=''>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3">Birth Date: </label>
									<div class="col-sm-9">
										<input type="date" class="form-control" id="birthdate"
											placeholder="Enter Birth Date" value=''>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3">Register Date: </label>
									<div class="col-sm-9">
										<input type="date" class="form-control" id="registerdate"
											placeholder="Enter Register Date" value=''>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3">Image: </label>
									<div class="col-sm-9">
										<input type="text" class="form-control" id="image"
											placeholder="Enter Image" value=''>
									</div>
								</div>
							</div>
							<div class="col-sm-6 center-block">
								<button type="submit" id="btnAdd" class="btn btn-primary"
									style="width: 200px;">
									<i class="fa fa-plus-circle"></i>&nbsp;&nbsp;Add
								</button>
								<button type="reset" id="btnClear"
									class="btn btn-primary pull-right" style="width: 200px;">
									<i class="fa fa-times-circle"></i>&nbsp;&nbsp;Reset
								</button>
							</div>
						</div>


					</div>
				</h1>
				<hr>
				<div class="col-sm-11 center-block">
					<div class="col-sm-10 ">
						<div class="input-group">
							<input type="text" class="form-control" id="keyword"
								placeholder="Search for User ..."> <span
								class="input-group-btn">
								<button type="submit" class="btn btn-primary btn-search">
									&nbsp;<span class="fa fa-search"></span>&nbsp;
								</button>
							</span>

						</div>
					</div>
					<div class="col-sm-2 ">
						<select class="form-control" id="type">
							<option value="username">Username</option>
							<option value="email">Email</option>
							<option value="password">Password</option>
							<option value="image">Image</option>
						</select>
					</div>
				</div>
				<div class="table-responsive">
					<table class="table table-striped table-hover">
						<thead>
							<tr class="info">
								<th>ID</th>
								<th>Username</th>
								<th>Email</th>
								<th>Password</th>
								<th>Birth Date</th>
								<th>Register Date</th>
								<th>Image</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>

						</tbody>
					</table>
				</div>

			</div>
		</div>
	</div>

	<!-- Javascript Library -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/lib/jquery-2.1.4.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/lib/bootstrap.min.js"></script>
	<!-- End Javascript Library -->

	<!-- Custom Javascript -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/index.js"></script>
	<!-- End Custom Javascript -->
</body>
</html>