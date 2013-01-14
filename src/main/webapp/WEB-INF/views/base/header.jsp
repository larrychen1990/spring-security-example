<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<div class="navbar navbar-inverse navbar-fixed-top">
	<div class="navbar-inner">
		<div class="container">
			<button type="button" class="btn btn-navbar" data-toggle="collapse"
				data-target=".nav-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="brand" href="#" id="username"><tiles:insertAttribute
					name="title" ignore="true" /></a>
			<div class="nav-collapse collapse">
				<ul class="nav">
					<security:authorize access="isAnonymous()">
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"> Login <b class="caret"
								id="login_caret"></b>
						</a>

							<ul class="dropdown-menu">
								<li>
									<form style="padding-left: 20px; padding-right: 20px;"
										id="loginForm" modelAttribute="user" method="POST"
										action="<c:url value='j_spring_security_check' />">
										<div class="control-group">
											<label class="control-label" for="inputEmail">Name</label>
											<div class="controls">
												<input type="text" path="username" name="j_username"
													id="inputEmail" placeholder="Name" required="required" />
											</div>
										</div>
										<div class="control-group">
											<label class="control-label" for="inputPassword">Password</label>
											<div class="controls">
												<input type="password" path="password" name="j_password"
													id="inputPassword" required="required"
													placeholder="Password" />
											</div>
										</div>
										<div class="control-group">
											<div class="controls">
												<label class="checkbox"> <input type="checkbox"></input>
													Remember me
												</label>
												<button type="submit" name="submit" class="btn">Sign
													in</button>
											</div>
										</div>
									</form>
								</li>
							</ul></li>
					</security:authorize>

					<security:authorize access="isAuthenticated()">
						<li><a href='<c:url value="/j_spring_security_logout"/>'>Logout</a></li>
					</security:authorize>
					<security:authorize access="hasRole('ROLE_ADMIN')">
						<li><a href='<c:url value="/admin"/>'>Admin</a></li>
					</security:authorize>
				</ul>
			</div>
		</div>
	</div>
</div>

<header class="jumbotron subhead" id="overview">
	<div class="container">
		<h1>Sec Sample</h1>

	</div>
</header>


