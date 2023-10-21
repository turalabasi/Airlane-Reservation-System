package service.impl;

import data.GlobalData;
import helper.ServiceHelper;
import model.Flight;
import model.Passenger;
import model.Ticket;
import service.FlightService;
import util.InputUtil;

import java.time.LocalDateTime;

import static data.GlobalData.airport;
import static helper.ServiceHelper.fillFlight;
import static helper.ServiceHelper.generateRandomSeatNumber;

public class IFlightService implements FlightService {

    static long id = 0;
    static long fId = 0;
    static long lId = 0;
    @Override
    public void viewFlights() {
        GlobalData.noticeBoard.getFlightList().stream()
                .filter(Flight::isFlightStatus)
                .forEach(System.out::println);


        long fId = InputUtil.getInstance().inputLong("enter the flight id: ");
        Flight flight = ServiceHelper.searchFlight(fId);


        Ticket ticket = new Ticket(++id,generateRandomSeatNumber(), flight.getSource(), flight.getDestination(),flight.getPrice(),flight.getId());


        ticket.setFlightId(fId);

        Passenger passenger = ServiceHelper.fillPassenger();

        GlobalData.airport.setTotalAmount(airport.getTotalAmount() - ticket.getPrice() );
        passenger.setBalance(passenger.getBalance() - ticket.getPrice());
        System.out.println("------ Cash Receipt ------");

        System.out.println("Date: " + LocalDateTime.now());
        System.out.println("Flight name: " + flight.getName());
        System.out.println("Seat number: " + passenger.getSeatNumber());
        System.out.println("Passenger full name: " + passenger.getName() + " " + passenger.getSurname());
        System.out.println("Passenger phone number: " + passenger.getPhoneNumber());
        System.out.println("Passenger email: " + passenger.getEmail());
        System.out.println("Source: " + ticket.getSource());
        System.out.println("Destination: " + ticket.getDestination());
        System.out.println("Date: " + flight.getDate());
        System.out.println("StartingTime: " + flight.getStartingTime());
        System.out.println("ReachingTime: " + flight.getReachingTime());
        System.out.println("Cash: " + ticket.getPrice() + " AZN");
        System.out.println("-------------------------");




    }

    @Override
    public void searchFlights() {
        Flight flight = fillFlight();
        Ticket ticket = new Ticket(++id,generateRandomSeatNumber(), flight.getSource(), flight.getDestination(),flight.getPrice(),flight.getId());

        ticket.setFlightId(flight.getId());
        System.out.println(flight);

        Passenger passenger = ServiceHelper.fillPassenger();

        GlobalData.airport.setTotalAmount(airport.getTotalAmount() - ticket.getPrice() );
        passenger.setBalance(passenger.getBalance() - ticket.getPrice());

        System.out.println("------ Cash Receipt ------");

        System.out.println("Date: " + LocalDateTime.now());
        System.out.println("Flight name: " + flight.getName());
        System.out.println("Seat number: " + passenger.getSeatNumber());
        System.out.println("Passenger full name: " + passenger.getName() + " " + passenger.getSurname());
        System.out.println("Passenger phone number: " + passenger.getPhoneNumber());
        System.out.println("Passenger email: " + passenger.getEmail());
        System.out.println("Source: " + ticket.getSource());
        System.out.println("Destination: " + ticket.getDestination());
        System.out.println("Date: " + flight.getDate());
        System.out.println("StartingTime: " + flight.getStartingTime());
        System.out.println("ReachingTime: " + flight.getReachingTime());
        System.out.println("Cash: " + ticket.getPrice() + " AZN");
        System.out.println("-------------------------");
    }
}









