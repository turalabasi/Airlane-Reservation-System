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
public class Airport {
       private  long id;
       private String name;
       private String area;
       private double totalAmount;
}
