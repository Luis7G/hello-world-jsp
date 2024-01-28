package edu.ec.epn.saew;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MyFirstServlet", urlPatterns = "/my-first-servlet")

public class MyFirstServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Student> students = new ArrayList<Student>();
        students.add(new Student(1, "John Doe", 18.0f));
        students.add(new Student(2, "Jane Doe", 19.0f));
        students.add(new Student(3, "John Smith", 20.0f));

        PrintWriter out = resp.getWriter();
        resp.setContentType("text / html");
        out.println("<html>");
        out.println("<body>");
        out.println("<table>");

        // for(int i=0; i<students.size();i++)
        for (Student st : students) {
            out.println("<tr>");
            // ID de estudiante
            out.println("<td>");
            out.println(st.getId());
            out.println("</td>");

            // Nombre de estudiante
            out.println("<td>");
            out.println(st.getName());
            out.println("</td>");

            // Nota de estudiante
            out.println("<td>");
            out.println(st.getGrading());
            out.println("</td>");
            out.println("<tr>");
        }
        out.println("</table>");
        out.println("</html>");
        out.println("</body>");

    }

}