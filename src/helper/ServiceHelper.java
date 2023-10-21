package helper;

import data.GlobalData;
import model.*;
import util.InputUtil;

import java.time.LocalDateTime;
import java.time.LocalTime;

import java.util.Random;

public class ServiceHelper {
    static long passengerId = 0 ;
    static long ticketId = 0;
    static long flightId = 0 ;

    public static Flight fillFlight() {

        String name = InputUtil.getInstance().inputString("Enter the flight name : "); ;
        String source = InputUtil.getInstance().inputString("Enter the flight source airport : "); ; ;
        String destination = InputUtil.getInstance().inputString("Enter the flight destination : "); ;;
        LocalDateTime date = LocalDateTime.now();
        LocalTime startingTime = dateHelperService();
        LocalTime reachingTime = dateHelperService();
        double price = InputUtil.getInstance().inputDouble("enter the  price");


        return Flight.builder()
                .id(++flightId)
                .name(name)
                .source(source)
                .destination(destination)
                .date(date)
                .startingTime(startingTime)
                .reachingTime(reachingTime)
                .price(price)
                .build();
    }


    public static Passenger fillPassenger(){
              String name = InputUtil.getInstance().inputString("Enter the passenger name: ");
              String surname = InputUtil.getInstance().inputString("Enter your surname: ");
              int age = InputUtil.getInstance().inputInt("Enter the age: ");
              String birthdate = InputUtil.getInstance().inputString("Enter the birthdate: ");
              String phoneNumber = InputUtil.getInstance().inputString("Enter the phone number:");
              String email = InputUtil.getInstance().inputString("Enter the email:");
              String passportNumber =InputUtil.getInstance().inputString("Enter the pass number:");
              String gender = InputUtil.getInstance().inputString("Enter the phone number:");
              int seatNumber = generateRandomSeatNumber();






        return Passenger.builder()
                .id(++passengerId)
                .name(name)
                .surname(surname)
                .age(age)
                .birthdate(birthdate)
                .phoneNumber(phoneNumber)
                .email(email)
                .passportNumber(passportNumber)
                .gender(gender)
                .seatNumber(seatNumber)
                .balance(2000)
                .ticketId(ticketId)




                .build();


    }
    public static int generateRandomSeatNumber() {
        Random rand = new Random();

        return rand.nextInt(100) + 1;
    }

    public static Ticket fillTicket(){
        int ticketNumber = generateRandomSeatNumber();
        String source = InputUtil.getInstance().inputString("Enter the departure place: ");
        String destination = InputUtil.getInstance().inputString("Enter the destination place: ");
        double price = InputUtil.getInstance().inputDouble("Enter the price: ");

        return Ticket.builder()
                .ticketNumber(ticketNumber)
                .source(source)
                .destination(destination)
                .price(price)
                .build();

    }
    private static LocalTime dateHelperService() {
        try {
            String str1 = InputUtil.getInstance().inputString("Enter the Date time (hours-minutes) : ");
            String[] str2 = str1.split("-");
            int hours = Integer.parseInt(str2[0]);
            int minutes = Integer.parseInt(str2[1]);
            return LocalTime.of(hours, minutes);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static Flight searchFlight(long id){
       return  GlobalData.noticeBoard.getFlightList().stream()
                .filter(flight -> flight.getId() == id)
               .findFirst()
               .orElseThrow();



    }
    public static Ticket searchTicket(long tId){
        GlobalData.ticketList.stream()
                .filter(ticket -> ticket.getId() == tId)
                .forEach(System.out::println);

        return new Ticket();
    }
}
