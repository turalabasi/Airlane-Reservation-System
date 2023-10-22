package service.impl;

import Exceptions.ApplicationException;
import data.GlobalData;
import enums.ExceptionEnum;
import helper.ServiceHelper;
import model.Flight;
import model.Passenger;
import model.Ticket;
import service.*;
import util.InputUtil;
import util.MenuUtil;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.InputMismatchException;

import static data.GlobalData.*;

public class CustomerServiceImpl implements CustomerService {
    @Override
    public void viewFlights() {
        if (GlobalData.noticeBoard.getFlightList().isEmpty() ){
            throw new ApplicationException(ExceptionEnum.FLIGHT_NOT_FOUND);
        }
        GlobalData.noticeBoard.getFlightList().stream()
                .filter(Flight::isFlightStatus)
                .forEach(System.out::println);

    }

    @Override
    public void orderTicket() {
        while (true){
            try {
                CustomerManagement customerManagement = new CustomerManagementImpl();
                FlightService flightService = new IFlightService();

                byte choice =  MenuUtil.getInstance().flightsMenu();
                switch (choice) {
                    case 0 -> customerManagement.manage();
                    case 1 -> flightService.viewFlights();
                    case 2 -> flightService.searchFlights();
                    default -> throw new RuntimeException();
                }
            } catch (InputMismatchException | NumberFormatException e){
                System.err.println(e.getMessage());
            }


        }
    }


    @Override
    public void cancelTicket() {
        long cancelId = InputUtil.getInstance().inputLong("Enter the order to cancel: ");
        for (Flight flight : GlobalData.noticeBoard.getFlightList()){
            LocalDateTime nowDate = LocalDateTime.now();
            Duration duration = Duration.between(nowDate, flight.getDate().minusMinutes(30));
            if (duration.isNegative()){
                throw new ApplicationException(ExceptionEnum.EXPIRED_TIME);
            }
            if (flight.getId() == cancelId){
                long id = InputUtil.getInstance().inputLong("Enter the  passenger id: ");
                noticeBoard.getFlightList().remove(flight);
                Passenger passenger = ServiceHelper.searchPassenger(id);
                passenger.setBalance(passenger.getBalance() + flight.getPrice());
                airport.setTotalAmount(airport.getTotalAmount() - flight.getPrice());

            }
        }

    }
}
