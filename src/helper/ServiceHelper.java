package helper;

import data.GlobalData;
import model.*;
import util.InputUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import java.util.Random;

import static data.GlobalData.airport;

public class ServiceHelper {
    static  long id =0;
    static long passengerId = 0;
    static long ticketId = 0;
    static long flightId = 0;

    public static Flight fillFlight() {

        String name = InputUtil.getInstance().inputString("Enter the flight name : ");
        ;
        String source = InputUtil.getInstance().inputString("Enter the flight source airport : ");
        ;
        ;
        String destination = InputUtil.getInstance().inputString("Enter the flight destination : ");
        ;
        ;
        LocalDateTime date = dateTimeHelperService();
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


    public static Passenger fillPassenger() {
        String name = InputUtil.getInstance().inputString("Enter the passenger name: ");
        String surname = InputUtil.getInstance().inputString("Enter your surname: ");
        int age = InputUtil.getInstance().inputInt("Enter the age: ");
        String birthdate = InputUtil.getInstance().inputString("Enter the birthdate: ");
        String phoneNumber = InputUtil.getInstance().inputString("Enter the phone number:");
        String email = InputUtil.getInstance().inputString("Enter the email:");
        String passportNumber = InputUtil.getInstance().inputString("Enter the pass number:");
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

    public static Ticket fillTicket() {
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
            String str1 = InputUtil.getInstance().inputString("Enter the  time (hours-minutes-seconds) : ");
            String[] str2 = str1.split("-");
            int hours = Integer.parseInt(str2[0]);
            int minutes = Integer.parseInt(str2[1]);
            int seconds = Integer.parseInt(str2[1]);
            return LocalTime.of(hours, minutes, seconds);

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static Flight searchFlight(long id) {
        return GlobalData.noticeBoard.getFlightList().stream()
                .filter(flight -> flight.getId() == id)
                .findFirst()
                .orElseThrow();

    }

    public static Passenger searchPassenger(long id) {
        return GlobalData.passengerList.stream()
                .filter(passenger -> passenger.getId() == id)
                .findFirst()
                .orElseThrow();
    }

    public static Ticket searchTicket(long tId) {
        return GlobalData.ticketList.stream()
                .filter(ticket -> ticket.getId() == tId)
                .findFirst()
                .orElseThrow();


    }


    private static LocalDateTime dateTimeHelperService() {
        try {
            String dateInput = InputUtil.getInstance().inputString(("Enter the Local Date (day-month-year): "));
            String timeInput = InputUtil.getInstance().inputString(("Enter the Local Time for the Date (hours-minutes): "));


            String[] dateParts = dateInput.split("-");
            int year = Integer.parseInt(dateParts[2]);
            int month = Integer.parseInt(dateParts[1]);
            int day = Integer.parseInt(dateParts[0]);

            String[] timeParts = timeInput.split("-");
            int hours = Integer.parseInt(timeParts[0]);
            int minutes = Integer.parseInt(timeParts[1]);

            LocalDate date = LocalDate.of(year, month, day);
            LocalTime time = LocalTime.of(hours, minutes);

            return LocalDateTime.of(date, time);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public static Ticket getTicket(Flight flight) {
        Ticket ticket = new Ticket(++id,generateRandomSeatNumber(), flight.getSource(), flight.getDestination(), flight.getPrice(), flight.getId());
        GlobalData.ticketList.add(ticket);
        return ticket;
    }

}
