package Actions;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import leave_management_portal.data.*;

import module.*;

public class Lmp_Services extends RegEmployeData {

	public static int opt;
	public static String ra;
	public static Scanner scanner = new Scanner(System.in);
	public static int ide;
	static TreeMap<Integer, LeaveManagementPortal> tm = employeData(null);
	static TreeMap<Integer, LeaveStatus> ts = RegEmployeData.leavePageData(null);

	/***************************
	 * Home Page Services      *
	 ***************************/
	public static void home(TreeMap<Integer, LeaveManagementPortal> tm) {

		System.out.println("***************Welcom To Leave Management portal****************");
		System.out.println();
		System.out.println("Select any option below : ");
		System.out.println("1.login");
		System.out.println("2.Employe Registration");
		System.out.println("****************************************************************");

		try {

			opt = scanner.nextInt();

			// using switch case to pass selected option

			switch (opt) {
			case 1:
				// calling login() method
				login(tm);

				break;
			case 2:
				// calling registration() method

				registration();

				break;

			default:

				System.out.println("Enter a valied option :");

				break;

			}

		} catch (InputMismatchException ime) {

			// Handling InputMismatchException to avoid mismatch of opt variable data type

			System.out.println("\nPlease enter only Integer value");

		}

		catch (Exception e) {
			System.out.println(e);
		} finally {

			scanner.close();
		}
	}

	/***************************
	 * Login Services		   *
	 ***************************/
	// login() method
	public static void login(TreeMap<Integer, LeaveManagementPortal> tm) {

		// Creating log variable of type boolean

		boolean log = false;

		try {
			System.out.println("*****************Welcom To Leave Management portal Login Page *****************");
			System.out.println();
			System.out.println("Select any option below : ");
			System.out.println("1.Employee Login");
			System.out.println("2.Manager Login");
			System.out.println("3.Admin Login");
			System.out.println("4.Back to Home");
			System.out.println("******************************************************************************");

			opt = scanner.nextInt();

			// using switch case to pass option

			switch (opt) {
			case 1:

				/*
				 * calling eLogin() method which return true if username with password are
				 * present in employeData() method and false if user was not present
				 */

				log = eLogin(tm);

				if (log == true) {

					// calling employee() method

					employee(tm);

					System.out.println(
							"**********************************************************************************");

				}
				break;

			case 2:

				/*
				 * calling eLogin() method which return true if username with password are
				 * present in employeData() method and false if user was not present
				 */

				log = eLogin(tm);

				if (log == true) {

					// calling manager() method

					manager(tm);

					System.out.println(
							"***************************************************************************************");

				}
				break;

			case 3:
				/*
				 * calling eLogin() method which return true if username with password are
				 * present in employeData() method and false if user was not present
				 */
				log = eLogin(tm);

				if (log == true) {
					// calling adminInfo() method
					adminInfo(tm);

					System.out.println(
							"***************************************************************************************");
				}

				break;
			case 4:
				// back navigation calling home method
				home(tm);
				break;

			default:
				System.out.println("Enter a valied option :");
				break;

			}

		} catch (InputMismatchException ime) {

			// Handling InputMismatchException to avoid mismatch of opt variable data type

			System.out.println("\nPlease enter only Integer value");

		} catch (Exception e) {
			System.out.println(e);
		} finally {

			scanner.close();
		}

	}

	// eLogin() method
	public static boolean eLogin(TreeMap<Integer, LeaveManagementPortal> map) {

		try {
			System.out.println("Enter id :");

			// getting id from console

			ide = scanner.nextInt();

			System.out.println("Enter password :");

			// getting password from console

			String pas = scanner.next();

			// logic to differentiate employee from manager/admin

			LeaveManagementPortal l = map.get(ide);

			/*
			 * logic to differentiate manager/admin from employee other wise there is a
			 * chance for employee to acess Manager Home page
			 */
			if (l.getId() == ide && l.getPassword().equals(pas) && l.getDesig() != "manager"
					&& l.getDesig() != "admin") {

				return true;
			}

			else if (map.get(ide).getId() == ide && map.get(ide).getPassword() == pas
					&& map.get(ide).getDesig() == "manager" || map.get(ide).getDesig() == "admin") {

				return true;
			}

		} catch (InputMismatchException ime) {

			// Handling InputMismatchException to avoid mismatch of opt variable data type

			System.out.println("\nPlease enter only Integer value");

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			scanner.close();

		}
		return false;
	}

