package util;

public class MenuUtil {
    private static MenuUtil instance;

    private MenuUtil() {

    }

    public static MenuUtil getInstance() {
        return instance == null
                ? instance = new MenuUtil() : instance;
    }

    public byte mainMenu() {
        System.out.println(
                "[0]-> exit \n" +
                        "[1]-> Admin \n" +
                        "[2]-> Customer \n");


        return InputUtil.getInstance().inputByte("enter the choice ");
    }

    public byte AdminMenu() {
        System.out.println("[0]-> Exit \n[1]-> Back \n[2]-> Add Flight \n[3]-> View Tickets \n[4]-> View Passengers \n[5]-> View Notice Board \n[6]-> View Flight \n[7]-> Search \n");
        return InputUtil.getInstance().inputByte("enter ");
    }

    public byte customerMenu() {
        System.out.println("[0]-> exit \n[1]-> Back \n[2]-> View Flights \n[3]-> Order ticket \n [4]-> Cancel ticket \n");
        return InputUtil.getInstance().inputByte("enter the option");
    }

    public byte flightsMenu() {
        System.out.println(
                "[1]-> Back \n" +
                        "[1]-> View Flights \n" +
                        "[2]-> Search Flights \n");


        return InputUtil.getInstance().inputByte("enter the choice ");
    }
}
