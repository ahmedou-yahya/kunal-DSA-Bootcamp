package oop.shallowVSdeepcoying;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException{
        Human  human1 = new Human(22, "Ahmedou Yahya");
        Human human2 = (Human) human1.clone();
        System.out.println(human2.name + " " + human2.age);
        human1.name = "M'keissir";
        System.out.println(human1.name);
        System.out.println(human2.name);
    }
}
