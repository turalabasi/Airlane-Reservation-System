package service.impl;

import service.AirportManagement;
import service.CustomerManagement;
import service.CustomerService;
import util.MenuUtil;

import java.util.InputMismatchException;

public class CustomerManagementImpl implements CustomerManagement {
    @Override
    public void manage() {
        while (true) {

            try {
                int option = MenuUtil.getInstance().customerMenu();
                AirportManagement airportManagement = new IAirportManagement();
                CustomerService customerService = new CustomerServiceImpl();
                switch (option) {
                    case 0 -> System.exit(0);
                    case 1 -> airportManagement.management();
                    case 2 -> customerService.viewFlights();
                    case 3 -> customerService.orderTicket();
                    case 4 -> customerService.cancelTicket();
                    default -> throw new RuntimeException();
                }
            } catch (
                    InputMismatchException | NumberFormatException e) {
                System.err.println(e.getMessage());

            }

        }
    }
}
