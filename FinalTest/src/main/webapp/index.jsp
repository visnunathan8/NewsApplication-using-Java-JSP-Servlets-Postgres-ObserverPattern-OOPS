<%@page import="com.concordia.repository.ReviewRepository"%>
<%@page import="java.util.ArrayList" %>
<%@page import="com.concordia.entity.Review"%>
<%
	if(session.getAttribute("name") == null ) {
		response.sendRedirect("login.jsp");
	}
%>
<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
  border: 1px solid;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
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
						class="nav-link py-3 px-0 px-lg-3 rounded" href="#portfolio">Movie Reviews</a></li>
					<li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded" href="#about">Subscribed Content </a></li>
					<li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded" href="#contact">Subscriber list</a></li>
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
			<p class="masthead-subheading font-weight-light mb-0">MovieReviews-MultiMedia-MovieLink</p>
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
			<div style="height:400px;overflow:auto;">
			<%
			ArrayList<Review> review = ReviewRepository.selectFromReviewTable();
			for(int i=0; i<review.size(); i+=3) {
			System.out.println(i);
			%>
			
			<!-- Portfolio Grid Items-->
			<div class="row justify-content-center">
				<!-- Portfolio Item 1-->
				<div class="col-md-6 col-lg-4 mb-5">
					<div class="portfolio-item mx-auto" data-bs-toggle="modal"
						data-bs-target="#portfolioModal<%=i%>">
						<div
							class="portfolio-item-caption d-flex align-items-center justify-content-center h-100 w-100">
							<div
								class="portfolio-item-caption-content text-center text-white">
								<i class="fas fa-plus fa-3x"></i>
							</div>
						</div>
						<div style="padding-top:30px;text-align: center;height:100px;text-align: center;border: 3px solid green;">
							<%-- <div class="img-fluid" >Review <%=i%>    </div> --%>
							<div><b><%= review.get(i).getDisplay_title() %></b></div>
						</div>
					</div>
				</div>
				<!-- Portfolio Item 2-->
				<%if((i+1) < review.size()) { %>
				<div class="col-md-6 col-lg-4 mb-5">
					<div class="portfolio-item mx-auto" data-bs-toggle="modal"
						data-bs-target="#portfolioModal<%=i+1%>">
						<div
							class="portfolio-item-caption d-flex align-items-center justify-content-center h-100 w-100">
							<div
								class="portfolio-item-caption-content text-center text-white">
								<i class="fas fa-plus fa-3x"></i>
							</div>
						</div>
						<div style="padding-top:30px;text-align: center;height:100px;text-align: center;border: 3px solid green;">
							<%-- <div class="img-fluid" >Review <%=i+1%>    </div> --%>
							<div><b><%= review.get(i+1).getDisplay_title() %></b></div>
						</div>
					</div>
				</div>
				<%} %>
				<!-- Portfolio Item 3-->
				<%if((i+2) < review.size()) { %>
				<div class="col-md-6 col-lg-4 mb-5">
					<div class="portfolio-item mx-auto" data-bs-toggle="modal"
						data-bs-target="#portfolioModal<%=i+2%>">
						<div
							class="portfolio-item-caption d-flex align-items-center justify-content-center h-100 w-100">
							<div
								class="portfolio-item-caption-content text-center text-white">
								<i class="fas fa-plus fa-3x"></i>
							</div>
						</div>
						<div style="padding-top:30px;text-align: center;height:100px;text-align: center;border: 3px solid green;">
							<%-- <div class="img-fluid" >Review <%=i+2%>    </div> --%>
							<div><b><%= review.get(i+2).getDisplay_title() %></b></div>
						</div>
					</div>
				</div>
			<%}
				} %>	
			</div>
			</div>
		</div>
	</section>
	<!-- About Section-->
	<section class="page-section bg-primary text-white mb-0" id="about">
		<div class="container">
			<!-- About Section Heading-->
			<h2
				class="page-section-heading text-center text-uppercase text-white">SUBSCRIBED CONTENT</h2>
			<!-- Icon Divider-->
			<div class="divider-custom divider-light">
				<div class="divider-custom-line"></div>
				<div class="divider-custom-icon">
					<i class="fas fa-star"></i>
				</div>
				<div class="divider-custom-line"></div>
			</div>
			<div style="width:1300px;height:700px;background-color:white">
			
			</div>
			
		</div>
	</section>
	<!-- Contact Section-->
	<section class="page-section" id="contact">
		<div class="container">
			<!-- Contact Section Heading-->
			<h2
				class="page-section-heading text-center text-uppercase text-secondary mb-0">SUBCRIBER LIST</h2>
			<!-- Icon Divider-->
			<div class="divider-custom">
				<div class="divider-custom-line"></div>
				<div class="divider-custom-icon">
					<i class="fas fa-star"></i>
				</div>
				<div class="divider-custom-line"></div>
			</div>
			<!-- Subscriber Section -->
			<div class="row justify-content-center">
				<div class="col-lg-8 col-xl-7">
					
					<form id="contactForm" method="post" action="login">
						
						<!-- Submit Button-->
						<button class="btn btn-primary btn-xl disabled" id="submitButton"
							type="submit">Send</button>
					</form>
				</div>
			</div>
		</div>
	</section>
	<!-- Footer-->
	<footer class="footer text-center">
		<div class="container">
			<div class="row">
				<!-- Footer Location-->
				<div class="col-lg-4 mb-5 mb-lg-0">
					<h4 class="text-uppercase mb-4">Location</h4>
					<p class="lead mb-0">
						2215 John Daniel Drive <br /> Clark, MO 65243
					</p>
				</div>
				<!-- Footer Social Icons-->
				<div class="col-lg-4 mb-5 mb-lg-0">
					<h4 class="text-uppercase mb-4">Around the Web</h4>
					<a class="btn btn-outline-light btn-social mx-1" href="#!"><i
						class="fab fa-fw fa-facebook-f"></i></a> <a
						class="btn btn-outline-light btn-social mx-1" href="#!"><i
						class="fab fa-fw fa-twitter"></i></a> <a
						class="btn btn-outline-light btn-social mx-1" href="#!"><i
						class="fab fa-fw fa-linkedin-in"></i></a> <a
						class="btn btn-outline-light btn-social mx-1" href="#!"><i
						class="fab fa-fw fa-dribbble"></i></a>
				</div>
				<!-- Footer About Text-->
				<div class="col-lg-4">
					<h4 class="text-uppercase mb-4">About Freelancer</h4>
					<p class="lead mb-0">
						Freelance is a free to use, MIT licensed Bootstrap theme created
						by <a href="http://startbootstrap.com">Start Bootstrap</a> .
					</p>
				</div>
			</div>
		</div>
	</footer>
	<!-- Copyright Section-->
	<div class="copyright py-4 text-center text-white">
		<div class="container">
			<small>Copyright &copy; Your Website 2021</small>
		</div>
	</div>
	<%
	ArrayList<Review> data = ReviewRepository.selectFromReviewTable();
	for(int j=0; j<data.size(); j+=3) {
		
	%>
	<!-- Portfolio Modals-->
	<!-- Portfolio Modal 1-->
	<div class="portfolio-modal modal fade" id="portfolioModal<%=j%>"
		tabindex="-1" aria-labelledby="portfolioModal<%=j%>" aria-hidden="true">
		<div class="modal-dialog modal-xl">
			<div class="modal-content">
				<div class="modal-header border-0">
					<button class="btn-close" type="button" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body text-center pb-5">
					<div class="container">
						<div class="row justify-content-center">
							<div class="col-lg-8">
								<!-- Portfolio Modal - Title-->
								
								<h2
									class="portfolio-modal-title text-secondary text-uppercase mb-0"><%= review.get(j).getDisplay_title() %></h2>
								<!-- Icon Divider-->
								<div class="divider-custom">
									<div class="divider-custom-line"></div>
									<div class="divider-custom-icon">
										<i class="fas fa-star"></i>
									</div>
									<div class="divider-custom-line"></div>
								</div>
								
								<div style="height:400px;overflow:auto;">
																
								<div style="float:left; font-size: 200%; /* 36px */color: Crimson;"> Movie Review Details : </div><br/><br/><br/>
								<table>
								<tr>
									<div>
										<td> HEADLINE : </td><td> <%= review.get(j).getHeadline() %> </td>
									</div>
								</tr>
								<tr>
									<div>
										<td>MPAA RATING : </td><td> <%= review.get(j).getMpaa_rating() %> </td>
									</div>
								</tr>
								<tr>
									<div>
										<td>CRITICS PICK : </td><td> <%= review.get(j).getCritics_pick() %> </td>
									</div>
								</tr>
								<tr>
									<div>
										<td>DATE UPDATED : </td><td> <%= review.get(j).getDate_updated() %> </td>
									</div>
								</tr>
								<tr>
									<div>
										<td>BY LINE : </td><td> <%= review.get(j).getByline() %> </td>
									</div>
								</tr>
								<tr>
									<div>
										<td>OPENING DATE : </td><td> <%= review.get(j).getOpening_date() %> </td>
									</div>
								</tr>
								<tr>
									<div>
										<td>PUBLICATION DATE : </td><td> <%= review.get(j).getPublication_date() %> </td>
									</div>
								</tr>
								<tr>
									<div>
										<td>SHORT SUMMARY : </td><td> <%= review.get(j).getSummary_short() %> </td>
									</div>
								</tr>
								
								</table><br/><br/>
								<div style="float:left; font-size: 200%; /* 36px */color: Crimson;"> Multimedia Details : </div><br/><br/><br/>
								<table>
								<tr>
									<div>
										<td> MULTIMEDIA TYPE : </td><td> <%= review.get(j).getMultimedia().getType() %> </td>
									</div>
								</tr>
								<tr>
									<div>
										<td> CREDIT : </td><td> <%= review.get(j).getMultimedia().getCredit() %> </td>
									</div>
								</tr>
								<tr>
									<div>
										<td> SOURCE : </td><td> <%= review.get(j).getMultimedia().getSrc() %> </td>
									</div>
								</tr>
								<tr>
									<div>
										<td> HEIGHT : </td><td> <%= review.get(j).getMultimedia().getHeight() %> </td>
									</div>
								</tr>
								<tr>
									<div>
										<td> WEIDTH : </td><td> <%= review.get(j).getMultimedia().getWidth() %> </td>
									</div>
								</tr>
								</table>
								
								</table><br/><br/>
								<div style="float:left; font-size: 200%; /* 36px */color: Crimson;"> MovieLink Details : </div><br/><br/><br/>
								<table>
								<tr>
									<div>
										<td> MOVIELINK TYPE : </td><td> <%= review.get(j).getMovielink().getType() %> </td>
									</div>
								</tr>
								<tr>
									<div>
										<td> MOVIELINK URL : </td><td> <%= review.get(j).getMovielink().getURL() %> </td>
									</div>
								</tr>
								<tr>
									<div>
										<td> MOVIELINK SUGGESTED LINK TEXT : </td><td> <%= review.get(j).getMovielink().getSuggested_link_text() %> </td>
									</div>
								</tr>
								</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%if((j+1) < review.size()) { %>
	<!-- Portfolio Modal 2-->
	<div class="portfolio-modal modal fade" id="portfolioModal<%=j+1%>"
		tabindex="-1" aria-labelledby="portfolioModal<%=j+1%>" aria-hidden="true">
		<div class="modal-dialog modal-xl">
			<div class="modal-content">
				<div class="modal-header border-0">
					<button class="btn-close" type="button" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body text-center pb-5">
					<div class="container">
						<div class="row justify-content-center">
							<div class="col-lg-8">
								<!-- Portfolio Modal - Title-->
								<h2
									class="portfolio-modal-title text-secondary text-uppercase mb-0"><%= review.get(j+1).getDisplay_title() %></h2>
								<!-- Icon Divider-->
								<div class="divider-custom">
									<div class="divider-custom-line"></div>
									<div class="divider-custom-icon">
										<i class="fas fa-star"></i>
									</div>
									<div class="divider-custom-line"></div>
								</div>
								<div style="height:400px;overflow:auto;">
																
								<div style="float:left; font-size: 200%; /* 36px */color: Crimson;"> Movie Review Details : </div><br/><br/><br/>
								<table>
								<tr>
									<div>
										<td> HEADLINE : </td><td> <%= review.get(j+1).getHeadline() %> </td>
									</div>
								</tr>
								<tr>
									<div>
										<td>MPAA RATING : </td><td> <%= review.get(j+1).getMpaa_rating() %> </td>
									</div>
								</tr>
								<tr>
									<div>
										<td>CRITICS PICK : </td><td> <%= review.get(j+1).getCritics_pick() %> </td>
									</div>
								</tr>
								<tr>
									<div>
										<td>DATE UPDATED : </td><td> <%= review.get(j+1).getDate_updated() %> </td>
									</div>
								</tr>
								<tr>
									<div>
										<td>BY LINE : </td><td> <%= review.get(j+1).getByline() %> </td>
									</div>
								</tr>
								<tr>
									<div>
										<td>OPENING DATE : </td><td> <%= review.get(j+1).getOpening_date() %> </td>
									</div>
								</tr>
								<tr>
									<div>
										<td>PUBLICATION DATE : </td><td> <%= review.get(j+1).getPublication_date() %> </td>
									</div>
								</tr>
								<tr>
									<div>
										<td>SHORT SUMMARY : </td><td> <%= review.get(j+1).getSummary_short() %> </td>
									</div>
								</tr>
								
								</table><br/><br/>
								<div style="float:left; font-size: 200%; /* 36px */color: Crimson;"> Multimedia Details : </div><br/><br/><br/>
								<table>
								<tr>
									<div>
										<td> MULTIMEDIA TYPE : </td><td> <%= review.get(j+1).getMultimedia().getType() %> </td>
									</div>
								</tr>
								<tr>
									<div>
										<td> CREDIT : </td><td> <%= review.get(j+1).getMultimedia().getCredit() %> </td>
									</div>
								</tr>
								<tr>
									<div>
										<td> SOURCE : </td><td> <%= review.get(j+1).getMultimedia().getSrc() %> </td>
									</div>
								</tr>
								<tr>
									<div>
										<td> HEIGHT : </td><td> <%= review.get(j+1).getMultimedia().getHeight() %> </td>
									</div>
								</tr>
								<tr>
									<div>
										<td> WEIDTH : </td><td> <%= review.get(j+1).getMultimedia().getWidth() %> </td>
									</div>
								</tr>
								</table>
								
								</table><br/><br/>
								<div style="float:left; font-size: 200%; /* 36px */color: Crimson;"> MovieLink Details : </div><br/><br/><br/>
								<table>
								<tr>
									<div>
										<td> MOVIELINK TYPE : </td><td> <%= review.get(j+1).getMovielink().getType() %> </td>
									</div>
								</tr>
								<tr>
									<div>
										<td> MOVIELINK URL : </td><td> <%= review.get(j+1).getMovielink().getURL() %> </td>
									</div>
								</tr>
								<tr>
									<div>
										<td> MOVIELINK SUGGESTED LINK TEXT : </td><td> <%= review.get(j+1).getMovielink().getSuggested_link_text() %> </td>
									</div>
								</tr>
								</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%} %>
	<!-- Portfolio Modal 3-->
	<%if((j+2) < review.size()) {%>
	<div class="portfolio-modal modal fade" id="portfolioModal<%=j+2%>"
		tabindex="-1" aria-labelledby="portfolioModal<%=j+2%>" aria-hidden="true">
		<div class="modal-dialog modal-xl">
			<div class="modal-content">
				<div class="modal-header border-0">
					<button class="btn-close" type="button" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body text-center pb-5">
					<div class="container">
						<div class="row justify-content-center">
							<div class="col-lg-8">
								<!-- Portfolio Modal - Title-->
								<h2 
									class="portfolio-modal-title text-secondary text-uppercase mb-0"><%= review.get(j+2).getDisplay_title() %></h2>
								<!-- Icon Divider-->
								<div class="divider-custom">
									<div class="divider-custom-line"></div>
									<div class="divider-custom-icon">
										<i class="fas fa-star"></i>
									</div>
									<div class="divider-custom-line"></div>
								</div>
								<div style="height:400px;overflow:auto;">
																
								<div style="float:left; font-size: 200%; /* 36px */color: Crimson;"> Movie Review Details : </div><br/><br/><br/>
								<table>
								<tr>
									<div>
										<td> HEADLINE : </td><td> <%= review.get(j+2).getHeadline() %> </td>
									</div>
								</tr>
								<tr>
									<div>
										<td>MPAA RATING : </td><td> <%= review.get(j+2).getMpaa_rating() %> </td>
									</div>
								</tr>
								<tr>
									<div>
										<td>CRITICS PICK : </td><td> <%= review.get(j+2).getCritics_pick() %> </td>
									</div>
								</tr>
								<tr>
									<div>
										<td>DATE UPDATED : </td><td> <%= review.get(j+2).getDate_updated() %> </td>
									</div>
								</tr>
								<tr>
									<div>
										<td>BY LINE : </td><td> <%= review.get(j+2).getByline() %> </td>
									</div>
								</tr>
								<tr>
									<div>
										<td>OPENING DATE : </td><td> <%= review.get(j+2).getOpening_date() %> </td>
									</div>
								</tr>
								<tr>
									<div>
										<td>PUBLICATION DATE : </td><td> <%= review.get(j+2).getPublication_date() %> </td>
									</div>
								</tr>
								<tr>
									<div>
										<td>SHORT SUMMARY : </td><td> <%= review.get(j+2).getSummary_short() %> </td>
									</div>
								</tr>
								
								</table><br/><br/>
								<div style="float:left; font-size: 200%; /* 36px */color: Crimson;"> Multimedia Details : </div><br/><br/><br/>
								<table>
								<tr>
									<div>
										<td> MULTIMEDIA TYPE : </td><td> <%= review.get(j+2).getMultimedia().getType() %> </td>
									</div>
								</tr>
								<tr>
									<div>
										<td> CREDIT : </td><td> <%= review.get(j+2).getMultimedia().getCredit() %> </td>
									</div>
								</tr>
								<tr>
									<div>
										<td> SOURCE : </td><td> <%= review.get(j+2).getMultimedia().getSrc() %> </td>
									</div>
								</tr>
								<tr>
									<div>
										<td> HEIGHT : </td><td> <%= review.get(j+2).getMultimedia().getHeight() %> </td>
									</div>
								</tr>
								<tr>
									<div>
										<td> WEIDTH : </td><td> <%= review.get(j+2).getMultimedia().getWidth() %> </td>
									</div>
								</tr>
								</table>
								
								</table><br/><br/>
								<div style="float:left; font-size: 200%; /* 36px */color: Crimson;"> MovieLink Details : </div><br/><br/><br/>
								<table>
								<tr>
									<div>
										<td> MOVIELINK TYPE : </td><td> <%= review.get(j+2).getMovielink().getType() %> </td>
									</div>
								</tr>
								<tr>
									<div>
										<td> MOVIELINK URL : </td><td> <%= review.get(j+2).getMovielink().getURL() %> </td>
									</div>
								</tr>
								<tr>
									<div>
										<td> MOVIELINK SUGGESTED LINK TEXT : </td><td> <%= review.get(j+2).getMovielink().getSuggested_link_text() %> </td>
									</div>
								</tr>
								</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%}
	}%>
	<!-- Bootstrap core JS-->
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
