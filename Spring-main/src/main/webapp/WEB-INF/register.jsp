<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <title>Registration</title>
        </head>

        <body>
            <h2>For Trainer fill here</h2>
            <form:form id="regForm" modelAttribute="trainer" action="registerProcess" method="post" >

                <table align="center">
                <tr>
                  <td>
                      <form:label path="employeeId">employeeId</form:label>
                  </td>
                   <td>
                      <form:input path="employeeId" name="employeeId" id="employeeId" />
                   </td>
                   </tr>
                   <tr>
                        <td>
                            <form:label path="employeeFirstName">FirstName</form:label>
                        </td>
                        <td>
                            <form:input path="employeeFirstName" name="employeeFirstName" id="employeeFirstName" />
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <form:label path="employeeLastName">LastName</form:label>
                        </td>
                        <td>
                            <form:input  path="employeeLastName" name="employeeLastName" id="employeeLastName" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="employeeEmailId">Email</form:label>
                        </td>
                        <td>
                            <form:input path="employeeEmailId" name="employeeEmailId" id="employeeEmailId" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="employeePhoneNumber">Phone</form:label>
                        </td>
                        <td>
                            <form:input path="employeePhoneNumber" name="employeePhoneNumber" id="employeePhoneNumber" />
                        </td>
                    </tr>

                    <tr>
                        <td></td>
                        <td>
                            <form:button id="register" name="register">Register</form:button>
                        </td>
                    </tr>
                    <tr></tr>
                    <tr>
                        <td></td>
                        <td><a href="index.jsp">Home</a>
                        </td>
                    </tr>
                </table>
            </form:form>

        </body>

        </html>