import java.util.Iterator;
import java.util.Scanner;
import java.util.function.ObjDoubleConsumer;

import javax.management.loading.PrivateClassLoader;

import types.cars;
import types.motorcycles;
import types.vehicle;

public class main {
	private static int totalVehicle = 0;
	private static int totalCars = 0;
	private static int totalMotors = 0;
	
	public static void main(String[] args) {
		pickingOptions();
	}
	
	private static void pickingOptions( ) {
		while (true) {
			System.out.println("==========================================");
			System.out.println("Welcome To PT Musang!");
			System.out.println("Please input one of the following options");
			System.out.println("==========================================");
			System.out.println("1. Input");
			System.out.println("2. View");
			System.out.println("3. Exit");
			
			int option;
			do {
				System.out.printf(">> ");
				Scanner input = new Scanner(System.in);
				option = input.nextInt();
			} while (option < 1 || option > 3);
			
			switch (option) {
				case 1:
					inputMain();
					break;
				case 2:
					viewData();
					break;
				case 3:
					System.out.println("Thank you for using our facility! :)");
					return;
			}
		}
	}
	
	private static void viewData() {
		int option, secondaryOption = 0;
		Scanner input = new Scanner(System.in);
		
		System.out.println("|-------|---------------|-----------------------|");
		System.out.println("|No\t|Type\t\t|Name\t\t\t|");
		System.out.println("|-------|---------------|-----------------------|");
		if (totalVehicle == 0) {
			System.out.println("|\t|\t\t|\t\t\t|");
			System.out.println("|-------|---------------|-----------------------|");
		} else {
			for (int i = 0; i < totalVehicle; i++) {
				System.out.print("|" + (i+1) + "\t|" + vehicle.callTypeVehicle(i));
				if (vehicle.callTypeVehicle(i).equals("Car")) {
					System.out.println("\t\t|" + vehicle.callName(i) + "\t\t\t|");
				} else {
					System.out.println("\t|" + vehicle.callName(i) + "\t\t\t|");
				}
				System.out.println("|-------|---------------|-----------------------|");
			}
			System.out.println("|-------|---------------|-----------------------|");
			
			System.out.print("Pick a vehicle number to test drive[Enter '0' to exit]: ");
			option = input.nextInt();
			if (option != 0) {
				int count = 0;
				option = option - 1;
				if(vehicle.callTypeVehicle(option).equals("Car")) {
					for (int j = 0; j < totalCars; j++) {
						if (vehicle.callIDPrimer(option).equals(cars.callIDSekunder(j))) {
							secondaryOption = count;
							printMobil(option, secondaryOption);
						}
						count++;
					}
				} else {
					for (int j = 0; j < totalMotors; j++) {
						if (vehicle.callIDPrimer(option).equals(motorcycles.callIDSekunder(j))) {
							secondaryOption = count;
							printMotor(option, secondaryOption);
						}
						count++;
					}
				}
			}
		}
	}
	
	private static void printMobil(int index, int indexCar) {
		System.out.println("Brand: " + cars.callBrand(index));
		System.out.println("Name: " + cars.callName(index));
		System.out.println("License Plate: " + cars.callLicense(index));
		System.out.println("Type: " + cars.callTypeCar(indexCar));
		System.out.println("Gas Capacity: " + cars.callGasCapacity(index));
		System.out.println("Top Speed: " + cars.callTopSpeed(index));
		System.out.println("Wheel(s): " + cars.callWheelCar(indexCar));
		System.out.println("Entertainment System: " + cars.callEnterSystem(indexCar));
		System.out.println("Turning on entertainment system...");
		
		if (cars.callTypeCar(indexCar).equals("Supercar")) {
			System.out.println("Boosting!\n");
		}
	}
	
	private static void printMotor(int index, int indexMotor) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Brand: " + motorcycles.callBrand(index));
		System.out.println("Name: " + motorcycles.callName(index));
		System.out.println("License Plate: " + motorcycles.callLicense(index));
		System.out.println("Type: " + motorcycles.callTypeMotor(indexMotor));
		System.out.println("Gas Capacity: " + motorcycles.callGasCapacity(index));
		System.out.println("Top Speed: " + motorcycles.callTopSpeed(index));
		System.out.println("Wheel(s): " + motorcycles.callWheelMotor(indexMotor));
		System.out.println("Helm: " + motorcycles.callHelm(indexMotor));
		System.out.println(motorcycles.callName(index) + " is standing!\n");
		
