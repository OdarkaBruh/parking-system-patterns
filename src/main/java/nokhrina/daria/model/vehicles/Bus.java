package nokhrina.daria.model.vehicles;

import nokhrina.daria.enums.ParkingSpotSize;
import nokhrina.daria.model.parkingLot.spot.ParkingSpot;

public class Bus extends Vehicle{
    public static final int SPOTS_NEEDED = 6;

    public boolean canFit(ParkingSpot spot) {
        return spot.getSize() == ParkingSpotSize.LARGE;
    }
}
