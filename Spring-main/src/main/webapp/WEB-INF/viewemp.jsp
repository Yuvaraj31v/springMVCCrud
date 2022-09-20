<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

      <table border="2" width="70%">
      <tr><th>employeeId</th><th>employeeFirstName</th><th>employeeLastName</th><th>employeePhoneNumber</th><th>employeeEmailId</th></tr>
   <c:forEach var="employee" items="${list}" >
   <tr>
    <td>${employee.employeeId}</td><br>
    <td>${employee.employeeFirstName}</td><br>
    <td>${employee.employeeLastName}</td><br>
    <td>${employee.employeePhoneNumber}</td><br>
    <td>${employee.employeeEmailId}</td><br>
   </tr>
   </c:forEach>
    </table>
    <a href="index.jsp">Home</a>


