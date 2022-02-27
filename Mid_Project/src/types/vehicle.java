package types;

import java.util.ArrayList;

public abstract class vehicle {
	private String brand;
	private String name;
	private String licenseNumber;
	private String typeVehicle;
	private int topSpeed;
	private int gasCapacity;
	private int ID;
	
	private static ArrayList<String> brandData = new ArrayList<>();
	private static ArrayList<String> nameData = new ArrayList<>();
	private static ArrayList<String> licenseNumData = new ArrayList<>();
	private static ArrayList<String> typeVehicleData = new ArrayList<>();
	private static ArrayList<Integer> topSpeedData = new ArrayList<>();
	private static ArrayList<Integer> gasCapacityData = new ArrayList<>();
	private static ArrayList<Integer> IDData = new ArrayList<>();
	

	public vehicle(int ID, String brand, String name, String licenseNumber, String typeVehicle, int topSpeed, int gasCapacity) {
		this.brand = brand;
		this.name = name;
		this.licenseNumber = licenseNumber;
		this.typeVehicle = typeVehicle;
		this.topSpeed = topSpeed;
		this.gasCapacity = gasCapacity;
		this.ID = ID;
		
		//Ini untuk masukin data ke masing2 arraylist
		brandData.add(brand);
		nameData.add(name);
		licenseNumData.add(licenseNumber);
		typeVehicleData.add(typeVehicle);
		topSpeedData.add(topSpeed);
		gasCapacityData.add(gasCapacity);
		IDData.add(ID);
	}

	//Ini untuk manggil data dari masing2 arraylist
	public static String callBrand(int index) {
		return brandData.get(index);
	}
	
	public static String callName(int index) {
		return nameData.get(index);
	}
	
	public static String callLicense(int index) {
		return licenseNumData.get(index);
	}
	
	public static String callTypeVehicle(int index) {
		return typeVehicleData.get(index);
	}
	
	public static Integer callTopSpeed(int index) {
		return topSpeedData.get(index);
	}
	
	public static Integer callGasCapacity(int index) {
		return gasCapacityData.get(index);
	}
	
	public static Integer callIDPrimer(int index) {
		return IDData.get(index);
	}
}