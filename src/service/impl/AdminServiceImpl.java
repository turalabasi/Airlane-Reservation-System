package service.impl;

import Exceptions.ApplicationException;
import data.GlobalData;
import enums.ExceptionEnum;
import helper.ServiceHelper;
import model.Flight;
import service.AdminService;
import util.InputUtil;

import java.time.*;

import static data.GlobalData.noticeBoard;


public class AdminServiceImpl implements AdminService {
    @Override
    public boolean addFlight() {
        Flight flight = ServiceHelper.fillFlight();

        if (flight != null) {
            noticeBoard.addFlight(flight);
            if (LocalTime.now().isAfter(flight.getStartingTime()) && LocalTime.now().isBefore(flight.getReachingTime()) ) {
                flight.setFlightStatus(true);
                return true;
            }

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
        if (noticeBoard.getFlightList().isEmpty() ){
            throw new ApplicationException(ExceptionEnum.FLIGHT_NOT_FOUND);
        }
        noticeBoard.getFlightList()
                .forEach(System.out::println);

    }

    @Override
    public void viewPassenger() {
        if (noticeBoard.getFlightList().isEmpty() ){
            throw new ApplicationException(ExceptionEnum.FLIGHT_NOT_FOUND);
        }
        noticeBoard.getFlightList()
                .forEach(System.out::println);
    }

    @Override
    public void viewNoticeBoard() {
        for (Flight flight : noticeBoard.getFlightList()) {

            Duration duration = Duration.between(flight.getDate(),LocalDateTime.now() );
            if ( duration.toHours() < 24) {
                System.out.println(flight);

            }

        }
    }

    @Override
    public void search() {
        long id = InputUtil.getInstance().inputLong("enter the ticket id: ");
        ServiceHelper.searchTicket(id);

    }
}
