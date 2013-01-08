$(function() {
	$("#loginForm").submit(function() {
		
		var table="<table class=\"table\" id=\"right_table\"><thead><tr><th>#</th> <th>First Name</th> <th>Last Name</th><th>Username</th></tr></thead><tbody><tr> <td>1</td> <td>Mark</td><td>Otto</td> <td>@mdo</td></tr> <tr> <td>2</td> <td>Jacob</td> <td>Thornton</td> <td>@fat</td> </tr><tr> <td>3</td> <td>Larry</td><td>the Bird</td> <td>@twitter</td></tr></tbody></table>";
		//$("#right_table tbody:last").append(tablecontent);
		$("#userrights").append(table);
		return false;
	});

});