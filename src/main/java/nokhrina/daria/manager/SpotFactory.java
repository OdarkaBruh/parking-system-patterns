package nokhrina.daria.manager;

import nokhrina.daria.enums.ParkingSpotSize;
import nokhrina.daria.model.parkingLot.ParkingLevel;
import nokhrina.daria.model.parkingLot.spot.CompactSpot;
import nokhrina.daria.model.parkingLot.spot.LargeSpot;
import nokhrina.daria.model.parkingLot.spot.MotorcycleSpot;

import java.util.Random;

public class SpotFactory {
    private static final Random r = new Random();
    private final int truckSpotSizeInSpots = 6;

    private ParkingLevel level;
    public SpotFactory(ParkingLevel level) {
        this.level = level;
    }

    public void createRandomSpots(int numberOfSpots) {
        while (numberOfSpots != 0) {
            ParkingSpotSize spotSize = getRandomSpotSize();
            if (!spotSize.equals(ParkingSpotSize.TRUCK)) {
                addSingularSpot(spotSize);
                numberOfSpots--;
            } else if (numberOfSpots >= truckSpotSizeInSpots){
                addTruckSpot();
                numberOfSpots -= truckSpotSizeInSpots;
            }
            // if not enough space for a track spot => nothing.
        }
    }

    private ParkingSpotSize getRandomSpotSize() {
        int pick = new Random().nextInt(ParkingSpotSize.values().length);
        return ParkingSpotSize.values()[pick];
    }

    private void addSingularSpot(ParkingSpotSize spot) {
        level.addSpot(switch (spot) {
            case LARGE -> new LargeSpot(level);
            case COMPACT -> new CompactSpot(level);
            case MOTORCYCLE -> new MotorcycleSpot(level);
            case TRUCK -> throw new IllegalArgumentException("TruckSpot is not singular");
        });
    }

    private void addTruckSpot() {
        for (int i = 0; i < truckSpotSizeInSpots; i++) {
            level.addSpot(new LargeSpot(level));
        }
    }

    public int getRandomNumberOfSpots(int maxSpotsPerLevel, int minSpotsPerLevel) {
        return r.nextInt(minSpotsPerLevel, maxSpotsPerLevel);
    }
}
