package nokhrina.daria.model.parkingLot.spot;

import nokhrina.daria.enums.ParkingSpotSize;
import nokhrina.daria.model.parkingLot.ParkingLevel;

public class LargeSpot extends ParkingSpot{
    private int counter = 0;
    public LargeSpot(ParkingLevel level) {
        super(level, ParkingSpotSize.LARGE);
    }

}
