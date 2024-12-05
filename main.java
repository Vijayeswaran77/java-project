import java.util.Scanner;
class ParkingSpot {
 int spotId;
 boolean isOccupied;
 String vehicleNumber;
 public ParkingSpot(int spotId) {
 this.spotId = spotId;
 this.isOccupied = false;
 this.vehicleNumber = "";
 }
 public void parkCar(String vehicleNumber) {
 this.isOccupied = true;
 this.vehicleNumber = vehicleNumber;
 }
 public void removeCar() {
 this.isOccupied = false;
 this.vehicleNumber = "";
 }
 public String getStatus() {
 return isOccupied ? "Occupied by " + vehicleNumber : "Available";
 }
}
class ParkingLot {
 ParkingSpot[] spots;
 int totalSpots;
 public ParkingLot(int totalSpots) {
 this.totalSpots = totalSpots;
 this.spots = new ParkingSpot[totalSpots];
 for (int i = 0; i < totalSpots; i++) {
 spots[i] = new ParkingSpot(i + 1); // Parking spots numbered from 1
 }
 }
 public boolean parkCar(String vehicleNumber) {
 for (ParkingSpot spot : spots) {
 if (!spot.isOccupied) {
 spot.parkCar(vehicleNumber);
 System.out.println("Car parked at spot " + spot.spotId);
 return true;
 }
 }
11
 System.out.println("No available parking spots.");
 return false;
 }
 public boolean removeCar(String vehicleNumber) {
 for (ParkingSpot spot : spots) {
 if (spot.isOccupied && spot.vehicleNumber.equals(vehicleNumber)) {
 spot.removeCar();
 System.out.println("Car with number " + vehicleNumber + " removed from spot " + spot.spotId);
 return true;
 }
 }
 System.out.println("Car not found.");
 return false;
 }
 public void displayParkingLotStatus() {
 System.out.println("\nParking Lot Status:");
 for (ParkingSpot spot : spots) {
 System.out.println("Spot " + spot.spotId + ": " + spot.getStatus());
 }
 }
 public void calculateParkingFee(String vehicleNumber, int hoursParked) {
 final double RATE_PER_HOUR = 5.0; // Charge rate per hour
 double totalFee = hoursParked * RATE_PER_HOUR;
 System.out.println("Parking fee for vehicle " + vehicleNumber + ": $" + totalFee);
 }
}
public class Main {
 public static void main(String[] args) {
 Scanner scanner = new Scanner(System.in);
 ParkingLot parkingLot = new ParkingLot(10); // Create a parking lot with 10 spots
 while (true) {
 System.out.println("\n--- Smart Parking System ---");
 System.out.println("1. Park Car");
 System.out.println("2. Remove Car");
 System.out.println("3. Display Parking Lot Status");
 System.out.println("4. Calculate Parking Fee");
 System.out.println("5. Exit");
 System.out.print("Choose an option: ");
 
 int choice = scanner.nextInt();
 scanner.nextLine(); // Consume newline
 switch (choice) {
 case 1:
 System.out.print("Enter vehicle number to park: ");
12
 String vehicleNumber = scanner.nextLine();
 parkingLot.parkCar(vehicleNumber);
 break;
 case 2:
 System.out.print("Enter vehicle number to remove: ");
 vehicleNumber = scanner.nextLine();
 parkingLot.removeCar(vehicleNumber);
 break;
 case 3:
 parkingLot.displayParkingLotStatus();
 break;
 case 4:
 System.out.print("Enter vehicle number: ");
 vehicleNumber = scanner.nextLine();
 
 System.out.print("Enter number of hours parked: ");
 int hoursParked = scanner.nextInt();
 parkingLot.calculateParkingFee(vehicleNumber, hoursParked);
 break;
 case 5:
 System.out.println("Exiting Smart Parking System.");
 scanner.close();
 return;
 default:
 System.out.println("Invalid option, please try again.");
 }
 }
 }
}