	/***************************
	 * Employee Services       *
	 ***************************/

	public static void employee(TreeMap<Integer, LeaveManagementPortal> tm) {

		System.out.println("**************** Welcom To Leave Management portal Employee blog Page *****************");
		System.out.println();
		System.out.println("Select any option below : ");
		System.out.println("1.Take Leave");
		System.out.println("2.Show Leave Status");
		System.out.println("3.Show Employee");
		System.out.println("***************************************************************************************");

		// using scanner to collect option

		opt = scanner.nextInt();

		// exceptional handling

		try {
			// passing opt to switch case

			switch (opt) {

			case 1:
				// calling takeLeaves method

				takeLeaves(tm);

				System.out.println(
						"***************************************************************************************");

				break;
			case 2:

				// calling showLeave method

				showLeavesStatus(tm);

				System.out.println(
						"***************************************************************************************");

				break;
			case 3:
				// calling showEmployee method

				showEmployees(tm);

				System.out.println(
						"***************************************************************************************");

				break;
			default:

				System.out.println("Enter a valied option :");

				break;

			}
		} catch (IllegalStateException ill) {
			// Handling IllegalStateException to avoid inappropriate time method invokation
			System.out.println(ill);
		} catch (InputMismatchException ime) {

			// Handling InputMismatchException to avoid mismatch of opt variable data type

			System.out.println("\nPlease enter only Integer value");

		} catch (Exception e) {
			System.out.println(e);
		}


	}

	/*
	 * takeLeaves method with parameters TreeMap<Integer, LeaveManagementPortal> map
	 * and no return type
	 */
	public static void takeLeaves(TreeMap<Integer, LeaveManagementPortal> map) {

		// exception handling

		try {
			System.out.println("Enter Id");

			// assigning id value using scanner

			ide = scanner.nextInt();

			System.out.println("Enter Number of Leaves You Want");
			// lev = total number of leave employee want to take
			int lev = scanner.nextInt();
			// getting and Assigning LeaveManagementPortal object from TreeMap Object map
			LeaveManagementPortal lmp = map.get(ide);
			/*
			 * logic to check id , leaves !=0 and totlal leaves > number of leaves employe
			 * want to take
			 */
			if (ide == lmp.getId() && lmp.getLeaves() != 0 && lmp.getLeaves() >= lev) {

				map.get(ide).setLeaves(map.get(ide).getLeaves() - lev);

				System.out.println("Total Leaves Avilable : " + lmp.getLeaves());

			} else if (lmp.getLeaves() == 0) {

				System.out.println("No Leaves... ");

			} else {
				System.out.println("Enter a Valid Id:");
			}
			/*
			 * Calling leavePageData method of RegEmployeData to save leave applied by
			 * employee
			 */
			RegEmployeData.leavePageData(
					new LeaveStatus(lmp.getId(), lmp.getName(), lmp.getLeaves(), "pending", lmp.getDesig()));

		} catch (InputMismatchException ime) {

			// Handling InputMismatchException to avoid mismatch of opt variable data type

			System.out.println("\nPlease enter only Integer value");
		} catch (NullPointerException e) {
			// Handling NullPointerException to avoid null entries
			System.out.println("No Leaves Requests are Avilable");
			System.out
					.println("***************************************************************************************");
			// calling doYouWantToContinue method
			doYouWantToContinue(map, "engineer");
		} catch (Exception e)

		{
			System.out.println(e);
		}

		finally

		{
			// calling doYouWantToContinue method

			doYouWantToContinue(map, "engineer");

		}

	}

	// showLeaves method

	public static void showLeavesStatus(TreeMap<Integer, LeaveManagementPortal> map2) {

		try {

			System.out.println("Enter Id");
			ide = scanner.nextInt();
			// calling leavePageData() and assigning return value to TreeMap reference ls
			TreeMap<Integer, LeaveStatus> ls = RegEmployeData.leavePageData(null);
			// getting object of LeaveStatus from TreeMap object withe key ide
			LeaveStatus l = ls.get(ide);
			System.out.println("Hi " + l.getName() + " Your Leave was : " + l.getStatus());
		} catch (InputMismatchException ime) {

			// Handling InputMismatchException to avoid mismatch of opt variable data type

			System.out.println("\nPlease enter only Integer value");
		} catch (NullPointerException e) {
			// Handling NullPointException
			System.out.println("No Leaves Requests are Avilable");
			System.out
					.println("***************************************************************************************");
			doYouWantToContinue(map2, "engineer");
		} catch (Exception e) {
			System.out.println(e);
		}

		finally {

			// calling doYouWantToContinue()

			doYouWantToContinue(map2, "engineer");

		}

	}

