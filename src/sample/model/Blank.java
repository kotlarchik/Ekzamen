package sample.model;

import java.util.Objects;

public class Blank {
    private int id;
    private String student;
    private String courses;
    private String date1;
    private String date2;
    private String date3;
    private String date4;

    public Blank(int id, String student, String courses, String date1, String date2, String date3, String date4){
        this.id = id;
        this.student = student;
        this.courses = courses;
        this.date1 = date1;
        this.date2 = date2;
        this.date3 = date3;
        this.date4 = date4;
    }

    // Getters
    public int getId() {
        return id;
    }
    public String getStudent() {
        return student;
    }
    public String getCourses() {
        return courses;
    }
    public String getDate1() {
        return date1;
    }
    public String getDate2() {
        return date2;
    }
    public String getDate3() {
        return date3;
    }
    public String getDate4() {
        return date4;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }
    public void setStudent(String student) {
        this.student = student;
    }
    public void setCourses(String courses) {
        this.courses = courses;
    }
    public void setDate1(String date1) {
        this.date1 = date1;
    }
    public void setDate2(String date2) {
        this.date2 = date2;
    }
    public void setDate3(String date3) {
        this.date3 = date3;
    }
    public void setDate4(String date4) {
        this.date4 = date4;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Blank blank = (Blank) o;
        return id == blank.id &&
                Objects.equals(student, blank.student) &&
                Objects.equals(courses, blank.courses) &&
                Objects.equals(date1, blank.date1) &&
                Objects.equals(date2, blank.date2) &&
                Objects.equals(date3, blank.date3) &&
                Objects.equals(date4, blank.date4);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, student, courses, date1, date2, date3, date4);
    }
}
