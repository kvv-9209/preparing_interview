package hw1;

import hw1.patterns.Person;
import hw1.polymorphism.Circle;
import hw1.polymorphism.Figure;
import hw1.polymorphism.Square;
import hw1.polymorphism.Triangle;

public class main {
    public static void main(String[] args) {
//      1.  Создать builder для класса Person со следующими полями: String firstName, String lastName,
//                String middleName, String country, String address, String phone, int age, String gender.

        Person.builder()
                .firstName("Valentin")
                .lastName("Kalashnikov")
                .middleName("Null")
                .country("Russia")
                .address("Moscow")
                .phone("88005353535")
                .age(29)
                .gender("male")
                .build();

/**
 * Написать пример кода, который реализует принципы наследования и полиморфизма, на примере
 * фигур — круг, квадрат, треугольник.
 */
        Figure triangle = new Triangle();
        Figure square = new Square();
        Figure circle = new Circle();
    }
}
