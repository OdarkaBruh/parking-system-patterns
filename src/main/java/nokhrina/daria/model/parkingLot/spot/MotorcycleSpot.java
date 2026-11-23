package nokhrina.daria.model.parkingLot.spot;

import nokhrina.daria.enums.ParkingSpotSize;
import nokhrina.daria.model.parkingLot.ParkingLevel;

public class MotorcycleSpot extends ParkingSpot{
    public MotorcycleSpot(ParkingLevel level) {
        super(level, ParkingSpotSize.MOTORCYCLE);
    }
}
