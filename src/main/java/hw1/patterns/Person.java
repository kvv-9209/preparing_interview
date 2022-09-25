package hw1.patterns;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Person {
    String firstName;
    String lastName;
    String middleName;
    String country;
    String address;
    String phone;
    int age;
    String gender;
}
