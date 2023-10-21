package service.impl;

import service.AdminManagement;
import service.AdminService;
import service.AirportManagement;
import service.CustomerManagement;
import util.MenuUtil;

import java.util.InputMismatchException;

public class IAirportManagement implements AirportManagement {
    @Override
    public void management() {
        while (true){
            try {
                AdminService adminService = new AdminServiceImpl();
                AdminManagement adminManagement = new AdminManagementImpl();
                CustomerManagement customerManagement = new CustomerManagementImpl();
                byte choice =  MenuUtil.getInstance().mainMenu();
                switch (choice) {
                    case 0 -> System.exit(0);
                    case 1 -> adminManagement.manage();
                    case 2 -> customerManagement.manage();
                    default -> throw new RuntimeException();
                }
            } catch (InputMismatchException | NumberFormatException e){
                System.err.println(e.getMessage());
            }


        }
    }
}
