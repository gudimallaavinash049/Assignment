package leave_management_portal.data;
import java.util.TreeMap;
import module.*;
public class RegEmployeData {
	/* Creating object of TreeMap to Handle Employee Data */
	static TreeMap<Integer, LeaveManagementPortal> al = new TreeMap<Integer, LeaveManagementPortal>();

	/* Creating object of TreeMap to Handle Leave Status */

	static TreeMap<Integer, LeaveStatus> a = new TreeMap<Integer, LeaveStatus>();

	/*
	 * using employeData() to register employee Details and to fetch employee
	 * Details
	 */
	public static TreeMap<Integer, LeaveManagementPortal> employeData(LeaveManagementPortal lmp) {
		/*
		 * logic to avoid null value entry and TreeMap with Id as Key and
		 * LeaveManagementPortal Object as Value
		 */
		if (lmp != null) {
			al.put(lmp.getId(), lmp);
		}

		return al;

	}

	/*
	 * Creating method leavePageData() to handle LeaveStatus
	 * 
	 */

	public static TreeMap<Integer, LeaveStatus> leavePageData(LeaveStatus l) {
		/*
		 * logic to avoid null value entry and TreeMap with Id as Key and LeaveStatus
		 * Object as Value
		 */
		if (l != null) {
			a.put(l.getId(), l);
		}
	

		return a;

	}

}
