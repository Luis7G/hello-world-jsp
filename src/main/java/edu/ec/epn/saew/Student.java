package edu.ec.epn.saew;

public class Student {
    private Integer id;
    private String name;
    private Float grading;

    public Student(Integer id, String name, Float grading) {
        this.id = id;
        this.name = name;
        this.grading = grading;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getGrading() {
        return grading;
    }

    public void setGrading(Float grading) {
        this.grading = grading;
    }

}
