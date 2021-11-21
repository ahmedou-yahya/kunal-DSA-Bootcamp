package oop.generics.comparing;

public class Student implements Comparable<Student>{

    private String name;
    private float mark;

    public Student(String name, float mark){
        this.name = name;
        this.mark = mark;
    }

    @Override
    public int compareTo(Student student) {
        return (int) (this.mark-student.mark);
    }

    public String getName() {
        return name;
    }

    public float getMark() {
        return mark;
    }
}
