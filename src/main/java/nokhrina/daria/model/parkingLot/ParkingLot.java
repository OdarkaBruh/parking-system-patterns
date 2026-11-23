package nokhrina.daria.model.parkingLot;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ParkingLot {
    private static final int MAX_SPOTS_PER_LEVEL = 30;
    private static final int MIN_SPOTS_PER_LEVEL = 6;

    Set<ParkingLevel> parkingLevels = new LinkedHashSet<>();

    public void createLevels(int number) {
        while (number != 0) {
            parkingLevels.add(new ParkingLevel());
            number--;
        }
    }

    public void fillLevelsWithSpots() {
        for (ParkingLevel level : parkingLevels) {
            level.fill(MAX_SPOTS_PER_LEVEL, MIN_SPOTS_PER_LEVEL);
        }
    }

    @Override
    public String toString() {
            return "Parking lot: {" + System.lineSeparator()
                    + parkingLevels.stream()
                    .map(ParkingLevel::toString)
                    .collect(Collectors.joining(System.lineSeparator()))+"\n}";
    }

    public Set<ParkingLevel> getParkingLevels() {
        return parkingLevels;
    }
}
