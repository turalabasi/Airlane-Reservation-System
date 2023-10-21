package model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.time.LocalTime;


@Setter
@Getter
@AllArgsConstructor
@Builder
@ToString
@NoArgsConstructor

@FieldDefaults(level = AccessLevel.PRIVATE)
public class Flight {
    long id ;
    String name ;
    String source;
    String destination;
    LocalDateTime date;
    LocalTime startingTime;
    LocalTime reachingTime;
    double price;
    boolean flightStatus;

}
