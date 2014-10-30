<html>
<head>
<title>Application Level Logging in EAP 6</title>
</head>
<body>

	<form action="LogServlet" method="Get">
		Choose Log Level : 	<select name="logLevel">
								<option>DEBUG</option>
								<option>INFO</option>
								<option>ERROR</option>
								<option>TRACE</option>
								<option selected="true">FATAL</option>
							</select> 
		<BR> Enter Message to be logged:
		<input type="textarea" name="logMessage"/> 
		<BR>
		<input type="submit" name="submit" value="Log Message" />
	</form>

</body>
</html>