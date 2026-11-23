package nokhrina.daria.model.parkingLot;

import nokhrina.daria.manager.SpotFactory;
import nokhrina.daria.model.parkingLot.spot.ParkingSpot;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ParkingLevel {
    private static int levelCounter = 0;
    private SpotFactory spotFactory = new SpotFactory(this);

    int floor;
    ArrayList<ParkingSpot> parkingSpots = new ArrayList<>();

    ParkingLevel() {
        this.floor = levelCounter;
        levelCounter++;
    }

    void fill(int maxSpotsPerLevel, int minSpotsPerLevel) {
        spotFactory.createRandomSpots(spotFactory.getRandomNumberOfSpots(maxSpotsPerLevel, minSpotsPerLevel));
    }

    public void addSpot(ParkingSpot spot) {
        parkingSpots.add(spot);
    }

    public ArrayList<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    @Override
    public String toString() {
        return "\tParking level №" + floor + "  -  (" + parkingSpots.size() + ')'
                + parkingSpots.stream()
                .map(spot -> System.lineSeparator() + "\t\t" + spot)
                .collect(Collectors.joining());
    }

    public int getFloor() {
        return floor;
    }
}
