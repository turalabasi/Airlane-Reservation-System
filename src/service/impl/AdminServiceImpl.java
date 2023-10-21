package service.impl;

import Exceptions.ApplicationException;
import data.GlobalData;
import enums.ExceptionEnum;
import helper.ServiceHelper;
import model.Flight;
import service.AdminService;

import java.time.Duration;


public class AdminServiceImpl implements AdminService {
    @Override
    public boolean addFlight() {
        Flight flight = ServiceHelper.fillFlight();

         if (flight != null){
             GlobalData.noticeBoard.addFlight(flight);
             return true;
         }
        return false;
    }

    @Override
    public void viewTickets() {
        if (GlobalData.ticketList.isEmpty() ){
            throw new ApplicationException(ExceptionEnum.TICKETS_NOT_FOUND);
        }
       GlobalData.ticketList
               .forEach(System.out::println);

    }

    @Override
    public void viewFlight() {
        if (GlobalData.noticeBoard.getFlightList().isEmpty() ){
            throw new ApplicationException(ExceptionEnum.FLIGHT_NOT_FOUND);
        }
        GlobalData.noticeBoard.getFlightList()
                .forEach(System.out::println);

    }

    @Override
    public void viewPassenger() {
        if (GlobalData.noticeBoard.getFlightList().isEmpty() ){
            throw new ApplicationException(ExceptionEnum.FLIGHT_NOT_FOUND);
        }
        GlobalData.noticeBoard.getFlightList()
                .forEach(System.out::println);
    }

    @Override
    public void viewNoticeBoard() {
        for (Flight flight : GlobalData.noticeBoard.getFlightList()) {

            Duration duration = Duration.between(flight.getStartingTime(), flight.getReachingTime());
            if (duration.toHours() < 24) {
                flight.setFlightStatus(true);
            }

        }
    }

    @Override
    public void search() {

    }
}
