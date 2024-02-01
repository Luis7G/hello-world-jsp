<%@ page import="java.util.List" %>
    <%@ page import="edu.ec.epn.saew.Student" %>

        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Lista de Estudiantes</title>
        </head>


        <body style="background-color: black;">
            <h1>Lista de Estudiantes</h1>
            <table border="1" style="color: white;">
                <tr>
                    <th>
                        Id
                    </th>
                    <th>
                        Nombre
                    </th>
                    <th>
                        Nota
                    </th>
                </tr>
                <% List<Student> students = (List) request.getAttribute("STUDENTS");
                    for(Student s: students) {
                    %>
                    <tr>
                        <td>
                            <%= s.getId() %>
                        </td>
                        <td>
                            <%= s.getName() %>
                        </td>
                        <td>
                            <%= s.getGrading() %>
                        </td>
                    </tr>
                    <%}%>
            </table>
        </body>

        </html>