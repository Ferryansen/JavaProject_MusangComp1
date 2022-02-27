package types;

import java.util.ArrayList;

public class motorcycles extends vehicle {
	private int wheelMotor;
	private String typeMotor;
	private int helm;
	private int IDSekunder;
	
	private static ArrayList<Integer> wheelMotorData = new ArrayList<>();
	private static ArrayList<Integer> helmData = new ArrayList<>();
	private static ArrayList<String> typeMotorData = new ArrayList<>();
	private static ArrayList<Integer> IDSekunderData = new ArrayList<>();
	
	public motorcycles(int IDSekunder, int wheelMotor, String typeMotor, int helm, int ID, String brand, String name, String licenseNumber, String typeVehicle, int topSpeed, int gasCapacity) {
		super(ID, brand, name, licenseNumber, typeVehicle, topSpeed, gasCapacity);
		
		this.wheelMotor = wheelMotor;
		this.typeMotor = typeMotor;
		this.helm = helm;
		this.IDSekunder = IDSekunder;
		
		wheelMotorData.add(wheelMotor);
		typeMotorData.add(typeMotor);
		helmData.add(helm);
		IDSekunderData.add(IDSekunder);
	}
	
	public static Integer callWheelMotor(int index) {
		return wheelMotorData.get(index);
	}
	
	public static Integer callHelm(int index) {
		return helmData.get(index);
	}
	
	public static String callTypeMotor(int index) {
		return typeMotorData.get(index);
	}
	
	public static Integer callIDSekunder(int index) {
		return IDSekunderData.get(index);
	}
	
}
