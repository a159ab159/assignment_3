<%-- 
    Document   : welcome
    Created on : Nov 4, 2018, 2:02:05 AM
    Author     : a159a
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
    </head>
    <body>
    <center><h1>Welcome</h1></center> 
    <h3>this user name is sent by bean</h3>
    <br>
    <p>user name :</p><jsp:getProperty name="bean" property="name"/>
    </body>
</html>