	// showEmployees method

	public static void showEmployees(TreeMap<Integer, LeaveManagementPortal> map3) {

		try {
			System.out.println("Enter Id");

			// creating local variable ide

			int ide = scanner.nextInt();

			/*
			 * using for loop to iterate among arraylist al to show details of employe
			 * matches with given id
			 */

			LeaveManagementPortal lmp = map3.get(ide);

			if (ide == lmp.getId()) {

				System.out.println(lmp);

			}

		} catch (InputMismatchException ime) {

			// Handling InputMismatchException to avoid mismatch of opt variable data type

			System.out.println("\nPlease enter only Integer value");
		} catch (NullPointerException e) {
			// Handling NullPointerException
			System.out.println("No Leaves Requests are Avilable");
			System.out
					.println("***************************************************************************************");
			doYouWantToContinue(RegEmployeData.employeData(null), "engineer");
		} catch (Exception e)

		{
			System.out.println(e);
		}

		finally {
			doYouWantToContinue(map3, "engineer");
		}

	}

	/*
	 * doYouWantToContinue method will handle employee, manager, admin back
	 * navigation based on the designation passed in the method signature
	 */

	public static void doYouWantToContinue(TreeMap<Integer, LeaveManagementPortal> tm, String desig) {

		try {

			System.out.println("Do you Want to continue (Y/N):");
			String choice = scanner.next();
			// System.out.println(choice);
			if (choice.equalsIgnoreCase("y")) {
				// using nested if to move back to respected Home Page
				if (desig == "manager") {
					// if designation = manager then it will call manager method of ManagerHome
					// class
					manager(tm);
				} else if (desig == "admin") {
					// if designation = admin then it will call adminInfo method of AdminHome
					// class
					adminInfo(tm);
				} else {
					employee(tm);// calling employee() method
				}

			} else {

				login(tm);// calling login method to go back
			}
		} catch (NullPointerException e) {
			// Handling NullPointerException
			System.out.println("No Leaves Requests are Avilable");
			System.out
					.println("***************************************************************************************");
			doYouWantToContinue(RegEmployeData.employeData(null), "engineer");
		} catch (InputMismatchException ime) {
			// Handling InputMismatchException
			System.out.println(ime);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			scanner.close();// closing scanner connection in finally block
		}

	}

	/*********************************
	 * Employee Registration Services* 
	 *********************************/
	
	// registration method
	public static void registration() {

		try {
			/*
			 * using scanner to assign vales to the variables
			 * id,name,address,design,ra,password
			 */
			System.out.println("Enter Employee Id : ");

			int id = scanner.nextInt();

			System.out.println("Enter Employee Name : ");

			String name = scanner.next();

			System.out.println("Enter Designation : ");

			String desig = scanner.next();

			// if designation is manager/admin then no need of ra

			if (desig.equals("manager") || desig.equals("admin")) {
				ra = "N/A";

			} else {
				System.out.println("Enter RA : ");

				ra = scanner.next();

			}

			// creating variable leaves with default total number of leaves =10

			int leaves = 10;

			System.out.println("Enter password : ");

			String password = scanner.next();

			/* using TreeMap to store employee details */

			// calling employeeData() to store employee details
			RegEmployeData.employeData(new LeaveManagementPortal(id, name, ra, desig, leaves, password));

			System.out.println("\nEmploye Registration Successfully");

		}

		catch (Exception e) {
			System.out.println(e);
		}

		finally {

			// navigating back to home page

			home(tm);

		}
	}
	
	
	/***************************
	 * Manager Services        *
	 ***************************/

	// manager method

