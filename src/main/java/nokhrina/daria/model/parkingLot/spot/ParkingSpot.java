package nokhrina.daria.model.parkingLot.spot;

import nokhrina.daria.enums.ParkingSpotSize;
import nokhrina.daria.model.parkingLot.ParkingLevel;
import nokhrina.daria.model.vehicles.Vehicle;

public class ParkingSpot {
    private final ParkingSpotSize size;
    private final ParkingLevel level;
    private final int slotNumber;

    private Vehicle parkedVehicle;

    ParkingSpot(ParkingLevel level, ParkingSpotSize size) {
        this.level = level;
        this.size = size;

        this.slotNumber = level.getParkingSpots().size();
    }

    public ParkingSpotSize getSize() {
        return size;
    }

    @Override
    public String toString() {
        return String.format("[%-2d]%-5d - %s", level.getFloor(), slotNumber, size);
    }

    public boolean isEmpty() {
        return parkedVehicle == null;
    }

    public void parkVehicle(Vehicle vehicle) {
        this.parkedVehicle = vehicle;
    }

    public void parkedVehicleLeft() {
        this.parkedVehicle = null;
    }
}
