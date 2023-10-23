package part2;

import part1.CourseGrade;

import java.util.List;

public class Applicant {
    private String name;
    private List<CourseGrade> grades;
    private double gpa;

    public Applicant(String name, List<CourseGrade> grades, double gpa) { // Constructor
        this.name = name;
        this.grades = grades;
        this.gpa = gpa;
    }

    public String getName() {
        return this.name;
    }

    public List<CourseGrade> getGrades() {
        return this.grades;
    }

    public CourseGrade getGradeFor(String course) {
        for (CourseGrade i: grades) {
            if (i.getCourseName().equals(course)) {
                return i;
            }
        }
        return new CourseGrade("generic", 100);
    }

    public double getGPA() {
        return gpa;
    }
}
