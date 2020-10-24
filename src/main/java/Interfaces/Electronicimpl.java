package Interfaces;

public class Electronicimpl implements ElectronicInterfaces {

	@Override
	public int getElectricityUsage() {
		// TODO Auto-generated method stub
		return 20;
	}
	public static void main(String[] args) {
		Electronicimpl elc= new Electronicimpl();
		elc.printDesc();
		
		//System.out.println(elc);
	}
}
