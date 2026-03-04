import java.util.*;

class ParkingSpot {
    String licensePlate;
    long entryTime;

    ParkingSpot(String licensePlate) {
        this.licensePlate = licensePlate;
        this.entryTime = System.currentTimeMillis();
    }
}

public class ParkingLotManager {

    private ParkingSpot[] parkingTable;
    private int size;

    public ParkingLotManager(int capacity) {
        parkingTable = new ParkingSpot[capacity];
        size = capacity;
    }

    // Hash function
    private int hash(String plate) {
        return Math.abs(plate.hashCode()) % size;
    }

    // Park vehicle
    public int parkVehicle(String plate) {

        int index = hash(plate);
        int probes = 0;

        while (parkingTable[index] != null) {
            index = (index + 1) % size; // Linear probing
            probes++;
        }

        parkingTable[index] = new ParkingSpot(plate);

        System.out.println("Vehicle " + plate +
                " parked at spot #" + index +
                " (" + probes + " probes)");

        return index;
    }

    // Exit vehicle
    public void exitVehicle(String plate) {

        for (int i = 0; i < size; i++) {

            if (parkingTable[i] != null &&
                    parkingTable[i].licensePlate.equals(plate)) {

                long duration = (System.currentTimeMillis()
                        - parkingTable[i].entryTime) / 1000;

                parkingTable[i] = null;

                System.out.println("Vehicle " + plate +
                        " exited from spot #" + i +
                        " Duration: " + duration + " seconds");

                return;
            }
        }

        System.out.println("Vehicle not found.");
    }

    public static void main(String[] args) {

        ParkingLotManager lot = new ParkingLotManager(10);

        lot.parkVehicle("ABC-1234");
        lot.parkVehicle("ABC-1235");
        lot.parkVehicle("XYZ-9999");

        lot.exitVehicle("ABC-1234");
    }
}