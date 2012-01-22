<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Socket Sensor</title>
</head>
<body>
<h1>
	Socket sensor
</h1>

<P> Temperature: ${temperature} <br />
	Humidity: ${humidity} <br />
	Light is ${lightIs}. Turn
	<c:url var="lightUrl" value="/socket/turnLight" />
	<form method="POST" action="${lightUrl}">
		<input type="hidden" name="turn" value="${turnLight}" />
		<input type="submit" value="${turnLight}" />
	</form>
	<br />
	Socket is ${socketIs}. Turn
	<c:url var="socketUrl" value="/socket/turnSocket" />
	<form method="POST" action="${socketUrl}">
		<input type="hidden" name="turn" value="${turnSocket}" />
		<input type="submit" value="${turnSocket}" />
	</form>

</body>
</html>