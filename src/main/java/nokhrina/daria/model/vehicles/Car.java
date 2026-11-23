package nokhrina.daria.model.vehicles;

import nokhrina.daria.enums.ParkingSpotSize;
import nokhrina.daria.model.parkingLot.spot.ParkingSpot;

public class Car extends Vehicle{
    public boolean canFit(ParkingSpot spot) {
        return spot.getSize() == ParkingSpotSize.LARGE || spot.getSize() == ParkingSpotSize.COMPACT;
    }
}
