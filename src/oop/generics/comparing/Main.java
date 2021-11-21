package oop.generics.comparing;

public class Main {

    public static void main(String[] args) {
        Student student1 = new Student("Ahmedou", 99);
        Student student2 = new Student("Mezid", 89);

        if (student1.compareTo(student2)>0){
            System.out.println(student1.getName() + " is above " + student2.getName());
        }
        else if (student1.compareTo(student2)>0){
            System.out.println(student1.getName() + " and " + student2.getName() + "are equal");
        }
        else
            System.out.println(student2.getName() + " is above " + student1.getName());

    }
}
