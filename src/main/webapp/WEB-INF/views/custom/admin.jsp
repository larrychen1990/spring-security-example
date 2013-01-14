<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container">
	<div class="row" style="height: 20px !important;"></div>
	<div class="row">

		<div id="userrights">
			<table class="table  table-hover" id="right_table">
				<thead>
					<tr>
						<th>#</th>
						<th>User Name</th>
						<th>Enabled</th>
						<th>Email</th>
						<th>Roles</th>
						<th>Delete user</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${users}" var="user">
						<tr>
							<td>${user.id}</td>
							<td>${user.username}</td>
							<td>${user.enabled}</td>
							<td>${user.email}</td>
							<td>
								<select id="role" name="role" class="select">
									<c:forEach items="${user.roles}" var="role">
									  <option value="${role.name}">${role.name}</option>
									</c:forEach>
								</select>
							</td>
							<td><button class="btn btn-primary" type="button">Delete
									User</button></td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
		</div>
		<p>
			<a href="#myModal" role="button" class="btn btn-primary"
				data-toggle="modal">Add User</a>
		</p>
	</div>


	<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<c:url var="url" value="/register"></c:url>
		<form id="registerForm" modelAttribute="user" method="POST" class="form-horizontal" action="${url}">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">×</button>
				<h3 id="myModalLabel">New User</h3>
			</div>
			<div class="modal-body">
				<div class="control-group">
					<label class="control-label" for="username">Name: </label>
					<div class="controls">
						<input type="text" path="username" name="username" id="username" placeholder="Name" required="required" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="password">Password: </label>
					<div class="controls">
						<input type="password" path="password" name="password" id="inputPassword" required="required" placeholder="Password" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="email">Email: </label>
					<div class="controls">
						<input type="text" path="email" name="email" id="email" placeholder="Email" required="required" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="role">Email: </label>
					<div class="controls">
						<select id="roleSelect" name="role">
						  <option value="ROLE_ADMIN">ADMIN</option>
						  <option value="ROLE_USER">USER</option>
						</select>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
				<button type="submit" class="btn btn-primary">Save</button>
			</div>
		</form>
	</div>
<script type="text/javascript">
$('#roleSelect').change(function() {
	  alert($(this).val());
	});
</script>

</div>