		int price;
		System.out.print("Input price: Rp");
		price = Integer.parseInt(input.nextLine());
		System.out.println("Price: Rp" + (price * motorcycles.callHelm(indexMotor)) + "\n");
	}
	
	private static void inputMain() {
		Scanner input = new Scanner(System.in);
		
		String type;
		String brand;
		String name;
		String license;
		int topSpeed;
		int gasCapacity;
		int countNum = 0;
		boolean checkLicense = false;
		
		
		do {
			System.out.print("Input type [Car | Motorcycle]: ");
			type = input.nextLine();
		} while (!type.equals("Car") && !type.equals("Motorcycle"));
		
		do {
			System.out.print("Input brand [>= 5]: ");
			brand = input.nextLine();
		} while (brand.length() < 5);
		
		do {
			System.out.print("Input name [>= 5]: ");
			name = input.nextLine();
		} while (name.length() < 5);
		
		do {
			System.out.print("Input license: ");
			license = input.nextLine();
			
			if (license.length() >= 8 && license.length() <= 10) {
				for (int i = 2; i < 5; i++) {
					if ((license.charAt(i) - '0') >= 0 && (license.charAt(i) - '0') <= 9) {
						countNum++;
					}
				}
				if (license.charAt(0) >= 'A' && license.charAt(0) <= 'Z') {
					int countNum2 = 0;
					if (license.charAt(1) == ' ' && license.charAt(6) == ' ') {
						for (int i = 7; i < license.length(); i++) {
							if (license.charAt(i) >= 'A' && license.charAt(i) <= 'Z') {
								countNum2++;
							}
						}
						if (countNum2 == (license.length() - 7)) {
							checkLicense = true;
						}
					}
				}
			}
		} while (checkLicense == false);
		
		do {
			System.out.print("Input top speed [100 <= topspeed <= 250]: ");
			topSpeed = Integer.parseInt(input.nextLine());
		} while (topSpeed < 100 || topSpeed > 250);
		
		do {
			System.out.print("Input gas capacity [30 <= gascap <= 60]: ");
			gasCapacity = Integer.parseInt(input.nextLine());
		} while (gasCapacity < 30 || gasCapacity > 60);
		
		
		if (type.equals("Car")) {
			inputCar(type, brand, name, license, topSpeed, gasCapacity);
		} else {
			inputMotor(type, brand, name, license, topSpeed, gasCapacity);
		}
	}
	
	private static void inputCar(String type, String brand, String name, String license, int topSpeed, int gasCapacity) {
		Scanner input = new Scanner(System.in);
		
		int carWheel;
		String typeCar;
		int enterSystem;
		String enter;
		
		
		do {
			System.out.print("Input wheel [4 <= wheel <= 6]: ");
			carWheel = Integer.parseInt(input.nextLine());
		} while (carWheel < 4 || carWheel > 6);
		
		do {
			System.out.print("Input type [SUV | Supercar | Minivan]: ");
			typeCar = input.nextLine();
		} while (!typeCar.equals("SUV") && !typeCar.equals("Supercar") && !typeCar.equals("Minivan"));
		
		do {
			System.out.print("Input entertainment system amount [>= 1]: ");
			enterSystem = Integer.parseInt(input.nextLine());
		} while (enterSystem < 1);
		
		
		do {
			System.out.print("ENTER to return");
			enter = input.nextLine();
		} while (enter != "");
		
		cars Car = new cars(totalVehicle, carWheel, enterSystem, typeCar, totalVehicle, brand, name, license, type, topSpeed, gasCapacity);
		totalVehicle++;
		totalCars++;
	}
	
	private static void inputMotor(String type, String brand, String name, String license, int topSpeed, int gasCapacity) {
		Scanner input = new Scanner(System.in);
		
		int motorWheel;
		String typeMotor;
		int helm;
		String enter;
		

		do {
			System.out.print("Input wheel [2 <= wheel <= 3]: ");
			motorWheel = Integer.parseInt(input.nextLine());
		} while (motorWheel < 2 || motorWheel > 3);
		
		do {
			System.out.print("Input type [Automatic | Manual]: ");
			typeMotor = input.nextLine();
		} while (!typeMotor.equals("Automatic") && !typeMotor.equals("Manual"));
		
		do {
			System.out.print("Input helm amount [>= 1]: ");
			helm = Integer.parseInt(input.nextLine());
		} while (helm < 1);
		
		
		do {
			System.out.print("ENTER to return");
			enter = input.nextLine();
		} while (enter != "");
		
		motorcycles Motor = new motorcycles(totalVehicle, motorWheel, typeMotor, helm, totalVehicle, brand, name, license, type, topSpeed, gasCapacity);
		totalVehicle++;
		totalMotors++;
	}

}