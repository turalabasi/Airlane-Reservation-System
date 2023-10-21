import service.AirportManagement;
import service.impl.IAirportManagement;

public class Main {
    public static void main(String[] args) {
        AirportManagement airportManagement = new IAirportManagement();
        airportManagement.management();
    }


}
