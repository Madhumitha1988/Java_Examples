package enums;

enum Pizza_STATUS {
	ORDERED(5) {
		@Override
		public boolean isOrdered() {
			return true;
		}

	},
	READY(2), DELIVERED(0);

	private int time;

	Pizza_STATUS(int time) {
		this.time = time;
	}

	public boolean isOrdered() {
		return false;
	}

	public int getTime() {
		return time;
	}

}

public class Example_Enums {
	public static void main(String[] args) {
		Pizza_STATUS status = Pizza_STATUS.ORDERED;
		System.out.println("time --- " + status.getTime()); // 5
		System.out.println("status --- " + status.isOrdered()); //true
		
		Pizza_STATUS status1 = Pizza_STATUS.READY;
		System.out.println("time --- " + status1.getTime()); // 5
		System.out.println("status --- " + status1.isOrdered()); //true


	}
}
/*  time --- 5
status --- true
time --- 2
status --- false
*/