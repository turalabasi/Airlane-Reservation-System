package data;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import model.*;

import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)

public class GlobalData {
    static long flightId = 0;




    public static  Airport airport = Airport.builder()
            .id(1)
            .name("Hon Kong International Airport")
            .area(" Chek Lap Kok, New Territories,")
            .totalAmount(9000000)
            .build();


   public static NoticeBoard noticeBoard = NoticeBoard.builder()
           .id(++flightId)
           .flightList(new ArrayList<>())


           .build();


   public static List<Ticket>ticketList = new ArrayList<>();

   public static List<Passenger>passengerList = new ArrayList<>();


}



