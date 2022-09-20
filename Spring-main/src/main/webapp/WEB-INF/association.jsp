<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <title>Registration</title>
        </head>

        <body>
            <h2>To get Trainer details from their Id</h2>
             <table align="center">
             <tr>
             <form action = "associationId" >
             <h2>Enter trainer ID</h2><input type = "text" name = "TrainerId">
             <h2>Enter trainee ID</h2><input type ="text" name="TraineeId">
             <input type ="submit">
             </form>
             </tr>
             <tr>
                 <td><a href="index.jsp">Home</a>
                 </td>
             </tr>


                    </body>

                    </html>