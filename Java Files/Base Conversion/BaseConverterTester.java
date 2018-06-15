import java.util.*;

public class BaseConverterTester extends BaseConverter {

	public static void main(String[] args) {
		BaseConverter basic = new BaseConverter();
		Scanner scan = new Scanner(System.in);
		String str;
		System.out.println("Please enter the base of the number you	would like to convert from.");
		basic.setBaseFrom(scan.nextInt());
		System.out.println("Please enter the base you would like to convert into.");
		basic.setBaseTo(scan.nextInt());
		scan.nextLine();
		System.out.println("Please enter the number in the base you would like to convert from.");
		basic.setOriginal(scan.nextLine());
		basic.setnInt(basic.toBase10(basic.getOriginal(), basic.getBaseFrom()));
		basic.fromBase10(basic.getnInt(), basic.getBaseTo());
		scan.close();
	}

}
