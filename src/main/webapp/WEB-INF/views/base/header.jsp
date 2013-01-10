<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="navbar navbar-inverse navbar-fixed-top">
	<div class="navbar-inner">
		<div class="container">
			<button type="button" class="btn btn-navbar" data-toggle="collapse"
				data-target=".nav-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="brand" href="#" id="username">hf</a>
			<div class="nav-collapse collapse">
				<ul class="nav">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"> Login <b class="caret" id="login_caret"></b>
					</a>
						<ul class="dropdown-menu">
							<li>
								<c:url value="/login" var="url" />
								<form:form style="padding-left: 20px; padding-right: 20px;"
									id="loginForm" modelAttribute="user"  action="${url}">
									<div class="control-group">
										<label class="control-label" for="inputEmail">Name</label>
										<div class="controls">
											<form:input type="text" path="name" id="inputEmail" placeholder="Name"/>
										</div>
									</div>
									<div class="control-group">
										<label class="control-label" for="inputPassword">Password</label>
										<div class="controls">
											<form:input type="password" path="password" id="inputPassword"
												placeholder="Password"/>
										</div>
									</div>
									<div class="control-group">
										<div class="controls">
											<label class="checkbox"> <input  type="checkbox"></input>
												Remember me
											</label>
											<form:button type="submit" class="btn">Sign in</form:button>
										</div>
									</div>
								</form:form>
							</li>
						</ul></li>
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


