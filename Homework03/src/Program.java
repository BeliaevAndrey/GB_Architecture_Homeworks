import service.Core;

public class Program {

    public static void main(String[] args) {

        Core core = new Core();

        core.buildHarvesters(5);
        core.buildSportCars(3);

        core.goCars();

        core.reportCars();



    }

}
