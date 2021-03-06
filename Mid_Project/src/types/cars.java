package types;

import java.util.ArrayList;

public class cars extends vehicle {
	private int wheelCar;
	private int enterSystem;
	private String typeCar;
	private int IDSekunder;
	
	private static ArrayList<Integer> wheelCarData = new ArrayList<>();
	private static ArrayList<Integer> enterSystemData = new ArrayList<>();
	private static ArrayList<Integer> IDSekunderData = new ArrayList<>();
	private static ArrayList<String> typeCarData = new ArrayList<>();
	
	
	public cars(int IDSekunder, int wheelCar, int enterSystem, String typeCar, int ID, String brand, String name, 
			String licenseNumber, String typeVehicle, int topSpeed, int gasCapacity) {
		super(ID, brand, name, licenseNumber, typeVehicle, topSpeed, gasCapacity);
		this.wheelCar = wheelCar;
		this.enterSystem = enterSystem;
		this.typeCar = typeCar;
		this.IDSekunder = IDSekunder;
		
		wheelCarData.add(wheelCar);
		enterSystemData.add(enterSystem);
		typeCarData.add(typeCar);
		IDSekunderData.add(IDSekunder);
	}
	
	public static Integer callWheelCar(int index) {
		return wheelCarData.get(index);
	}
	
	public static Integer callEnterSystem(int index) {
		return enterSystemData.get(index);
	}
	
	public static String callTypeCar(int index) {
		return typeCarData.get(index);
	}
	
	public static Integer callIDSekunder(int index) {
		return IDSekunderData.get(index);
	}
	
}