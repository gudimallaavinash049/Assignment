package leave_management_portal.main;
import java.util.Scanner;
import Actions.Lmp_Services;
import leave_management_portal.data.RegEmployeData;


public class HomePage extends RegEmployeData {
	public static int opt;
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		Lmp_Services service = new Lmp_Services();
		service.home(RegEmployeData.employeData(null));

	}

	

}
