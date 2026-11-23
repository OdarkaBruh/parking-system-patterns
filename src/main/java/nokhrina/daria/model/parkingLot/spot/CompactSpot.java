package nokhrina.daria.model.parkingLot.spot;

import nokhrina.daria.enums.ParkingSpotSize;
import nokhrina.daria.model.parkingLot.ParkingLevel;

public class CompactSpot extends ParkingSpot{
    public CompactSpot(ParkingLevel level) {
        super(level, ParkingSpotSize.COMPACT);
    }
}
