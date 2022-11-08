<%
	if(session.getAttribute("name") == null ) {
		response.sendRedirect("login.jsp");
	}
%>
<style>

</style>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>NewsApp</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Font Awesome icons (free version)-->
<script src="https://use.fontawesome.com/releases/v5.15.4/js/all.js"
	crossorigin="anonymous"></script>
<!-- Google fonts-->
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css" />
<link
	href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic"
	rel="stylesheet" type="text/css" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="css/index-styles.css" rel="stylesheet" />
</head>
<body id="page-top">
	<!-- Navigation-->
	<nav
		class="navbar navbar-expand-lg bg-secondary text-uppercase fixed-top"
		id="mainNav">
		<div class="container">
			<a class="navbar-brand" href="#page-top">News Application</a>
			<button
				class="navbar-toggler text-uppercase font-weight-bold bg-primary text-white rounded"
				type="button" data-bs-toggle="collapse"
				data-bs-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				Menu <i class="fas fa-bars"></i>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ms-auto">
					<li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded" href="#portfolio">PostReview</a></li>
					<!-- <li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded" href="#about">About</a></li>
					<li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded" href="#contact">Contact</a></li> -->
					<li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded" href="logout">Logout</a></li>
					<li class="nav-item mx-0 mx-lg-1 bg-danger"><a
						class="nav-link py-3 px-0 px-lg-3 rounded" href="logout"><%= session.getAttribute("name")%></a></li>
					
				</ul>
			</div>
		</div>
	</nav>
	<!-- Masthead-->
	
	<div> 
		<%-- <% com.concordia.database.CriticsApiToDatabase.convertAllMovieCriticDataToDatabase();%>
		<% com.concordia.database.ReviewsApiToDatabase.convertPicksMovieReviewsDataToDatabase();%>
		 --%>
	</div>
	
	<header class="masthead bg-primary text-white text-center">
		<div class="container d-flex align-items-center flex-column">
			<!-- Masthead Avatar Image-->
			<img class="masthead-avatar mb-5" src="assets/img/avataaars.svg"
				alt="..." />
			<!-- Masthead Heading-->
			<h1 class="masthead-heading text-uppercase mb-0">Welcome To NewsApp</h1>
			<!-- Icon Divider-->
			<div class="divider-custom divider-light">
				<div class="divider-custom-line"></div>
				<div class="divider-custom-icon">
					<i class="fas fa-star"></i>
				</div>
				<div class="divider-custom-line"></div>
			</div>
			<!-- Masthead Subheading-->
			<p class="masthead-subheading font-weight-light mb-0">Place To Post your Reviews</p>
		</div>
	</header>
	<!-- Portfolio Section-->
	<section class="page-section portfolio" id="portfolio">
		<div class="container">
			<!-- Portfolio Section Heading-->
			<h2
				class="page-section-heading text-center text-uppercase text-secondary mb-0">Movie Reviews</h2>
			<!-- Icon Divider-->
			<div class="divider-custom">
				<div class="divider-custom-line"></div>
				<div class="divider-custom-icon">
					<i class="fas fa-star"></i>
				</div>
				<div class="divider-custom-line"></div>
			</div>
			<div>
			
				<form id="reviewform" method="post" action="review">
					<input type=hidden id="publisherid" name="publisherid" value="<%=request.getAttribute("userid")%>"> 
					<table  style="border-collapse: separate;width:2000px;border-spacing: 20px 20px;">
					<tr>
							<td style="width:300px"><div class="float-child">DISPLAY TITLE :</div></td>
						    <td><div class="float-child">
						      <input style="border: 3px solid #73AD21;width: 50%;" class="w3-input w3-border" name="disptitle" type="text" placeholder="Enter the DISPLAY TITLE">
						    </div></td>
					    </tr>
						<tr>
							<td style="width:300px"><div class="float-child">HEADLINE :</div></td>
						    <td><div class="float-child">
						      <input style="border: 3px solid #73AD21;width: 50%;" class="w3-input w3-border" name="headline" type="text" placeholder="Enter the HEADLINE">
						    </div></td>
					    </tr>
					    <tr>
							<td style="width:300px"><div class="float-child">MPAA RATING :</div></td>
						    <td><div class="float-child">
						      <input style="border: 3px solid #73AD21;width: 50%;" class="w3-input w3-border" name="mpaa" type="text" placeholder="Enter the MPAA RATING">
						    </div></td>
					    </tr>
					    <tr>
							<td style="width:300px"><div class="float-child">CRITICS PICK :</div></td>
						    <td><div class="float-child">
						      <input style="border: 3px solid #73AD21;width: 50%;" class="w3-input w3-border" name="critics" type="text" placeholder="Enter the CRITICS PICK">
						    </div></td>
					    </tr>
					    <tr>
							<td style="width:300px"><div class="float-child">DATE UPDATED :	</div></td>
						    <td><div class="float-child">
						      <input style="border: 3px solid #73AD21;width: 50%;" class="w3-input w3-border" name="dateupdated" type="text" placeholder="Enter the DATE UPDATED">
						    </div></td>
					    </tr>
					    <tr>
							<td style="width:300px"><div class="float-child">BY LINE :	</div></td>
						    <td><div class="float-child">
						      <input style="border: 3px solid #73AD21;width: 50%;" class="w3-input w3-border" name="byline" type="text" placeholder="Enter the BY LINE">
						    </div></td>
					    </tr>
					    <tr>
							<td style="width:300px"><div class="float-child">OPENING DATE :</div></td>
						    <td><div class="float-child">
						      <input style="border: 3px solid #73AD21;width: 50%;" class="w3-input w3-border" name="openingdate" type="text" placeholder="Enter the OPENING DATE">
						    </div></td>
					    </tr>
					    <tr>
							<td style="width:300px"><div class="float-child">PUBLICATION DATE :	</div></td>
						    <td><div class="float-child">
						      <input style="border: 3px solid #73AD21;width: 50%;" class="w3-input w3-border" name="publicationdate" type="text" placeholder="Enter the PUBLICATION DATE">
						    </div></td>
					    </tr>
					    <tr>
							<td style="width:300px"><div class="float-child">SHORT SUMMARY :</div></td>
						    <td><div class="float-child">
						      <input style="border: 3px solid #73AD21;width: 50%;" class="w3-input w3-border" name="shortsummary" type="text" placeholder="Enter the SHORT SUMMARY">
						    </div></td>
					    </tr>
					</table>
					<br/>
					<button style=" margin-left:500px;" class="btn btn-primary btn-xl" id="submitButton" type="submit">Post Review</button>
				
				</form>
				
			</div>
		</div>
	</section>
	
	<div class="copyright py-4 text-center text-white">
		<div class="container">
			<small>Copyright &copy; Your Website 2021</small>
		</div>
	</div>
	
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	<!-- * *                               SB Forms JS                               * *-->
	<!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
</body>
</html>
