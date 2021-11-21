package oop.enums;

public class Main {

    public static void main(String[] args) {
        Week week = Week.Friday;

//        for (Week day: week.values()) {
//            System.out.println(day);
//        }

        System.out.println(week.ordinal());
    }
}
