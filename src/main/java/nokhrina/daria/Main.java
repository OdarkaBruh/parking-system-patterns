package nokhrina.daria;

import nokhrina.daria.manager.ParkingManager;
import nokhrina.daria.model.parkingLot.ParkingLot;
import nokhrina.daria.model.vehicles.Bus;
import nokhrina.daria.model.vehicles.Car;
import nokhrina.daria.model.vehicles.Vehicle;


public class Main {
    public static void main(String[] args) {
        ParkingLot mainLot = new ParkingLot();
        mainLot.createLevels(3);
        mainLot.fillLevelsWithSpots();
        System.out.println(mainLot);

        ParkingManager parkingManager = new ParkingManager(mainLot);

        parkingManager.parkVehicle(new Bus());
        parkingManager.parkVehicle(new Car());

        Vehicle bus = new Bus();
        parkingManager.parkVehicle(bus);
    }
}