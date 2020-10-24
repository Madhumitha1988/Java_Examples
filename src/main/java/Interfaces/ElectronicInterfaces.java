package Interfaces;

public interface ElectronicInterfaces {
	String LED = "led";

	int getElectricityUsage();

	default void printDesc() {
		System.out.println("Electronic description "+getDesc());
	}
	
	static boolean isEnergyEfficient() { 
		return true;
	}
	
	private String getDesc() {
		return "Awesome??";
	}

}
