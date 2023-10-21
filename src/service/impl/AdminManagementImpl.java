package service.impl;

import service.AdminManagement;
import service.AdminService;
import service.AirportManagement;

import util.MenuUtil;

import java.util.InputMismatchException;

public class AdminManagementImpl implements AdminManagement {

    @Override
    public void manage() {
        while (true) {

            try {
                byte option = MenuUtil.getInstance().AdminMenu();
                AirportManagement airportManagement = new IAirportManagement();

                AdminService adminService = new AdminServiceImpl();

                switch (option) {
                    case 0 -> System.exit(0);
                    case 1 -> airportManagement.management();
                    case 2 -> adminService.addFlight();
                    case 3 -> adminService.viewTickets();
                    case 4 -> adminService.viewPassenger();
                    case 5 -> adminService.viewNoticeBoard();
                    case 6 -> adminService.viewFlight();
                    case 7 -> adminService.search();
                    default -> throw new RuntimeException();
                }
            } catch (
                    InputMismatchException | NumberFormatException e) {
                System.err.println(e.getMessage());

            }

        }
    }
}
