package model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
@Setter
@Getter
@AllArgsConstructor
@Builder
@ToString
@NoArgsConstructor

@FieldDefaults(level = AccessLevel.PRIVATE)
public class NoticeBoard {
    long id;
    List<Flight> flightList;


   public void addFlight(Flight flight){
       this.flightList.add(flight);
   }

}