	public static void manager(TreeMap<Integer, LeaveManagementPortal> tm) {

		System.out.println(
				"******************** Welcom To Leave Management portal Manager/Admin blog Page ***************");
		System.out.println();
		System.out.println("Select any option below : ");
		System.out.println("1.View Leave Request List");
		System.out.println("2.Show Employee");
		System.out.println("3.Take Leave");
		System.out.println("4.Show Leaves");
		System.out.println("***************************************************************************************");

		try {
			opt = scanner.nextInt();
			// passing option via switch

			switch (opt) {
			case 1:

				// calling leaveViewPage method
				leaveViewPage(ts);

				System.out.println(
						"***************************************************************************************");

				break;

			case 2:

				// calling showEmployees()

				showEmployees(tm);

				System.out.println(
						"***************************************************************************************");

				break;

			case 3:

				// calling takeLeaves()

				takeLeaves(tm);

				System.out.println(
						"***************************************************************************************");

				break;
			case 4:

				// calling showLeaves()
				showLeavesStatus(tm);
				System.out.println(
						"***************************************************************************************");

				break;
			default:

				System.out.println("Enter a valied option :");
				manager(tm);
				break;

			}
		} catch (Exception e) {
			System.out.println(e);
		}

		finally {
			System.out
					.println("***************************************************************************************");
		}

	}

	// leaveViewPage method
	public static void leaveViewPage(TreeMap<Integer, LeaveStatus> as) {

		try {

			Set<?> set = as.entrySet();

			// Get an iterator
			Iterator<?> it = set.iterator();

			System.out.println("List of Leave Requests Recived : ");
			System.out
					.println("***************************************************************************************");
			// Display elements
			while (it.hasNext()) {
				Map.Entry<Integer, LeaveStatus> me = (Map.Entry) it.next();
				// getting Value from me Object
				System.out.println(me.getValue());
				System.out.println(
						"***************************************************************************************");

			}

			System.out.println("Please Enter ID To Change Status:");

			opt = scanner.nextInt();

			System.out
					.println("***************************************************************************************");
			LeaveStatus leaveStatus = as.get(opt);

			System.out
					.println("***************************************************************************************");
			System.out.println("ID :" + leaveStatus.getId() + "  Status : " + leaveStatus.getStatus());

			System.out.println("Select any Action : ");

			System.out.println("1.Approve");

			System.out.println("2.Reject");

			opt = scanner.nextInt();

			if (opt == 1) {
				// setting status to Approve using setter method
				leaveStatus.setStatus("Approved");
			} else if (opt == 2) {
				// setting status to Reject using setter method
				leaveStatus.setStatus("Rejected");
			} else {
				System.out.println("plase enter valid choice");
			}

		} catch (NullPointerException e) {
			System.out.println("No Leaves Requests are Avilable");
			System.out
					.println("***************************************************************************************");
			doYouWantToContinue(RegEmployeData.employeData(null), "manager");
		} catch (Exception e) {
			System.out.println(e);
		} finally {

			doYouWantToContinue(RegEmployeData.employeData(null), "manager");
		}

	}

	/***************************
	 * Admin Services          *
	 ***************************/
	
	// calling adminInfo() method

	public static void adminInfo(TreeMap<Integer, LeaveManagementPortal> tm) {

		System.out.println(
				"******************** Welcom To Leave Management portal Manager/Admin blog Page ***************");

		System.out.println();

		System.out.println("Select any option below : ");

		System.out.println("1.View Leave Request List");

		System.out.println("2.Show Employee");

		System.out.println("***************************************************************************************");

		int opt = scanner.nextInt();

		System.out.println("***************************************************************************************");

		try {

			// passing option via switch

			switch (opt) {
			case 1:

				TreeMap<Integer, LeaveStatus> as = leavePageData(null);

				// calling leaveViewPage

				leaveViewPage(as);

				System.out.println(
						"***************************************************************************************");

				break;

			case 2:

				// calling showEmployees()

				showEmployees(tm);

				System.out.println(
						"***************************************************************************************");

				break;

			default:

				System.out.println("Enter a valied option :");

				System.out.println(
						"***************************************************************************************");

				break;

			}
		} catch (InputMismatchException ime) {

			// Handling InputMismatchException to avoid mismatch of opt variable data type

			System.out.println("\nPlease enter only Integer value");
		} catch (Exception e) {
			System.out.println(e);
		}

		finally {
			// calling doYouWantToContinue()

			doYouWantToContinue(tm, "admin");

			System.out
					.println("***************************************************************************************");

		}
	}
}
