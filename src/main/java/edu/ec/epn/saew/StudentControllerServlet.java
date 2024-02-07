package edu.ec.epn.saew;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet(name = "StudentControllerServlet", urlPatterns = "/student-list")

public class StudentControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> students = getStudentList();
        // ["Estud1", "Estud2", "Estud3"]
        // [10, 12, 20]
        String view = "list";
        if (req.getParameter("view") != null && "chart".equals(req.getParameter("view"))) {
            view = "chart";
        }

        List<String> studentNames = students.stream().map(student -> student.getName()).collect(Collectors.toList());
        List<String> studentGrades = students.stream().map(student -> student.getGrading().toString())
                .collect(Collectors.toList());

        Gson gson = new Gson();
        String studentNameAsString = gson.toJson(studentNames);
        String studentGradesAsString = gson.toJson(studentGrades);
        // System.out.println(Arrays.toString(studentNames.toArray()));
        // String[] studentNames = new String[students.size()];
        // int index = 0;
        // for (Student s : students) {
        // studentNames[index] = s.getName();
        // index++;
        // }
        // System.out.println(Arrays.toString(studentNames));
        req.setAttribute("STUDENTS", students);
        req.setAttribute("STUDENT_NAMES", studentNameAsString);
        req.setAttribute("STUDENT_GRADES", studentGradesAsString);
        RequestDispatcher dispatcher = req.getRequestDispatcher("student-list-table.jsp");
        if ("list".equals(view)) {
            dispatcher = req.getRequestDispatcher("student-list-table.jsp");
        } else {
            dispatcher = req.getRequestDispatcher("student-list-chart.jsp");
        }
        dispatcher.forward(req, resp);
    }

    private List<Student> getStudentList() {
        List<Student> students = new ArrayList<Student>();
        students.add(new Student(1, "John Doe", 18.0f));
        students.add(new Student(2, "Jane Doe", 19.0f));
        students.add(new Student(3, "John Smith", 20.0f));
        return students;
    }

    // public static void main(String[] args) {
    // List<Integer> myNumbers = new ArrayList<Integer>();
    // myNumbers.add(1);
    // myNumbers.add(2);
    // myNumbers.add(3);
    // myNumbers.add(4);

    // myNumbers.stream().forEach(v -> {
    // System.out.println("Number:" + v);
    // });

    // List<Integer> numberFiltered = myNumbers.stream().filter(v -> {
    // // True en caso de que el filtro cumpla con el criterio o false en caso
    // // contrario
    // if (v % 2 == 0) {
    // return true;
    // } else {
    // return false;
    // }
    // }).collect(Collectors.toList());
    // Optional<Integer> number = myNumbers.stream().filter(v -> v >
    // 2).findAny();
    // // El primer intem de la lista que
    // Optional<Integer> number = myNumbers.stream().filter(v -> v > 2).findFirst();
    // El primer intem de la lista que
    // if (number.isPresent()) {
    // System.out.println("Se ha encontrado un numero mayor a 2: " + number.get());
    // } // cumpla la condicion
    // else {
    // System.out.println("No se ha encontrado un numero mayor a 2");
    // }
    // List<Integer> numberFiltered = myNumbers.stream().filter(v -> v % 2 ==
    // 0).collect(Collectors.toList());
    // System.out.println(Arrays.toString(numberFiltered.toArray()));

    // MAP transformar una lista en otra completamente diferente con el mismo
    // numero
    // de elementos.
    // List<Integer> numberMultiplied = myNumbers.stream().map(v -> v *
    // 3).collect(Collectors.toList());
    // System.out.println(Arrays.toString(numberMultiplied.toArray()));

    // Reduce
    // 1 iteration -> subtotal = 0, v=1 -> 0+1 = 1
    // 2 iteration -> subtotal = 1, v=2 -> 1+2 = 3
    // 3 iteration -> subtotal = 3, v=3 -> 3+3 = 6
    // 4 iteration -> subtotal = 6, v=4 -> 6+4 = 10
    // int result = myNumbers.stream().reduce(0, (subtotal, v) -> subtotal + v);
    // System.out.println("Resultado: " + result);

    // Lo siguiente es parecido al anterior.
    // List<Integer> result = new ArrayList<Integer>();
    // for (Integer v : myNumbers) {
    // if (v % 2 == 0) {
    // result.add(v);
    // }
    // }
    // }
}
