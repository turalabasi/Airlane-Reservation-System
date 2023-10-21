package model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@AllArgsConstructor
@Builder
@ToString
@NoArgsConstructor

@FieldDefaults(level = AccessLevel.PRIVATE)
public class Passenger{
    long id;
    String name;
    String surname;
    int age;
    String birthdate;
    String phoneNumber;
    String email;
    String passportNumber;
    String gender;
    double balance;
    long ticketId;
    int seatNumber;
}
