<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.saaspass.barcode.ResponseBarcode" %>

<!DOCTYPE html>
<html>
<head>
   <title>Saaspass Login </title>
    <script type="text/javascript">
	var sessionID = uuidv4();
        function callWebSocket() {

            var socket = new WebSocket('ws://localhost:8080/websocket/' + sessionID );

            socket.onopen = function () {
                alert("WebSocket handshake is successfull!");
            };

            socket.onmessage = function (e) {
		 //window.location = "http://localhost:8084/list-todos.do";
                alert("The message received is : " + e.data);
            };
            socket.onerror = function (e) {
                alert("An error occured while connecting... " + e.data);
            };
            socket.onclose = function () {
                alert("The conection has been clsoed");
            };

        }

function barcode(){
	
}

function uuidv4() {
  return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
    var r = Math.random() * 16 | 0, v = c === 'x' ? r : (r & 0x3 | 0x8);
    return v.toString(16);
  });
}
function push(){
	    var username= document.querySelector("[name=username]").value; 
	fetch('/push.do', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8'
    },
    body: `username=${username}&sessionID=${sessionID}`
  });
}

	callWebSocket();
    </script>
  
    
<title>Todos</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">

<style>
.footer {
	position: absolute;
	bottom: 0;
	width: 100%;
	height: 60px;
	background-color: #f5f5f5;
}
</style>
</head>



	<nav class="navbar navbar-default">


		<ul class="nav navbar-nav">
			<li class="active"><a href="#">Home</a></li>
		</ul>

		<ul class="nav navbar-nav navbar-right">
			<li><a href="/login.do">Login</a></li>
		</ul>

	</nav>

	<div class="container">
		<form action="/login.do" method="post">
			<p>
				<font color="red">${errorMessage}</font>
			</p>
			Username *: <input type="text" name="username" /> OTP *:<input
				type="password" name="password" /> <input type="submit"
				value="Login" />
		</form>
                    <button type="button" onclick="push()" >push</button> 
                    

	</div>
        <%
            ResponseBarcode res = new ResponseBarcode();
            
         %>
         
        <img id="barcodeImageGrid" src="data:image/png;base64,<%=res.getBarcode(request)%>"/>


	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>


</html>