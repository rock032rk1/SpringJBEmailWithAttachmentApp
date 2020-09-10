<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>
<body>
	<center>
		<div class="container">
			<center>
				<h2>Spring Mvc Mail Sender</h2>
			</center>
			<form action="sendmail" method="post">
				<table class="table table-bordered" style="width: 60%">
					<thead>
						<tr>
							<th colspan="2"><center>Simple Mail Sending</center></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>To:</td>
							<td><input type="email" name="email" required=""
								placeholder="Recipient Name" class="form-control"></td>
						</tr>
						<tr>
							<td>Subject:</td>
							<td><input type="text" name="subject" required=""
								placeholder="Subject" class="form-control"></td>
						</tr>
						<tr>
							<td>Message:</td>
							<td><textarea rows="5" cols="50" name="msg" required=""
									placeholder="Message" class="form-control"></textarea></td>
						</tr>
						<tr>
							<td><input type="reset" value="Reset" class="btn btn-info"></td>
							<td><input type="submit" value="Submit"
								class="btn btn-primary"></td>
						</tr>
					</tbody>
				</table>
				<center>
					<a href="email-attachment">Send Email with Attachment</a>
				</center>
			</form>
		</div>
	</center>
</body>
</html>