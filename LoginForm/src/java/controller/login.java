package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.*;

@WebServlet(name = "login", urlPatterns = {"/login"})
public class login extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        use_bean ub = new use_bean();
        session.setAttribute("bean", ub);
        try (PrintWriter out = response.getWriter()) {
            String _username = request.getParameter("username");
            String _password = request.getParameter("password");

            if (_username != null && _password != null) {
                String connectionURL = "jdbc:derby://localhost:1527/dbms";
                //ConnectionURL, username and password should be specified in getConnection() 
                ub.setName(_username);
                try {
                    Connection conn = DriverManager.getConnection(connectionURL, "login", "login");
                    String sql = "SELECT * FROM login.login";
                    Statement st = conn.createStatement();
                    ResultSet rs = null;
                    rs = st.executeQuery(sql);

                    while (rs.next()) {
                        System.out.println(rs.getString("user_id") + "\t" + rs.getString("password"));
                        if (rs.getString("user_id").equals(_username) && rs.getString("password").equals(_password)) {
                            //        response.sendRedirect("welcome.jsp");
                            RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
                            rd.forward(request, response);

                        } else {
                            //  out.println("invalid user or password");
                            RequestDispatcher rd = request.getRequestDispatcher("newjsp.jsp");
                            rd.forward(request, response);
                            
                        }
                    }
                    rs.close();
                    st.close();
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println("Connect failed ! ");
                }

//                if (_username.equals("Peter") && _password.equals("12345")) {
                //                   response.sendRedirect("welcome.jsp");
                //              } else {
                //                 out.println("invalid user or password");
                //               }
            } else {
                out.println("Empty Username or password");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
