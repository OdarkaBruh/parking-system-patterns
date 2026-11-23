package nokhrina.daria.manager;

import nokhrina.daria.model.parkingLot.ParkingLevel;
import nokhrina.daria.model.parkingLot.ParkingLot;
import nokhrina.daria.model.parkingLot.spot.ParkingSpot;
import nokhrina.daria.model.vehicles.Bus;
import nokhrina.daria.model.vehicles.Vehicle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Set;

public class ParkingManager {
    private final Logger logger = LogManager.getLogger(ParkingManager.class);
    private final ParkingLot lot;

    public ParkingManager(ParkingLot lot) {
        this.lot  = lot;
    }

    public void parkVehicle(Vehicle vehicle) {
        if (vehicle.getClass().equals(Bus.class)) parkMultipleSpot(vehicle);
        else parkSingularSpot(vehicle);
    }

    private void parkSingularSpot(Vehicle vehicle) {
        logger.info ("Parking vehicle " + vehicle + "to single spot.");
        ParkingSpot spot = findEmptySpot(vehicle, 1);
    }

    private ParkingSpot findEmptySpot(Vehicle vehicle, int neededSpotsInARow) {
        Set<ParkingLevel> levels = lot.getParkingLevels();
        for (ParkingLevel level: levels) {
            int spotsFound = 0;
            for (ParkingSpot spot: level.getParkingSpots()) {
                if (spot.isEmpty() && vehicle.canFit(spot)) {
                    spotsFound++;
                    if (neededSpotsInARow == spotsFound) return spot;
                }
                else spotsFound = 0;
            }
        }
        throw new RuntimeException("no empty spots");
    }

    private void parkMultipleSpot(Vehicle vehicle) {
        //TODO: INTO ONE METHOD
        //TODO: TICKET WITH SET<SPOTS> SPOTS OCCUPIED + MAKE findEmptySpot RETURN SET, NOT SINGLE OBJ
        logger.info ("Parking vehicle " + vehicle + "to multiple spot.");
        ParkingSpot spot = findEmptySpot(vehicle, Bus.SPOTS_NEEDED);
    }
}
