package service.impl;

import data.GlobalData;
import model.Flight;
import service.*;
import util.MenuUtil;

import java.util.InputMismatchException;

public class CustomerServiceImpl implements CustomerService {
    @Override
    public void viewFlights() {
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

    }
}
