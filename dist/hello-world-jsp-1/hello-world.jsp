<html>

<body>
    <!-- Directivas -->
    <%@ page import="java.util.Date" %>

        <!-- Scriptlets -->
        <% //Objetos implicitos //out -> PrintWritter (Salida HTML que deseo imprimir)
            //request -> Representa el request del Cliente hacia el recurso
            //response -> Representa la respuesta del Servidor (Aplicaciones) hacia el Cliente
            //session -> Representa la sesion del usuario
            //config -> Configuraciones de las Aplicaciones
            //page Context-> Contexto de memoria limitado a la pagina
            //page -> Representa la clase compilada a partir del JSP
            //exception -> Representa una excepcion.
            out.println(new Date());

            String name = "Joel Guingla";
            session.setAttribute("nombre", name);

            %>
            <br>
            <!-- Expresiones  -->
            <%= new Date() %>
</body>

</html>