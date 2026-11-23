package nokhrina.daria.model.vehicles;

import nokhrina.daria.model.parkingLot.spot.ParkingSpot;

public class Motorcycle extends Vehicle{
    public boolean canFit(ParkingSpot spot) {
        return true;
    }
}
