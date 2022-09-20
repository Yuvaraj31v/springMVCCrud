<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <!DOC TYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Welcome</title>
    </head>
    <body>
    <h2>EMPLOYEE DETAILS</h2>
    <h3>Id </h3><%= request.getAttribute("employeeId") %><br>
    <h3>FirstName </h3><%= request.getAttribute("employeeFirstName") %><br>
    <h3>Lastname </h3><%= request.getAttribute("employeeLastName") %><br>
    <h3>phoneNumber</h3><%= request.getAttribute("employeePhoneNumber") %><br>
    </body>
    </html>