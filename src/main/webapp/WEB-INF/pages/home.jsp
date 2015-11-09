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
<!-- End Custom StyleSheet -->

</head>
<body>
	<div id="main" class="container-fluid">
		<div class="col-sm-12 center-block">
			<div class="col-sm-12 card form-horizontal">
				<h1>
					All User <a class="btn pull-right"
						href="${pageContext.request.contextPath}/add"><i
						class="fa fa-plus fa-2x"></i></a>
				</h1>
				<hr>
				<div class="col-sm-11 center-block">
					<div class="col-sm-10 ">
						<div class="input-group">
							<input type="text" class="form-control" name="keyword"
								placeholder="Search for User ..."> <span
								class="input-group-btn">
								<button type="submit" class="btn btn-primary">
									&nbsp;<span class="fa fa-search"></span>&nbsp;
								</button>
							</span>

						</div>
					</div>
					<div class="col-sm-2 ">
						<select class="form-control" name="type">
							<option value="first_name">First Name</option>
							<option value="last_name">Last Name</option>
							<option value="classroom">Classroom</option>
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