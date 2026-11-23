package nokhrina.daria.model.vehicles;

import nokhrina.daria.model.parkingLot.spot.ParkingSpot;

public abstract class Vehicle {
    int id;

    abstract public boolean canFit(ParkingSpot spot);
}
