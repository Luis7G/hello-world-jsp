package edu.ec.epn.saew;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "StudentControllerServlet", urlPatterns = "/student-list")

public class StudentControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> students = getStudentList();
        // ["Estud1", "Estud2", "Estud3"]
        // [10, 12, 20]
        String[] studentNames = new String[students.size()];
        int index = 0;
        for (Student s : students) {
            studentNames[index] = s.getName();
            index++;
        }
        System.out.println(Arrays.toString(studentNames));
        req.setAttribute("STUDENTS", students);
        RequestDispatcher dispatcher = req.getRequestDispatcher("student-list-table.jsp");
        dispatcher.forward(req, resp);
    }

    private List<Student> getStudentList() {
        List<Student> students = new ArrayList<Student>();
        students.add(new Student(1, "John Doe", 18.0f));
        students.add(new Student(2, "Jane Doe", 19.0f));
        students.add(new Student(3, "John Smith", 20.0f));
        return students;
    }
}
