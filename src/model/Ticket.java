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
public class Ticket {
    long id;
    int ticketNumber ;
    String source;
    String destination;
    double price;
    long flightId;
}
