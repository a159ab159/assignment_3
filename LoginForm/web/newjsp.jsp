<%-- 
    Document   : newjsp
    Created on : Nov 3, 2018, 7:56:49 PM
    Author     : a159a
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href ="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel ="stylesheet">
        <title>Login</title>
        <style>
            td{
                padding: 10px;
            }
            div{
                width: 50%;
                border: 1px solid black;
                border-radius: 5 px;
                background-color: lightslategrey;
            }
        </style>
        
        
        <jsp:useBean id ="bean" class = "controller.use_bean" scope="session"/>
    </head>
    <body>
    <center><h1><u>Login here</h1</u></center>
<center>
    <div>
        <form action="login" method="POST">
            <table>
                <tr>
                    <td>User name</td>
                    <td><input type ="text" class ="form-control" name = "username" placeholder="User name"></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type ="password" class ="form-control" name = "password" placeholder="Password"></td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align: center"><input class="btn-success" type ="submit" value="Submit"></td>
                </tr>
                <tr><td><a href="MyFirstServlet">Click here to servlet</a></td></tr>
            </table>
        </form>
    </div>

</center>
</body>
</html>
